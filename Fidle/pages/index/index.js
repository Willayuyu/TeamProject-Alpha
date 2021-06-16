// pages/test/test.js
var app = getApp()
Page({
  /**
   * 页面的初始数据
   */
  data: {
    secPr: 0,
    secDe: 0,
    taskPr: 0,
    taskTi: 0,
    acTi: 0,
    searchInput: "",//搜索框内容
    tabIndex: 0,//标签页下标
    secTime: "时间",//二手-时间筛选
    secSort: "类别",//二手-类别筛选
    secDegree: "新旧程度",//二手-新旧筛选
    taskTime: "时间",//任务-时间筛选
    taskSort: "类别",//任务-类别筛选
    activityTime: "时间",//活动-时间筛选
    activitySort: "类别",//活动-类别筛选
    secTimeArray: [
      "时间","近三天","近一天","近七天","近一个月","近三个月"
    ],
    secSortMap: new Map(),//二手类别键值对
    secSortArray: [
      
    ],//二手类别名称
    secDegreeArray: [
      "新旧程度","全新","九成新","八成新","八成新以下"
    ],
    taskTimeArray: [
      "时间","近三天","近一天","近七天","近一个月"
    ],
    taskSortMap: new Map(),//任务类别键值对
    taskSortArray: [
      
    ],//任务类别名称
    activityTimeArray: [
      "时间","近七天","近一天","近三天","近一个月","近三个月"
    ],
    activitySortMap: new Map(),//活动类别键值对
    activitySortArray: [
      
    ],//活动类别名称

    goodsPage: 1,
    taskPage: 1,
    activityPage: 1,

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

  /**
   * 获取搜索框内容
   */
  getInputValue: function(e) { 
    this.data.searchInput = e.detail.value;
  },

  /**
   * 二手-时间筛选事件
   */
  select_Sec_Time: function(e) {
    this.data.secTime = e.detail;
    this.search();
  },

  /**
   * 二手-类别筛选事件
   */
  select_Sec_Sort: function(e) {
    this.data.secSort = e.detail;
    this.search();
  },

  /**
   * 二手-新旧筛选事件
   */
  select_Sec_Degree: function(e) {
    this.data.secDegree = e.detail;
    this.search();
  },

  /**
   * 任务-时间筛选事件
   */
  select_Task_Time: function(e) {
    this.data.taskTime = e.detail;
    this.search();
  },

  /**
   * 任务-类别筛选事件
   */
  select_Task_Sort: function(e) {
    this.data.taskSort = e.detail;
    this.search();
  },

  /**
   * 活动-时间筛选事件
   */
  select_Act_Time: function(e) {
    this.data.activityTime = e.detail;
    this.search();
  },

  /**
   * 活动-类别筛选事件
   */
  select_Act_Sort: function(e) {
    this.data.activitySort = e.detail;
    this.search();
  },

  /**
   * 标签点击/切换事件
   */
  tab_Click: function(e) {
    this.data.tabIndex = e.detail.index;
  },

  /**
   * 搜索二手物品
   */
  search_Sec: function(days, categoryId, condition, keyWord, pageid) {
    let that=this;
    wx.request({
      url: 'https://fidle.shawnxixi.icu/goods/listGoodsByKeyword',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
      },
      data: {
        days: days,
        categoryId: categoryId,
        condition: condition,
        keyWord: keyWord,
        pageid: pageid
      },
      method: "POST",
      success(res){
        console.log(res);
        if(res.data.code == 200){
          var list = res.data.data;//json中的data数组
          console.log(list);
          if(pageid != 1) {
            list = that.data.goodsList.concat(list);
          }
          that.setData({
            goodsList: list
          })
        }
      }
    })
  },

  /**
   * 搜索任务委托
   */
  search_Task: function(days, categoryId, keyWord, pageid) {
    let that=this;
    wx.request({
      url: 'https://fidle.shawnxixi.icu/task/listTaskByKeyword',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
      },
      data: {
        days: days,
        categoryId: categoryId,
        keyWord: keyWord,
        pageid: pageid
      },
      method: "POST",
      success(res){
        console.log(res);
        if(res.data.code == 200){
          var list = res.data.data;//json中的data数组
          console.log(list);
          if(pageid != 1) {
            list = that.data.taskList.concat(list);
          }
          that.setData({
            taskList: list
          })
        }
      }
    })
  },

  /**
   * 搜索活动
   */
  search_Act: function(days, categoryId, keyWord, pageid) {
    let that=this;
    wx.request({
      url: 'https://fidle.shawnxixi.icu/activity/listActivityByKeyword',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
      },
      data: {
        days: days,
        categoryId: categoryId,
        keyWord: keyWord,
        pageid: pageid
      },
      method: "POST",
      success(res){
        console.log(res);
        if(res.data.code == 200){
          var list = res.data.data;//json中的data数组
          console.log(list);
          if(pageid != 1) {
            list = that.data.activityList.concat(list);
          }
          that.setData({
            activityList: list
          })
        }
      }
    })
  },

  /**
   * 获取下拉框的天数
   */
  getDays: function(secTime) {
    var days;
    switch(secTime) {
      case "近三天":
        days = 3;
        break;
      case "近一天":
        days = 1;
        break;
      case "近七天":
        days = 7;
        break;
      case "近一个月":
        days = 30;
        break;
      case "近三个月":
        days = 90;
        break;
      default:
        days = 0;
    }
    return days;
  },

  /**
   * 获取新旧程度值
   */
  getDegree: function(degree) {
    var condition;
    switch(degree) {
      case "新旧程度":
        condition = 0;
        break;
      case "全新":
        condition = 1;
        break;
      case "九成新":
        condition = 2;
        break;
      case "八成新":
        condition = 3;
        break;
      case "八成新以下":
        condition = 4;
        break;
      default:
        condition = 0;
    }
    return condition;
  },

  /**
   * 初始搜索函数（只查第一页）
   */
  searchOne: function() {
    console.log(this.data.searchInput);
    var keyWord = this.data.searchInput;
    switch(this.data.tabIndex) {
      case 0:
        var days = this.getDays(this.data.secTime);
        console.log(days);
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
        var condition = this.getDegree(this.data.secDegree);
        console.log(condition);
        this.search_Sec(days, secSortId, condition, keyWord, this.data.goodsPage);
        break;
      case 1:
        console.log(this.data.taskSort);
        var days = this.getDays((this.data.taskTime));
        console.log(days);
        console.log(this.data.taskSortArray);
        var map = this.data.taskSortMap;
        var taskSortId = 0;
        var taskSort = this.data.taskSort;
        for(let item of map.entries()) {
          if(item[1] == taskSort) {
            taskSortId = item[0];
          }//从map中找到类别对应的数据库Id
        }
        console.log(taskSortId);
        console.log(this.data.taskSort);
        this.search_Task(days, taskSortId, keyWord, this.data.taskPage);
        break;
      case 2:
        console.log(this.data.activityTime);
        console.log(this.data.activitySort);
        var days = this.getDays((this.data.activityTime));
        console.log(days);
        console.log(this.data.activitySortArray);
        var map = this.data.activitySortMap;
        var activitySortId = 0;
        var activitySort = this.data.activitySort;
        for(let item of map.entries()) {
          if(item[1] == activitySort) {
            activitySortId = item[0];
          }//从map中找到类别对应的数据库Id
        }
        console.log(activitySortId);
        console.log(this.data.activitySort);
        this.search_Act(days, activitySortId, keyWord, this.data.activityPage);
        break;
    }
  },


  /**
   * 搜索功能
   */
  search: function() {
    this.setData({
      goodsPage: 1,
      taskPage: 1,
      activityPage: 1
    })
    this.searchOne();
  },

  /**
   * 上拉刷新
   */
  searchPre: function() {
    let pageid;
    switch(this.data.tabIndex) {
      case 0:
        pageid = this.data.goodsPage;
        if(pageid > 1)
          pageid--;
        this.setData({
          goodsPage: pageid
        })
        break;
      case 1:
        pageid = this.data.taskPage;
        if(pageid > 1)
          pageid--;
        this.setData({
          taskPage: pageid
        })
        break;
      case 2:
        pageid = this.data.activityPage;
        if(pageid > 1)
          pageid--;
        this.setData({
          activityPage: pageid
        })
        break;
    }
    this.searchOne();
    console.log(pageid);
  },

  /**
   * 下拉刷新
   */
  searchNext: function() {
    let pageid;
    switch(this.data.tabIndex) {
      case 0:
        pageid = this.data.goodsPage;
        if(pageid < 10)
          pageid++;
        this.setData({
          goodsPage: pageid
        })
        break;
      case 1:
        pageid = this.data.taskPage;
        if(pageid < 10)
          pageid++;
        this.setData({
          taskPage: pageid
        })
        break;
      case 2:
        pageid = this.data.activityPage;
        if(pageid < 10)
          pageid++;
        this.setData({
          activityPage: pageid
        })
        break;
    }
    console.log(pageid);
    this.searchOne();
  },

  /**
   * 联系卖家、委托人
   */
  contact: function() {
    wx.navigateTo({
      url: '/pages/contact/contact',
    })
  },

  /**
   * 二手物品收藏
   */
  storeGoods_collected: function(e) {
    var index = e.currentTarget.dataset.index;
    console.log(index);
    var list = this.data.goodsList;
    var id = list[index].id;
    console.log(id);
    list[index].collectState = 1;
    wx.request({
      url: 'https://fidle.shawnxixi.icu/goods/collectGoods/' + id,
      header: {
        'Content-Type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
      },
      data: {
      },
      method: "GET",
      success(res){
        if(res.data.code == 200){
          console.log("收藏状态修改成功");
        }
      }
    })
    this.setData({
      goodsList: list
    })
  },

  /**
   * 二手物品取消收藏
   */
  storeGoods_uncollected: function(e) {
    var index = e.currentTarget.dataset.index;
    console.log(index);
    var list = this.data.goodsList;
    var id = list[index].id;
    console.log(id);
    list[index].collectState = -1;
    wx.request({
      url: 'https://fidle.shawnxixi.icu/goods/cancelCollectGoods/' + id,
      header: {
        'Content-Type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
      },
      data: {
      },
      method: "GET",
      success(res){
        if(res.data.code == 200){
          console.log("收藏状态修改成功");
        }
      }
    })
    this.setData({
      goodsList: list
    })
  },

  /**
   * 任务收藏
   */
  storeTask_collected: function(e) {
    var index = e.currentTarget.dataset.index;
    console.log(index);
    var list = this.data.taskList;
    var id = list[index].id;
    console.log(id);
    list[index].collectState = 1;
    wx.request({
      url: 'https://fidle.shawnxixi.icu/task/collectTask/' + id,
      header: {
        'Content-Type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
      },
      data: {
      },
      method: "GET",
      success(res){
        if(res.data.code == 200){
          console.log("收藏状态修改成功");
        }
      }
    })
    this.setData({
      taskList: list
    })
  },

  /**
   * 任务取消收藏
   */
  storeTask_uncollected: function(e) {
    var index = e.currentTarget.dataset.index;
    console.log(index);
    var list = this.data.taskList;
    var id = list[index].id;
    console.log(id);
    list[index].collectState = -1;
    wx.request({
      url: 'https://fidle.shawnxixi.icu/task/cancelCollectTask/' + id,
      header: {
        'Content-Type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
      },
      data: {
      },
      method: "GET",
      success(res){
        if(res.data.code == 200){
          console.log("收藏状态修改成功");
        }
      }
    })
    this.setData({
      taskList: list
    })
  },

  /**
   * 活动收藏
   */
  storeAct_collected: function(e) {
    var index = e.currentTarget.dataset.index;
    console.log(index);
    var list = this.data.activityList;
    var id = list[index].id;
    console.log(id);
    list[index].collectState = 1;
    wx.request({
      url: 'https://fidle.shawnxixi.icu/activity/collectActivity/' + id,
      header: {
        'Content-Type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
      },
      data: {
      },
      method: "GET",
      success(res){
        if(res.data.code == 200){
          console.log("收藏状态修改成功");
        }
      }
    })
    this.setData({
      activityList: list
    })
  },

  /**
   * 活动取消收藏
   */
  storeAct_uncollected: function(e) {
    var index = e.currentTarget.dataset.index;
    console.log(index);
    var list = this.data.activityList;
    var id = list[index].id;
    console.log(id);
    list[index].collectState = -1;
    wx.request({
      url: 'https://fidle.shawnxixi.icu/activity/cancelCollectActivity/' + id,
      header: {
        'Content-Type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
      },
      data: {
      },
      method: "GET",
      success(res){
        if(res.data.code == 200){
          console.log("收藏状态修改成功");
        }
      }
    })
    this.setData({
      activityList: list
    })
  },

  /**
   * 点击标题跳转详情页
   */
  clickGoodsCard(event) {
    let index = event.currentTarget.dataset.index;
    let id;
    let that = this;
    var list = that.data.goodsList[index];//json中的data数组
    console.log(list);
    id = list.id;
    wx.navigateTo({
      url: '/pages/goodsDetailsPage/goodsDetailsPage?id='+id,
    })
  },
  clickTaskCard(event) {
    let index = event.currentTarget.dataset.index;
    let id;
    let that = this;
    var list = that.data.taskList[index];//json中的data数组
    console.log(list);
    id = list.id;
    wx.navigateTo({
      url: '/pages/taskDetailsPage/taskDetailsPage?id='+id,
    })
  },
  clickActivityCard(event) {
    let index = event.currentTarget.dataset.index;
    let id;
    let that = this;
    var list = that.data.activityList[index];//json中的data数组
    console.log(list);
    id = list.id;
    wx.navigateTo({
      url: '/pages/activityDetailsPage/activityDetailsPage?id='+id,
    })
  },
  
  /**
   * 数组去空值 
   */
  removeEmpty: function(arr) {   
    for(var i = 0; i < arr.length; i++) {
     if(arr[i] == "" || typeof(arr[i]) == "undefined") {
        arr.splice(i,1);
        i = i - 1; // i - 1 ,因为空元素在数组下标 2 位置，删除空之后，后面的元素要向前补位
      }
     }
     return arr;
  },

  /**
   * 获取二手物品类别列表
   */
  getGoodsCategory: function() {
    let that=this;
    wx.request({
      
      url: 'https://fidle.shawnxixi.icu/goods/listGoodsCategory',
      header: {
        'Content-Type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
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

  /**
   * 获取任务委托类别列表
   */
  getTaskCategory: function() {
    let that=this;
    wx.request({
      url: 'https://fidle.shawnxixi.icu/task/listTaskCategory',
      header: {
        'Content-Type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
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

  /**
   * 获取活动类别列表
   */
  getActivityCategory: function() {
    let that=this;
    wx.request({
      url: 'https://fidle.shawnxixi.icu/activity/listActivityCategory',
      header: {
        'Content-Type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
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

  /**
   * 获取二手物品列表
   */
  getGoodsList: function(days, categoryId, condition, pageid) {
    let that = this;
    wx.request({
      url: 'https://fidle.shawnxixi.icu/goods/listGoods',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
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

  /**
   * 获取任务物品列表
   */
  getTaskList: function(days, categoryId, pageid) {
    let that = this;
    wx.request({
      url: 'https://fidle.shawnxixi.icu/task/listTask',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
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

  /**
   * 获取活动列表
   */
  getActivityList: function(days, categoryId, pageid) {
    let that = this;
    wx.request({
      url: 'https://fidle.shawnxixi.icu/activity/listActivity',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
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
    // this.getGoodsCategory();//渲染二手类别下拉框
    // this.getTaskCategory();//渲染任务类别下拉框
    // this.getActivityCategory();//渲染活动类别下拉框
    // this.getGoodsList(0,0,0,1);//初始二手列表
    // this.getTaskList(0,0,1);//初始任务列表
    // this.getActivityList(0,0,1);//初始活动列表
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
    this.getGoodsCategory();//渲染二手类别下拉框
    this.getTaskCategory();//渲染任务类别下拉框
    this.getActivityCategory();//渲染活动类别下拉框
    this.getGoodsList(0,0,0,1);//初始二手列表
    this.getTaskList(0,0,1);//初始任务列表
    this.getActivityList(0,0,1);//初始活动列表
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
    this.searchNext();
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  /**
   * 联系卖家
   */
  goodsConnect: function(event){
    let index = event.currentTarget.dataset.index;
    console.log(index);
    let that = this;
    let dataList = that.data.goodsList[index];
    console.log(dataList);
    let sellerId =  dataList.sellerId;
    console.log(sellerId);
    wx.navigateTo({ 
      url: '/pages/contact/contact?pubId='+ sellerId
    }) 
  },

  /**
   * 联系委托人
   */
  taskConnect: function(event){
    let index = event.currentTarget.dataset.index;
    console.log(index);
    let that = this;
    let dataList = that.data.taskList[index];
    console.log(dataList);
    let  pulisherId =  dataList. pulisherId;
    console.log( pulisherId);
    wx.navigateTo({
      url: '/pages/contact/contact?pubId='+  pulisherId,
    })
  },

  /**
   * 二手价格排序
   */
  rankAPSec: function(days, categoryId, condition, keyWord, pageid) {
    let that=this;
    for(let i = 1; i <= pageid; i++) {
      wx.request({
        url: 'https://fidle.shawnxixi.icu/goods/sortGoods/priceAsc',
        header: {
          'Content-Type': 'application/x-www-form-urlencoded',
          'Cookie': wx.getStorageSync('sessionid'),
          'token': app.globalData.token
        },
        data: {
          days: days,
          categoryId: categoryId,
          condition: condition,
          keyWord: keyWord,
          pageid: pageid
        },
        method: "POST",
        success(res){
          console.log(res);
          if(res.data.code == 200){
            var list = res.data.data;//json中的data数组
            console.log(list);
            if(i != 1) {
              list = that.data.goodsList.concat(list);
            }
            that.setData({
              goodsList: list
            })
          }
        }
      })
    }
    console.log("二手价格升序");
  },

  rankDPSec: function(days, categoryId, condition, keyWord, pageid) {
    let that=this;
    for(let i = 1; i <= pageid; i++) {
      wx.request({
        url: 'https://fidle.shawnxixi.icu/goods/sortGoods/priceDesc',
        header: {
          'Content-Type': 'application/x-www-form-urlencoded',
          'Cookie': wx.getStorageSync('sessionid'),
          'token': app.globalData.token
        },
        data: {
          days: days,
          categoryId: categoryId,
          condition: condition,
          keyWord: keyWord,
          pageid: pageid
        },
        method: "POST",
        success(res){
          console.log(res);
          if(res.data.code == 200){
            var list = res.data.data;//json中的data数组
            console.log(list);
            if(i != 1) {
              list = that.data.goodsList.concat(list);
            }
            that.setData({
              goodsList: list
            })
          }
        }
      })
    }
    console.log("二手价格降序");
  },

  rankPSec: function() {
    var keyWord = this.data.searchInput;
    var days = this.getDays(this.data.secTime);
    console.log(days);
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
    var condition = this.getDegree(this.data.secDegree);
    console.log(condition);
    if(this.data.secPr == 0) {
      this.rankAPSec(days, secSortId, condition, keyWord, this.data.goodsPage);
      this.setData({
        secPr: 1
      })
    } else {
      this.rankDPSec(days, secSortId, condition, keyWord, this.data.goodsPage);
      this.setData({
        secPr: 0
      })
    }
  },

  /**
   * 二手新旧排序
   */
  rankADSec: function(days, categoryId, condition, keyWord, pageid) {
    let that=this;
    for(let i = 1; i <= pageid; i++) {
      wx.request({
        url: 'https://fidle.shawnxixi.icu/goods/sortGoods/conditionAsc',
        header: {
          'Content-Type': 'application/x-www-form-urlencoded',
          'Cookie': wx.getStorageSync('sessionid'),
          'token': app.globalData.token
        },
        data: {
          days: days,
          categoryId: categoryId,
          condition: condition,
          keyWord: keyWord,
          pageid: pageid
        },
        method: "POST",
        success(res){
          console.log(res);
          if(res.data.code == 200){
            var list = res.data.data;//json中的data数组
            console.log(list);
            if(i != 1) {
              list = that.data.goodsList.concat(list);
            }
            that.setData({
              goodsList: list
            })
          }
        }
      })
    }
    console.log("二手新旧升序");
  },

  rankDDSec: function(days, categoryId, condition, keyWord, pageid) {
    let that=this;
    for(let i = 1; i <= pageid; i++) {
      wx.request({
        url: 'https://fidle.shawnxixi.icu/goods/sortGoods/conditionDesc',
        header: {
          'Content-Type': 'application/x-www-form-urlencoded',
          'Cookie': wx.getStorageSync('sessionid'),
          'token': app.globalData.token
        },
        data: {
          days: days,
          categoryId: categoryId,
          condition: condition,
          keyWord: keyWord,
          pageid: pageid
        },
        method: "POST",
        success(res){
          console.log(res);
          if(res.data.code == 200){
            var list = res.data.data;//json中的data数组
            console.log(list);
            if(i != 1) {
              list = that.data.goodsList.concat(list);
            }
            that.setData({
              goodsList: list
            })
          }
        }
      })
    }
    console.log("二手新旧降序");
  },

  rankDSec: function() {
    var keyWord = this.data.searchInput;
    var days = this.getDays(this.data.secTime);
    console.log(days);
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
    var condition = this.getDegree(this.data.secDegree);
    console.log(condition);
    if(this.data.secDe == 0) {
      this.rankADSec(days, secSortId, condition, keyWord, this.data.goodsPage);
      this.setData({
        secDe: 1
      })
    } else {
      this.rankDDSec(days, secSortId, condition, keyWord, this.data.goodsPage);
      this.setData({
        secDe: 0
      })
    }
  },

  /**
   * 任务酬劳排序
   */
  rankAPTask: function(days, categoryId, keyWord, pageid) {
    let that=this;
    for(let i = 1; i <= pageid; i++) {
      wx.request({
        url: 'https://fidle.shawnxixi.icu/task/sortTask/rewardAsc',
        header: {
          'Content-Type': 'application/x-www-form-urlencoded',
          'Cookie': wx.getStorageSync('sessionid'),
          'token': app.globalData.token
        },
        data: {
          days: days,
          categoryId: categoryId,
          keyWord: keyWord,
          pageid: i
        },
        method: "POST",
        success(res){
          console.log(res);
          if(res.data.code == 200){
            var list = res.data.data;//json中的data数组
            console.log(list);
            if(i != 1) {
              list = that.data.taskList.concat(list);
            }
            that.setData({
              taskList: list
            })
          }
        }
      })
    }
    console.log("任务酬劳升序");
  },

  rankDPTask: function(days, categoryId, keyWord, pageid) {
    let that=this;
    for(let i = 1; i <= pageid; i++) {
      wx.request({
        url: 'https://fidle.shawnxixi.icu/task/sortTask/rewardDesc',
        header: {
          'Content-Type': 'application/x-www-form-urlencoded',
          'Cookie': wx.getStorageSync('sessionid'),
          'token': app.globalData.token
        },
        data: {
          days: days,
          categoryId: categoryId,
          keyWord: keyWord,
          pageid: i
        },
        method: "POST",
        success(res){
          console.log(res);
          if(res.data.code == 200){
            var list = res.data.data;//json中的data数组
            console.log(list);
            if(i != 1) {
              list = that.data.taskList.concat(list);
            }
            that.setData({
              taskList: list
            })
          }
        }
      })
    }
    console.log("任务酬劳降序");
  },

  rankPTask: function() {
    var keyWord = this.data.searchInput;
    console.log(this.data.taskSort);
        var days = this.getDays((this.data.taskTime));
        console.log(days);
        console.log(this.data.taskSortArray);
        var map = this.data.taskSortMap;
        var taskSortId = 0;
        var taskSort = this.data.taskSort;
        for(let item of map.entries()) {
          if(item[1] == taskSort) {
            taskSortId = item[0];
          }//从map中找到类别对应的数据库Id
        }
        console.log(taskSortId);
        console.log(this.data.taskSort);
    if(this.data.taskPr == 0) {
      this.rankAPTask(days, taskSortId, keyWord, this.data.taskPage);
      this.setData({
        taskPr: 1
      })
    } else {
      this.rankDPTask(days, taskSortId, keyWord, this.data.taskPage);
      this.setData({
        taskPr: 0
      })
    }
  },

  /**
   * 任务时间排序
   */
  rankADTask: function(days, categoryId, keyWord, pageid) {
    let that=this;
    for(let i = 1; i <= pageid; i++) {
      wx.request({
        url: 'https://fidle.shawnxixi.icu/task/sortTask/dateAsc',
        header: {
          'Content-Type': 'application/x-www-form-urlencoded',
          'Cookie': wx.getStorageSync('sessionid'),
          'token': app.globalData.token
        },
        data: {
          days: days,
          categoryId: categoryId,
          keyWord: keyWord,
          pageid: i
        },
        method: "POST",
        success(res){
          console.log(res);
          if(res.data.code == 200){
            var list = res.data.data;//json中的data数组
            console.log(list);
            if(i != 1) {
              list = that.data.taskList.concat(list);
            }
            that.setData({
              taskList: list
            })
          }
        }
      })
    }
    console.log("任务时间升序");
  },

  rankDDTask: function(days, categoryId, keyWord, pageid) {
    let that=this;
    for(let i = 1; i <= pageid; i++) {
      wx.request({
        url: 'https://fidle.shawnxixi.icu/task/sortTask/dateDesc',
        header: {
          'Content-Type': 'application/x-www-form-urlencoded',
          'Cookie': wx.getStorageSync('sessionid'),
          'token': app.globalData.token
        },
        data: {
          days: days,
          categoryId: categoryId,
          keyWord: keyWord,
          pageid: i
        },
        method: "POST",
        success(res){
          console.log(res);
          if(res.data.code == 200){
            var list = res.data.data;//json中的data数组
            console.log(list);
            if(i != 1) {
              list = that.data.taskList.concat(list);
            }
            that.setData({
              taskList: list
            })
          }
        }
      })
    }
    console.log("任务时间降序");
  },

  rankDTask: function() {
    var keyWord = this.data.searchInput;
    console.log(this.data.taskSort);
        var days = this.getDays((this.data.taskTime));
        console.log(days);
        console.log(this.data.taskSortArray);
        var map = this.data.taskSortMap;
        var taskSortId = 0;
        var taskSort = this.data.taskSort;
        for(let item of map.entries()) {
          if(item[1] == taskSort) {
            taskSortId = item[0];
          }//从map中找到类别对应的数据库Id
        }
        console.log(taskSortId);
        console.log(this.data.taskSort);
    if(this.data.taskTi == 0) {
      this.rankADTask(days, taskSortId, keyWord, this.data.taskPage);
      this.setData({
        taskTi: 1
      })
    } else {
      this.rankDDTask(days, taskSortId, keyWord, this.data.taskPage);
      this.setData({
        taskTi: 0
      })
    }
  },

  /**
   * 活动时间排序
   */
  rankADActivity: function(days, categoryId, keyWord, pageid) {
    let that=this;
    for(let i = 1; i <= pageid; i++) {
      wx.request({
        url: 'https://fidle.shawnxixi.icu/activity/sortActivity/dateAsc',
        header: {
          'Content-Type': 'application/x-www-form-urlencoded',
          'Cookie': wx.getStorageSync('sessionid'),
          'token': app.globalData.token
        },
        data: {
          days: days,
          categoryId: categoryId,
          keyWord: keyWord,
          pageid: i
        },
        method: "POST",
        success(res){
          console.log(res);
          if(res.data.code == 200){
            var list = res.data.data;//json中的data数组
            console.log(list);
            if(i != 1) {
              list = that.data.activityList.concat(list);
            }
            that.setData({
              activityList: list
            })
          }
        }
      })
    }
    console.log("活动时间升序");
  },

  rankDDActivity: function(days, categoryId, keyWord, pageid) {
    let that=this;
    for(let i = 1; i <= pageid; i++) {
      wx.request({
        url: 'https://fidle.shawnxixi.icu/activity/sortActivity/dateDesc',
        header: {
          'Content-Type': 'application/x-www-form-urlencoded',
          'Cookie': wx.getStorageSync('sessionid'),
          'token': app.globalData.token
        },
        data: {
          days: days,
          categoryId: categoryId,
          keyWord: keyWord,
          pageid: i
        },
        method: "POST",
        success(res){
          console.log(res);
          if(res.data.code == 200){
            var list = res.data.data;//json中的data数组
            console.log(list);
            if(i != 1) {
              list = that.data.activityList.concat(list);
            }
            that.setData({
              activityList: list
            })
          }
        }
      })
    }
    console.log("活动时间降序");
  },

  rankDActivity: function() {
    var keyWord = this.data.searchInput;
    console.log(this.data.activityTime);
        console.log(this.data.activitySort);
        var days = this.getDays((this.data.activityTime));
        console.log(days);
        console.log(this.data.activitySortArray);
        var map = this.data.activitySortMap;
        var activitySortId = 0;
        var activitySort = this.data.activitySort;
        for(let item of map.entries()) {
          if(item[1] == activitySort) {
            activitySortId = item[0];
          }//从map中找到类别对应的数据库Id
        }
        console.log(activitySortId);
        console.log(this.data.activitySort);
    console.log(this.acTi);
    if(this.data.acTi == 0) {
      this.rankADActivity(days, activitySortId, keyWord, this.data.activityPage);
      this.setData({
        acTi: 1
      })
    } else {
      this.rankDDActivity(days, activitySortId, keyWord, this.data.activityPage);
      this.setData({
        acTi: 0
      })
    }
  },

})


