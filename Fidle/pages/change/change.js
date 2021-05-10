// pages/changeInf/changeInf.js
let app=getApp();

import Toast from '../../components/dist/toast/toast';

Page({
  /**
   * 页面的初始数据
   */
  data: {
      imgsrc:app.globalData.imgsrc,
      username:app.globalData.username,
      phonenum:app.globalData.phonenum,
      qqnum:app.globalData.qqnum,
  },

  change: function(e) {
    var username=e.detail.value.username;
    var phonenum=e.detail.value.phonenum;
    var qqnum=e.detail.value.qqnum;
    
    if(username==''||phonenum==''||qqnum=='') {
      wx.showToast({
        title: '信息不能为空！',
        duration: 1000,
        icon: 'none'
      })
    }
    else{
      app.globalData.username=username;
      app.globalData.phonenum=phonenum;
      app.globalData.qqnum=qqnum;

      wx.request({
        url: 'http://xxx.com/personalPage/alterInformation',
        data: {
          username: username,
          tel: phonenum,
          qq: qqnum
        },
        method: 'POST',
        header: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        success: function(res){
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
    wx.setNavigationBarTitle({ title: '修改个人信息' })  
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