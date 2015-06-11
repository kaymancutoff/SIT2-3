<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : view
    Created on : 04.06.2015, 10:45:47
    Author     : KVI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Данные</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
      body {
        padding-top: 20px;
        padding-bottom: 60px;
        background: url(images/doges.jpg)  repeat-y, repeat-x;
         background-attachment: fixed;
      }

      /* Custom container */
      .container {
        margin: 0 auto;
        max-width: 1000px;
      }
      .container > hr {
        margin: 60px 0;
      }

      /* Main marketing message and sign up button */
      .jumbotron {
        margin: 80px 0;
        text-align: center;
      }
      .jumbotron h1 {
        font-size: 80px;
        line-height: 1;
      }
      .jumbotron .lead {
        font-size: 24px;
        line-height: 1.25;
      }
      .jumbotron .btn {
        font-size: 21px;
        padding: 14px 24px;
      }

      /* Supporting marketing content */
      .marketing {
        margin: 60px 0;
      }
      .marketing p + h4 {
        margin-top: 28px;
      }


      /* Customize the navbar links to be fill the entire space of the .navbar */
      .navbar .navbar-inner {
        padding: 0;
      }
      .navbar .nav {
        margin: 0;
        display: table;
        width: 100%;
      }
      .navbar .nav li {
        display: table-cell;
        width: 1%;
        float: none;
      }
      .navbar .nav li a {
        font-weight: bold;
        text-align: center;
        border-left: 1px solid rgba(255,255,255,.75);
        border-right: 1px solid rgba(0,0,0,.1);
      }
      .navbar .nav li:first-child a {
        border-left: 0;
        border-radius: 3px 0 0 3px;
      }
      .navbar .nav li:last-child a {
        border-right: 0;
        border-radius: 0 3px 3px 0;
      }
    </style>
    </head>
    <body>
        <div class="masthead">
                <h3 class="muted"></h3>
                <div class="navbar">
                  <div class="navbar-inner">
                    <div class="container">
                      <ul class="nav">
                        <li class="active"><a href="Servlet?command=show" class="btn btn-primary btn-lg">Показать заказы</a></li>
                        <li><a href="Servlet?command=goInsert" class="btn btn-primary btn-lg">Добавить заказ</a></li>
                        <li><a href="Servlet?command=goUpdate" class="btn btn-primary btn-lg">Редактировать заказ</a></li>
                        <li><a href="Servlet?command=goDelete" class="btn btn-primary btn-lg">Удалить заказ</a></li>
                        <li><a href="Servlet?command=goSearch" class="btn btn-primary btn-lg">Поиск</a></li>
                        <li><a href="Servlet?command=prib" class="btn btn-primary btn-lg">Прибыль</a></li>
                        <li><a href="Servlet?command=home" class="btn btn-primary btn-lg">Домой</a></li>
                      </ul>
                    </div>
                  </div>
                </div><!-- /.navbar -->
              </div>
        <div class="jumbotron">
                <h1>Данные:</h1>
                <br>
        <table class="table table-striped table-bordered">
            <tr>
		<td>N</td><td>Товар</td><td>Количество</td><td>Стоимость</td>
                <td>ФИО</td><td>Адрес</td><td>Телефон</td><td>Дата</td><td>Статус</td>
            </tr>
            <c:forEach var="elem" items="${lst}" varStatus="status" >
                <tr>
                    <td><c:out value = "${elem.id}"/> </td>
                    <td><c:out value="${ elem.tovar }" />  </td> <td><c:out value="${ elem.kolich }" /></td>
                    <td><c:out value="${ elem.stoim }" />  </td> <td><c:out value="${ elem.fiozakaz }" /></td>
                    <td><c:out value="${ elem.adress }" />  </td> <td><c:out value="${ elem.telef }" /></td>
                    <td><c:out value="${ elem.data }" />  </td> <td><c:out value="${ elem.status }" /></td>
                </tr>
            </c:forEach>
        </table>
                <a href="#top">Наверх</a>              
                </div>
    </body>
</html>
