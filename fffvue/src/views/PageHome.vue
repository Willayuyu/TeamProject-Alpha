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
                    <router-link to="goods">
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
                    <router-link to="task">
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
                    <router-link to="activity">
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
                    <el-select v-model="value" placeholder="请选择">
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
                <div id="map" style="width: 100%;height:326px;"></div>
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

export default {
  name: "homePage",
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
      value: '',
      usersNumber: 200,
      goodNumber: 350,
      taskNumber: 500,
      activityNumber: 400,
      goodReport: 350,
      taskReport: 500,
      activityReport: 400,

    }
  },
  mounted() {
    this.getMap();
  },

  methods: {
    getMap() {
      let myChart = this.$echarts.init(document.getElementById('map'))
      let option = {
        title: {
        },
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
          data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日','周一', '周二', '周三', '周四', '周五', '周六', '周日','周一', '周二', '周三', '周四', '周五', '周六', '周日','周一', '周二', '周三', '周四', '周五', '周六', '周日']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: '二手物品',
            type: 'line',
            stack: '总量',
            data: [120, 132, 101, 134, 90, 230, 210,120, 132, 101, 134, 90, 230, 210,120, 132, 101, 134, 90, 230, 210,120, 132, 101, 134, 90, 230, 210]
          },
          {
            name: '任务委托',
            type: 'line',
            stack: '总量',
            data: [220, 182, 191, 234, 290, 330, 310]
          },
          {
            name: '活动信息',
            type: 'line',
            stack: '总量',
            data: [150, 232, 201, 154, 190, 330, 410]
          },
        ]
      }
      myChart.setOption(option)
    }
  },

}
</script>

<style scoped>
.el-container{
  margin-bottom: 20px;
}
/*.el-aside{*/
/*  border: solid 1px black;*/
/*}*/
/*.el-main{*/
/*  border: solid 1px blue;*/
/*}*/
/*.el-col{*/
/*  border: solid 1px green;*/
/*  background: blue;*/
/*}*/
.boxes h3 {
  color: #FFFFFF;
}

img {
  width: 40px;
  height: 40px;
  margin: 0 auto;
}

.image{
  margin: 0 auto;
}

.el-header{
  background: #FFFFFF;
}
.el-col{
  text-align: center;
}

.homePage{
  background: #E7ECF3;
}

.header{
  font-family: "Microsoft YaHei";
  float: left;
  font-weight: bold;
  margin-top: 20px;
}
.trendHeader{
  font-family: "Microsoft YaHei";
  font-weight: bold;
  padding-top: 10px;
}
.whiteBackground{
  background: #FFFFFF;

}
.boxes{
  width:200px;
  height: 100px;
  border-radius: 5px;
}
.box{
  margin-top: 5px;
  vertical-align: middle;
}
.user{
  margin-left: 50px;
  background: #F9AEAE;
}
.good{
  background: #F0E073;
  margin: 0 auto;
}
.task{
  background: #B091E3;
  margin: 0 auto;
}
.activity{
  float: right;
  background: #99DAC0;
  margin-right: 50px;
}
.trendChart{
  height: 380px;
  width: 100%;
}
.report{
  width: 80%;
  border-radius: 5px;

}

.size{
  width: 90%;
  height: 30%;
}

</style>