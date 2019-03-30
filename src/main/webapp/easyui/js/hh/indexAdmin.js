/**
 * Created by Administrator on 2017/11/8.
 */
$("#mainBox").layout({
        fit:true,
        border:false
})
$("#mean").menu('show',{
        left: 200,
        top: 100
})
$("#left01").accordion({
        border:false

})
$("#con").tabs({
        fit:true,
        border:false
})


$(".topText a").click(function () {
        $(this).addClass('textActive').siblings().removeClass('textActive');

})
$("#left01  a").click(function () {
        var testVal=$(this).text();
        var thisUrl=$(this).attr('href');
        var con = '<iframe scrolling="no" frameborder="0"  src="'+thisUrl+'" style="width:100%;height:100%;">';
        $('#con').tabs('add',{
                title: testVal,
                selected: true,
                closable:true,
               content:con


        });

})
$("#con").tabs({
        onSelect:function (tit,ind) {
                if(ind==0){
                        $("#ifDiv").attr('src',"applyLeader.do");
                }

        }
})

$("a").click(function(){
//	$("#tabName").panel('setTitle',$(this).find("p").eq(1).html());
	var tab = $('#con').tabs('getTab',0);
	 $('#con').tabs('update',{
		 tab:tab,
		 options:{title:$(this).find("p").eq(1).html()}
	 });
})
