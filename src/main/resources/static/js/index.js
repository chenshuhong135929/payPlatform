
            var vm = new Vue({
                el: '#content_list',
                data : {
                    pageModel: {
                        data:[],
                        pageSize : 10,
                        pageNo : 1,
                        total : 0,
                        start: 1,
                        end: 8,
                        pageCount: 5,
                        pageCounts : [],
                        isShowPrevious: false,
                        isShowNext: false,
                        dataLen : false
                    },
                    showAddBoxContentBox : false,
                    cuuerMerchant : {},
                    updateMerchant : {},
                    uploadBusinessLicenseMerchant : null//选择要重新上传营业执照的数据id
                },
                methods : {
                    findPageMerchant : function (page) {
                        var _this = this;
                        var searchContent = $("#searchContent").val();
                        var load = payPlatform.load();
                        payPlatform.api_request(REQUEST_URL + "/merchant/pageMerchant",{pageNo:page , searchContent :searchContent},function(data){
                            var pageModel =  _this.pageModel;
                            pageModel.data = data.data.data;
                            if(pageModel.data.length > 0){
                                pageModel.dataLen = false;

                            }else{
                                pageModel.dataLen = true;
                            }

                            pageModel.pageNo = data.data.pageNo;
                            pageModel.pageSize = data.data.pageSize;
                            pageModel.total = data.data.total;
                            pageModel.total = Math.ceil((pageModel.total / pageModel.pageSize ));
                            //判断上一页、下一页是否显示
                            if ((pageModel.pageNo == 1 && pageModel.total == 1) || pageModel.total == 0) {
                                pageModel.isShowPrevious = false;
                                pageModel.isShowNext = false;
                            } else if (pageModel.pageNo == 1 && pageModel.total != 1 && pageModel.total != 0) {
                                pageModel.isShowPrevious = false;
                                pageModel.isShowNext = true;
                            } else if (pageModel.pageNo == pageModel.total) {
                                pageModel.isShowPrevious = true;
                                pageModel.isShowNext = false;
                            } else {
                                pageModel.isShowPrevious = true;
                                pageModel.isShowNext = true;
                            }
                            if (pageModel.total < 9){
                                pageModel.end = pageModel.total;
                            }

                            pageModel.pageCounts  = [];

                            if (pageModel.pageNo == pageModel.end && pageModel.end < pageModel.total) {
                                pageModel.start++;
                                pageModel.end++;
                            } else if (vm.pageModel.pageNo == pageModel.start && pageModel.start > 1) {
                                pageModel.start--;
                                pageModel.end--;
                            }
                            //获取显示的椰树
                                for (var i = pageModel.start; i <= pageModel.end; i++) {
                                    pageModel.pageCounts.push({
                                        pages: i,
                                        isActive: i == pageModel.pageNo ? true : false,
                                        isSlpt : false,
                                    })
                                }

                            payPlatform.closeLoad(load);
                            console.log(pageModel.pageNo);

                        });
                    },
                    pageClick : function (e) {
                        this.findPageMerchant(event.target.innerHTML.trim());
                    },
                    previous :function() {
                        this.pageModel.pageNo--;
                        this.findPageMerchant(this.pageModel.pageNo);
                    },
                    next : function () {
                        this.pageModel.pageNo++;
                        this.findPageMerchant(this.pageModel.pageNo);
                    },
                    search : function () {
                        this.pageModel.pageNo = 1;
                        this.pageModel.start = 1;
                        this.pageModel.end = 8;
                        this.findPageMerchant(this.pageModel.pageNo);
                    },
                    //打开显示商户弹框
                    addMerchant : function (merchant) {


                        this.cuuerMerchant = Object.assign({}, merchant)
                        this.addBoxContent = true;
                    },
                    //打开修改弹框
                    showUpdateMerchantModel : function (merchant) {
                        this.updateMerchant = Object.assign({}, merchant)
                    },
                    //刷新表格
                    refresh : function () {
                        this.findPageMerchant(this.pageModel.pageNo);
                    },
                    //修改冻结非冻结状态
                    updateDisableStatus : function (disableStatus,id) {
                        var message = "你确定要激活选择的数据吗?";
                        if(disableStatus == 'A'){
                            message = "你确定要冻结选择的数据吗?";
                        }
                      var updateStatusLoad =   payPlatform.confirm(message,function () {
                            payPlatform.api_request(REQUEST_URL + "/merchant/updateDisableStatus",{disableStatus:disableStatus,id:id},function (data) {
                                if(data.code == 200){
                                    payPlatform.alert("请求成功");
                                    vm.refresh();
                                }else{
                                    payPlatform.alert("请求失败");
                                }
                                layer.close(updateStatusLoad);
                            });
                        },function () {
                          layer.close(updateStatusLoad);

                        });


                    },
                    showBindMerchantFileBox : function(merchant){
                         this.uploadBusinessLicenseMerchant = merchant;
                    },


                    uploadHreadImg : function(){
                        this.$api.post();
                    }

                },
                created:function(){
                    this.findPageMerchant(this.pageModel.pageNo);
                }


            });