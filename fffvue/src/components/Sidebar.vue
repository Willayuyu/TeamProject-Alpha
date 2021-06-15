<template>
<div>
  <!-- el-menu开启vue-router模式，菜单项的index属性作为路径path使用 -->
  <el-menu
    :router="true"
    default-active="/goodsList"
    class="el-menu-vertical-demo"
    @open="handleOpen"
    @close="handleClose"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#7db5ee"
    >
    <el-menu-item index="/">
      <i class="iconfont icon-home icon"></i>
      <span slot="title">首页</span>
    </el-menu-item>
    <el-menu-item index="/goodsList">
      <i class="iconfont icon-Shoppingcartfinancebusiness icon"></i>
      <span slot="title">二手物品</span>
    </el-menu-item>
    <el-menu-item index="/taskList">
      <i class="iconfont icon-shoppingbag icon"></i>
      <span slot="title">任务委托</span>
    </el-menu-item>
    <el-menu-item index="/activityList">
      <i class="iconfont icon-horn icon"></i>
      <span slot="title">活动信息</span>
    </el-menu-item>
  </el-menu>

</div>
</template>
<script>
export default{
     methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
}
</script>
<style>
.icon {
  margin-right: 15px;
  margin-left: 15px;
}
</style>