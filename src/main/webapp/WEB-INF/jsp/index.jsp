<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="author" content="WebMobiData Solutions" />
<title>Sonda - Toyoda</title>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" />

<!-- Custom CSS -->
<link href="css/stylish-sonda.css" rel="stylesheet" />

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="container">
		<h1>Sonda WEB</h1>
			<div class="form-group row">
				<fieldset>
					<div class="col-sm-6">
						<input class="form-control"
							type="number" class="form-control" id="inputLimitX"
							placeholder="Digite Coordenada X Limite Malha"
							name="coordenadaLimitX" min="0" max="10"> 
					</div> 
					<div class="col-sm-6">
						<input class="form-control" type="number" class="form-control"
							id="inputLimitY" placeholder="Digite Coordenada Y Limite Malha"
							name="coordenadaLimitY" min="0" max="10">
					</div> 
				</fieldset>
			</div>
			<form action="#" method="post" id="sondaForm">
				<c:forEach items="${actionInputModel.actionInput}" varStatus="status">
					<div class="form-group row">
						<fieldset>
							<legend>Sonda ${status.count}</legend>
							<div class="col-sm-3">
								<input class="form-control"
									type="number" class="form-control"
									placeholder="Digite Coordenada X Inicial da Sonda"
									name="actionInputModel.actionInput[${status.index}].sonda.coordinateX" 
									min="0" max="10"> 
							</div> 
							<div class="col-sm-3">
								<input class="form-control" 
								    type="number" class="form-control"
								    placeholder="Digite Coordenada Y Inicial da Sonda"
									name="actionInputModel.actionInput[${status.index}].sonda.coordinateY" 
									min="0" max="10">
							</div>
							<div class="col-sm-3">
								<select class="form-control" name="actionInputModel.actionInput[${status.index}].sonda.direction">
									<option>N</option>
								    <option>S</option>
								    <option>W</option>
								    <option>E</option>
								</select>
							</div>
							<div class="col-sm-3">
								<input class="form-control instructions"
									type="text" class="form-control"
									placeholder="Digite Instruções para Sonda A (L,R,M)"
									name="actionInputModel.actionInput[${status.index}].instructions" 
									required> 
							</div>  
						</fieldset>
					</div>
				</c:forEach>
			<div>
      			<button id="sendInstruction" type="button" class="btn btn-primary btn-block">Enviar Instruções</button>
			</div>
		</form>
		<div id="result"></div>
	</div>

	<!-- jQuery -->
	<script src="js/jquery.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$( document ).ready(function() {
			$('.instructions').keypress(function(key) {
				var num = [76,77,82];
			    if (num.indexOf(event.keyCode) < 0)
					return false;
		  	});	
			$('#sendInstruction').click(function(){
			  	$('#result').empty();
				var json =  {"actionInput":[
				           	{"sonda":{"coordinateX":3,"coordinateY":3,"direction":"E"},"instructions":"LLMM"},
				            {"sonda":{"coordinateX":1,"coordinateY":2,"direction":"N"},"instructions":"LLMM"}]};
				$.ajax({
				type: 'post',
				url: '/sonda',
				contentType : 'application/json',
				dataType: 'json',
				data: json,
				success: function(response){
					$('#result').html(response);
					$('#result').show();
				}
			});	
		  });
		});
	</script>
</body>
</html>