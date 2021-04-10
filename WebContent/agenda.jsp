<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.ContatoBean"%>
<%@ page import="java.util.ArrayList"%>


<%
	@ SuppressWarnings ("unchecked")
	ArrayList<ContatoBean> lista = (ArrayList<ContatoBean>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="icon" href="images/favicon.ico">
<link rel="stylesheet" href="styles/style.css">
<meta http-equiv="Cache-Control" content="no-store" />
</head>
<body>
	<div class="container">
		<div class="content-block card">
			<h1>Agenda de Contatos</h1>
			<a href="novo.html" class="btn-primario">Novo contato</a> <a href="report"
				class="btn-relatorio">Relatório</a>
			<table id="tabela">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>Fone</th>
						<th>E-mail</th>
						<th>Opções</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (int i = 0; i < lista.size(); i++) {
					%>
					<tr>
						<td><%=lista.get(i).getIdcon()%></td>
						<td><%=lista.get(i).getNome()%></td>
						<td><%=lista.get(i).getFone()%></td>
						<td><%=lista.get(i).getEmail()%></td>
						<td><a class="btn-primario"
							href="select?idcon=<%=lista.get(i).getIdcon()%>">Editar</a> <a
							class="btn-remover"
							href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)">Excluir</a></td>
					</tr>

					<%
						}
					%>

				</tbody>
			</table>
		</div>
	</div>
	<script src="scripts/confirmador.js"></script>
</body>
</html>