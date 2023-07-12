/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.mysql;

import java.io.Serializable;

/**
 *
 * @author João Cláudio Soares
 */
public class Cartao implements Serializable {
int codigoCliente;
 int numeroCartao;
double saldo;
String dataValidade;
int codigoCartao;
String nomeBanco;
int totalCompra;

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getCodigoCartao() {
        return codigoCartao;
    }

    public void setCodigoCartao(int codigoCartao) {
        this.codigoCartao = codigoCartao;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public Cartao(int codigoCliente, int numeroCartao, double saldo, String dataValidade, int codigoCartao, String nomeBanco) {
        this.codigoCliente = codigoCliente;
        this.numeroCartao = numeroCartao;
        this.saldo = saldo;
        this.dataValidade = dataValidade;
        this.codigoCartao = codigoCartao;
        this.nomeBanco = nomeBanco;
    }

}
