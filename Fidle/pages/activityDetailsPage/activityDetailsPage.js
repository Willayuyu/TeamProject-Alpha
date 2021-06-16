// pages/activityDetailsPage/activityDetailsPage.js
import Toast from '../../components/lib/toast/toast';
let app =getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    swiperList: [],
    tagsList: [],
    category: "",
    title: "",
    address: "",
    beginTime: "",
    endTime: "",
    collectState: -1,
    description:"",
    pubId: 0,
    id: 0,
    hiddenModal: true,
    inputValue: null
  },

  /**
   * 获取活动详情页信息
   */
  getActivityDetail:function(){
    let that=this;
    wx.request({
      url: 'http://47.106.241.182:8082/activity/getActivityDetailById/' + that.data.id,
      method: "GET",
      header:{
        'content-type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
      },
      success(res){
        console.log(res.data);
        if(res.data.code===200){
          that.setData({
            swiperList: res.data.data.picturesLink,
            title: res.data.data.title,
            address: res.data.data.address,
            beginTime: res.data.data.startTime,
            endTime: res.data.data.endTime,
            tagsList: res.data.data.tagList,
            collectState: res.data.data.collectState,
            description: res.data.data.description,
            category: res.data.data.category,
            pubId: res.data.data.pubId,
            id:res.data.data.id,
          })
        }
      },
      fail(err){
        console.log(err);
      }
    })
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
   * 轮播图图片放大预览
   */
  preview(event) {
    var swiperlist = this.data.swiperList;
    var index = event.currentTarget.dataset.index;
    wx.previewImage({
      current: swiperlist[index],
      urls: swiperlist
    })
  },

  /**
   * 点击收藏变色
   */
  onClickStar(event){
    let that = this;
    if(that.data.collectState == -1){
      wx.request({
        url: 'https://fidle.shawnxixi.icu/activity/collectActivity/' + that.data.id,
        method: 'GET',
        header:{
          'content-type': 'application/json',
          'Cookie': wx.getStorageSync('sessionid'),
          'token': app.globalData.token
        },
        success(res){
          console.log(res);
          if(res.data.code===200){
            that.setData({
              collectState: 1
            });
            Toast({
              position: 'bottom',
              message: '收藏成功！'
            });
          } 
        },
        fail(err){
          console.log(err);
        }
      })
    } else if(that.data.collectState == 1) {
      wx.request({
        url: 'http://47.106.241.182:8082/activity/cancelCollectActivity/' + that.data.id,
        method: 'GET',
        header:{
          'content-type': 'application/json',
          'Cookie': wx.getStorageSync('sessionid'),
          'token': app.globalData.token
        },
        success(res){
          console.log(res);
          if(res.data.code===200){
            that.setData({
              collectState: -1
            });
            Toast({
              position: 'bottom',
              message: '取消收藏成功！'
            });
          }
        },
        fail(err){
          console.log(err);
        }
      })
    }
  },

  /**
   * 举报
   */
  input: function (e) {
    this.setData({ inputValue: e.detail.value })
  },
  showInputModel: function (e) {
    this.setData({ hiddenModal: false })
  },
  modelConfirm: function (e) {
    this.setData({ hiddenModal: true })
    wx.showToast({
      title: '举报理由：' + this.data.inputValue + '已提交',
      icon: 'none'
    })
    var that = this;
    var id = that.data.id;
    console.log(id);
    var reason = that.data.inputValue;
    console.log(reason);
      wx.request({
        url: 'http://47.106.241.182:8082/activity/reportActivity',
        method: 'POST',
        header: {
          'Content-Type': 'application/x-www-form-urlencoded',
          'Cookie': wx.getStorageSync('sessionid'),
          'token': app.globalData.token
        },
        data: {
          id: id,
          reason: reason
        },
        success(res){
          console.log(res.data);
        }

      })
  },
  modelCancel: function (e) {
    this.setData({ hiddenModal: true })
    wx.showToast({
      title: '举报已取消',
      icon: 'none'
    })
  },
  reset: function (e) {
    this.setData({ inputValue: '' });
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({ title: '活动信息详情页' });
    let activityID = options.id;
    this.setData({
      id: activityID
    })
    this.getActivityDetail();
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