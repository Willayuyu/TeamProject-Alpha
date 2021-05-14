// pages/changeTask/changeTask.js
var app = getApp();
Page({

    /**
     * 页面的初始数据
     */
    data: {
        id: 1,
        task_title: "",
        task_remuneration: "",
        task_message: "",
        task_tag: "",
        task_class_list: [{ categoryId: "", categoryDesignation: "" }],
        task_label_list: [],
        task_class_list_idx: 0,
        task_classListUrl: "http://47.106.241.182:8082/task/listTaskCategory",
        task_releaseUrl: "http://47.106.241.182:8082/publish/task",

        isPickerRender: false,
        isPickerShow: false,
        startTime: "",
        endTime: "",
        pickerConfig: {
            endDate: true,
            column: "second",
            dateLimit: true,
            initStartTime: "",
            initEndTime: "",
            limitEndTime: "2099-12-31 23:59:59"
        },
        history_category: "",
        history_label_list: [{ content: "", id: "" }],

    },


    //时间选择器显示
    pickerShow() {
        this.setData({
            isPickerShow: true,
            isPickerRender: true,
            chartHide: true
        });
    },

    //时间选择器隐藏
    pickerHide() {
        this.setData({
            isPickerShow: false,
            chartHide: false
        });
    },

    //设置选择时间
    setPickerTime(val) {
        let data = val.detail;
        this.setData({
            startTime: data.startTime,
            endTime: data.endTime
        });

    },

    //选择任务委托类别
    taskClassListSelectApply(e) {
        let id = e.target.dataset.id
        this.setData({
            task_class_list_idx: id
        })
    },

    //从服务器上获取任务委托的类别列表并展示
    getTaskClassList() {
        let that = this;

        wx.request({
            url: that.data.task_classListUrl, //这里''里面填写你的服务器API接口的路径  
            //data: {},  //这里是可以填写服务器需要的参数  
            method: 'GET', // 声明GET请求  
            // header: {}, // 设置请求的 header，GET请求可以不填  
            header: {
                'Content-Type': 'application/json',
                'Cookie': wx.getStorageSync('sessionid'),
                'token': app.globalData.token
            },
            success: function(res) {
                let task_list = new Array();

                res.data.data.forEach(function(e) {
                    let task = {
                        categoryId: "",
                        categoryDesignation: ""
                    }
                    task.categoryId = e.categoryId;
                    task.categoryDesignation = e.categoryDesignation;
                    task_list.push(task);
                });

                that.setData({
                    task_class_list: task_list,
                })
            },
            fail: function(fail) {
                // 这里是失败的回调，取值方法同上,把res改一下就行了  
            },
            complete: function(arr) {
                // 这里是请求以后返回的所以信息，请求方法同上，把res改一下就行了  
            }
        })
    },

    //任务委托标题
    taskTitleInput(e) {
        this.setData({
            task_title: e.detail,
        })
    },

    //任务委托酬劳
    taskRemunerationInput(e) {
        this.setData({
            task_remuneration: e.detail,
        })
    },

    //任务委托详情
    taskMessageInput(e) {
        this.setData({
            task_message: e.detail,
        })
    },

    getCurrentTime() {
        var date = new Date(); //当前时间
        var month = this.zeroFill(date.getMonth() + 1); //月
        var day = this.zeroFill(date.getDate()); //日
        var hour = this.zeroFill(date.getHours()); //时
        var minute = this.zeroFill(date.getMinutes()); //分
        var second = this.zeroFill(date.getSeconds()); //秒

        //当前时间
        var curTime = date.getFullYear() + "-" + month + "-" + day +
            " " + hour + ":" + minute + ":" + second;

        return curTime;
    },

    getInitEnd() {
        var date = new Date(); //当前时间
        date.setTime(date.getTime() + 15 * 60 * 1000);
        var month = this.zeroFill(date.getMonth() + 1); //月
        var day = this.zeroFill(date.getDate()); //日
        var hour = this.zeroFill(date.getHours()); //时
        var minute = this.zeroFill(date.getMinutes()); //分
        var second = this.zeroFill(date.getSeconds()); //秒

        //当前时间
        var curTime = date.getFullYear() + "-" + month + "-" + day +
            " " + hour + ":" + minute + ":" + second;

        return curTime;
    },

    zeroFill(i) {
        if (i >= 0 && i <= 9) {
            return "0" + i;
        } else {
            return i;
        }
    },

    //删除任务委托标签
    taskDeleteLabel: function(e) {
        var task_label_list = this.data.task_label_list;

        var index = e.currentTarget.dataset.id; //获取当前长按图片下标
        console.log(index);
        task_label_list.splice(index, 1);

        this.setData({
            task_label_list: task_label_list,
        })
        console.log('删除任务委托标签');
        console.log(task_label_list);
    },

    taskTagInput(e) {
        console.log('e.detail.value');
        console.log(e.detail.value);
        this.setData({
            task_tag: e.detail.value
        })
    },

    TagCreate(e) {
        this.onReady();
        console.log('TagCreate');
        console.log(this.data.task_label_list);
    },

    unique(arr) {
        return Array.from(new Set(arr))
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function(options) {
        console.log('token='+app.globalData.token);
        console.log('修改任务的id为'+options.id);
        this.setData({
            id: options.id
        })
        this.getTaskClassList();
        this.getHistoryTaskList();
    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function() {
        if (this.data.task_tag) {
            this.data.task_label_list.push(this.data.task_tag.replaceAll(" ", ""));
            this.setData({
                task_label_list: this.unique(this.data.task_label_list),
                task_tag: "",

            })
        }

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function() {
        let initstart = this.getCurrentTime();
        let initend = this.getInitEnd();
        let tempPickerConfig = this.data.pickerConfig;
        tempPickerConfig.initStartTime = initstart;
        tempPickerConfig.initEndTime = initend;

        this.setData({
            pickerConfig: tempPickerConfig,
        })
    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function() {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function() {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function() {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function() {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function() {

    },

     /**
     * 获取任务历史记录
     */
    getHistoryTaskList() {
        let that = this;
        wx.request({
            url: 'http://47.106.241.182:8082/task/getTaskDetailById/' + that.data.id,
            method: "GET",
            header: {
                'Content-Type': 'application/json',
                'Cookie': wx.getStorageSync('sessionid'),
                'token': app.globalData.token
            },
            success(res) {
                console.log('获取任务历史记录');
                let data = res.data.data;
                console.log(res.data);
                if (res.data.code === 200) {

                    that.setData({
                        task_title: data.title,
                        task_remuneration: data.reward,
                        task_message: data.description,
                        history_label_list: res.data.data.tagList,
                        history_category: res.data.data.category,
                        task_classListUrl: "http://47.106.241.182:8082/task/listTaskCategory",
                        task_releaseUrl: "http://47.106.241.182:8082/publish/task",

                        isPickerRender: false,
                        isPickerShow: false,
                        startTime: data.startTime,
                        endTime: data.endTime,
                        pickerConfig: {
                            endDate: true,
                            column: "second",
                            dateLimit: true,
                            initStartTime: "",
                            initEndTime: "",
                            limitEndTime: "2099-12-31 23:59:59"
                        },

                    })
                    console.log('res.data.data.tagList[0]');
                    console.log(res.data.data.tagList[0]);
                    console.log(res.data.data.tagList[0].content == null);
                    if(res.data.data.tagList[0].content == null) {
                        that.setData({
                            history_label_list: [],
                        })
                    }
                    that.setLabelList();
                    that.setCategoryIndex();
                    // that.setPictureList();
                }
            },
            fail(err) {
                console.log(err);
            }
        })
    },

    // task_class_list: [{ categoryId: "", categoryDesignation: "" }],
    // task_label_list: [],

    /**
     * 类别转化
     */
    setCategoryIndex(){
        let that = this;
        let list = that.data.task_class_list;
        let category = that.data.history_category;
        let i = 0;
        let categoryID;
        for(i = 0;i < list.length;i++){
            if(category == list[i].categoryDesignation){
                categoryID = i;
            }
        }
        that.setData({
            task_class_list_idx: categoryID
        })
    },
    /**
     * 标签转化
     */
    setLabelList(){
        let that = this;
        let list =[];
        let i=0;
        console.log('history_label_list=');
        console.log(that.data.history_label_list);

        for(i=0;i<that.data.history_label_list.length;i++){
            list[i] = that.data.history_label_list[i].content;
        }
        console.log(list)
        that.setData({
            task_label_list: list
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
  doAlterTask() {
    let that = this;
    let task_id = that.data.id;
    let task_title = that.data.task_title;
    let task_remuneration = that.data.task_remuneration;
    let task_message = that.data.task_message;
    let task_startTime = that.data.startTime;
    let task_endTime = that.data.endTime;
    let task_category = that.data.task_class_list[that.data.task_class_list_idx].categoryId;
    console.log('task_tags=');
    let task_tags = that.data.task_label_list;
    console.log(task_tags);

    let session_id = wx.getStorageSync('sessionid');
    console.log(session_id); 
    console.log('app.globaldata=');
    console.log(app.globalData.user.id);
     
    wx.request({
      url: 'http://120.77.210.142:8080/myTask/alterTask/',
      method: 'POST',
      header: { 'content-type': 'application/x-www-form-urlencoded',
        'Cookie': session_id ,
        'token': app.globalData.token
      },
      data: {
        id: task_id,
        title: task_title,
        reward: task_remuneration,
        start_time: task_startTime,
        end_time: task_endTime,
        description: task_message,
        category: task_category,
        tags: task_tags,

        pub_id: app.globalData.user.id,

      },
      success(res){
        console.log("修改任务");
        console.log(res.data);
        if(res.data.code==200) {
        wx.redirectTo({
            url: '/pages/task/task',
            })
        }
      },
    //   complete: function(res) {              
    //     if (res == null || res.data == null) {           console.error('网络请求失败');           return;         } else {
    //         wx.showModal({
    //             title: "提示",
    //             content: "任务委托信息修改成功",
    //         })
    //     }      
    // }    
      
    })
},

})