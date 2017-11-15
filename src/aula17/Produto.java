/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula17;

/**
 *
 * @author 11944413600
 */
public class Produto {
    String nome;
    Integer qtd;

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if(nome.length()<2) throw new Exception("O nome deve ter mais de duas letras");
        this.nome = nome;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) throws Exception {
        if(qtd<0) throw new Exception("A quantidade deve ser positiva.");
        this.qtd = qtd;
    }    
    
}
