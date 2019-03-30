<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SMG融媒体中心制播系统账号管理页面</title>

    <link type="text/css" rel="stylesheet" href="easyui/js/jquery-easyui-1.5.3/themes/default/easyui.css"/>
    <link type="text/css" rel="stylesheet" href="easyui/js/jquery-easyui-1.5.3/themes/icon.css"/>
    <link type="text/css" rel="stylesheet" href="easyui/css/main.css">
      <link rel="stylesheet" media="screen" href="login/css/style.css">
  <link rel="stylesheet" type="text/css" href="login/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="css/toastr.css">
    <link rel="stylesheet" type="text/css" href="css/sweetalert2.min.css">
</head>
<body>
<div class="easyui-layout" data-options="fit:true" id="useBox">

    <div data-options="region:'center',split:true" >
        <!--表格查询-->
        <div class="tableFind">
            <p><label>栏目名称：</label><input type="text" id="columName" value="${columName }"/>
            </select><a id="btn" href="javascript:" class="easyui-linkbutton tableFindBut" data-options="iconCls:'icon-search'" onclick="obj.find()">查询</a></p>
        </div>
       
        <!--表格列表-->
        <div class="tableCon">
            <table id="table" class="tableStyle"></table>
              <div id="tabelBut">
                <div>
                    <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add" onclick="obj.addBox()">新增</a>
                    <!-- <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-edit">修改</a> -->
                    <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-remove" onclick="obj.delOne()">删除</a>
                </div>
            </div>
        </div>
    </div>
</div>


<!--//详细弹出框-->
<div id="addBox"  style="display: none; z-index: 100000;" >
     <form id="addForm" method="post">
       <div class="formDiv"><label>栏目名称:</label><input type="text" id="columName2" class="easyui-validatebox" name="columName2" data-options="required:true"><span class="formSpan">*</span></div>
        <div class="forSubmint"> <a href="#" class="easyui-linkbutton"  iconCls="icon-ok" onclick="obj.sum()" >提交</a> </div>

    </form>
</div>


<script src="easyui/js/jquery-easyui-1.5.3/jquery.min.js"></script>
<script src="easyui/js/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
<script src="easyui/js/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
<script src="easyui/js/hh/applyColum.js"></script>
<script type="text/javascript" src="js/toastr.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</body>
</html>