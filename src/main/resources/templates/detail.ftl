<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>秒杀详情页</title>
</head>
<#include "header.ftl">
<body>
<div class="container">
    <div class="panel panel-defaule text-center">
        <div class="panel-heading">
            <h1>${seckill.name}</h1></br>
            <h2 class="text-danger">
                <!--显示time图标-->
                <span class="glyphicon glyphicon-time"></span>
                <!-- 展示倒计时 -->
                <span class="glyphicon" id="seckill-box"></span>
            </h2>
        </div>
    </div>
</div>
<!-- 登陆弹出层 -->
<!-- 模态框（Modal） -->
<div class="modal fade" id="killPhoneModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-phone"></span>
                    秒杀电话:
                </h3>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" name="killPhone" id="killPhoneKey"
                               placeholder="填手机号" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <span id="killPhoneMessage" class="glyphicon"></span>
                <button type="button" id="killPhoneBtn" class="btn btn-success">
                    <span class="glyphicon glyphicon-phone"></span>
                    Submit
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script src="/common/jquery.cookie-1.4.1.min.js"></script>
<script src="/common/jquery.countdown.js"></script>
<!-- 交互逻辑 -->
<script src="/script/seckill.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        var startTime = new Date("${seckill.startTime?datetime?string.iso}");
        var endTime = new Date("${seckill.endTime?datetime?string.iso}");

        //使用EL表达式传入参数
        seckill.detail.init({
            seckillId : ${seckill.seckillId?c},
            startTime : startTime.getTime(),//毫秒
            endTime : endTime.getTime()
        });
    });
</script>
</html>