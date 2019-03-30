$(function(){
	
	// 基于准备好的dom，初始化echarts实例
       var myChart = echarts.init(document.getElementById('kkEchart'));
	   var assetResult;      

queryhits(myChart);

$("#search_echart").click(function(){
	queryhits(myChart);
})
	
})

function queryhits(myChart){
	var param={};
	param.step=$("#step").val();
	$.ajax({
		type:"post",
		url:"messageGroupTime.do",
		contentType : 'application/json;charset=UTF-8',
		dataType: 'json',
		data:JSON.stringify(param),
		async:true,
		success:function(data1){
			var programFlowBeans=data1.result;
//			var toXnewsCnts=data1.result.toXnewsCnts;
			var names=[], values=[];
			var namess=[], valuess=[],valuess1=[],valuess2=[];
			
			
			// 第一张图
			$.each(programFlowBeans, function(i) {  
				names.push(programFlowBeans[i].time);
				values.push(programFlowBeans[i].cnt);
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
//				myChart2.setOption(option2);
		},
		error: function(data1){
			alert("error"+data1);
		}
	});
}
        