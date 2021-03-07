<template>
  <div class="app-container">
    <div v-loading="loading" >
      <p>{{ key }}</p>
      <p>{{ balance }}</p>
    </div>
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
