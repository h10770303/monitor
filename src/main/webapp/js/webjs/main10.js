$(function(){
	
	
	// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main10'));

$.ajax({
	type:"get",
	url:"getTitleList.do",
	dataType: 'json',
	async:true,
	success:function(data1){

		option = {
			    tooltip: {
			        trigger: 'item',
			        formatter: "{b}"
			    },
			    series: [{
			        type: 'treemap',
			        width: '100%',
			        height: '100%',
			        roam: true, //是否开启拖拽漫游（移动和缩放）
			        nodeClick: false,//点击节点后的行为,false无反应
			        breadcrumb: {
			            show: false
			        },
			        label: { //描述了每个矩形中，文本标签的样式。
			            normal: {
			                show: true,
			                position: ['40%', '40%']
			            }
			        },
			        itemStyle: {
			            normal: {
			                show: true,
			                textStyle: {
			                    color: '#fff',
			                    fontSize: 16,
			                },
			            },
			            emphasis: {
			                label: {
			                    show: true
			                }
			            }
			        },
			        data: [
			        { 
			            value: 10,
			            name: '红色\n\n100(品牌数量)\n\n30%',
			            itemStyle: {
			                normal: {
			                    color: "#c33430",
			                }
			            }
			           
			        }, 
			        {
			            value: 10,
			            name: '蓝色\n\n100(品牌数量)\n\n30%',
			            itemStyle: {
			                normal: {
			                    color: "#2e4454",
			                }
			            }
			            
			        }, 
			        {
			                    value: 10,
			                    children: [{
			                        name: '连体A1\n\n10(品牌数量)\n\n30%',
			                        value: 3,
			                        itemStyle: {
			                            normal: {
			                                color: '#81e7cf'
			                            }
			                        }
			                    }, {
			                        name: '连体A1\n\n10(品牌数量)\n\n30%',
			                        value: 3,
			                        itemStyle: {
			                            normal: {
			                                color: '#81e7cf'
			                            }
			                        }
			                    }, {
			                        name: '连体\n\n20(品牌数量)\n30%',
			                        value: 2,
			                        itemStyle: {
			                            normal: {
			                                color: '#81e7cf'
			                            }
			                        }
			                    }, {
			                        name: '连体\n\n30(品牌数量)\n30%',
			                        value: 2,
			                        itemStyle: {
			                            normal: {
			                                color: '#81e7cf'
			                            }
			                        }
			                    }]
			                },
			        {
			            value: 10,
			            name: '黑色\n\n100(品牌数量)\n\n30%',
			            itemStyle: {
			                normal: {
			                    color: "#d48363",
			                }
			            }
			            
			        }
			       
			        
			        ]
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
        