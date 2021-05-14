// pages/changeActivity/changeActivity.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        tempFilePaths: [],
        max_upload: 3,

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

        id: 0,
        activity_title: "",
        activity_place: "",
        activity_message: "",
        activity_tag: "",
        activity_fileList: [],
        history_fileList: [],
        activity_pictureID: [],
        activity_class_list: [{ categoryId: "", categoryDesignation: "" }],
        history_category: "",
        activity_label_list: [],
        history_label_list: [{ content: "", id: 0 }],
        activity_class_list_idx: 0,
        activity_uploadUrl: "http://47.106.241.182:8082/publish/uploadActivityImage",
        activity_deleteUrl: "http://47.106.241.182:8082/publish/deleteActivityImage/",
        activity_releaseUrl: "http://47.106.241.182:8082/publish/activity",
    },

    /**
     * 获取活动历史记录
     */
    getHistoryActivityList() {
        let that = this;
        var session_id = wx.getStorageSync('sessionid');
        var token = wx.getStorageSync('token');
        var header = { 'content-type': 'application/json', 'Cookie': session_id,'token': app.globalData.token };
        wx.request({
            url: 'http://47.106.241.182:8082/activity/getActivityDetailById/' + that.data.id,
            method: "GET",
            header: header,
            success(res) {
                console.log(res.data);
                if (res.data.code === 200) {
                    that.setData({
                        history_fileList: res.data.data.picturesLink,
                        activity_title: res.data.data.title,
                        activity_place: res.data.data.address,
                        startTime: res.data.data.startTime,
                        endTime: res.data.data.endTime,
                        history_label_list: res.data.data.tagList,
                        activity_message: res.data.data.description,
                        history_category: res.data.data.category,
                        id: res.data.data.id,
                    })
                    that.setLabelList();
                    that.setCategoryIndex();
                    that.setPictureList();
                }
            },
            fail(err) {
                console.log(err);
            }
        })
    },
    /**
     * 图片转化
     */
    setPictureList() {
        let that = this;
        let list = that.data.history_fileList;
        let activity_List = [];
        let i = 0;
        let pictureID = [];
        var session_id = wx.getStorageSync('sessionid');
        var token = wx.getStorageSync('token');
        var header = { 'content-type': 'application/x-www-form-urlencoded', 'Cookie': session_id,'token': app.globalData.token };
        if(list[0] != null){
            for (i = 0; i < list.length; i++) {
                wx.request({
                    url: 'http://47.106.241.182:8082/publish/getActivityImageIdByLink',
                    data: { imageLink: list[i] },
                    method: "POST",
                    header: header,
                    success(res) {
                        console.log(res.data.data);
                        if (res.data.code === 200) {
                            pictureID[i] = res.data.data;
                        }
                    }
                })
            }
            for (i = 0; i < list.length; i++) {
                activity_List[i] = { id: pictureID[i], imageLink: list[i] };
            }
            that.setData({
                activity_fileList: activity_List,
                activity_pictureID: pictureID
            })
            console.log(activity_List)
        }
    },
    /**
     * 类别转化
     */
    setCategoryIndex() {
        let that = this;
        let list = that.data.activity_class_list;
        let category = that.data.history_category;
        let i = 0;
        let categoryID;
        console.log(list);
        for (i = 0; i < list.length; i++) {
            if (category == list[i].categoryDesignation) {
                categoryID = i;
            }
        }
        console.log(categoryID);
        that.setData({
            activity_class_list_idx: categoryID
        })
    },
    /**
     * 标签转化
     */
    setLabelList() {
        let that = this;
        let list = [];
        let i = 0;
        for (i = 0; i < that.data.history_label_list.length; i++) {
            list[i] = that.data.history_label_list[i].content;
        }
        console.log(list);
        that.setData({
            activity_label_list: list
        })
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

    //活动信息类别选择
    activityClassListSelectApply(e) {
        let id = e.target.dataset.id
        this.setData({
            activity_class_list_idx: id
        })
    },

    //活动信息标题输入
    activityTitleInput(e) {
        this.setData({
            activity_title: e.detail,
        })
    },

    //活动信息地点输入
    activityPlaceInput(e) {
        this.setData({
            activity_place: e.detail,
        })
    },

    //活动信息活动形式输入
    activityMessageInput(e) {
        this.setData({
            activity_message: e.detail,
        })
    },
    
    //活动信息发布功能
    activityRelease() {
        let that = this;
        let flag = false;
        let id = that.data.id;
        let activity_title = that.data.activity_title;
        let activity_place = that.data.activity_place;
        let activity_message = that.data.activity_message;
        let activity_startTime = that.data.startTime;
        let activity_endTime = that.data.endTime;
        console.log(id);
        console.log(activity_title);
        console.log(id);
        let imageList = [];
        for (var i = 0; i < that.data.activity_fileList.length; i++)
            imageList.push(that.data.activity_fileList[i].imageLink);
        console.log(imageList)
        let activity_category = that.data.activity_class_list[that.data.activity_class_list_idx].categoryId;
        let activity_tags = that.data.activity_label_list;
        console.log(activity_tags);
        console.log(activity_category);
        if (activity_title.trim() == "")
            wx.showToast({
                icon: "none",
                title: "输入活动名称不能为空",
            })
        else if (activity_place.trim() == "")
            wx.showToast({
                icon: "none",
                title: "输入活动地点不能为空",
            })
        else if (activity_message.trim() == "")
            wx.showToast({
                icon: "none",
                title: "输入活动形式不能为空",
            })
        else if (activity_startTime.trim() == "") {
            wx.showToast({
                icon: "none",
                title: "输入时间信息不能为空",
            })
        } else {
            flag = true;
        }
        if(flag == true){
            wx.request({
                url: 'http://120.77.210.142:8080/myActivity/alterActivity',
                header: { "Content-Type": "application/x-www-form-urlencoded",'token': app.globalData.token },
                method: "POST",
                dataType:'json',
                data: {
                    id: id,
                    title: activity_title,
                    address: activity_place,
                    start_time: activity_startTime,
                    end_time: activity_endTime,
                    category: activity_category,
                    description: activity_message,
                    images: imageList,
                    tags: activity_tags,
                },
                success(res){
                    console.log(res.data.code);
                    console.log(res.data.message);
                    wx.redirectTo({
                        url: '/pages/activity/activity',
                    })
                },
                fail(err){
                    wx.showToast({ title: '系统错误' })
                }
            })
        }
        
       //测试
       /**
        * that.setData({
           test: [{
            id: id,
            title: activity_title,
            address: activity_place,
            start_time: activity_startTime,
            end_time: activity_endTime,
            description: activity_message,
            images: imageList,
            category: activity_category,
            tags: activity_tags,
             }],
        })

         console.log(that.data.test);
        */
        
    },

    //活动信息上传图片方法
    activityUpload() {
        let that = this;
        wx.chooseImage({
            sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function(res) {
                wx.showToast({
                        title: '正在上传...',
                        icon: 'loading',
                        mask: true,
                        duration: 1000
                    })
                    // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片

                let tempFilePaths = [];
                let init = that.data.activity_fileList.length;


                for (var i = 0; i < res.tempFilePaths.length; i++) {
                    if (init + i < that.data.max_upload)
                        tempFilePaths.push(res.tempFilePaths[i]);
                    else {
                        wx.showModal({
                            title: '提示',
                            content: '图片最多上传三张',
                        })
                        break;
                    }
                }


                if (tempFilePaths.length + init == that.data.max_upload) {
                    that.setData({
                        activity_add_img: true,
                    })
                }

                //上传完成后把文件上传到服务器
                for (var i = 0, h = tempFilePaths.length; i < h; i++) {
                    console.log(tempFilePaths[i]);

                    //上传文件
                    wx.uploadFile({
                        url: that.data.activity_uploadUrl,
                        filePath: tempFilePaths[i],
                        name: 'image',
                        header: {
                            "Content-Type": "multipart/form-data"
                        },
                        success: function(res) {
                            let imageFile = that.data.activity_fileList;
                            //如果是最后一张,则隐藏等待中  
                            if (i == tempFilePaths.length) {
                                wx.hideToast();
                            }
                            let image = {
                                id: "",
                                imageLink: ""
                            };

                            const data = JSON.parse(res.data)

                            image.id = data.data.id;
                            image.imageLink = data.data.imageLink;

                            imageFile.push(image);
                            console.log(imageFile);


                            that.setData({
                                activity_fileList: imageFile,
                            })
                        },
                        fail: function(res) {
                            wx.hideToast();
                            wx.showModal({
                                title: '错误提示',
                                content: '上传图片失败',
                                showCancel: false,
                                success: function(res) {}
                            })
                        }
                    });
                }

            }
        })
    },

    // 预览活动信息图片方法
    activityListenerButtonPreviewImage(e) {
        let index = e.target.dataset.index;
        let that = this;
        console.log(that.data.activity_fileList[index].imageLink);
        let imageList = [];
        for (var i = 0; i < that.data.activity_fileList.length; i++)
            imageList.push(that.data.activity_fileList[i].imageLink)

        wx.previewImage({
            current: that.data.activity_fileList[index].imageLink,
            urls: imageList,
            //这根本就不走
            success: function(res) {
                //console.log(res);
            },
            //也根本不走
            fail: function() {
                //console.log('fail')
            }
        })
    },

    // 删除活动信息图片
    activityDeleteImage: function(e) {
        var that = this;
        var tempFilePaths = that.data.activity_fileList;

        var index = e.currentTarget.dataset.id; //获取当前长按图片下标
        console.log(index);
        var tempId = tempFilePaths[index].id;
        wx.showModal({
            title: '提示',
            content: '确定要删除此图片吗？',
            success: function(res) {
                if (res.confirm) {
                    wx.request({
                        url: that.data.activity_deleteUrl + tempId,
                        header: {
                            'content-type': 'application/json', // 默认值
                            'Cookie': wx.getStorageSync('sessionid'),
                            'token': app.globalData.token
                        },
                        success: function(res) {
                            console.log("删除成功");
                            console.log(tempId);
                        }

                    })

                    tempFilePaths.splice(index, 1);

                    that.setData({
                        activity_add_img: false,
                    })
                } else if (res.cancel) {
                    console.log('取消');
                    return false;
                }
                that.setData({
                    activity_fileList: tempFilePaths,
                });
            }
        })
    },

    //从服务器上获取活动信息的类别列表并展示
    getActivityClassList() {
        let that = this;

        wx.request({
            url: "http://47.106.241.182:8082/activity/listActivityCategory", //这里''里面填写你的服务器API接口的路径  
            //data: {},  //这里是可以填写服务器需要的参数  
            method: 'GET', // 声明GET请求  
            header: {
                'content-type': 'application/json', // 默认值
                'Cookie': wx.getStorageSync('sessionid'),
                'token': app.globalData.token
            },
            success: function(res) {
                let activity_list = new Array();

                res.data.data.forEach(function(e) {
                    let activity = {
                        categoryId: "",
                        categoryDesignation: ""
                    }
                    activity.categoryId = e.categoryId;
                    activity.categoryDesignation = e.categoryDesignation;
                    activity_list.push(activity);
                });

                that.setData({
                    activity_class_list: activity_list,
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

    //删除活动信息标签
    activityDeleteLabel: function(e) {
        var activity_label_list = this.data.activity_label_list;

        var index = e.currentTarget.dataset.id; //获取当前长按图片下标
        console.log(index);
        activity_label_list.splice(index, 1);

        this.setData({
            activity_label_list: activity_label_list,
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
     * 生命周期函数--监听页面加载
     */
    onLoad: function(options) {
        let activityID = options.id;
        this.setData({
            id: activityID
        })
        this.getActivityClassList();
        this.getHistoryActivityList();

    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function() {
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