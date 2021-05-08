// pages/publish/publish.js


Page({

    /**
     * 页面的初始数据
     */
    data: {
        goods_title: "",
        goods_price: "",
        goods_originalPrice: "",
        goods_message: "",
        goods_tag: "",
        goods_fileList: [],
        goods_old_new_list: ["全新", "九成新", "八成新", "八成以下"],
        goods_class_list: ["服饰", "鞋子", "电子产品", "生活用品", "电动车", "书籍", "其他"],
        goods_label_list: ["李宁"],
        goods_old_new_list_idx: "",
        goods_class_list_idx: "",

        task_title: "",
        task_remuneration: "",
        task_message: "",
        task_tag: "",
        task_class_list: ["取快递", "填写问卷", "考试辅导", "食堂带饭", "其他"],
        task_label_list: ["高数"],
        task_class_list_idx: "",

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

        activity_title: "",
        activity_place: "",
        activity_message: "",
        activity_tag: "",
        activity_fileList: [],
        activity_class_list: ["团立项", "社团活动", "比赛", "招聘会", "其他"],
        activity_label_list: ["五四活动"],
        activity_class_list_idx: "",
    },

    pickerShow() {
        this.setData({
            isPickerShow: true,
            isPickerRender: true,
            chartHide: true
        });
    },
    pickerHide() {
        this.setData({
            isPickerShow: false,
            chartHide: false
        });
    },

    bindPickerChange(e) {
        // console.log("picker发送选择改变，携带值为", e.detail.value);
        // console.log(this.data.sensorList);

        this.getData(this.data.sensorList[e.detail.value].id);
        // let startDate = util.formatTime(new Date(new Date().getTime() - 24 * 60 * 60 * 1000 * 7));
        // let endDate = util.formatTime(new Date());
        this.setData({
            index: e.detail.value,
            sensorId: this.data.sensorList[e.detail.value].id
                // startDate,
                // endDate
        });
    },
    setPickerTime(val) {
        // console.log(val);
        let data = val.detail;
        this.setData({
            startTime: data.startTime,
            endTime: data.endTime
        });
    },

    goods_old_new_list_selectApply(e) {
        let id = e.target.dataset.id
        this.setData({
            goods_old_new_list_idx: id
        })
    },

    goods_class_list_selectApply(e) {
        let id = e.target.dataset.id
        this.setData({
            goods_class_list_idx: id
        })
    },

    task_class_list_selectApply(e) {
        let id = e.target.dataset.id
        this.setData({
            task_class_list_idx: id
        })
    },

    activity_class_list_selectApply(e) {
        let id = e.target.dataset.id
        this.setData({
            activity_class_list_idx: id
        })
    },

    onInput(event) {

    },

    /**
     * 一键清空
     */
    clearInputEvent(res) {
        this.setData({
            'message': ''
        })
    },

    afterRead(event) {
        const { file } = event.detail;
        // 当设置 mutiple 为 true 时, file 为数组格式，否则为对象格式
        wx.uploadFile({
            url: 'https://example.weixin.qq.com/upload', // 仅为示例，非真实的接口地址
            filePath: file.url,
            name: 'file',
            formData: { user: 'test' },
            success(res) {
                // 上传完成需要更新 fileList
                const { fileList = [] } = this.data;
                fileList.push({...file, url: res.data });
                this.setData({ fileList });
            },
        });
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function(options) {
        let time = this.getCurrentTime();
        this.setData({
            initStartTime: time,

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

    zeroFill(i) {
        if (i >= 0 && i <= 9) {
            return "0" + i;
        } else {
            return i;
        }
    },

    goodsTagInput(e) {
        this.setData({
            goods_tag: e.detail.value
        })
    },

    taskTagInput(e) {
        this.setData({
            task_tag: e.detail.value
        })
    },

    activityTagInput(e) {
        this.setData({
            activity_tag: e.detail.value
        })
    },

    TagCreate(e) {
        this.onReady();
    },

    unique(arr) {
        return Array.from(new Set(arr))
    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function() {
        if (this.data.goods_tag) {
            this.data.goods_label_list.push(this.data.goods_tag.replaceAll(" ", ""));
            this.setData({
                goods_label_list: this.unique(this.data.goods_label_list),
                goods_tag: "",

            })
        }

        if (this.data.task_tag) {
            this.data.task_label_list.push(this.data.task_tag.replaceAll(" ", ""));
            this.setData({
                task_label_list: this.unique(this.data.task_label_list),
                task_tag: "",

            })
        }

        if (this.data.activity_tag) {
            this.data.activity_label_list.push(this.data.activity_tag.replaceAll(" ", ""));
            this.setData({
                activity_label_list: this.unique(this.data.activity_label_list),
                activity_tag: "",

            })
        }
    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function() {

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