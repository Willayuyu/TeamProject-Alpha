// pages/activity/activity.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    activityImageURL: "http://5b0988e595225.cdn.sohucs.com/images/20190311/ab66040c529445778cf31ced4ba24657.jpeg",
    activityTitle: "百米画卷",
    address: "青春广场",
    date: "2021年4月23日",
    oganizer: "2018级软件工程3班",
    activityTagsList: [
      "团立项",
      "五四活动"
    ],
    activityDetailsURL: "/pages/activityDetailsPage/activityDetailsPage",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({ title: '我的活动' });  
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

  },

    /**
   * 点击标题跳转详情页
   */
  clickActivityCard(event){
    wx.navigateTo({
      url: '/pages/activityDetailsPage/activityDetailsPage',
    })
  },
})