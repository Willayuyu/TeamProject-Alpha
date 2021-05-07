// pages/test/test.js
Page({
  /**
   * 页面的初始数据
   */
  data: {
    searchInput: "",//搜索框内容
    tabIndex: 0,//标签页下标
    secTime: "近三天",//二手-时间筛选
    secSort: "类别",//二手-类别筛选
    secDegree: "新旧程度",//二手-新旧筛选
    taskTime: "近三天",//任务-时间筛选
    taskSort: "类别",//任务-类别筛选
    activityTime: "近七天",//活动-时间筛选
    activitySort: "类别",//活动-类别筛选
    secTimeArray: [
      "近三天","近一天","近七天","近一个月","近三个月"
    ],
    secSortArray: [
      "类别","服饰","鞋子","生活用品","电子产品","书籍",
      "电动车","其他"
    ],
    secDegreeArray: [
      "新旧程度","全新","九成新","八成新","八成新以下"
    ],
    taskTimeArray: [
      "近三天","近一天","近七天","近一个月"
    ],
    taskSortArray: [
      "类别","取快递","填写问卷","考试辅导","食堂带饭","其他"
    ],
    activityTimeArray: [
      "近七天","近一天","近三天","近一个月","近三个月"
    ],
    activitySortArray: [
      "类别","团立项","社团活动","比赛","招聘会","其他"
    ],

    goodsStore: "&nbsp;收&nbsp;&nbsp;藏&nbsp;",
    goodsPrice: "30",
    goodsOriginPrice: "75",
    goodsTitle: "软件工程 第八版 全新未拆封 好价速来！",
    goodsImageURL: "/images/book.png",
    goodsDetialsURL: "/pages/goodsDetailsPage/goodsDetailsPage",
    goodsTagsList: [
      "全新",
      "教材",
      "大三",
      "软件工程"
    ],

    taskStore: "&nbsp;收&nbsp;&nbsp;藏&nbsp;",
    taskPrice: "30",
    taskTitle: "找人拿快递 3小件 送到41号楼",
    taskTagsList: [
      "拿快递",
      "顺丰"
    ],

    activityStore: "&nbsp;收&nbsp;&nbsp;藏&nbsp;",
    activityImageURL: "http://5b0988e595225.cdn.sohucs.com/images/20190311/ab66040c529445778cf31ced4ba24657.jpeg",
    activityDetialsURL: "/pages/activityDetailsPage/activityDetailsPage",
    activityTitle: "百米画卷",
    address: "青春广场",
    date: "2021年4月23日",
    oganizer: "2018级软件工程3班",
    activityTagsList: [
      "团立项",
      "五四活动"
    ]
  },

  //获取搜索框内容
  getInputValue: function(e) { 
    this.data.searchInput = e.detail.value;
  },

  //二手-时间筛选事件
  select_Sec_Time: function(e) {
    this.data.secTime = e.detail;
    this.search();
  },

  //二手-类别筛选事件
  select_Sec_Sort: function(e) {
    this.data.secSort = e.detail;
    this.search();
  },

  //二手-新旧筛选事件
  select_Sec_Degree: function(e) {
    this.data.secDegree = e.detail;
    this.search();
  },

  //任务-时间筛选事件
  select_Task_Time: function(e) {
    this.data.taskTime = e.detail;
    this.search();
  },

  //任务-类别筛选事件
  select_Task_Sort: function(e) {
    this.data.taskSort = e.detail;
    this.search();
  },

  //活动-时间筛选事件
  select_Act_Time: function(e) {
    this.data.activityTime = e.detail;
    this.search();
  },

  //活动-类别筛选事件
  select_Act_Sort: function(e) {
    this.data.activitySort = e.detail;
    this.search();
  },

  //标签点击/切换事件
  tab_Click: function(e) {
    this.data.tabIndex = e.detail.index;
  },

  //搜索
  search: function() {
    console.log(this.data.searchInput);
    console.log(this.data.tabIndex);
    switch(this.data.tabIndex) {
      case 0:
        console.log(this.data.secTime);
        console.log(this.data.secSort);
        console.log(this.data.secDegree);
        break;
      case 1:
        console.log(this.data.taskTime);
        console.log(this.data.taskSort);
        break;
      case 2:
        console.log(this.data.activityTime);
        console.log(this.data.activitySort);
        break;
    }
  },

  //联系卖家、委托人
  contact: function() {
    wx.navigateTo({
      url: '/pages/contact/contact',
    })
  },

  //二手物品收藏、取消收藏
  storeGoods: function() {
    var nowStore = this.data.goodsStore;
    if(nowStore == "&nbsp;收&nbsp;&nbsp;藏&nbsp;")
      nowStore = "已收藏";
    else
      nowStore = "&nbsp;收&nbsp;&nbsp;藏&nbsp;";
    this.setData({
      goodsStore: nowStore
    })
    console.log(this.data.goodsStore);
  },

  //任务收藏、取消收藏
  storeTask: function() {
    var nowStore = this.data.taskStore;
    if(nowStore == "&nbsp;收&nbsp;&nbsp;藏&nbsp;")
      nowStore = "已收藏";
    else
      nowStore = "&nbsp;收&nbsp;&nbsp;藏&nbsp;";
    this.setData({
      taskStore: nowStore
    })
    console.log(this.data.taskStore);
  },

  //活动收藏、取消收藏
  storeActivity: function() {
    var nowStore = this.data.activityStore;
    if(nowStore == "&nbsp;收&nbsp;&nbsp;藏&nbsp;")
      nowStore = "已收藏";
    else
      nowStore = "&nbsp;收&nbsp;&nbsp;藏&nbsp;";
    this.setData({
      activityStore: nowStore
    })
    console.log(this.data.activityStore);
  },
  /**
   * 点击标题跳转详情页
   */
  clickGoodsCard(event){
    wx.navigateTo({
      url: '/pages/goodsDetailsPage/goodsDetailsPage',
    })
  },
  clickTaskCard(event){
    wx.navigateTo({
      url: '/pages/taskDetailsPage/taskDetailsPage',
    })
  },
  clickActivityCard(event){
    wx.navigateTo({
      url: '/pages/activityDetailsPage/activityDetailsPage',
    })
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
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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