/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.jdbc;

import entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodrigo
 */
public class UsuarioDAO {
    private final Connection con;

    public UsuarioDAO() throws SQLException {
        this.con = ConexaoFactory.getConnection();
    }
    public void cadastrar(Usuario usu) {
   
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
    public void alterar(Usuario usu) throws SQLException{
        String sql = "update usuario set nome=?, login=?, senha=? where id=?";
        try(PreparedStatement preparador = con.prepareStatement(sql)){
            preparador.setString(1, usu.getLogin());
            preparador.setString(2, usu.getNome());
            preparador.setString(3, usu.getSenha());
            preparador.setInt(4, usu.getId());
            boolean x = preparador.execute();
            
        }catch(SQLException e){
        }
    }
    public void excluir(Usuario usu) throws SQLException{
        String sql = "delete from usuario where id=?";
        try(PreparedStatement preparador = con.prepareStatement(sql)){
            preparador.setInt(1, usu.getId());
            preparador.execute();
        }catch(SQLException e){
        }
    }
    
    /**
     *
     * @param usu
     * @throws SQLException
     */
   
    public void salvar(Usuario usu) throws SQLException{
        if(usu.getId()!= null){
            cadastrar(usu);
        }
        else{
            alterar(usu);          
        }
    }
    public Usuario buscarPorId(Integer id) throws SQLException{
        
        String sql = "select * from usuario where id = ?";
        try(PreparedStatement preparador = con.prepareStatement(sql)){
            preparador.setInt(1,id);
            //criando um rs e recebendo os dados do banco
            ResultSet rs = preparador.executeQuery();
            //posicionando o cursor do primeiro registro
            if(rs.next()){ // depois de verificar se existe algum registro no rs
               Usuario usuario = new Usuario();//instaciar um usuario p retornar
               usuario.setId(rs.getInt("id"));//setar o id pegando do rs
               usuario.setNome(rs.getString("nome"));//setar o nome pegando do rs
               usuario.setLogin(rs.getString("login"));
               usuario.setSenha(rs.getString("senha"));
               
               return usuario;
            }
                               
            return null;
        }catch(SQLException e){
             
        return null;
    }
}
public List<Usuario> buscarTodos() throws SQLException{
        
        String sql = "select * from usuario";
        @SuppressWarnings("Convert2Diamond")
        List<Usuario> lista = new ArrayList<Usuario>();
        try(PreparedStatement preparador = con.prepareStatement(sql)){
            
            //criando um rs e recebendo os dados do banco
            ResultSet rs = preparador.executeQuery();
            //posicionando o cursor do primeiro registro
            while(rs.next()){ // depois de verificar se existe algum registro no rs
               Usuario usuario = new Usuario();//instaciar um usuario p retornar
               usuario.setId(rs.getInt("id"));//setar o id pegando do rs
               usuario.setNome(rs.getString("nome"));//setar o nome pegando do rs
               usuario.setLogin(rs.getString("login"));
               usuario.setSenha(rs.getString("senha"));
               // adicionando usuario na lista
               lista.add(usuario);
               
               
            }
                               
            
        }catch(SQLException e){
             
        return lista;
    }
        
     return null;
}


public Usuario autenticar(Usuario usuConsulta) throws SQLException{
    String sql = "select * from usuario where login = ? and senha = ?";
    
    try(PreparedStatement preparador = con.prepareStatement(sql)){
        preparador.setString(1,usuConsulta.getLogin());
        preparador.setString(2, usuConsulta.getSenha());
        ResultSet rs = preparador.executeQuery();
        if(rs.next()){
            Usuario usuario;
            usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
        
            return usuario;
        }
    }catch(SQLException e){
        
    }
    return null;
}
}