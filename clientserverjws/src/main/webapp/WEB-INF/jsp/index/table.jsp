<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<table style="margin-top: 10px; width: 100%;">
	<thead>
		<th align="left">Cliente</th>
		<th>Última solicitação</th>
		<th>Qtde. itens processados</th>
		<th>Última impressão</th>
		<th align="left">Último texto impresso</th>
	</thead>
	<tbody>
		<c:forEach var="service" items="${services}">
			<tr>
				<td style="text-transform: capitalize;">${service.version} - ${service.nome}</td>
				<td align="center"><fmt:formatDate value="${service.lastDateOnline}" pattern="dd/MM/YYYY hh:mm:ss" /></td>
				<td align="center">${service.clientImpressao.processedItensCount}</td>
				<td align="center"><fmt:formatDate value="${service.clientImpressao.lastDateImpressao}"
						pattern="dd/MM/YYYY hh:mm:ss" /></td>
				<td>${service.clientImpressao.lastTextImpresso}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>