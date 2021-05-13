// pages/changeTask/changeTask.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
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

    //任务委托发布功能
    taskRelease() {
        let that = this;
        let task_title = that.data.task_title;
        let task_remuneration = that.data.task_remuneration;
        let task_message = that.data.task_message;
        let task_startTime = that.data.startTime;
        let task_endTime = that.data.endTime;
        let task_category = that.data.task_class_list[that.data.task_class_list_idx].categoryId;
        let task_tags = that.data.task_label_list;

        wx.request({      
            url: that.data.task_releaseUrl,
            header: {         "Content-Type": "application/x-www-form-urlencoded"       },
            method: "POST",
            data: {
                title: task_title,
                reward: task_remuneration,
                start_time: task_startTime,
                end_time: task_endTime,
                description: task_message,
                category: task_category,
                tags: task_tags,
            },

            complete: function(res) {              
                if (res == null || res.data == null) {           console.error('网络请求失败');           return;         } else {
                    wx.showModal({
                        title: "提示",
                        content: "任务委托信息发布成功",
                    })
                }      
            }    
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
    },

    taskTagInput(e) {
        this.setData({
            task_tag: e.detail.value
        })
    },

    TagCreate(e) {
        this.onReady();
    },

    unique(arr) {
        return Array.from(new Set(arr))
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function(options) {
        this.getTaskClassList();
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

    }
})