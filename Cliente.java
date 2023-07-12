/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.mysql;

/**
 *
 * @author ledunipiaget
 */
public class Cliente {
    private int codigo;
    private String nome;
    private String email;
    private String morada;
    private String telefone;

    public Cliente(int codigo, String nome, String email, String morada, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.morada = morada;
        this.telefone = telefone;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    } 

    public void imprimir() {
    System.out.println("codigo = " + codigo + ", nome = " + nome + ", email =" + email+ ", morada = " + morada + ", telefone =" + telefone);
    }
}
