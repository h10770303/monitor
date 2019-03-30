$(function(){
	var flag=$("#flag").val();
	if(flag=='gd'){  //登陆页面
		$("#useBox").hide();
		$("#particles-js").show();
	}else if(flag=='sp'){   //有问题
//		$("#status option:eq(1)").attr('selected','selected');
	}
	setLeaderByChannel("技术")
	
});
 
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
					$("#finsher").html('<option value="0" selected="selected">请选择归档人</option> ');
					$.each(result,function(item,value){
						option+=" <option value=\""+value.userName+"\">"+value.userName+"</option> "
					})	
					$("#finsher").append(option);
				}
			}
		},
		error:function(data){
		}
	});
}

function getValue(){
	var param={};
	var applyId=$("#applyId").val();
	param.id=applyId;
	var applyName=$("#applyName2").val();
	param.applyName=applyName;
	var name_pinyin=$("#name_pinyin2").val();
	param.name_pinyin=name_pinyin;
	var userId=$("#userId2").val();
	param.userId=userId;
	var partment=$("#partment2").val();
	param.partment=partment;
	var columns=$("#columns2").val();
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
	var leaderName=$("#leaderName").val();
	param.leaderName=leaderName;
	
	return param
}

function ischkecked(){
	$.ajax({
		type : "get",
		url : "hasChecked.do" ,
		dataType : 'json',
		async : true,
		success : function(data) {
			if (data.result == '1') {
				$( "#addBox" ).dialog( "close" ); 
				var param=getValue();
				$.ajax({
					type:"post",
					url:"updateApply.do",
					contentType : 'application/json;charset=UTF-8',
					dataType: 'json',
					data:JSON.stringify(param),
					async:true,
					success:function(data){
						if(data.code==0){
							$.messager.show({
								title : '提示信息',
								msg : "审批成功！"
							})
							window.location.href="applyList.do?flag=sp"
//							gdSucess();
						}else{
							$.messager.show({
								title : '提示信息',
								msg : "审批失败,您没有审批权限！"
							})
							window.location.href="applyList.do?flag=sp"
//							gdSucess();
						}
					},
					error:function(data){
						toastr.warning("系统异常，请联系管理员！")
						}
				});
			} else if (data.result == '0') {
				window.location.href="http://172.27.207.91/monitor/404.do"
			}
		},
		error : function(data) {

			toastr.warning("访问异常，请联系管理员！")
		}
	});
}

obj={
        // 查询
        find:function () {
                $("#table").datagrid('load',{
                	applyName:$("#applyName").val(),
                	name_pinyin:$("#name_pinyin").val(),
                	status:$("#status option:selected").val()
                })
                
        },
        approve:function(){
        	$("#approve").dialog({
                closed: false
        });
        	
        },
        operator:function(){
        	$("#operator").dialog({
                closed: false
        });
        },
        update:function(param){
        	var finisher=$("#finisher").val().trim();
        	if(finisher==''){
        		toastr.warning("操作人不能为空！");
        		return false;
        	}
        	 var rows=$("#table").datagrid("getSelections");
        	 if(rows.length<=0){
        		 toastr.warning("请选择需要操作的记录！")
        		 return false;
        	 }else{
        		 var status=2
        		 var ids=[];
        		 $.each(rows,function(i,item){
        			 ids.push(item.id);
        		 })
        		 var param={};
        		 param.ids=ids;
        		 $.ajax({
        				type : "post",
        				url : "updateApply.do" ,
        				data:JSON.stringify(param),
        				contentType : 'application/json;charset=UTF-8',
        				dataType: 'json',
        				async : true,
        				success : function(data) {
        					toastr.success("操作完成！")
        				},
        				error : function(data) {

        					toastr.warning("访问异常，请联系管理员！")
        				}
        			});
        	 }
        	
        	
        },
        // 详细
        detail:function (id,flag) {
                $("#addBox").dialog({
                        closed:false,
                })
                if(flag=='sp'){
                	$("#icon-ok").text('');
					$("#icon-ok").append('<span class="l-btn-left l-btn-icon-left"><span class="l-btn-text">审批通过</span><span class="l-btn-icon icon-ok">&nbsp;</span></span>');
				}else if(flag=='gd'){
					$("#finsherdiv").show();
					$("#icon-ok").text('');
					$("#icon-ok").append('<span class="l-btn-left l-btn-icon-left"><span class="l-btn-text">归档</span><span class="l-btn-icon icon-ok">&nbsp;</span></span>');
			
				}else{
					$("#icon-ok").hide();
				}
               $.ajax({
					type:"get",
					url:"getApplyById.do?id="+id,
					dataType: 'json',
					async:true,
					success:function(data){
						if(data.code==0){
							result=data.result;
							$("#applyId").val(id)
							$("#applyName2").val(result.applyName);
							$("#name_pinyin2").val(result.name_pinyin);
							$("#userId2").val(result.userId);
							$("#partment2").val(result.partment);
							$("#columns2").val(result.columns);
							$("#phoneNo").val(result.phoneNo);
							$("input[name='accountType']").eq(result.accountType-1).attr("checked","checked");
							$("#description").val(result.description);
							$("#applyColum").val(result.applyColums);
							if(result.inews!=""){
								$.each(result.inews,function(i,item){
									$("input[name='inews']").eq(item).attr("checked","checked");
								});
							}
							if(result.videos!=""){
								$.each(result.videos,function(i,item){
									$("input[name='videos']").eq(item).attr("checked","checked");
								})
							}
							if(result.xnews!=""){
								$.each(result.xnews,function(i,item){
									$("input[name='xnews']").eq(item).attr("checked","checked");
								})
							}
							$("#leaderName").val(result.leaderName);
							
						}
					},
					error:function(data){
						toastr.warning("系统异常，请联系管理员！")
						}
				});

        },

}
// 加载表格
$("#table").datagrid({
        title:"数据列表",
        iconCls:"icon-left02",
        url:'getApplyList.do',
        fitColumns:true,
        striped:true,
        pagination:true,
        pageSize:10,
        width:'100%',
        rownumbers:true,
        pageList:[10,20],
        pageNumber:1,
        loadMsg:"正在加载数据，请稍后...",
        nowrap:true,
        height:'auto',
        sortName:'id',
        checkOnSelect:false,
        sortOrder:'asc',
        toolbar: '#tabelBut',
        queryParams:{applyName:"",name_pinyin:$("#name_pinyin").val(),status:$("#status option:selected").val()},
        columns:[[
                {
                        checkbox:true,
                        field:'no',
                        width:100,
                        align:'center'
                },
                {
                    field:'id',
                    title:'id值',
                    width:100,
                    hidden:'true'
                },
                {
                        field:'applyName',
                        title:'申请人',
                        width:100,
                        align:'center'



                },
                {
                        field:'userId',
                        title:'工号',
                        width:100,
                        align:'center'



                },
                {
                        field:'partment',
                        title:'所在部门',
                        width:100,
                        align:'center'



                },
                {
                        field:'columns',
                        title:'所属栏目',
                        width:100,
                        align:'center'



                },
                {
                    field:'phoneNo',
                    title:'电话',
                    width:100,
                    align:'center'



            }, {
                field:'leaderName',
                title:'审批人',
                width:120,
                align:'center'
        },{
                field:'approveDate',
                title:'审批时间',
                width:120,
                align:'center',
                formatter:function (val,row) {
                	var time=null;
                	if(val!=null){
                		var time = formatDateTime(val);  
                	}
                	return time;
                }
        },
        {
            field:'finsher',
            title:'完成人',
            width:90,
            align:'center'



    }
        ,
        {
            field:'finshDate',
            title:'完成时间',
            width:120,
            align:'center',
            formatter:function (val,row) {
            	var time=null;
            	if(val!=null){
            		var time = formatDateTime(val);  
            	}
            	return time;
            }
    },{
        field:'status',
        title:'当前状态',
        width:90,
        align:'center',
        formatter:function (val,row) {
        	var e;
            if(val==1){
            	e='<span style="color:blue">待审批</span>'
            }else if(val==2){
            	e='<span style="color:orange">已审批</span>'
            }else if(val==3){
            	e='<span style="color:red">已归档</span>'
            }
            return e;

        	}
    	},  {
                        field:"opr",
                        title:'操作',
                        width:100,
                        align:'center',
                        formatter:function (val,row) {
                        	var flag=$("#flag").val();
                        	var e='';
                        	//   sp只有status=1时 审批， 其他为详情  gd status=2 时归档， 其他详情
                        	    if(flag=="sp"&& row.status==1){
                        	    	e = '<a  id="add" data-id="98" class=" operA"   onclick="obj.detail(\'' + row.id + '\',\'' + flag + '\')"><img src="easyui/img/cabinet.png"/><span style="color:orange">审批</span></a> ';
                        	    }else if(flag=='gd'&&row.status==2){
                        	    	e = '<a  id="add" data-id="98" class=" operA"  onclick="obj.detail(\'' + row.id + '\',\'' + flag + '\')"><img src="easyui/img/book.png"/><span style="color:red">归档</span></a> ';
                        	    }else{
                        	    	flag='cx';
                        	    	e = '<a  id="add" data-id="98" class=" operA" onclick="obj.detail(\'' + row.id + '\',\'' + flag + '\')"><img src="easyui/img/reload.png"/><span style="color:blue">详情</span></a> ';
                        	    }
                                c = '<a  id="look"   onclick="obj.look(\'' + row.id + '\')">流程查看</a> ';
                                return e;

                        }

                }
        ]]
})
// 弹出框加载
$("#addBox").dialog({
        title:"申请单详细信息",
        width:850,
        height:380,
        closed: true,
        modal:true,
        shadow:true,
        onClose:function(){  
            $("#addForm").show();
            $(".loginBody").hide();
        },  
})

// 加载物流详情
$("#lookTail").dialog({
        title:"信息内容",
        width:650,
        height:410,
        closed: true,
        modal:true,
        shadow:true
})

$("#icon-ok").click(function(){
	var btnTxt=$("#icon-ok").text().trim();
	if(btnTxt=='审批通过'){
		$.ajax({
			type : "get",
			url : "getWxCode.do" ,
			dataType : 'json',
			async : true,
			success : function(data) {
				if (data.code == 0) {
					$("#addForm").hide();
					$(".loginBody").show();
					var showcode="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
					$("#code").attr("src",showcode+data.result);
					if(data.result.length>0){
						setInterval("ischkecked()",2000);
					}
				} else {
					toastr.warning("出现异常，请联系管理员！")
				}
			},
			error : function(data) {

			}
		});
	}else if(btnTxt=='归档'){
		var finsher=$("#finsher option:selected").val();
		var id=$("#applyId").val();
		if(finsher==''){
			toastr.warning("请选择归档操作人！");
			return false;
		}
		 $( "#addBox" ).dialog( "close" ); //关闭弹出框
		$.ajax({
			type:"get",
			url:"updateApplyById.do?finsher="+encodeURI(encodeURI(finsher))+"&id="+id,
			cache: false,
			async:true,
			success:function(data){
				if (data.code==0) {
					$.messager.show({
						title : '提示信息',
						msg : "归档成功！"
					})
					gdSucess();
					
				}else{
					gdSucess();
					toastr.warning("归档失败！")
				}
			},
			error:function(data){
				gdSucess();
				toastr.warning("请联系管理员！")
			}
			});
	}
	
})

function gdSucess(){
	 $("#table").datagrid('load',{
        	applyName:$("#applyName").val(),
        	name_pinyin:$("#name_pinyin").val(),
        	status:$("#status option:selected").val()
        })
}

/**
 * 归档模块登陆
 * @returns {Boolean}
 */
function login(){
	var userName=$("#userName").val();
	var userPwd=$("#userPwd").val();
	if(userName==''){
		toastr.warning("请输入用户名!");
		return false;
	}
	if(userPwd==''){
		toastr.warning("请输入密码!");
		return false;
	}
	$.ajax({
		type:"get",
		url:"loginCheck.do?userName="+userName+"&userPwd="+userPwd,
		cache: false,
		async:true,
		success:function(data){
			if (data.code==0) {
					$("#useBox").show();
					$("#particles-js").hide();
					 $("#table").datagrid('load',{
		                	applyName:$("#applyName").val(),
		                	name_pinyin:$("#name_pinyin").val(),
		                	status:$("#status option:selected").val()
		                })
			}else{
				toastr.warning("用户名或密码错误！")
			}
		},
		error:function(data){
		}
		});
}
