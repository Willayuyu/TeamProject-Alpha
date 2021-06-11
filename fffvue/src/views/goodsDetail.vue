<template>
    <el-container style="height: 100%;" direction="vertical">
    <el-main>
      <div class="main">
        <div class="publisherInfo">
          <div class="leftFirstBox">
            发布人信息
          </div>
          <div class="leftSecondBox">
            <img v-bind:src="url"/>
          </div>
          <div class="leftThirdBox">
            <i class = "iconfont icon-account" />
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
        </div>
        <div class="goodsInfo">
          <div class="goodsImage">
            <el-carousel height="300px" arrow="never">
              <el-carousel-item v-for="item in pics" :key="item">
                <el-image
                  style="width: 100%"
                  v-bind:src="item.url"
                  :preview-src-list="picList">
                </el-image>
              </el-carousel-item>
            </el-carousel>
          </div>
          <div class="goodsDetail">
            <div class="header">
              <p class="title">软件工程第八版 好价速来 软件工程第八版 好价速来</p>
              <div class="prices">
                <span class="price">￥ 30</span>
                <span class="originalPrice">￥ 50</span>
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
            <div class="tags">
              <span>新旧：</span>
              <i class="el-icon-price-tag"></i>
              <el-tag type="info">标签1</el-tag>
            </div>
            <p class="details">软件工程第八版 好价速来 软件工程第八版 好价速来 软件工程第八版 好价速来 软件工程第八版 好价速来</p>
            <div class="footer">
              <div class="leftFooter">
                <i class = "iconfont icon-zaishouzhong" />
                <span class="state">在售</span>
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
        url: 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=900739219,1112472094&fm=26&gp=0.jpg',
        pics: [
          { url: 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2841118707,440982020&fm=26&gp=0.jpg' },
          { url: require("../assets/logo.png") },
          { url: require("../assets/logo.png") },
        ],
        picList: [
          'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2841118707,440982020&fm=26&gp=0.jpg',
          require("../assets/logo.png"),
          require("../assets/logo.png")
        ],
        labels: [
          '标签1',
          '标签2'
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
    margin: 10px, 30px;
    padding: 20px;
    font-family: "Helvetica Neue";
    font-size: 22px;
    font-weight: bold;
    border-radius: 4px;
  }
  .leftSecondBox{
    margin: 30px;
    margin-top: 0px;
    padding: 30px;
    background-color: #FFFFFF;
    border-radius: 4px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
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
    flex-grow: 1;
    padding: 30px;
    text-align: left;
    background-color: #EFF3F3;
    border-radius: 4px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
    font-family: "Helvetica Neue";
  }
  .header{
    display: flex;
    justify-content: space-between;
  }
  .title{
    margin-top: 0px;
    font-size: 19px;
    font-weight: bold;
    max-width: 75%;
  }
  .price{
    color:red;
    font-size: 24px;
  }
  .originalPrice{
    margin-left: 10px;
    font-size: 16px;
    color: rgba(150, 148, 148, 0.849);
    text-decoration: line-through;
  }
  .details{
    font-size: 15px;
  }
  .tags{
    margin-top: 10px;
    font-size: 15px;
    vertical-align: middle;
  }
  .tags i{
    font-size: 20px;
    vertical-align: middle;
  }
  .el-tag{
    margin-right: 5px;
    vertical-align: middle;
  }
  .footer{
    display: flex;
    justify-content: space-between;
  }
  .leftFooter{
    display:flex;
    align-items: center;
    line-height: 23px;
  }
  .leftFooter i{
    font-size: 30px;
    margin-right: 8px;
  }

</style>