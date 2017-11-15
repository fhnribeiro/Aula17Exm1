/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 11944413600
 */
public class ProdutoDAO {
    
    public void criar(Produto prod) throws Exception{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String driverURL = "jdbc:derby://localhost:1527/2017-3-DCC171";
        Connection conexao = DriverManager.getConnection(driverURL,"usuario","senha");

        PreparedStatement operacaoInsere = conexao.prepareStatement("INSERT INTO produto(nome,qtd,atualizado) VALUES(?,?,CURRENT_TIMESTAMP)");
        
        operacaoInsere.clearParameters();
        operacaoInsere.setString(1, prod.getNome());
        operacaoInsere.setInt(2, prod.getQtd());
        operacaoInsere.executeUpdate();
    }
    
    public List<Produto> listarTodos() throws Exception{
        ArrayList<Produto> produtos=null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String driverURL = "jdbc:derby://localhost:1527/2017-3-DCC171";
        Connection conexao = DriverManager.getConnection(driverURL,"usuario","senha");

        PreparedStatement operacaoListar = conexao.prepareStatement("SELECT nome,qtd FROM produto WHERE qtd>?");
        operacaoListar.clearParameters();
        operacaoListar.setInt(1, 0);
        ResultSet rs = operacaoListar.executeQuery();

        while(rs.next()){
            Produto p = new Produto();
            p.setNome(rs.getString("nome"));
            p.setQtd(rs.getInt("qtd"));
            produtos.add(p);
        }
        
        return produtos;
    }
}
