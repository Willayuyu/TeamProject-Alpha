// pages/activityDetailsPage/activityDetailsPage.js
import Toast from '../../components/lib/toast/toast';
Page({

  /**
   * 页面的初始数据
   */
  data: {
    swiperList: [
      "http://5b0988e595225.cdn.sohucs.com/images/20190311/ab66040c529445778cf31ced4ba24657.jpeg",
      "https://img.yzcdn.cn/vant/cat.jpeg",
      "https://img.yzcdn.cn/vant/cat.jpeg"
    ],
    tagsList: [
      "标签",
      "标签"
    ],
    title: "百米画卷",
    organizer: "2018级软件工程3班",
    place: "青春广场",
    beginTime: "2021.4.4 12:00",
    endTime: "2021.4.4 20:00",
    isStar:false,
    activityForm:"百米画卷画好后参赛者即可离场，等画干后将画布收起，第二天在学子广场挂起展出。评选分为两个环节有老师为所有作品打分；有观看的学生投票。每名观看的学生在准备好的纸片上写上自己认为最有意义的作品的组序号投入投票箱内。最后通过两个环节的综合评选选出获胜者。",
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