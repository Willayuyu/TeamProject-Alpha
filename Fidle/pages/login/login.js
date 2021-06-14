// pages/login/login.js
var app = getApp()
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

    // 清除Storage缓存
    // try {
    //   wx.clearStorageSync()
    // } catch(e) {
    //   // Do something when catch error
    // }
    
    console.log("onLoad")
    if (wx.getUserProfile) {
      this.setData({
        canIUseGetUserProfile: true
      })
    }
    //let that = this;
    //0 如果isLogin==true，那么自动登录
    let value = wx.getStorageSync('isLogin')
    console.log("isLogin="+value)
    console.log(value=="")
    if(value==true || value=="")
    {
      console.log("wx.login")
      //1 wx.login获取code
      wx.login({
        success (res) {
          if (res.code) {
            console.log('res.code='+res.code)
            //2 发起网络请求,获取token和用户信息
            wx.request({
              url: 'http://47.106.241.182:8082/login/loginRequest',
              // url: 'https://baidu.com',
              method: 'POST',
              data:{code: res.code},
              header: {
                'content-type': 'application/x-www-form-urlencoded',
              },
              success: (res) => {
                /*小程序登录时，保存这次session id，下次访问修改请求头header的cookie。*/

                if (res && res.header && res.header['Set-Cookie']) {
                wx.setStorageSync('sessionid', res.header['Set-Cookie']); //登录返回，保存Cookie到Storage
                }
                       

                console.log(res)
                console.log(res.data)
                console.log(res.data.data)
                console.log(res.data.data.user)
                // 把数据存下来
                app.globalData.token = res.data.data.token
                app.globalData.user = res.data.data.user

                // app.globalData.token="token=lalala"
                // app.globalData.user=
                // {
                //     "credit":    
                //     {    
                //         "creditScore":1500,
                //         "dislikeNum":20,
                //         "likeNum":30
                //     },
                // "id":1,
                // "portrait":"",
                // "qq":"11111",
                // "username":""
                // }
                console.log("app.globalData.token="+app.globalData.token)
                console.log("app.globalData.user="+app.globalData.user)
              },
              fail:function(err){
                console.log('fail')
                console.log(err)
              },
              complete: function () { 
                //不论成功还是失败都会到这里面。第二个请求放在第一个请求的complete里面                         
                try {
                  console.log('app.globalData.username='+app.globalData.user.username)
                  console.log('globalData.user.portrait='+app.globalData.user.portrait)
                  console.log("判断是否用户信息中的nickname和portrait为空")
                  console.log(value=="")
                  //3 判断是否用户信息中的nickname和portrait为空
                  if(app.globalData.user.username==null && app.globalData.user.portrait==null || value=="") {
                    console.log('为空')
                    //3.1 为空，则用户为第一次登录
                    //必须留在当前页面，进行授权
                    // if (wx.getUserProfile) {
                    //   that.setData({
                    //     canIUseGetUserProfile: true
                    //   })
                    // }
                    //等待用户自己点击微信登录按钮
                    //进入授权函数
                  
                  }
                  else {
                    //3.2 昵称和头像不为空
                    //直接登录，跳转至首页
                    wx.setStorageSync('isLogin', true)
                    wx.switchTab({
                      url:'/pages/index/index'
                    })                 
                  }       
                } catch (e) { }
              }
            })
          } else {
            console.log('登录失败！' + res.errMsg)
          }
        }
      }) 
    } 
    else{
      console.log("走到这里了")
    }
  },
  getUserProfile(e) {
    console.log("getUserProfile")
    // let my_token = globalData.token
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

        // 4 授权成功后，发送用户信息(昵称+头像)给后端，返回完整的用户信息
        console.log("res.userInfo.nickName="+res.userInfo.nickName)
        console.log("res.userInfo.avatarUrl="+res.userInfo.avatarUrl)
        let session_id = wx.getStorageSync('sessionid');
        
                // var header = { 'content-type': 'application/x-www-form-urlencoded', 'Cookie': session_id }
        console.log('token='+app.globalData.token)
        console.log("发起授权网络请求")
        wx.request({
          url: 'http://47.106.241.182:8082/login/userAuth', 
          // url: 'https://baidu.com',
          method: 'POST',
          data: {
            nickname: res.userInfo.nickName,
            avatar_url: res.userInfo.avatarUrl,
          },
          header: { 'content-type': 'application/x-www-form-urlencoded', 'Cookie': session_id ,
          'token': app.globalData.token},
          success (res) {
            // console.log(res)
            // console.log(res.data)
            if(res.data.code == 200) {
              console.log('授权成功，返回完整的用户信息')
            
              wx.setStorageSync('isLogin', true)
              console.log("res=")
              console.log(res)
              console.log(res.data)
              //把数据存在全局变量
              app.globalData.user = res.data.data
              console.log("res.data.data=")
              console.log(res.data.data)
              //打印出来看看，确认已经头像和昵称已经有了
              console.log("app.globalData.user"+app.globalData.user)
              //跳转进入首页              
              console.log("跳转")
              wx.switchTab({
                url:'/pages/index/index'
              })             
            }
            else{
              console.log("res.data.code="+res.data.code)
            }
          },
          fail:function(err){
            console.log("跳转")
            console.log(err)
          },
          complete:function(){
            console.log("complete")
          }
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