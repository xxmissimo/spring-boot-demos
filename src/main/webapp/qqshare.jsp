<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>QQ录入页面</title>
		<script type="text/javascript" src="static/js/jquery-1.12.4.min.js"></script>
	</head>
	<body>
		<h3> qq录入 ，QQ数值大于2147483647的十位Q输入无效！</h3>
		录入QQ号<input type="text" id="qq"></input>
				<button onclick="sendQQ()">录入</button>
		
	</body>
	<script>
	function sendQQ(){
		var qq=document.getElementById("qq").value;	
       var reg = /^[1-9][0-9]{4,9}$/gim;
      if (reg.test(qq)) {
          $.ajax({
			url:"/Hex/typein",
			data:{qq:qq},
			type:"post",				
			success:function(result){
				console.log(result);
				var tips=result.extend.PageInfo;
				alert(tips);
			},
			error:function(){				
				alert("服务器未开启！");
			}
		});		                      
        } else {
            //console.log('请输入正确格式的QQ号码');
            alert('请输入正确格式的QQ号码');
        }				
	}	
</script>
</html>
