<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>${table.comments}管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <th:block th:include="include :: public_css" />
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<div class="layui-row" id="app">
    <form class="layui-form" id="form-member-add">
        <input type="hidden" name="id" v-model="${className}.id">
<#list table.columnList as c>
    <#if c.isEdit?string('1','0') == "1">
        <div class="layui-form-item">
            <label class="layui-form-label required">${c.comments}</label>
            <div class="layui-input-block">
                <#if c.showType == "input">
                    <input type="text" name="${c.javaField}" v-model="${className}.${c.javaField}" <#if c.isNull?string('1','0') == "0">lay-verify="required" lay-reqtext="${c.comments}不能为空"</#if>  placeholder="请输入${c.comments}" value="" class="layui-input">
                <#elseif c.showType == "textarea">

                <#elseif c.showType == "select">

                <#elseif c.showType == "checkbox">

                <#elseif c.showType == "radiobox">

                <#elseif c.showType == "dateselect">

                <#elseif c.showType == "fileselect">

                </#if>
            </div>
        </div>
    </#if>
</#list>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-normal"  th:if="${"$"}{${"@"}permission.check('${moduleName}:${className}:save')}" lay-submit lay-filter="saveBtn">确认保存</button>
            </div>
        </div>
    </form>
</div>

<th:block th:include="include :: public_js" />
<script th:inline="javascript">
    var app = new Vue({
        el: '#app',
        data: {
            ${className}: [[${"${"+className+"}"}]]
        }
    })

    layui.use(['form','tree'], function () {
        var form = layui.form,
            layer = layui.layer,
            tree = layui.tree,
            $ = layui.jquery;

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            $.operate.submit("/${moduleName}/${className}/save", app.$data.${className});
            return false;
        });

    });
</script>
</body>
</html>
