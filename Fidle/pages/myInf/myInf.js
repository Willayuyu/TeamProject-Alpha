// pages/myInf/myInf.js
let app=getApp();

Page({
  /**
   * 页面的初始数据
   */
  data: {
    id:0,
    dataList:[]
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
    let that = this;
    let id = app.globalData.user.id;
    console.log(id);
    wx.request({
      url: 'https://fidle.shawnxixi.icu/homePage/getPublisherBusinessCard/'+ id,
      method: 'GET',
      dataType: 'json',
      header: {
        'content-type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
      },
      success: (res) => {
        console.log(res.data);
        console.log(res.data.data);
        that.setData({
          id:app.globalData.user.id,
          dataList: res.data.data
        })
      },
      fail: (err) => {
        wx.showToast({ title: '系统错误' })
      },
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
    console.log("重新加载页面")
    let that = this;
    let id = app.globalData.user.id;
    wx.request({
      url: 'https://fidle.shawnxixi.icu/homePage/getPublisherBusinessCard/'+ id,
      method: 'GET',
      dataType: 'json',
      header: {
        'content-type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
      },
      success: (res) => {
        console.log(res.data);
        console.log(res.data.data);
        that.setData({
          dataList: res.data.data
        })
      },
      fail: (err) => {
        wx.showToast({ title: '系统错误' })
      },
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