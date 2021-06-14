<template>
  <el-container style="height: 100%;" direction="vertical">
    <div>
      <i class = "el-icon-back" />
    </div>
    <el-main>
      <div class="taskmain">
        <div class="publisherInfo">
          <div class="leftFirstBox">
            发布人信息
          </div>
          <div class="leftSecondBox">
            <img v-bind:src="url"/>
          </div>
          <div class="leftThirdBox">
            <i class = "el-icon-user" />
            <span class="leftText">Fidle</span>
          </div>
          <div class="leftThirdBox">
            <i class = "iconfont icon-shouji" />
            <span class="leftText">11111111111</span>
          </div>
          <div class="leftThirdBox">
            <i class = "iconfont icon-qq" />
            <span class="leftText">11111111111</span>
          </div>
          <div class="leftThirdBox">
            <i class = "el-icon-medal" />
            <span class="leftText">100</span>
          </div>
        </div>
        <div class="taskInfo">
          <div class="taskDetail">
            <div class="infoHeader">
              <p class="title">软件工程第八版 好价速来 软件工程第八版 好价速来</p>
              <div class="prices">
                <span class="price">￥ 30</span>
              </div>
            </div>
            <div class="tags">
              <span>类别：</span>
              <i class="el-icon-price-tag"></i>
              <el-tag type="info">标签1</el-tag>
            </div>
            <div class="tags">
              <span>标签：</span>
              <i class="el-icon-price-tag"></i>
              <el-tag type="info" v-for="item in labels" :key="item">{{item}}</el-tag>
            </div>
            <div class="time">
              <span>开始时间：</span>
              <i class="el-icon-time"></i>
              <span>2021/4/6</span>
            </div>
            <div class="time">
              <span>结束时间：</span>
              <i class="el-icon-time"></i>
              <span>2021/4/6</span>
            </div>
            <p class="details">简介：</p>
            <div class="footer">
              <div class="leftFooter">
                <i class = "iconfont icon-renwujinhangzhong" />
                <span class="state">任务进行中</span>
              </div>
              <el-button type="danger">删除</el-button>
            </div>
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
        url: require("../assets/img/face" + Math.round(Math.random()*5) + ".png"),
        labels: [
          '标签1',
          '标签2'
        ]
      }
    }
  }
</script>

<style scoped>
  .el-icon-back{
    margin-left: 20px;
    padding: 20px;
    padding-bottom: 0px;
    font-size: 40px;
  }
  .taskmain{
    display: flex;
    margin-left: 160px;
    margin-bottom: 110px;
    align-items: flex-start;
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
    margin: 10px, 30px;
    padding: 20px;
    font-family: "Helvetica Neue";
    font-size: 22px;
    font-weight: bold;
    border-radius: 4px;
    text-align: center;
  }
  .leftSecondBox{
    margin: 30px;
    margin-top: 0px;
    padding: 30px;
    background-color: #FFFFFF;
    border-radius: 4px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    text-align: center;
  }
  .leftSecondBox img{
    width: 200px;
    height: 200px;
  }
  .leftThirdBox{
    display: flex;
    margin: 30px;
    padding: 5px;
    padding-right: 50px;
    text-align: center;
    background-color: #FFFFFF;
    align-content: center;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
  }
  .leftThirdBox i{
    padding-left: 15px;
    font-size: 23px;
    margin: 10px;
    color: #000000;
  }
  .leftText{
    font-size: 18px;
    width: 100%;
    margin: 10px;
    line-height: 23px;
    color: #000000;
  }
  .taskInfo{
    display: flex;
    flex-direction: column;
    width: 43%;
    margin-left: 40px;
  }
  .taskDetail{
    display: flex;
    flex-direction: column;
    padding: 30px;
    text-align: left;
    background-color: #EFF3F3;
    border-radius: 4px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
    font-family: "Helvetica Neue";
  }
  .infoHeader{
    display: flex;
    justify-content: space-between;
    margin-bottom: 10px;
  }
  .title{
    margin-top: 0px;
    font-size: 20px;
    font-weight: bold;
    max-width: 75%;
  }
  .price{
    color:red;
    font-size: 24px;
  }
  .details{
    margin-top: 20px;
    font-size: 16px;
  }
  .tags{
    margin-top: 20px;
    font-size: 16px;
    vertical-align: middle;
    display: flex;
    align-items: center;
  }
  .tags i{
    font-size: 20px;
    vertical-align: middle;
  }
  .el-tag{
    margin-left: 5px;
    margin-right: 5px;
    vertical-align: middle;
  }
  .time{
    margin-top: 20px;
    font-size: 16px;
    vertical-align: middle;
    display: flex;
    align-items: center;
  }
  .time i{
    font-size: 20px;
    vertical-align: middle;
    margin-right: 5px;
  }
  .footer{
    margin-top: 30px;
    display: flex;
    justify-content: space-between;
  }
  .leftFooter{
    display:flex;
    align-items: center;
    line-height: 23px;
  }
  .leftFooter i{
    font-size: 24px;
    margin-right: 8px;
  }
</style>