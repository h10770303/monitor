$(function() { 
	 
	analysisFile();
	
	$("#search_btn").click(function(){
		delTbody('table1')
		analysisFile();
	});

}) 

/**
 * 清空表格
 * @param n
 * @param i
 */
function delTbody(n){ 
var t=document.getElementById(n); 
if (!t)return; 
var tbs=t.getElementsByTagName('tbody'); 
//if (!tbs[i]){ 
//alert('你指定的tbody索引号对应的tbody不存在'); 
//return; 
//} 
t.removeChild(tbs[0]); 
} 
  
/**
 * table 分页
 */
function tablefenye(){
	 var pageSize = 15;    //每页显示的记录条数
     var curPage=0;        //当前页
     var lastPage;        //最后页
    var direct=0;        //方向
    var len;            //总行数
    var page;            //总页数
    var begin;
  var end;
   
      len =$("#tbody>tr").length;    // 求这个表的总行数，剔除第一行介绍
      page=len % pageSize==0 ? len/pageSize : Math.floor(len/pageSize)+1;//根据记录条数，计算页数
       // alert("page==="+page);
       curPage=1;    // 设置当前为第一页
       displayPage(1);//显示第一页
       
       document.getElementById("btn0").innerHTML="当前 " + curPage + "/" + page + " 页    每页 ";    // 显示当前多少页
      document.getElementById("sjzl").innerHTML="数据总量 " + len + "";        // 显示数据量
       document.getElementById("pageSize").value = pageSize;
        
       
       
        $("#btn1").click(function firstPage(){    // 首页
          curPage=1;
           direct = 0;
           displayPage();
        });
      $("#btn2").click(function frontPage(){    // 上一页
           direct=-1;
           displayPage();
       });
       $("#btn3").click(function nextPage(){    // 下一页
          direct=1;
           displayPage();
       });
       $("#btn4").click(function lastPage(){    // 尾页
          curPage=page;
           direct = 0;
           displayPage();
       });
       $("#btn5").click(function changePage(){    // 转页
            curPage=document.getElementById("changePage").value * 1;
            if (!/^[1-9]\d*$/.test(curPage)) {
               alert("请输入正整数");
               return ;
           }
           if (curPage > page) {
                alert("超出数据页面");
              return ;
           }
            direct = 0;
          displayPage();
       });
        
       
       $("#pageSizeSet").click(function setPageSize(){    // 设置每页显示多少条记录
            pageSize = document.getElementById("pageSize").value;    //每页显示的记录条数
           if (!/^[1-9]\d*$/.test(pageSize)) {
                alert("请输入正整数");
               return ;
           }
           len =$("#tbody>tr").length - 1;
            page=len % pageSize==0 ? len/pageSize : Math.floor(len/pageSize)+1;//根据记录条数，计算页数
           curPage=1;        //当前页
            direct=0;        //方向
             firstPage();
      });

       
   function displayPage(){
       if(curPage <=1 && direct==-1){
           direct=0;
           alert("已经是第一页了");
          return;
       } else if (curPage >= page && direct==1) {
           direct=0;
           alert("已经是最后一页了");
           return ;
      }
        
      lastPage = curPage;
     
       // 修复当len=1时，curPage计算得0的bug
      if (len > pageSize) {
           curPage = ((curPage + direct + len) % len);
       } else {
           curPage = 1;
      }
 
       
       document.getElementById("btn0").innerHTML="当前 " + curPage + "/" + page + " 页    每页 ";        // 显示当前多少页
       
       begin=(curPage-1)*pageSize + 1;// 起始记录号
       end = begin + 1*pageSize - 1;    // 末尾记录号
    
       
       if(end > len ) end=len;
      $("#tbody>tr").hide();    // 首先，设置这行为隐藏
       $("#tbody>tr").each(function(i){    // 然后，通过条件判断决定本行是否恢复显示
          if((i>=begin && i<=end) || i==0 )//显示begin<=x<=end的记录
               $(this).show();
       });

  }
	
}


/**
 * 分析日志table 展示
 */
function analysisFile(){
	$.ajax({
		  type:"get",
			url:"analysisFile.do?time="+$("#time").val()+"&time2="+$("#time2").val()+"&id="+$("#id").val(),
			cache: false,
			async:true,
			success:function(data){
				if(data.code==0){
					var messageshows=data.result;
					var trs="";
					for(var item in messageshows ){
						var diff=messageshows[item].diffs;
						var str="";
						for(var item2 in diff ){
							str=str+" <tr><td>"+diff[item2].hostName+"</td><td>"+diff[item2].time+"</td></tr>  ";
						}
						trs=trs+ "  <tr><td>"+messageshows[item].id+"</td><td>"+messageshows[item].duration+"</td><td>"+messageshows[item].diffTime+"</td> "+
						"  <td> "+
						" <table id=\"table2\" class=\"table\">  "+
						"  <thead>  "+
						" <tr><th>airspeed</th><th>到达时间</th></tr>  "+
						" </thead>  "+
						" <tbody> "+ str+
						"  </tbody> "+ 
						" </table> "+
						" </td>"+
						" </tr>";
					}
					$("#table1").append( "<tbody id=\"tbody\" >  "+trs+ "</tbody>"  );
					
					tablefenye();
					
				}else{
					alert("出现异常");
				}
				
			},
			error:function(data){
				 alert("出现异常!");
				}
			});
}

 