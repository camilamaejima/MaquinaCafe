package br.com.bluesoft.maquina;

import br.com.bluesoft.maquina.estoque.Estoque;
import br.com.bluesoft.maquina.estoque.ItemEstoque;
import br.com.bluesoft.maquina.menu.Menu;
import br.com.bluesoft.maquina.menu.Opcao;
import br.com.bluesoft.maquina.receita.ItemReceita;
import br.com.bluesoft.maquina.receita.Receita;

import java.math.BigDecimal;


public class Main {

    public static void main(String[] args){

        ItemEstoque poCafeEstoque = new ItemEstoque(1, "Pó de café", 0);
        ItemEstoque chocolateEstoque = new ItemEstoque(2,"Chocolate", 0);
        ItemEstoque chaEstoque = new ItemEstoque(3, "Essência de chá", 0);
        ItemEstoque leiteEstoque = new ItemEstoque(4, "Leite", 0);
        ItemEstoque acucarEstoque = new ItemEstoque(5,"Açúcar", 0);
        ItemEstoque xicaraEstoque = new ItemEstoque(6, "Xícara", 0);

        Estoque novoEstoque = new Estoque();
        novoEstoque.adicionarItemEstoque(poCafeEstoque);
        novoEstoque.adicionarItemEstoque(chocolateEstoque);
        novoEstoque.adicionarItemEstoque(chaEstoque);
        novoEstoque.adicionarItemEstoque(leiteEstoque);
        novoEstoque.adicionarItemEstoque(acucarEstoque);
        novoEstoque.adicionarItemEstoque(xicaraEstoque);

        ItemReceita itemCafe = new ItemReceita("Pó de Café", "Passa pelo filtro o", 1, 1);
        ItemReceita itemChocolate = new ItemReceita("Chocolate", "Acrescenta ",2, 1);
        ItemReceita itemCha = new ItemReceita("Essência chá","Passa por", 3, 1);
        ItemReceita itemLeite = new ItemReceita("Leite", "Acrescenta ", 4,1);
        ItemReceita itemAcucar = new ItemReceita("Açúcar", "Acrescenta ", 5, 3);
        ItemReceita itemXicara = new ItemReceita("Xícara", "Coloca na ", 6, 1);
        ItemReceita itemAgua = new ItemReceita("Água", "Esquenta ", 7, 0);

        Receita receitaCafe = new Receita();
        receitaCafe.adicionarItem(itemAgua);
        receitaCafe.adicionarItem(itemCafe);
        receitaCafe.adicionarItem(itemAcucar);
        receitaCafe.adicionarItem(itemXicara);
        Opcao cafe = new Opcao(receitaCafe, "Café", 1, new BigDecimal(1) );

        Receita receitaCafeLeite = new Receita();
        receitaCafeLeite.adicionarItem(itemAgua);
        receitaCafeLeite.adicionarItem(itemCafe);
        receitaCafeLeite.adicionarItem(itemLeite);
        receitaCafeLeite.adicionarItem(itemAcucar);
        receitaCafeLeite.adicionarItem(itemXicara);
        Opcao cafeLeite = new Opcao(receitaCafeLeite, "Café com Leite",2, new BigDecimal(1.50));

        Receita receitaCappuccino = new Receita();
        receitaCappuccino.adicionarItem(itemAgua);
        receitaCappuccino.adicionarItem(itemCafe);
        receitaCappuccino.adicionarItem(itemLeite);
        receitaCappuccino.adicionarItem(itemChocolate);
        receitaCappuccino.adicionarItem(itemAcucar);
        receitaCappuccino.adicionarItem(itemXicara);
        Opcao cappuccino = new Opcao(receitaCappuccino,"Cappuccino", 3, BigDecimal.valueOf(2) );

        Receita receitaCha = new Receita();
        receitaCha.adicionarItem(itemAgua);
        receitaCha.adicionarItem(itemCha);
        receitaCha.adicionarItem(itemAcucar);
        receitaCha.adicionarItem(itemXicara);
        Opcao cha = new Opcao(receitaCha, "Chá", 4,new BigDecimal(1));

        Receita receitaAgua = new Receita();
        receitaAgua.adicionarItem(itemAgua);
        receitaAgua.adicionarItem(itemXicara);
        Opcao agua = new Opcao(receitaAgua,"Água", 5, new BigDecimal(0));

        Menu menuNovo = new Menu();
        menuNovo.adicionarOpcao(cafe);
        menuNovo.adicionarOpcao(cafeLeite);
        menuNovo.adicionarOpcao(cappuccino);
        menuNovo.adicionarOpcao(cha);
        menuNovo.adicionarOpcao(agua);

        MaquinaCafe maquinaCafe = new MaquinaCafe(menuNovo, novoEstoque);


        boolean desliga = true;
        maquinaCafe.iniciaMaquina();
        maquinaCafe.inserirEstoque();
        maquinaCafe.ligaMaquina();
        while (desliga){
            maquinaCafe.mostraMenu();
            maquinaCafe.esperaAteAlguemSelecionarUmaOpcao();
            try{
                maquinaCafe.confereEstoque();
                maquinaCafe.alterarNivelAcucar();
            }catch (Exception e){
                System.out.println(e.getMessage());
                return;
            }

            maquinaCafe.mostrarPreco();
            maquinaCafe.cobrar();
            maquinaCafe.retiraItemEstoque();
            maquinaCafe.preparar();
            desliga = maquinaCafe.desligaMaquina();
        }
    }
}
