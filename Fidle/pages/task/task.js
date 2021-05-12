// pages/task/task.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
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
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({ title: '我的任务' });
    // this.getPublishedTaskList();
    // this.getAcceptedTaskList();   
    // this.doConductTask();
    // this.doDeleteTask();
    // this.doFinishTask();
    // this.doCancelTask();
    // this.doAlterTask();
    // this.doEvaluateTaskPublisher();
    this.doEvaluateTaskAccepter();
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
   * 点击标题跳转详情页
   */
  clickTaskCard(event){
    wx.navigateTo({
      url: '/pages/taskDetailsPage/taskDetailsPage',
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
   * 获取已发布任务记录列表
   */
  getPublishedTaskList(){
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id);      
    wx.request({
      url: 'http://120.77.210.142:8080/myTask/listTaskPublishedByPageid/1',
      header: { 'content-type': 'application/json',
       'Cookie': session_id ,
      },
      success(res){
        console.log("获取已发布任务记录列表")
        console.log(res.data.data)
      }
    })
  },

  /**
   * 获取已接受任务记录列表
   */
  getAcceptedTaskList(){
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id);      
    wx.request({
      url: 'http://120.77.210.142:8080/myTask/listTaskAcceptedByPageid/1',
      header: { 'content-type': 'application/json',
       'Cookie': session_id ,
      },
      success(res){
        console.log("获取已发布任务记录列表");
        console.log(res.data.data);
      }
    })
  },

  /**
   * 进行任务
   * 
   * id	任务委托id
   * acc_id 接收方id 
   */
  doConductTask(){
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id); 
     
    wx.request({
      url: 'http://120.77.210.142:8080/myTask/conductTask',
      method: 'POST',
      header: { 'content-type': 'application/x-www-form-urlencoded',
       'Cookie': session_id ,
      },
      data: {
        id: 1,
        acc_id: 1,
      },
      success(res){
        console.log("进行任务");
        console.log(res.data);
      }
    })
  },

  /**
   * 删除任务
   */
  doDeleteTask(){
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id);      
    wx.request({
      url: 'http://120.77.210.142:8080/myTask/deleteTaskById/1',
      header: { 'content-type': 'application/json',
       'Cookie': session_id ,
      },
      success(res){
        console.log("删除任务");
        console.log(res.data);
      }
    })
  },

  /**
   * 完成任务
   */
  doFinishTask(){
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id);      
    wx.request({
      url: 'http://120.77.210.142:8080/myTask/finishTaskById/1',
      header: { 'content-type': 'application/json',
       'Cookie': session_id ,
      },
      success(res){
        console.log("完成任务");
        console.log(res.data);
      }
    })
  },

   /**
   * 取消任务
   */
  doCancelTask(){
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id);      
    wx.request({
      url: 'http://120.77.210.142:8080/myTask/cancelTaskById/1',
      header: { 'content-type': 'application/json',
       'Cookie': session_id ,
      },
      success(res){
        console.log("取消任务");
        console.log(res.data);
      }
    })
  },

   /**
   * 修改任务
   * 
   * 参数名	必选	  类型	    说明
    id	    是	  bigint	  任务委托项id
    title	  是	  String	  标题
    reward	是  	decimal	  酬劳
    pub_id	是  	bigint	  发布者id
    description	是	String	详细描述
    category	是	bigint	  类别
    start_time	是	Datetime	开始时间
    end_time	是	Datetime	结束时间
    tags  	是	  String[]	标签数组
   */
  doAlterTask(){
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id); 
     
    wx.request({
      url: 'http://120.77.210.142:8080/myTask/alterTask/',
      method: 'POST',
      header: { 'content-type': 'application/x-www-form-urlencoded',
       'Cookie': session_id ,
      },
      data: {
        id: 1,
        title: "修改后的标题",
        reward: 30,
        pub_id: 1,
        description: "修改后的详细描述",
        category: 1,
        start_time: 1620087200000,
        end_time: 1620087200000,
        tags: ["修改1","修改2"]
      },
      success(res){
        console.log("修改任务");
        console.log(res.data);
      }
    })
  },

  /**
   * 评价委托发布方
   * 
   * 参数名	    必选	类型	  说明
    id    	    是	bigint	任务委托项id
    evaluation	是	int	    是否好评
    reason	    是	String	评价内容
   */
  doEvaluateTaskPublisher(){
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id); 
     
    wx.request({
      url: 'http://120.77.210.142:8080/myTask/evaluatePublisher',
      method: 'POST',
      header: { 'content-type': 'application/x-www-form-urlencoded',
       'Cookie': session_id ,
      },
      data: {
        id: 1,
        evaluation: 1,
        reason: "评价委托发布方的一条评价",
      },
      success(res){
        console.log("评价委托发布方");
        console.log(res.data);
      }
    })
  },

  /**
   * 评价委托接受方
   * 
   * 参数名	    必选	类型	  说明
    id    	    是	bigint	任务委托项id
    evaluation	是	int	    是否好评
    reason	    是	String	评价内容
   */
  doEvaluateTaskAccepter(){
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id); 
     
    wx.request({
      url: 'http://120.77.210.142:8080/myTask/evaluateAccepter',
      method: 'POST',
      header: { 'content-type': 'application/x-www-form-urlencoded',
       'Cookie': session_id ,
      },
      data: {
        id: 1,
        evaluation: 1,
        reason: "评价委托接受方的一条评价",
      },
      success(res){
        console.log("评价委托接受方");
        console.log(res.data);
      }
    })
  },



})