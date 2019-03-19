package br.com.bluesoft.maquina.estoque;

import br.com.bluesoft.maquina.Item;

public class ItemEstoque extends Item {

    private int quantidadeEstoque;

    public ItemEstoque(int codigoItem, String nomeItem, int quantidadeEstoque){
        super(codigoItem, nomeItem);
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
