<template>
    <el-container style="height: 100%;" direction="vertical">
    <el-main>
      <div class="main">
        <div class="publisherInfo">
          <div class="leftFirstBox">
            发布人信息
          </div>
          <div class="leftSecondBox">
            <el-image
              style="width: 200px; height: 100px"
              :src="url"
              :fit="fit"></el-image>
          </div>
          <div class="leftThirdBox">
            <i class="el-icon-user"></i>
            <span>Fidle</span>
          </div>
          <div class="leftThirdBox">
            <i class="el-icon-phone-outline"></i>
            <span>11111111111</span>
          </div>
          <div class="leftThirdBox">
            <i class="el-icon-chat-dot-round"></i>
            <span>11111111111</span>
          </div>
        </div>
        <div class="goodsInfo">
          <div class="goodsImage">
            <el-carousel height="300px" arrow="never">
              <el-carousel-item v-for="item in pics" :key="item">
                <h3 class="small">{{ item }}</h3>
              </el-carousel-item>
            </el-carousel>
          </div>
          <div class="goodsDetail">
            
          </div>
        </div>
      </div>
    </el-main>
  </el-container>
</template>

<script>
  export default {
    data() {
      return {
        pics: [
          { url: require("../assets/logo.png") },
          { url: require("../assets/logo.png") },
          { url: require("../assets/logo.png") },
          { url: require("../assets/logo.png") },
        ]
      }
    }
  }
</script>

<style>
  .main{
    display: flex;
    margin-left: 160px;
    margin-bottom: 110px;
    align-items: stretch;
  }
  .publisherInfo{
    background-color: #EFF3F3;
    width: 43%;
    min-height: 550px;
    padding: 10px;
    border-radius: 4px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  }
  .leftFirstBox{
    margin: 20px;
    padding: 20px;
    font-family: "Helvetica Neue";
    font-size: 20px;
    font-weight: bold;
    border-radius: 4px;
  }
  .leftSecondBox{
    margin: 30px;
    padding: 20px;
    background-color: #FFFFFF;
    border-radius: 4px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
  }
  .leftThirdBox{
    margin: 30px;
    padding: 5px;
    text-align: left;
    background-color: #FFFFFF;
    border-radius: 4px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
  }
  i{
    padding-left: 15px;
    font-size: 23px;
    margin: 10px;
    color: #000000;
  }
  span{
    font-size: 18px;
    margin: 10px;
    padding-left: 120px;
    line-height: 23px;
    color: #000000;
  }
  .goodsInfo{
    display: flex;
    flex-direction: column;
    width: 43%;
    margin-left: 40px;
  }
  .goodsImage{
    background-color: #EFF3F3;
    border-radius: 4px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  }
  .goodsDetail{
    margin-top: 20px;
    flex-grow:2;
    padding: 10px;
    background-color: #EFF3F3;
    border-radius: 4px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  }
</style>