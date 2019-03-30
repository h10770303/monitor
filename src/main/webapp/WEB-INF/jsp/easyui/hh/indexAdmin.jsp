<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SMG融媒体中心制播系统账号申请管理页面</title>

    <link type="text/css" rel="stylesheet" href="easyui/js/jquery-easyui-1.5.3/themes/default/easyui.css"/>
    <link type="text/css" rel="stylesheet" href="easyui/js/jquery-easyui-1.5.3/themes/icon.css"/>
    <link type="text/css" rel="stylesheet" href="easyui/css/main.css">

</head>
<body>

<div class="easyui-layout" id="mainBox">
    <div data-options="region:'north',split:true" style="height: 80px" class="mainTop">
        <div class="topLogin"><img src="easyui/img/ssjsk.png"/> <div class="topLongRight">SMG融媒体中心制播系统账号申请系统管理页面</div></div>
        <div class="topText">
            <a href="applyLeader.do" class="textActive" target="frameName">
                <p style="margin-top: 10px"><img src="easyui/img/low01.png"/> </p>
                <p style="margin-top: 5px">人员管理</p>
            </a>
            <a href="applyColum.do" target="frameName" >
            <p style="margin-top: 10px"><img src="easyui/img/low02.png"/> </p>
            <p style="margin-top: 5px">频道管理</p>
        </a>
        </div>
        
    </div>
    <div data-options="region:'south',split:true" style="height:40px;" class="footStyle">
         版本所有@2019-2020 技术运营中心 电视制作部 系统值班室（ 座机51500 51460 短号58002）
    </div>
    <div data-options="region:'center'" style="padding:5px;background:#eee;">
        <div id="con">
            <div id="tabName" title="人员管理" >
               <iframe frameborder="0" width="100%" height="100%" name="frameName" src="applyLeader.do" scrolling="auto" id="ifDiv" ></iframe>
            </div>
        </div>

    </div>
</div>

<script src="easyui/js/jquery-easyui-1.5.3/jquery.min.js"></script>
<script src="easyui/js/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
<script src="easyui/js/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
<script src="easyui/js/hh/indexAdmin.js"></script>

</body>
</html>