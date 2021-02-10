<link href="style.css" rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List, br.com.alura.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Empresas</title>
</head>
<body class="fundo">

	<c:if test="${not empty empresa}">
		Empresa ${ empresa } cadastrada com sucesso!
	</c:if>

	Lista de empresas:
	<br />

	<ul>
		<c:forEach items="${empresas}" var="empresa">

			<li>${empresa.nome } - <fmt:formatDate
					value="${empresa.dataAbertura }" pattern="dd/MM/yyyy" /> <a
				href="/gerenciador/mostraEmpresa?id=${empresa.id }">edita</a> <a
				href="/gerenciador/removeEmpresa?id=${empresa.id }">remove</a>
			</li>
		</c:forEach>
	</ul>

</body>
</html>



