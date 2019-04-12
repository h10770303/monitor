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
	querys(); 
	// 定时刷新
	setInterval("refresh()",10000);
    $("#search_btn").click(function(){
    	refresh();
    });
})  
  

function refresh(){
	$("#empUserList").bootstrapTable('refresh', {url: 'getMonitorConfFlow.do',queryParams:function queryParams(params) { // 设置查询参数
		var param = {
				startDt:$("#startDt").val(),
				endDt:$("#endDt").val(),
				programTitle:$("#programTitle").val(),
			pageNo : 1,
			pageSize : params.pageSize,
			 sortName:this.sortName,
             sortOrder:this.sortOrder
		};
		
		return JSON.stringify(param);
	}});
}
function getNextDay(d){
        d = new Date(d);
        d = +d + 1000*60*60*24;
        d = new Date(d);
        //return d;
        //格式化
        return d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
         
    }

function querys() {  
    $("#empUserList").bootstrapTable({  
        url : 'getMonitorConfFlow.do',  
        height : '500',  
        undefinedText : '-',  
        pagination : true, // 分页  
        striped : true, // 是否显示行间隔色  
     // 设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
		// 设置为limit可以获取limit, offset, search, sort, order
        contentType : 'application/json;charset=UTF-8',
        dataTpe:'json',
        method:"post",
		queryParamsType : "undefined",
		queryParams : function queryParams(params) { // 设置查询参数
			var param = {
					startDt:$("#startDt").val(),
					endDt:$("#endDt").val(),
					programTitle:$("#programTitle").val(),
				pageNo : params.pageNumber,
				pageSize : params.pageSize,
				 sortName:this.sortName,
                 sortOrder:this.sortOrder
			};
			
			return JSON.stringify(param);
		},
        cache : false, // 是否使用缓存  
        pagination: true, //分页
        pageNumber:1,   //初始化加载第一页，默认第一页
        pageSize: 20,   //每页的记录行数（*）
        pageList : [ 5, 10, 20,25 ],  
        sortable:true,
        sortOrder:"desc",
        toolbar : "#toolbar",// 指定工具栏  
        showColumns : false, // 显示隐藏列  
        showRefresh : true, // 显示刷新按钮  
       // uniqueId : "programID", // 每一行的唯一标识  
        sidePagination : "server", // 服务端处理分页  
        showExport: false,                     //是否显示导出
        exportDataType: "all",              //basic', 'all', 'selected'.
        rowStyle:function(row,index){
        	 //这里有5个取值代表5中颜色['active', 'success', 'info', 'warning', 'danger'];
            var strclass = "";
           if (row.ifHasError == 1) {
        	   if(row.errorInfo=='未能从inews中获取到文稿！'){
//        		   strclass = 'warning';
        	   }else{
        		   strclass = 'danger';
        	   }
            }
            else {
                return {};
            }
            return { classes: strclass }
        },
        columns : [{  
            title : '任务名',  
            field : 'programTitle', // 字段  
            align : 'left', // 对齐方式（左 中 右）  
            valign : 'middle', //  
            formatter:function(value,row,index){ 
         	   var e = '<a href="#" mce_href="#" onclick="ondetail(\''+ row.programID + '\')">'+value+'</a> '; 
         	   return e;
         	  } ,
            sortable : false  
        }, {  
            title : '节目时长',  
            field : 'duration',  
            align : 'center',  
            valign : 'middle',  
            sortable : false  
        }, {  
            title : '操作人',  
            field : 'createBy',  
            align : 'center',  
            valign : 'middle',  
            sortable : false  
        },{  
            title : '开始时间',  
            field : 'createTime',  
            align : 'center',  
            valign : 'middle',  
            sortable : false  
        },{  
            title : '进度',  
            field : 'precent',  
            align : 'center',  
            valign : 'left',
            formatter:function(value,row,index){ 
          	   var e = ["<div class='progress'> <div class='progress-bar' role='progressbar' aria-valuenow='20' aria-valuemin='0' aria-valuemax='100' style='width:"+row.precent+"'>"+row.precent+"</div> </div>"]; 
          	   return e;
          	  } ,
            sortable : true  
        },{  
            title : '耗时(s)',  
            field : 'diffTimes',  
            align : 'center',  
            valign : 'middle',  
            sortable : true  
        },{  
            title : '流程状态',  
            field : 'ifHasErrors',  
            align : 'center', 
            valign : 'middle',  
            sortable : true  
        },{  
            title : '备注',  
            field : 'errorInfo',  
            align : 'center',  
            valign : 'middle',  
            sortable : false  ,
            formatter:function(value,row,index){ 
            	var e=row.errorInfo;
            	/*if(row.ifHasErrors=='未完成'){
            		var duration=row.duration;
            		var durations=duration.split(":");
            		var aa=parseInt(durations[0])*3600+ parseInt(durations[1])*60+parseInt(durations[2]);
            		
            		var date=(new Date().getTime()-parseLong(row.createStamp))/(1000*60);
            		if(date>aa*15){
            			e="反推流程未知异常，请联系管理员！";
            		}
        			
            	}*/
           	   return e;
           	  } 
        }],  
        responseHandler : function(res) { 
            return {  
                total : res.total,  
                rows : res.records  
            };  
        } 
    })  
}  
 
function queryParams(pageReqeust) {  
    pageReqeust.enabled = $("#enabled").val();  
    pageReqeust.querys = $("#querys").val();  
    pageReqeust.pageNo = this.offset;  
    pageReqeust.pageSize = this.pageNumber;  
    return pageReqeust;  
}  

function ondetail(param){
	$("#myModalLabel").text("详细流程节点");
	$('#myModal').modal();
	$.ajax({
		type:"get",
		url:"getBussinessNodeBeanByprogramID.do?programID="+param,
		dataType: 'json',
		async:true,
		success:function(data){
			var result=data.result;
			$("#modal-body").html("");
			$.each(result, function(i) {  
			    $(" <div class=\"form-group\">" +
			    		" <label for=\"txt_parentdepartment\">"+result[i].nodeNames+"</label><br/>" +
			    		" <span>耗时：</span><span>"+result[i].diffTime+"</span><br/>" +
			    		"<span>异常信息：</span>"+result[i].errorInfo+"<br/>").appendTo("#modal-body")
			});
		},
		error:function(data){
			
			}
	});
}
 