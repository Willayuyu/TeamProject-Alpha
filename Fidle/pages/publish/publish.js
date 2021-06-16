// pages/publish/publish.js
var app = getApp();
//console.log("返回成功的数据:" + JSON.stringify(res.data)) //这样就可以愉快的看到后台的数据啦
Page({
    data: {
        tempFilePaths: [],
        max_upload: 3,

        goods_add_img: false,
        goods_title: "",
        goods_price: "",
        goods_originalPrice: "",
        goods_message: "",
        goods_tag: "",
        goods_fileList: [],
        goods_old_new_list: ["全新", "九成新", "八成新", "八成以下"],
        goods_class_list: [{ categoryId: "", categoryDesignation: "" }],
        goods_label_list: [],
        goods_old_new_list_idx: 0,
        goods_class_list_idx: 0,
        goods_uploadUrl: "https://fidle.shawnxixi.icu/publish/uploadGoodsImage",
        goods_deleteUrl: "https://fidle.shawnxixi.icu/publish/deleteGoodsImage/",
        goods_releaseUrl: "https://fidle.shawnxixi.icu/publish/goods",


        task_title: "",
        task_remuneration: "",
        task_message: "",
        task_tag: "",
        task_class_list: [{ categoryId: "", categoryDesignation: "" }],
        task_label_list: [],
        task_class_list_idx: 0,
        task_classListUrl: "https://fidle.shawnxixi.icu/task/listTaskCategory",
        task_releaseUrl: "https://fidle.shawnxixi.icu/publish/task",

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
        activity_class_list: [{ categoryId: "", categoryDesignation: "" }],
        activity_label_list: [],
        activity_class_list_idx: 0,
        activity_uploadUrl: "https://fidle.shawnxixi.icu/publish/uploadActivityImage",
        activity_deleteUrl: "https://fidle.shawnxixi.icu/publish/deleteActivityImage/",
        activity_releaseUrl: "https://fidle.shawnxixi.icu/publish/activity",

    },

    /**
     * 二手物品表单输入
     * @param {*} e 
     */
    goodsTitleInput(e) {
        this.setData({
            goods_title: e.detail,
        })

    },

    /**
     * 二手物品价格输入
     * @param {*} e 
     */
    goodsPriceInput(e) {
        this.setData({
            goods_price: e.detail,
        })
    },

    /**
     * 二手物品原价输入
     * @param {*} e 
     */
    goodsOriginalPriceInput(e) {
        this.setData({
            goods_originalPrice: e.detail,
        })
    },

    /**
     * 二手物品详情输入
     * @param {*} e 
     */
    goodsMessageInput(e) {
        this.setData({
            goods_message: e.detail,
        })
    },

    /**
     * 二手物品信息发布功能
     */
    goodsRelease() {
        let flag = false;
        let that = this;
        let goods_title = that.data.goods_title;
        let goods_price = that.data.goods_price;
        let goods_original_price = that.data.goods_originalPrice;
        let goods_description = that.data.goods_message;
        let imageList = [];
        for (var i = 0; i < that.data.goods_fileList.length; i++)
            imageList.push(that.data.goods_fileList[i].imageLink);
        let goods_condition = that.data.goods_old_new_list_idx + 1;
        let goods_category = that.data.goods_class_list[that.data.goods_class_list_idx].categoryId;
        let goods_tags = that.data.goods_label_list;

        if (goods_title.trim() == "")
            wx.showToast({
                icon: "none",
                title: "输入标题不能为空",
            })
        else if (goods_price.trim() == "")
            wx.showToast({
                icon: "none",
                title: "输入价格不能为空",
            })
        else if (goods_original_price.trim() == "")
            wx.showToast({
                icon: "none",
                title: "输入原价不能为空",
            })
        else if (goods_description.trim() == "") {
            wx.showToast({
                icon: "none",
                title: "输入详细描述不能为空",
            })
        } else {
            flag = true;
        }

        console.log(imageList);
        console.log(goods_tags);
        if (flag)
            wx.request({      
                url: that.data.goods_releaseUrl,
                header: {        
                    "Content-Type": "application/x-www-form-urlencoded",
                    'Cookie': wx.getStorageSync('sessionid'),
                    'token': app.globalData.token      
                },
                method: "POST",
                data: {
                    title: goods_title,
                    price: goods_price,
                    original_price: goods_original_price,
                    description: goods_description,
                    image_links: imageList,
                    condition: goods_condition,
                    category: goods_category,
                    tags: goods_tags,
                },

                //       data: Util.json2Form( { cityname: "上海", key: "1430ec127e097e1113259c5e1be1ba70" }),

                complete: function(res) {              
                    if (res == null || res.data == null) {          
                        console.error('网络请求失败');       
                        return;        
                    } else {
                        that.clean();
                        wx.showModal({
                            title: "提示",
                            content: "二手物品信息发布成功",
                        })
                    }      
                }    
            })
    },

    /**
     * 恢复初始化数据
     */
    clean() {
        this.setData({
            tempFilePaths: [],

            goods_add_img: false,
            goods_title: "",
            goods_price: "",
            goods_originalPrice: "",
            goods_message: "",
            goods_tag: "",
            goods_fileList: [],
            goods_label_list: [],
            goods_old_new_list_idx: 0,
            goods_class_list_idx: 0,

            task_title: "",
            task_remuneration: "",
            task_message: "",
            task_tag: "",
            task_label_list: [],
            task_class_list_idx: 0,

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
            activity_label_list: [],
            activity_class_list_idx: 0,
        })

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
     * 二手交易上传图片方法
     */
    goodsUpload() {
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
                let init = that.data.goods_fileList.length;


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
                        goods_add_img: true,
                    })
                }

                //上传完成后把文件上传到服务器
                for (var i = 0, h = tempFilePaths.length; i < h; i++) {
                    console.log(tempFilePaths[i]);

                    //上传文件
                    wx.uploadFile({
                        url: that.data.goods_uploadUrl,
                        filePath: tempFilePaths[i],
                        name: 'image',
                        header: {
                            "Content-Type": "multipart/form-data",
                            'Cookie': wx.getStorageSync('sessionid'),
                            'token': app.globalData.token
                        },
                        success: function(res) {
                            let imageFile = that.data.goods_fileList;
                            console.log(imageFile);
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
                                goods_fileList: imageFile,
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

    /**
     * 预览二手交易图片方法
     */
    goodsListenerButtonPreviewImage(e) {
        let index = e.target.dataset.index;
        let that = this;
        console.log(that.data.goods_fileList[index].imageLink);
        let imageList = [];
        for (var i = 0; i < that.data.goods_fileList.length; i++)
            imageList.push(that.data.goods_fileList[i].imageLink)

        wx.previewImage({
            current: that.data.goods_fileList[index].imageLink,
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

    /**
     * 删除二手交易图片
     */
    goodsDeleteImage: function(e) {
        var that = this;
        var tempFilePaths = that.data.goods_fileList;

        var index = e.currentTarget.dataset.id; //获取当前长按图片下标
        console.log(index);
        var tempId = tempFilePaths[index].id;
        wx.showModal({
            title: '提示',
            content: '确定要删除此图片吗？',
            success: function(res) {
                if (res.confirm) {
                    wx.request({
                        url: that.data.goods_deleteUrl + tempId,
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
                        goods_add_img: false,
                    })
                } else if (res.cancel) {
                    console.log('取消');
                    return false;
                }
                that.setData({
                    goods_fileList: tempFilePaths,
                });
            }
        })
    },

    /**
     * 删除二手交易标签
     */
    goodsDeleteLabel(e) {
        var goods_label_list = this.data.goods_label_list;

        var index = e.currentTarget.dataset.id; //获取当前长按图片下标
        console.log(index);
        goods_label_list.splice(index, 1);

        this.setData({
            goods_label_list: goods_label_list,
        })
    },

    /**
     * 新旧程度单选功能
     */
    goodsOldNewListSelectApply(e) {
        let id = e.target.dataset.id
        this.setData({
            goods_old_new_list_idx: id
        })
    },

    /**
     * 二手类别单选功能
     */
    goodsClassListSelectApply(e) {
        let id = e.target.dataset.id
        this.setData({
            goods_class_list_idx: id
        })
    },

    /**
     * 从服务器上获取二手交易的类别列表并展示
     */
    getGoodsClassList() {
        let that = this;
        wx.request({
            url: "https://fidle.shawnxixi.icu/goods/listGoodsCategory", //这里''里面填写你的服务器API接口的路径  
            //data: {},  //这里是可以填写服务器需要的参数  
            method: 'GET', // 声明GET请求  
            header: {
                'content-type': 'application/json', // 默认值
                'Cookie': wx.getStorageSync('sessionid'),
                'token': app.globalData.token
            },
            success: function(res) {
                let goods_list = new Array();

                res.data.data.forEach(function(e) {
                    let good = {
                        categoryId: "",
                        categoryDesignation: ""
                    }
                    good.categoryId = e.categoryId;
                    good.categoryDesignation = e.categoryDesignation;
                    goods_list.push(good);
                });

                that.setData({
                    goods_class_list: goods_list,
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

    /**
     * 时间选择器显示
     */
    pickerShow() {
        this.setData({
            isPickerShow: true,
            isPickerRender: true,
            chartHide: true
        });
    },

    /**
     * 时间选择器隐藏
     */
    pickerHide() {
        this.setData({
            isPickerShow: false,
            chartHide: false
        });
    },

    /**
     * 设置选择时间
     */
    setPickerTime(val) {
        let data = val.detail;
        this.setData({
            startTime: data.startTime,
            endTime: data.endTime
        });

    },

    /**
     * 选择任务委托类别
     */
    taskClassListSelectApply(e) {
        let id = e.target.dataset.id
        this.setData({
            task_class_list_idx: id
        })
    },

    /**
     * 从服务器上获取任务委托的类别列表并展示
     */
    getTaskClassList() {
        let that = this;

        wx.request({
            url: that.data.task_classListUrl, //这里''里面填写你的服务器API接口的路径  
            //data: {},  //这里是可以填写服务器需要的参数  
            method: 'GET', // 声明GET请求  
            header: {
                'content-type': 'application/json', // 默认值
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

    /**
     * 任务委托标题
     */
    taskTitleInput(e) {
        this.setData({
            task_title: e.detail,
        })
    },

    /**
     * 任务委托酬劳
     */
    taskRemunerationInput(e) {
        this.setData({
            task_remuneration: e.detail,
        })
    },

    /**
     * 任务委托详情
     */
    taskMessageInput(e) {
        this.setData({
            task_message: e.detail,
        })
    },

    /**
     * 任务委托发布功能
     */
    taskRelease() {
        let that = this;
        let flag = false;
        let task_title = that.data.task_title;
        let task_remuneration = that.data.task_remuneration;
        let task_message = that.data.task_message;
        let task_startTime = that.data.startTime;
        let task_endTime = that.data.endTime;
        let task_category = that.data.task_class_list[that.data.task_class_list_idx].categoryId;
        let task_tags = that.data.task_label_list;

        if (task_title.trim() == "")
            wx.showToast({
                icon: "none",
                title: "输入标题不能为空",
            })
        else if (task_remuneration.trim() == "")
            wx.showToast({
                icon: "none",
                title: "输入报酬不能为空",
            })
        else if (task_message.trim() == "")
            wx.showToast({
                icon: "none",
                title: "输入任务详情不能为空",
            })
        else if (task_startTime.trim() == "") {
            wx.showToast({
                icon: "none",
                title: "输入时间信息不能为空",
            })
        } else {
            flag = true;
        }

        if (flag)
            wx.request({      
                url: that.data.task_releaseUrl,
                header: {        
                    "Content-Type": "application/x-www-form-urlencoded",
                    'Cookie': wx.getStorageSync('sessionid'),
                    'token': app.globalData.token      
                },
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
                    if (res == null || res.data == null) {          
                        console.error('网络请求失败');          
                        return;        
                    } else {
                        that.clean();
                        wx.showModal({
                            title: "提示",
                            content: "任务委托信息发布成功",
                        })
                    }      
                }    
            })
    },

    /**
     * 删除任务委托标签
     */
    taskDeleteLabel: function(e) {
        var task_label_list = this.data.task_label_list;

        var index = e.currentTarget.dataset.id; //获取当前长按图片下标
        console.log(index);
        task_label_list.splice(index, 1);

        this.setData({
            task_label_list: task_label_list,
        })
    },

    /**
     * 活动信息类别选择
     */
    activityClassListSelectApply(e) {
        let id = e.target.dataset.id
        this.setData({
            activity_class_list_idx: id
        })
    },

    /**
     * 活动信息标题输入
     */
    activityTitleInput(e) {
        this.setData({
            activity_title: e.detail,
        })
    },

    /**
     * 活动信息地点输入
     */
    activityPlaceInput(e) {
        this.setData({
            activity_place: e.detail,
        })
    },

    /**
     * 活动信息活动形式输入
     */
    activityMessageInput(e) {
        this.setData({
            activity_message: e.detail,
        })
    },

    /**
     * 活动信息发布功能
     */
    activityRelease() {
        let that = this;
        let flag = false;
        let activity_title = that.data.activity_title;
        let activity_place = that.data.activity_place;
        let activity_message = that.data.activity_message;
        let activity_startTime = that.data.startTime;
        let activity_endTime = that.data.endTime;

        let imageList = [];
        for (var i = 0; i < that.data.activity_fileList.length; i++)
            imageList.push(that.data.activity_fileList[i].imageLink);

        let activity_category = that.data.activity_class_list[that.data.activity_class_list_idx].categoryId;
        let activity_tags = that.data.activity_label_list;

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

        if (flag)
            wx.request({      
                url: that.data.activity_releaseUrl,
                header: {        
                    "Content-Type": "application/x-www-form-urlencoded",
                    'Cookie': wx.getStorageSync('sessionid'),
                    'token': app.globalData.token      
                },
                method: "POST",
                data: {
                    title: activity_title,
                    address: activity_place,
                    start_time: activity_startTime,
                    end_time: activity_endTime,
                    description: activity_message,
                    image_links: imageList,
                    category: activity_category,
                    tags: activity_tags,
                },

                //       data: Util.json2Form( { cityname: "上海", key: "1430ec127e097e1113259c5e1be1ba70" }),

                complete: function(res) {              
                    if (res == null || res.data == null) {          
                        console.error('网络请求失败');          
                        return;        
                    } else {
                        that.clean();
                        wx.showModal({
                            title: "提示",
                            content: "活动信息发布成功",
                        })
                    }      
                }    
            })
    },

    /**
     * 活动信息上传图片方法
     */
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
                            "Content-Type": "multipart/form-data",
                            'Cookie': wx.getStorageSync('sessionid'),
                            'token': app.globalData.token
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
                            console.log(data);
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

    /**
     * 预览活动信息图片方法
     */
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

    /**
     * 删除活动信息图片
     */
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

    /**
     * 删除活动信息标签
     */
    activityDeleteLabel: function(e) {
        var activity_label_list = this.data.activity_label_list;

        var index = e.currentTarget.dataset.id; //获取当前长按图片下标
        console.log(index);
        activity_label_list.splice(index, 1);

        this.setData({
            activity_label_list: activity_label_list,
        })
    },

    /**
     * 从服务器上获取活动信息的类别列表并展示
     */
    getActivityClassList() {
        let that = this;

        wx.request({
            url: "https://fidle.shawnxixi.icu/activity/listActivityCategory", //这里''里面填写你的服务器API接口的路径  
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

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function(options) {

        this.getGoodsClassList();
        this.getTaskClassList();
        this.getActivityClassList();
    },

    /**
     * 获取初始化开始时间
     */
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

    /**
     * 获取初始化结束时间
     */
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

    /**
     * 补0函数
     */
    zeroFill(i) {
        if (i >= 0 && i <= 9) {
            return "0" + i;
        } else {
            return i;
        }
    },

    /**
     * 二手标签添加
     * @param {*} e 
     */
    goodsTagInput(e) {
        this.setData({
            goods_tag: e.detail.value
        })
    },

    /**
     * 任务标签添加
     * @param {*} e 
     */
    taskTagInput(e) {
        this.setData({
            task_tag: e.detail.value
        })
    },


    /**
     * 活动标签添加
     * @param {*} e 
     */
    activityTagInput(e) {
        this.setData({
            activity_tag: e.detail.value
        })
    },

    /**
     * 标签创建
     * @param {*} e 
     */
    TagCreate(e) {
        this.onReady();
    },

    /**
     * 标签唯一性判断
     * @param {*} arr 
     * @returns 
     */
    unique(arr) {
        return Array.from(new Set(arr))
    },

    //生命周期函数--监听页面初次渲染完成
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

    //字符串转日期格式，strDate要转为日期格式的字符串
    stringToDate(strDate) {
        var st = strDate;
        var a = st.split(" ");
        var b = a[0].split("-");
        var c = a[1].split(":");
        var date = new Date(b[0], b[1] - 1, b[2], c[0], c[1], c[2])
        return date;
    },

    //日期转字符串格式
    　dateToString(date) {
        var year = date.getFullYear();
        var month = (date.getMonth() + 1).toString();
        var day = (date.getDate()).toString();
        var hour = (date.getHours()).toString();
        var minute = (date.getMinutes()).toString();
        var second = (date.getSeconds()).toString();

        if (month.length == 1) {
            month = "0" + month;
        }
        if (day.length == 1) {
            day = "0" + day;
        }
        if (hour.length == 1) {
            hour = "0" + hour;
        }
        if (minute.length == 1) {
            minute = "0" + minute;
        }
        if (second.length == 1) {
            second = "0" + second;
        }
        var dateTime = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
        return dateTime;
    },

    // 生命周期函数--监听页面显示
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

    // 生命周期函数--监听页面隐藏
    onHide: function() {

    },

    // 生命周期函数--监听页面卸载
    onUnload: function() {

    },

    // 页面相关事件处理函数--监听用户下拉动作
    onPullDownRefresh: function() {

    },

    // 页面上拉触底事件的处理函数
    onReachBottom: function() {

    },

    // 用户点击右上角分享
    onShareAppMessage: function() {

    }
})