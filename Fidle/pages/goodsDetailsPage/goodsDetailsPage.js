// pages/goodsDetailsPage/goodsDetailsPage.js
import Toast from '../../components/lib/toast/toast';
Page({

  /**
   * 页面的初始数据
   */
  data: {
    swiperList: [
      "https://bkimg.cdn.bcebos.com/pic/86d6277f9e2f0708134ac8a5ef24b899a801f2cc?x-bce-process=image/resize,m_lfit,w_268,limit_1/format,f_jpg",
      "https://bkimg.cdn.bcebos.com/pic/e61190ef76c6a7ef58da72f6fafaaf51f2de6666?x-bce-process=image/watermark,image_d2F0ZXIvYmFpa2UxMTY=,g_7,xp_5,yp_5/format,f_auto",
      "https://img.yzcdn.cn/vant/cat.jpeg"
    ],
    tagsList: [
      "标签",
      "标签"
    ],
    title: "软件工程 第八版 全新未拆 好价速来！",
    currentPrice: 30,
    originalPrice: 50,
    isStar:false,
    detailsText:"软件工程是一门研究用工程化方法构建和维护有效实用和高质量的软件的学科。它涉及程序设计语言、数据库、软件开工具、系统平台、标准、设计模式等方面。在现代社会中，软件应用于多个方面。典型的软件有电子邮件、嵌入式系统、人机界面、办公套件、操作系统、编译器、数据库、游戏等。同时，各个行业几乎都有计算机软件的应用，如工业农业银行航空政府部门等。这些应用促进了经济和社会的发展，也提高了工作效率和生活效率 。 ",
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
   * 点击联系卖家跳转
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