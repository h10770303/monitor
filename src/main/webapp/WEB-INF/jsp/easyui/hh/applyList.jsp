<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SMG融媒体中心制播系统账号申请列表</title>

    <link type="text/css" rel="stylesheet" href="easyui/js/jquery-easyui-1.5.3/themes/default/easyui.css"/>
    <link type="text/css" rel="stylesheet" href="easyui/js/jquery-easyui-1.5.3/themes/icon.css"/>
    <link type="text/css" rel="stylesheet" href="easyui/css/main.css">
      <link rel="stylesheet" media="screen" href="login/css/style.css">
  <link rel="stylesheet" type="text/css" href="login/css/reset.css"/>
</head>
<body>
<div class="easyui-layout" data-options="fit:true" id="useBox">
    <!--左侧树-->

    <div data-options="region:'center',split:true" >
      <div class="sportTit"><label>SMG融媒体中心制播系统账号申请</label></div>
        <!--表格查询-->
        <div class="tableFind">
        <input id="flag" type="hidden" value="${flag }">
            <p><label>申请人：</label><input type="text" id="applyName" value="${applyName }"/><input type="hidden" id="name_pinyin" value="${name_pinyin }"/><label>当前状态</label><select id="status">
                <option value="0" selected="selected">全部</option>
                <option value="1">待审批</option>
                <option value="2">已审批</option>
                <option value="3">已归档</option>
            </select><a id="btn" href="javascript:" class="easyui-linkbutton tableFindBut" data-options="iconCls:'icon-search'" onclick="obj.find()">查询</a></p>
        </div>
       
        <!--表格列表-->
        <div class="tableCon">
            <table id="table" class="tableStyle"></table>
        </div>
    </div>
</div>


<div id="particles-js" style="display: none">
		<div class="login">
			<div class="login-top">
				登录
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="login/img/name.png"/></div>
				<div class="login-center-input">
					<input type="text" name="" value="" id="userName" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
					<div class="login-center-input-text">用户名</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="login/img/password.png"/></div>
				<div class="login-center-input">
					<input type="password" name=""value="" id="userPwd" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
					<div class="login-center-input-text">密码</div>
				</div>
			</div>
			<div class="login-button">
				登陆
			</div>
		</div>
		<div class="sk-rotating-plane"></div>
</div>

<!--//详细弹出框-->
<div id="addBox"  style="display: none; z-index: 100000;" >
    <form id="addForm" method="post">
		<div class="sportTable"><table border="1">
               <tr>
                   <td class="TailLabel01">本人姓名<span class="formSpan">*</span></td>
                   <td ><input type="text" class=" tableInput" id="applyName2" name="name" readonly="readonly"  data-options="required:true,validType:['length[1,100]']"/>
                        <input id="applyId" type="hidden" value="">  </td>
                   <td class="TailLabel01">姓名拼音<span class="formSpan">*</span></td>
                   <td ><input id="name_pinyin2" type="text" class=" tableInput" name="name" readonly="readonly" data-options="required:true,validType:['length[1,100]']"/></td>
                   <td class="TailLabel01">工号<span class="formSpan">*</span></td>
                   <td ><input id="userId2" type="text" class=" tableInput" name="name" readonly="readonly" data-options="required:true,validType:['length[1,100]']"/></td>
               </tr>
               <tr>
                   <td class="TailLabel01">所属部门<span class="formSpan">*</span></td>
                   <td ><input id="partment2" type="text" class=" tableInput" name="name"  readonly="readonly"  data-options="required:true,validType:['length[1,100]']" /></td>
                   <td class="TailLabel01">制作栏目</td>
                   <td ><input id="columns2" type="text" class="tableInput" name="name" readonly="readonly"  /></td>
                   <td class="TailLabel01">联系电话<span class="formSpan">*</span></td>
                   <td ><input id="phoneNo" type="text" class=" tableInput"readonly="readonly"  name="name" data-options="required:true,validType:['length[1,100]']"/></td>
               </tr>
             
               <tr>
                   <td  class="TailLabel01">个人账号<span class="formSpan">*</span></td>
                   <td colspan="2" ><label for="accountType01"> <input id="accountType01" value="1" type="radio"  readonly="readonly" name="accountType" checked/><span>原有账号</span></label>
                                    <label for="accountType02"> <input id="accountType02" value="2" name="accountType" readonly="readonly"  type="radio"/><span>申请新账号</span></label></td>
              		<td class="TailLabel01">申请权限的栏目<span class="formSpan">*</span></td>
                   <td colspan="2" ><input type="text" style="border:none" id="applyColum"  readonly="readonly" /></td>
               </tr>
               
               <tr>
                   <td  class="TailLabel01">文稿生产<span class="formSpan">*</span></td>
                   <td colspan="5" ><label for="edit"> <input id="edit"  value="0" type="checkbox"  readonly="readonly" name="inews" /><span>iNEWS编辑（可写“编辑改稿”）</span> </label>
                                    <label for="charge">  <input id="charge" value="1" name="inews" readonly="readonly"  type="checkbox"/><span>iNEWS编导（可写“编播串联单”）</span> </label>
                                    <label for="manager">  <input id="manager" value="2" name="inews"  readonly="readonly"  type="checkbox"/><span>iNEWS责编（可写可装载“播出串联单”）</span></label></td>
               </tr>
               <tr>
                   <td  class="TailLabel01">视频生产<span class="formSpan">*</span></td>
                   <td colspan="5" ><label for="central"> <input id="central" value="0" type="checkbox" name="videos" /><span>Interplay Central粗编</span></label>
                                   <label for="interplay"> <input id="interplay" value="1" name="videos"  type="checkbox"/><span>Interplay NewsCutter精编栏目</span></label>
                                   <label for="checkmxf">  <input id="checkmxf" value="2" name="videos"  type="checkbox"/><span>需要审片</span></label> </td>
               </tr>
               <tr>
                   <td  class="TailLabel01">xnews系统<span class="formSpan">*</span></td>
                   <td colspan="5" ><label for="bp"> <input id="bp" value="0" type="checkbox" name="xnews" /><span>Xnews全媒报片</span> </label>
                                    <label for="rw"> <input id="rw" value="1" name="xnews"  type="checkbox"/><span>Xnews申请任务</span></label>
                                    <label for="sp"> <input id="sp" value="2" name="xnews"  type="checkbox"/><span>Xnews任务审批</span> </label>
                   <br/>            <label for="tc"><input id="tc" value="3" type="checkbox" name="xnews" /><span>Xnews线索统筹</span></label> 
                                    <label for="ds">  <input id="ds" value="4" name="xnews"  type="checkbox"/><span>Xnews电视主编</span></label>
                                    <label for="sz"> <input id="sz" value="5" name="xnews"  type="checkbox"/><span>Xnews数字主编</span></label> </td>
               </tr>
               <tr>
                   <td class="TailLabel01" colspan="6">申请描述（申请的具体要求）</td>

               </tr>
               <tr>
                   <td class="TailLabel01" colspan="6"><textarea class="tableArea" id="description" >申请描述</textarea></td>

               </tr>
               
               <tr>
                   <td class="TailLabel01">审核领导<span class="formSpan">*</span></td>
                   <td colspan="5" >
						<input id="leaderName" type="text"  value="leaderName"  readonly="readonly" class=" tableInput"  />
                   </td>
               </tr>

           </table>
           
             <div class="sportFoot"  >
             	<div id="finsherdiv" style="display: none; ">
             		<label>归档人</label> <select id="finsher" class="tableInput01">
             		 <option value="0" selected="selected">请选择归档人</option> 
             		<!--<option value="李继豪">李继豪</option> 
             		<option value="马伟华">马伟华</option>
             		<option value="郑皆敏">郑皆敏</option> -->
             		 </select>
             	</div>
               <a  id="icon-ok" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">审批通过</a>
               <!-- <a  id="icon-cancel" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">审批不通过</a> -->
           </div>
          </div>
    </form>
    <!-- 扫一扫 -->
		<div class="loginBody" style="display: none;">
			<div class="logoImg">
				<img id="code" alt="微信扫一扫" src="" />
			</div>
			<div class="loginText">微信扫一扫</div>
			<div class="loginText01"><br/>微信扫描完成审批认证</div>
		</div>
	</div>
<!--物流详情查看-->
<div id="lookTail" style="display: none">
    <div class="floatLeft maginTop " >
        <div class="lookTailDiv01">2017-12-18</div>
        <div class="floatRight maginRt">
            <span class="circleStyle01"></span>
        </div>

        <div class="clear"></div>
        <div class="floatRight maginRt">
            <span class="lineH magingLeft"></span>
        </div>

        <div class="clear"></div>
        <div class="lookTailDiv02">16:22:35</div>
        <div class="floatRight maginRt">
            <span class="circleStyle02 backGreen "></span>
        </div>

        <div class="clear"></div>
        <div class="floatRight maginRt">
            <span class="lineH magingLeft"></span>
        </div>
        <div class="clear"></div>
        <div class="lookTailDiv02">16:22:35</div>
        <div class="floatRight maginRt">
            <span class="circleStyle02 backRed "></span>
        </div>
        <div class="clear"></div>
        <div class="floatRight maginRt">
            <span class="lineH magingLeft"></span>
        </div>
        <div class="clear"></div>
        <div class="lookTailDiv01">2017-12-19</div>
        <div class="floatRight maginRt">
            <span class="circleStyle01"></span>
        </div>

        <div class="clear"></div>
        <div class="floatRight maginRt">
            <span class="lineH magingLeft"></span>
        </div>

        <div class="clear"></div>
        <div class="lookTailDiv02">16:22:35</div>
        <div class="floatRight maginRt">
            <span class="circleStyle02 backGreen "></span>
        </div>

        <div class="clear"></div>
        <div class="floatRight maginRt">
            <span class="lineH magingLeft"></span>
        </div>
        <div class="clear"></div>
        <div class="lookTailDiv01">2017-12-20</div>
        <div class="floatRight maginRt">
            <span class="circleStyle01"></span>
        </div>

        <div class="clear"></div>
        <div class="floatRight maginRt">
            <span class="lineH magingLeft"></span>
        </div>

        <div class="clear"></div>
        <div class="lookTailDiv02">16:22:35</div>
        <div class="floatRight maginRt">
            <span class="circleStyle02 backGreen "></span>
        </div>
        <div class="clear"></div>
        <div class="floatRight maginRt">
            <span class="lineH magingLeft"></span>
        </div>
    </div>

    <div class="floatLeft maginTop">
        <div class="divBorder magintTop01 floatLeft borderGreen"><span class="footBlood">张立新</span><span class="colorCCC">(买方)</span><span class="footBlood">下单</span></div>
        <div class="clear"></div>
        <div class="divBorder magintTop02  floatLeft borderRed"><span class="footBlood">刘强</span><span class="colorCCC">(卖方)</span><span class="footBlood">确认订单</span></div>
        <div class="clear"></div>
        <div class="divBorder magintTop03  floatLeft borderGreen"><span class="footBlood">罗林</span><span class="colorCCC">(配送员)</span><span class="footBlood">确认订单</span><span>成都市高新区西南仓库中心</span><span class="colorGreen">13695632156</span></div>
        <div class="clear"></div>
        <div class="divBorder magintTop03  floatLeft borderGreen"><span class="footBlood">罗林</span><span class="colorCCC">(配送员)</span><span class="footBlood">确认订单</span><span>成都市高新区西南仓库中心</span><span class="colorGreen">13695632156</span></div>
    </div>
    
    </div>


<script src="easyui/js/jquery-easyui-1.5.3/jquery.min.js"></script>
<script src="easyui/js/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
<script src="easyui/js/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
<script src="js/util/dateUtil.js"></script>
<script src="easyui/js/hh/applyList.js"></script>
<!-- scripts -->
<script src="login/js/particles.min.js"></script>
<script src="login/js/app.js"></script>
<script type="text/javascript">
	 
		document.querySelector(".login-button").onclick = function(){
			login();
				
		}
		document.onkeydown = function(e){
	        var ev = document.all ? window.event : e;
	        if(ev.keyCode==13) {
	        	login();
	        }
	    }
		
</script>

</body>
</html>