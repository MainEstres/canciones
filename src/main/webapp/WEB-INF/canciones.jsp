<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <div>
      <c:forEach var="cancion" items="${listaCanciones}">
        <h2><a href="/canciones/detalle/cancion/${cancion.id}">${cancion.titulo}</a></h2>

        <form method="POST" action="/canciones/eliminar/${cancion.id}">
          <input type="hidden" name="_method" value="DELETE">
          <button>Eliminar</button>
        </form>
      </c:forEach>
    </div>
    <a href="/canciones/formulario/agregar">Agregar una canción</a>
    <a href="/artistas">Ir a artistas</a>
  </body>
</html>
