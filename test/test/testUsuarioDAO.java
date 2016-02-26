
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
        
        
        //Criando usuario
        Usuario usu = new Usuario(); 
        usu.setNome("Jao");
        usu.setLogin("jzao");
        usu.setSenha("123");
        //Cadastrando usuario no banco
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.cadatrar(usu);
        System.out.println("Cadastrado com sucesso");
    }
}

  
