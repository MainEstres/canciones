<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Artistas</title>
  </head>
  <body>
    <div>
      <c:forEach var="artista" items="${listaArtistas}">
        <h2><a href="/artistas/detalle/${artista.id}">${artista.nombre}</a></h2>
      </c:forEach>
    </div>
    <a href="/artistas/formulario/agregar">Agregar una artista</a>
    <a href="/canciones">Ir a lista de canciones</a>
  </body>
</html>
