<%@ page language="java" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>互点 缤纷暑假和盛夏派对</title>
		<script type="text/javascript" src="static/js/jquery-1.12.4.min.js"></script>
	</head>
	<body>
	<div>
	录入QQ号<input type="text" id="qq"></input>
	<button onclick="sendQQ()">上传</button>
	</div>
		<div id="main_box" style="width: 640px;">
			<ul  id="main_content" style="list-style: none;">				
			</ul>
		</div>	
		<script>
	window.onload=function (){
		$.ajax({
			url:"http://localhost:8080/Hex/qqspeed",
			type:"get",				
			success:function(result){
				console.log(result.extend.PageInfo[0].qq);					
				  for (var i=0;i<result.extend.PageInfo.length;i++) {
				  	loopbox(i,result);
				  }
			},
			error:function(){
				alert("服务器未开启！")
			}
		});	
}	 
//循环生成对应的框
function loopbox(i,result){
	var main_box=document.getElementById("main_content");
	var parali=document.createElement("li");
	var para=document.createElement("p");
	para.setAttribute("id","tips"+i)
	var button=document.createElement("button");
	button.setAttribute("id","btn"+i);
	button.setAttribute("onclick", "QQspeed("+i+")");
	button.innerHTML="互点缤纷暑假";
	
	var button1=document.createElement("button");
	button1.setAttribute("id","btn1"+i);
	button1.setAttribute("onclick", "QQspeed1("+i+")");
	button1.innerHTML="互点盛夏派对";
	
	var node=document.createTextNode(result.extend.PageInfo[i].qq);
	para.appendChild(node);
 	parali.appendChild(para);
 	parali.appendChild(button);
 	parali.appendChild(button1);
	main_box.appendChild(parali);	
}
	//获取 帮助人的QQ号  跳转到对应页面
	//换个活动 把下面的连接 改一下就行了。。。。。。
	function QQspeed(i){
		var btn=document.getElementById("btn"+i);
		btn.style.background="#555555"
		var tips=document.getElementById("tips"+i).innerHTML;
		window.open("http://speed.qq.com/cp/a20180628holiday/index.htm?uid="+tips);
	}
	//盛夏派对
	function QQspeed1(i){
		var btn=document.getElementById("btn1"+i);
		btn.style.background="#555555"
		var tips=document.getElementById("tips"+i).innerHTML;
		window.open("http://speed.qq.com/cp/a20180629jzyx/index.htm?uid="+tips);
	}
	
	function sendQQ(){
		var qq=document.getElementById("qq").value;
		$.ajax({
			url:"http://localhost:8080/Hex/insqq",
			data:{qq:qq},
			type:"post",				
			success:function(result){
				//console.log();
				alert(result.extend.PageInfo);
			},
			error:function(){				
				alert("QQ格式错误 或 服务器未开启！")
			}
		});			
	}	
</script>	
	</body>
</html>

   