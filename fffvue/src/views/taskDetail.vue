<template>
  <el-container style="height: 100%;" direction="vertical">
    <div>
      <i class = "el-icon-back" @click="$router.back(-1)"/>
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
        <div class="taskInfo">
          <div class="taskDetail">
            <div class="infoHeader">
              <p class="title">{{title}}</p>
              <div class="prices">
                <span class="price">￥ {{price}}</span>
              </div>
            </div>
            <div class="tags">
              <span>类别：</span>
              <i class="el-icon-price-tag"></i>
              <el-tag type="info">{{category}}</el-tag>
            </div>
            <div class="tags" v-show="tagflag">
              <span>标签：</span>
              <i class="el-icon-price-tag"></i>
              <el-tag type="info" v-for="item in labels" :key="item">{{item.content}}</el-tag>
            </div>
            <div class="time">
              <span>开始时间：</span>
              <i class="el-icon-time"></i>
              <span>{{startTime}}</span>
            </div>
            <div class="time">
              <span>结束时间：</span>
              <i class="el-icon-time"></i>
              <span>{{endTime}}</span>
            </div>
            <p class="details">简介：{{description}}</p>
            <div class="footer">
              <div class="leftFooter">
                <i class = "iconfont icon-weibiaoti-" v-if="state === -1"/>
                <i class = "iconfont icon-weijieshou" v-else-if="state === 1"/>
                <i class = "iconfont icon-jinhangzhong" v-else-if="state === 2"/>
                <i class = "iconfont icon-yiwancheng" v-else-if="state === 3"/>
                <span class="state" v-if="state === -1">已取消</span>
                <span class="state" v-else-if="state === 1">未接收</span>
                <span class="state" v-else-if="state === 2">进行中</span>
                <span class="state" v-else-if="state === 3">已完成</span>
              </div>
              <el-button type="danger" @click="deleteInfo">删除</el-button>
            </div>
          </div>
        </div>
      </div>
    </el-main>
  </el-container>
</template>

<script>
import axios from "axios";
import { Message } from 'element-ui';

  export default {
    data() {
      return {
        url: require("../assets/img/face" + Math.round(Math.random()*5) + ".png"),
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
        description: '',
        price: 1,
        pubId: 1,
        state: 1,
        title: '',
        tagflag: 1,
      }
    },

    mounted() {
      this.getTaskInfo();
      this.getPublisherInfo();
    },

    methods: {
      async getTaskInfo() {
        this.id = this.$route.params.id;
        await axios.get('/api/task/getTaskDetailById/' + this.id,{
          headers:{
            'token': sessionStorage.getItem("token")
          }
        })
        .then( response => {
          console.log(response.data.data);
          this.category = response.data.data.category;
          this.description = response.data.data.description;
          this.price = response.data.data.reward;
          this.pubId = response.data.data.pubId;
          this.state = response.data.data.state;
          this.title = response.data.data.title;
          this.startTime = response.data.data.startTime;
          this.endTime = response.data.data.endTime;
          this.labels = response.data.data.tagList;
          if(this.labels[0].content == ''){
            this.tagflag = 0;
          }
          console.log(this.pubId);
        })
        .catch(function (error) {
          console.log(error);
        });
      },

      async getPublisherInfo() {
        await this.getTaskInfo();
        axios.get('/api/personalPage/getHomePageById/' + this.pubId,{
          headers:{
            'token': sessionStorage.getItem("token")
          }
        })
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
      },

      deleteInfo(){
        axios.get('/api/myTask/deleteTaskById/' + this.id,{
          headers:{
            'token': sessionStorage.getItem("token")
          }
        })
        .then( response => {
          console.log(response);
          this.$message({
            message: '删除成功！',
            type: 'success'
          });
          this.$router.back(-1);
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
    font-size: 26px;
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
    font-size: 40px;
    margin-right: 8px;
  }
</style>