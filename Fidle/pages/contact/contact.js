// pages/contact/contact.js
let app=getApp();
Page({
  /**
   * 页面的初始数据
   */
  data: {
      id:'',
      dataList:[{tel:0,qq:0}]
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
        if(res.data.data.tel == null)
          res.data.data.tel = "无";
        if(res.data.data.qq == null)
          res.data.data.qq = "无";
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

  },

  /**
   * 点击用户电话复制
   */
  telPaste(){
    var tel=this.data.dataList.tel;
    wx.showToast({
      title: '电话号码复制成功',
    })
    wx.setClipboardData({
      data: tel,
      success: function (res) {
        wx.getClipboardData({    
          success: function (res) {
            console.log(res.data) // data
          }
        })
      }
    })
  },

  /**
   * 点击用户qq号码复制
   */
  qqPaste(){
    var qq=this.data.dataList.qq;
    wx.showToast({
      title: 'qq号码复制成功',
    })
    wx.setClipboardData({
      data: qq,
      success: function (res) {
        wx.getClipboardData({    
          success: function (res) {
            console.log(res.data) // data
          }
        })
      }
    })
  },
})