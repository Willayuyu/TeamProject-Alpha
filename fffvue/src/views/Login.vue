<template>
  <el-form>
    <el-form-item class="">
      <el-input v-model="account" placeholder="请输入用户名" size="small" style="width: 100%;"></el-input>
    </el-form-item>
    <el-form-item class="">
      <el-input v-model="password" placeholder="请输入密码" type="password" size="small" style="width: 100%;"></el-input>
    </el-form-item>
    <el-form-item>
      <h1>{{message}}</h1>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" size="small" @click="loginRequest">登录</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import axios from "axios";
import qs from "qs";

export default {
  data () {
    return {
      account: "",
      password: "",
      message: ""
    }
  },
  methods: {
    loginRequest: function () {
      this.$axios.post("/api/admin/login",
          qs.stringify({
            account: this.account,
            password: this.password
          }),{
            headers: {
              'Content-Type': 'application/x-www-form-urlencoded'
            }
          }
      ).then(res => {

        console.log(res.data);
        if(res.data.code==200)
        {
          this.$router.push("/goods");
          sessionStorage.setItem("token",res.data.data.token);

          var admin= {account:res.data.data.account,id:res.data.data.id};
          sessionStorage.setItem("admin",admin);
        }
        else
        {
          this.message=res.data.message;
        }
      })

    },//搜索

  }
}
</script>