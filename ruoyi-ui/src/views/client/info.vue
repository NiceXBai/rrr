<template>
  <div class="app-container">
    <el-row :gutter="15">
      <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
        <el-col :span="12">
          <el-row gutter="15">
            <el-col :span="24">
              <el-form-item label="API_KEY" prop="key">
                <el-input v-model="key" readonly prefix-icon='el-icon-key' :style="{width: '100%'}">
                </el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item label="余额" prop="balance">
                <el-input v-model="balance" readonly  :style="{width: '100%'}">
                </el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-col>
      </el-form>
    </el-row>
  </div>


</template>

<script>
import { userInfo} from "@/api/client/client";

export default {
  name: "Info",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      key:"",
      balance:"0.0"
    };
  },
  created() {
    this.getList();
  },
  methods: {

    getList() {
      this.loading = true;
      userInfo().then(response => {

        this.loading = false;
        this.key = response.authority.authorityKey;
        this.balance = response.info.balance;
      });
    }
  }

};
</script>
