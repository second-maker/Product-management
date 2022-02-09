<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="css/top.css">
<script src="js/script.js" defer></script>
<title>商品検索画面</title>
</head>
<body class="text-center bg-light">

    <p class="login-name">ようこそ<c:out value="${user.userName}"/>様</p>

    <div>
        <img src="img/logo.png" alt="ロゴマーク">
    </div>
    

    <div class="form product-manager">
        <form action="./SearchServlet" method="get" class="border rounded bg-white login-form menu">
    
            <div class="mb-3 d-flex box">
                <p class="input-title serch-title">商品名</p>
                <input type="text" name="productName" value="" class="form-control mg-form">
            </div>

            <div class="mb-3 d-flex box">
                <p class="input-title serch-title">カテゴリ</p>
                <select class="form-select category-select" aria-label="Default select example" name="category">
                    <option selected value="">-------</option>
                    <option value="1">フード</option>
                    <option value="2">ドリンク</option>
                    <option value="3">デザート</option>
                </select>
            </div>

            <div class="mb-3 d-flex box">
                <p class="input-title">価格</p>
                <input type="text" name="lowPrice" value="" class="form-control price-form"><p class="namisen">～</p>
                <input type="text" name="highPrice" value="" class="form-control price-form">
            </div>
            
            

            <button type="submit" class="btn btn-primary rounded-pill">検索</button>
            
            
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