//通过bootstrap Table方法refresh重新加载数据  
function showData() {  
    $('#tableList').bootstrapTable('refresh');  
}  
  
//官方使用方法的语法：<code>$('#table').bootstrapTable('method', parameter)</code>  
$('#tableList').bootstrapTable({  
    columns: [{  
        field: 'id',  
        title: '序号',  
    }, {  
        field: 'programTitle',  
        title: '流程名',  
    }, {  
        field: 'businessName',  
        title: '业务名',  
    },{  
        field: 'createBy',  
        title: '创建人',  
    }],//页面需要展示的列，后端交互对象的属性  
    pagination: true,  //开启分页  
    sidePagination: 'server',//服务器端分页  
    pageNumber: 1,//默认加载页  
    pageSize: 20,//每页数据  
    pageList: [20, 50, 100, 500],//可选的每页数据  
    queryParams: function (params) {  
        return {  
        startDate: $("#txtStartDate").val(),  
        endDate: $("#txtEndDate").val(),  
        merName: $("#txtMerName").val(),  
            pageSize: params.limit,  
            offset: params.offset  
        }  
    },//请求服务器数据时的参数  
    url: 'getMonitorConfFlow.do' //服务器数据的加载地址  
});  