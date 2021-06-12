// pages/task/task.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    tabIndex: 0,
    publishPage: 1,
    acceptPage: 1,
    publishedTaskList: [],
    acceptedTaskList: [],
    taskPrice: "30",
    taskTitle: "找人拿快递 3小件 送到41号楼",
    taskTagsList: [
      "拿快递",
      "顺丰"
    ],
    state: [
      "未接收",
      "进行中",
      "已完成"
    ],
    
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({ title: '我的任务' });
    this.getPublishedTaskList(1);
    this.getAcceptedTaskList(1); 
    console.log('token='+app.globalData.token);  
    // this.doConductTask();
    // this.doDeleteTask();
    // this.doFinishTask();
    // this.doCancelTask();
    // this.doAlterTask();
    // this.doEvaluateTaskPublisher();
    // this.doEvaluateTaskAccepter();
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
    this.getPublishedTaskList(1);
    this.getAcceptedTaskList(1);
    this.setData({
      publishPage: 1
    });
    this.setData({
      acceptPage: 1
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
        pageid = this.data.publishPage;
        pageid++;
        console.log(pageid);
        this.setData({
          publishPage: pageid
        })
        this.getPublishedTaskList(pageid);
        break;
      case 1:
        pageid = this.data.acceptPage;
        pageid++;
        console.log(pageid);
        this.setData({
          acceptPage: pageid
        })
        this.getAcceptedTaskList(pageid);
        break;
    }
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  /**
   * 标签点击/切换事件
   */
  tab_Click: function(e) {
    this.data.tabIndex = e.detail.index;
  },

  /**
   * 点击标题跳转详情页
   */
  clickPublishTaskCard(event) {
    let index = event.currentTarget.dataset.index;
    let id;
    let pubId;
    wx.request({
      url: 'http://47.106.241.182:8080/myTask/listTaskPublishedByPageid/1',
      method: 'GET',
      dataType: 'json',
      data: {
        'id': id,
        'pubId': pubId
      },
      headers: {
        'Content-Type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
      },
      success: (res) => {
        console.log(index);
        let dataList = res.data.data[index];
        console.log(dataList);
        id = dataList.id;
        pubId = dataList.pub_Id;
        console.log(id);
        console.log(pubId);
        wx.navigateTo({
          url: '/pages/taskDetailsPage/taskDetailsPage?id='+id,
        })
      },
      fail: (err) => {
        wx.showToast({ title: '系统错误' })
      },
    })
  },
  clickAcceptTaskCard(event) {
    let index = event.currentTarget.dataset.index;
    let id;
    let pubId;
    wx.request({
      url: 'http://47.106.241.182:8080/myTask/listTaskPublishedByPageid/1',
      method: 'GET',
      dataType: 'json',
      data: {
        'id': id,
        'pubId': pubId
      },
      headers: {
        'Content-Type': 'application/json',
        'Cookie': wx.getStorageSync('sessionid'),
        'token': app.globalData.token
      },
      success: (res) => {
        console.log(index);
        let dataList = res.data.data[index];
        console.log(dataList);
        id = dataList.id;
        pubId = dataList.pub_Id;
        console.log(id);
        console.log(pubId);
        wx.navigateTo({
          url: '/pages/taskDetailsPage/taskDetailsPage?id='+id,
        })
      },
      fail: (err) => {
        wx.showToast({ title: '系统错误' })
      },
    })
  },

  /**
   * 点击图标跳转修改页
   */
  clickTaskModify(event){
    wx.navigateTo({
      url: '/pages/publish/publish',
    })
  },

  /**
   * 
   * @param {*} pageid 
   */
  Refresh(pageid) {
    this.getPublishedTaskList(pageid);
  },

  /**
   * 获取已发布任务记录列表
   */
  getPublishedTaskList(pageid){
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id); 
    let that = this;     
    wx.request({
      //url: 'http://47.106.241.182:8080/myTask/listTaskPublishedByPageid/'+ pageid,
      url: 'http://120.77.210.142:8080/myTask/listTaskPublishedByPageid/'+ pageid,
      header: { 'content-type': 'application/json',
       'Cookie': session_id ,
       'token': app.globalData.token
      },
      success(res){
        console.log("获取已发布任务记录列表")
        console.log(res.data.data);
        let list = res.data.data;
        if(res.data.code == 200) {
          if(pageid > 1) {
            list = that.data.publishedTaskList.concat(list);
          }
          that.setData({
            publishedTaskList: list
          })
          console.log("publishedTaskList=")
          console.log(that.data.publishedTaskList)
          // console.log(that.data.publishedTaskList[0].tagList)
        }
      }
    })
  },

  /**
   * 获取已接受任务记录列表
   */
  getAcceptedTaskList(pageid){
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id);  
    let that = this;        
    wx.request({
      //url: 'http://47.106.241.182:8080/myTask/listTaskAcceptedByPageid/' + pageid,
      url: 'http://120.77.210.142:8080/myTask/listTaskAcceptedByPageid/' + pageid,
      header: { 'content-type': 'application/json',
       'Cookie': session_id ,
       'token': app.globalData.token
      },
      success(res){
        console.log("获取已接受任务记录列表");
        console.log(res.data.data);
        let list = res.data.data;
        if(res.data.code == 200) {
          if(pageid > 1) {
            list = that.data.acceptedTaskList.concat(list);
          }
          that.setData({
            acceptedTaskList: list
          })
          console.log("acceptedTaskList=")
          console.log(that.data.acceptedTaskList)
        }
      }
    })
  },

  /**
   * 进行任务
   * 
   * id	任务委托id
   * acc_id 接收方id 
   */
  doConductTask(e) {
    // 传递的参数
    let id = e.currentTarget.dataset['index'];
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id); 
    console.log("进行id为"+id+"的任务");
    let that = this;
    wx.request({
      url: 'http://47.106.241.182:8080/myTask/conductTask',
      method: 'POST',
      header: { 'content-type': 'application/x-www-form-urlencoded',
       'Cookie': session_id ,
       'token': app.globalData.token
      },
      data: {
        id: 1,
        acc_id: 1,
      },
      success(res){
        console.log("进行任务");
        console.log(res.data);
        // that.onLoad();
      }
    })
  },

  /**
   * 删除任务
   */
  doDeleteTask(e){
    // 传递的参数
    let id = e.currentTarget.dataset['index'];
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id);   
    console.log("删除id为"+id+"的任务"); 
    let that = this;   
    wx.request({
      url: 'http://47.106.241.182:8080/myTask/deleteTaskById/'+id,
      header: { 'content-type': 'application/json',
       'Cookie': session_id ,
       'token': app.globalData.token
      },
      success(res){
        if(res.data.code==200) {
          console.log("删除任务");
          console.log(res.data);
          // that.getPublishedTaskList();
          that.onLoad();
        }
      }
    })
  },

  /**
   * 完成任务
   */
  doFinishTask(e) {
    // 传递的参数
    let id = e.currentTarget.dataset['index'];
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id); 
    console.log("完成id为"+id+"的任务");   
    let that = this;   
    wx.request({
      url: 'http://47.106.241.182:8080/myTask/finishTaskById/'+id,
      header: { 'content-type': 'application/json',
       'Cookie': session_id ,
       'token': app.globalData.token
      },
      success(res){
        if(res.data.code==200) {
          console.log("完成任务");
          console.log(res.data);
          // that.getPublishedTaskList();
          that.onLoad();
        }
      }
    })
  },

   /**
   * 取消任务
   */
  doCancelTask(e){
    // 传递的参数
    let id = e.currentTarget.dataset['index'];
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id);      
    console.log("取消id为"+id+"的任务");
    let that = this; 
    wx.request({
      url: 'http://47.106.241.182:8080/myTask/cancelTaskById/'+id,
      header: { 'content-type': 'application/json',
       'Cookie': session_id ,
       'token': app.globalData.token
      },
      success(res){
        console.log(res.data);
        if(res.data.code==200) {
          console.log("取消任务");
          console.log(res.data);
          // that.getPublishedTaskList();
          that.onLoad();
        }
      }
    })
  },

  showOverlap: function(event){
    this.setData({indexOnsale: event.currentTarget.dataset.index});
    console.log("showOverlap");
    // this.setData({ show: true });
    // this.setData({indexOnsale: event.currentTarget.dataset.index});
    let that = this;
    //获得下标
    let index = event.currentTarget.dataset.index;
    console.log(index);
    console.log('that.data.publishedTaskList');
    
    let taskList = that.data.publishedTaskList;
    console.log(taskList);
    let task = taskList[index];
    console.log('task');
    console.log(task);
    console.log('tagList=');
    console.log(task.tagList);
    console.log('/pages/taskOrder/taskOrder?id='+task.id+'&title='+task.title+
    '&reward='+task.reward+'&tagList='+JSON.stringify(task.tagList)+'&category='+task.category);
    wx.navigateTo({
      url: '/pages/taskOrder/taskOrder?id='+task.id+'&title='+task.title+
      '&reward='+task.reward+'&tagList='+JSON.stringify(task.tagList)+'&category='+task.category,
      // ?i
      // d='+id+'&title='+title+'&price='+price+'&originalPrice='+originalPrice+'&imageLink='+imageLink+'&condition='+condition+'&category='+category+'&tagList='+tagList,
    })
    
  },

  /**
   * 跳转到修改任务页
   */
  gotoAlterTaskPage(e) {
    // 传递的参数
    let id = e.currentTarget.dataset['index'];
    console.log("修改id为"+id+"的活动");
    wx.redirectTo({
      url: '/pages/changeTask/changeTask?id=' + id,
    })
    //修改页写好了改

    /**
     * 跳转页面中参数的获取
      js

      // 生命周期函数--监听页面加载
        onLoad: function (options) {
          console.log(options.e_id) // 即上一个界面传过来的值
        },
     */
  },

  /**
   * 评价任务接受方
   */
  gotoComment1: function(event){
    this.setData({indexOnsale: event.currentTarget.dataset.index});
    console.log("评价任务接受方");
    let that = this;
    //获得下标
    let index = event.currentTarget.dataset.index;
    console.log(index);
    console.log('that.data.publishedTaskList');
    
    let taskList = that.data.publishedTaskList;
    console.log(taskList);
    let task = taskList[index];
    console.log('task');
    console.log(task);
    console.log('tagList=');
    console.log(task.tagList);
    console.log('/pages/taskOrder/taskOrder?id='+task.id+'&title='+task.title+
    '&reward='+task.reward+'&tagList='+JSON.stringify(task.tagList)+'&category='+task.category);
    wx.navigateTo({
      url: '/pages/taskcommentPage/taskcommentPage?id='+task.id+'&title='+task.title+
      '&reward='+task.reward+'&tagList='+JSON.stringify(task.tagList)+'&category='+task.category+'&isPublisher=1&isAccepter=0',
    })
  },

  /**
   * 评价任务发布方
   */
  gotoComment2: function(event){
    this.setData({indexOnsale: event.currentTarget.dataset.index});
    console.log("评价任务发布方");
    let that = this;
    //获得下标
    let index = event.currentTarget.dataset.index;
    console.log(index);
    console.log('that.data.acceptedTaskList');
    
    let taskList = that.data.acceptedTaskList;
    console.log(taskList);
    let task = taskList[index];
    console.log('task');
    console.log(task);
    console.log('tagList=');
    console.log(task.tagList);
    console.log('/pages/taskOrder/taskOrder?id='+task.id+'&title='+task.title+
    '&reward='+task.reward+'&tagList='+JSON.stringify(task.tagList)+'&category='+task.category);
    wx.navigateTo({
      url: '/pages/taskcommentPage/taskcommentPage?id='+task.id+'&title='+task.title+
      '&reward='+task.reward+'&tagList='+JSON.stringify(task.tagList)+'&category='+task.category+'&isPublisher=0&isAccepter=1',
    })
  },
})