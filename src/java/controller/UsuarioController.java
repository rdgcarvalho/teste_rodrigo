/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entidade.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
      
      String acao = req.getParameter("acao");
      
      if(acao.equals("exc")){
      
      String id = req.getParameter("id");
      Usuario usu = new Usuario();
      if(id!=null){
          usu.setId(Integer.parseInt(id));
      }
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.excluir(usu);
        } catch (SQLException e) {
           
        }
      resp.getWriter().println("Excluido com sucesso");
      resp.sendRedirect("usucontroller.do?acao=lis");
      } else if(acao.equals("lis")){
          
          try {
              UsuarioDAO usuarioDAO = new UsuarioDAO();
              List<Usuario> lista = usuarioDAO.buscarTodos();
              req.setAttribute("lista", lista);
              RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/listausu.jsp");
              dispatcher.forward(req,resp);
          } catch (SQLException ex) {}
          
      } else if(acao.equals("alt")){
          String id = req.getParameter("id");
          
          try {
          UsuarioDAO  usuarioDAO = new UsuarioDAO();
          Usuario usuario = usuarioDAO.buscarPorId(Integer.parseInt(id));
          req.setAttribute("usu", usuario);
          RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formusuario.jsp");
          dispatcher.forward(req, resp);
          } catch (SQLException ex) {}
          
      } else if(acao.equals("cad")){
          
          Usuario usu = new Usuario();
          usu.setId(0);
          usu.setLogin("");
          usu.setNome("");
          usu.setSenha("");
          req.setAttribute("usu", usu);
          req.getRequestDispatcher("WEB-INF/formusuario.jsp").forward(req, resp);
          
          
          
      }
    }
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      String id = req.getParameter("id");
      String nome = req.getParameter("nome");
      String login = req.getParameter("login");
      String senha = req.getParameter("senha");
      
      Usuario usu = new Usuario();
      if(id != null){
        usu.setId(Integer.parseInt(id));
      }
      usu.setNome(nome);
      usu.setLogin(login);
      usu.setSenha(senha);
          
        try {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.salvar(usu);
        } catch (SQLException e) {}  
      resp.getWriter().print("Sucesso!");
      resp.getWriter().println("Cadastrado");
      resp.sendRedirect("usucontroller.do?acao=lis");
        
        
        
        
    }
    
    
    
    
    @Override
    public void destroy(){
        System.out.println("Destroy..");
        super.destroy();
    }
    
}
