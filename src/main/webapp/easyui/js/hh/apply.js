
$("#work").combobox({
        url:'json/addr.json',
        valueField:'id',
        textField:'text'
})
$('.easyui-filebox').filebox({
        buttonText:'选择文件'
})
$("#description").focus(function () {
        $(this).val("");
        $(this).css('color','#333');

})
$.fn.datebox.defaults.formatter = function(date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        var d = date.getDate();
        return y+'年'+m+'月'+d+'日';
}


$(function() { 
	
	setApplyColum();
	setChannel();
	// 选择审批领导二级联动
	 $("#channel").change(function(){
//         var index = $(this).get(0).selectedIndex;
//         $('.city').hide().eq(index).show();
//		 $("#leader").show();
		setLeaderByChannel($("#channel option:selected").val());
     });
	
	$("#save").click(function(){
		save(0);
	})
	$("#submit").click(function(){
		
		save(1);
	})
	
	
});


function setApplyColum(){
	$.ajax({
		type:"get",
		url:"getApplyColum.do",
		cache: false,
		async:true,
		success:function(data){
			if (data.code==0) {
				var result=data.result;
				var option="";
				$.each(result,function(item,value){
					option+=" <option value=\""+value.id+"\">"+value.columName+"</option> "
				})	
				$("#applyColum").append(option);
			}
		},
		error:function(data){
		}
		});
}
function setChannel(){
	$.ajax({
		type:"get",
		url:"getChannel.do",
		cache: false,
		async:true,
		success:function(data){
			if (data.code==0) {
				var result=data.result;
				var option="";
				$.each(result,function(item,value){
					option+=" <option value=\""+value.channel+"\">"+value.channel+"</option> "
				})	
				$("#channel").append(option);
			}
		},
		error:function(data){
		}
	});
}
function setLeaderByChannel(channel){
	$.ajax({
		type:"get",
		url:"getLeaderByChannel.do?channel="+encodeURI(encodeURI(channel)),
		cache: false,
		async:true,
		success:function(data){
			if (data.code==0) {
				var result=data.result;
				if(result!=null){
					var option="";
					$("#leader").html('<option value="0">--选择领导--</option>');
					$.each(result,function(item,value){
						option+=" <option value=\""+value.userName+"\">"+value.userName+"</option> "
					})	
					$("#leader").append(option);
				}
			}
		},
		error:function(data){
		}
	});
}


function getValue(){
	var param={};
	var applyName=$("#applyName").val();
	param.applyName=applyName;
	var name_pinyin=$("#name_pinyin").val();
	param.name_pinyin=name_pinyin;
	var userId=$("#userId").val();
	param.userId=userId;
	var partment=$("#partment").val();
	param.partment=partment;
	var columns=$("#columns").val();
	param.columns=columns;
	var phoneNo=$("#phoneNo").val();
	param.phoneNo=phoneNo;
	var accountType=$("input[name='accountType']:checked").val();
	param.accountType=accountType;
	var applyColum=$("#applyColum").val();
	param.applyColum=applyColum;
	var inews_check=$("input[name='inews']:checked")
	var inews=[];
	inews_check.each(function(){
		inews.push($(this).val())
	});
	param.inews=inews;
	var videos_check=$("input[name='videos']:checked")
	var videos=[];
	videos_check.each(function(){
		videos.push($(this).val());
	})
	param.videos=videos;
	var xnews_check=$("input[name='xnews']:checked")
	var xnews=[];
	xnews_check.each(function(){
		xnews.push($(this).val());
	})
	param.xnews=xnews;
	var description=$("#description").val();
	param.description=description;
	var channel=$("#channel option:selected").val();
	var leaderName;
	if(channel==0){
		toastr.warning("请先选择审核领导所在频道");
		return false;
	}
	leaderName=$("#leader option:selected").val();
	if(leaderName==0){
		toastr.warning("请先选择审核领导");
		return false;
	}
	param.leaderName=leaderName;
	
	
	
	if(param.applyName.trim()==''){
		toastr.warning("本人姓名不能为空!");
		return false;
	}
	if(param.name_pinyin.trim()==''){
		toastr.warning("姓名拼音不能为空!");
		return false;
	}
	if(param.userId.trim()==''){
		toastr.warning("工号不能为空!");
		return false;
	}
	if(param.partment.trim()==''){
		toastr.warning("所属部门不能为空!");
		return false;
	}
	if(param.applyColum==0){
		toastr.warning("申请权限的栏目不能为空!");
		return false;
	}
	if(param.phoneNo.trim()==''){
		toastr.warning("联系电话不能为空!");
		return false;
	}
	if(inews.length==0&&videos.length==0&&xnews.length==0){
		toastr.warning("请至少选择一个申请配置项!");
		return false;
	}
	if(param.leaderName==0){
		toastr.warning("请选择审核领导");
		return false;
	}
	return param
}



function save(flag){
	var param=getValue();
	if(param){
		
		$.ajax({
			type:"post",
			url:"toApply.do?flag="+flag,
			contentType : 'application/json;charset=UTF-8',
			dataType: 'json',
			data:JSON.stringify(param),
			async:true,
			success:function(data){
				if (data.code==0) {
					toastr.success("您已提交申请!");
					window.location.href='applyList.do?name_pinyin='+$("#name_pinyin").val();
				} else {
					toastr.warning("出现异常，请联系管理员");
				}
				
			},
			error:function(data){
				toastr.warning("出现异常，请联系管理员");
			}
		})
	}
	
}

