$(function() {
	querys();
})

function querys() {
	$("#edit").attr({
		"disabled" : "disabled"
	});
	$("#delete").attr({
		"disabled" : "disabled"
	});
	$("#empUserList").bootstrapTable({
		url : 'getMonitorConfFlow.do',
		height : '500',
		undefinedText : '-',
		pagination : true, // 分页
		striped : true, // 是否显示行间隔色
		// 设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
		// 设置为limit可以获取limit, offset, search, sort, order
		queryParamsType : "undefined",
		queryParams : function queryParams(params) { // 设置查询参数
			var param = {
				// 这里是在ajax发送请求的时候设置一些参数 params有什么东西，自己看看源码就知道了
				pageNo : params.pageNumber,
				pageSize : params.pageSize
			};
			return param;
		},
		cache : false, // 是否使用缓存
		pageSize : 15, // 每页显示的记录数
		pageNumber : 1, // 当前第几页
		pageList : [ 5, 10, 20 ],
		toolbar : "#toolbar",// 指定工具栏
		showColumns : true, // 显示隐藏列
		showRefresh : true, // 显示刷新按钮
		search : false, // 列不排序
		uniqueId : "userName", // 每一行的唯一标识
		// method:"get",
		sidePagination : "server", // 服务端处理分页
		columns : [ {
			field : 'programID',
			checkbox : true,
			align : 'center',
			valign : 'middle'
		}, {
			title : '流程名',
			field : 'programTitle', // 字段
			align : 'center', // 对齐方式（左 中 右）
			valign : 'middle', //  
			sortable : true
		}, {
			title : '业务名',
			field : 'businessName',
			align : 'center',
			valign : 'middle',
			sortable : true
		} ],
		// 远程数据加载之前,处理程序响应数据格式,对象包含的参数: 我们可以对返回的数据格式进行处理
		// 在ajax后我们可以在这里进行一些事件的处理
		responseHandler : function(res) {
			return {
				total : res.total,
				rows : res.records
			};
		},
		onLoadSuccess : function(data) { // 加载成功时执行
			alert("加载成功" + data);
		},
		onLoadError : function() { // 加载失败时执行
			alert("加载数据失败", {
				time : 1500,
				icon : 2
			});
		},

		onCheck : function() {
			buttonControl('#empUserList', '#edit', '#delete');
		},
		onCheckAll : function() {
			buttonControl('#empUserList', '#edit', '#delete');
		},
		onUncheckAll : function() {
			buttonControl('#empUserList', '#edit', '#delete');
		},
		onUncheck : function() {
			buttonControl('#empUserList', '#edit', '#delete');
		}
	})
}
/** 替换数据为文字 */
function genderFormatter(value) {
	if (value == null || value == undefined) {
		return "-";
	} else if (value == 1) {
		return "已删除";
	} else if (value == 0) {
		return "正常";
	}
}
/** 刷新页面 */
function refresh() {
	$('#empUserList').bootstrapTable('refresh');
}
/** 查询条件与分页数据 */
function queryParams(pageReqeust) {
	pageReqeust.enabled = $("#enabled").val();
	pageReqeust.querys = $("#querys").val();
	pageReqeust.pageNo = this.offset;
	pageReqeust.pageSize = this.pageNumber;
	alert(11)
	return pageReqeust;
}
/** 编辑数据 */
function editHr() {
	var selectRow = $("#empUserList").bootstrapTable('getSelections');
	if (selectRow.length != 1) {
		layer.alert('请选择并只能选择一条数据进行编辑！', {
			icon : 2
		});
		return false;
	} else {
		window.location = createUrl("admin/hrEmployee/view?username="
				+ selectRow[0].userName);
	}
}
/**
 * 删除数据
 */
function deleteHr() {
	var hrs = $("#empUserList").bootstrapTable('getSelections');
	if (hrs.length < 1) {
		layer.alert('请选择一条或多条数据进行删除！', {
			icon : 2
		});
	} else {
		layer.confirm('确定要删除所选数据？', {
			icon : 3,
			title : '提示'
		}, function() {
			var userNames = [];
			for (var i = 0; i < hrs.length; i++) {
				userNames.push(hrs[i].userName);
			}
			$.ajax({
				url : '../../../admin/hrEmployee/delete',
				traditional : true, // 阻止深度序列化，向后台传送数组
				data : {
					userNames : userNames
				},
				contentType : 'application/json',
				success : function(msg) {
					if (msg.success) {
						layer.alert(msg.msg, {
							icon : 1
						});
					} else {
						layer.alert(msg.msg, {
							icon : 2
						});
					}
					refresh();
					$("#edit").attr({
						"disabled" : "disabled"
					});
					$("#delete").attr({
						"disabled" : "disabled"
					});
				}
			})
		});
	}
}