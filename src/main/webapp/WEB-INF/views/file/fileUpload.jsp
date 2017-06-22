<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="fileUpload" method="post" enctype="multipart/form-data">
네임:<input type="text" name="name"><br>
파일:<input type="file" name="f1"><br>
<button>떼스트</button>


</form>
<br>
<br>
<br>
<br>
<form action="multiFileUpload" method="post" enctype="multipart/form-data">
네임:<input type="text" name="name"><br>
파일:<input type="file" name="f1"><br>
파일:<input type="file" name="f2"><br>

<button>떼스트</button>

</form>
<br>
<br>
<br>
<br>
<form action="sameMultiFileUpload" method="post" enctype="multipart/form-data">
네임:<input type="text" name="name"><br>
파일:<input type="file" name="f1"><br>
파일:<input type="file" name="f1"><br>

<button>떼스트</button>


</form>

</body>
</html>