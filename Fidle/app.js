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
    imgsrc:"/images/photo.jpg",
    username:"Fidle",
    userid:"a12345",
    credit:"104",
    goodcmt:5,
    badcmt:1,
    phonenum:"15728051975",
    qqnum:"3113937807",
  }
})
