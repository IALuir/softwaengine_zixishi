<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="座位id" prop="zuoweiId">
        <el-input
          v-model="queryParams.zuoweiId"
          placeholder="请输入座位id"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="使用数" prop="zuoweiNumber">
        <el-input
          v-model="queryParams.zuoweiNumber"
          placeholder="请输入使用数"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="zuoweiState">
        <el-input
          v-model="queryParams.zuoweiState"
          placeholder="请输入状态"
          clearable
          @keyup.enter="handleQuery"
        />
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
          v-hasPermi="['system:zuowei:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:zuowei:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:zuowei:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['system:zuowei:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="zuoweiList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="座位id" align="center" prop="zuoweiId" />
      <el-table-column label="使用数" align="center" prop="zuoweiNumber" />
      <el-table-column label="状态" align="center" prop="zuoweiState" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:zuowei:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['system:zuowei:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      v-model:page="queryParams.pageNum"
      v-model:limit="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改座位管理对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="zuoweiRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="使用数" prop="zuoweiNumber">
          <el-input v-model="form.zuoweiNumber" placeholder="请输入使用数" />
        </el-form-item>
        <el-form-item label="状态" prop="zuoweiState">
          <el-input v-model="form.zuoweiState" placeholder="请输入状态" />
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

<script setup name="Zuowei">
import { listZuowei, getZuowei, delZuowei, addZuowei, updateZuowei } from "@/api/system/zuowei";

const { proxy } = getCurrentInstance();

const zuoweiList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    zuoweiId: null,
    zuoweiNumber: null,
    zuoweiState: null
  },
  rules: {
    zuoweiId: [
      { required: true, message: "座位id不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询座位管理列表 */
function getList() {
  loading.value = true;
  listZuowei(queryParams.value).then(response => {
    zuoweiList.value = response.rows;
    total.value = response.total;
    loading.value = false;
  });
}

// 取消按钮
function cancel() {
  open.value = false;
  reset();
}

// 表单重置
function reset() {
  form.value = {
    zuoweiId: null,
    zuoweiNumber: null,
    zuoweiState: null
  };
  proxy.resetForm("zuoweiRef");
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef");
  handleQuery();
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.zuoweiId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加座位管理";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _zuoweiId = row.zuoweiId || ids.value
  getZuowei(_zuoweiId).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改座位管理";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["zuoweiRef"].validate(valid => {
    if (valid) {
      if (form.value.zuoweiId != null) {
        updateZuowei(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addZuowei(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}

/** 删除按钮操作 */
function handleDelete(row) {
  const _zuoweiIds = row.zuoweiId || ids.value;
  proxy.$modal.confirm('是否确认删除座位管理编号为"' + _zuoweiIds + '"的数据项？').then(function() {
    return delZuowei(_zuoweiIds);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('system/zuowei/export', {
    ...queryParams.value
  }, `zuowei_${new Date().getTime()}.xlsx`)
}

getList();
</script>
