package br.com.bluesoft.maquina.receita;

import br.com.bluesoft.maquina.Item;

public class ItemReceita extends Item {

    private String comportamento;
    private int quantidade;

    public ItemReceita(String nomeItem, String comportamento, int codigoItem, int quantidade){
        super(codigoItem, nomeItem);
        this.comportamento = comportamento;
        this.quantidade = quantidade;
    }

    public String getComportamento() {
        return comportamento;
    }

    public void setComportamento(String comportamento) {
        this.comportamento = comportamento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
