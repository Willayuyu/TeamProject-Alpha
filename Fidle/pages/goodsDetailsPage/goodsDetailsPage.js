// pages/goodsDetailsPage/goodsDetailsPage.js
import Toast from '../../components/lib/toast/toast';
Page({

  /**
   * 页面的初始数据
   */
  data: {
    swiperList: [],
    collectState: 0,
    category: "",
    condition: "",
    tagsList: [],
    title: "",
    currentPrice: 0,
    originalPrice: 0,
    description:" ",
    pubId: 0,
    id: 0,
  },

  /**
   * 获取二手详情页信息
   */
  getGoodsDetail:function(event){
    let that = this;
    //let id = event.id;
    var session_id = wx.getStorageSync('sessionid');
    var header = {'content-type': 'application/x-www-form-urlencoded', 'Cookie': session_id };
    wx.request({
      url: 'http://47.106.241.182:8080/goods/getGoodsDetailById/' + 2,
      method: "GET",
      header: header,
      success(res){
        console.log(res.data);
        if(res.data.code===200){
          that.setData({
            swiperList: res.data.data.picturesLink,
            title: res.data.data.title,
            currentPrice: res.data.data.price,
            originalPrice: res.data.data.originalPrice,
            condition: res.data.data.condition,
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
    var session_id = wx.getStorageSync('sessionid');
    var header = {'content-type': 'application/x-www-form-urlencoded', 'Cookie': session_id };
    wx.request({
      url: 'http://47.106.241.182:8080/goods/collectGoods/' + 2,
      method: 'GET',
      header: header,
      success(res){
        console.log(res);
        if(res.data.code===200){
          if(that.data.collectState == 0){
            that.setData({
              collectState: 1
            });
            Toast({
              position: 'bottom',
              message: '收藏成功！'
            });
          } else {
            that.setData({
              collectState: 0
            });
            Toast({
              position: 'bottom',
              message: '取消收藏成功！'
            });
          }
        }
      }
    })
  },
  /**
   * 点击联系卖家跳转
   */
  contact: function() {
    let that = this;
    wx.navigateTo({
      url: '/pages/contact/contact?pubId=' + that.data.pubId,
    })
  },
 /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getGoodsDetail();
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