// pages/login/login.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: {},
    hasUserInfo: false,
    canIUseGetUserProfile: false,
    user: {},
    token: "",
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

  },
  onLoad() {
    console.log("hasuserinfo="+this.hasUserInfo)
    let that = this;
    //1 wx.login获取code
    wx.login({
      success (res) {
        if (res.code) {
          console.log('res.code='+res.code)
          //2 发起网络请求,获取token和用户信息
          wx.request({
            url: 'http://47.106.241.182:8080/login/loginRequest',
            method: 'POST',
            data:{code: res.code},
            header: {
              'content-type': 'application/x-www-form-urlencoded',
            },
            success: (res) => {
              console.log(res)
              // 把数据存下来
              that.setData({
                user: res.data.user,
                token: res.data.token,
              }) 
            },
            fail:function(err){
              console.log('fail')
              console.log(err)
            },
            //先注释掉第二个请求
            /*
            complete: function () { 
              //不论成功还是失败都会到这里面。第二个请求放在第一个请求的complete里面                         
              try {
                console.log('that.user.nickname='+that.user.nickname)
                //3 判断是否用户信息中的nickname和portrait为空
                if(that.user.nickname=="" && that.user.portrait=="") {
                  //3.1 为空，则用户为第一次登录
                  //必须留在当前页面，进行授权
                  if (wx.getUserProfile) {
                    that.setData({
                      canIUseGetUserProfile: true
                    })
                  }
                  //4 授权成功后，发送用户信息给后端，返回完整的用户信息
                  wx.request({
                    url: 'http://xx/login/userAuth', 
                    data: {
                      nickname: user.nickname,
                      avatar_url: user.portrait,
                    },
                    header: {
                      'token': token,
                    },
                    success (res) {
                      console.log(res.data)
                      //把数据存下来
                      that.setData({
                        user: res.data.user,
                        token: res.data.token,
                      }) 
                    },
                    fail:function(err){
                      console.log(err)
                    },
                  })

                }
                else {
                  
                }       
              } catch (e) { }
            }*/
           })

          //3.2 昵称和头像不为空
          //直接登录，跳转至首页
          //5 授权成功后，也获取了昵称和头像，跳转至首页
          //把token和user存入Storage
          /*if(that.user.nickname=="" && that.user.portrait=="") {
            wx.setStorageSync('token', that.token)
            wx.setStorageSync('id', that.user.id)
            wx.setStorageSync('portrait', that.user.portrait)
            wx.setStorageSync('qq', that.user.qq)
            wx.setStorageSync('username', that.user.username)
            wx.setStorageSync('creditScore', that.user.credit.creditScore)
            wx.setStorageSync('dislikeNum', that.user.credit.dislikeNum)
            wx.setStorageSync('likeNum', that.user.credit.likeNum)

            wx.redirectTo({
              url: '/pages/index/index'
            })
          }*/

        } else {
          console.log('登录失败！' + res.errMsg)
        }
      }
    })

  
  },
  getUserProfile(e) {
    // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认
    // 开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
    wx.getUserProfile({
      desc: '用于登录', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (res) => {
        console.log(res.userInfo)
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    })
  },
  getUserInfo(e) {
    // 不推荐使用getUserInfo获取用户信息，预计自2021年4月13日起，getUserInfo将不再弹出弹窗，并直接返回匿名的用户个人信息
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
})