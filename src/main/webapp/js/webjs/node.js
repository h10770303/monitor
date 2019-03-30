$(function(){
	
	
	// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
	   var assetResult;        

$.ajax({
	type:"get",
	url:"getClueFlow.do",
	dataType: 'json',
	async:true,
	success:function(data1){
		//测试数据
//		var jsonStr={"clue":40,"topic":30,"title":20};

		var data = [{
		    name: '线索',
		    code: 'node1',
		    value: {
		        alarmNum: data1.result.clue
		    },
		    x: 0.1,
		    y: 0.69
		}, {
		    name: '选题',
		    code: 'node3',
		    value: {
		        alarmNum: data1.result.topic
		    },
		    x: 0.5,
		    y: 0.5
		}, {
		    name: '报道',
		    code: 'node4',
		    value: {
		        alarmNum: data1.result.title
		    },
		    x: 0.9, // 内容框坐标位置
		    y: 0.3  // 内容看坐标位置
		}];

		var links = [{
		    source: 'node1',
		    target: 'node3',
		}, {
		    source: 'node3',
		    target: 'node4',
		}];

		var line = 1; //行：把画布上画几行信息框 越小越大
		var column = 2; //列：把画布上画几列信息框

		function getScatterData() {
		    var scatterData = [];

		    //画布宽高
		    var c_w = myChart.getWidth();
		    var c_h = myChart.getHeight();
		    //计算信息框的宽高
		    var w = c_w / (column * 2);
		    var h = c_h / (line * 2);
		    for (var i = 0; i < data.length; i++) {
		        //把消息框分为两部分：标题和内容,内容高度为标题高度的3倍，echart是以中心画图，所以要分别计算标题和内容框的中心点位置
		        scatterData.push({
		            name: data[i].name,
		            value: [data[i].x, (data[i].y * c_h + (3 / 8 * h)) / c_h],
		            type: 'title',
		            w: w,
		            h: h / 4,
		            label: {
		                normal: {
		                    textStyle: {
		                        color: '#fff',
		                        fontWeight: 'bold',
		                        fontSize: 30 // 框内标题大小
		                    }
		                }
		            }
		        }, {
		            code: data[i].code,
		            value: [data[i].x, (data[i].y * c_h + (1 / 4 * h) - (3 / 4 * h) / 2) / c_h],
		            type: 'body',
		            w: w,
		            h: 3 / 4 * h,
		            info: data[i].value,
		            label: {
		                normal: {
		                    textStyle: {
		                        color: '#ff0',
		                        fontWeight: 'bold',
		                        fontSize: 20 // 框内内容大小
		                    }
		                }
		            }
		        });
		    }
		    return scatterData;
		}

		function getLinesData() {
		    var linesData = [];
		    var map = {};
		    for (var i = 0; i < data.length; i++) {
		        map[data[i].code] = data[i];
		    }

		    for (var i = 0; i < links.length; i++) {
		        var source = map[links[i].source];
		        var target = map[links[i].target];

		        //画布宽高
		        var c_w = myChart.getWidth();
		        var c_h = myChart.getHeight();
		        //计算信息框的宽高
		        var w = c_w / (column * 2);
		        var h = c_h / (line * 2);
		        //计算信息框的四个边中点的位置
		        source.top = {
		            x: source.x,
		            y: (source.y * c_h + (1 / 2 * h)) / c_h
		        };
		        source.right = {
		            x: (source.x * c_w + (1 / 2 * w)) / c_w,
		            y: source.y
		        };
		        source.bottom = {
		            x: source.x,
		            y: (source.y * c_h - (1 / 2 * h)) / c_h
		        };
		        source.left = {
		            x: (source.x * c_w - (1 / 2 * w)) / c_w,
		            y: source.y
		        };

		        target.top = {
		            x: target.x,
		            y: (target.y * c_h + (1 / 2 * h)) / c_h
		        };
		        target.right = {
		            x: (target.x * c_w + (1 / 2 * w)) / c_w,
		            y: target.y
		        };
		        target.bottom = {
		            x: target.x,
		            y: (target.y * c_h - (1 / 2 * h)) / c_h
		        };
		        target.left = {
		            x: (target.x * c_w - (1 / 2 * w)) / c_w,
		            y: target.y
		        };

		        //s->t：s左：t右
		        if (source.right.x < target.left.x) {
		            linesData.push(getLine([
		                [source.right.x, source.right.y],
		                [target.left.x, target.left.y]
		            ]));
		        }
		        //t<-s：s右：t左
		        else if (source.left.x > target.right.x) {
		            linesData.push(getLine([
		                [source.left.x, source.left.y],
		                [target.right.x, target.right.y]
		            ]));
		        }
		        //s
		        //|
		        //t
		        else if (source.bottom.y > target.top.y) {
		            linesData.push(getLine([
		                [source.bottom.x, source.bottom.y],
		                [target.top.x, target.top.y]
		            ]));
		        }
		        //t
		        //|
		        //s
		        else if (source.top.y < target.bottom.y) {
		            linesData.push(getLine([
		                [source.top.x, source.top.y],
		                [target.bottom.x, target.bottom.y]
		            ]));
		        }
		    }
		    return linesData;
		}

		function getLine(coords) {
		    return {
		        name: '',
		        type: 'lines',
		        coordinateSystem: 'cartesian2d',
		        symbol: ['none', 'arrow'],
		        symbolSize: 20, // 箭头
		        zlevel: 6,
		        effect: {
		            show: true,
		            period: 6,
		            trailLength: 0.7,
		            color: '#7480BC',
		            symbolSize: 30 // 动态流
		        },
		        lineStyle: {
		            normal: {
		                color: '#9EADD6',
		                width: 10, // 线宽
		                curveness: 0
		            }
		        },
		        data: [{
		            coords: coords
		        }]
		    };
		}

		function getSeries() {
		    var series = [];
		    series.push({
		        type: 'scatter',
		        symbol: 'rect',
		        zlevel: 2,
		        silent: true,
		        symbolSize: function(value, params) {
		            return [params.data.w, params.data.h];
		        },
		        itemStyle: {
		            normal: {
		                shadowBlur: 10,
		                shadowColor: 'rgba(120, 36, 50, 0.5)',
		                shadowOffsetY: 5,
		                color: function(params) {
		                    if (params.data.type == 'title') {
		                        return '#007CB8';
		                    } else {
		                        return '#6DC6F2';
		                    }
		                }
		            }
		        },
		        label: {
		            normal: {
		                show: true,
		                position: 'inside',
		                formatter: function(params) {
		                    if (params.data.type == 'title') {
		                        return params.data.name;
		                    } else {
		                        return '数量：' + params.data.info.alarmNum ;
		                    }

		                },
		                textStyle: {
		                    color: '#000'
		                }
		            }
		        },
		        data: getScatterData(),
		    });
		    return series.concat(getLinesData());
		}
		option = null;
		option = {
		      backgroundColor: '#F3F3F3',
		    title: [{
		        text: "      xnews业务数据流图 ",
		        x: '15%',
		        y: 0,
		        textStyle: {
		            color: '#000',
		            fontStyle: 'normal',
		            fontWeight: 'normal',
		            fontFamily: 'sans-serif',
		            fontSize: 44,
		        }
		    }],
		    tooltip: {

		        /*trigger: 'axis',
		        axisPointer: {
		            show: true,
		            type: 'cross'
		        }*/
		    },
		    grid: {
		        left: 0,
		        right: 0,
		        top: 0,
		        bottom: 0
		    },
		    xAxis: {
		        type: 'value',
		        splitLine: {
		            show: false,
		        },
		        axisLabel: {
		            show: false
		        },
		        max: 1,
		        min: 0
		    },
		    yAxis: {
		        type: 'value',
		        splitLine: {
		            show: false,
		        },
		        axisLabel: {
		            show: false
		        },
		        max: 1,
		        min: 0
		    },
		    series: getSeries()
		};
		        // 使用刚指定的配置项和数据显示图表。
		        myChart.setOption(option);
	},
	error: function(data1){
		alert("error"+data1);
	}
});

    
	
})
        