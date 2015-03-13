<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Banque</title>
</head>
<body>
	<div>
		<f:form modelAttribute="banqueForm" method="post"
			action="chargerCompte">
			<table>
				<tr>
					<td>Code:</td>
					<td><f:input path="code" /></td>
					<td><f:errors path="code" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Ok"></td>
				</tr>

			</table>

		</f:form>
	</div>
<c:if test="${not empty banqueForm.compte}">
	<div>
		<table>
			<tr>
				<td>Solde :</td>
				<td>${banqueForm.compte.solde}</td>
			</tr>
			<tr>
				<td>Date de Création: :</td>
				<td>${banqueForm.compte.dateCreation}</td>
			</tr>


		</table>

	</div>
	</c:if>
</body>
</html>