package util;

import Classes.Usuario;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;

public class Apoio {

    static public Usuario usr;

    static public String getSigno(int dia, int mes) {
        
        String signo = "aaa";

        if (dia >= 20 && mes == 3 || dia <= 20 && mes == 4) {
            //aries
            signo = "aries";

        } else if (dia >= 23 && mes == 9 || dia <= 22 && mes == 10) {
            //libra
            signo = "libra";

        } else if (dia >= 21 && mes == 4 || dia <= 20 && mes == 5) {
            //touro
            signo = "touro";

        } else if (dia >= 23 && mes == 10 || dia <= 21 && mes == 11) {
            //escorpiao
            signo = "escorpiao";

        } else if (dia >= 21 && mes == 5 || dia <= 20 && mes == 6) {
            //gemeos
            signo = "gemeos";

        } else if (dia >= 22 && mes == 11 || dia <= 21 && mes == 12) {
            //sargitario
            signo = "sargitario";

        } else if (dia >= 21 && mes == 6 || dia <= 21 && mes == 7) {
            //cancer
            signo = "cancer";

        } else if (dia >= 22 && mes == 12 || dia <= 21 && mes == 1) {
            //capricornio
            signo = "capricornio";

        } else if (dia >= 22 && mes == 7 || dia <= 22 && mes == 8) {
            //leao
            signo = "leao";

        } else if (dia >= 21 && mes == 1 || dia <= 18 && mes == 2) {
            //aquario
            signo = "aquario";

        } else if (dia >= 23 && mes == 8 || dia <= 22 && mes == 9) {
            //virgem
            signo = "virgem";

        } else if (dia >= 19 && mes == 2 || dia <= 19 && mes == 3) {
            //peixes
            signo = "peixes";
        }
        
        return signo;
    }

    static public String getBiscoito(HttpServletRequest request) {
        String path = request.getServletContext().getRealPath("");
        String biscoito = "";

        try {
            RandomAccessFile arq = new RandomAccessFile(path + "sorte.txt", "r");
            int Random;
            Random r = new Random();
            int pos = r.nextInt(60);

            for (int i=0; i < pos; i++) {
                biscoito = arq.readLine();
            }
            
            arq.close();
        } catch (IOException ex) {
            biscoito = "Erro: " + ex.getMessage();
        }

        return biscoito;
    }

    static public String buscarHoroscopo(LocalDate data, HttpServletRequest request) 
    {
        String aux;
        String path = request.getServletContext().getRealPath("");
        String signo = getSigno(data.getDayOfMonth(), data.getMonthValue());

        try {

            RandomAccessFile arq = new RandomAccessFile(path + "horoscopo.txt", "r");
            String sig;
            
            aux = arq.readLine();
            sig = aux.substring(0, aux.indexOf("#"));
            
            while(aux != null && !sig.equalsIgnoreCase(signo))
            {
                aux = arq.readLine();
                sig = aux.substring(0, aux.indexOf("#"));
            }
            arq.close();
        } catch (IOException ex) {
            aux = ex.getMessage();
        }

        if(aux != null)
            aux = aux.replace(signo+"#", "");
        
        return aux;
    }

    static public boolean validaSenha(String senhaDig, String parteEmail) {

        String reverse = "";

        for (int i = parteEmail.length() - 1; i >= 0; i--) {
            reverse += parteEmail.charAt(i);
        }

        return reverse.equals(senhaDig);
    }

}
