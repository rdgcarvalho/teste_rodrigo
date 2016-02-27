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
import persistencia.jdbc.UsuarioDAO;

/**
 *
 * @author rodrigo
 */
@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {
    
    
    public UsuarioController(){
        System.out.println("Novo Servlet!");
    }
    
    @Override
    public void init() throws ServletException{
        System.out.println("Init..");
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
      String nome = req.getParameter("nome");
      String login = req.getParameter("login");
      String senha = req.getParameter("senha");
      
      Usuario usu = new Usuario();
      usu.setNome(nome);
      usu.setLogin(login);
      usu.setSenha(senha);
      
     
        try {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.salvar(usu);
        } catch (SQLException e) {}  
      resp.getWriter().print("Sucesso!");
     
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      String nome = req.getParameter("nome");
      String login = req.getParameter("login");
      String senha = req.getParameter("senha");
      
      Usuario usu = new Usuario();
      usu.setNome(nome);
      usu.setLogin(login);
      usu.setSenha(senha);
      
     
        try {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.salvar(usu);
        } catch (SQLException e) {}  
      resp.getWriter().print("Sucesso!");    
        
        
        
        
    }
    
    
    
    
    @Override
    public void destroy(){
        System.out.println("Destroy..");
        super.destroy();
    }
    
}
