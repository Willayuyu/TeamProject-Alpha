// pages/taskDetailsPage/taskDetailsPage.js
import Toast from '../../components/lib/toast/toast';
Page({

  /**
   * 页面的初始数据
   */
  data: {
    tagsList: [],
    title: "",
    price: 0,
    description: "",
    collectState: 0,
    category: "",
    beginTime: "",
    endTime: "",
    pubId: 0,
    id: 0,
  },

  /**
   * 获取任务详情页信息
   */
  getTaskDetail:function(){
    let that=this;
    //let id = event.id;
    var session_id = wx.getStorageSync('sessionid');
    var header = {'content-type': 'application/x-www-form-urlencoded', 'Cookie': session_id };
    wx.request({
      url: 'http://47.106.241.182:8080/task/getTaskDetailById/' + 2,
      method: "GET",
      header: header,
      success(res){
        console.log(res.data);
        if(res.data.code===200){
          that.setData({
            title: res.data.data.title,
            price: res.data.data.reward,
            category: res.data.data.category,
            tagsList: res.data.data.tagList,
            collectState: res.data.data.collectState,
            description: res.data.data.description,
            beginTime: res.data.data.startTime,
            endTime: res.data.data.endTime,
            pubId: res.data.data.pubId,
            id:res.data.data.id,
          })
        }
      },
      fail(err){
        console.log(err);
      }
    })
  },
  /**
   * 点击home图标跳转首页
   */
  onClickHome(event){
    wx.switchTab({
      url: '/pages/index/index',
    })
  },
  /**
   * 点击收藏变色
   */
  onClickStar(event){
    let that = this;
    var session_id = wx.getStorageSync('sessionid');
    var header = {'content-type': 'application/x-www-form-urlencoded', 'Cookie': session_id };
    wx.request({
      url: 'http://47.106.241.182:8080/task/collectTask/' + 2,
      method: 'GET',
      header: header,
      success(res){
        console.log(res);
        if(res.data.code===200){
          if(that.data.collectState == 0){
            that.setData({
              collectState: 1
            });
            Toast({
              position: 'bottom',
              message: '收藏成功！'
            });
          } else {
            that.setData({
              collectState: 0
            });
            Toast({
              position: 'bottom',
              message: '取消收藏成功！'
            });
          }
        }
      }
    })
  },
  /**
   * 点击联系委托人跳转
   */
  contact: function() {
    let that = this;
    wx.navigateTo({
      url: '/pages/contact/contact?pubId=' + that.data.pubId,
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getTaskDetail();
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