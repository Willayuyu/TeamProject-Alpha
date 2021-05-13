// pages/order/order.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    id: '',
    title: '',
    price: '',
    originalPrice: '',
    imageLink: '',
    condition: '',
    category: '',
    tagList: [

    ],
    buyerId: ''

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let that = this;
    wx.setNavigationBarTitle({ title: '生成订单' })
    let id = options.id;
    console.log(id);
    let title = options.title;
    console.log(title);
    let price = options.price;
    console.log(price);
    let  originalPrice = options.originalPrice;
    let imageLink = options.imageLink;
    let condition = options.condition;
    let category = options.category;
    let tagList = options.tagList;
    that.setData({
      id: id,
      price: price,
      title: title,
      originalPrice:  originalPrice,
      imageLink: imageLink,
      condition: condition,
      category: category,
      tagList: tagList
    })
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

  },

  change: function (event) {
    this.setData({
      buyerId: event.detail.value
    })
  },

  confirm: function (event) {
    let that = this;
    let id = that.data.id;
    console.log(id);
    let buyerId = that.data.buyerId;
    console.log(buyerId);
    wx.showModal({
      content: '确认生成当前订单吗？',
      success: function (res) {
        //进行退出登录操作：把Storage中的flag置为false
        if (res.confirm) {
          console.log('用户点击确定');
          wx.request({
            url: 'http://120.77.210.142:8080/myGoods/generateOrder/',
            header: {
              'Content-Type': 'application/x-www-form-urlencoded',
              'Cookie': wx.getStorageSync('sessionid')
            },
            data: {
              id: id,
              buyerId: buyerId
            },
            method: 'POST',
            dataType: 'json',
            success(res) {
              console.log(res.data.code);
              console.log("生成订单成功");
              wx.redirectTo({
                url: '/pages/goods/goods',
              })
            },
            fail(err) {
              reject(err);
              wx.showToast({ title: '系统错误' })
            },
          })
        } else if (res.cancel) {
          console.log('用户点击取消');
        }
      }
    })
  },
})