<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Nuevo Artista</title>
  </head>
  <body>
    <h1>Nuevo Artista</h1>

    <form:form
      action="/artistas/procesa/agregar"
      method="POST"
      modelAttribute="nuevoArtista"
    >
      <div>
        <form:label path="nombre"> Nombre: </form:label>
        <form:input path="nombre" type="text" />
        <form:errors path="nombre" />
      </div>
      <div>
        <form:label path="apellido"> Apellido: </form:label>
        <form:input path="apellido" type="text" />
        <form:errors path="apellido" />
      </div>
      
      <div>
        <form:label path="biografia"> Biografia: </form:label>
        <form:input path="biografia" type="text" />
        <form:errors path="biografia" />
      </div>
      <button>Agregar</button>
    </form:form>
  
  </body>
</html>
