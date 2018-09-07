/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Apoio;

@WebServlet(name = "ValidarAcesso", urlPatterns = {"/ValidarAcesso"})
public class ValidarAcesso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // valida sessão
            HttpSession sessao = request.getSession(true);
            Usuario user = (Usuario) sessao.getAttribute("usuario");

            if (user == null) {
                if (request.getParameter("email") != null && request.getParameter("pswd") != null) {
                    user = new Usuario(request.getParameter("email"), request.getParameter("pswd"));
                    sessao.setAttribute("usuario", user);
                }
            }

            //valida login
            String senhaDig = user.getSenha();
            String parteEmail = user.getEmail();

            parteEmail = parteEmail.substring(0, parteEmail.indexOf("@"));

            if (Apoio.validaSenha(senhaDig, parteEmail)) {
                Apoio.usr = user;
                response.sendRedirect("HoroscopoPage.jsp");
            } 
            else
                response.sendRedirect(".");
            
            

        } catch (IOException ex) {

            response.sendRedirect(".");
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
