// pages/test/test.js
Page({
  /**
   * 页面的初始数据
   */
  data: {
    searchInput: "",//搜索框内容
    tabIndex: 0,//标签页下标
    secTime: "近三天",//二手-时间筛选
    secSort: "类别",//二手-类别筛选
    secDegree: "新旧程度",//二手-新旧筛选
    taskTime: "近三天",//任务-时间筛选
    taskSort: "类别",//任务-类别筛选
    activityTime: "近七天",//活动-时间筛选
    activitySort: "类别",//活动-类别筛选
    secTimeArray: [
      "近三天","近一天","近七天","近一个月","近三个月"
    ],
    secSortArray: [
      "类别","服饰","鞋子","生活用品","电子产品","书籍",
      "电动车","其他"
    ],
    secDegreeArray: [
      "新旧程度","全新","九成新","八成新","八成新以下"
    ],
    taskTimeArray: [
      "近三天","近一天","近七天","近一个月"
    ],
    taskSortArray: [
      "类别","取快递","填写问卷","考试辅导","食堂带饭","其他"
    ],
    activityTimeArray: [
      "近七天","近一天","近三天","近一个月","近三个月"
    ],
    activitySortArray: [
      "类别","团立项","社团活动","比赛","招聘会","其他"
    ]
  },

  //获取搜索框内容
  getInputValue: function(e) { 
    this.data.searchInput = e.detail.value;
  },

  //二手-时间筛选事件
  select_Sec_Time: function(e) {
    this.data.secTime = e.detail;
    this.search();
  },

  //二手-类别筛选事件
  select_Sec_Sort: function(e) {
    this.data.secSort = e.detail;
    this.search();
  },

  //二手-新旧筛选事件
  select_Sec_Degree: function(e) {
    this.data.secDegree = e.detail;
    this.search();
  },

  //任务-时间筛选事件
  select_Task_Time: function(e) {
    this.data.taskTime = e.detail;
    this.search();
  },

  //任务-类别筛选事件
  select_Task_Sort: function(e) {
    this.data.taskSort = e.detail;
    this.search();
  },

  //活动-时间筛选事件
  select_Act_Time: function(e) {
    this.data.activityTime = e.detail;
    this.search();
  },

  //活动-类别筛选事件
  select_Act_Sort: function(e) {
    this.data.activitySort = e.detail;
    this.search();
  },

  //标签点击/切换事件
  tab_Click: function(e) {
    this.data.tabIndex = e.detail.index;
  },

  //搜索
  search: function() {
    console.log(this.data.searchInput);
    console.log(this.data.tabIndex);
    switch(this.data.tabIndex) {
      case 0:
        console.log(this.data.secTime);
        console.log(this.data.secSort);
        console.log(this.data.secDegree);
        break;
      case 1:
        console.log(this.data.taskTime);
        console.log(this.data.taskSort);
        break;
      case 2:
        console.log(this.data.activityTime);
        console.log(this.data.activitySort);
        break;
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})