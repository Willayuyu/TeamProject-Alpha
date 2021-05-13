// pages/contact/contact.js
let app=getApp();
Page({
  /**
   * 页面的初始数据
   */
  data: {
      id:'',
      dataList:[]
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
    wx.setNavigationBarTitle({ title: '对方信息' })  
    let id = options.pubId;
    console.log(options.pubId);
    wx.request({
      url: 'http://47.106.241.182:8082/homePage/getPublisherBusinessCard/'+ id,
      method: 'GET',
      dataType: 'json',
      headers: {
        'Content-Type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid')
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