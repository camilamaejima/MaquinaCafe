package br.com.bluesoft.maquina.menu;

import br.com.bluesoft.maquina.receita.Receita;

import java.math.BigDecimal;

public class Opcao {

    private BigDecimal valor;
    private String descricao;
    private int codigo;
    public Receita novaReceita;

    public Opcao(Receita novaReceita, String descricao, int codigo, BigDecimal valor ){
        this.novaReceita = novaReceita;
        this.descricao = descricao;
        this.codigo = codigo;
        this.valor = valor;
    }


    public int getCodigo() {
        return codigo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao + " - valor R$: " + valor;
    }

}
