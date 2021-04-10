<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Agenda de contatos</title>
<link rel="icon" href="images/favicon.ico">
<link rel="stylesheet" href="styles/style.css">
<meta http-equiv="Cache-Control" content="no-store" />
</head>
</head>
<body>
	<div class="container">
	<a href="main"><img class="back" src="images/voltar.png" /></a>
		<div class="content-flex card">

			<div class="form-content">

				<form name="frmContato" action="update" id="form">
					<h1>Editar contato</h1>
					<table>
						<tr>
							<td><input type="text" name="idcon" id="caixa3" readonly
								value="<%out.print(request.getAttribute("idcon"));%>"></td>
						</tr>
						<tr>
							<td><input type="text" name="nome" class="caixa1"
								value="<%out.print(request.getAttribute("nome"));%>"></td>
						</tr>
						<tr>
							<td><input type="text" name="fone" class="caixa2"
								value="<%out.print(request.getAttribute("fone"));%>"></td>
						</tr>

						<tr>
							<td><input type="text" name="email" class="caixa1"
								value="<%out.print(request.getAttribute("email"));%>"></td>
						</tr>
					</table>
					<input type="button" value="Salvar" class="btn-primario"
						onclick="validar()">
				</form>
				<script src="scripts/validar.js"></script>
			</div>
			<div class="img-novo">
				<img src="images/edit.png" />
			</div>
		</div>
	</div>

	<footer>
		<p>
			Agenda Web - Developed by <a href="https://github.com/RobertoMartins">Roberto
				Murilo</a>
		</p>
	</footer>
</body>
</html>