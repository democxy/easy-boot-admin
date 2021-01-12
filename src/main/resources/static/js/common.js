(function ($) {
    $.extend({
        modal: {
            // 显示图标
            icon: function (type) {
                var icon = "";
                if (type == modal_status.WARNING) {
                    icon = 0;
                } else if (type == modal_status.SUCCESS) {
                    icon = 1;
                } else if (type == modal_status.FAIL) {
                    icon = 2;
                } else {
                    icon = 3;
                }
                return icon;
            },
            // 消息提示
            msg: function (content, type) {
                if (type != undefined) {
                    layer.msg(content, {icon: $.modal.icon(type), time: 1000, shift: 5});
                } else {
                    layer.msg(content);
                }
            },
            // 错误消息
            msgError: function (content) {
                $.modal.msg(content, modal_status.FAIL);
            },
            // 成功消息
            msgSuccess: function (content) {
                $.modal.msg(content, modal_status.SUCCESS);
            },
            // 警告消息
            msgWarning: function (content) {
                $.modal.msg(content, modal_status.WARNING);
            },
            // 弹出提示
            alert: function (content, type) {
                layer.alert(content, {
                    icon: $.modal.icon(type),
                    title: "系统提示",
                    btn: ['确认'],
                    btnclass: ['btn btn-primary'],
                });
            },
            // 消息提示并刷新父窗体
            msgReload: function (msg, type) {
                layer.msg(msg, {
                        icon: $.modal.icon(type),
                        time: 500,
                        shade: [0.1, '#8F8F8F']
                    },
                    function () {
                        $.modal.reload();
                    });
            },
            // 错误提示
            alertError: function (content) {
                $.modal.alert(content, modal_status.FAIL);
            },
            // 成功提示
            alertSuccess: function (content) {
                $.modal.alert(content, modal_status.SUCCESS);
            },
            // 警告提示
            alertWarning: function (content) {
                $.modal.alert(content, modal_status.WARNING);
            },
            // 关闭窗体
            close: function () {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            },
            // 关闭全部窗体
            closeAll: function () {
                layer.closeAll();
            },
            // 确认窗体
            confirm: function (content, callBack) {
                layer.confirm(content, {
                    icon: 3,
                    title: "系统提示",
                    btn: ['确认', '取消']
                }, function (index) {
                    layer.close(index);
                    callBack(true);
                });
            },
            // 弹出层指定宽度
            open: function (title, url, width, height) {
                //如果是移动端，就使用自适应大小弹窗
                if ($.common.isMobile()) {
                    /*width = 'auto';
                    height = 'auto';*/
                }
                if ($.common.isEmpty(title)) {
                    title = false;
                }
                if ($.common.isEmpty(url)) {
                    url = "/404.html";
                }
                if ($.common.isEmpty(width)) {
                    width = '80%';
                }
                if ($.common.isEmpty(height)) {
                    height = '80%';
                }
                layer.open({
                    type: 2,
                    area: [width, height ],
                    fix: false,
                    //不固定
                    maxmin: true,
                    shade: 0.3,
                    title: title,
                    content: url,
                    // 弹层外区域关闭
                    shadeClose: true
                });
            },
            // 弹出层指定宽度
            openWithButton: function (title, url, width, height, callback) {
                //如果是移动端，就使用自适应大小弹窗
                if ($.common.isMobile()) {
                    width = 'auto';
                    height = 'auto';
                }
                if ($.common.isEmpty(title)) {
                    title = false;
                }
                if ($.common.isEmpty(url)) {
                    url = "/404.html";
                }
                if ($.common.isEmpty(width)) {
                    width = '80%';
                }
                if ($.common.isEmpty(height)) {
                    height = '80%';
                }
                if ($.common.isEmpty(callback)) {
                    callback = function (index, layero) {
                        var iframeWin = layero.find('iframe')[0];
                        iframeWin.contentWindow.submitHandler(index, layero);
                    }
                }
                layer.open({
                    type: 2,
                    area: [width, height ],
                    fix: false,
                    //不固定
                    maxmin: true,
                    shade: 0.3,
                    title: title,
                    content: url,
                    btn: ['确定', '关闭'],
                    // 弹层外区域关闭
                    shadeClose: true,
                    yes: callback,
                    cancel: function (index) {
                        return true;
                    }
                });
            },
            // 禁用按钮
            disable: function () {
                var doc = window.top == window.parent ? window.document : window.parent.document;
                $("a[class*=layui-layer-btn]", doc).addClass("layer-disabled");
            },
            // 启用按钮
            enable: function () {
                var doc = window.top == window.parent ? window.document : window.parent.document;
                $("a[class*=layui-layer-btn]", doc).removeClass("layer-disabled");
            },
            // 重新加载
            reload: function () {
                parent.location.reload();
            }
        },
        // 通用方法封装处理
        common: {
            // 判断字符串是否为空
            isEmpty: function (value) {
                if (value == null || this.trim(value) == "") {
                    return true;
                }
                return false;
            },
            // 判断一个字符串是否为非空串
            isNotEmpty: function (value) {
                return !$.common.isEmpty(value);
            },
            // 空对象转字符串
            nullToStr: function(value) {
                if ($.common.isEmpty(value)) {
                    return "-";
                }
                return value;
            },
            // 是否显示数据 为空默认为显示
            visible: function (value) {
                if ($.common.isEmpty(value) || value == true) {
                    return true;
                }
                return false;
            },
            // 空格截取
            trim: function (value) {
                if (value == null) {
                    return "";
                }
                return value.toString().replace(/(^\s*)|(\s*$)|\r|\n/g, "");
            },
            // 比较两个字符串（大小写敏感）
            equals: function (str, that) {
                return str == that;
            },
            // 比较两个字符串（大小写不敏感）
            equalsIgnoreCase: function (str, that) {
                return String(str).toUpperCase() === String(that).toUpperCase();
            },
            // 将字符串按指定字符分割
            split: function (str, sep, maxLen) {
                if ($.common.isEmpty(str)) {
                    return null;
                }
                var value = String(str).split(sep);
                return maxLen ? value.slice(0, maxLen - 1) : value;
            },
            // 字符串格式化(%s )
            sprintf: function (str) {
                var args = arguments, flag = true, i = 1;
                str = str.replace(/%s/g, function () {
                    var arg = args[i++];
                    if (typeof arg === 'undefined') {
                        flag = false;
                        return '';
                    }
                    return arg;
                });
                return flag ? str : '';
            },
            // 获取节点数据，支持多层级访问
            getItemField: function (item, field) {
                var value = item;
                if (typeof field !== 'string' || item.hasOwnProperty(field)) {
                    return item[field];
                }
                var props = field.split('.');
                for (var p in props) {
                    value = value && value[props[p]];
                }
                return value;
            },
            // 指定随机数返回
            random: function (min, max) {
                return Math.floor((Math.random() * max) + min);
            },
            // 判断字符串是否是以start开头
            startWith: function(value, start) {
                var reg = new RegExp("^" + start);
                return reg.test(value)
            },
            // 判断字符串是否是以end结尾
            endWith: function(value, end) {
                var reg = new RegExp(end + "$");
                return reg.test(value)
            },
            // 数组去重
            uniqueFn: function(array) {
                var result = [];
                var hashObj = {};
                for (var i = 0; i < array.length; i++) {
                    if (!hashObj[array[i]]) {
                        hashObj[array[i]] = true;
                        result.push(array[i]);
                    }
                }
                return result;
            },
            // 数组中的所有元素放入一个字符串
            join: function(array, separator) {
                if ($.common.isEmpty(array)) {
                    return null;
                }
                return array.join(separator);
            },
            // 获取form下所有的字段并转换为json对象
            formToJSON: function(formId) {
                var json = {};
                $.each($("#" + formId).serializeArray(), function(i, field) {
                    if(json[field.name]) {
                        json[field.name] += ("," + field.value);
                    } else {
                        json[field.name] = field.value;
                    }
                });
                return json;
            },
            // 数据字典转下拉框
            dictToSelect: function(datas, value, name) {
                var actions = [];
                actions.push($.common.sprintf("<select class='form-control' name='%s'>", name));
                $.each(datas, function(index, dict) {
                    actions.push($.common.sprintf("<option value='%s'", dict.dictValue));
                    if (dict.dictValue == ('' + value)) {
                        actions.push(' selected');
                    }
                    actions.push($.common.sprintf(">%s</option>", dict.dictLabel));
                });
                actions.push('</select>');
                return actions.join('');
            },
            // 获取obj对象长度
            getLength: function(obj) {
                var count = 0;
                for (var i in obj) {
                    if (obj.hasOwnProperty(i)) {
                        count++;
                    }
                }
                return count;
            },
            // 判断移动端
            isMobile: function () {
                return navigator.userAgent.match(/(Android|iPhone|SymbianOS|Windows Phone|iPad|iPod)/i);
            },
        },
        operate: {
            get: function(url,callback){
                var config = {
                    url: url,
                    type: "get",
                    dataType: "json",
                    headers: {
                        'token': $.cookie("token")
                    },
                    success: function(result) {
                        if (result.code == 4040){
                            if ("auto" == result.data){
                                $.operate.reflashToken();
                                $.operate.get(url,callback);
                            }else {
                                $.modal.confirm(result.msg,function () {
                                    window.parent.location.href = "/admin/sys/login"
                                })
                            }
                        }else if (result.code != 200){
                            $.modal.msgError(result.msg)
                            return;
                        }else {
                            if (typeof callback == "function") {
                                callback(result);
                            }
                        }

                    }
                };
                $.ajax(config)
            },
            // 保存信息 刷新表格
            post: function(url, data, callback) {
                var config = {
                    url: url,
                    type: "post",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(data),
                    headers: {
                        'token': $.cookie("token")
                    },
                    // beforeSend: function () {
                    //     $.modal.loading("正在处理中，请稍后...");
                    //     $.modal.disable();
                    // },
                    success: function(result) {
                        if (result.code == 4040){
                            if ("auto" == result.data){
                                $.operate.reflashToken();
                                $.operate.post(url,data,callback);
                            }else {
                                $.modal.confirm(result.msg,function () {
                                    window.parent.location.href = "/admin/sys/login"
                                })
                            }
                        }else if (result.code != 200){
                            $.modal.msgError(result.msg)
                            return;
                        }else {
                            if (typeof callback == "function") {
                                callback(result);
                            }
                        }

                    }
                };
                $.ajax(config)
            },
            // 共用提交表单事件
            submit: function(url, data, callback) {
                var config = {
                    url: url,
                    type: "post",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(data),
                    headers: {
                        'token': $.cookie("token")
                    },
                    // beforeSend: function () {
                    //     $.modal.loading("正在处理中，请稍后...");
                    //     $.modal.disable();
                    // },
                    success: function(result) {
                        if (result.code == 4040){
                            if ("auto" == result.data){
                                $.operate.reflashToken();
                                $.operate.submit(url,data,callback);
                            }else {
                                $.modal.confirm(result.msg,function () {
                                    window.parent.location.href = "/admin/sys/login"
                                })
                            }
                        }else if (result.code != 200){
                            $.modal.msgError(result.msg+","+result.data);
                            return;
                        }else {
                            if (typeof callback == "function") {
                                callback(result);
                            }
                            $.operate.successCallback(result);
                        }

                    }
                };
                $.ajax(config)
            },
            // 成功回调执行事件（父窗体静默更新）
            successCallback: function(result) {
                if (result.code == 200){
                    $.modal.msgSuccess("操作成功")
                    var parent = window.parent;
                    parent.flashData();
                    $.modal.close();
                }else {
                    $.modal.msgError(result.msg+","+result.data);
                    return;
                }
            },
            reflashToken: function(){
                $.ajax({
                    url: "/admin/account/autoLogin",
                    type: "post",
                    async: false,
                    dataType: "json",
                    data: {
                        "token":$.cookie("token")
                    },
                    success :function (result) {
                        if (result.code == 200){
                            sessionStorage.setItem("token",result.data);
                            return;
                        }else {
                            $.modal.msgError(result.msg+","+result.data);
                        }
                    }
                })
            },
            // 共用分页事件
            setPage:function (laypage,app) {
                laypage.render({
                    elem: 'page' //注意，这里的 test1 是 ID，不用加 # 号
                    ,curr: app.$data.page.pageNum
                    ,count: app.$data.page.total //数据总数，从服务端得到
                    ,layout: [ 'prev', 'page', 'next', 'limit', 'limits']
                    ,limits:[5,10,20,50]
                    ,limit:app.$data.page.pageSize
                    ,jump: function(obj, first){
                        //obj包含了当前分页的所有参数，比如：
                        // console.info(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                        // console.info(obj.limit); //得到每页显示的条数
                        //首次不执行
                        app.pageNum = obj.curr
                        app.pageSize = obj.limit
                        if(!first){
                            $.operate.getPageData(laypage,app);
                        }
                    }
                });
            },
            // 共用获取分页数据事件
            getPageData:function (laypage,app) {
                var baseQuery = {
                    "pageNum":app.$data.pageNum,
                    "pageSize":app.$data.pageSize,
                    "entity":app.$data.entity
                };
                $.operate.post( app.$data.pageUrl, baseQuery,function (callData) {
                    app.page = callData.data
                    app.pageNum = app.$data.page.pageNum
                    app.pageSize = app.$data.page.pageSize
                    $.operate.setPage(laypage,app);
                });
            },
            // 共用删除事件
            del:function (url,laypage,layer,app,msg) {
                if ($.common.isEmpty(msg)){
                    msg = "确定要删除吗？"
                }
                layer.confirm(msg, function (index) {
                    $.operate.get(url,function (data) {
                        if (app.$data.pageNum!=1){
                            var lastSize = app.$data.page.total-(app.$data.pageNum-1)*app.$data.pageSize;
                            if (lastSize == 1){
                                app.$data.pageNum --;
                            }
                        }
                        $.operate.getPageData(laypage,app);
                        layer.close(index);
                    })
                });
            }
        }
    })
})(jQuery);


/** 消息状态码 */
web_status = {
    SUCCESS: 0,
    FAIL: 500,
    WARNING: 301
};

/** 弹窗状态码 */
modal_status = {
    SUCCESS: "success",
    FAIL: "error",
    WARNING: "warning"
};