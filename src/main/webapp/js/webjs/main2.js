$(function(){
	
	
	// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main2'));

$.ajax({
	type:"get",
	url:"getAssetList.do",
	dataType: 'json',
	async:true,
	success:function(data1){
		option = {
			    title: {
			        text: '线索',
//			      subtext: '12月',
			        x: 'center',
			        y: 'center',
			        textStyle: {
			            fontWeight: 'normal',
			            fontSize: 40
			        }
			    },
			    tooltip: {
			        trigger: 'item',
			        formatter: function(params, ticket, callback) {
			            var res = params.seriesName;
			            res += '<br/>' + params.name + ' : ' + params.percent + '%';
			            return res;
			        }
			    },
			    legend: {
			        orient: 'vertical',
			        right: '0%',
			        bottom: '0%',
			        data: ['区县台视频', 'CPTN', '美联', '路透','报片'],
			        itemWidth: 30,
			        itemHeight: 20
			    },
			    series: [{
			        name: '数量',
			        type: 'pie',
			        selectedMode: 'single',
			        radius: ['50%', '90%'],
			        label: {
			            normal: {
			                position: 'inner',
			                textStyle: {
			                    color: '#fff',
			                    fontSize: 20
			                }
			            }
			        },
			        labelLine: {
			            normal: {
			                show: false
			            }
			        },
			        data: [{
			            value: data1.result.区县台视频,
			            name: '区县台视频'
			        }, {
			            value: data1.result.CPTN,
			            name: 'CPTN'
			        }, {
			            value: data1.result.美联社,
			            name: '美联'
			        }, {
			            value: data1.result.路透社,
			            name: '路透'
			        }, {
			            value: data1.result.报片,
			            name: '报片'
			        }]
			    }]
			};
			        // 使用刚指定的配置项和数据显示图表。
			        myChart.setOption(option);
			    
	},
	error: function(data1){
		alert("error"+data1);
	}
});

    
	
})
        