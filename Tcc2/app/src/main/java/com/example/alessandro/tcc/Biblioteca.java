package com.example.alessandro.tcc;

import java.util.Date;

/**
 * Created by Alessandro on 08/05/2017.
 */

public class Biblioteca {
    private Date data_entrega;
    private Date data_recebimento;
    private double juros_dia;
    private int qtd_emprestimo;

    public Biblioteca(Date data_entrega, Date data_recebimento, double juros_dia, int qtd_emprestimo){
        this.data_entrega = data_entrega;
        this.data_recebimento = data_recebimento;
        this.juros_dia = juros_dia;
        this.qtd_emprestimo = qtd_emprestimo;
    }

    public Date getData_entrega(){
        return data_entrega;
    }
    public void setData_entrega(Date data_entrega){
        this.data_entrega = data_entrega;
    }

    public Date getData_recebimento(){
        return data_recebimento;
    }
    public void setData_recebimento(Date data_recebimento){
        this.data_recebimento = data_recebimento;
    }

    public double getJuros_dia(){
        return juros_dia;
    }
    public void setJuros_dia(double juros_dia){
        this.juros_dia = juros_dia;
    }

    public int getQtd_emprestimo(){
        return qtd_emprestimo;
    }
    public void setQtd_emprestimo(int qtd_emprestimo){
        this.qtd_emprestimo = qtd_emprestimo;
    }
}
