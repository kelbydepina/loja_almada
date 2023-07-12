/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.mysql;

/**
 *
 * @author joao Claudio Soares
 */
public class Produto {
    private int codigo;
    private String designacao;
    private double preco;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Produto(int codigo, String designacao, double preco) {
        this.codigo = codigo;
        this.designacao = designacao;
        this.preco = preco;
    }

    
    public void imprimir() {
        System.out.println("codigo=" + codigo + ", designacao=" + designacao + ", preco=" + preco );
    }
    
    public double desconto(double valor){
        double d=this.preco*valor/100;
        return d;
    }
    
    
    
    
    
    
}
