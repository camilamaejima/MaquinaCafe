package br.com.bluesoft.maquina.receita;

import br.com.bluesoft.maquina.receita.ItemReceita;

import java.util.ArrayList;
import java.util.List;

public class Receita {
    public List<ItemReceita> listaItens = new ArrayList<>();

    public void adicionarItem(ItemReceita novoItem){
        listaItens.add(novoItem);
    }

    @Override
    public String toString(){

        listaItens.forEach((item) ->{

            if(item.getCodigoItem() == 6 && item.getQuantidade() == 0) {
                System.out.println("Sem açúcar!");

            }else{
                System.out.println(item.getComportamento() + " - "
                        + item.getNomeItem()
                        + (item.getQuantidade() != 0 ? " - " + item.getQuantidade() : ""));
            }
        });

        return "";
    }



}

