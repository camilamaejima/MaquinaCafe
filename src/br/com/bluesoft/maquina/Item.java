package br.com.bluesoft.maquina;

public class Item {

    private int codigoItem;
    private String nomeItem;


    public Item(int codigoItem, String nomeItem){
        this.codigoItem = codigoItem;
        this.nomeItem = nomeItem;
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

}
