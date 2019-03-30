$(function() { 
	 $(".datepicker").datepicker({
         language: "zh-CN",
         autoclose: true,//选中之后自动隐藏日期选择框
         format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
     });
	 $(".datepicker").datepicker("getDate").toLocaleString();
	 var date=new Date();
	$("#startDt").val(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+(date.getDate()));
	$("#endDt").val(getNextDay(date));
	
	refresh();
	
	
/*	$("#search_btn").click(function(){
		refresh();
	})*/
	//TODO  触发了3次
	$("#startDt").change(function(){
		$("#endDt").val(getNextDay($("#startDt").val()));
		refresh();
	})
//	$("#endDt").change(function(){
//		$("#startDt").val(getBeforeDay($("#endDt").val()));
//		refresh();
//	})
    
});  

  
	/**
	 * 试机详细信息
	 */
function refresh(param){
	var param = {
			startDt:$("#startDt").val(),
			endDt:$("#endDt").val(),
			};
	$.ajax({
		type:"post",
		url:"testRunMsg.do",
		contentType : 'application/json;charset=UTF-8',
		dataType: 'json',
		data:JSON.stringify(param),
		async:true,
		success:function(data){
			if(data.code==0){
				var inewsMonOns=data.result.inewsMonOns;
				var messages=data.result.messages;
				var ncStatus=data.result.ncStatus;
				var checkInterplays=data.result.checkInterplays;
				$("#load_inewscnt").html(inewsMonOns.length);
				$("#restart_spcnt").html(ncStatus.length);
				$("#warning_cnt").html(messages.length);
				$("#checkInterplays_cnt").html(checkInterplays.length);
				
				//串联单
				var tr="";
				$(".inews").html("");
				$.each(inewsMonOns,function(i,item){
					if(item.studio!=1&&item.studio!=2&&item.studio!=7&&item.studio!=9){
						tr+=" <tr> <td>"+item.studio+"</td> <td>"+item.time+"</td> " +
						" <td>"+item.createBy+"</td> <td>"+item.queue+"</td>   </tr>  ";
					}
				});
				$(".inews").append(tr);
				
				//审片机
				var sp="";
				$("#sp").html("");
				$.each(ncStatus,function(i,item){
					sp+=" <a href=\"#\" class=\"list-group-item\"> <i class=\"fa  fa-fw\"></i> "+item.alias+"" +
							"<span class=\"pull-right text-muted small\"><em>"+formatDateTime(item.createDate)+"</em>  </span>  </a>  ";
				})
				$("#sp").append(sp);
				
				//interplay测试
				var interplay="";
				$(".interplay").html("");
				$.each(checkInterplays,function(i,item){
					
					var info=item.checkinfo;
					var infos=info.split("!");
					var infoResult=infos[0];
					var userName="",operateTime,time;
					if(infos[1].indexOf('v')>=0){
						userName=infos[1].substring(infos[1].indexOf('v'), infos[1].lastIndexOf("测"));
					}
					operateTime=infos[1].substring(infos[1].lastIndexOf("间")+2);
//					2018-12-12T05:30:01.000+0800  05:18:10
					if(operateTime.indexOf('T')>=0){
						time=operateTime.substring(operateTime.indexOf('T')+1,operateTime.indexOf('.'))
					}else{
						time=operateTime;
					}
					if(("info"==item.checkresult)){
						interplay+=" <tr> <td>"+item.checkname+"</td> <td>"+userName+"</td> <td>"+time+"</td><td>"+infoResult+"</td>  </tr>  ";
					}
				});
				$(".interplay").append(interplay);
				
				//报警信息
				var message="";
				$("#message").html("");
				$.each(messages,function(i,item){
					if(item=='试机正常'){
						$("#warning_cnt").html(0);
					}else{
						message+=" <li class=\"right clearfix\"> <span class=\"chat-img pull-left\">" +
						"  <img src=\"http://placehold.it/50/55C1E7/fff\" alt=\"User Avatar\" class=\"img-circle\" />" +
						"  </span> <div class=\"chat-body clearfix\"> <p> "+item+" </p>   </div>  </li>"
					}
				});
				$("#message").append(message);
				
			}else{
				alert("联系管理员");
			}
		},
		error:function(data){
			
			}
	});
}

	
	





 