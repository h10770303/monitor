<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SMG融媒体中心制播系统账号申请</title>

    <link type="text/css" rel="stylesheet" href="easyui/js/jquery-easyui-1.5.3/themes/default/easyui.css"/>
    <link type="text/css" rel="stylesheet" href="easyui/js/jquery-easyui-1.5.3/themes/icon.css"/>
    <link type="text/css" rel="stylesheet" href="easyui/css/main.css">

</head>
<body>

<div class="easyui-layout" id="mainBox">
    <div data-options="region:'north',split:true" style="height: 80px" class="mainTop">
        <div class="topLogin"><img src="easyui/img/ssjsk.png"/> <div class="topLongRight">SMG融媒体中心制播系统账号申请系统</div></div>
        <div class="topText">
            <a href="apply.do" class="textActive" target="frameName">
                <p style="margin-top: 10px"><img src="easyui/img/low01.png"/> </p>
                <p style="margin-top: 5px">账号申请</p>
            </a>
            <a href="applyList.do?flag=sp" target="frameName" >
            <p style="margin-top: 10px"><img src="easyui/img/low02.png"/> </p>
            <p style="margin-top: 5px">领导审批</p>
        </a>
            <a href="applyList.do?flag=gd"  target="frameName">
                <p style="margin-top: 10px"><img src="easyui/img/action.png"/> </p>
                <p style="margin-top: 5px">技术归档</p>
            </a>
            <a href="applyWxcode.do"  target="frameName">
                <p style="margin-top: 10px"><img src="easyui/img/rqcode.png"/> </p>
                <p style="margin-top: 5px">二维码</p>
            </a>
           <!--  <a href="applyList.do?flag=cx" target="frameName">
                <p style="margin-top: 10px"><img src="easyui/img/ogrn.png"/> </p>
                <p style="margin-top: 5px">账号记录查询</p>
            </a> -->
        </div>
        
    </div>
    <div data-options="region:'south',split:true" style="height:40px;" class="footStyle">
         版本所有@2019-2020 技术运营中心 电视制作部 系统值班室（ 座机51500 51460 短号58002）
    </div>
    <div data-options="region:'center'" style="padding:5px;background:#eee;">
        <div id="con">
            <div id="tabName" title="账号申请" >
               <iframe frameborder="0" width="100%" height="100%" name="frameName" src="apply.do" scrolling="auto" id="ifDiv" ></iframe>
            </div>
        </div>

    </div>
</div>
<div id="myMes" style="display: none;">

<p><label class="diaLable">用户名：</label><input  class="easyui-validatebox TailInput" disabled="disabled" data-options="required:true,novalidate:true" value="张林海"></p>
   <p><label class="diaLable">登录名称：</label><input  class="easyui-validatebox TailInput" data-options="required:true" value="zhanglinghai"></p>
    <p><label class="diaLable">用户密码：</label><input  type="password" value="123456" class="easyui-validatebox TailInput" data-options="required:true,"></p>
    <p><label class="diaLable">用户角色：</label><input  class="easyui-validatebox TailInput" disabled="disabled" data-options="required:true,novalidate:true" value="管理员"></p>
    <p><label class="diaLable">所属部门：</label><input  class="easyui-validatebox TailInput" disabled="disabled" data-options="required:true,novalidate:true" value="行政部门"></p>
    <p><label class="diaLable areaLabel">描述：</label><textarea class="TailArea01" ></textarea></p>
    <div class="forSubmint"> <a href="#" class="easyui-linkbutton"  iconCls="icon-save" >保存</a><a href="#" class="easyui-linkbutton"  iconCls="icon-redo" >重置</a> </div>
</div>

<script src="easyui/js/jquery-easyui-1.5.3/jquery.min.js"></script>
<script src="easyui/js/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
<script src="easyui/js/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
<script src="easyui/js/hh/index.js"></script>

</body>
</html>