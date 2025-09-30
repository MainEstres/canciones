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
    <h1>Detalle Artista: ${artista.nombre}</h1>

    <p>Nombre: ${artista.nombre}</p>
    <p>Apellido: ${artista.apellido}</p>
    <p>Biografia: ${artista.biografia}</p>


    <a href="/artistas">Lista de Artistas</a>
  </body>
</html>
