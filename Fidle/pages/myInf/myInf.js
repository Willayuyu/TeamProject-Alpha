// pages/myInf/myInf.js
let app=getApp();

Page({
  /**
   * 页面的初始数据
   */
  data: {
  imgsrc:"",
  username:"",
  userid:"",
  credit:"",
  goodcmt:0,
  badcmt:0,
  },

  aboutus: function (options) {
    wx.navigateTo({
      url: '/pages/aboutus/aboutus',
    })
  },

  changeInf: function (options) {
    wx.navigateTo({
      url: '/pages/changeInf/changeInf',
    })
  },

  comments: function (options) {
    wx.navigateTo({
      url: '/pages/comments/comments',
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      imgsrc:app.globalData.imgsrc,
      username:app.globalData.username,
      userid:app.globalData.userid,
      credit:app.globalData.credit,
      goodcmt:app.globalData.goodcmt,
      badcmt:app.globalData.badcmt,
    })
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