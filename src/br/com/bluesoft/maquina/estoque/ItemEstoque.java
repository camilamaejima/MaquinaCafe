package br.com.bluesoft.maquina.estoque;

import br.com.bluesoft.maquina.Item;

public class ItemEstoque extends Item {

    private int quantidadeEstoque;
    private int quantidadeEstoqueMinimo;
    private boolean itemObrigatorio;

    public ItemEstoque(int codigoItem, String nomeItem, int quantidadeEstoque, int quantidadeEstoqueMinimo, boolean itemObrigatorio){
        super(codigoItem, nomeItem);
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeEstoqueMinimo = quantidadeEstoqueMinimo;
        this.itemObrigatorio = itemObrigatorio;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void addQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque += quantidadeEstoque;
    }

    public void removerQuantidadeEstoque(int quantidadeEstoque, int codigoItem){
        if(codigoItem == this.getCodigoItem()){
            this.quantidadeEstoque -= quantidadeEstoque;
        }
    }

    public int getQuantidadeEstoqueMinimo() {
        return quantidadeEstoqueMinimo;
    }

    public boolean isItemObrigatorio() {
        return itemObrigatorio;
    }

}
