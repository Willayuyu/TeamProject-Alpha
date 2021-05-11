// pages/goods/goods.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    goodsPrice: "30",
    goodsOriginPrice: "75",
    goodsTitle: "软件工程 第八版 全新未拆封 好价速来！",
    goodsImageURL: "/images/book.png",
    goodsTagsList: [
      "全新",
      "教材",
      "大三",
      "软件工程"
    ],
    goodsDetailsURL: "/pages/goodsDetailsPage/goodsDetailsPage",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({ title: '我的二手' });  
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
    wx.request({
      url: 'http://120.77.210.142:8080/myGoods/listGoodsOnSaleByPageid/Pageid',
      method: 'GET',
      success: function(res){
        console.log(res.code);
        console.log(res.data);
      }
    })
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
   * 点击标题跳转详情页
   */
  clickGoodsCard(event){
    wx.navigateTo({
      url: '/pages/goodsDetailsPage/goodsDetailsPage',
    })
  }

})