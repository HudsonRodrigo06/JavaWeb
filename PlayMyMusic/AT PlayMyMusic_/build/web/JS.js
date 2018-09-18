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

function vStr(str)
{
    
  
    for(var i=0; i<str.length; i++)
    {
        switch(str[i])
        {
            case '!': return false; break;
            case '@': return false; break;
            case '#': return false; break;
            case '$': return false; break;
            case '%': return false; break;
            case '£': return false; break;
            case '¹': return false; break;
            case '²': return false; break;
            case '³': return false; break;
            case '¢': return false; break;
            case '¨': return false; break;
            case '¬': return false; break;
            case '&': return false; break;
            case '*': return false; break;
            case '(': return false; break;
            case ')': return false; break;
            case '-': return false; break;
            case '+': return false; break;
            case '=': return false; break;
            case '§': return false; break;
            case '´': return false; break;
            case '`': return false; break;
            case '[': return false; break;
            case '{': return false; break;
            case 'ª': return false; break;
            case ']': return false; break;
            case '}': return false; break;
            case 'º': return false; break;
            case '?': return false; break;
            case '/': return false; break;
            case '°': return false; break;
            case ':': return false; break;
            case ';': return false; break;
            case '>': return false; break;
            case '<': return false; break;
            case '.': return false; break;
            case ',': return false; break;
            case '|': return false; break;
            case '"': return false; break;
            case '\\': return false; break;
        }
    }
    return true;
}

function validaString()
{
    var musica = document.getElementsByName("musica")[0].value;
    var cantor = document.getElementsByName("cantor")[0].value;
    var estilo = document.getElementsByName("cbEstilos")[0].value;
    var msgAlert = "";
    
    if(!vStr(musica))
        msgAlert = "Música contém simbolos não permitidos!";
    if(!vStr(cantor))
        msgAlert += ((msgAlert === "") ? "Cantor contém simbolos não permitidos!" : "\nCantor contém simbolos não permitidos!");
    
    if(!(msgAlert === ""))
    {
        alert(msgAlert);
        toUpSvl(musica, cantor, estilo);
    }
    else
    {
        toUpSvl(musica, cantor, estilo);
    }
    
    
    
}

function toHome()
{
    window.location.href = ".";
}

function toUpSvl(musica, cantor, estilo)
{
    document.getElementsByName("musica")[0].
    window.location.href = "UpServlet?musica"+musica+"&cantor="+cantor+"&cbEstilos="+estilo+"";
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