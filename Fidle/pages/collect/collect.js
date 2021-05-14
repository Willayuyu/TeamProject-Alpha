// pages/collect/collect.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    goodsList: [
      // {
      // "collectState": 1,
      // "condition": 3,
      // "description": "旧了",
      // "id": 3,
      // "originalPrice": 111,
      // "picturesLink": [
      //   "http://47.106.241.182:8083/fidle/20210511150926_1.png",
      //   "http://47.106.241.182:8083/fidle/20210512124904_47JJ9unTBvE745195903c2d9fb1ffdf08f784d987671.png"],
      // "price": 11,
      // "pubId": 3,
      // "tagList": [{
      //   "content":
      //     "标签1",
      //   "id": 1
      // }],
      // "title": "衣服"
      // }
    ],
    taskList: [
    //   {
    //   "category": "做高数",
    //   "collectState": 1,
    //   "description": "打死不给钱",
    //   "endTime": "2021-05-26 16:55:08",
    //   "id": 3, "pubId": 3,
    //   "reward": 2,
    //   "startTime": "2021-05-25 16:55:02",
    //   "tagList": [{
    //     "content": "标签3",
    //     "id": 3
    //   }],
    //   "title": "要饭"
    // }
    ],
    activityList: [
      // { 
      // "category": "班级活动", 
      // "collectState": 1, 
      // "description": "班级活动描述1", 
      // "endTime": "2021-05-20 21:35:59", 
      // "id": 4, 
      // "picturesLink": ["http://47.106.241.182:8083/fidle/20210512214558_jWaJvl9wFX51872eac70d631b1fd32ca4fb9d395b5b1.png"], 
      // "pubId": 2, 
      // "startTime": "2021-05-10 21:35:59", 
      // "tagList": [{ 
      //   "content": "有志愿时长", 
      //   "id": 1 }, 
      //   { "content": "有德育", 
      //   "id": 3 }], 
      //   "title": "班级活动1" 
      // }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({ title: '我的收藏' });
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
    this.showPromise();
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
    this.showPromise();
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  /**
   * 点击标题跳转详情页
   */
  clickGoodsCard(event) {
    let index = event.currentTarget.dataset.index;
    console.log(index);
    let that = this;
    let dataList = that.data.goodsList[index];
    console.log(dataList);
    let id = dataList.id;
    console.log(id);
    wx.navigateTo({
      url: '/pages/goodsDetailsPage/goodsDetailsPage?id=' + id
    })
  },
  clickTaskCard(event) {
    let index = event.currentTarget.dataset.index;
    console.log(index);
    let that = this;
    let dataList = that.data.taskList[index];
    console.log(dataList);
    let id = dataList.id;
    console.log(id);
    wx.navigateTo({
      url: '/pages/taskDetailsPage/taskDetailsPage?id=' + id
    })
  },
  clickActivityCard(event) {
    let index = event.currentTarget.dataset.index;
    console.log(index);
    let that = this;
    let dataList = that.data.activityList[index];
    console.log(dataList);
    let id = dataList.id;
    console.log(id);
    wx.navigateTo({
      url: '/pages/activityDetailsPage/activityDetailsPage?id=' + id
    })
  },

  /**
   * 请求获取收藏的二手物品
   */
  showGoods() {
    return new Promise(function (resolve, reject) {
      wx.request({
        url: 'http://47.106.241.182:8082/collection/listCollectibleGoodsByPageid/1',
        method: 'GET',
        dataType: 'json',
        header: {
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

  /**
   * 请求获取收藏的任务
   */
  showTask() {
    return new Promise(function (resolve, reject) {
      wx.request({
        url: 'http://47.106.241.182:8082/collection/listCollectibleTaskByPageid/1',
        method: 'GET',
        dataType: 'json',
        header: {
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

  /**
   * 请求获取收藏的活动
   */
  showActivity() {
    return new Promise(function (resolve, reject) {
      wx.request({
        url: 'http://47.106.241.182:8082/collection/listCollectibleActivityByPageid/1',
        method: 'GET',
        dataType: 'json',
        header: {
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

  /**
   * 同步获取三个请求的结果
   */
  showPromise() {
    let that = this;
    Promise.all(
      [that.showGoods(), that.showTask(), that.showActivity()]).then((res) => {
        //三个方法回来后的数据
        console.log(res.data);
        const [res1, res2, res3] = res;
        console.log(res1.data.data);
        console.log(res2.data.data);
        console.log(res3.data.data);
        that.setData({
          goodsList: res1.data.data,
          taskList: res2.data.data,
          activityList: res3.data.data
        })
      });
  },

  /***
   * 联系卖家
   */
  goodsConnect: function (event) {
    let index = event.currentTarget.dataset.index;
    console.log(index);
    let that = this;
    let dataList = that.data.goodsList[index];
    console.log(dataList);
    let pubId = dataList.pubId;
    console.log(pubId);
    wx.navigateTo({
      url: '/pages/contact/contact?pubId=' + pubId
    })
  },

  /**
   * 联系委托人
   */
  taskConnect: function (event) {
    let index = event.currentTarget.dataset.index;
    console.log(index);
    let that = this;
    let dataList = that.data.taskList[index];
    console.log(dataList);
    let pubId = dataList.pubId;
    console.log(pubId);
    wx.navigateTo({
      url: '/pages/contact/contact?pubId=' + pubId
    }) 
  },

  /**
   * 二手物品取消收藏
   */
  goodsCollect: function(event){
    let index = event.currentTarget.dataset.index;
    console.log(index);
    let that = this;
    let list = that.data.goodsList;
    let dataList = that.data.goodsList[index];
    console.log(dataList);
    let id = dataList.id;
    console.log(id);
    dataList.collectState = -1;
    wx.request({
      url: 'http://47.106.241.182:8082/goods/cancelCollectGoods/' + id,
      header: {
        'Content-Type': 'application/json'
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
   * 任务取消收藏
   */
  taskCollect: function(event){
    let index = event.currentTarget.dataset.index;
    console.log(index);
    let that = this;
    let list = that.data.taskList;
    let dataList = that.data.taskList[index];
    console.log(dataList);
    let id = dataList.id;
    console.log(id);
    dataList.collectState = -1;
    wx.request({
      url: 'http://47.106.241.182:8082/task/cancelCollectTask/' + id,
      header: {
        'Content-Type': 'application/json'
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
   * 活动取消收藏
   */
  activityCollect: function(event){
    let index = event.currentTarget.dataset.index;
    console.log(index);
    let that = this;
    let list = that.data.activityList
    let dataList = that.data.activityList[index];
    console.log(dataList);
    let id = dataList.id;
    console.log(id);
    dataList.collectState = -1;
    wx.request({
      url: 'http://47.106.241.182:8082/activity/cancelCollectActivity/' + id,
      header: {
        'Content-Type': 'application/json'
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
  }
})