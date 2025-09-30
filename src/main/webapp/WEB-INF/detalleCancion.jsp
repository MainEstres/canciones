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
    <h1>Detalle Cancion: ${cancion.titulo}</h1>

    <p>Artista: ${cancion.artista.nombre}</p>
    <p>Albúm: ${cancion.album}</p>
    <p>Genero: ${cancion.genero}</p>
    <p>Idioma: ${cancion.idioma}</p>

    <form method="GET" action="/canciones/formulario/editar/${cancion.id}">
      <button >Editar</button>
    </form>

    <a href="/canciones">Lista de canciones</a>
  </body>
</html>
