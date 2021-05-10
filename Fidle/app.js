// app.js
App({
  onLaunch() {
    // 展示本地存储能力
    const logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)
    console.log("onlaunch")

    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        console.log("登陆成功");
        // var that=this;
        // wx.request({
        //   url: 'http://localhost:8080/personalPage/getHomePageById/id',
        //   method: "GET",
        //   header: {
        //     'content-type':'application/json'
        //   },
        //   success: function (res){
        //     //登录时获取用户信息赋给全局数据
        //     that.globalData.userid=res.data.id;
        //     that.globalData.username=res.data.username;
        //     that.globalData.credit=res.data.credit.credit_score;
        //     that.globalData.goodcmt=res.data.like_num;
        //     that.globalData.badcmt=res.data.dislike_num;
        //     that.globalData.phonenum=res.data.tel;
        //     that.globalData.qqnum=res.data.qq;
        //   }
        // })
      }
    })
  },
  globalData: {
    click:1,
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
