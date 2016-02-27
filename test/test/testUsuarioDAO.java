
package test;

import entidade.Usuario;
import java.sql.SQLException;
import persistencia.jdbc.UsuarioDAO;

/**
 *
 * @author rodrigo
 */
public class testUsuarioDAO {

   
    public static void main(String[] args) throws SQLException {
        
        
        
    }
    public static void testCadastrar() throws SQLException{
        //Criando usuario
        Usuario usu = new Usuario(); 
        usu.setNome("Jao");
        usu.setLogin("jzao");
        usu.setSenha("123");
        //Cadastrando usuario no banco
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.cadastrar(usu);
        System.out.println("Cadastrado com sucesso");
    }
    public static void testSalvar() throws SQLException{
        Usuario usuario = new Usuario();
        usuario.setId(2);
        usuario.setNome("Ronaldo");
        usuario.setLogin("rnl");
        usuario.setSenha("333");
        
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.salvar(usuario);
        System.out.println("Salvo com sucesso");
        
    }
}

  
