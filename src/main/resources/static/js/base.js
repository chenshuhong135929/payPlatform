var REQUEST_URL = "";//根目录

$(function () {
    $(".setCookieBtn").click(function () {
        var userLocal = $.cookie('userLocal');
        var useLocal = "zh_CN";
        if(userLocal){
            if(userLocal == useLocal){
                useLocal = "en_US";
            }
        }

        $.cookie("userLocal", useLocal, { expires: 365 });
        location.href = location.href;
    });


});


var payPlatform = {
    api_request : function (name, params, cb, scope, async, el) {
        var loadIndex = payPlatform.load();
        if (async == null)
            async = true;

        console.log('调用接口:\n%s,\n参数列表:', REQUEST_URL + name, params);
        $.ajax({
            url: REQUEST_URL + name,
            async: async,
            data: params,
            type: 'POST',
            dataType: 'json',
            cache: false,
            timeout: 70000,
            success: function (data, textStatus) {
                //alert(data.obj[0].id);
                payPlatform.closeLoad(loadIndex);
                cb.call(scope || window, data, textStatus);
            },
            error: function (xhr) {
                payPlatform.closeLoad(loadIndex);
                alert("readyState: " + xhr.readyState + "\nstatus: " + xhr.status);
            }
        });
    },
    checkIsNullOrEmpty: function (value) {
        var reg = /^\s*$/
        //返回值为true表示是空字符串
        return !(value != null && value != undefined && !reg.test(value))
    },
    load : function(){
       return  layer.load(1, {
                 shade: [0.1,'#fff'] //0.1透明度的白色背景
             });
    },
    closeLoad :function(index){
        layer.close(index);
    },
    alert:function(message,fn){
        if(fn){
           return layer.alert(message,fn)
        }else{
            return  layer.alert(message)
        }
    },
    confirm : function(message,yesFn,noFn) {
       return layer.confirm(message,yesFn,noFn)
    },

    uploadFile : function(url,file,outherParameter,uploadComplete) {

        var load = payPlatform.load();
        var fd = new FormData();
        fd.append("file", file);
        if(outherParameter){
            for(var key in outherParameter){
                fd.append(key , outherParameter[key]);
            }
        }
        var xhr = new XMLHttpRequest();
        xhr.addEventListener("load", function (evt) {
            uploadComplete(evt);
            payPlatform.closeLoad(load);
        }, false);
        xhr.addEventListener("error", function(ev){
            console.log("上传文件失败" + ev);
            payPlatform.closeLoad(load);
        }, false);
        xhr.open("POST", url); //修改成自己的接口
        xhr.send(fd);
    },
    getFormStr: function (obj, key) {
        key = key || "";
        var values = "";
        if (!obj) return "";
        // 如果是数组
        if ($.isArray(obj)) {
            var index = 0;
            obj.forEach(function (value) {
                values += payPlatform.getFormStr(value, key + "[" + (index++) + "]");
            })
            // 按对象处理
        } else if (typeof obj == "object") {
            for (childname in obj) {
                if (obj.hasOwnProperty(childname)) {
                    var childkey = key ? (key + "." + childname) : key + childname;
                    values += payPlatform.getFormStr(obj[childname], childkey)
                }

            }
        } else {
            return (key + "=" + obj) + "&";
        }

        return values;
    },

};