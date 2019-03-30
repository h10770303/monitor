$(function(){
	
	// 基于准备好的dom，初始化echarts实例
       var myChart = echarts.init(document.getElementById('txwsCntEchart'));
	   var assetResult;      

var param={};
var date=new Date();
param.startDt=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+(date.getDate());
param.endDt=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+(date.getDate()+1);
queryhits2(param,myChart);

	
})

function queryhits2(param,myChart){
	
	$.ajax({
		type:"post",
		url:"getProgramnodeCnt.do",
		contentType : 'application/json;charset=UTF-8',
		dataType: 'json',
		data:JSON.stringify(param),
		async:true,
		success:function(data1){
			var title = 'avid反推与看看引用量占比';
			var result=data1.result;
			var names=[], values=[],values1=[],values2=[];
			
			$.each(result, function(i) {  
				names.push(result[i].createTimed);
				values.push(result[i].count);
				values1.push(result[i].kankanCnt);
				values2.push(result[i].percent);
			});
			
			option = {
				    tooltip: {
				        trigger: 'axis',
				        formatter: function(params, ticket, callback) {

				            var res = params[0].name;

				            for (var i = 0, l = params.length; i < l; i++) {
				                if (params[i].seriesType === 'line') {
				                    res += '<br/>' + params[i].seriesName + ' : ' + (params[i].value ? params[i].value : '-') + '%';
				                } else {
				                    res += '<br/>' + params[i].seriesName + ' : ' + (params[i].value ? params[i].value : '-') + '条';
				                }
				            }
				            return res;

				        }
				    },
				    grid: {
				        containLabel: true
				    },
				    legend: {
				        data: ['利用率', '反推量', '看看引用量']
				    },
				    xAxis: [{
				        type: 'category',
				        axisTick: {
				            alignWithLabel: true
				        },
				        data: names
				    }],
				    dataZoom: [{
				        type: 'slider',
				        xAxisIndex: 0,
				        filterMode: 'empty',
				        start: 0,
				        end: 100
				    }, {
				        type: 'slider',
				        yAxisIndex: 0,
				        filterMode: 'empty',
				        start: 0,
				        end: 100
				    }, {
				        type: 'inside',
				        xAxisIndex: 0,
				        filterMode: 'empty',
				        start: 0,
				        end: 100
				    }, {
				        type: 'inside',
				        yAxisIndex: 0,
				        filterMode: 'empty',
				        start: 0,
				        end: 100
				    }],
				    yAxis: [{
				        type: 'value',
				        name: '利用率',
				        min: 0,
				        position: 'left',
				        axisLabel: {
				            formatter: '{value} %'
				        }
				    }, {
				        type: 'value',
				        name: '数量',
				        min: 0,
				        position: 'right',
				        axisLabel: {
				            formatter: '{value} 条'
				        }
				    }],
				    series: [{
				        name: '利用率',
				        type: 'line',
				        label: {
				            normal: {
				                show: true,
				                position: 'top',
				            }
				        },
				        lineStyle: {
				            normal: {
				                width: 3,
				                shadowColor: 'rgba(0,0,0,0.4)',
				                shadowBlur: 10,
				                shadowOffsetY: 10
				            }
				        },
				        data: values2
				    }, {
				        name: '反推量',
				        type: 'bar',
				        yAxisIndex: 1,
				        label: {
				            normal: {
				                show: true,
				                position: 'top'
				            }
				        },
				        data: values
				    }, {
				        name: '看看引用量',
				        type: 'bar',
				        yAxisIndex: 1,
				        label: {
				            normal: {
				                show: true,
				                position: 'top'
				            }
				        },
				        data: values1
				    }]
				};

			        // 使用刚指定的配置项和数据显示图表。
	        myChart.setOption(option);
		},
		error: function(data1){
			alert("error"+data1);
		}
	});
}
        