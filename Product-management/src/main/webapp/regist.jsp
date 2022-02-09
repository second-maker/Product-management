<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	
	String userId = (String)session.getAttribute("userId");
	String userName = (String)session.getAttribute("userName");
	
%>

 
<!DOCTYPE html>
<html lang="ja">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="css/top.css">
	<title>ユーザー登録画面</title>
</head>
<body class="text-center bg-light">

	<p class="login-name">ようこそ　<c:out value="${user.userName}"/>様</p>

    <img src="img/logo.png" alt="ロゴマーク">

    <div class="title-info">
        <p>あたらしく登録したい</p>
        <p>ユーザーの情報を入力してください。</p>
    </div>
    

    <div class="form">
        <form action="./UserRegistServlet" method="post" class="border rounded bg-white login-form menu">
    
            <div class="mb-3 d-flex box">
                <p class="input-title">ユーザーID</p>
                <input type="text" name="userId" value="<% if(userId != null) { out.print(userId);} %>" class="form-control">
            </div>

            <div class="mb-3 d-flex box">
                <p class="input-title">ユーザー名</p>
                <input type="text" name="userName" value="<% if(userName != null) { out.print(userName);} %>" class="form-control">
            </div>

            <div class="mb-3 d-flex box">
                <p class="input-title">パスワード</p>
                <input type="password" name="password" value="" class="form-control">
            </div>
            
            <div class="mb-3 d-flex box">
                <p class="input-title">区分</p>
                <div class="radioBox">
                    <input class="form-check-input" type="radio" name="division" id="inlineRadio1" value="1" checked>
                    <label class="form-check-label" for="inlineRadio1">消費者</label>
                    <input class="form-check-input" type="radio" name="division" id="inlineRadio2" value="2">
                    <label class="form-check-label" for="inlineRadio2">管理者</label>
                </div>
            </div>

            <button type="submit" class="btn btn-primary rounded-pill">登録する</button>
            
 		<c:if test="${requestScope.alert != null && requestScope.alert != ''}">
            <p class="text-danger"><c:out value="${requestScope.alert}"/></p>
        </c:if>
            
        </form>
    </div>
	    
    <form action="./LogoutServlet" method="post">
		<button type="submit" class="logout">ログアウト</button>
	</form>
	
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
</body>
</html>