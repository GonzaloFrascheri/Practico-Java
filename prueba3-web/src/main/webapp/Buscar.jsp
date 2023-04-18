<%--
  Created by IntelliJ IDEA.
  User: usuario
  Date: 9/4/2023
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Carga.uy</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
        crossorigin="anonymous"
  >
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
          crossorigin="anonymous">
  </script>
</head>
<body>
  <div class="jumbotron text-center" style="margin-bottom:0">
    <h1>Carga.uy</h1>
  </div>
  <ul class="nav justify-content-center">
    <li class="nav-item">
      <a class="nav-link" href="Alta.jsp">Agregar Proceso</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="Buscar.jsp">Buscar Proceso</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="Listar.jsp">Listar Proceso</a>
    </li>
  </ul>
  <br>
  <br>
  <br>
  <div class="jumbotron text-center" style="margin-bottom:0">
    <h1>Buscar Procesos</h1>
  </div>
  <form action="Buscar" method="post">
    <div class="mb-3">
      <label class="form-label">ID</label>
      <input type="text" class="form-control" name="id">
    </div>
    <div class="container">
      <div class="col-md-12 text-center">
        <button type="submit" class="btn btn-primary">Buscar</button>
      </div>
    </div>
  </form>
</body>
</html>
