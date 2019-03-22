package br.com.bluesoft.maquina.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Menu {

    public List<Opcao> listaOpcoes = new ArrayList<>();

    public String toString(){

        listaOpcoes.forEach((opcao) ->{
            System.out.println(opcao);
        });
        return "";
    }

    public void adicionarOpcao(Opcao opcaoLista){
        listaOpcoes.add(opcaoLista);
    }

    public Optional<Opcao> buscaOpcaoPorCodigo(int codigo, ArrayList<Opcao> listaEstoque){

        Optional<Opcao> opcaoEscolhida = listaEstoque.stream()
                .filter(opcao -> opcao.getCodigo() == codigo)
                .findFirst();

        return opcaoEscolhida;

    }

}