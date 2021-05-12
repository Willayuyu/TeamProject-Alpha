// pages/myInf/myInf.js
let app=getApp();

Page({
  /**
   * 页面的初始数据
   */
  data: {
    reload:0,
    imgsrc:"",
    username:"",
    userid:"",
    credit:"100",
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
    if(this.data.reload==0) {
      console.log("登录后来到个人信息页");
      console.log(app.globalData.user);
      var that=this;
      console.log("此用户id为："+app.globalData.user.id);
      wx.request({
        url: 'http://120.77.210.142:8080/personalPage/getHomePageById/'+app.globalData.user.id,
        method: 'GET',
        header: {
          "Content-Type": "application/json",
          'Cookie': wx.getStorageSync('sessionid')
        },
        success: function(res){
          console.log(res);
          that.setData({
            //onload装载页面要显示的信息
            imgsrc:res.data.data.portrait,
            username:res.data.data.username,
            userid:res.data.data.id,
            credit:res.data.data.credit.creditScore,
            goodcmt:res.data.data.credit.likeNum,
            badcmt:res.data.data.credit.dislikeNum,
          })
          app.globalData.username=res.data.data.username;
          app.globalData.phonenum=res.data.data.tel;
          app.globalData.qqnum=res.data.data.qq;
        },
        fail: function(res){
          console.log("根据id获取个人信息失败")
        }
      })    
      this.data.reload=1;
    }
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
    console.log("reload我的界面");
    if(this.data.reload==1) {
      var that=this;
      console.log("此用户id为："+app.globalData.user.id);
      wx.request({
        url: 'http://120.77.210.142:8080/personalPage/getHomePageById/'+app.globalData.user.id,
        method: 'GET',
        header: {
          "Content-Type": "application/json",
          'Cookie': wx.getStorageSync('sessionid')
        },
        success: function(res){
          console.log(res);
          that.setData({
            //页面显示的可能会改变的信息需要刷新
            username:res.data.data.username,
            credit:res.data.data.credit.creditScore,
            goodcmt:res.data.data.credit.likeNum,
            badcmt:res.data.data.credit.dislikeNum,
          })
        },
        fail: function(res){
          console.log("根据id获取个人信息失败")
        }
      })    
    }
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