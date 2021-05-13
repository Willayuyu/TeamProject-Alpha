// pages/goods/goods.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    // show: false,
    // indexOnsale:0,
    // input:null,
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
    console.log(index);
    let that = this;
    let dataList = that.data.goodsOnSale[index];
    console.log(dataList);
    let id = dataList.id;
    console.log(id);
    wx.navigateTo({
      url: '/pages/goodsDetailsPage/goodsDetailsPage?id=' + id
    })
  },
  clickSoldGoodsCard(event){
    let index = event.currentTarget.dataset.index;
    console.log(index);
    let that = this;
    let dataList = that.data.goodsSold[index];
    console.log(dataList);
    let id = dataList.id;
    console.log(id);
    wx.navigateTo({
      url: '/pages/goodsDetailsPage/goodsDetailsPage?id=' + id
    })
  },
  clickBuyingGoodsCard(event){
    let index = event.currentTarget.dataset.index;
    console.log(index);
    let that = this;
    let dataList = that.data.goodsBuy[index];
    console.log(dataList);
    let id = dataList.id;
    console.log(id);
    wx.navigateTo({
      url: '/pages/goodsDetailsPage/goodsDetailsPage?id=' + id
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
        url: 'http://120.77.210.142:8080/myGoods/listGoodsBuyingByPageid/1',
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
        console.log(res);
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

  showOverlap: function(event){
    // this.setData({ show: true });
    // this.setData({indexOnsale: event.currentTarget.dataset.index});
    let that = this;
    let index = event.currentTarget.dataset.index;
    console.log(index);
    let goodsList = that.data.goodsOnSale;
    let goodsData = goodsList[index];
    console.log(goodsData);
    let id = goodsData.id;
    console.log(id);
    let title = goodsData.title;
    console.log(title);
    let price = goodsData.price;
    console.log(price);
    let originalPrice = goodsData.originalPrice;
    let imageLink = goodsData.imageLink;
    let condition = goodsData.condition;
    let category = goodsData.category;
    let tagList = goodsData.tagList;
    wx.navigateTo({
      url: '/pages/order/order?id='+id+'&title='+title+'&price='+price+'&originalPrice='+originalPrice+'&imageLink='+imageLink+'&condition='+condition+'&category='+category+'&tagList='+tagList,
    })
    
  },

  onClickHide() {
    this.setData({ show: false });
  },

  noop() {},

  change:function(event){
    this.setData({
      buyerId: event.detail.value
    })
  },

  confirm: function(event){
    let that = this;
    let index = that.data.indexOnsale;
    console.log(index);
    let goodsList = that.data.goodsOnSale;
    let goodsData = goodsList[index];
    console.log(goodsData);
    let id = goodsData.id;
    console.log(id);
    let buyerId = that.data.buyerId;
    console.log(buyerId);
    // wx.request({
    //   url: 'http://120.77.210.142:8080/myGoods/generateOrder/'+id,
    //   headers: {
    //     'Content-Type': 'application/x-www-form-urlencoded'
    //   },
    //   data:{
    //     id: id,
    //     buyerId: buyerId
    //   }

    // })
  },

  deleteGoods: function(event){
    let that = this;
    let index = event.currentTarget.dataset.index;
    console.log(index);
    let goodsList = that.data.goodsOnSale;
    let goodsData = goodsList[index];
    console.log(goodsData);
    let id = goodsData.id;
    console.log(id);
    wx.request({
      url: 'http://120.77.210.142:8080/myGoods/withdrawGoodsById/'+ id,
      method: 'GET',
      dataType: 'json',
      headers: {
        'Content-Type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid')
      },
      success(res){
        console.log(res.data);
        console.log("下架物品");
        that.onLoad();
      }
    })

  }
})