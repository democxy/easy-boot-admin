// 字典回显过滤器
Vue.filter('getDictLabel', function (value, type) {
    var re = "";
    var data = {
        "value": value,
        'type': type
    }
    $.operate.post("/admin/dict/list", data, function (result) {
        var data = result.data[0];
        console.info(JSON.stringify(data))
        re = data.label
    })
    return re;
})

// 字典列表数据加载
Vue.prototype.getDictList = function (type){ //changeData是函数名
    var data = {
        'type': type
    }
    $.operate.post("/admin/dict/list", data, function (result) {
        console.info(JSON.stringify(result.data))
        return result.data
    })
}