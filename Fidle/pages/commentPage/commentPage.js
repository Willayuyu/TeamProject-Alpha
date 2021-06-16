let app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    radio: 0,
    icon: {
      upnormal: '../../icons/thumbs-up.png',
      upactive: '../../icons/thumbs-upblue.png',
      downnormal: '../../icons/thumbs-down.png',
      downactive: '../../icons/thumbs-downblue.png',
    },

    id: '',
    title: '',
    price: '',
    originalPrice: '',
    imageLink: '',
    condition: '',
    category: '',
    tagList: [

    ],
    commentwords: '',
    hiddenConfirm:false,
    hiddenSubmit:true,
    isSold:-1,
    isBuy:-1
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let that = this;
    wx.setNavigationBarTitle({ title: '评价' })
    let id = options.id;
    console.log(id);
    let title = options.title;
    console.log(title);
    let price = options.price;
    console.log(price);
    let originalPrice = options.originalPrice;
    let imageLink = options.imageLink;
    let condition = options.condition;
    let category = options.category;
    let tagList = JSON.parse(options.tagList);
    let isSold = options.isSold;
    let isBuy = options.isBuy;
    console.log("issold="+isSold+"isbuy="+isBuy);
    that.setData({
      id: id,
      price: price,
      title: title,
      originalPrice: originalPrice,
      imageLink: imageLink,
      condition: condition,
      category: category,
      tagList: tagList,
      isSold: isSold,
      isBuy: isBuy,
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

  onChange(event) {
    this.setData({
      radio: event.detail,
    });
  },

  change: function (event) {
    this.setData({
      commentwords: event.detail.value
    })
  },

  confirm: function (event) {
    this.setData({
      hiddenConfirm:true,
      hiddenSubmit:false
    })
  },

  submit: function (event) {
    let that = this;
    let id = that.data.id;
    console.log(id);
    let radio = that.data.radio;
    console.log("radio="+radio);
    let commentwords = that.data.commentwords;
    console.log("commentwords:"+commentwords);
    let str = commentwords.trim();
    if(radio!=1&&radio!=-1) {
      wx.showToast({
        icon: 'none',
        title: '您还未选择评价',
      })
      console.log('评价为空'),
      that.setData({
        hiddenConfirm:false,
        hiddenSubmit:true
      })
    }
    else if (str == '' || str == undefined || str == null) {
      wx.showToast({
        icon: 'none',
        title: '评论不可为空',
      })
      console.log('评论内容为空'),
      that.setData({
        hiddenConfirm:false,
        hiddenSubmit:true
      })
    } 
    else {
      wx.showModal({
        content: '确认提交评论吗？',
        success: function (res) {
          if (res.confirm) {
            console.log('用户点击提交');
            if(that.data.isSold ==1 && that.data.isBuy == 0) {//评价买家
              console.log("评价买家");
              wx.request({
                url: 'http://47.106.241.182:8082/myGoods/evaluateBuyer/',
                header: {
                  'Content-Type': 'application/x-www-form-urlencoded',
                  'Cookie': wx.getStorageSync('sessionid'),
                  'token': app.globalData.token
                },
                data: {
                  id: id,
                  evaluation: radio,
                  reason: commentwords
                },
                method: 'POST',
                dataType: 'json',
                success(res) {
                  console.log(res.data.code);
                  console.log("订单评价成功");
                  wx.redirectTo({
                    url: '/pages/goods/goods',
                  })
                },
                fail(err) {
                  reject(err);
                  wx.showToast({ title: '系统错误' })
                },
              })
            }
            else {//评价卖家
              console.log("评价卖家");
              wx.request({
                url: 'http://47.106.241.182:8082/myGoods/evaluateSeller/',
                header: {
                  'Content-Type': 'application/x-www-form-urlencoded',
                  'Cookie': wx.getStorageSync('sessionid'),
                  'token': app.globalData.token
                },
                data: {
                  id: id,
                  evaluation: radio,
                  reason: commentwords
                },
                method: 'POST',
                dataType: 'json',
                success(res) {
                  console.log(res.data.code);
                  console.log("订单评价成功");
                  wx.redirectTo({
                    url: '/pages/goods/goods',
                  })
                },
                fail(err) {
                  reject(err);
                  wx.showToast({ title: '系统错误' })
                },
              })
            }            
          } else if (res.cancel) {
            console.log('用户点击取消');
          }
        }
      })
    }
  },
})