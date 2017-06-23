<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<input type="button" id="add" value="file add">
<form action="upload" method="post" enctype="multipart/form-data">
<input type="text" name="name"><br>
<div id="file">

</div>


<button>떼스트</button>


</form>
<script type="text/javascript">
var t = 0;
$("#add").click(function() {
	t = t + 1;
	if(t <=5){
	$("#file").append('<p">파일선택 ★ ★ <input type="file" name="f1"><span class="del">x</span> </p>')
	}else{
		t = 5;
		alert('그만클릭해라 임마야')
	}
	
});
$("#file").on("click",".del", function () {
	$(this).parent().remove();
	t--;
	
	if(t < 0){
		t = 0;
	}
});
</script>

</body>
</html>