/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.jdbc;

import entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rodrigo
 */
public class UsuarioDAO {
    private final Connection con;

    public UsuarioDAO() throws SQLException {
        this.con = ConexaoFactory.getConnection();
    }
    public void cadatrar(Usuario usu) {
   
        String sql = "insert into usuario(nome, login, senha) values (?, ?, ?)";
        try ( //Criando um statement
                PreparedStatement preparador = con.prepareStatement(sql)){
            //cada linha substitui um ponto pela variavel
            preparador.setString(1, usu.getNome());
            preparador.setString(2, usu.getLogin());
            preparador.setString(3, usu.getSenha());
            //executar sql no banco
            preparador.execute();
            //fechando o statement, o objeto preparador

        } catch (SQLException e) {
            
        }
        
        
        
    }

   
    
}
