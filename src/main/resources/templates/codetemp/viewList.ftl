<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>${table.comments}列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <th:block th:include="include :: public_css" />
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main" id="app">

        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                <#list table.columnList as c>
                    <#if c.isQuery?string('1','0') == "1">
                        <div class="layui-inline">
                            <label class="layui-form-label">${c.comments}</label>
                            <div class="layui-input-inline">
                                <#if c.showType == "input" || c.showType == "textarea">
                                    <input type="text" name="${c.javaField}" v-model="entity.${c.javaField}" autocomplete="off" class="layui-input">
                                <#elseif c.showType == "select">

                                <#elseif c.showType == "checkbox">

                                <#elseif c.showType == "radiobox">

                                <#elseif c.showType == "dateselect">

                                </#if>
                            </div>
                        </div>
                    </#if>
                </#list>
                        <div class="layui-inline">
                            <button type="button" class="layui-btn layui-btn-primary" v-on:click="getData(1)"><i class="layui-icon"></i> 搜 索</button>
                            <button type="button"  th:if="${"$"}{${"@"}permission.check('${moduleName}:${className}:add')}" class="layui-btn" v-on:click="add()"><i class="layui-icon"></i> 添 加</button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

        <div style="overflow-x: auto">
            <table class="layui-table" >
                <thead>
                <tr>
                    <th>序号</th>
            <#list table.columnList as c>
                <#if c.isList?string('1','0') == "1">
                    <th>${c.comments}</th>
                </#if>
            </#list>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="(${className},index) in page.list">
                    <td>{{(index+1)+(pageNum-1)*pageSize}}</td>
            <#list table.columnList as c>
                <#if c.isList?string('1','0') == "1">
                    <td>
                    <#if c.showType == "select">

                    <#elseif c.showType == "select" || c.showType == "checkbox" || c.showType == "radiobox">

                    <#else>
                        {{${className}.${c.javaField}}}
                    </#if>
                    </td>
                </#if>
            </#list>
                    <td style="word-break: keep-all;white-space:nowrap;">
                        <a href="javascript:void(0)" th:if="${"$"}{${"@"}permission.check('${moduleName}:${className}:edit')}" @click="edit(${className}.id);" class="layui-btn layui-btn-sm">编辑</a>
                        <a href="javascript:void(0)" th:if="${"$"}{${"@"}permission.check('${moduleName}:${className}:del')}" @click="del(${className}.id)" class="layui-btn layui-btn-sm layui-btn-danger">删除</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

        <span id="page"></span>
    </div>
</div>

<th:block th:include="include :: public_js" />

<script>
    var app;
    function flashData(){
        app.getData(0)
    };
    layui.use(['laypage','layer'], function(){
        var $ = layui.jquery;
        var laypage = layui.laypage;
        var layer = layui.layer;
        app = new Vue({
            el: '#app',
            data: {
                pageUrl: "/${moduleName}/${className}/page",
                page:{},
                pageNum:1,
                pageSize:5,
                entity:{
                    <#list table.columnList as c>
                    <#if c.isQuery?string('1','0') == "1">
                    "${c.javaField}":"",
                    </#if>
                    </#list>
                }
            },
            methods: {
                getData: function (pageNum) {
                    if (1 == pageNum) app.$data.pageNum = 1;
                    $.operate.getPageData(laypage,app);
                },
                add: function () {
                    $.modal.open("新增${table.comments}",'/${moduleName}/${className}/form')
                },
                edit: function (id) {
                    $.modal.open("编辑${table.comments}",'/${moduleName}/${className}/form?id='+id)
                },
                del:function (id) {
                    $.operate.del('/${moduleName}/${className}/del/'+id,laypage,layer,app);
                }
            }
        });

        layer.ready(function(){
            app.getData(0)
        });
    });
</script>

</body>

</html>