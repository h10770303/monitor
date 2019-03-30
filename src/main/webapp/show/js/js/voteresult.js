$(function() { 
	getVoteResultMyself();
})  
  
function getVoteResultMyself() {  
  $("#getVoteResultMyself").bootstrapTable({  
      url : 'getVoteResultMyself.do',  
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
          title : '明星类型',  
          field : 'starTypes', // 字段  
          align : 'left', // 对齐方式（左 中 右）  
          valign : 'middle', //  
          sortable : true  
      },{  
          title : '候选明星',  
          field : 'candidate',  
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
 