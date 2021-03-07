<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="key" prop="authorityKey">
        <el-input
          v-model="queryParams.authorityKey"
          placeholder="请输入key"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="识别方式" prop="recognizeFrom">
        <el-input
          v-model="queryParams.recognizeFrom"
          placeholder="请输入识别方式"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="识别类型" prop="recognizeType">
        <el-select v-model="queryParams.recognizeType" placeholder="请选择识别类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>


    <el-table v-loading="loading" :data="historyList" >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="key" align="center" prop="authorityKey" />
      <el-table-column label="识别耗时" align="center" prop="recognizeTime" />

      <el-table-column label="费用" align="center" prop="expense" />
      <el-table-column label="结果" align="center" prop="result" />

      <el-table-column label="识别类型" align="center" prop="recognizeType" />
      <el-table-column label="识别ip" align="center" prop="recognizeIp" />

      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['biz:history:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['biz:history:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
 </div>
</template>

<script>
import { listHistory} from "@/api/client/client";

export default {
  name: "History",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 识别记录表格数据
      historyList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        authorityKey: null,
        recognizeTime: null,
        recognizeFrom: null,
        expense: null,
        result: null,
        status: null,
        recognizeType: null,
        recognizeIp: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        authorityKey: [
          { required: true, message: "key不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "状态不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询识别记录列表 */
    getList() {
      this.loading = true;
      listHistory(this.queryParams).then(response => {
        this.historyList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
  }
};
</script>
