<%-- 
    Document   : UploadMusic
    Created on : 11/09/2018, 20:03:51
    Author     : hudso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Music</title>
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
        <form method="POST" action="UpServlet" enctype="multipart/form-data">
            <div class="form-group" style="padding: 20px;">
                <h4>Please Input yours music data below:</h4><br><hr>
                <label>Estilo:</label>
                <div class="row">
                    <div class="col-sm-1">
                        <select class="form-control" name="cbEstilos">
                            <option value="Pop">Pop</option>
                            <option value="Funk">Funk</option>
                            <option value="Rock">Rock</option>
                        </select>
                    </div>
                </div>
                <br>
                <label>Musica:</label>
                <input required type="text" placeholder="MyMusic" name="musica" class="form-control" style="width: 25%">
                <label>Cantor:</label>
                <input required type="text" placeholder="MySinger" name="cantor" class="form-control" style="width: 25%">

                <label>Arquivo:</label>
                <input required type="file" name="file" id="file" class="form-control-file border" style="width: 25%;">
               
                <br>
                <button type="submit" class="btn btn-outline-info">Upload</button>
                <button type="button" onclick="toHome()" class="btn btn-outline-info">Home</button>
            </div>
        </form>

    </body>

</html>
