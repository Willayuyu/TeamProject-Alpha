// app.js
App({
  onLaunch() {
    // 展示本地存储能力
    const logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
      }
    })
  },
  globalData: {
    //登录以后会设置这些全局变量的值
    token:"",
    user:{},
    imgsrc:"/images/photo.jpg",
    username:"Fidle",
    userid:"a12345",
    credit:"104",
    goodcmt:5,
    badcmt:1,
    phonenum:"此项为空",
    qqnum:"此项为空",
  }
})
