package br.com.bluesoft.maquina.estoque;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

    public List<ItemEstoque> listaItens = new ArrayList<>();

    public boolean verificaSeTemItensObrigatorios(){
        for (ItemEstoque listaIten : listaItens) {
            if(listaIten.isItemObrigatorio() == true && listaIten.getQuantidadeEstoque() >= listaIten.getQuantidadeEstoqueMinimo()){
                return true;
            }
        }
        return false;
    }

    public boolean verificaUmItemNaoObrigatorioTemEstoque(){
        for (ItemEstoque listaIten : listaItens) {
            if(listaIten.isItemObrigatorio() == false && listaIten.getQuantidadeEstoque() >= listaIten.getQuantidadeEstoqueMinimo()){
                return true;
            }
        }
        return false;
    }

    public void adicionarItemEstoque(ItemEstoque novoItem){
        listaItens.add(novoItem);
    }

    public boolean verificaQuantidade(int codigoItem, int quantidade){
        for (ItemEstoque listaItem : listaItens) {
            int codigoItemEstoque = listaItem.getCodigoItem();
            int quantidadeEstoque = listaItem.getQuantidadeEstoque();
            if (codigoItemEstoque == codigoItem) {
                int resultado = quantidadeEstoque - quantidade;
                if (resultado < 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public void removerQuantidadeEstoque(int quantidadeRemocao, int codigoItem){
        for (ItemEstoque listaItem : listaItens) {
            if(codigoItem == listaItem.getCodigoItem()) {
                listaItem.removerQuantidadeEstoque(quantidadeRemocao, listaItem.getCodigoItem());
            }
        }
    }

}
