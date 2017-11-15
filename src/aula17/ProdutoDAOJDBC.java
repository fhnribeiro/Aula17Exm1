/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula17;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 11944413600
 */
public class ProdutoDAOJDBC implements ProdutoDAO{
    
    private Connection conexao;
    private PreparedStatement operacaoInsere;
    private PreparedStatement operacaoListar;

    public ProdutoDAOJDBC() throws Exception {
        conexao = ConexaoJavaDB.getConnection();
        operacaoInsere = conexao.prepareStatement("INSERT INTO produto(nome,qtd,atualizado) VALUES(?,?,CURRENT_TIMESTAMP)");
        operacaoListar = conexao.prepareStatement("SELECT nome,qtd FROM produto WHERE qtd>?");
    }
    
    
    public void criar(Produto prod) throws Exception{
        operacaoInsere.clearParameters();
        operacaoInsere.setString(1, prod.getNome());
        operacaoInsere.setInt(2, prod.getQtd());
        operacaoInsere.executeUpdate();
    }
    
    public List<Produto> listarTodos() throws Exception{
        ArrayList<Produto> produtos = new ArrayList<>();
        
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
