$(function(){
	
	
	// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main4'));

$.ajax({
	type:"get",
	url:"getTitleList.do",
	dataType: 'json',
	async:true,
	success:function(data1){

		option = {
		    tooltip: {
		        trigger: 'item',
		        formatter: "{a} <br/>{b}: {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        x: 'left',
		        data:['Android','IOS','OthersMobile','Windows','Mac','Linux','OthersPC']
		    },
		    series: [
		        {
		            name:'访问来源',
		            type:'pie',
		            selectedMode: 'single',
		            radius: [0, '30%'],

		            label: {
		                normal: {
		                    position: 'inner'
		                }
		            },
		            labelLine: {
		                normal: {
		                    show: false
		                }
		            },
		            data:[
		                {value:75100817.1254119, name:'移动端', selected:true},
		                {value:118182588.874588, name:'PC 端'},
		            ]
		        },
		        {
		            name:'访问来源',
		            type:'pie',
		            radius: ['40%', '55%'],

		            data:[
		                {value:35880113, name:'Android'},
		                {value:37846064, name:'IOS'},
		                {value:1374640.12541185, name:'OthersMobile'},
		                {value:108944238, name:'Windows'},
		                {value:5411511, name:'Mac'},
		                {value:1663634, name:'Linux'},
		                {value:2163205.87458815, name:'OthersPC'},
		            ]
		        }
		    ]
		};
			        // 使用刚指定的配置项和数据显示图表。
			        myChart.setOption(option);
			    
	},
	error: function(data1){
		alert("error"+data1);
	}
});

    
	
})
        