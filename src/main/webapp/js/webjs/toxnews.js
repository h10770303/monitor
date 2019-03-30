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
   // queryhits();
    
    $("#search_btn").click(function(){
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
    });
})  

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
        showColumns : true, // 显示隐藏列  
        showRefresh : true, // 显示刷新按钮  
       // uniqueId : "programID", // 每一行的唯一标识  
        sidePagination : "server", // 服务端处理分页  
        showExport: true,                     //是否显示导出
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
        },{  
            title : '节目时长',  
            field : 'duration',  
            align : 'center',  
            valign : 'middle',  
            sortable : false  
        }, {  
            title : '创建人',  
            field : 'createBy',  
            align : 'center',  
            valign : 'middle',  
            sortable : false  
        },{  
            title : '开始时间',  
            field : 'createTimes',  
            align : 'center',  
            valign : 'middle',  
            sortable : false  
        },{  
            title : '耗时(s)',  
            field : 'diffTimes',  
            align : 'center',  
            valign : 'middle',  
            sortable : true  
        },{  
            title : '是否异常',  
            field : 'ifHasErrors',  
            align : 'center', 
            valign : 'middle',  
            sortable : true  
        },{  
            title : '报错信息',  
            field : 'errorInfo',  
            align : 'center',  
            valign : 'middle',  
            sortable : false  
        },{  
            title : '送看看',  
            field : 'isKankans',  
            align : 'center',  
            valign : 'middle',  
            sortable : true  
        },{  
            title : '评论数',  
            field : 'hits',  
            align : 'center', 
            formatter:function(value,row,index){ 
            	  var e = '<a href="'+row.hitsUrl+'" mce_href="#" target="_blank">'+value+'</a> ';   
         	   return e;
         	  } ,
            valign : 'middle',  
        }],  
     // 远程数据加载之前,处理程序响应数据格式,对象包含的参数: 我们可以对返回的数据格式进行处理
		// 在ajax后我们可以在这里进行一些事件的处理
        responseHandler : function(res) { 
            return {  
                total : res.total,  //获取后台返回的数据 总数量
                rows : res.records  // 获取后台返回的记录数
            };  
        } 
    })  
}  

function queryhits() {  
  $("#hitcount").bootstrapTable({  
      url : 'getTopHits.do',  
      height : '500',  
      undefinedText : '-',  
      striped : true, // 是否显示行间隔色  
      method:"get",
      cache : false, // 是否使用缓存  
      showColumns : true, // 显示隐藏列  
      sortable:false,
      showRefresh : true, // 显示刷新按钮  
      uniqueId : "programID", // 每一行的唯一标识  
      sidePagination : "server", // 服务端处理分页  
      columns : [ {  
          title : '任务名',  
          field : 'programTitle', // 字段  
          align : 'left', // 对齐方式（左 中 右）  
          valign : 'middle', //  
          sortable : true  
      },{  
          title : '节目时长',  
          field : 'duration',  
          align : 'center',  
          valign : 'middle',  
          sortable : true  
      }, {  
          title : '创建人',  
          field : 'createBy',  
          align : 'center',  
          valign : 'middle',  
          sortable : true  
      },{  
          title : '开始时间',  
          field : 'createTimes',  
          align : 'center',  
          valign : 'middle',  
          sortable : true  
      },{  
          title : '耗时(s)',  
          field : 'diffTimes',  
          align : 'center',  
          valign : 'middle',  
          sortable : true  
      },{  
          title : '评论数',  
          field : 'hits',  
          align : 'center', 
          formatter:function(value,row,index){ 
        	   var e = '<a href="'+row.hitsUrl+'" mce_href="#" target="_blank">'+value+'</a> '; 
        	   return e;
        	  } ,
          valign : 'middle',  
          sortable : true  
      }],  
      responseHandler : function(res) { 
          return {  
              total : res.total,  //获取后台返回的数据 总数量
              rows : res.records  // 获取后台返回的记录数
          };  
      }
  })  
}
/** 替换数据为文字 */  
function genderFormatter(value) {  
    if (value == null || value == undefined) {  
        return "-";  
    } else if (value==1) {  
        return "已删除";  
    } else if(value==0){  
        return "正常";  
    }  
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
 