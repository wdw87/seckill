<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>秒杀详情页</title>

</head>
<#include "header.ftl">
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>秒杀列表</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>名称</th>
                    <th>库存</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>创建时间</th>
                    <th>详情</th>
                </tr>
                </thead>
                <tbody>
                <#list list as sk>
                    <tr>
                        <td>${sk.name}</td>
                        <td>${sk.number}</td>
                        <td>${sk.startTime?string("yyyy-MM-dd hh:mm:ss")}</td>
                        <td>${sk.endTime?string("yyyy-MM-dd hh:mm:ss")}</td>
                        <td>${sk.createTime?string("yyyy-MM-dd hh:mm:ss")}</td>
                        <td><a class="btn btn-info" href="/seckill/${sk.seckillId?c}/detail" target="_blank">link</a></td>
                    </tr>
                </#list>

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>