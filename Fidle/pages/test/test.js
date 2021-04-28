// pages/test/test.js
Page({
  /**
   * 页面的初始数据
   */
  data: {
    secTime: "近三天",
    secSort: "类别",
    secDegree: "新旧程度",
    taskTime: "近三天",
    taskSort: "类别",
    activityTime: "近七天",
    activitySort: "类别",
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

  select: function(e) {
    console.log(e.detail)
  },

  tab_Click: function(e) {
    console.log(e.detail)
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