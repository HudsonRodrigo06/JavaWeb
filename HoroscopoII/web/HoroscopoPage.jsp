<%@page import="Classes.Usuario"%>
<%@page import="java.time.LocalDate"%>
<%@page import="util.Apoio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Horóscopo</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
        <script>
            
            function consultarHoroscopo(dtnasc) 
            {
                var xhttp = new XMLHttpRequest(); // cria objeto ajax
                xhttp.open("GET", "ApoioAJAX?dataa="+dtnasc, true); // faz chamada ao Servlet
                xhttp.onreadystatechange = function()  // vincula ao evento ajax 
                {
                    document.getElementById("texto").innerHTML = xhttp.responseText;
                };
                xhttp.send(); // devolve requisição
            }
            
            
            
            
        </script>
        
    </head>
    <body>

        <%!
            LocalDate data;
            String signo, userMail;
        %>

        <%
            try {
                String sData = (String) request.getParameter("dataa");

                if (data == null) {
                    data = LocalDate.now();
                } else if (sData != null) {
                    data = LocalDate.parse(sData);
                }

                signo = Apoio.getSigno(data.getDayOfMonth(), data.getMonthValue());
            } catch (Exception ex) {
                response.sendRedirect("HoroscopoPage.jsp");
            }
        %>

        <%
            Usuario us = (Usuario) request.getSession().getAttribute("usuario");

            if (us != null) {
                userMail = us.getEmail();
            } else {
                response.sendRedirect(".");
            }
        %>


        <form >
            <div class="panel panel-default" onload="consultarHoroscopo('2018-08-06')">
                <div class="panel-heading">Consultar Horoscopo
                    <br>Logado como: <b><% out.println(userMail);%></b>

                </div>
                <div class="panel-body">
                    <label for="dt">Data de Nascimento:</label>
                    <p><input name="dataa" type="date" class="form-control" style="width: 10%;"></p>
                    <p><button type="button" onclick="consultarHoroscopo(dataa.value)"  class="btn btn-primary active">Consultar</button> <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                            ?
                        </button> </p>


                    <!-- The Modal -->
                    <div class="modal" id="myModal">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title" ><i>Você encontrou um Biscoito da sorte!</i></h4><button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>

                                <!-- Modal body -->
                                <div class="modal-body">
                                    <div class="alert alert-success">
                                        <strong>Sorte do dia:</strong> 
                                        <%
                                            String sorte = Apoio.getBiscoito(request);
                                            out.println(sorte);
                                        %>
                                    </div>
                                </div>

                                <!-- Modal footer -->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-danger" data-dismiss="modal">Ok!</button>
                                </div>

                            </div>
                        </div>
                    </div>

                    <hr>

                    <p>Para a data <b><%=data%></b>:</p>
                    <% out.println("<p>Signo: " + signo.toUpperCase() + "</p>");%>
                    <!--<div id="texto"></div>-->
                    <div id="texto">
                    <p><img src="imgs/<%=signo%>.png" class="img-thumbnail" height="100px" width="100px" alt="Imagem Signo" style="text-align: start;"> <%=Apoio.buscarHoroscopo(LocalDate.now(), request)%> </p>
                    </div>

                </div>
            </div>
            <div class="panel-body">
                <a href="Logout"><button style="float: right;" type="button" class="btn btn-info">Logout</button></a>
            </div>
        </form>

    </body>
</html>
