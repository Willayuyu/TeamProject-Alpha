// pages/comments/comments.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    active:1,
    good_secondhand_cmt:[
      {
        imgsrc:"../../images/photo.jpg",
        username:"Fidle1",
        cmtdate:"2021-04-01",
        cmtcontent:"很好很好的卖家，物美价廉，货真价实。",
      },
      {
        imgsrc:"../../images/photo.jpg",
        username:"Fidle2",
        cmtdate:"2021-04-02",
        cmtcontent:"这是测试的好评语句。",
      },
    ],
    bad_secondhand_cmt:[
      {
        imgsrc:"../../images/photo.jpg",
        username:"Fidle1",
        cmtdate:"2021-04-01",
        cmtcontent:"这是测试的差评语句1。测试测试测试测试测试测试测试测试测试测试",
      },
      {
        imgsrc:"../../images/photo.jpg",
        username:"Fidle2",
        cmtdate:"2021-04-02",
        cmtcontent:"这是测试的差评语句2。",
      },
    ],
    good_mission_cmt:[
      {
        imgsrc:"../../images/photo.jpg",
        username:"Fidle1",
        cmtdate:"2021-04-01",
        cmtcontent:"能够按时完成任务，很好！",
      },
      {
        imgsrc:"../../images/photo.jpg",
        username:"Fidle2",
        cmtdate:"2021-04-02",
        cmtcontent:"这是测试的任务好评语句。",
      },
    ],
    bad_mission_cmt:[
      {
        imgsrc:"../../images/photo.jpg",
        username:"Fidle1",
        cmtdate:"2021-04-01",
        cmtcontent:"这是测试的任务差评语句1。测试测试测试测试测试测试测试测试测试测试",
      },
      {
        imgsrc:"../../images/photo.jpg",
        username:"Fidle2",
        cmtdate:"2021-04-02",
        cmtcontent:"这是测试的任务差评语句2。",
      },
    ],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({ title: '评论列表' })  
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