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
    this.showPromise();
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
    this.showPromise();
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
  },
  showOnSale() {
    return new Promise(function (resolve, reject) {
      wx.request({
        url: 'http://120.77.210.142:8080/myGoods/listGoodsOnSaleByPageid/1',
        method: 'GET',
        dataType: 'json',
        headers: {
          'Content-Type': 'application/json',
          'Cookie': wx.getStorageSync('sessionid')
        },
        success: (result) => {
          resolve(result);
          // console.log(res.data.code);
          // console.log(res.data.data); 
          // console.log(res.data.data[0]);
          // that.setData({
          //   dataList: res.data.data,
          // });
          // console.log(dataList);
        },
        fail: (err) => {
          reject(err);
          wx.showToast({ title: '系统错误' })
        },
      })
    })
  },
  showSold() {
    return new Promise(function (resolve, reject) {
      wx.request({
        url: 'http://120.77.210.142:8080/myGoods/listGoodsSoldByPageid/1',
        method: 'GET',
        dataType: 'json',
        headers: {
          'Content-Type': 'application/json',
          'Cookie': wx.getStorageSync('sessionid')
        },
        success: (result) => {
          resolve(result);
          // console.log(res.data.code);
          // console.log(res.data.data); 
          // console.log(res.data.data[0]);
          // that.setData({
          //   dataList: res.data.data,
          // });
          // console.log(dataList);
        },
        fail: (err) => {
          reject(err);
          wx.showToast({ title: '系统错误' })
        },
      })
    })
  },

  showBuy() {
    return new Promise(function (resolve, reject) {
      wx.request({
        url: 'http://120.77.210.142:8080/myGoods/listGoodsBuyingByPageid//1',
        method: 'GET',
        dataType: 'json',
        headers: {
          'Content-Type': 'application/json',
          'Cookie': wx.getStorageSync('sessionid')
        },
        success: (result) => {
          resolve(result);
          // console.log(res.data.code);
          // console.log(res.data.data); 
          // console.log(res.data.data[0]);
          // that.setData({
          //   dataList: res.data.data,
          // });
          // console.log(dataList);
        },
        fail: (err) => {
          reject(err);
          wx.showToast({ title: '系统错误' })
        },
      })
    })
  },
  showPromise() {
    let that = this;
    let goodsOnSale;
    let goodsSold;
    let goodsBuy;
    Promise.all(
      [that.showOnSale(), that.showSold(), that.showBuy()]).then((res) => {
        //三个方法回来后的数据
        console.log(res.data);
        const [res1, res2, res3] = res;
        console.log(res1.data.data);
        console.log(res2.data.data);
        console.log(res3.data.data);
        that.setData({
          goodsOnSale: res1.data.data,
          goodsSold: res2.data.data,
          goodsBuy: res3.data.data
        })
      });
  },

})