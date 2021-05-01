// pages/index/index.js
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
    taskPrice: "30",
    taskTitle: "找人拿快递 3小件 送到41号楼",
    taskTagsList: [
      "拿快递",
      "顺丰"
    ],
    activityImageURL: "http://5b0988e595225.cdn.sohucs.com/images/20190311/ab66040c529445778cf31ced4ba24657.jpeg",
    activityTitle: "百米画卷",
    address: "青春广场",
    date: "2021年4月23日",
    oganizer: "2018级软件工程3班",
    activityTagsList: [
      "团立项",
      "五四活动"
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //wx.setNavigationBarTitle({ title: '首页' });  
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


  /**
   * 获取二手物品列表
   */
  getSecondhandList(){
    // let that=this;
    // wx.request({
    //   url: 'url',
    //   success(res){
    //     console.log(res);
    //     if(res.data.code===0){
    //       that.setData({
    //         secondhandList:res.data.data.list
    //       })

    //     }
    //   }
    // })
  }
})