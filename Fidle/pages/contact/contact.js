// pages/contact/contact.js
let app=getApp();
Page({
  /**
   * 页面的初始数据
   */
  data: {
      imgsrc: app.globalData.imgsrc,
      username: app.globalData.username,
      phonenum: app.globalData.phonenum,
      qqnum: app.globalData.qqnum,
      credit: 100,
      goodcmt: 5,
      badcmt: 1,
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
    wx.setNavigationBarTitle({ title: '对方信息' })  
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
    this.setData({
      imgsrc:app.globalData.imgsrc,
      username:app.globalData.username,
      phonenum:app.globalData.phonenum,
      qqnum:app.globalData.qqnum,
    })
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
    wx.reLaunch({
      url: '/pages/index/index'
    })
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