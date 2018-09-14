<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Music</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script src="JS.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container mt-3">
            <h2>Search Music!</h2>
            <p>Type something in the input field to search the list for specific musics:</p>  
            <input class="form-control" id="myInput" type="text" placeholder="Music name or singer...">
            <br>
            <ul class="list-group" id="myList">

                <%! boolean fVazio = false;%>
                <%
                    try { // cria pasta musicas se n existir
                        File fpasta = new File(getServletContext().getRealPath("/") + "/" + "musicas");
                        fpasta.mkdir();

                        File arq = new File(request.getServletContext().getRealPath("") + "musicas");

                        File[] arquivos = arq.listFiles();
                        int total = arquivos.length;
                        String sNome = "";

                        if (total > 0) {
                            for (int i = 0; i < total; i++) {
                                sNome = arquivos[i].getName();
                %>
                <li name="nMusic" data-toggle='tooltip' title='Click to Play!!' value="<%=sNome%>" onclick="playMusic(this)" class="list-group-item list-group-item-action"> <%=sNome%></li> 
                <%
                            }
                        } else {
                            out.println("<li  class='list-group-item list-group-item-action'><b>" + "Nenhum arquivo foi encontrado! :(" + "</b></li>");
                            fVazio = true;
                        }

                    } catch (Exception ex) {

                        out.println("Caminho testado: " + request.getServletContext().getRealPath("") + "musicas");
                        out.println(ex);
                    }

                    //<li class="list-group-item list-group-item-action">First item</li>
                    //<li class="list-group-item list-group-item-action">Second item</li>

                %>
            </ul> 
            <div id="player">
            </div>
            <%                    //if(fVazio)
                out.println("<br><button type='button' onclick='home()' class='btn btn-outline-info'>Back to Home</button>");
            %>
        </div>     
    </body>
</html>
