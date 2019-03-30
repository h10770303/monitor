$(function(){
	
	// 基于准备好的dom，初始化echarts实例
       var myChart = echarts.init(document.getElementById('kkEchart'));
       var myChart2 = echarts.init(document.getElementById('txwsCntEchart'));
	   var assetResult;      

var param={};
var date=new Date();
param.startDt=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+(date.getDate());
param.endDt=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+(date.getDate()+1);
queryhits(param,myChart,myChart2);

$("#today").click(function(){
	 var date=new Date();
	param.startDt=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+(date.getDate());
	param.endDt=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+(date.getDate()+1);
	queryhits(param,myChart,myChart2);
})
$("#yesteday").click(function(){
	 var date=new Date();
	param.startDt=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+(date.getDate()-1);
	param.endDt=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+(date.getDate());
	queryhits(param,myChart,myChart2);
})
$("#week").click(function(){
	param.startDt=getWeekStartDate();
	param.endDt=getWeekEndDate();
	queryhits(param,myChart,myChart2);
})
$("#month").click(function(){
	param.startDt=getMonthStartDate();
	param.endDt=getMonthEndDate();
	queryhits(param,myChart,myChart2);
})
	
})

function queryhits(param,myChart,myChart2){
	
	$.ajax({
		type:"post",
		url:"getTopHitsEchart.do",
		contentType : 'application/json;charset=UTF-8',
		dataType: 'json',
		data:JSON.stringify(param),
		async:true,
		success:function(data1){
			var programFlowBeans=data1.result.programFlowBeans;
			var toXnewsCnts=data1.result.toXnewsCnts;
			var names=[], values=[];
			var namess=[], valuess=[],valuess1=[],valuess2=[];
			
			
			// 第二张图
			$.each(toXnewsCnts, function(i) {  
				namess.push(toXnewsCnts[i].createTimed);
				valuess.push(toXnewsCnts[i].count);
				valuess1.push(toXnewsCnts[i].kankanCnt);
				valuess2.push(toXnewsCnts[i].percent);
			});
			var option2 = {
					 title : {
					        text: 'avid反推与看看引用量占比',
					    },
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
				        data: namess
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
				        data: valuess2
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
				        data: valuess
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
				        data: valuess1
				    }]
				};
			
			
			// 第一张图
			$.each(programFlowBeans, function(i) {  
				names.push(programFlowBeans[i].programTitle);
				values.push(programFlowBeans[i].hits);
			});
			
			
			
			deemph_color = 'rgb(165,165,165)'
				emph_color = 'rgb(79,129,189)'
				height = 300
				bar_category_gap = '28%'

			var option1 = {
				    title : {
				        text: '看看点评量前十榜',
				    },
				    grid: {
				        left: '0',
				        containLabel: true,
				        height:height,
				    },
				    tooltip: {
				        trigger: 'axis',
				        axisPointer: {
				            type: 'shadow'
				        }
				    },
				    xAxis : [
				        {
				            type : 'category',
				            axisLabel: {
				                interval: 0,
				                margin:10,
				                rotate:30
				            },
				            textStyle: {
		                        fontWeight:'bold'
		                    },
				            data : names,
				        }],
				    yAxis : [
				        {
				            name: '数量',
				            type : 'value',
				            splitLine: {show: false},
				        },
				    ],
				    series : [
				        {
				            name: '数量',
				            type: 'bar',
				            barCategoryGap: bar_category_gap,
				            data: values,
				            itemStyle: {
				                normal: {
				                    color: deemph_color
				                }
				            },
				        },
				    ]
				};

			        // 使用刚指定的配置项和数据显示图表。
			        myChart.setOption(option1);
				myChart2.setOption(option2);
		},
		error: function(data1){
			alert("error"+data1);
		}
	});
}
        