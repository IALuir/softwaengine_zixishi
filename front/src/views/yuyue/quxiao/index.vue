<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" v-show="showSearch" :inline="true" label-width="68px">
      <el-form-item label="预约时间" style="width: 308px">
        <el-date-picker
            v-model="dateRange1"
            value-format="YYYY-MM-DD"
            type="daterange"
            range-separator="-"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
        ></el-date-picker>
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
      <el-col :span="1.5" v-if="0">
        <el-button
            type="primary"
            plain
            icon="Plus"
            @click="handleAdd"
            v-hasPermi="['system:role:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="success"
            plain
            icon="Edit"
            :disabled="single"
            @click="handleUpdate"
            v-hasPermi="['system:role:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="danger"
            plain
            icon="Delete"
            :disabled="multiple"
            @click="handleDelete"
            v-hasPermi="['system:role:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="warning"
            plain
            icon="Download"
            @click="handleExport"
            v-hasPermi="['system:role:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 表格数据 -->
    <el-table v-loading="loading" :data="yuyueList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="预约编号" prop="yuyueId" width="120" />
      <el-table-column label="用户名称" prop="userName" :show-overflow-tooltip="true" width="150" />
      <el-table-column label="预约座位" prop="zuoweiId" width="120" />
      <el-table-column label="预约时间" align="center" prop="yuyueTime">
        <template #default="scope">
          <span>{{ parseTime(scope.row.yuyueTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="终止时间" align="center" prop="deTime">
        <template #default="scope">
          <span>{{ parseTime(scope.row.deTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="cTime">
        <template #default="scope">
          <span>{{ parseTime(scope.row.cTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="预约状态" prop="state" width="320" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-tooltip content="修改" placement="top" v-if="scope.row.yuyueId !== 0" >
            <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)"></el-button>
          </el-tooltip>
          <el-tooltip content="删除" placement="top" v-if="scope.row.yuyueId !== 0">
            <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"></el-button>
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

    <!-- 添加或修改配置对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="yuyueRef" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="用户名称" prop="userName">
          <p style="text-align: center;margin: 0;padding: 0;padding-left:10px">{{form.userName}}</p>
        </el-form-item>
        <el-form-item label="预约座位" prop="zuoweiId">
          <el-input v-model="form.zuoweiId" placeholder="请输入座位" />
        </el-form-item>
        <el-form-item label="预约时间">
          <el-col :span="11">
            <el-date-picker value-format="YYYY-MM-DD" type="date" placeholder="选择日期" v-model="form.yuyueDate" style="width: 100%;"></el-date-picker>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-time-picker value-format="YYYY-MM-DD HH:mm:ss" placeholder="选择时间" v-model="form.yuyueTime" style="width: 100%;"></el-time-picker>
          </el-col>
        </el-form-item>
        <el-form-item label="终止时间">
          <el-col :span="11">
            <el-date-picker value-format="YYYY-MM-DD" type="date" placeholder="选择日期" v-model="form.deDate" style="width: 100%;"></el-date-picker>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-time-picker value-format="YYYY-MM-DD HH:mm:ss" placeholder="选择时间" v-model="form.deTime" style="width: 100%;"></el-time-picker>
          </el-col>
        </el-form-item>
        <el-form-item label="创建时间" v-if=false>
          <el-col :span="11">
            <el-date-picker value-format="YYYY-MM-DD" type="date" placeholder="选择日期" v-model="form.cDate" style="width: 100%;"></el-date-picker>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-time-picker value-format="YYYY-MM-DD HH:mm:ss" placeholder="选择时间" v-model="form.cTime" style="width: 100%;"></el-time-picker>
          </el-col>
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

<script setup>
import {
  addYuyue,
  delYuyue,
  getYuyueByyuyueId,
  getYuyueByZuoweiId,
  getYuyueList,
  updateYuyue
} from "@/api/yuyuezuowei/yuyuezuowei.js";
import store from "@/store";
const router = useRouter();
const { proxy } = getCurrentInstance();
const { sys_normal_disable } = proxy.useDict("sys_normal_disable");

const yuyueList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");
const dateRange = ref([]);
const dateRange1 = ref([]);
const menuOptions = ref([]);
const menuExpand = ref(false);
const menuNodeAll = ref(false);
const deptExpand = ref(true);
const deptNodeAll = ref(false);
const deptOptions = ref([]);
const openDataScope = ref(false);
const menuRef = ref(null);
const deptRef = ref(null);


const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    yuyueId: undefined,
    userName: undefined,
    zuowei: undefined,
    cTime: undefined,
    yuyueTime: undefined,
    cDate: undefined,
    yuyueDate: undefined,
    cLeftTime:undefined,
    cRightTime:undefined,
    yuyueLeftTime:undefined,
    yuyueRightTime:undefined
  },
  rules: {
    zuowei: [{ required: true, message: "预约座位不能为空", trigger: "blur" }],
    yuyueDate: [{ required: true, message: "预约日期不能为空", trigger: "blur" }],
    yuyueTime: [{ required: true, message: "预约时间不能为空", trigger: "blur" }],
    cDate: [{ required: true, message: "创建日期不能为空", trigger: "blur" }],
    cTime: [{ required: true, message: "创建时间不能为空", trigger: "blur" }]
  },
});

const { queryParams, form, rules } = toRefs(data);
let tempId = 0;
/** 查询角色列表 */
function getList() {
  loading.value = true;
  let tempTime = {};
  tempTime.cLeftTime = dateRange.value[0];
  tempTime.cRightTime = dateRange.value[1];
  tempTime.yuyueLeftTime = dateRange1.value[0];
  tempTime.yuyueRightTime = dateRange1.value[1];
  tempTime.userId = store.state.value.user.id;
  getYuyueList(tempTime).then(response => {
    yuyueList.value = response.rows;
    total.value = response.total;
    loading.value = false;
    if(response.total){
      //0：未到签到时间 1：正常签到，正常签退 2:正常签到，未到签退时间 3:正常签到,未签退 4:正常签到,超时签退 5:超时签到,未到签退时间 6:超时签到，超时签退 7:超时签到，正常签退 8:未签到 9:超时签到,未到签
      const stateList = ["未结束：未签到","已结束：正常签到，正常签退","未结束：正常签到，未签退","已结束：正常签到,未签退","已结束：正常签到,超时签退","未结束：超时签到,未签退","已结束：超时签到，超时签退","已结束：超时签到，正常签退","已结束：未签到","已结束：超时签到,未到签"]
      yuyueList.value[0].state = stateList[response.rows[0].state]
    }
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
  dateRange1.value = [];
  proxy.resetForm("queryRef");
  handleQuery();
}
/** 删除按钮操作 */
function handleDelete(row) {
  const roleIds = row.yuyueId || ids.value;
  proxy.$modal.confirm('是否确认删除编号为"' + roleIds + '"的数据项?').then(function () {
    return delYuyue(roleIds);
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
  ids.value = selection.map(item => item.yuyueId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
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
    yuyueId: undefined,
    userId: undefined,
    userName: undefined,
    zuoweiId: undefined,
    cTime: undefined,
    yuyueTime: undefined,
    cDate: undefined,
    yuyueDate: undefined,
    state:undefined
  };
  proxy.resetForm("yuyueRef");
}
/** 添加 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加预约";
}
/** 修改 */
function handleUpdate(row) {
  reset();
  const yuyueId = row.yuyueId || ids.value;
  getYuyueByyuyueId(yuyueId).then(response => {
    form.value = response.data[0];
    form.value.yuyueDate = response.data[0].yuyueTime.split(" ")[0];
    form.value.cDate = response.data[0].cTime.split(" ")[0];
    form.value.deDate = response.data[0].deTime.split(" ")[0];
    open.value = true;
    title.value = "修改预约";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["yuyueRef"].validate(valid => {
    if (valid) {
      form.value.yuyueTime = form.value.yuyueDate + ' ' + form.value.yuyueTime.split(" ")[1]
      form.value.deTime = form.value.deDate + ' ' + form.value.deTime.split(" ")[1]
      form.value.cTime = form.value.cDate + ' ' + form.value.cTime.split(" ")[1]
      if (form.value.yuyueId != undefined) {
        getYuyueByZuoweiId(form.value.zuoweiId).then(res => {
          if(!res.data.length){
            updateYuyue(form.value).then(response => {
              proxy.$modal.msgSuccess("修改成功");
              open.value = false;
              getList();
            });
          }else{
            proxy.$modal.msgError("该座位已被预约");
          }
        })
      }
    }
  });
}
/** 取消按钮 */
function cancel() {
  open.value = false;
  reset();
}

getList();
</script>
