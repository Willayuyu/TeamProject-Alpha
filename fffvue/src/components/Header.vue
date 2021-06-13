<template>
<div class="header flex">
    <span class="el-dropdown-link">
        <el-avatar class="header-icon" src= "https://images.cnblogs.com/cnblogs_com/blogs/673579/galleries/1986078/o_210612031536fidle.png"></el-avatar>
      </span>
    <span class="--mb--rich-text header-title" data-boldtype="0" style="font-family:Courier New; font-weight:700; font-size:36px; color:rgba(255, 255, 255, 1); font-style:normal; letter-spacing:0px; line-height:41px; text-decoration:none;">Fidle</span>
            
    <div class="header-avatar">
        <el-dropdown trigger="click" placement="bottom-end">
        <span class="el-dropdown-link">
            <el-avatar class="header-icon" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
        </span>
        <template #dropdown>
            <el-dropdown-menu>
            <el-dropdown-item icon="el-icon-switch-button">退出登录</el-dropdown-item>
            </el-dropdown-menu>
        </template>
        </el-dropdown>
    </div>
 
</div>    
</template>
<script>
export default{
}
</script>
<style>
.header{
    padding: 10px;
}
.header-icon {
    margin-left: 10px;
}
.header-title {
    margin:0 30px
}
.header-avatar {
    margin-left: 79vw;
}
</style>