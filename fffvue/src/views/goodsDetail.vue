<template>
  <el-container style="height: 100%;" direction="vertical">
    <div>
      <i class = "el-icon-back" />
    </div>
    <el-main>
      <div class="goodsmain">
        <div class="publisherInfo">
          <div class="leftFirstBox">
            发布人信息
          </div>
          <div class="leftSecondBox">
            <img v-bind:src="url"/>
          </div>
          <div class="leftThirdBox">
            <i class = "el-icon-user" />
            <span class="leftText">{{username}}</span>
          </div>
          <div class="leftThirdBox">
            <i class = "iconfont icon-shouji" />
            <span class="leftText">{{tel}}</span>
          </div>
          <div class="leftThirdBox">
            <i class = "iconfont icon-qq" />
            <span class="leftText">{{qq}}</span>
          </div>
          <div class="leftThirdBox">
            <i class = "el-icon-medal" />
            <span class="leftText">{{creditscore}}</span>
          </div>
        </div>
        <div class="goodsInfo">
          <div class="goodsImage">
            <el-carousel height="300px" arrow="never">
              <el-carousel-item v-for="item in picList" :key="item">
                <el-image
                  style="height: 100%"
                  v-bind:src="item"
                  :preview-src-list="picList">
                </el-image>
              </el-carousel-item>
            </el-carousel>
          </div>
          <div class="goodsDetail">
            <div class="infoHeader">
              <p class="title">{{title}}</p>
              <div class="prices">
                <span class="price">￥ {{price}}</span>
                <span class="originalPrice">￥ {{originalPrice}}</span>
              </div>
            </div>
            <div class="tags">
              <span>类别：</span>
              <i class="el-icon-price-tag"></i>
              <el-tag type="info">{{category}}</el-tag>
            </div>
            <div class="tags">
              <span>标签：</span>
              <i class="el-icon-price-tag"></i>
              <el-tag type="info" v-for="item in labels" :key="item">{{item.content}}</el-tag>
            </div>
            <div class="tags">
              <span>新旧：</span>
              <i class="el-icon-price-tag"></i>
              <el-tag type="info" v-if="condition === 1">全新</el-tag>
              <el-tag type="info" v-else-if="condition === 2">九成新</el-tag>
              <el-tag type="info" v-else-if="condition === 3">八成新</el-tag>
              <el-tag type="info" v-else-if="condition === 4">八成以下</el-tag>
            </div>
            <p class="details">简介：{{description}}</p>
            <div class="footer">
              <div class="leftFooter">
                <i class = "iconfont icon-zaishouzhong" v-if = "state === 1"/>
                <i class = "iconfont icon-yishouchu" v-else-if = "state === 2"/>
                <span class="state" v-if="state === 1">在售中</span>
                <span class="state" v-if="state === 2">已售出</span>
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
import axios from "axios";

  export default {
    data() {
      return {
        url: require("../assets/img/face" + Math.round(Math.random()*5) + ".png"),
        picList: [
          'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2841118707,440982020&fm=26&gp=0.jpg',
          require("../assets/logo.png"),
          require("../assets/logo.png")
        ],
        labels: [
          { content: '标签1', id: 1},
          { content: '标签2', id: 2},
        ],
        qq: '1',
        tel: '1',
        username: '1',
        creditscore: 100,
        category: "1",
        collectState: -1,
        condition: 1,
        description: '',
        price: 1,
        originalPrice: 1,
        pubId: 1,
        state: 2,
        title: '',
      }
    },

    mounted() {
      this.getGoodsInfo();
      this.getPublisherInfo();
    },

    methods: {
      async getGoodsInfo() {
        await axios.get('/api/goods/getGoodsDetailById/' + 89)
        .then( response => {
          console.log(response.data.data);
          this.category = response.data.data.category;
          this.collectState = response.data.data.collectState;
          this.condition = response.data.data.condition;
          this.description = response.data.data.description;
          this.price = response.data.data.price;
          this.originalPrice = response.data.data.originalPrice;
          this.picList = response.data.data.picturesLink;
          this.pubId = response.data.data.pubId;
          this.state = response.data.data.state;
          this.title = response.data.data.title;
          this.labels = response.data.data.tagList;
          console.log(this.pubId);
        })
        .catch(function (error) {
          console.log(error);
        });
      },

      async getPublisherInfo() {
        await this.getGoodsInfo();
        axios.get('/api/personalPage/getHomePageById/' + this.pubId)
        .then( response => {
          console.log(response);
          this.username = response.data.data.username;
          this.qq = response.data.data.qq;
          this.tel = response.data.data.tel;
          this.url = response.data.data.portrait;
          this.creditscore = response.data.data.credit.creditScore;
        })
        .catch(function (error) {
          console.log(error);
        });
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
  .goodsmain{
    display: flex;
    margin-left: 160px;
    margin-bottom: 110px;
    align-items: stretch;
    flex-shrink: 0;
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
  .goodsInfo{
    display: flex;
    flex-direction: column;
    width: 43%;
    margin-left: 40px;
  }
  .goodsImage{
    text-align: center;
    background-color: #EFF3F3;
    border-radius: 4px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  }
  .goodsDetail{
    display: flex;
    flex-direction: column;
    margin-top: 20px;
    flex-grow: 1;
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
  .originalPrice{
    margin-left: 10px;
    font-size: 16px;
    color: rgba(150, 148, 148, 0.849);
    text-decoration: line-through;
  }
  .details{
    margin-top: 20px;
    font-size: 16px;
  }
  .tags{
    margin-top: 15px;
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
    font-size: 35px;
    margin-right: 8px;
  }
</style>