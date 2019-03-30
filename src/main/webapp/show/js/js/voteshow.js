$(function() { 
    querys(); 
    candidateTop10();
})  
  
function querys() {  
    $("#votepartment").bootstrapTable({  
        url : 'getVotePartment.do',  
        height : '500',  
        undefinedText : '-',  
        pagination : false, // 分页  
        striped : true, // 是否显示行间隔色  
     // 设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
		// 设置为limit可以获取limit, offset, search, sort, order
        contentType : 'application/json;charset=UTF-8',
        dataTpe:'json',
        method:"post",
		queryParamsType : "undefined",
		queryParams : function queryParams(params) { // 设置查询参数
			var param = {
					startDt:'',
					endDt:'',
					programTitle:'',
				pageNo : params.pageNumber,
				pageSize : params.pageSize,
				 sortName:this.sortName,
                 sortOrder:this.sortOrder
			};
			
			return JSON.stringify(param);
		},
        cache : false, // 是否使用缓存  
        pagination: false, //分页
        pageNumber:1,   //初始化加载第一页，默认第一页
        pageSize: 20,   //每页的记录行数（*）
        pageList : [ 5, 10, 20,25 ],  
        sortable:true,
        sortOrder:"desc",
        toolbar : "#toolbar",// 指定工具栏  
        showColumns : false, // 显示隐藏列  
        showRefresh : false, // 显示刷新按钮  
       // uniqueId : "programID", // 每一行的唯一标识  
        sidePagination : "server", // 服务端处理分页  
        showExport: false,                     //是否显示导出
//        exportDataType: "all",              //basic', 'all', 'selected'.
        columns : [{  
            title : '部门',  
            field : 'partments', // 字段  
            align : 'left', // 对齐方式（左 中 右）  
            valign : 'middle', //  
            sortable : false  
        },{  
            title : '投票数',  
            field : 'cnt',  
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

function candidateTop10() {  
  $("#candidateTop10").bootstrapTable({  
      url : 'candidateTop10.do',  
      height : '500',  
      undefinedText : '-',  
      striped : true, // 是否显示行间隔色  
      method:"get",
      cache : false, // 是否使用缓存  
      showColumns : false, // 显示隐藏列  
      sortable:false,
      showRefresh : false, // 显示刷新按钮  
//      uniqueId : "programID", // 每一行的唯一标识  
      sidePagination : "server", // 服务端处理分页  
      columns : [ {  
          title : '姓名',  
          field : 'candidate', // 字段  
          align : 'left', // 对齐方式（左 中 右）  
          valign : 'middle', //  
          sortable : true  
      },{  
          title : '投票数',  
          field : 'cnt',  
          align : 'center',  
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
 