// pages/taskOrder/taskOrder.js
let app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    radio: 0,
    icon: {
      upnormal: '../../icons/thumbs-up.png',
      upactive: '../../icons/thumbs-upblue.png',
      downnormal: '../../icons/thumbs-down.png',
      downactive: '../../icons/thumbs-downblue.png',
    },

    task: {},
    id: '1',
    taskTitle: '任务标题',
    reward: 1,
    tagList: [],
    category: '',
    acc_id: '',
    hiddenConfirm:false,
    hiddenSubmit:true,
    isAccepter:-1,
    isPublisher:-1
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
    let isPublisher = options.isPublisher;
    let isAccepter = options.isAccepter;
    console.log("isPublisher="+isPublisher+"isAccepter="+isAccepter);
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
      isPublisher:isPublisher,
      isAccepter:isAccepter,
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

  onChange(event) {
    this.setData({
      radio: event.detail,
    });
  },

  change: function (event) {
    this.setData({
      commentwords: event.detail.value
    })
  },

  confirm: function (event) {
    this.setData({
      hiddenConfirm:true,
      hiddenSubmit:false
    })
  },

  submit: function (event) {
    let that = this;
    let id = that.data.id;
    console.log(id);
    let radio = that.data.radio;
    console.log("radio="+radio);
    let commentwords = that.data.commentwords;
    console.log("commentwords:"+commentwords);
    let str = commentwords.trim();
    if(radio!=1&&radio!=-1) {
      wx.showToast({
        icon: 'none',
        title: '您还未选择评价',
      })
      console.log('评价为空'),
      that.setData({
        hiddenConfirm:false,
        hiddenSubmit:true
      })
    }
    else if (str == '' || str == undefined || str == null) {
      wx.showToast({
        icon: 'none',
        title: '评论不可为空',
      })
      console.log('评论内容为空'),
      that.setData({
        hiddenConfirm:false,
        hiddenSubmit:true
      })
    } 
    else {
      wx.showModal({
        content: '确认提交评论吗？',
        success: function (res) {
          if (res.confirm) {
            console.log('用户点击提交');
            if(that.data.isPublisher ==1 && that.data.isAccepter == 0) {//评价任务接受方
              console.log("评价任务接受方");
              wx.request({
                url: 'https://fidle.shawnxixi.icu/myTask/evaluateAccepter/',
                header: {
                  'Content-Type': 'application/x-www-form-urlencoded',
                  'Cookie': wx.getStorageSync('sessionid'),
                  'token': app.globalData.token
                },
                data: {
                  id: id,
                  evaluation: radio,
                  reason: commentwords
                },
                method: 'POST',
                dataType: 'json',
                success(res) {
                  console.log(res.data.code);
                  console.log("任务评价成功");
                  wx.redirectTo({
                    url: '/pages/task/task',
                  })
                },
                fail(err) {
                  reject(err);
                  wx.showToast({ title: '系统错误' })
                },
              })
            }
            else {//评价任务发布方
              console.log("评价任务发布方");
              wx.request({
                url: 'https://fidle.shawnxixi.icu/myTask/evaluatePublisher/',
                header: {
                  'Content-Type': 'application/x-www-form-urlencoded',
                  'Cookie': wx.getStorageSync('sessionid'),
                  'token': app.globalData.token
                },
                data: {
                  id: id,
                  evaluation: radio,
                  reason: commentwords
                },
                method: 'POST',
                dataType: 'json',
                success(res) {
                  console.log(res.data.code);
                  console.log("任务评价成功");
                  wx.redirectTo({
                    url: '/pages/task/task',
                  })
                },
                fail(err) {
                  reject(err);
                  wx.showToast({ title: '系统错误' })
                },
              })
            }            
          } else if (res.cancel) {
            console.log('用户点击取消');
          }
        }
      })
    }
  },
})