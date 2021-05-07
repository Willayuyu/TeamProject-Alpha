// pages/taskDetailsPage/taskDetailsPage.js
import Toast from '../../components/lib/toast/toast';
Page({

  /**
   * 页面的初始数据
   */
  data: {
    tagsList: [
      "标签",
      "标签"
    ],
    title: "找人拿快递 3小件 送到41号楼！",
    currentPrice: 30,
    isStar:false,
    detailsText:"中通快递，晚上7点前送到即可。",
    beginTime: "2021.4.4 12:00",
    endTime: "2021.4.4 20:00"
  },

  /**
   * 点击home图标跳转首页
   */
  onClickHome(event){
    wx.switchTab({
      url: '/pages/index/index',
    })
  },
  /**
   * 点击收藏变色
   */
  onClickStar(event){
    let that = this;
    var state = that.data.isStar;
    that.setData({
      isStar: !state
    })
    if(!state) {
      Toast({
        position: 'bottom',
        message: '收藏成功！'
      });
    } else {
      Toast({
        position: 'bottom',
        message: '取消收藏成功！'
      });
    }
  },
  /**
   * 点击联系委托人跳转
   */
  contact: function() {
    wx.navigateTo({
      url: '/pages/contact/contact',
    })
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