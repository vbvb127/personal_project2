/**
input > item_ord 값도 같이 보내기 위한 쿼리
**/

console.log("나오나요");
 const item_ord = document.getElementById("item_ord").val();

$(document).ready(function(){			
		$("#orderServlet").click(function() { 
			console.log(item_ord);
		});
		
	});