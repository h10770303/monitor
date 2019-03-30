/** 
* 获取本周、本季度、本月、上月的开端日期、停止日期 
*/  
var now = new Date(); //当前日期  
var nowDayOfWeek = now.getDay(); //今天本周的第几天  
var nowDay = now.getDate(); //当前日  
var nowMonth = now.getMonth(); //当前月  
var nowYear = now.getYear(); //当前年  
nowYear += (nowYear < 2000) ? 1900 : 0; //  
  
var lastMonthDate = new Date(); //上月日期  
lastMonthDate.setDate(1);  
lastMonthDate.setMonth(lastMonthDate.getMonth()-1);  
var lastYear = lastMonthDate.getYear();  
var lastMonth = lastMonthDate.getMonth();  
  
//格局化日期：yyyy-MM-dd  
function formatDate(date) {  
var myyear = date.getFullYear();  
var mymonth = date.getMonth()+1;  
var myweekday = date.getDate();  
  
if(mymonth < 10){  
mymonth = "0" + mymonth;  
}  
if(myweekday < 10){  
myweekday = "0" + myweekday;  
}  
return (myyear+"-"+mymonth + "-" + myweekday);  
}  
  
//获得某月的天数  
function getMonthDays(myMonth){  
var monthStartDate = new Date(nowYear, myMonth, 1);  
var monthEndDate = new Date(nowYear, myMonth + 1, 1);  
var days = (monthEndDate - monthStartDate)/(1000 * 60 * 60 * 24);  
return days;  
}  
  
//获得本季度的开端月份  
function getQuarterStartMonth(){  
var quarterStartMonth = 0;  
if(nowMonth<3){  
quarterStartMonth = 0;  
}  
if(2<nowMonth && nowMonth<6){  
quarterStartMonth = 3;  
}  
if(5<nowMonth && nowMonth<9){  
quarterStartMonth = 6;  
}  
if(nowMonth>8){  
quarterStartMonth = 9;  
}  
return quarterStartMonth;  
}  
  
//获得本周的开端日期  
function getWeekStartDate() {  
var weekStartDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek+1);  
return formatDate(weekStartDate);  
}  
  
//获得本周的停止日期  
function getWeekEndDate() {  
var weekEndDate = new Date(nowYear, nowMonth, nowDay + (6 - nowDayOfWeek)+2);  
return formatDate(weekEndDate);  
}  
  
//获得本月的开端日期  
function getMonthStartDate(){  
var monthStartDate = new Date(nowYear, nowMonth, 1);  
return formatDate(monthStartDate);  
}  
  
//获得本月的停止日期  
function getMonthEndDate(){  
var monthEndDate = new Date(nowYear, nowMonth, getMonthDays(nowMonth));  
return formatDate(monthEndDate);  
}  
  
//获得上月开端时候  
function getLastMonthStartDate(){  
var lastMonthStartDate = new Date(nowYear, lastMonth, 1);  
return formatDate(lastMonthStartDate);  
}  
  
//获得上月停止时候  
function getLastMonthEndDate(){  
var lastMonthEndDate = new Date(nowYear, lastMonth, getMonthDays(lastMonth));  
return formatDate(lastMonthEndDate);  
}  
  
//获得本季度的开端日期  
function getQuarterStartDate(){  
  
var quarterStartDate = new Date(nowYear, getQuarterStartMonth(), 1);  
return formatDate(quarterStartDate);  
}  
  
//或的本季度的停止日期  
function getQuarterEndDate(){  
var quarterEndMonth = getQuarterStartMonth() + 2;  
var quarterStartDate = new Date(nowYear, quarterEndMonth, getMonthDays(quarterEndMonth));  
return formatDate(quarterStartDate);  
}  



/**
 * 时间戳转换成日期格式 
 * @param obj
 * @returns {String}
 */
function fmtDate(obj){
    var date =  new Date(obj);
    var y = 1900+date.getYear();
    var m = "0"+(date.getMonth()+1);
    var d = "0"+date.getDate();
    var h = "0"+date.getHours();
    var min = "0"+date.getMinutes();
    var sec = "0"+date.getSeconds();
    return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length)+" "+h.substring(h.length-2,h.length)+":"+min.substring(min.length-2,min.length)+":"+sec.substring(sec.length-2,sec.length);
}

/**
 * 时间戳转换成日期格式  
 * @param obj
 * @returns {String}
 */
function formatDateTime(inputTime) {  
    var date = new Date(inputTime);
    var y = date.getFullYear();  
    var m = date.getMonth() + 1;  
    m = m < 10 ? ('0' + m) : m;  
    var d = date.getDate();  
    d = d < 10 ? ('0' + d) : d;  
    var h = date.getHours();
    h = h < 10 ? ('0' + h) : h;
    var minute = date.getMinutes();
    var second = date.getSeconds();
    minute = minute < 10 ? ('0' + minute) : minute;  
    second = second < 10 ? ('0' + second) : second; 
    return y + '-' + m + '-' + d+' '+h+':'+minute+':'+second;  
}

function getNextDay(d){
    d = new Date(d);
    d = +d + 1000*60*60*24;
    d = new Date(d);
    //return d;
    //格式化
    return d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
     
}
function getBeforeDay(d){
	d = new Date(d);
	d = d - 1000*60*60*24;
	d = new Date(d);
	//return d;
	//格式化
	return d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
	
}