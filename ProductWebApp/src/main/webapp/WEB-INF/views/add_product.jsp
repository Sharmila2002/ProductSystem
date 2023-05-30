<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./style.jsp"%>
</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">

				<h2 class="text-center mb-3">Add product details</h2>
				<form action="handleForm" method="post">
					<div class="form-group">
						<label for="name">Product Name</label> <input type="text"
							class="form-control" aria-describedby="emailHelp"
							placeholder="Enter the product name" id="name" name="name">
					</div>
					<div class="form-group">
						<label for="description">Product Description</label>
						<textarea class="form-control" aria-describedby="emailHelp"
							rows="5" placeholder="Enter the product description"
							id="description" name="description"></textarea>
					</div>

					<div class="form-group">
						<label for="price">Product Price</label> <input type="text"
							class="form-control" aria-describedby="emailHelp"
							placeholder="Enter the product price" id="price" name="price">
					</div>

					<div class="container text-center">
						<a href="${pageContext.request.contextPath}/"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-primary">Add</button>
					</div>

				</form>


			</div>
		</div>


	</div>

</body>
</html>