<template>
  <div>
    <div class="background">
      <img :src="imgSrc" width="100%" height="100%" alt="" />
    </div>
    <div class="front">
      <div>
        <img :src="logo" class="logo" alt=""/>
      </div>
      <el-card class="card">
        <div slot="header" class="cardtitle">
          <span>Fidle后台登录</span>
        </div>
        <div>
          <el-form>
            <el-form-item class="">
              <el-input
                v-model="account"
                placeholder="请输入用户名"
                style="width: 100%"
              ></el-input>
            </el-form-item>
            <el-form-item class="">
              <el-input
                v-model="password"
                placeholder="请输入密码"
                type="password"
                style="width: 100%"
              ></el-input>
            </el-form-item>
            <!-- <el-form-item>
              <h1>{{ message }}</h1>
            </el-form-item> -->
              <el-button type="primary"  @click="loginRequest" class="card-btn"
                >登录</el-button
              >
          </el-form>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import qs from "qs";

export default {
  data() {
    return {
      account: "",
      password: "",
      // message: "",
      imgSrc: require("../assets/img/background.jpg"),
      logo:require("../assets/img/Fidlelogo.png")
    };
  },
  methods: {
    loginRequest: function () {
      this.$axios
        .post(
          "/api/admin/login",
          qs.stringify({
            account: this.account,
            password: this.password,
          }),
          {
            headers: {
              "Content-Type": "application/x-www-form-urlencoded",
            },
          }
        )
        .then((res) => {
          console.log(res.data);
          if (res.data.code == 200) {
            this.$router.push("/");
            sessionStorage.setItem("token", res.data.data.token);

            var admin = {
              account: res.data.data.account,
              id: res.data.data.id,
            };
            sessionStorage.setItem("admin", admin);
          } else {
            alert(res.data.message);
            // this.message = res.data.message;
          }
        });
    }, //搜索
  },
};
</script>
<style scoped>
.background {
  width: 100%;
  height: 100%; /**宽高100%是为了图片铺满屏幕 */
  z-index: -1;
  position: absolute;
}

.front {
  z-index: 1;
  position: absolute;
}
.logo{
  width: 150px;
  height: 150px;
  margin-left: calc(calc(100vw - 150px)/2);
  margin-top: 10%;
}
.card{
  width:400px;
  margin-top: 5%;
  margin-left: calc(calc(100vw - 400px)/2);
  background-color: rgba(200,200,200,0.5);
  border-color: rgba(200,200,200,0.5);
  border-radius: 10px;
}
.cardtitle{
  text-align: center;
  font-size: 24px;
  font-weight: bold;
  color: rgba(50,50,50,0.8);
}
.card-btn{
  display: block;
  margin: 0 auto;
  width: 100%;
}
</style>
