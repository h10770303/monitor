$(function() { 
    querys(); 
    $("#search_btn").click(function(){
    	$("#empUserList").bootstrapTable('refresh', {url: 'rundown.do',queryParams:function queryParams(params) { // 设置查询参数
			var param = {
				cName:$("#cName").val(),
				pageNo : 1,
				pageSize : params.pageSize,
				 sortName:this.sortName,
                 sortOrder:this.sortOrder
			};
			
			return JSON.stringify(param);
		}}); 
    });
    
    
})  
  

function querys() {  
    $("#empUserList").bootstrapTable({  
        url : 'rundown.do',  
        height : '500',  
        undefinedText : '-',  
        pagination : true, // 分页  
        striped : true, // 是否显示行间隔色  
        contentType : 'application/json;charset=UTF-8',
        dataTpe:'json',
        method:"post",
		queryParamsType : "undefined",
		queryParams : function queryParams(params) { // 设置查询参数
			var param = {
				cName:$("#cName").val(),
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
        pageSize: 40,   //每页的记录行数（*）
        pageList : [ 40 ],  
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
                strclass = 'danger';
            }
            else {
                return {};
            }
            return { classes: strclass }
        },
        columns : [{  
            title : '节目名',  
            field : 'pName', // 字段  
            align : 'left', // 对齐方式（左 中 右）  
            valign : 'middle', //  
            formatter:function(value,row,index){ 
         	   var e = '<a href="http://www.tvmao.com/program/CCTV-'+$("#cName").val()+'-w3.html" target="_blank" mce_href="#" >'+value+'</a> '; 
         	   return e;
         	  } ,
            sortable : false  
        },{  
            title : '播放时间',  
            field : 'time',  
            align : 'center',  
            valign : 'middle',  
            sortable : false  
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

 