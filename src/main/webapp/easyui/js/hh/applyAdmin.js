$(function(){
	setChannel();
	 $("#channel").change(function(){
		 var channel=$("#channel option:selected").val();
		 if(channel==1){
			 $("#other").show();
		 }
   });
});
 
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
				option+= " <option value='技术'>技术</option> "
				$("#channels").append(option);
				option+=" <option value='1'>其他</option> "
				$("#channel").append(option);
			}
		},
		error:function(data){
		}
	});
}

obj={
        // 查询
        find:function () {
        	var channel=$("#channels option:selected").val()+"";
                $("#table").datagrid('load',{
                	userName:$("#userName").val(),
                	channels:channel
                })
                
        },
        // 添加
        addBox:function () {
                $("#addBox").dialog({
                        closed: false

                });
        },
        //提交
        sum:function(){
        	var param={};
        	var userName=$("#userName2").val().trim();
        	if(userName==''){
        		toastr.warning("姓名不能为空！");
        		return false;
        	}
        	var channel=$("#channel option:selected").val();
        	if(channel==0){
        		toastr.warning("请选择所属频道！");
        		return false;
        		
        	}else if(channel==1){
        		channel=$("#channelName").val();
        	}
        	param.userName=userName;
        	param.channel=channel;
        	$( "#addBox" ).dialog( "close" ); //关闭弹出框
        	
    		 $.ajax({
    				type : "post",
    				url : "addLeader.do" ,
    				data:JSON.stringify(param),
    				contentType : 'application/json;charset=UTF-8',
    				dataType: 'json',
    				async : true,
    				success : function(data) {
    					window.location.href="applyLeader.do"
    	                $.messager.show({
    						title : '提示信息',
    						msg : "操作完成"
    		               		}) 
    				},
    				error : function(data) {

    					toastr.warning("访问异常，请联系管理员！")
    				}
    			});
        	
        	
        },
      //删除一个
        delOne:function (id) {
                id=$("#table").datagrid('getSelected').id;
                $.messager.confirm('提示信息','是否删除所选择记录',function (flg) {
                        if(flg){
                                $.ajax({
                                        type:'get',
                                        url:'delLeader.do?id='+id,
                                        cache: false,
                                		async:true,
                                        success:function (data) {
                                                if(data){
                                                        $("#table").datagrid("loaded");
                                                        $("#table").datagrid("load");
                                                        $("#table").datagrid("unselectRow");
                                                        $.messager.show({
                                                                title:'提示信息',
                                                                msg:"信息删除成功"
                                                        })
                                                }
                                                else{
                                                        $.messager.show({
                                                                title:'警示信息',
                                                                msg:"信息删除失败"
                                                        })

                                                }

                                        }
                                })

                        }

                })


        }

}
// 加载表格
$("#table").datagrid({
        title:"数据列表",
        iconCls:"icon-left02",
        url:'getLeaderList.do',
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
        queryParams:{userName:"",channels:""},
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
                        field:'userName',
                        title:'姓名',
                        width:100,
                        align:'center'



                },
                {
                        field:'channel',
                        title:'所属频道',
                        width:100,
                        align:'center'



                } 
        ]]
})
// 弹出框加载
$("#addBox").dialog({
	 title:"信息内容",
     width:500,
     height:300,
     closed: true,
     modal:true,
     shadow:true
})
