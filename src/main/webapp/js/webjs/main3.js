$(function(){
	
	
	// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main3'));

$.ajax({
	type:"get",
	url:"getTitleList.do",
	dataType: 'json',
	async:true,
	success:function(data1){
		option = {
			    title: {
			        text: '报道',
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
			        data: ['电视', '数字', '看看'],
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
			            value: data1.result.电视,
			            name: '电视:'+data1.result.电视
			        }, {
			            value: data1.result.数字,
			            name: '数字:'+data1.result.数字
			        }, {
			            value: data1.result.送看看,
			            name: '送看看:'+data1.result.送看看
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
        