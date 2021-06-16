// pages/taskOrder/taskOrder.js
let app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    task: {},
    id: '1',
    taskTitle: '任务标题',
    reward: 1,
    tagList: [],
    category: '',
    acc_id: '',
    hiddenConfirm:false,
    hiddenSubmit:true
    // buyerId: ''
    // taskPrice: '1',
    // imageLink: '1',
    // condition: '1',
    // category: '1',
    // id: 1,
    //   title: '',
    //   reward,
    //   tagList
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let that = this;
    wx.setNavigationBarTitle({ title: '生成订单' })
    let id = options.id;
    let taskTitle = options.title;
    let reward = options.reward;
    let tagList = JSON.parse(options.tagList);
    let category = options.category;
    console.log(id);
    console.log(taskTitle);
    console.log(reward);
    console.log(tagList);
    console.log(category);
    that.setData({
      id: id,
      taskTitle: taskTitle,
      reward: reward,
      tagList: tagList,
      category: category,
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

  change: function (event) {
    this.setData({
      acc_id: event.detail.value
    })
  },
  confirm:function(event){
    this.setData({
      hiddenConfirm:true,
      hiddenSubmit:false
    })
  },

  submit: function (event) {
    let that = this;
    let id = that.data.id;
    console.log(id);
    let acc_id = that.data.acc_id;
    console.log(acc_id);
    let str = acc_id.replace(/(^\s*)|(\s*$)/g, '');
    if (str == "" || str == undefined || str == null) {
      wx.showToast({
        title: 'id不可为空',
      })
      console.log('空')
      that.setData({
        hiddenConfirm:false,
        hiddenSubmit:true
      })
    } else {
      wx.showModal({
        content: '确认提交当前订单吗？',
        success: function (res) {
          //进行退出登录操作：把Storage中的flag置为false
          if (res.confirm) {
            console.log('用户点击确定');
            wx.request({
              url: 'http://47.106.241.182:8082/myTask/conductTask/',
              header: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'Cookie': wx.getStorageSync('sessionid'),
                'token': app.globalData.token
              },
              data: {
                id: id,
                acc_id: acc_id
              },
              method: 'POST',
              dataType: 'json',
              success(res) {
                console.log(res.data.code);
                console.log("生成订单成功");
                wx.redirectTo({
                  url: '/pages/task/task',
                })
              },
              fail(err) {
                reject(err);
                wx.showToast({ title: '系统错误' })
              },
            })
          } else if (res.cancel) {
            console.log('用户点击取消');
          }
        }
      })
    }
  },
})