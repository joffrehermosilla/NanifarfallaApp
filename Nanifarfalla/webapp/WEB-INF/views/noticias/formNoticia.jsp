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
    <title>Creacion de Noticias</title>    
	<spring:url value="/resources" var="urlPublic"></spring:url>

    <jsp:include page="../includes/link.jsp"></jsp:include>
     <jsp:include page="../includes/script.jsp"></jsp:include>
  </head>

  <body>
   
   <jsp:include page="../includes/estadoymenu.jsp"></jsp:include>
	<header class="section-header">
	
		<jsp:include page="../includes/navbarheader.jsp"></jsp:include>

	</header>
    <div class="container theme-showcase" role="main">

      <h3 class="blog-title"><span class="label label-success">Datos de la Noticia</span></h3>

	  <spring:url value="/noticias/save" var="urlForm"></spring:url>
	  
	  
	  
	  	
      <form action="${urlForm}" method="post">
        <div class="row">         
          <div class="col-sm-6">
            <div class="form-group">
              <label for="titulo">Titulo</label>             
              <input type="text" class="form-control" name="titulo" id="titulo" required="required"/>
            </div>
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="estatus">Estatus</label>             
              <select id="estatus" name="estatus" class="form-control">
                <option value="importante">importante</option>
                <option value="info">info</option>  
                  <option value="alerta">alerta</option>
                <option value="eventos">eventos</option>               
              </select>  
            </div>
          </div>
        </div>
        <div class="row"> 
          <div class="col-sm-12">
            <div class="form-group">
              <label for="detalle">Detalles</label>             
              <textarea class="form-control" name="detalle" id="detalle" rows="10"></textarea>
            </div>  
          </div>
        </div>

        <button type="submit" class="btn btn-danger" >Guardar</button>
      </form> 

      <hr class="featurette-divider">

   

    </div> <!-- /container -->
   <jsp:include page="../includes/footer.jsp"></jsp:include>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  
    <script src="${urlPublic}/tinymce/tinymce.min.js"></script>
    <script>
	  // Configuracion de la barra de heramientas
	  // https://www.tinymce.com/docs/get-started/basic-setup/
      tinymce.init({
          selector: '#detalle',
          plugins: "textcolor, table lists code",
          toolbar: " undo redo | bold italic | alignleft aligncenter alignright alignjustify \n\
                    | bullist numlist outdent indent | forecolor backcolor table code"
      });
    </script>
  </body>
</html>
