// pages/changeInf/changeInf.js
let app=getApp();
Page({
  /**
   * 页面的初始数据
   */
  data: {
      imgsrc:app.globalData.user.portrait,
      username:app.globalData.username,
      phonenum:app.globalData.phonenum,
      qqnum:app.globalData.qqnum,
  },

  change: function(e) {
    var username=e.detail.value.username.trim();
    var phonenum=e.detail.value.phonenum.trim();
    var qqnum=e.detail.value.qqnum.trim();
    
    if(username.length==0||phonenum.length==0||qqnum.length==0) {
      wx.showToast({
        title: '信息不能为空！',
        duration: 1000,
        icon: 'none'
      })
    }
     else if(phonenum.length!=11||!(/^1[3|4|5|7|8][0-9]{9}$/.test(phonenum))) {
      wx.showToast({
        title: '电话号码输入有误！',
        duration: 1000,
        icon: 'none'
      })
    }
    else{
      //将修改的信息赋给全局数据 方便调用
      app.globalData.user.username=username;
      app.globalData.phonenum=phonenum;
      app.globalData.qqnum=qqnum;
      console.log("填入的用户名："+username);
      console.log("填入的电话号码："+phonenum);
      console.log("填入的qq："+qqnum);

      wx.request({
        url: 'http://47.106.241.182:8080/personalPage/alterInformation',
        data: {
          //将修改的数据传给后台进行同步修改
          username: username,
          tel: phonenum,
          qq: qqnum
        },
        method: 'POST',
        header: {
          "Content-Type": "application/x-www-form-urlencoded",
          'Cookie': wx.getStorageSync('sessionid'),
          'token': app.globalData.token
        },
        success: function(res){
          console.log(res);
          wx.showToast({
            title: '修改成功！',
            icon: 'success',
            duration: 1000,
            success:function(){ 
              setTimeout(function () { 
                  wx.redirectTo({ 
                      url: '/pages/changeInf/changeInf'
                   }) 
               }, 1000) 
            } 
          })
        },
        fail: function(res){
          console.log("修改失败！")
        }
      })      
    }   
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({ title: '修改个人信息' }) ;
    this.setData({
      imgsrc:app.globalData.user.portrait,
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