// pages/publish/publish.js

//console.log("返回成功的数据:" + JSON.stringify(res.data)) //这样就可以愉快的看到后台的数据啦
Page({
    data: {
        url: "",
        fileList: [],

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
        goods_class_list: [],
        goods_label_list: [],
        goods_old_new_list_idx: "",
        goods_class_list_idx: "",
        goods_uploadUrl: "http://47.106.241.182:8082/publish/uploadGoodsImage",


        task_title: "",
        task_remuneration: "",
        task_message: "",
        task_tag: "",
        task_class_list: [],
        task_label_list: [],
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
        activity_class_list: [],
        activity_label_list: [],
        activity_class_list_idx: "",
        activity_uploadUrl: "http://47.106.241.182:8082/publish/uploadActivityImage",
    },

    /**
     * 上传图片方法
     */
    upload: function() {
        let that = this;
        wx.chooseImage({
            count: 9, // 默认9
            sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: res => {
                wx.showToast({
                        title: '正在上传...',
                        icon: 'loading',
                        mask: true,
                        duration: 1000
                    })
                    // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片

                let tempFilePaths = [];
                let init = that.data.tempFilePaths.length;


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


                /**
                 * 上传完成后把文件上传到服务器
                 */

                for (var i = 0, h = tempFilePaths.length; i < h; i++) {
                    console.log(tempFilePaths[i]);

                    //上传文件
                    wx.uploadFile({
                        url: "http://47.106.241.182:8082/publish/uploadGoodsImage",
                        filePath: tempFilePaths[i],

                        name: 'image',
                        header: {
                            "Content-Type": "multipart/form-data"
                        },
                        success: function(res) {
                            let imageFile = that.data.tempFilePaths;

                            //如果是最后一张,则隐藏等待中  
                            if (i == tempFilePaths.length) {
                                wx.hideToast();
                            }
                            let image = {
                                id: "",
                                imageLink: ""
                            }
                            const data = JSON.parse(res.data)
                            image.id = data.data.id;
                            image.imageLink = data.data.imageLink;
                            imageFile.push(image);
                            console.log(data.data.id);
                            console.log(image);
                            console.log(data.data.imageLink);
                            console.log(that.data.tempFilePaths)
                            that.setData({
                                tempFilePaths: imageFile,
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
     * 预览图片方法
     */
    listenerButtonPreviewImage: function(e) {
        let index = e.target.dataset.index;
        let that = this;
        console.log(that.data.tempFilePaths[index].imageLink);
        let imageList = [];
        for (var i = 0; i < that.data.tempFilePaths.length; i++)
            imageList.push(that.data.tempFilePaths[i].imageLink)

        console.log(imageList);

        wx.previewImage({
            current: that.data.tempFilePaths[index].imageLink,
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
     * 长按删除图片
     */
    deleteImage: function(e) {
        var that = this;
        var tempFilePaths = that.data.tempFilePaths;
        var index = e.currentTarget.dataset.index; //获取当前长按图片下标
        wx.showModal({
            title: '提示',
            content: '确定要删除此图片吗？',
            success: function(res) {
                if (res.confirm) {
                    console.log('确定');
                    tempFilePaths.splice(index, 1);
                    console.log(index);
                    that.setData({
                        goods_add_img: false,
                    })
                } else if (res.cancel) {
                    console.log('取消');
                    return false;
                }
                that.setData({
                    tempFilePaths
                });
            }
        })
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

    //新旧程度单选功能
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

    //一键清空
    clearInputEvent(res) {
        this.setData({
            'message': ''
        })
    },

    //上传二手物品图片
    goods_afterRead(event) {
        this.setData({
            url: this.data.goods_uploadUrl
        })
        this.afterRead(event);
        this.setData({
            goods_fileList: this.data.fileList
        })
    },

    //上传活动信息图片
    activity_afterRead(event) {
        this.setData({
            url: activity_uploadUrl
        })
        this.afterRead(event);
        this.setData({
            activity_fileList: fileList
        })
    },

    //上传图片后操作
    afterRead(event) {
        wx.showLoading({
            title: '上传中...'
        })
        const { file } = event.detail //获取所需要上传的文件列表
        let uploadPromiseTask = [] //定义上传的promise任务栈
        for (let i = 0; i < file.length; i++) {
            uploadPromiseTask.push(this.uploadFile(file[i].path)) //push进每一张所需要的上传的图片promise栈
        }
        Promise.all(uploadPromiseTask).then(res => {
            //全部上传完毕
            this.setData({
                fileList: this.data.fileList.concat(res)
            })
            wx.hideLoading()
        }).catch(error => {
            //存在有上传失败的文件
            wx.hideLoading()
            wx.showToast({
                title: '上传失败！',
                icon: 'none',
            })
        })
    },

    // 上传图片到指定服务器
    uploadFile(uploadFile) {
        return new Promise((resolve, reject) => {
            wx.uploadFile({
                filePath: uploadFile,
                name: 'file', //上传的所需字段，后端提供
                success: (res) => {
                    // 上传完成操作
                    const data = JSON.parse(res.data)
                    const url = data.data.url
                    resolve({
                        url: url
                    })
                },
                fail: (err) => {
                    //上传失败：修改pedding为reject
                    reject(err)
                }
            });
        })
    },

    // 删除二手物品已上传的图片
    goods_deleteImg(event) {
        this.deleteImg(event);
        this.setData({
            goods_fileList: this.data.fileList
        })
    },

    // 删除活动信息已上传的图片
    activity_deleteImg(event) {
        this.deleteImg(event);
        this.setData({
            activity_fileList: this.data.fileList
        })
    },

    // 删除已上传的图片
    deleteImg(event) {
        const delIndex = event.detail.index
        const { fileList } = this.data
        fileList.splice(delIndex, 1)
        this.setData({
            fileList
        })
    },


    //生命周期函数--监听页面加载
    onLoad: function(options) {
        let time = this.getCurrentTime();
        this.setData({
            initStartTime: time,
        })

        this.getGoodsClassList();
        this.getTaskClassList();
        this.getActivityClassList();
    },

    //从服务器上获取活动信息的类别列表并展示
    getActivityClassList() {
        let that = this;

        wx.request({
            url: "http://47.106.241.182:8082/activity/listActivityCategory", //这里''里面填写你的服务器API接口的路径  
            //data: {},  //这里是可以填写服务器需要的参数  
            method: 'GET', // 声明GET请求  
            // header: {}, // 设置请求的 header，GET请求可以不填  
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

    //从服务器上获取任务委托的类别列表并展示
    getTaskClassList() {
        let that = this;

        wx.request({
            url: "http://47.106.241.182:8082/task/listTaskCategory", //这里''里面填写你的服务器API接口的路径  
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

    //从服务器上获取二手交易的类别列表并展示
    getGoodsClassList() {
        let that = this;
        wx.request({
            url: "http://47.106.241.182:8082/goods/listGoodsCategory", //这里''里面填写你的服务器API接口的路径  
            //data: {},  //这里是可以填写服务器需要的参数  
            method: 'GET', // 声明GET请求  
            // header: {}, // 设置请求的 header，GET请求可以不填  
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

    // 生命周期函数--监听页面显示
    onShow: function() {

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