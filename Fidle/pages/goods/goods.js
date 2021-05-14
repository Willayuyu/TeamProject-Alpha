// pages/goods/goods.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    // show: false,
    // indexOnsale:0,
    // input:null,
    tabIndex: 0,
    salePage: 1,
    soldPage: 1,
    buyPage: 1,
    goodsOnSale: [],
    goodsSold: [],
    goodsBuy: [],
    goodsCondition:["全新", "九成新", "八成新", "八成以下"],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({ title: '我的二手' });
    // this.showPromise();
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
    this.showOnSale(1);
    this.showSold(1);
    this.showBuy(1);
    this.setData({
      salePage: 1,
      soldPage: 1,
      buyPage: 1
    });
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
    let pageid;
    switch(this.data.tabIndex) {
      case 0:
        pageid = this.data.salePage;
        pageid++;
        console.log(pageid);
        this.setData({
          salePage: pageid
        })
        this.showOnSale(pageid);
        break;
      case 1:
        pageid = this.data.soldPage;
        pageid++;
        console.log(pageid);
        this.setData({
          soldPage: pageid
        })
        this.showSold(pageid);
        break;
      case 2:
        pageid = this.data.buyPage;
        pageid++;
        console.log(pageid);
        this.setData({
          buyPage: pageid
        })
        this.showBuy(pageid);
        break;
    }
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  /**
   * 点击标题跳转详情页
   */
  clickSaleGoodsCard(event) {
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
  clickSoldGoodsCard(event) {
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
  clickBuyingGoodsCard(event) {
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

  /**
   * 标签点击/切换事件
   */
  tab_Click: function(e) {
    this.data.tabIndex = e.detail.index;
  },

  /**
   * 渲染在售页面
   */
  showOnSale(pageid) {
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id); 
    let that = this;     
    wx.request({
      url: 'http://47.106.241.182:8082/myGoods/listGoodsOnSaleByPageid/' + pageid,
      header: { 'content-type': 'application/json',
       'Cookie': session_id ,
      },
      success(res){
        console.log(res.data.data);
        let list = res.data.data;
        if(res.data.code == 200) {
          if(pageid > 1) {
            list = that.data.goodsOnSale.concat(list);
          }
          that.setData({
            goodsOnSale: list
          })
          console.log("goodsOnSale=")
          console.log(that.data.goodsOnSale)
        }
      }
    })
    // return new Promise(function (resolve, reject) {
    //   wx.request({
    //     url: 'http://120.77.210.142:8080/myGoods/listGoodsOnSaleByPageid/' + this.data.salePage,
    //     method: 'GET',
    //     dataType: 'json',
    //     header: {
    //       'Content-Type': 'application/json',
    //       'Cookie': wx.getStorageSync('sessionid')
    //     },
    //     success: (result) => {

    //       resolve(result);
    //       // console.log(res.data.code);
    //       // console.log(res.data.data); 
    //       // console.log(res.data.data[0]);
    //       // that.setData({
    //       //   dataList: res.data.data,
    //       // });
    //       // console.log(dataList);
    //     },
    //     fail: (err) => {
    //       reject(err);
    //       wx.showToast({ title: '系统错误' })
    //     },
    //   })
    // })
  },

  /**
   * 渲染已售页面
   */
  showSold(pageid) {
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id); 
    let that = this;     
    wx.request({
      url: 'http://47.106.241.182:8082/myGoods/listGoodsSoldByPageid/' + pageid,
      header: { 'content-type': 'application/json',
       'Cookie': session_id ,
      },
      success(res){
        console.log(res.data.data);
        let list = res.data.data;
        if(res.data.code == 200) {
          if(pageid > 1) {
            list = that.data.goodsSold.concat(list);
          }
          that.setData({
            goodsSold: list
          })
          console.log("goodsSold=")
          console.log(that.data.goodsSold)
        }
      }
    })
    // return new Promise(function (resolve, reject) {
    //   wx.request({
    //     url: 'http://120.77.210.142:8080/myGoods/listGoodsSoldByPageid/1',
    //     method: 'GET',
    //     dataType: 'json',
    //     header: {
    //       'Content-Type': 'application/json',
    //       'Cookie': wx.getStorageSync('sessionid')
    //     },
    //     success: (result) => {
    //       resolve(result);
    //       // console.log(res.data.code);
    //       // console.log(res.data.data); 
    //       // console.log(res.data.data[0]);
    //       // that.setData({
    //       //   dataList: res.data.data,
    //       // });
    //       // console.log(dataList);
    //     },
    //     fail: (err) => {
    //       reject(err);
    //       wx.showToast({ title: '系统错误' })
    //     },
    //   })
    // })
  },

  /**
   * 渲染买入界面
   */
  showBuy(pageid) {
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id); 
    let that = this;     
    wx.request({
      url: 'http://120.77.210.142:8080/myGoods/listGoodsBuyingByPageid/' + pageid,
      header: { 'content-type': 'application/json',
       'Cookie': session_id ,
      },
      success(res){
        console.log(res.data.data);
        let list = res.data.data;
        if(res.data.code == 200) {
          if(pageid > 1) {
            list = that.data.goodsBuy.concat(list);
          }
          that.setData({
            goodsBuy: list
          })
          console.log("goodsBuy=")
          console.log(that.data.goodsBuy)
        }
      }
    })
    // return new Promise(function (resolve, reject) {
    //   wx.request({
    //     url: 'http://120.77.210.142:8080/myGoods/listGoodsBuyingByPageid/1',
    //     method: 'GET',
    //     dataType: 'json',
    //     header: {
    //       'Content-Type': 'application/json',
    //       'Cookie': wx.getStorageSync('sessionid')
    //     },
    //     success: (result) => {
    //       resolve(result);
    //       // console.log(res.data.code);
    //       // console.log(res.data.data); 
    //       // console.log(res.data.data[0]);
    //       // that.setData({
    //       //   dataList: res.data.data,
    //       // });
    //       // console.log(dataList);
    //     },
    //     fail: (err) => {
    //       reject(err);
    //       wx.showToast({ title: '系统错误' })
    //     },
    //   })
    // })
  },

  /**
   * 同步获取三个请求结果
   */
  // showPromise() {
  //   let that = this;
  //   Promise.all(
  //     [that.showOnSale(), that.showSold(), that.showBuy()]).then((res) => {
  //       //三个方法回来后的数据
  //       console.log(res);
  //       const [res1, res2, res3] = res;
  //       console.log(res1.data.data);
  //       console.log(res2.data.data);
  //       console.log(res3.data.data);
  //       that.setData({
  //         goodsOnSale: res1.data.data,
  //         goodsSold: res2.data.data,
  //         goodsBuy: res3.data.data
  //       })
  //     });
  // },

  /**
   * 生成订单传值跳转
   */
  showOverlap: function (event) {
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
      url: '/pages/order/order?id=' + id + '&title=' + title + '&price=' + price + '&originalPrice=' + originalPrice + '&imageLink=' + imageLink + '&condition=' + condition + '&category=' + category + '&tagList=' + tagList,
    })

  },

    /**
     * 下架二手物品
     */
  deleteGoods: function (event) {
    let that = this;
    let index = event.currentTarget.dataset.index;
    console.log(index);
    let goodsList = that.data.goodsOnSale;
    let goodsData = goodsList[index];
    console.log(goodsData);
    let id = goodsData.id;
    console.log(id);
    wx.request({
      url: 'http://120.77.210.142:8080/myGoods/withdrawGoodsById/' + id,
      method: 'GET',
      dataType: 'json',
      header: {
        'Content-Type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid')
      },
      success(res) {
        console.log(res.data);
        console.log("下架物品");
        that.onLoad();
      }
    })
  },

  /**
   * 传值跳转修改二手界面
   */
  gotoAlterGoodsPage: function (event) {
    let that = this;
    let index = event.currentTarget.dataset.index;
    console.log(index);
    let goodsList = that.data.goodsOnSale;
    let goodsData = goodsList[index];
    console.log(goodsData);
    let id = goodsData.id;
    console.log(id);
    wx.redirectTo({
      url: '/pages/changeGood/changeGood?id='+id,
    })
  }
})