<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="author" content="Marcelo Toyoda" />
<title>Sonda - Toyoda</title>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" />

<!-- Custom CSS -->
<link href="css/stylish-sonda.css" rel="stylesheet" />

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<h1>Sonda WEB</h1>
			<form action="#" method="post" id="sondaForm">
				<div class="form-group row">
					<fieldset>
						<legend>Sonda 1</legend>
						<div class="col-sm-3">
							<input class="form-control"
								type="number" class="form-control"
								placeholder="Digite Coordenada X Inicial da Sonda"
								name="coordinateX1"
								min="0" max="5" required> 
						</div> 
						<div class="col-sm-3">
							<input class="form-control" 
								type="number" class="form-control"
								placeholder="Digite Coordenada Y Inicial da Sonda"
								name="coordinateY1"
								min="0" max="5" required>
						</div>
						<div class="col-sm-3">
							<select class="form-control" name="direction1">
								<option value="N">N</option>
								<option value="S">S</option>
								<option value="W">W</option>
								<option value="E">E</option>
							</select>
						</div>
						<div class="col-sm-3">
							<input class="form-control instructions"
								type="text" class="form-control"
								placeholder="Digite Instruções para Sonda (L,R,M)"
								name="instructions1"
								required> 
						</div>  
					</fieldset>
				</div>
				<div class="form-group row">
					<fieldset>
						<legend>Sonda 2</legend>
						<div class="col-sm-3">
							<input class="form-control"
								type="number" class="form-control"
								placeholder="Digite Coordenada X Inicial da Sonda"
								name="coordinateX2"
								min="0" max="5" required> 
						</div> 
						<div class="col-sm-3">
							<input class="form-control" 
								type="number" class="form-control"
								placeholder="Digite Coordenada Y Inicial da Sonda"
								name="coordinateY2"
								min="0" max="5" required>
						</div>
						<div class="col-sm-3">
							<select class="form-control" name="direction2">
								<option value="N">N</option>
								<option value="S">S</option>
								<option value="W">W</option>
								<option value="E">E</option>
							</select>
						</div>
						<div class="col-sm-3">
							<input class="form-control instructions"
								type="text" class="form-control"
								placeholder="Digite Instruções para Sonda (L,R,M)"
								name="instructions2"
								required> 
						</div>  
					</fieldset>
				</div>	
			<div>
      			<button id="sendInstruction" type="button" class="btn btn-primary btn-block">Enviar Instruções</button>
			</div>
		</form>
		<br>
		<div id="result"></div>
	</div>

	<!-- jQuery -->
	<script src="js/jquery.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		$( document ).ready(function() {
			$('.instructions').keypress(function(key){
				var num = [76,77,82];
			    if (num.indexOf(event.keyCode) < 0)
					return false;
		  	});	
			$('#sendInstruction').on('click', function(){
			  	$('#result').empty();
			  
			  	var json = {"actionInputList":
				  		[
					  		{"sonda":{"coordinateX":$("input[name='coordinateX1']").val(),"coordinateY":$("input[name='coordinateY1']").val(),"direction":$("select[name='direction1']").val()},"instructions": $("input[name='instructions1']").val()},
				  			{"sonda":{"coordinateX":$("input[name='coordinateX2']").val(),"coordinateY":$("input[name='coordinateY2']").val(),"direction":$("select[name='direction2']").val()},"instructions": $("input[name='instructions2']").val()}
				  		]};
				$.ajax({
					url: '/sonda',
					type: 'POST',
					contentType: 'application/json; charset=utf-8',
					dataType: 'json',
					data: JSON.stringify(json),
					success: function(response){
						var result = JSON.parse(JSON.stringify(response));
						var htmlResponse = 'Resultado: ';
						$.each(result, function(index){
							htmlResponse += '<p>'+result[index].coordinateX+' '+result[index].coordinateY+' '+result[index].direction+'</p>'; 
						});
						$('#result').html(htmlResponse);
						$('#result').show();
					}
				});	
		  	});
		});
	</script>
</body>
</html>