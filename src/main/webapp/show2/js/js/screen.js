$(function() { 
    var param={};
    param.startDt='2017-08-29';
    param.endDt='2017-08-30';
    
	getNowClueCnt(param);
	  setInterval(function() {
		  getNowClueCnt(param);
		}, 5000);
//    
//    $("#test").click(function(){
//    	getNowClueCnt(param);
//    });
})  

function getNowClueCnt(param){
	$.ajax({
		type:"post",
		url:"getDashBord.do",
		contentType : 'application/json;charset=UTF-8',
		dataType: 'json',
		data:JSON.stringify(param),
		async:true,
		success:function(data){
			var assetByTimes=data.result.assetByTimes;
			clueCnt(assetByTimes)
			var clueSites= data.result.clueSites;
			clueSite(clueSites);
			clueFrom();
			getLogon();
			topicDesck();
			topicRefcount();
			titlePlatform();
			titleOrgcount();
			
		},
		error:function(data){
			alert(error);
		}
	});
}

/**
 * 线索、选题、报道数量
 */
function clueCnt(assetByTimes){
	assetByTimes.forEach(function(e){
		if(e.assetCategoryId=="clue"){
			$("#clue").html(e.number);
		}else if(e.assetCategoryId=="topic"){
			$("#topic").html(e.number);
		}else if(e.assetCategoryId=="title"){
			$("#title").html(e.number);
		}else if(e.assetCategoryId=="clip"){
			$("#clip").html(e.number);
		}
	});
}
/**
 * 线索来源 echart
 */
function clueSite(clueSites){
	var sites=[],values=[];
	clueSites.forEach(function(e){
		sites.push(e.site);
		values.push(e.count);
	});
	var clueSite = echarts.init(document.getElementById('clueSite'));
	option = {
			title : {
				text: '线索来源统计',
				subtext: '/条'
			},
			tooltip : {
				trigger: 'axis'
			},
			grid: {
				left: '3%',
				right: '4%',
				bottom: '3%',
				containLabel: true
			},
			xAxis : [
				{
					type : 'category',
					data : sites,
					splitLine:{
						show:false
					},
					axisTick: {
						alignWithLabel: true
					}
				}
			],
			yAxis : [
				{
					type : 'value',
					splitLine:{
						show:false
					},
					splitArea:{
						show:true,
					},
				}
			],
			series : [
				{
					name:'条数',
					type:'bar',
					label:{
					    normal:{
					        show:true,
					        position:'top'
					    }
					},
					itemStyle:{
						normal:{
							color:function(d){return "#"+Math.floor(Math.random()*(256*256*256-1)).toString(16);}
						}
					},
					data:values,
				}
			]
		};
	clueSite.setOption(option);
	
}

/**
*线索部门来源
 * 
 */
function clueFrom(){
	var clueFrom = echarts.init(document.getElementById('clueFrom'));
	//app.title = '嵌套环形图';

	option = {
		title : {
				text: '线索部门报片来源统计 ',
				
			},
	    tooltip: {
	        trigger: 'item',
	        formatter: "{a} <br/>{b}: {c} ({d}%)"
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
	                {value:335, name:'直达', selected:true},
	                {value:679, name:'营销广告'},
	                {value:1548, name:'搜索引擎'}
	            ]
	        },
	        {
	            name:'访问来源',
	            type:'pie',
	            radius: ['40%', '55%'],
	            label: {
	                normal: {
	                  //  formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
	                    backgroundColor: '#eee',
	                    borderColor: '#aaa',
	                    borderWidth: 1,
	                    borderRadius: 4,
	                    // shadowBlur:3,
	                    // shadowOffsetX: 2,
	                    // shadowOffsetY: 2,
	                    // shadowColor: '#999',
	                    // padding: [0, 7],
	                    rich: {
	                        a: {
	                            color: '#999',
	                            lineHeight: 22,
	                            align: 'center'
	                        },
	                        // abg: {
	                        //     backgroundColor: '#333',
	                        //     width: '100%',
	                        //     align: 'right',
	                        //     height: 22,
	                        //     borderRadius: [4, 4, 0, 0]
	                        // },
	                        hr: {
	                            borderColor: '#aaa',
	                            width: '100%',
	                            borderWidth: 0.5,
	                            height: 0
	                        },
	                        b: {
	                            fontSize: 16,
	                            lineHeight: 33
	                        },
	                        per: {
	                            color: '#eee',
	                            backgroundColor: '#334455',
	                            padding: [2, 4],
	                            borderRadius: 2
	                        }
	                    }
	                }
	            },
	            data:[
	                {value:335, name:'直达'},
	                {value:310, name:'邮件营销'},
	                {value:234, name:'联盟广告'},
	                {value:135, name:'视频广告'},
	                {value:1048, name:'百度'},
	                {value:251, name:'谷歌'},
	                {value:147, name:'必应'},
	                {value:102, name:'其他'}
	            ]
	        }
	    ]
	};
	
	clueFrom.setOption(option);
}


/**
 * 获取在线人数
 */
function getLogon(){
	
	var logonCnt = echarts.init(document.getElementById('logon'));
	var percent = 30;

	function getData() {
	    return [{
	        value: percent,
	        itemStyle: {
	            normal: {
	                color: '#fb358a',
	                shadowBlur: 10,
	                shadowColor: '#fb358a'
	            }
	        }
	    }, {
	        value: 1 - percent,
	        itemStyle: {
	            normal: {
	                color: 'transparent'
	            }
	        }
	    }];
	}

	option = {
	    backgroundColor: '#333645',

	    title: {
	        text: percent ,
	        x: 'center',
	        y: 'center',
	        textStyle: {
	            color: '#98a0c4',
	            fontWeight: 'bolder',
	            fontSize: 64,
	        }
	    },
	    series: [{
	            type: 'pie',
	            radius: ['39%', '49%'],
	            silent: true,
	            label: {
	                normal: {
	                    show: false,
	                }
	            },

	            data: [{
	                value: 1,
	                itemStyle: {
	                    normal: {
	                        color: '#313443',
	                        shadowBlur: 10,
	                        shadowColor: '#1b1e25',


	                    }
	                }
	            }],

	            animation: false
	        },

	        {
	            type: 'pie',
	            radius: ['39%', '49%'],
	            silent: true,
	            label: {
	                normal: {
	                    show: false,
	                }
	            },

	            data: [{
	                value: 1,
	                itemStyle: {
	                    normal: {
	                        color: '#313443',
	                        shadowBlur: 50,
	                        shadowColor: '#1b1e25'
	                    }
	                }
	            }],
	        
	            animation: false
	        },

	        {
	            name: 'main',
	            type: 'pie',
	            radius: ['50%', '51%'],
	            label: {
	                normal: {
	                    show: false,
	                }
	            },
	            data: getData(),
	            
	            animationEasingUpdate: 'cubicInOut',
	            animationDurationUpdate: 500
	        }
	    ]
	};
	
	logonCnt.setOption(option);
}

function topicDesck(){
	var topicDesk = echarts.init(document.getElementById('topicDesk'));
	option = {
//	        backgroundColor: '#10398a',
	        tooltip : {
	            trigger: 'item',
	            formatter: "{a} <br/>{b} : {c} ({d}%)"
	        },
	        series : [
	            {
	                name:'访问来源',
	                type:'pie',
	                radius : ['30%', '75%'],
	                center: ['50%', '50%'],
	                data:[
	                    {
	                        value:335,
	                        name:'直接访问',
	                        itemStyle: {
	                            normal: {
	                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
	                                    offset: 0,
	                                    color: 'rgba(152,251,152,1)'
	                                }, {
	                                    offset: 1,
	                                    color: 'rgba(64,224,208,1)'
	                                }]),
	                                shadowBlur: 200,
	                                shadowColor: 'rgba(0, 0, 0, 0.5)'
	                            }
	                        }
	                    },
	                    {
	                        value:310,
	                        name:'邮件营销',
	                        itemStyle: {
	                            normal: {
	                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
	                                    offset: 0,
	                                    color: 'rgba(5,15,88,1)'
	                                }, {
	                                    offset: 1,
	                                    color: 'rgba(235,122,255,1)'
	                                }]),
	                                shadowBlur: 200,
	                                shadowColor: 'rgba(0, 0, 0, 0.5)'
	                            }
	                        }
	                    },
	                    {
	                        value:274,
	                        name:'联盟广告',
	                        itemStyle: {
	                            normal: {
	                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
	                                    offset: 0,
	                                    color: 'rgba(5,193,255,1)'
	                                }, {
	                                    offset: 1,
	                                    color: 'rgba(15,15,90,1)'
	                                }]),
	                                shadowBlur: 200,
	                                shadowColor: 'rgba(0, 0, 0, 0.5)'
	                            }
	                        }
	                    },
	                    {
	                        value:235,
	                        name:'视频广告',
	                        itemStyle: {
	                            normal: {
	                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
	                                    offset: 0,
	                                    color: 'rgba(255,34,34,1)'
	                                }, {
	                                    offset: 1,
	                                    color: 'rgba(80,123,45,1)'
	                                }]),
	                                shadowBlur: 200,
	                                shadowColor: 'rgba(0, 0, 0, 0.5)'
	                            }
	                        }
	                    },
	                    {
	                        value:400,
	                        name:'搜索引擎',
	                        itemStyle: {
	                            normal: {
	                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
	                                    offset: 0,
	                                    color: 'rgba(75,0,130,1)'
	                                }, {
	                                    offset: 1,
	                                    color: 'rgba(176,196,222,1)'
	                                }]),
	                                shadowBlur: 200,
	                                shadowColor: 'rgba(0, 0, 0, 0.5)'
	                            }
	                        }
	                    }
	                ].sort(function (a, b) { return a.value - b.value; }),
	                roseType: 'radius',
	                label: {
	                    normal: {
	                        textStyle: {
	                            color: 'rgba(255, 255, 255, 1)'
	                        }
	                    }
	                },
	                labelLine: {
	                    normal: {
	                        lineStyle: {
	                            color: 'rgba(255, 255, 255, 1)'
	                        },
	                        smooth: 0.2,
	                        length: 10,
	                        length2: 20
	                    }
	                },
	                animationType: 'scale',
	                animationEasing: 'elasticOut',
	                animationDelay: function (idx) {
	                    return Math.random() * 200;
	                }
	            },{
	                name: '内环',
	                type: 'pie',
	                silent: true,
	                clockWise: true,
	                hoverAnimation: false,
	                animationType: 'scale',
	                radius: ['22%', '25%'],
	                label: {
	                    normal: {
	                        position: 'center'
	                    }
	                },
	                data: [{
	                    value: 100,
	                    itemStyle: {
	                        normal: {
	                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
	                                offset: 0,
	                                color: 'rgba(152,251,152,1)'
	                            }, {
	                                offset: 1,
	                                color: 'rgba(64,224,208,1)'
	                            }])
	                        }
	                    }
	                }]
	            },{
	                name: '线1',
	                type: 'pie',
	                silent: true,
	                clockWise: true,
	                hoverAnimation: false,
	                animationType: 'scale',
	                radius: ['80%', '80.5%'],
	                label: {
	                    normal: {
	                        position: 'center'
	                    }
	                },
	                data: [{
	                    value: 100,
	                    itemStyle: {
	                        normal: {
	                            color: 'rgba(255,255,255,0.3)'
	                        }
	                    }
	                }]
	            },{
	                name: '线2',
	                type: 'pie',
	                silent: true,
	                clockWise: true,
	                hoverAnimation: false,
	                animationType: 'scale',
	                radius: ['70%', '70.3%'],
	                label: {
	                    normal: {
	                        position: 'center'
	                    }
	                },
	                data: [{
	                    value: 100,
	                    itemStyle: {
	                        normal: {
	                            color: 'rgba(255,255,255,0.15)',
	                            borderType:'dotted'
	                        }
	                    }
	                }]
	            }
	        ]
	    }
	topicDesk.setOption(option);
}

/**
 *  选题各部门被采用数量统计
 */
function topicRefcount(){
	/*中间显示的数据*/
	var topicRefcount = echarts.init(document.getElementById('topicRefcount'));
	option = {

		    legend: {
		        data: ['line', 'bar'],
		        bottom:0,
		    },
		    xAxis: {
		        data: ['出栏量', '存栏量', '蔬菜产量', '蔬菜种植面积'],

		    },
		    yAxis: {
		        splitLine: {
		            show: false
		        },

		        max: 150,
		    },
		    series: [{
		        name: 'bar',
		        type: 'bar',
		        barWidth: '40%',
		        itemStyle: {
		            normal: {
		                barBorderRadius: 5,
		                color: new echarts.graphic.LinearGradient(
		                    0, 0, 0, 1, [{
		                        offset: 0,
		                        color: '#14c8d4'
//		                        color:function(d){return "#"+Math.floor(Math.random()*(256*256*256-1)).toString(16); }
		                    }, {
		                        offset: 1,
//		                        color:function(d){return "#"+Math.floor(Math.random()*(256*256*256-1)).toString(16);}
		                        color: '#43eec6'
		                    }]
		                )
		            }
		        },
		        data: [45, 87, 118, 98]
		    }, {
		        name: 'line',
		        type: 'bar',
		        barGap: '-110%',
		        barWidth: '50%',

		        z: -12,
		        data: [100, 100, 118, 100, ]
		    }]
		};
	topicRefcount.setOption(option);
}
/**
 * 报道电视报道与数字报道统计分析
 */
function titlePlatform(){
	/*中间显示的数据*/
	var titlePlatform = echarts.init(document.getElementById('titlePlatform'));
	option = {
		    "series": [
		        {
		            "center": [
		                "25.0%",
		                "50%"
		            ],
		            "radius": [
		                "49%",
		                "50%"
		            ],
		            "clockWise": false,
		            "hoverAnimation": false,
		            "type": "pie",
		            "itemStyle": {
		                "normal": {
		                    "label": {
		                        "show": true,
		                        "textStyle": {
		                            "fontSize": 15,
		                            "fontWeight": "bold"
		                        },
		                        "position": "center"
		                    },
		                    "labelLine": {
		                        "show": false
		                    },
		                    "color": "#5886f0",
		                    "borderColor": "#5886f0",
		                    "borderWidth": 25
		                },
		                "emphasis": {
		                    "label": {
		                        "textStyle": {
		                            "fontSize": 15,
		                            "fontWeight": "bold"
		                        }
		                    },
		                    "color": "#5886f0",
		                    "borderColor": "#5886f0",
		                    "borderWidth": 25
		                }
		            },
		            "data": [
		                {
		                    "value": 52.7,
		                    "name": "男  覆盖率52.7%"
		                },
		                {
		                    "name": " ",
		                    "value": 47.3,
		                    "itemStyle": {
		                        "normal": {
		                            "label": {
		                                "show": false
		                            },
		                            "labelLine": {
		                                "show": false
		                            },
		                            "color": "#5886f0",
		                            "borderColor": "#5886f0",
		                            "borderWidth": 0
		                        },
		                        "emphasis": {
		                            "color": "#5886f0",
		                            "borderColor": "#5886f0",
		                            "borderWidth": 0
		                        }
		                    }
		                }
		            ]
		        },
		        {
		            "center": [
		                "75.0%",
		                "50%"
		            ],
		            "radius": [
		                "49%",
		                "50%"
		            ],
		            "clockWise": false,
		            "hoverAnimation": false,
		            "type": "pie",
		            "itemStyle": {
		                "normal": {
		                    "label": {
		                        "show": true,
		                        "textStyle": {
		                            "fontSize": 15,
		                            "fontWeight": "bold"
		                        },
		                        "position": "center"
		                    },
		                    "labelLine": {
		                        "show": false
		                    },
		                    "color": "#ee3a3a",
		                    "borderColor": "#ee3a3a",
		                    "borderWidth": 25
		                },
		                "emphasis": {
		                    "label": {
		                        "textStyle": {
		                            "fontSize": 15,
		                            "fontWeight": "bold"
		                        }
		                    },
		                    "color": "#ee3a3a",
		                    "borderColor": "#ee3a3a",
		                    "borderWidth": 25
		                }
		            },
		            "data": [
		                {
		                    "value": 47.3,
		                    "name": "女  覆盖率47.3%"
		                },
		                {
		                    "name": " ",
		                    "value": 52.7,
		                    "itemStyle": {
		                        "normal": {
		                            "label": {
		                                "show": false
		                            },
		                            "labelLine": {
		                                "show": false
		                            },
		                            "color": "#ee3a3a",
		                            "borderColor": "#ee3a3a",
		                            "borderWidth": 0
		                        },
		                        "emphasis": {
		                            "color": "#ee3a3a",
		                            "borderColor": "#ee3a3a",
		                            "borderWidth": 0
		                        }
		                    }
		                }
		            ]
		        }
		    ]
		};
	titlePlatform.setOption(option);
}

/**
 * 看看部门与引用统计
 */
function titleOrgcount(){
	/*中间显示的数据*/
	var titleOrgcount = echarts.init(document.getElementById('titleOrgcount'));
	/*myChart.on('click', function (params) {
	    console.log(params);
	});*/
	// 指定图表的配置项和数据
	var colors = ['#5793f3', '#ff9933'];
	var option = {
	    color: colors,
	    tooltip: {
	        trigger: 'axis',
	        axisPointer: {
	            type: 'cross'
	        }
	    },
	    grid: {
	        right: '10%'
	    },
	    toolbox: {
	        orient: 'vertical',
	        itemGap: 20,
	        right: 1,
	        feature: {
	            dataView: {
	                show: true,
	                readOnly: true,
	                title: '数据'
	            },
	            magicType: {
	                type: ['line', 'bar'],
	                title: {
	                    line: '线形',
	                    bar: '柱形'
	                }
	            },
	            restore: {
	                show: true
	            },
	            saveAsImage: {
	                show: true,
	                title: '下载'
	            }
	        }
	    },
	    dataZoom: [{
	        type: 'slider',
	        show: true,
	        xAxisIndex: [0],
	        start: 0,
	        end: 100
	    }, {
	        type: 'inside',
	        xAxisIndex: [0],
	        start: 0,
	        end: 100
	    }],
	    legend: {
	        data: ['失圆率', '磨耗率']
	    },
	    xAxis: [{
	        name: '列车制造商',
	        type: 'category',
	        axisTick: {
	            alignWithLabel: true
	        },
	        axisPointer: {
	            label: {
	                backgroundColor: '#333333'
	            }
	        },
	        nameLocation: 'start',
	        nameGap: 40,
	        nameRotate: 50,
	        data: ['奔驰', '大众', '宝马', '马自达', '别克', '丰田', '本田', '尼桑', '斯柯达', '长安', '法拉利', '保时捷']
	    }],
	    yAxis: [{
	        type: 'value',
	        name: '失圆率',
	        min: 0,
	        max: 25,
	        position: 'right',
	        //interval : 5,//强制分割段数
	        axisLine: {
	            lineStyle: {
	                color: colors[0]
	            }
	        },
	        axisLabel: {
	            formatter: '{value} %'
	        }
	    }, {
	        type: 'value',
	        name: '磨耗率',
	        min: 0, //y轴刻度最小限制
	        max: 25, //y轴刻度最大限制
	        position: 'left', //y轴显示在哪边
	        //interval : 5,//强制分割段数
	        axisLine: {
	            lineStyle: {
	                color: colors[1] //线或者柱状图的颜色
	            }
	        },
	        axisLabel: {
	            formatter: '{value} %' //设置刻度数值后的单位
	        }
	    }],
	    series: [{
	        name: '失圆率',
	        type: 'bar',
	        data: [2.0, 4.9, 7.0, 23.2, 21.6, 20.7, 14.6, 12.2, 2.6, 15.2, 6.4, 3.3]
	    }, {
	        name: '磨耗率',
	        type: 'line',
	        yAxisIndex: 1,
	        smooth: true, //曲线
	        data: [2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2],
	        markLine: { //线
	            silent: false,
	            label: {
	                normal: {
	                    position: 'start',
	                    formatter: '{b}: {c} %'
	                }
	            },
	            lineStyle: {
	                normal: {
	                    color: '#cc0033',
	                    type: 'dashed',
	                    width: 1
	                }
	            },
	            data: [{
	                    name: '均值',
	                    type: 'average'
	                }, {
	                    name: '极大',
	                    yAxis: 23.4
	                }, {
	                    name: '极小',
	                    yAxis: 2
	                },
	                [{
	                    name: '轮位',
	                    x: '10%',
	                    y: '90%',
	                    symbol: 'circle',
	                    symbolSize: 1,
	                    label: {
	                        normal: {
	                            position: 'end',
	                            formatter: '\n\n轮位'
	                        }
	                    },
	                    lineStyle: {
	                        normal: {
	                            color: '#0CF49B',
	                            type: 'solid',
	                            width: 2
	                        }
	                    }
	                }, {
	                    name: '',
	                    x: '95%',
	                    y: '5%',
	                    symbol: 'circle',
	                    symbolSize: 1
	                }]
	            ]
	        },
	        markPoint: {//点
	            symbol: 'circle',
	            symbolSize: 10,
	            itemStyle: {
	                normal: {
	                    color: '#0CF49B'
	                }
	            },
	            data: [
	                {
	                    x: '20%',
	                    y: '80%',
	                    value: '1号',
	                    label: {
	                        normal: {
	                            formatter: '1号',
	                            position: 'right',
	                            textStyle: {
	                                color: '#0CF49B'
	                            }
	                        }
	                    }
	                },
	                {
	                    x: '40%',
	                    y: '60%',
	                    value: '2号',
	                    label: {
	                        normal: {
	                            formatter: '2号',
	                            position: 'right',
	                            textStyle: {
	                                color: '#0CF49B'
	                            }
	                        }
	                    }
	                },
	                {
	                    x: '60%',
	                    y: '40%',
	                    value: '3号',
	                    label: {
	                        normal: {
	                            formatter: '3号',
	                            position: 'right',
	                            textStyle: {
	                                color: '#0CF49B'
	                            }
	                        }
	                    }
	                },
	                {
	                    x: '80%',
	                    y: '20%',
	                    value: '4号',
	                    label: {
	                        normal: {
	                            formatter: '4号',
	                            position: 'right',
	                            textStyle: {
	                                color: '#0CF49B'
	                            }
	                        }
	                    }
	                }
	            ]
	        }
	    }]
	};
	titleOrgcount.setOption(option);
}


$("#cluediv").click(function(e){
	e.preventDefault();
	$('#clueModal').modal('show');
});

