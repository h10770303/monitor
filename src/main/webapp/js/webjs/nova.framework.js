/**
 * 框架公用js，其中的网页布局class名称、id号均必须一致，否则无法使用。
 * 如果需要个性化的操作，建议不要使用这个js文件
 * @author Yoson
 * @since 1.0 2014-11-22
 */

(function NovaNav($) {
	jQuery.fn.novaNav = function(opts){
		var options = $.extend(true, {menu: [], notice: []}, opts);
		var $this = $(this);
		var novaHtml = '<nav class="navbar navbar-inverse" role="navigation"><div class="container-fluid"><div class="collapse navbar-collapse"></div></div></nav>';
		var pane = $(novaHtml).appendTo($this);
		
		/** @memberOf NovaNav */
		var renderLogo = function(){
			var logoHtml = '<div class="navbar-header"><a class="navbar-brand" href="/web/index.html"><img alt="LOGO" src="/web/api/config/sys/logo" height="26"></a></div>';
			$(logoHtml).insertBefore('.container-fluid>.collapse');
		};
		
		/** @memberOf NovaNav */
		var renderNovaMain = function(rows){
			var ulHtml = '<ul class="nav navbar-nav"></ul>';
			var ul = $(ulHtml).appendTo(pane.find('.container-fluid>.collapse'));
			//{name: '工作台', url:'javascript:;',icon: 'glyphicon glyphicon-tasks',isactive: false}
			$(rows).each(function(index, row){
				var rowHtml = '<li class="nav-item"><a href="' + row.url + '"><i class="' + row.icon + '"></i><span>' + row.name + '</span></a></li>';
				if(row.target){
					rowHtml = '<li class="nav-item"><a href="' + row.url + '" target="_blank"><i class="' + row.icon + '"></i><span>' + row.name + '</span></a></li>';
				}
				var li = $(rowHtml).appendTo(ul);
				if(row.isactive){
					li.addClass('active');
				}
			});
		};
		
		/** @memberOf NovaNav */
		var renderNovaRight = function(rows){
			var ulHtml = '<ul class="nav navbar-nav navbar-right"></ul>';
			var ul = $(ulHtml).appendTo(pane.find('.container-fluid>.collapse'));
			
			$(rows).each(function(index, row){
				var rowHtml = '';
				if(row.subtitles && row.subtitles.length > 0){
					var li = $('<li class="dropdown">').appendTo(ul);
					$('<a href="#" "class="dropdown-toggle" data-toggle="dropdown"><i class="' + row.icon + '"></i> <span>' + row.title + '</span> <span class="caret"></span></a>').appendTo(li);
					var subul = $('<ul class="dropdown-menu" role="menu">').appendTo(li);
					$(row.subtitles).each(function(index, subrow){
						if(subrow.divider){
							$('<li class="divider"></li>').appendTo(subul);
						} else {
							var url = subrow.url;
							if(!url){
								url = 'javascript:;';
							}
							var st = $('<li><a href="' + url + '"><i class="' + subrow.icon + '"></i><span>' + subrow.title + '</span></a></li>').appendTo(subul);
							st.find('a').click(function(){
								if('function' === typeof subrow.event){
									subrow.event();
								}
							});
						}
					});
				} else {
					var li = $('<li><a href="' +row.url+ '"><i class="' + row.icon + '"></i></a></li>').appendTo(ul);
					li.find('a').click(function(){
						if('function' === typeof row.event){
							row.event();
						}
					});
				}
				$(rowHtml).appendTo(ul);
			});
		};
		
		renderLogo();
		renderNovaMain(options.menu);
		renderNovaRight(options.notice);
	};
})(jQuery);

$(function(){
	$('.bottom_tool a').tooltip({
		trigger: 'hover'
	});
	
	var collapse = function(){
		$('#menu_close').tooltip('hide');
		$('.menu').addClass('only-icon');
		$('.only-icon a').tooltip({trigger: 'hover', placement: 'right', container:'body'});
		$('#menu_close').parent().prev().hide();
		$("#nv_left").animate({width: '80px'});
		$("#nv_content").animate({left: '80px'});
		$('#menu_close').find('i').addClass('glyphicon-step-forward').removeClass('glyphicon-step-backward');
		localStorage.setItem('nova_collapse', true);
	};
	var open = function(){
		var help = $('#menu_close').parent().prev();
		$("#nv_left").animate({width: '180px'}, function(){
			help.show();
			$('.menu').removeClass('only-icon');
			$('.menu a').tooltip('destroy');
		});
		$("#nv_content").animate({left: '180px'});
		$('#menu_close').find('i').addClass('glyphicon-step-backward').removeClass('glyphicon-step-forward');
		localStorage.setItem('nova_collapse', false);
	};
	var isCollapse = localStorage.getItem('nova_collapse');
	if(isCollapse == 'true'){
		$('#menu_close').tooltip('hide');
		$('#menu_close').parent().prev().hide();
		$("#nv_left").width(80);
		$("#nv_content").css('left', 80); 
		$('#menu_close').find('i').addClass('glyphicon-step-forward').removeClass('glyphicon-step-backward');
		localStorage.setItem('nova_collapse', true);
	}
	
	$('#menu_close').click(function(){
		if($(this).find('i').hasClass('glyphicon-step-backward')){
			collapse();
		} else {
			open();
		}
	});
	
	$('.message-genius .collaspe').click(function(){
		var genius = $(this).parent();
		if(genius.hasClass('message-genius-collaspe')){
			genius.removeClass('message-genius-collaspe');
		} else {
			genius.addClass('message-genius-collaspe');
		}
	});
	$('.message-genius .detail').click(function(){
		var genius = $(this).parent();
		genius.addClass('message-genius-collaspe');
	});
	
	//TODO yoson 暂时关闭web socket
	
	/*var session = SessionHelper.getCurrentSession();
	var url = "ws://" + window.location.host + "/web/websockets/im/" + session.sessionID;

	
	var __socket = new WebSocket(url);
	__socket.onopen = function(event) {
		
	};

	__socket.onmessage = function (event) {
		try{
			var data = JSON.parse(event.data);
			if(data.talkMessage && data.talkMessage.sender == session.userID){
				
			} else if(data.talkMessage){
				var msg = data.talkMessage.sender + ' : '+ data.talkMessage.body.plainText;
				$('.message-genius').removeClass('message-genius-collaspe');
				$('.message-genius .detail').html(msg);
				$('#chatAudio')[0].play();
			}
		} catch(e){
			console.log(e);
		}
	};
	$('<audio id="chatAudio"><source src="../../base/images/notify.ogg" type="audio/ogg"><source src="../../base/images/notify.mp3" type="audio/mpeg"><source src="../../base/images/notify.wav" type="audio/wav"> </audio>').appendTo('body');
		    
	__socket.onclose = function (event) {
		__socket = null;
	};*/
	
	// 一个调用触发链式回调
	// getCurrentSession();

	// 获取当前登录的SessionID
	function getCurrentSession() {
		Proxy.getCurrentSession(function onsuccess(session){
			if(session.sessionID === 'unauthenticate'){
				$('body').html('<p>软件可能已过期或未授权，请联系管理员。</p><div class="alert alert-warning auth">认证码：【' + session.userName +"】</div>");
			} else {
				SessionHelper.setSession(session);
				var ret = getCurrentUserPermissions(session);
				if(ret === 'json-error'){
					return;
				}
				getCurrentOrgs(session);
				getBaseAttribute(session);
				connectBySocket(session);
			}
		}, function onerror(jqXHR, textStatus, errorThrown){
			if(jqXHR.status === 403) {
				if(jqXHR.getResponseHeader('Location')) {
					$('.status-bar>.text').html('你尚未登录，正在为你转入登录页...');
					top.location.href = jqXHR.getResponseHeader('Location');
				} else {
					top.location.href = '/web/login.html';
				}
			} else {
				$('.status-bar>.text').html('获取当前登录会话失败，' + jqXHR.responseText);
			}
		});
	}
	// 获取当前登录用户的权限
	function getCurrentUserPermissions(session) {
		
		// TODO sunwei 获取当前用户的权限
		Proxy.getCurrentPermission(function(response){
			if(response.code !== Proxy.SUCCESS){
				Message.danger("错误：无法确认用户的权限");
			} else {
				SessionHelper.setPermissions(session, response.result.roleList, response.result.otherAttributes);
				getEnums(session);
				
			}
		});
	}
	
	function getCurrentOrgs(session){
		Proxy.orgsByUser({userID: session.userID}, function(response){
			if(response.code !== Proxy.SUCCESS){
				Message.danger('无法确认用户所在部门');
			} else {
				SessionHelper.setOrgs(session, response.result);
			}
		});
	}
	
	function getBaseAttribute(session){
		Proxy.queryBaseAttributes({},function(response){
			if(response.code !== Proxy.SUCCESS){
				Message.danger('获取基础配置属性失败!');
			} else {
				//配置页面不读取配置进行验证，防止json格式不对造成的死循环而无法进入配置页面
				if('/web/sites/syscfg/index.html' !== window.location.pathname){
					SessionHelper.setBaseAttributes(session, response.result);
				}
			}
		});
	}
	
	/**
	 * 初始化系统枚举类型
	 */
	function getEnums(session) {
		Proxy.getEnums(function(data){
			if(data.code !== Proxy.SUCCESS){
				Message.danger("初始化系统枚举类型参数失败");
			} else{
				SessionHelper.setEnums(data.result);
				loadNovaNav(session);
			}
		});
	}
	/**
	 * 页面websocket长连接，用于APP消息推送给客户端
	 */
	function connectBySocket(session){
		var $appPushDiv = null;
		var host = window.location.host;
//		var path = '/web/api/registerSocketSession'
		var path = '/web/websockets/im/' + session.sessionID;
		var socket = new WebSocket('ws://' + host + path);
		var times = 0;
		var timeFlag = null;
		function blink(){
			var selector = $appPushDiv.show().find('.top-icon');
			var color = selector.css('color');
			if('rgb(255, 255, 255)'==color){
				selector.css('color', 'rgb(204, 204, 255)');
			}else{
				selector.css('color', 'rgb(255, 255, 255)');
			}
			if(times < 10){
				timeFlag = setTimeout(function(){
					times++;
					blink();
				}, 300);
			} else {
				$appPushDiv.find('.tip-text').html('<i class="fa fa-circle new-circle"></i>新消息');
				times = 0;
			}
		}
		socket.onopen = function(event) { 
			socket.send('{"fault": null, "talkMessage": {"messageID":"123","receiverList":[{"receiverId":"super", "receiverType":"USER"}],"sender": "super", "talkMessageType": "P_2_P_MESSAGE"}}');
			/*setInterval(function(){
				socket.send('{"fault": null}');
			}, 30000);*/
//			Proxy.noop(function(/*resp*/){
//				setTimeout(noop, 300000);//5 * 60 * 1000
//			});
//			function noop(){
//				Proxy.noop(function(/*resp*/){
//					setTimeout(noop, 300000);//5 * 60 * 1000
//				});
//			}
			$appPushDiv = $('.app-push-div');
			if($appPushDiv.length == 0){
				var html = '<div class="app-push-div panel panel-info">\
								<div class="left-btn-ctl">\
									<div class="top-icon"><i class="fa fa-envelope-o"></i></div>\
					                <div class="tip-text">暂无消息</div>\
								</div>\
							    <div class="panel-heading">APP消息推送\
								</div>\
							    <div class="panel-body"><div class="app-push-content"></div></div>\
							</div>';
				$appPushDiv = $(html).appendTo($('body')).hide();
			}
			$appPushDiv.find('.left-btn-ctl').click(function(){
				if($appPushDiv.hasClass('come')){
					$appPushDiv.find('.top-icon').css('color', 'rgb(255, 255, 255)');
					clearTimeout(timeFlag);
					$appPushDiv.hide().find('.tip-text').text('暂无消息');
					times = 0;
				}
				$appPushDiv.toggleClass('come');
			});
//			function websocket(){
//				var ex = null;
//				try{//websocket关闭后重新开启
//					socket.send('{"fault": null, "talkMessage": {"messageID":"123","receiverList":[{"receiverId":"super", "receiverType":"USER"}],"sender": "super", "talkMessageType": "P_2_P_MESSAGE"}}');
//				}catch(e){
//					ex = e;
//				}
//				if(ex == null){
//					setTimeout(websocket, 300000);
//				}else{
//					connectBySocket(session);
//				}
//			}
//			websocket();
		};
		socket.onmessage = function(event) { 
			var data = JSON.parse(event.data);
			var tMsg = data.talkMessage;
			if(tMsg && tMsg.talkMessageType != 'P_2_P_MESSAGE'){
				$appPushDiv.find('.tip-text').text('新消息');
				$appPushDiv.find('.panel-heading').text(tMsg.body.systemNotify.title)
				   .attr('title', tMsg.body.systemNotify.title);
				$appPushDiv.find('.app-push-content').text(tMsg.body.systemNotify.content);
				if(!$appPushDiv.hasClass('come')){
					blink();
				}
			}
		}; 
		socket.onclose = function(event) { 
		    console.log('Client notified socket has closed',event); 
		}; 
	}

	function loadNovaNav(session){
		if(session == null) {
			Proxy.showLogin();
			return;
		}
		var menu = [{name: '工作台'		, url:'../mhome/index.html',icon: 'fa fa-dashboard'},
		            {name: '内容库'		, url:'../library/index.html',icon: 'glyphicon glyphicon-globe'},
		            {name: '数据中心'	, url:'../datacenter/index.html',icon: 'fa fa-bar-chart'},
		            {name: '资源管理'	, url: '../resource/index.html', icon: 'fa fa-automobile'},
		            //{name: '资讯汇聚'	, url: '../../api/onair/sites/collector' ,icon: 'glyphicon glyphicon-fire', target: '_blank'},
		            {name: '资讯汇聚'	, url: '../information/index.html' ,icon: 'glyphicon glyphicon-fire'},
		            //{name: '发布'		, url: '../../api/onair/sites/dispatcher' ,icon: 'glyphicon glyphicon-cloud', target: '_blank'},
		            {name: '考评统计'	, url: '../evaluation/index.html' ,icon: 'glyphicon glyphicon-thumbs-up'},
		            {name: '通联'		, url: '../relatedcom/index.html' ,icon: ' glyphicon glyphicon-road'},
		            {name: 'Web报片'		, url: '../reportclue/index.html', icon: 'fa fa-send-o'},
		            {name: '大屏维护'	, url: '../screencontrol/index.html', icon: 'fa fa-th-large'},
		            {name: '系统维护'	, url: '../manager/index.html', icon: 'glyphicon glyphicon-cog'},
		            {name: '系统配置'	, url: '../syscfg/index.html', icon: 'glyphicon glyphicon-wrench'}
		           ];
		var myMenu = [];
		for(var i = 0; i < menu.length; i++){
			if(SessionHelper.canDO(menu[i].name)){
				myMenu.push(menu[i]);
			}
		}
		var location = window.location.href;
		
		$(myMenu).each(function(index, m){
			if(location.indexOf(m.url.substring(2, m.url.length)) > 0){
				m.isactive = true;
				m.url = 'javascript:;';
			} else {
				m.isactive = false;
			}
		});
		
		var craeteSub = null;
		craeteSub = [{
			title: '线索(快速)', icon: 'glyphicon glyphicon-flash', event: function(){
				top.GlobalDetail.ask(function(){
					ClueCreate.quickCreate();
				});
			}
		}, {
			divider: true
		}, {
			title: '线索', icon: 'fa fa-send', event: function(){
				var session = SessionHelper.getCurrentSession();
				
				top.GlobalDetail.ask(function(){
					var pane = $('.detail-div').empty().addClass('active detail-globe');
					var header = '<div class="detail-title">\
							<h4><i class="glyphicon glyphicon-list-alt"></i><span class="title-name"></span></h4>\
							<div class="toolbar"></div>\
							<a href="javascript:;" class="close">×</a>\
						</div>\
						<div class="detail-body"></div>';
					$(header).appendTo(pane);
					ClueCreate.create();
//						ClueCreate.closeQuickCreate();
				});
				
			}
		}, {
			title: '选题', icon: 'glyphicon glyphicon-inbox', event: function(){
				var session = SessionHelper.getCurrentSession();
				var result = session.attrCreatedTos;
				if(!result){
					result = new Array();
				}
				if(result.length==0){
					Message.warn(Message.TEXT.NO_CREATEDTO);
				}else{
					top.GlobalDetail.ask(function(){
						Topic.create(null, 'detail-globe');
//					ClueCreate.closeQuickCreate();
					});
				}
			}
		}, {
			title: '报道', icon: 'glyphicon glyphicon-th-list', event: function(){
				top.GlobalDetail.ask(function(){
					TitleCreate.create();
//					ClueCreate.closeQuickCreate();
				});
			}
		/*}, {
			title: '新建串编单', icon: 'glyphicon glyphicon-list-alt', event: function(){
				RundownCreate.create(true);
				ClueCreate.closeQuickCreate();
			}*/
		}, {
			title: '任务', icon: 'fa fa-microphone', event: function(){
				top.GlobalDetail.ask(function(){
					Interviewtask.createInterviewtask(null, 'detail-globe', null, {interviewType:0});
//					ClueCreate.closeQuickCreate();
				});
			}
		}, {
			title: '报片', icon: 'fa fa-send-o', event: function(){
				top.GlobalDetail.ask(function(){
					ReportClue.quickCreate(null, 'detail-globe',true);
				});
			}
		}];
		if(location.indexOf('reportclue/index.html') > 0){//Web报片中仅能够新建采访任务和报片
			craeteSub = [{
				title: '任务', icon: 'fa fa-microphone', event: function(){
					top.GlobalDetail.ask(function(){
						Interviewtask.createInterviewtask(null, 'detail-globe', null, {interviewType:0});
//						ClueCreate.closeQuickCreate();
					});
				}
			}, {
				title: '报片', icon: 'fa fa-send-o', event: function(){
					top.GlobalDetail.ask(function(){
						ReportClue.quickCreate(null,null,true);
					});
				}
			},];
		}
		if(location.indexOf('resource/index.html') > 0){//资源调度页面仅能够新建直接到资源分配然后结束的采访任务
			craeteSub = [{
				title: '任务', icon: 'fa fa-microphone', event: function(){
					top.GlobalDetail.ask(function(){
						Interviewtask.createInterviewtask(null, 'detail-globe', null, {interviewType:4});
//						ClueCreate.closeQuickCreate();
					});
				}
			}];
		}
		var myCreate = [];
		$(craeteSub).each(function(index, item){
			if(SessionHelper.canDO('菜单/新建' + item.title)){
				myCreate.push(item);
			}
		});
		var notice = [];
		if(myCreate.length > 0 && 
				(location.indexOf('mhome/index.html') > 0 || location.indexOf('library/index.html') > 0 || location.indexOf('reportclue/index.html') > 0 || location.indexOf('resource/index.html') > 0)){
			notice.push({title: '新建', icon: 'glyphicon glyphicon-plus', subtitles: myCreate});
		}
		//notice.push({title: '', icon: 'glyphicon glyphicon-bell', url: 'javascript:;'});
		var userInfo = {
				title: '', icon: 'glyphicon glyphicon-user', subtitles: [{
					title: session.userName, icon: 'glyphicon glyphicon-user user-name-icon', url: 'javascript:;', event: function(){
						top.GlobalDetail.ask(function(){
							EditUser.openEditDialog( session.userID , $('.user-name-icon').next());//最后一个变量是 相对路径里面 插件swf的路径
						});
					}
				}, {
					title: '修改密码', icon: 'fa fa-key', url: 'javascript:;', event: function(){
						//TODO 修改密码
						top.GlobalDetail.ask(function(){
							EditUser.showChangePwd(session);
						});
						
					}
				}, {
					title: '注销', icon: 'glyphicon glyphicon-off', url: 'javascript:;', event: function(){
						Proxy.logout(function(resp){}, function(message) {
							Message.danger('注销失败,' + resp.message);
						});
					}
				}]
			};
		notice.push(userInfo);
		var logoff = {
				title: '', icon: 'glyphicon glyphicon-off', url: 'javascript:;', event: function(){
					Proxy.logout(function(resp){}, function(message) {
						Message.danger('注销失败,' + resp.message);
					});
				}
			};
		notice.push(logoff);
		
		$('#nv_header').novaNav({menu: myMenu, notice: notice});
		
		if('function' === typeof loadLeftNav){
			loadLeftNav(session);
			var isCollapse = localStorage.getItem('nova_collapse');
			if(isCollapse == 'true'){
				$('.menu').addClass('only-icon');
				$('.only-icon a').tooltip({trigger: 'hover', placement: 'right', container:'body'});
			}
		}
		
		// 这是一个彩蛋，用于对象重建索引
		+function(){
			var ttt = 0;
			$('#nv_header').click(function(){
				ttt += 1;
				if(ttt >= 6) {
					ttt = 0;
					var moid = window.prompt("请输入要重建索引的moid", '');
					if(moid) {
						Proxy.index(moid, function(resp){
							if(resp.code !== Proxy.SUCCESS) {
								Message.danger('重建索引失败：' + resp.message);
							} else {
								Message.success('重建索引成功');
							}
						});
					}
				}
			});
			setInterval(function(){
				ttt = 0;
			}, 1000);
		}();
	}
});

+function() {
	// 无论在哪里调用都要使用top.GlobalDetail 而不要用window.GlobalDetail
	var __detail = null;
//	__detail = $('.detail-div').data('dirty', true|false)
	
	window.GlobalDetail = {
		ask : function(callback, quiet) {
			if(__detail && __detail.data('dirty')) {
				if(!quiet) {
					Message.warn('请先关闭上一个编辑页');
				}
				return false;
			} else if(__detail){
				__detail.find('.close').click();
				callback && ('function' === typeof callback) && callback();
				return true;
			} else {
				callback && ('function' === typeof callback) && callback();
				return true;
			}
		},
		get: function() {
			return __detail;
		},
		reg : function(detail) {
			__detail = detail;
		},
		unreg: function() {
			if(__detail) {
				__detail.empty();
			}
			__detail = null;
		}
	}
}();
