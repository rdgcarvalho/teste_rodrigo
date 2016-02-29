/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entidade.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import persistencia.jdbc.UsuarioDAO;

/**
 *
 * @author rodrigo
 */
@WebServlet("/autenticador.do")
public class AutenticadorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
        //ao inserir o parametro false, voce so acessa a sessao, se deixar em branco
        //vai ser automaticamente true, que ira criar a sessao
        HttpSession sessao = req.getSession(false);
        
        if(sessao != null){
            sessao.invalidate();
           
        }
        
        resp.sendRedirect("login.html");
        






    }

    
    
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        
        Usuario usu = new Usuario();
        
        usu.setLogin(login);
        usu.setSenha(senha);
        
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuAutenticado = usuarioDAO.autenticar(usu);
            
            if(usuAutenticado != null){
                HttpSession sessao = req.getSession();
                sessao.setAttribute("usuAutenticado", usuAutenticado);
                sessao.setMaxInactiveInterval(60*5);
                
                
                req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
                
                
            }else{
                resp.getWriter().println("<script> window.alert('Login ou senha invalidos'); location.href='login.html';</script>");
            }
            
        } catch (SQLException ex) {
            
        }
        





        
        



    }
    
    
    
    
    
}
