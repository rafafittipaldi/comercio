<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="templates/header.jsp"></jsp:include>
	
	<div class="container">
		
		<div class="row justify-content-center">
			<div class="col-10">

				<div class="row pt-4">
				
					<c:forEach var="produto" items="${produtos}" >
					
						<div class="card m-2 p-2" style="width: 18rem;">
							<img class="card-img-top" width="200px" alt="iphone"
								src="${pageContext.request.contextPath}/img/${produto.foto}">
								
							<div class="card-body">
								<h5 class="card-title">${produto.nome}</h5>
								<p class="card-text">
								   ${produto.descricao}
								   <br/>
								   <h2> ${produto.preco} </h2>
								</p>
								<a href="#" class="btn btn-success">Comprar</a>
							</div>
							
						</div>
					
					</c:forEach>
					
				</div>

			</div>
		</div>
		
	</div>
</body>
</html>