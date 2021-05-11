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
    secSortMap: new Map(),//二手类别键值对
    secSortArray: [
      
    ],//二手类别名称
    secDegreeArray: [
      "新旧程度","全新","九成新","八成新","八成新以下"
    ],
    taskTimeArray: [
      "近三天","近一天","近七天","近一个月"
    ],
    taskSortMap: new Map(),//任务类别键值对
    taskSortArray: [
      
    ],//任务类别名称
    activityTimeArray: [
      "近七天","近一天","近三天","近一个月","近三个月"
    ],
    activitySortMap: new Map(),//活动类别键值对
    activitySortArray: [
      
    ],//活动类别名称

    goodsList: [ {
      "category":"鞋子",
      "collectState":0,
      "condition":1,
      "id":1,
      "imageLink":"13213",
      "originalPrice":6,
      "price":4,
      "sellerId":1,
      "tagList":
          [
              {
                  "content":"hhhhh",
                  "id":1
              }
          ],
      "title":"hhh"
  }],//二手物品列表

    goodsDetialsURL: "/pages/goodsDetailsPage/goodsDetailsPage",

    taskList: [{
      "category":"取快递",
      "collectState":0,
      "id":1,
      "pulisherId":1,
      "reward":4,
      "tagList":
          [
              {
                  "content":"hhhhh",
                  "id":1
              },
              {
                  "content":"xixixi",
                  "id":2
              }
          ],
      "title":"hhh"
  }],


    activityDetialsURL: "/pages/activityDetailsPage/activityDetailsPage",
    
    activityList: [{
      "category":"XXX",
      "collectState":0,
      "id":1,
      "imageLink":"",
      "tagList":
          [
              {
                  "content":"hhhhh",
                  "id":1
              },
              {
                  "content":"xixixixi",
                  "id":2
              }
          ],
      "title":"hhh"
  }]
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
    switch(this.data.tabIndex) {
      case 0:
        console.log(this.data.secTime);
        console.log(this.data.secSortArray);
        var map = this.data.secSortMap;
        var secSortId = 0;
        var secSort = this.data.secSort;
        for(let item of map.entries()) {
          if(item[1] == secSort) {
            secSortId = item[0];
          }//从map中找到类别对应的数据库Id
        }
        console.log(secSortId);
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
  
  //数组去空值
  removeEmpty: function(arr) {   
    for(var i = 0; i < arr.length; i++) {
     if(arr[i] == "" || typeof(arr[i]) == "undefined") {
        arr.splice(i,1);
        i = i - 1; // i - 1 ,因为空元素在数组下标 2 位置，删除空之后，后面的元素要向前补位
      }
     }
     return arr;
  },

  //获取二手物品类别列表
  getGoodsCategory: function() {
    let that=this;
    wx.request({
      url: 'http://47.106.241.182:8082/goods/listGoodsCategory',
      header: {
        'Content-Type': 'application/json'
      },
      data: {
      },
      method: "GET",
      success(res){
        if(res.data.code == 200){
          var map = new Map();
          var array = []; 
          var list = res.data.data;//json中的data数组
          for(var i in list) {
            var category = list[i].categoryDesignation;
            var id = list[i].categoryId;
            array.push(category);
            map.set(id,category);//遍历其中的categoryDesignation并插入
          }
          that.removeEmpty(array);
          that.setData({
            secSortArray : array,
            secSortMap: map
          })
        }
      }
    })
  },

  //获取任务委托类别列表
  getTaskCategory: function() {
    let that=this;
    wx.request({
      url: 'http://47.106.241.182:8082/task/listTaskCategory',
      header: {
        'Content-Type': 'application/json'
      },
      data: {
      },
      method: "GET",
      success(res){
        if(res.data.code == 200){
          var map = new Map();
          var array = []; 
          var list = res.data.data;//json中的data数组
          for(var i in list) {
            var category = list[i].categoryDesignation;
            var id = list[i].categoryId;
            array.push(category);
            map.set(id,category);//遍历其中的categoryDesignation并插入
          }
          that.removeEmpty(array);
          that.setData({
            taskSortArray : array,
            taskSortMap: map
          })
        }
      }
    })
  },

  //获取活动类别列表
  getActivityCategory: function() {
    let that=this;
    wx.request({
      url: 'http://47.106.241.182:8082/activity/listActivityCategory',
      header: {
        'Content-Type': 'application/json'
      },
      data: {
      },
      method: "GET",
      success(res){
        if(res.data.code == 200){
          var map = new Map();
          var array = []; 
          var list = res.data.data;//json中的data数组
          for(var i in list) {
            var category = list[i].categoryDesignation;
            var id = list[i].categoryId;
            array.push(category);
            map.set(id,category);//遍历其中的categoryDesignation并插入
          }
          that.removeEmpty(array);
          that.setData({
            activitySortArray : array,
            activitySortMap: map
          })
        }
      }
    })
  },

  //获取二手物品列表
  getGoodsList: function(days, categoryId, condition, pageid) {
    let that = this;
    wx.request({
      url: 'http://47.106.241.182:8082/goods/listGoods',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      data: {
        days: days,
        categoryId: categoryId,
        condition: condition,
        pageid: pageid
      },
      method: "POST",
      success(res){
        console.log(res);
        if(res.data.code == 200){
          var list = res.data.data;//json中的data数组
          console.log(list);
          that.setData({
            goodsList: list
          })
        }
      }
    })
  },

  //获取任务物品列表
  getTaskList: function(days, categoryId, pageid) {
    let that = this;
    wx.request({
      url: 'http://47.106.241.182:8082/task/listTask',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      data: {
        days: days,
        categoryId: categoryId,
        pageid: pageid
      },
      method: "POST",
      success(res){
        console.log(res);
        if(res.data.code == 200){
          var list = res.data.data;//json中的data数组
          console.log(list);
          that.setData({
            taskList: list
          })
        }
      }
    })
  },

  //获取活动列表
  getActivityList: function(days, categoryId, pageid) {
    let that = this;
    wx.request({
      url: 'http://47.106.241.182:8082/activity/listActivity',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      data: {
        days: days,
        categoryId: categoryId,
        pageid: pageid
      },
      method: "POST",
      success(res){
        console.log(res);
        if(res.data.code == 200){
          var list = res.data.data;//json中的data数组
          console.log(list);
          that.setData({
            activityList: list
          })
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getGoodsCategory();//渲染二手类别下拉框
    this.getTaskCategory();//渲染任务类别下拉框
    this.getActivityCategory();//渲染活动类别下拉框
    this.getGoodsList(3,1,9,1);//初始二手列表
    this.getTaskList(3,1,1);//初始任务列表
    this.getActivityList(7,1,1);//初始活动列表
    console.log(this.data.goodsList);
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