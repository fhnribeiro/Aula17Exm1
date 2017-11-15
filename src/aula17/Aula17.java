/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula17;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 11944413600
 */
public class Aula17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ProdutoDAO dao = new ProdutoDAOJDBC();
            
            Random rnd = new Random();
            
            for(int i = 0;i<10;i++){
                
                Produto p = new Produto();
                p.setNome("Produto"+ rnd.nextInt(100));
                p.setQtd(rnd.nextInt(10)+1);
                
                dao.criar(p);
                
            }
            
            
            List<Produto> produtos = dao.listarTodos();
            
            for (Produto produto : produtos) {
            
                System.out.println(String.format(" %s \t %d", produto.getNome(),produto.getQtd()));
            
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Aula17.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Aula17.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
    }
    
}
