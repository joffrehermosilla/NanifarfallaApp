<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Administración de Lineas</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/lineas/index" var="urlForm"></spring:url>
<spring:url value="/lineas/create" var="urlCreate" />

<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../includes/estadoymenu.jsp"></jsp:include>
	<header class="section-header">
		<jsp:include page="../includes/navbarheader.jsp"></jsp:include>

	</header>

	<div class="container theme-showcase" role="main">
		<h3>Listado de Lineas</h3>
		<c:if test="${mensaje!=null }">
			<div class='alert alert-success' role="alert">${mensaje}</div>
		</c:if>
		<a href="${urlCreate}" class="btn btn-success" role="button"
			title="Nueva Linea">Nuevo</a> <br> <br>



		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Nombre Usuario</th>
					<th>Codigo Linea</th>
					<th>fecha creacion</th>
					<th>Nombre de Linea</th>
					<th>estado de la linea</th>
					<th>Foto Linea</th>

				</tr>

				<c:forEach var="linea" items="${lineas}">
					<tr>
						<td>Tabla Lineas</td>
						<td>${linea.codigo_linea}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${linea.version}" />
						<td>${linea.nombre_linea}</td>
						<td>Renovar/Bloquear/Esperar</td>
						<td>${linea.foto_linea}</td>

						<td align="center">
							<table border="1">
								<tr>
									<td><a href="#" class="btn btn-success btn-sm"
										role="button" title="Edit"> <span
											class="glyphicon glyphicon-trash">Actualizar<i
												class="fa fa-pencil"></i></span></a></td>
								</tr>
								<tr>
									<td><a href="#" class="btn btn-danger btn-sm"
										role="button" title="Eliminar"><span
											class="glyphicon glyphicon-trash">Eliminar <i
												class="fa fa-trash-o"></i>
										</span></a></td>
								</tr>
							</table>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<hr class="featurette-divider">

		<!-- /container -->
		<jsp:include page="../includes/footer.jsp"></jsp:include>
		<!-- Bootstrap core JavaScript -->


		<!-- /container -->

	</div>
<body>

</body>


</html>

<head>
<spring:url value="/resources" var="urlPublic" />





<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
	rel="stylesheet">

<script>
	$(document)
			.ready(
					function() {
						var date = new Date();
						var d = date.getDate();
						var m = date.getMonth();
						var y = date.getFullYear();

						/*  className colors
						
						className: default(transparent), important(red), chill(pink), success(green), info(blue)
						
						 */

						/* initialize the external events
						-----------------------------------------------------------------*/

						$('#external-events div.external-event').each(
								function() {

									// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
									// it doesn't need to have a start or end
									var eventObject = {
										title : $.trim($(this).text())
									// use the element's text as the event title
									};

									// store the Event Object in the DOM element so we can get to it later
									$(this).data('eventObject', eventObject);

									// make the event draggable using jQuery UI
									$(this).draggable({
										zIndex : 999,
										revert : true, // will cause the event to go back to its
										revertDuration : 0
									//  original position after the drag
									});

								});

						/* initialize the calendar
						-----------------------------------------------------------------*/

						var calendar = $('#calendar')
								.fullCalendar(
										{
											header : {
												left : 'title',
												center : 'agendaDay,agendaWeek,month',
												right : 'prev,next today'
											},
											editable : true,
											firstDay : 1, //  1(Monday) this can be changed to 0(Sunday) for the USA system
											selectable : true,
											defaultView : 'month',

											axisFormat : 'h:mm',
											columnFormat : {
												month : 'ddd', // Mon
												week : 'ddd d', // Mon 7
												day : 'dddd M/d', // Monday 9/7
												agendaDay : 'dddd d'
											},
											titleFormat : {
												month : 'MMMM yyyy', // September 2009
												week : "MMMM yyyy", // September 2009
												day : 'MMMM yyyy' // Tuesday, Sep 8, 2009
											},
											allDaySlot : false,
											selectHelper : true,
											select : function(start, end,
													allDay) {
												var title = prompt('Event Title:');
												if (title) {
													calendar.fullCalendar(
															'renderEvent', {
																title : title,
																start : start,
																end : end,
																allDay : allDay
															}, true // make the event "stick"
													);
												}
												calendar
														.fullCalendar('unselect');
											},
											droppable : true, // this allows things to be dropped onto the calendar !!!
											drop : function(date, allDay) { // this function is called when something is dropped

												// retrieve the dropped element's stored Event Object
												var originalEventObject = $(
														this).data(
														'eventObject');

												// we need to copy it, so that multiple events don't have a reference to the same object
												var copiedEventObject = $
														.extend({},
																originalEventObject);

												// assign it the date that was reported
												copiedEventObject.start = date;
												copiedEventObject.allDay = allDay;

												// render the event on the calendar
												// the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
												$('#calendar')
														.fullCalendar(
																'renderEvent',
																copiedEventObject,
																true);

												// is the "remove after drop" checkbox checked?
												if ($('#drop-remove').is(
														':checked')) {
													// if so, remove the element from the "Draggable Events" list
													$(this).remove();
												}

											},

											events : [
													{
														title : 'All Day Event',
														start : new Date(y, m,
																1)
													},
													{
														id : 999,
														title : 'Repeating Event',
														start : new Date(y, m,
																d - 3, 16, 0),
														allDay : false,
														className : 'info'
													},
													{
														id : 999,
														title : 'Repeating Event',
														start : new Date(y, m,
																d + 4, 16, 0),
														allDay : false,
														className : 'info'
													},
													{
														title : 'Meeting',
														start : new Date(y, m,
																d, 10, 30),
														allDay : false,
														className : 'important'
													},
													{
														title : 'Lunch',
														start : new Date(y, m,
																d, 12, 0),
														end : new Date(y, m, d,
																14, 0),
														allDay : false,
														className : 'important'
													},
													{
														title : 'Birthday Party',
														start : new Date(y, m,
																d + 1, 19, 0),
														end : new Date(y, m,
																d + 1, 22, 30),
														allDay : false,
													},
													{
														title : 'Click for Google',
														start : new Date(y, m,
																28),
														end : new Date(y, m, 29),
														url : 'https://ccp.cloudaccess.net/aff.php?aff=5188',
														className : 'success'
													} ],
										});

					});
</script>
<style>
body {
	margin-bottom: 40px;
	margin-top: 40px;
	text-align: center;
	font-size: 14px;
	font-family: 'Roboto', sans-serif;
	background:
		url(http://www.digiphotohub.com/wp-content/uploads/2015/09/bigstock-Abstract-Blurred-Background-Of-92820527.jpg);
}

#wrap {
	width: 1100px;
	margin: 0 auto;
}

#external-events {
	float: left;
	width: 150px;
	padding: 0 10px;
	text-align: left;
}

#external-events h4 {
	font-size: 16px;
	margin-top: 0;
	padding-top: 1em;
}

.external-event { /* try to mimick the look of a real event */
	margin: 10px 0;
	padding: 2px 4px;
	background: #3366CC;
	color: #fff;
	font-size: .85em;
	cursor: pointer;
}

#external-events p {
	margin: 1.5em 0;
	font-size: 11px;
	color: #666;
}

#external-events p input {
	margin: 0;
	vertical-align: middle;
}

#calendar {
	/* 		float: right; */
	margin: 0 auto;
	width: 900px;
	background-color: #FFFFFF;
	border-radius: 6px;
	box-shadow: 0 1px 2px #C3C3C3;
	-webkit-box-shadow: 0px 0px 21px 2px rgba(0, 0, 0, 0.18);
	-moz-box-shadow: 0px 0px 21px 2px rgba(0, 0, 0, 0.18);
	box-shadow: 0px 0px 21px 2px rgba(0, 0, 0, 0.18);
}
</style>
</head>




<div id='wrap'>

	<div id='calendar'></div>

	<div style='clear: both'></div>
</div>
