<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Editar Cancion</title>
  </head>
  <body>
    <form:form
      action="/canciones/procesa/editar/${cancion.id}"
      method="POST"
      modelAttribute="cancion"
    >
      <input type="hidden" name="_method" value="PUT">
      <div>
        <form:label path="titulo"> Título: </form:label>
        <form:input path="titulo" type="text" />
        <form:errors path="titulo" />
      </div>
      <div>
        <form:label path="artista"> Artista: </form:label>
        <form:input path="artista" type="text" />
        <form:errors path="artista" />
      </div>
      <div>
        <form:label path="album"> Albúm: </form:label>
        <form:input path="album" type="text" />
        <form:errors path="album" />
      </div>
      <div>
        <form:label path="genero"> Genero: </form:label>
        <form:input path="genero" type="text" />
        <form:errors path="genero" />
      </div>
      <div>
        <form:label path="idioma"> Idioma: </form:label>
        <form:input path="idioma" type="text" />
        <form:errors path="idioma" />
      </div>
      <button type="submit">Actualizar</button>
    </form:form>
    <nav>
      <a href="/canciones"> Lista de canciones </a>
    </nav>
  </body>
</html>
