<template>
  <div>
    <el-container>
      <el-main class="homePage">
        <div id="homePage" >
          <div id="releaseOverview" class="whiteBackground">
            <el-container>
              <el-header height="10px" class="header">
                发布概况
              </el-header>
              <el-main>
                <el-row>

                    <el-col :span="6">
                      <div id="user" class="boxes user">
                        <el-container>
                          <el-main class="box">
                            <el-row>
                              <el-col :span="9">
                                <div class="image">
                                  <img src="../assets/users.png">
                                </div>
                              </el-col>
                              <el-col :span="15">
                                <div>
                                  <h3>用户数</h3>
                                  <h3>{{usersNumber}}</h3>
                                </div>
                              </el-col>
                            </el-row>
                          </el-main>
                        </el-container>
                      </div>
                    </el-col>
                  <router-link to="goodsList">
                    <el-col :span="6">
                      <div id="good" class="boxes good">
                        <el-container>
                          <el-main class="box">
                            <el-row>
                              <el-col :span="9">
                                <div class="image">
                                  <img src="../assets/shoppingCard.png">
                                </div>
                              </el-col>
                              <el-col :span="15">
                                <div>
                                  <h3>二手物品数</h3>
                                  <h3>{{goodNumber}}</h3>
                                </div>
                              </el-col>
                            </el-row>
                          </el-main>
                        </el-container>
                      </div>
                    </el-col>
                  </router-link>
                  <router-link to="taskList">
                    <el-col :span="6">
                      <div id="task" class="boxes task">
                        <el-container>
                          <el-main class="box">
                            <el-row>
                              <el-col :span="9">
                                <div class="image">
                                  <img src="../assets/work.png">
                                </div>
                              </el-col>
                              <el-col :span="15">
                                <div>
                                  <h3>任务数</h3>
                                  <h3>{{taskNumber}}</h3>
                                </div>
                              </el-col>
                            </el-row>
                          </el-main>
                        </el-container>
                      </div>
                    </el-col>
                  </router-link>
                  <router-link to="activityList">
                    <el-col :span="6">
                      <div id="activity" class="boxes activity">
                        <el-container>
                          <el-main class="box">
                            <el-row>
                              <el-col :span="9">
                                <div class="image">
                                  <img src="../assets/notification.png">
                                </div>
                              </el-col>
                              <el-col :span="15">
                                <div>
                                  <h3>活动数</h3>
                                  <h3>{{activityNumber}}</h3>
                                </div>
                              </el-col>
                            </el-row>
                          </el-main>
                        </el-container>
                      </div>
                    </el-col>
                  </router-link>
                </el-row>
              </el-main>
            </el-container>
          </div>

          <div id="pendingReport" class="whiteBackground">
            <el-container>
              <el-header height="10px" class="header">
                待处理举报
              </el-header>
              <el-main>
                <el-row>
                  <el-col :span="5" :offset="1">
                    <router-link to="goodsReport">
                      <div id="goodReport">
                        <el-container>
                          <el-main class="box report">
                            <el-row>
                              <el-col :span="9">
                                <div class="image">
                                  <img src="../assets/shoppingCardYellow.png">
                                </div>
                              </el-col>
                              <el-col :span="15">
                                <div>
                                  <h3>{{goodReport}}</h3>
                                  <h4>二手物品举报数</h4>
                                </div>
                              </el-col>
                            </el-row>
                          </el-main>
                        </el-container>
                      </div>
                    </router-link>
                  </el-col>
                  <el-col :span="5" :offset="3">
                    <router-link to="taskReport">
                      <div id="taskReport">
                        <el-container>
                          <el-main class="box report">
                            <el-row>
                              <el-col :span="9">
                                <div class="image">
                                  <img src="../assets/workpurple.png">
                                </div>
                              </el-col>
                              <el-col :span="15">
                                <div>
                                  <h3>{{taskReport}}</h3>
                                  <h4>任务委托举报数</h4>
                                </div>
                              </el-col>
                            </el-row>
                          </el-main>
                        </el-container>
                      </div>
                    </router-link>
                  </el-col>
                  <el-col :span="5" :offset="3">
                    <router-link to="activityReport">
                      <div id="activityReport">
                        <el-container>
                          <el-main class="box report">
                            <el-row>
                              <el-col :span="9">
                                <div class="image">
                                  <img src="../assets/notificationGreen.png">
                                </div>
                              </el-col>
                              <el-col :span="15">
                                <div>
                                  <h3>{{activityReport}}</h3>
                                  <h4>活动信息举报数</h4>
                                </div>
                              </el-col>
                            </el-row>
                          </el-main>
                        </el-container>
                      </div>
                    </router-link>
                  </el-col>
                </el-row>
              </el-main>
            </el-container>
          </div>

          <div id="trendChart" class="whiteBackground">
            <el-container>
              <el-header height="40px" class="trendHeader">
                <el-row>
                  <el-col :span="12" :offset="6">发布量趋势图</el-col>
                  <el-col :span="6">
                    <el-select v-model="value" placeholder="请选择" @change="selectTrigger(value)">
                      <el-option
                          v-for="item in options"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value">
                      </el-option>
                    </el-select>
                  </el-col>
                </el-row>
              </el-header>
              <el-main class="trendChart">
                <div id="chart" style="width: 100%;height:326px;"></div>
              </el-main>
            </el-container>
          </div>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
//局部引用组件
// import sideBar from "./";

import axios from "axios";
import qs from "qs";

export default {
  name: "PageHome",
  data() {
    return {
      options: [{
        value: '选项1',
        label: '近七天'
      }, {
        value: '选项2',
        label: '近一个月'
      }, {
        value: '选项3',
        label: '近三个月'
      }],
      value: '选项1',
      usersNumber: 200,
      goodNumber: 350,
      taskNumber: 500,
      activityNumber: 400,
      goodReport: 350,
      taskReport: 500,
      activityReport: 400,
      date: [],
      goodData: [],
      taskData: [],
      activityData: []

    }
  },
  mounted() {

    this.init();
    this.changeChart(7);
  },

  methods: {

    /**
     * 绘制折线图
     */
    getChart() {
      let myChart = this.$echarts.init(document.getElementById('chart'))
      let option = {
        title: {},
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['二手物品', '任务委托', '活动信息']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        toolbox: {
          feature: {
            saveAsImage: {}
          }
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: this.date
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: '二手物品',
            type: 'line',

            data: this.goodData,
            smooth:true
          },
          {
            name: '任务委托',
            type: 'line',

            data: this.taskData,
            smooth:true
          },
          {
            name: '活动信息',
            type: 'line',

            data: this.activityData,
            smooth:true
          },
        ]
      }
      myChart.setOption(option)
    },

    /**
     * 初始化获取用户数，二手交易数、任务委托数、活动信息数、以及三种类别的举报数
     */
    init() {
      axios
          .get('http://47.106.241.182:8082/admin/totalUsersNum',{
            headers:{
              'token': sessionStorage.getItem("token")
            }
          })
          .then(response => (this.usersNumber = response.data.data))

      axios
          .get('http://47.106.241.182:8082/admin/totalGoodsNum',{
            headers:{
              'token': sessionStorage.getItem("token")
            }
          })
          .then(response => (this.goodNumber = response.data.data))

      axios
          .get('http://47.106.241.182:8082/admin/totalTasksNum',{
            headers:{
              'token': sessionStorage.getItem("token")
            }
          })
          .then(response => (this.taskNumber = response.data.data))

      axios
          .get('http://47.106.241.182:8082/admin/totalActivitiesNum',{
            headers:{
              'token': sessionStorage.getItem("token")
            }
          })
          .then(response => (this.activityNumber = response.data.data))

      axios
          .get('http://47.106.241.182:8082/admin/goodsReportNum',{
            headers:{
              'token': sessionStorage.getItem("token")
            }
          })
          .then(response => (this.goodReport = response.data.data))

      axios
          .get('http://47.106.241.182:8082/admin/tasksReportNum',{
            headers:{
              'token': sessionStorage.getItem("token")
            }
          })
          .then(response => (this.taskReport = response.data.data))

      axios
          .get('http://47.106.241.182:8082/admin/activitiesReportNum',{
            headers:{
              'token': sessionStorage.getItem("token")
            }
          })
          .then(response => (this.activityReport = response.data.data))

    },

    /**
     * 获取多选框的数值
     * @param value 多选框的value值
     */
    selectTrigger(value){
      let i = 7;

      if(value==this.options[0].value)
        i = 7;
      else if(value==this.options[1].value)
        i = 30;
      else if(value==this.options[2].value)
        i = 90;

      this.changeChart(i);
    },

    /**
     * 获取横坐标(日期)
     * @param list 获取的折线图数据列表
     */
    getX(list){
      this.date = [];
      for(let i = 0; i < list.length; i++){
        this.date.push(this.dealStr(list[i].endTime));
      }
    },

    /**
     * 根据选择框改变折线图
     * @param value 向后台请求的数据天数
     */
    changeChart(value) {
      console.log(value);
      let that = this;
      axios.post('http://47.106.241.182:8082/admin/releaseNumTrend',
          qs.stringify({
          dayNum: value
      }),{
            headers:{
              'token': sessionStorage.getItem("token")
            }
          })
      .then(function (response) {
        let goodsReleaseList = response.data.data.goodsReleaseList;
        let tasksReleaseList = response.data.data.tasksReleaseList;
        let activitiesReleaseList = response.data.data.activitiesReleaseList;
        that.getX(goodsReleaseList);
        that.goodData = that.getReleaseNum(goodsReleaseList);
        that.taskData = that.getReleaseNum(tasksReleaseList);
        that.activityData = that.getReleaseNum(activitiesReleaseList);
        // console.log(goodsReleaseList);
        that.getChart();
        // console.log(that.goodData);
        // console.log(that.date);
      })
      .catch(function (error) {
        console.log(error);
      });
    },

    /**
     * 处理列表获取y轴数组值
     * @param list 待处理列表
     * @returns {*[]} 折线的y轴数值数组
     */
    getReleaseNum(list){
      let temp = [];
      for(let i = 0; i < list.length; i++){
        temp.push(parseInt(list[i].releaseNum));
      }
      return temp;
    },
    dealStr(value){
      let array = value.split('-');
      return array[1] + '.' + array[2];
    }
  }
}
</script>

<style scoped>
.el-container{
  margin-bottom: 20px;
}

.el-header{
  background: #FFFFFF;
}

.el-col{
  text-align: center;
}

/*图片大小*/
img {
  width: 40px;
  height: 40px;
  margin: 0 auto;
}

/*图片居中*/
.image{
  margin: 0 auto;
}

/*后台首页背景*/
.homePage{
  background: #E7ECF3;
}

/*头部*/
.header{
  font-family: "Microsoft YaHei";
  float: left;
  font-weight: bold;
  margin-top: 20px;
}

/*发布量趋势图的header*/
.trendHeader{
  font-family: "Microsoft YaHei";
  font-weight: bold;
  padding-top: 10px;
}

/*白色背景*/
.whiteBackground{
  background: #FFFFFF;
}

/*发布概况 待处理举报卡片样式*/
.boxes{
  width:200px;
  height: 100px;
  border-radius: 5px;
}

.boxes h3 {
  color: #FFFFFF;
}

/*发布概况 待处理举报卡片样式*/
.box{
  margin-top: 5px;
  vertical-align: middle;
}

/*总用户数*/
.user{
  margin-left: 50px;
  background: #F9AEAE;
}

/*二手交易数*/
.good{
  background: #F0E073;
  margin: 0 auto;
}

/*任务数*/
.task{
  background: #B091E3;
  margin: 0 auto;
}

/*活动数*/
.activity{
  float: right;
  background: #99DAC0;
  margin-right: 50px;
}

/*趋势图*/
.trendChart{
  height: 380px;
  width: 100%;
}

/*举报*/
.report{
  width: 80%;
  border-radius: 5px;
}
</style>