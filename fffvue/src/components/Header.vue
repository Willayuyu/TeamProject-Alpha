<template>
<div class="header flex">
    <span class="el-dropdown-link">
        <el-avatar class="header-icon" :src=logo></el-avatar>
      </span>
    <span class="--mb--rich-text header-title" data-boldtype="0" style="font-family:Courier New; font-weight:700; font-size:36px; color:rgba(255, 255, 255, 1); font-style:normal; letter-spacing:0px; line-height:41px; text-decoration:none;">Fidle</span>
            
    <div class="header-avatar">
        <el-dropdown trigger="click" placement="bottom-end">
        <span class="el-dropdown-link">
            <el-avatar icon="el-icon-user-solid"></el-avatar>
        </span>
        <template #dropdown>
            <el-dropdown-menu>
            <el-dropdown-item icon="el-icon-switch-button">
                <router-link to="/login" tag="span">
                退出登录
                </router-link>
            </el-dropdown-item>
            </el-dropdown-menu>
        </template>
        </el-dropdown>
    </div>
 
</div>    
</template>
<script>
export default{
    data() {
        return {
        account: "",
        password: "",
        // message: "",
        admin: require("../assets/img/admin.png"),
        logo:require("../assets/img/Fidlelogo.png")
        };
    },
}
</script>
<style>
.header{
    padding: 10px;
}
.header-icon {
    margin-left: 2vh;
}
.header-title {
    margin:0 30px
}
.header-avatar {
    margin-left: 79vw;
}
</style>