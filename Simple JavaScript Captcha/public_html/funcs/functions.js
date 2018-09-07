function ValidaData()
{
    var dig = new String();
    var aux;
    var data = new Date();
    var str = new String();

    dig = prompt("Digite a data de hoje (ex: mm/dd/aaaa):");
    aux = new Date(dig);

    if(aux.getDate() === data.getDate() &&
            aux.getMonth() === data.getMonth() &&
               aux.getFullYear() === data.getFullYear())
        str = "Data inserida é a mesma de hoje!";
    else
        str = "Data inserida é diferente da data de hoje!";

    alert(str);
}


function GeraPerguntas()
{
    mat1 = [];
    mat2 = [];
    var res;
    var msg = 0;
    
    for (i=0; i<3; i++) //definindo a 1ª dimensão
    {
        mat1[i]= [];
        mat2[i] = []; 
    }
    
    mat1[0] = "\nQuanto é 1+3?";
    mat1[1] = "\nQuanto é 1+1?";
    mat1[2] = "Quanto é 2+3?";
        
    mat2[0] = "4";
    mat2[1] = "2";
    mat2[2] = "5";
    
    
    for(i = 0; i < 3; i++)
    {
        res = prompt(mat1[i]);
        if(res === mat2[i])
            msg++;
    }
    
    alert(msg + " Acertos!");
}