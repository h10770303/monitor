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
    <link rel="stylesheet" type="text/css" href="css/toastr.css">
    <link rel="stylesheet" type="text/css" href="css/sweetalert2.min.css">
    
    <style>
        .city{
            display: none;;
        }
        .city_first {
            display: block;
        }
    </style>

</head>
<body>
<div class="easyui-layout" data-options="fit:true" id="useBox">


    <div data-options="region:'center',split:true">
       <div class="sportAll">
          
           <div class="sportTit"><label>SMG融媒体中心制播系统账号申请</label></div>
           <div class="sportTable"><table border="1">
              
               <tr>
                   <td class="TailLabel01">本人姓名<span class="formSpan">*</span></td>
                   <td ><input type="text" class="easyui-validatebox tableInput" id="applyName" name="name" placeholder="输入本人姓名" data-options="required:true,validType:['length[1,100]']"/></td>
                   <td class="TailLabel01">姓名拼音<span class="formSpan">*</span></td>
                   <td ><input id="name_pinyin" type="text" class="easyui-validatebox tableInput" name="name" placeholder="输入姓名拼音" data-options="required:true,validType:['length[1,100]']"/></td>
                   <td class="TailLabel01">工号<span class="formSpan">*</span></td>
                   <td ><input id="userId" type="text" class="easyui-validatebox tableInput" name="name" placeholder="输入工号" data-options="required:true,validType:['length[1,100]']"/></td>
               </tr>
               <tr>
                   <td class="TailLabel01">所属部门<span class="formSpan">*</span></td>
                   <td ><input id="partment" type="text" class="easyui-validatebox tableInput" name="name" placeholder="输入所属部门" data-options="required:true,validType:['length[1,100]']" /></td>
                   <td class="TailLabel01">制作栏目</td>
                   <td ><input id="columns" type="text" class="tableInput" name="name"  placeholder="输入所在栏目"/></td>
                   <td class="TailLabel01">联系电话<span class="formSpan">*</span></td>
                   <td ><input id="phoneNo" type="text" class="easyui-validatebox tableInput" name="name" placeholder="输入联系电话" data-options="required:true,validType:['length[1,100]']"/></td>
               </tr>
             
               <tr>
                   <td  class="TailLabel01">个人账号<span class="formSpan">*</span></td>
                   <td colspan="2" ><label for="accountType01"> <input id="accountType01" value="1" type="radio" name="accountType" checked/><span>原有账号</span></label>
                                    <label for="accountType02"> <input id="accountType02" value="2" name="accountType"  type="radio"/><span>申请新账号</span></label></td>
              		<td class="TailLabel01">申请权限的栏目<span class="formSpan">*</span></td>
                   <td colspan="2" ><select id="applyColum" class="tableInput01"> 
                   <option value="0" selected="selected">--请选择权限栏目--</option>
                    </select> </td>
               </tr>
               
               <tr>
                   <td  class="TailLabel01">文稿生产<span class="formSpan">*</span></td>
                   <td colspan="5" ><label for="edit"> <input id="edit"  value="0" type="checkbox" name="inews" /><span>iNEWS编辑（可写“编辑改稿”）</span> </label>
                                    <label for="charge">  <input id="charge" value="1" name="inews"  type="checkbox"/><span>iNEWS编导（可写“编播串联单”）</span> </label>
                                    <label for="manager">  <input id="manager" value="2" name="inews"  type="checkbox"/><span>iNEWS责编（可写可装载“播出串联单”）</span></label></td>
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
                   <td class="TailLabel01" colspan="6"><textarea class="tableArea" id="description"  >申请描述</textarea></td>

               </tr>
               
               <tr>
                   <td class="TailLabel01">审核领导<span class="formSpan">*</span></td>
                   <td colspan="5" >
                   <select id="channel"  class="tableInput01"  >
                   	<option value="0">--选择频道--</option>
                   </select>
                  <select id="leader" class="city city_first tableInput01" >
					    <option value="0">--选择领导--</option>
					</select>
                   </td>
               </tr>

           </table></div>
           <div class="sportFoot" >
              <!--  <a  id="save" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a> -->
               <a  id="submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a>
           </div>

       </div>
        </div>
        
</div>


<script src="easyui/js/jquery-easyui-1.5.3/jquery.min.js"></script>
<script src="easyui/js/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
<script src="easyui/js/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
<script src="js/util/checkUtil.js"></script>
<script src="easyui/js/hh/apply.js"></script>
<script type="text/javascript" src="js/toastr.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</body>
</html>