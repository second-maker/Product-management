<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	
	ArrayList<dto.ProductDTO> list = (ArrayList<dto.ProductDTO>)request.getAttribute("list");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="css/work.css">
	<script src="js/script.js" defer></script>
	<title>商品一覧</title>
</head>
<body class="text-center bg-light">

    <img src="img/logo.png" alt="ロゴマーク">

    <div class="title-info2">
        <h1>商品一覧</h1>
    </div>




    <form class="border rounded bg-white select-form">
        
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">名前</th>
                    <th scope="col">カテゴリー</th>
                    <th scope="col">値段</th>
                    
                </tr>
            </thead>
            <tbody>
            
            <% for(int i = 0; i < list.size(); i++) { %>
            
                <tr>
                
                
                	
                    <th scope="row"><%= (i+1) %></th>
                    <td><%= list.get(i).getProductName() %></td>
                    <td><%= list.get(i).getCategoryName() %></td>
                    <td><%= list.get(i).getPrice() %>円</td>
                    
       
                    
                </tr>
                
            <% } %>    
                
            </tbody>
        </table>
        
    </form>


	<p class="cancel"><a href="search.jsp">戻る</a></p>
	
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