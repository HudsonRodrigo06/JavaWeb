package svlt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
        location = "/",
        fileSizeThreshold = 1024 * 1024, // 1MB *      
        maxFileSize = 1024 * 1024 * 50, // 100MB **
        maxRequestSize = 1024 * 1024 * 10 * 10 // 100MB ***
)

@WebServlet(name = "UpServlet", urlPatterns = {"/UpServlet"})
public class UpServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // lê a pasta de destino

        String pasta = "musicas";
        Part filePart = request.getPart("file");  // Lê o arquivo de upload
        
        String fileName = request.getParameter("musica") + "_" + request.getParameter("cbEstilos") + "_" + request.getParameter("cantor") + ".mp3";
        fileName = fileName.replace(" ", "_");
        
        OutputStream outS = null;
        InputStream filecontent = null;
        PrintWriter out = response.getWriter();
        
        try {  //criando a pasta
            
            File fpasta = new File(getServletContext().getRealPath("/") + "/" + pasta);
            fpasta.mkdir();
            outS = new FileOutputStream(new File(fpasta.getAbsolutePath() + "/" + fileName));
            filecontent = filePart.getInputStream();
            int read = 0;
            byte[] bytes = new byte[1024];
            
            while ((read = filecontent.read(bytes)) != -1) {
                outS.write(bytes, 0, read);
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>UpServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Novo arquivo " + fileName + " criado na pasta " + pasta + "</h1>");
            out.println("<a href=\"Tela_UploadMusic.jsp\" >New Upload</a>");
            out.println("<a href=\"index.html\" style='padding-left: 10px;'>Back to Start</a>");
            out.println("</body>");
            out.println("</html>");

            out.println();
            out.println("");

            out.close();
            filecontent.close();
            out.close();
            
        } catch (Exception fne) {
            out.println("Erro ao receber o arquivo");
            out.println("<br/> ERRO: " + fne.getMessage());
            out.println("<br/><a href=\"Tela_UploadMusic.jsp\" >New Upload</a>");
            out.println("<a href=\"index.html\" style='padding-left: 10px;'>Back to Start</a>");
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
