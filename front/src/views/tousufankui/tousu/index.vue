<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" v-show="showSearch" :inline="true" label-width="68px">
      <el-form-item label="标题" prop="tousuTitle">
        <el-input
            v-model="queryParams.tousuTitle"
            placeholder="请输入标题"
            clearable
            style="width: 240px"
            @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="处理状态" prop="tousuState">
        <el-select
            v-model="queryParams.tousuState"
            placeholder="请输入处理状态"
            clearable
            style="width: 240px"
        >
          <el-option
              v-for="dict in tousu_state_choose"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="创建时间" style="width: 308px">
        <el-date-picker
            v-model="dateRange"
            value-format="YYYY-MM-DD"
            type="daterange"
            range-separator="-"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
            type="primary"
            plain
            icon="Plus"
            @click="handleAdd"
        >申请投诉</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="success"
            plain
            icon="Edit"
            :disabled="single"
            @click="handleUpdate"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="danger"
            plain
            icon="Delete"
            :disabled="multiple"
            @click="handleDelete"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="warning"
            plain
            icon="Download"
            @click="handleExport"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 表格数据 -->
    <el-table v-loading="loading" :data="tousuList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="标题" prop="tousuTitle" width="120" />
      <el-table-column label="类型" prop="tousuType" :show-overflow-tooltip="true" width="150" />
      <el-table-column label="状态" prop="tousuState" :show-overflow-tooltip="true" width="150" />
      <el-table-column label="创建人" prop="createBy" :show-overflow-tooltip="true" width="150" />
      <el-table-column label="创建时间" align="center" prop="tousuCreatetime" width="200">
        <template #default="scope">
          <span>{{ parseTime(scope.row.tousuCreatetime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="投诉内容" prop="tousuMain" :show-overflow-tooltip="true" width="500" align="center"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-tooltip content="修改" placement="top">
            <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)"></el-button>
          </el-tooltip>
          <el-tooltip content="删除" placement="top">
            <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"></el-button>
          </el-tooltip>
          <el-tooltip content="回复" placement="top">
            <el-button link type="primary" icon="Message" @click="handleReply(scope.row)"></el-button>
          </el-tooltip>
        </template>
      </el-table-column>
    </el-table>

    <pagination
        v-show="total > 0"
        :total="total"
        v-model:page="queryParams.pageNum"
        v-model:limit="queryParams.pageSize"
        @pagination="getList"
    />

    <!-- 新增或修改投诉配置对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="tousuRef" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="投诉标题" prop="tousuTitle">
          <el-input v-model="form.tousuTitle" placeholder="请输入投诉标题" />
        </el-form-item>
        <el-form-item label="投诉状态" prop="tousuState">
          <el-select
              v-model="form.tousuState"
              placeholder="请输入处理状态"
              clearable
              style="width: 180px"
          >
            <el-option
                v-for="dict in tousu_state_choose"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="投诉类型" prop="tousuType">
          <el-select
              v-model="form.tousuType"
              placeholder="请输入投诉类型"
              prop="tousuType"
              clearable
              style="width: 180px"
          >
            <el-option
                v-for="dict in tousu_type_choose"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="投诉描述" prop="tousuMain">
          <el-input v-model="form.tousuMain" type="textarea" placeholder="请输入内容" :rows="10"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>

    <!-- 回复配置对话框 -->
    <el-dialog :title="title" v-model="openReply" width="500px" append-to-body>
      <el-form ref="tousuRef" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="投诉标题" prop="tousuTitle">
          <el-input v-model="form.tousuTitle" placeholder="请输入投诉标题" />
        </el-form-item>
        <el-form-item label="投诉状态" prop="tousuState">
          <el-select
              v-model="form.tousuState"
              placeholder="请输入处理状态"
              clearable
              style="width: 180px"
          >
            <el-option
                v-for="dict in tousu_state_choose"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="投诉类型" prop="tousuType">
          <el-select
              v-model="form.tousuType"
              placeholder="请输入投诉类型"
              prop="tousuType"
              clearable
              style="width: 180px"
          >
            <el-option
                v-for="dict in tousu_type_choose"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="投诉描述" prop="tousuMain">
          <el-input v-model="form.tousuMain" type="textarea" placeholder="请输入内容" :rows="10"></el-input>
        </el-form-item>
        <el-form-item label="投诉回复" prop="tousuReply">
          <el-input v-model="form.tousuReply" type="textarea" placeholder="请输入内容" :rows="10"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>

  </div>
</template>

<script setup name="Tousu">
import { changeRoleStatus, dataScope, getRole, deptTreeSelect } from "@/api/system/role";
import { listTousu,updateTousu,addTousu,delTousu,getTousuBytousuId } from "@/api/tousu/tousu";
import { roleMenuTreeselect, treeselect as menuTreeselect } from "@/api/system/menu";

const router = useRouter();
const { proxy } = getCurrentInstance();
const tousuStateDict = {
  待回复: '待回复',
  待处理: '待处理',
  结束: '结束'
};
const tousuTypeDict = {
  系统投诉: '系统投诉',
  自习室投诉: '自习室投诉',
  其他投诉: '其他投诉'
};
// const { sys_normal_disable } = proxy.useDict(tousuStateDict);
const tousu_state_choose = Object.entries(tousuStateDict).map(([value, label]) => ({ value, label }));
const tousu_type_choose = Object.entries(tousuTypeDict).map(([value, label]) => ({ value, label }));

const tousuList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref([]);
const dateRange = ref([]);
const menuOptions = ref([]);
const menuExpand = ref(false);
const menuNodeAll = ref(false);
const deptExpand = ref(true);
const deptNodeAll = ref(false);
const deptOptions = ref([]);
const openDataScope = ref(false);
const openReply= ref(false);
const menuRef = ref(null);
const deptRef = ref(null);

/** 数据范围选项*/
const dataScopeOptions = ref([
  { value: "1", label: "全部数据权限" },
  { value: "2", label: "自定数据权限" },
  { value: "3", label: "本部门数据权限" },
  { value: "4", label: "本部门及以下数据权限" },
  { value: "5", label: "仅本人数据权限" }
]);

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    tousuTitle: undefined,
    tousuType: undefined,
    tousuMain: undefined,
    tousuReply: undefined
  },
  rules: {
    tousuTitle: [{ required: true, message: "标题不能为空", trigger: "blur" }],
    tousuType: [{ required: true, message: "投诉类型不能为空", trigger: "blur" }],
    tousuMain: [{ required: true, message: "投诉内容不能为空", trigger: "blur" }]
  },
});

const { queryParams, form, rules } = toRefs(data);

/** 查询角色列表 */
function getList() {
  loading.value = true;
  listTousu(proxy.addDateRange(queryParams.value, dateRange.value)).then(response => {
    tousuList.value = response.rows;
    total.value = response.total;
    loading.value = false;
    console.log(response.rows)
  });

}
/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}
/** 重置按钮操作 */
function resetQuery() {
  dateRange.value = [];
  proxy.resetForm("queryRef");
  handleQuery();
}
/** 删除按钮操作 */
function handleDelete(row) {
  const tousuTitles = row.tousuTitle;
  const tousuIds = row.tousuId;
  proxy.$modal.confirm('是否确认删除投诉标题为"' + tousuTitles + '"的数据项?').then(function () {
    return delTousu(tousuIds);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}
/** 导出按钮操作 */
function handleExport() {
  proxy.download("system/role/export", {
    ...queryParams.value,
  }, `role_${new Date().getTime()}.xlsx`);
}
/** 多选框选中数据 */
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.tousuId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}
/** 角色状态修改 */
function handleStatusChange(row) {
  let text = row.status === "0" ? "启用" : "停用";
  proxy.$modal.confirm('确认要"' + text + '""' + row.roleName + '"角色吗?').then(function () {
    return changeRoleStatus(row.roleId, row.status);
  }).then(() => {
    proxy.$modal.msgSuccess(text + "成功");
  }).catch(function () {
    row.status = row.status === "0" ? "1" : "0";
  });
}
/** 更多操作 */
function handleCommand(command, row) {
  switch (command) {
    case "handleDataScope":
      handleDataScope(row);
      break;
    case "handleAuthUser":
      handleAuthUser(row);
      break;
    default:
      break;
  }
}
/** 分配用户 */
function handleAuthUser(row) {
  router.push("/system/role-auth/user/" + row.roleId);
}
/** 查询菜单树结构 */
function getMenuTreeselect() {
  menuTreeselect().then(response => {
    menuOptions.value = response.data;
  });
}
/** 所有部门节点数据 */
function getDeptAllCheckedKeys() {
  // 目前被选中的部门节点
  let checkedKeys = deptRef.value.getCheckedKeys();
  // 半选中的部门节点
  let halfCheckedKeys = deptRef.value.getHalfCheckedKeys();
  checkedKeys.unshift.apply(checkedKeys, halfCheckedKeys);
  return checkedKeys;
}
/** 重置新增的表单以及其他数据  */
function reset() {
  if (menuRef.value != undefined) {
    menuRef.value.setCheckedKeys([]);
  }
  menuExpand.value = false;
  menuNodeAll.value = false;
  deptExpand.value = true;
  deptNodeAll.value = false;
  form.value = {
    userId:undefined,
    tousuId: undefined,
    tousuTitle: undefined,
    tousuType: undefined,
    tousuState: undefined,
    tousuMain: undefined,
    tousuReply:undefined,
    createBy:undefined,
    tousuIds: [],
    menuIds: [],
    deptIds: [],
    menuCheckStrictly: true,
    deptCheckStrictly: true,
    remark: undefined
  };
  proxy.resetForm("tousuRef");
}
/** 申请投诉 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "申请投诉";
}
/** 修改角色 */
function handleUpdate(row) {
  reset();
  const tousuId = row.tousuId;
  getTousuBytousuId(tousuId).then(response => {
    form.value = response.data[0];
    form.value.tousuType = response.data[0].tousuType.split(" ")[0];
    form.value.tousuTitle = response.data[0].tousuTitle.split(" ")[0];
    form.value.tousuMain = response.data[0].tousuMain.split(" ")[0];
    open.value = true;
    title.value = "修改投诉";
  });
}

function handleReply(row) {
  reset();
  const tousuId = row.tousuId;
  getTousuBytousuId(tousuId).then(response => {
    form.value = response.data[0];
    form.value.tousuType = response.data[0].tousuType.split(" ")[0];
    form.value.tousuTitle = response.data[0].tousuTitle.split(" ")[0];
    form.value.tousuMain = response.data[0].tousuMain.split(" ")[0];
    // form.value.tousuReply = response.data[0].tousuReply.split(" ")[0];
    if (response.data[0] && response.data[0].tousuReply) {
      form.value.tousuReply = response.data[0].tousuReply.split(" ")[0];
    } else {}
    openReply.value = true;
    title.value = "回复投诉";
  });
}

/** 根据角色ID查询菜单树结构 */
function getRoleMenuTreeselect(roleId) {
  return roleMenuTreeselect(roleId).then(response => {
    menuOptions.value = response.menus;
    return response;
  });
}
/** 根据角色ID查询部门树结构 */
function getDeptTree(roleId) {
  return deptTreeSelect(roleId).then(response => {
    deptOptions.value = response.depts;
    return response;
  });
}
/** 树权限（展开/折叠）*/
function handleCheckedTreeExpand(value, type) {
  if (type == "menu") {
    let treeList = menuOptions.value;
    for (let i = 0; i < treeList.length; i++) {
      menuRef.value.store.nodesMap[treeList[i].id].expanded = value;
    }
  } else if (type == "dept") {
    let treeList = deptOptions.value;
    for (let i = 0; i < treeList.length; i++) {
      deptRef.value.store.nodesMap[treeList[i].id].expanded = value;
    }
  }
}

/** 所有菜单节点数据 */
function getTousuAllCheckedIds() {
  // 目前被选中的菜单节点
  let checkedIds = menuRef.value.getCheckedKeys();
  // 半选中的菜单节点
  let halfCheckedKeys = menuRef.value.getHalfCheckedKeys();
  checkedKeys.unshift.apply(checkedKeys, halfCheckedKeys);
  return checkedKeys;
}
/** 提交按钮 */
function submitForm() {
  console.log("submitForm")
  proxy.$refs["tousuRef"].validate(valid => {
    if (valid) {
      if (form.value.tousuId != undefined) {
        // form.value.tousuIds = getTousuAllCheckedIds();
          updateTousu(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          openReply.value = false;
          getList();
        });
      } else {
        // form.value.tousuIds = getTousuAllCheckedIds();
        addTousu(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          openReply.value = false;
          getList();
        });
      }
    }
  });
}
/** 取消按钮 */
function cancel() {
  open.value = false;
  openReply.value = false;
  reset();
}
/** 选择角色权限范围触发 */
function dataScopeSelectChange(value) {
  if (value !== "2") {
    deptRef.value.setCheckedKeys([]);
  }
}
/** 分配数据权限操作 */
function handleDataScope(row) {
  reset();
  const deptTreeSelect = getDeptTree(row.roleId);
  getRole(row.roleId).then(response => {
    form.value = response.data;
    openDataScope.value = true;
    nextTick(() => {
      deptTreeSelect.then(res => {
        nextTick(() => {
          if (deptRef.value) {
            deptRef.value.setCheckedKeys(res.checkedKeys);
          }
        });
      });
    });
    title.value = "分配数据权限";
  });
}
/** 提交按钮（数据权限） */
function submitDataScope() {
  if (form.value.roleId != undefined) {
    form.value.deptIds = getDeptAllCheckedKeys();
    dataScope(form.value).then(response => {
      proxy.$modal.msgSuccess("修改成功");
      openDataScope.value = false;
      getList();
    });
  }
}
/** 取消按钮（数据权限）*/
function cancelDataScope() {
  openDataScope.value = false;
  reset();
}

getList();
</script>
