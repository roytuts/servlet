<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Username Availability using Servlet, jQuery, AJAX,
	MySQL</title>
<!--<script
	src="${pageContext.request.contextPath}/assets/js/jquery-3.3.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/jquery-migrate-1.4.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/jquery-ui-1.10.3.custom.min.js"></script>-->
	
	<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js" integrity="sha256-lSjKY0/srUM9BE3dPm+c4fBo1dky2v27Gdjm2uoZaL0=" crossorigin="anonymous"></script>
</head>
<body>
	<div style="margin: 10px 0 0 10px; width: 600px">
		<h3>Servlet, AJAX, MySQL username availability check</h3>
		<form id="signupform" style="padding: 10px;">
			<fieldset>
				<legend>Check username</legend>
				<div>
					<label>Username</label><br /> <input type="text" name="username"
						id="username" />
					<div id="msg"></div>
				</div>
			</fieldset>
		</form>
	</div>
	<!-- below jquery things triggered on onblur event and checks the username availability in the database -->
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$("#username")
									//.live(
									.on(
											//"blur",
											"input",
											function(e) {
												$('#msg').hide();
												if ($('#username').val() == null
														|| $('#username').val() == "") {
													$('#msg').show();
													$("#msg")
															.html(
																	"Username is required field.")
															.css("color", "red");
												} else {
													$
															.ajax({
																type : "POST",
																url : "http://localhost:8080/servlet-ajax-username-availability/AuthServlet",
																data : $(
																		'#signupform')
																		.serialize(),
																dataType : "html",
																cache : false,
																success : function(
																		msg) {
																	$('#msg')
																			.show();
																	$("#msg")
																			.html(
																					msg);
																},
																error : function(
																		jqXHR,
																		textStatus,
																		errorThrown) {
																	$('#msg')
																			.show();
																	$("#msg")
																			.html(
																					textStatus
																							+ " "
																							+ errorThrown);
																}
															});
												}
											});
						});
	</script>
</body>
</html>
