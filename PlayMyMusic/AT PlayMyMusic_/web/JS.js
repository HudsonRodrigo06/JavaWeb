$(document).ready(function () {
    $("#myInput").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#myList li").filter(function () {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});

$(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });

function home()
{
    window.location.href = ".";
}

function playMusic(obj)
{
    var xhttp = new XMLHttpRequest(); // cria objeto ajax
    xhttp.open("GET", "PlayServlet?nMusic=" + obj.innerHTML, true); // faz chamada ao Servlet
    xhttp.onreadystatechange = function ()  // vincula ao evento ajax 
    {
        document.getElementById("player").innerHTML = xhttp.responseText;
    };
    xhttp.send(); // devolve requisição
}