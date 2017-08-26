<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="cache-control" content="max-age=0" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="refresh" content="10" />
		<title>Client server Project</title>
	</head>
	<body>
		<div>
			<h3>Urls  disponíveis</h3>
		</div>
		<div>
			<ul>
				<span> <a href="#"> ${linkTo[PublicServicesController].consumirFilaImpressao}</a></span>
			</ul>
			<ul>
				<span> <a href="#"> http://localhost:8080/client-server/jws/ClientJws.jnlp</span>
			</ul>
		</div>
		<div style="margin-top: 40px;">
			<c:choose>
				<c:when test="${empty services}">
					<ul>
						<span>Não existem clientes online.</span>
					</ul>
				</c:when>
				<c:otherwise>
					<jsp:include page="table.jsp" />
				</c:otherwise>
			</c:choose>
		</div>
	</body>
</html>