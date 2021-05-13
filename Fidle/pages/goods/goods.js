// pages/goods/goods.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    show: false,
    goodsOnSale: [],
    goodsSold:[],
    goodsBuy:[]
  
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
  clickSaleGoodsCard(event){
    let index = event.currentTarget.dataset.index;
    let id;
    let pubId;
    wx.request({
      url: 'http://120.77.210.142:8080/myGoods/listGoodsOnSaleByPageid/1',
      method: 'GET',
      dataType: 'json',
      data: {
        'id': id,
        'pubId': pubId
      },
      headers: {
        'Content-Type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid')
      },
      success: (res) => {
        console.log(index);
        let dataList = res.data.data[index];
        console.log(dataList);
        id = dataList.id;
        pubId = dataList.pubId;
        console.log(id);
        console.log(pubId);
        wx.navigateTo({
          url: '/pages/goodsDetailsPage/goodsDetailsPage?id='+id,
        })
      },
      fail: (err) => {
        wx.showToast({ title: '系统错误' })
      },
    })
  },
  clickSoldGoodsCard(event){
    let index = event.currentTarget.dataset.index;
    let id;
    let pubId;
    wx.request({
      url: 'http://120.77.210.142:8080/myGoods/listGoodsSoldByPageid/1',
      method: 'GET',
      dataType: 'json',
      data: {
        'id': id,
        'pubId': pubId
      },
      headers: {
        'Content-Type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid')
      },
      success: (res) => {
        console.log(index);
        let dataList = res.data.data[index];
        console.log(dataList);
        id = dataList.id;
        pubId = dataList.pubId;
        console.log(id);
        console.log(pubId);
        wx.navigateTo({
          url: '/pages/goodsDetailsPage/goodsDetailsPage?id='+id,
        })
      },
      fail: (err) => {
        wx.showToast({ title: '系统错误' })
      },
    })
  },
  clickBuyingGoodsCard(event){
    let index = event.currentTarget.dataset.index;
    let id;
    let pubId;
    wx.request({
      url: 'http://120.77.210.142:8080/myGoods/listGoodsBuyingByPageid/1',
      method: 'GET',
      dataType: 'json',
      data: {
        'id': id,
        'pubId': pubId
      },
      headers: {
        'Content-Type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid')
      },
      success: (res) => {
        console.log(index);
        let dataList = res.data.data[index];
        console.log(dataList);
        id = dataList.id;
        pubId = dataList.pubId;
        console.log(id);
        console.log(pubId);
        wx.navigateTo({
          url: '/pages/goodsDetailsPage/goodsDetailsPage?id='+id,
        })
      },
      fail: (err) => {
        wx.showToast({ title: '系统错误' })
      },
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

  showOverlap: function(){
    this.setData({ show: true });
  },

  onClickHide() {
    this.setData({ show: false });
  },

  noop() {},

})