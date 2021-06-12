<template>
  <div id="app">
    <div class="header">
      <Header></Header>
    </div>
    <div class="content flex">
      <div class="sidebar">
        <Sidebar></Sidebar>
      </div>
      <div class="page">
        <!-- 使用路由视图组件，显示对应地址的页面 -->
        <router-view></router-view>
      </div>
    </div>
   
  </div>
</template>

<script>
//导入组件
import Header from './components/Header.vue'
import Sidebar from './components/Sidebar.vue'
//引入全局样式
import './assets/css/common.css'
export default {
  name: 'app',
  //注册页面中使用的组件
  components: {
    Header,
    Sidebar
  }
}
</script>

<style>
#app {
  /* font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px; */
  width: 100vw;
  height: 100vh;
  display: flex;
  flex-direction: column;
}
.header {
  height: 60px;
  background: #545c64;
  
}
.content {
  flex: 1;
}
.sidebar {
  width: 200px;
  background: rgb(84,92,100);
  border-style: solid;
  border-top-color: gainsboro;
  border-width: 1px;
}
.page {
  flex: 1;
  background: bisque;
}

</style>
