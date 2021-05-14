// pages/changeGood/changeGood.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        id: '',
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
        goods_uploadUrl: "http://47.106.241.182:8082/publish/uploadGoodsImage",
        goods_deleteUrl: "http://47.106.241.182:8082/publish/deleteGoodsImage/id?id=",
        goods_releaseUrl: "http://47.106.241.182:8082/publish/goods",
        history_fileList: [],
        history_condition: "",
        history_category: "",
        history_label_list: [{ content: "", id: "" }],
    },

    /**
     * 获取二手物品历史记录
     */
    getHistoryGoodsList() {
        let that = this;
        var session_id = wx.getStorageSync('sessionid');
        var token = wx.getStorageSync('token');
        var header = { 'content-type': 'application/json', 'Cookie': session_id };
        wx.request({
            url: 'http://47.106.241.182:8082/goods/getGoodsDetailById/' + that.data.id,
            method: "GET",
            header: header,
            success(res) {
                console.log(res.data);
                if (res.data.code === 200) {
                    that.setData({
                        history_fileList: res.data.data.picturesLink,
                        goods_title: res.data.data.title,
                        goods_price: res.data.data.price,
                        goods_originalPrice: res.data.data.originalPrice,
                        goods_message: res.data.data.description,
                        history_label_list: res.data.data.tagList,
                        history_category: res.data.data.category,
                        history_condition: res.data.data.condition,
                        id: res.data.data.id,
                    })

                    that.setLabelList();
                    that.setCategoryIndex();
                    that.setPictureList();
                    that.SetCondition();
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
        let goods_List = [];
        let i = 0;
        let pictureID = [];
        var session_id = wx.getStorageSync('sessionid');
        var token = wx.getStorageSync('token');
        var header = { 'content-type': 'application/x-www-form-urlencoded', 'Cookie': session_id };
        for (i = 0; i < list.length; i++) {
            wx.request({
                url: 'http://47.106.241.182:8082/publish/getGoodsImageIdByLink',
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
            goods_List[i] = { id: pictureID[i], imageLink: list[i] };
        }
        that.setData({
            goods_fileList: goods_List
        })
    },
    /**
     * 类别转化
     */
    setCategoryIndex() {
        let that = this;
        let list = that.data.goods_class_list;
        let category = that.data.history_category;
        let i = 0;
        let categoryID;
        console.log(list);
        console.log(category);
        for (i = 0; i < list.length; i++) {
            if (category == list[i].categoryDesignation) {
                categoryID = i;
            }
        }
        that.setData({
            goods_class_list_idx: categoryID
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
        console.log(list)
        that.setData({
            goods_label_list: list
        })
    },

    /**
     * 新旧程度转换
     */
    SetCondition() {
        let that = this;
        let list = that.data.goods_old_new_list;
        let condition = that.data.history_condition;
        let i = 0;
        let conditionID = condition - 1;
        console.log(list);
        console.log(condition);
        that.setData({
            goods_old_new_list_idx: conditionID
        })
    },

    goodsTitleInput(e) {
        this.setData({
            goods_title: e.detail,
        })

    },

    goodsPriceInput(e) {
        this.setData({
            goods_price: e.detail,
        })
    },

    goodsOriginalPriceInput(e) {
        this.setData({
            goods_originalPrice: e.detail,
        })
    },

    goodsMessageInput(e) {
        this.setData({
            goods_message: e.detail,
        })
    },
    //二手物品信息修改功能
    goodModify() {
        let that = this;
        let id = that.data.id;
        let goods_title = that.data.goods_title;
        let goods_price = that.data.goods_price;
        let goods_original_price = that.data.goods_originalPrice;
        let goods_description = that.data.goods_message;
        let imageList = [];
        for (var i = 0; i < that.data.goods_fileList.length; i++)
            imageList.push(that.data.goods_fileList[i].imageLink);
        console.log(imageList);
        let goods_condition = that.data.goods_old_new_list_idx + 1;
        let goods_category = that.data.goods_class_list[that.data.goods_class_list_idx].categoryId;
        let goods_tags = that.data.goods_label_list;
        
        wx.request({
            url: 'http://120.77.210.142:8080/myGoods/alterGoods/',
            header: { "Content-Type": "application/x-www-form-urlencoded" },
            method: "POST",
            dataType:'json',
            data: {
                id: id,
                title: goods_title,
                price: goods_price,
                origin_price: goods_original_price,
                description: goods_description,
                category: goods_category,
                condition: goods_condition,
                images_link: imageList,
                tags: goods_tags,
            },
            success(res){
                console.log(res.data.code);
                console.log(res.data.message);
                wx.redirectTo({
                  url: '/pages/goods/goods',
                })
            },
            fail(err){
                wx.showToast({ title: '系统错误' })
            }
        })
        // that.setData({
        //     goods_fileList: imageList
        // })
    },
    //二手物品信息发布功能
    goodsRelease() {
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

        wx.request({
            url: that.data.goods_releaseUrl,
            header: { "Content-Type": "application/x-www-form-urlencoded" },
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

            complete: function (res) {
                if (res == null || res.data == null) { console.error('网络请求失败'); return; } else {
                    wx.showModal({
                        title: "提示",
                        content: "二手物品信息发布成功",
                    })
                }
            }
        })
    },

    //二手交易上传图片方法
    goodsUpload() {
        let that = this;
        wx.chooseImage({
            sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
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
                            "Content-Type": "multipart/form-data"
                        },
                        success: function (res) {
                            let imageFile = that.data.goods_fileList;
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
                        fail: function (res) {
                            wx.hideToast();
                            wx.showModal({
                                title: '错误提示',
                                content: '上传图片失败',
                                showCancel: false,
                                success: function (res) { }
                            })
                        }
                    });
                }

            }
        })
    },

    //预览二手交易图片方法
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
            success: function (res) {
                //console.log(res);
            },
            //也根本不走
            fail: function () {
                //console.log('fail')
            }
        })
    },

    //删除二手交易图片
    goodsDeleteImage: function (e) {
        var that = this;
        var tempFilePaths = that.data.goods_fileList;
        
        var index = e.currentTarget.dataset.id; //获取当前长按图片下标
        console.log(index);
        var tempId = tempFilePaths[index].id;
        wx.showModal({
            title: '提示',
            content: '确定要删除此图片吗？',
            success: function (res) {
                if (res.confirm) {
                    wx.request({
                        url: that.data.goods_deleteUrl + tempId,
                        header: {
                            'content-type': 'application/json' // 默认值

                        },
                        success: function (res) {
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
                    goods_fileList: that.data.tempFilePaths,
                });
            }
        })
    },

    //新旧程度单选功能
    goodsOldNewListSelectApply(e) {
        let id = e.target.dataset.id
        this.setData({
            goods_old_new_list_idx: id
        })
    },

    //二手类别单选功能
    goodsClassListSelectApply(e) {
        let id = e.target.dataset.id
        this.setData({
            goods_class_list_idx: id
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
            success: function (res) {
                let goods_list = new Array();
                res.data.data.forEach(function (e) {
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
            fail: function (fail) {
                // 这里是失败的回调，取值方法同上,把res改一下就行了  
            },
            complete: function (arr) {
                // 这里是请求以后返回的所以信息，请求方法同上，把res改一下就行了  
            }
        })
    },

    //删除二手交易标签
    goodsDeleteLabel(e) {
        var goods_label_list = this.data.goods_label_list;

        var index = e.currentTarget.dataset.id; //获取当前长按图片下标
        console.log(index);
        goods_label_list.splice(index, 1);

        this.setData({
            goods_label_list: goods_label_list,
        })
    },

    goodsTagInput(e) {
        this.setData({
            goods_tag: e.detail.value
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
    onLoad: function (options) {
        let goodsId = options.id;
        this.setData({
            id: goodsId
        })
        this.getGoodsClassList();
        this.getHistoryGoodsList();
    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {
        if (this.data.goods_tag) {
            this.data.goods_label_list.push(this.data.goods_tag.replaceAll(" ", ""));
            this.setData({
                goods_label_list: this.unique(this.data.goods_label_list),
                goods_tag: "",

            })
        }
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

    }
})