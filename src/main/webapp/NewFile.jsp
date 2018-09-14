<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>QQ录入页面</title>
		<script type="text/javascript" src="static/js/jquery-1.12.4.min.js"></script>
	</head>
	<body>
		<h3>本页面提供 qq录入和qq id查询</h3>
		录入QQ号<input type="text" id="qq"></input>
				<button onclick="sendQQ()">录入</button>
		




<script>
	function sendQQ(){
		var qq=document.getElementById("qq").value;	
       var reg = /^[1-9][0-9]{4,9}$/gim;
      if (reg.test(qq)) {
           console.log('QQ号码格式输入正确');
          $.ajax({
			url:"http://localhost:8080/Hex/typein",
			data:{qq:qq},
			type:"post",				
			success:function(result){
				console.log(result);
				
			},
			error:function(){				
				alert("服务器未开启！")
			}
		});		                      
        } else {
            console.log('请输入正确格式的QQ号码');
        }		
			
	}		
</script>		
	</body>
</html>
