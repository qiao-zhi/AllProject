/**设置一个时钟表***/
function startTime()
{
var today=new Date()
var h=today.getHours()
var m=today.getMinutes()
var s=today.getSeconds()
// add a zero in front of numbers<10
m=checkTime(m)
s=checkTime(s)
document.getElementById('txt').innerHTML=h+":"+m+":"+s
t=setTimeout('startTime()',500)  //此函数用于在500s后调用函数start...函数
}
function checkTime(i)
{
if (i<10) 
  {i="0" + i}
  return i
}

function logout(){
	var isOK=confirm("确认注销？");
	if(isOK==true){
		window.location='logout.html';
	}
}
