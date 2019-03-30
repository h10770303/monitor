$(function() { 
	
	 $('#myform').bootstrapValidator({
//       live: 'disabled',
       message: 'This value is not valid',
       feedbackIcons: {
           valid: 'glyphicon glyphicon-ok',
           invalid: 'glyphicon glyphicon-remove',
           validating: 'glyphicon glyphicon-refresh'
       },
       fields: {
           userName: {
               validators: {
                   notEmpty: {
                       message: 'The first name is required and cannot be empty'
                   }
               }
           },
           partment: {
        	   validators: {
        		   notEmpty: {
        			   message: 'The first name is required and cannot be empty'
        		   }
        	   }
           }
       }
   });
	
	$("#submit").click(function(){
		//页面校验
//		 $('#myform').bootstrapValidator('validate');
		 var $myform=$('#myform').data('bootstrapValidator');
		 $myform.validate();
		 if($myform.isValid()){
			 alert(1)
		 }else{
			 alert(2)
		 }
		var param={};
		param.partment=$("#partment").val();
		param.userName=$("#userName").val();
		var stars=[];
		var star={};
		star.starType=1;
		var  candidate=[];
		candidate.push($("#jz01").val());
		candidate.push($("#jz02").val());
		candidate.push($("#jz03").val());
		candidate.push($("#jz04").val());
		candidate.push($("#jz05").val());
		candidate.push($("#jz06").val());
		star.candidate=candidate;
		stars.push(star);
		var star={};
		star.starType=2;
		var  candidate=[];
		candidate.push($("#bj01").val());
		candidate.push($("#bj02").val());
		candidate.push($("#bj03").val());
		candidate.push($("#bj04").val());
		candidate.push($("#bj05").val());
		candidate.push($("#bj06").val());
		candidate.push($("#bj07").val());
		candidate.push($("#bj08").val());
		star.candidate=candidate;
		stars.push(star);
		var star={};
		star.starType=3;
		var  candidate=[];
		candidate.push($("#bd01").val());
		candidate.push($("#bd02").val());
		candidate.push($("#bd03").val());
		candidate.push($("#bd04").val());
		star.candidate=candidate;
		stars.push(star);
		var star={};
		star.starType=4;
		var  candidate=[];
		candidate.push($("#sy01").val());
		candidate.push($("#sy02").val());
		candidate.push($("#sy03").val());
		candidate.push($("#sy04").val());
		star.candidate=candidate;
		stars.push(star);
		param.stars=stars;
		
		  $.ajax({
			  type:"get",
				url:"checkVotor.do?userName="+$("#userName").val(),
				cache: false,
				async:true,
				success:function(data){
					if (data.code==0) {
						if(data.result.length>0){
							 $.ajax({
								  type:"get",
									url:"checkVoted.do?userName="+$("#userName").val(),
									cache: false,
									async:true,
									success:function(data){
										if (data.code==0) {
											if(data.result.length>0){
												alert("您已经投票，谢谢参与!");
											}else{
												$.ajax({
													  type:"post",
														url:"setVote.do",
														contentType : 'application/json;charset=UTF-8',
														dataType: 'json',
														data:JSON.stringify(param),
														async:true,
														success:function(data){

															if (data.code==0) {
//																alert("投票成功，感谢您的参与!");
																window.location.href="getVoteShow.do";
															} else {
																alert("出现异常，请联系管理员");
															}
															
														},
														error:function(data){
															alert("出现异常，请联系管理员");
														}
													})
											}
										} else {
											alert("出现异常，请联系管理员");
										}
										
									},
									error:function(data){
										alert("出现异常，请联系管理员");
									}
								})
						}else{
							alert("您不符合投票权限，请联系管理员!");
						}
					} else {
						alert("出现异常，请联系管理员");
					}
					
				},
				error:function(data){
					alert("出现异常，请联系管理员");
				}
			});
		  
	});
	 
     
	
});

/**
 * 表格弹出框
 * @param id
 */
function myModal(id){
	/**
	 * ajax 查数据库
	 */
	$.ajax({
		type:"GET",
		url:"getCandidate.do?starType="+id,
		cache: false,
		async:true,
		success:function(data){

			var code=data.code;
			if (code==0) {
				var result=data.result;
				var tr="";
				$.each(result,function(i,item){
					tr+="<tr> <td>"+result[i].userId+"</td>    <td>"+result[i].userName+"</td>  <td>"+result[i].partment+"</td> <td>"+result[i].sexs+"</td> "
				});
				$("#myModalLabel").text(data.result[0].starTypes);
				$('#myModal').modal();
				$("#modal-body").html("");
				$(" <table class=\"table table-bordered table-hover\">"  +
						" <tbody>  <thead>  <tr class=\"success\"> <td></td><th>序号</th><th>姓名</th><th>职务</th><th>性别</th>  </thead>   " +
						tr+
						"</tbody> " +
				" </table>").appendTo("#modal-body");
				initTableCheckbox(id); 
			} 
			
		},
		error:function(data){
			alert(error);
		}
	});
	
}

/**
 * 表格复选框
 * @returns
 */
function initTableCheckbox(id) {  
	var $startDivCnt=$("#"+id+" input[type=text]").length;
    var $thr = $('table thead tr');
    
//    var $checkAllTh = $('<th><input type="checkbox" id="checkAll" name="checkAll" /></th>');  
//    /*将全选/反选复选框添加到表头最前，即增加一列*/  
//    $thr.prepend($checkAllTh);  
//    /*“全选/反选”复选框*/  
//    var $checkAll = $thr.find('input');  
//    $checkAll.click(function(event){  
//        /*将所有行的选中状态设成全选框的选中状态*/  
//        $tbr.find('input').prop('checked',$(this).prop('checked'));  
//        /*并调整所有选中行的CSS样式*/  
//        if ($(this).prop('checked')) {  
//            $tbr.find('input').parent().parent().addClass('warning');  
//        } else{  
//            $tbr.find('input').parent().parent().removeClass('warning');  
//        }  
//        /*阻止向上冒泡，以防再次触发点击操作*/  
//        event.stopPropagation();  
//    });  
//    /*点击全选框所在单元格时也触发全选框的点击操作*/  
//    $checkAllTh.click(function(){  
//        $(this).find('input').click();  
//    });  
    var $tbr = $('table tbody tr');  
    var $checkItemTd = $('<td><input type="checkbox" name="checkItem" /></td>');  
    /*每一行都在最前面插入一个选中复选框的单元格*/  
    $tbr.prepend($checkItemTd);  
    /*点击每一行的选中复选框时*/  
    $tbr.find('input').click(function(event){  
       
        /*如果已经被选中行的行数等于表格的数据行数，将全选框设为选中状态，否则设为未选中状态*/  
//        $checkAll.prop('checked',$tbr.find('input:checked').length == $tbr.length ? true : false);  
        // 如果选中的行等于待录入的框后不让再选
    	var checkedcnt=$tbr.find('input:checked').length;
        if(checkedcnt==$startDivCnt+1){
        	
        	alert("该之星最多选"+$startDivCnt+"个!");
//        	$("#myModal").modal("hide");
        	return false;
        }
        /*调整选中行的CSS样式*/  
        $(this).parent().parent().toggleClass('warning');  
        //TODO  将选中的内容进行填充文本框  有bug 如果取消文本也会填充的
    	$("#"+id+" input[type=text]").eq(checkedcnt-1).val($(this).parent().parent().children('td').eq(2).html())
        /*阻止向上冒泡，以防再次触发点击操作*/  
        event.stopPropagation();  
    });  
    /*点击每一行时也触发该行的选中操作*/  
    $tbr.click(function(){  
        $(this).find('input').click();  
    });  
} 
