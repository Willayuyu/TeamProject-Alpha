// pages/activity/activity.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    activityImageURL: "http://5b0988e595225.cdn.sohucs.com/images/20190311/ab66040c529445778cf31ced4ba24657.jpeg",
    activityTitle: "百米画卷",
    address: "青春广场",
    date: "2021年4月23日",
    oganizer: "2018级软件工程3班",
    activityTagsList: [
      "团立项",
      "五四活动"
    ],
    activityDetailsURL: "/pages/activityDetailsPage/activityDetailsPage",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({ title: '我的活动' }); 
    // this.getPublishedActivityList(); 
    // this.doDeleteActivity();
    this.doAlterActivity();
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
  clickActivityCard(event){
    wx.navigateTo({
      url: '/pages/activityDetailsPage/activityDetailsPage',
    })
  },

  /**
   * 获取已发布活动记录列表
   */
  getPublishedActivityList(){
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id);      
    wx.request({
      url: 'http://120.77.210.142:8080/myActivity/listActivityPublishedByPageid/1',
      header: { 'content-type': 'application/json',
       'Cookie': session_id ,
      },
      success(res){
        console.log("获取已发布活动记录列表")
        console.log(res.data.data)
      }
    })
  },

  /**
   * 删除活动
   */
  doDeleteActivity(){
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id);      
    wx.request({
      url: 'http://120.77.210.142:8080/myActivity/deleteActivityById/1',
      header: { 'content-type': 'application/json',
       'Cookie': session_id ,
      },
      success(res){
        console.log("删除活动");
        console.log(res.data);
      }
    })
  },

  /**
   * 修改活动
   * 
   * 参数名  	必选	类型    	说明
    id    	  是	bigint  	活动id
    title 	  是	String  	标题
    address	  是	String	  活动地点
    start_time	是	Datetime	开始时间
    end_time	是	Datetime	结束时间
    category	是	int	      类别
    description	是	String	详细描述
    images  	是	String[]	图片id数组
    tags	    是	String[]	标签数组
   */
  doAlterActivity(){
    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id); 
     
    wx.request({
      url: 'http://120.77.210.142:8080/myActivity/alterActivity',
      method: 'POST',
      header: { 'content-type': 'application/x-www-form-urlencoded',
       'Cookie': session_id ,
      },
      data: {
        id: 1,
        title: "修改后的标题",
        address: "修改后的活动地点",
        start_time: 1620087200000,
        end_time: 1620087200000,
        category: 1,
        description: "修改后的详细描述",
        images: ["img1","img2"],
        tags: ["修改1","修改2"]
      },
      success(res){
        console.log("修改活动");
        console.log(res.data);
      }
    })
  },
})