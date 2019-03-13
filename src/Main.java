import java.math.BigDecimal;


public class Main {

    public static void main(String[] args){


        //agua
        ItemReceita itemAgua = new ItemReceita();
        itemAgua.setNomeIngrediente("Água");
        itemAgua.setComportamento("Esquenta ");
        //cafe
        ItemReceita itemCafe = new ItemReceita();
        itemCafe.setNomeIngrediente("Café");
        itemCafe.setComportamento("Passa pelo pó");
        //chocolate
        ItemReceita itemChocolate = new ItemReceita();
        itemChocolate.setNomeIngrediente("Chocolate");
        itemChocolate.setComportamento("Acrescenta");
        //cha
        ItemReceita itemCha = new ItemReceita();
        itemCha.setNomeIngrediente("Essência Chá");
        itemCha.setComportamento("Passa por");
        //leite
        ItemReceita itemLeite = new ItemReceita();
        itemLeite.setNomeIngrediente("Leite");
        itemLeite.setComportamento("Acrescenta");
        //acucar
        ItemReceita itemAcucar = new ItemReceita();
        itemAcucar.setNomeIngrediente("Açúcar");
        itemAcucar.setComportamento("Acrescenta");
        itemAcucar.setQuantidade(3);

        Receita receitaCafe = new Receita();
        receitaCafe.adicionarIngrediente(itemAgua);
        receitaCafe.adicionarIngrediente(itemCafe);
        receitaCafe.adicionarIngrediente(itemAcucar);
        Opcao cafe = new Opcao(receitaCafe);
        cafe.setDescricao("Café");
        cafe.setValor(new BigDecimal(1));
        cafe.setCodigo(1);

        Receita receitaCafeLeite = new Receita();
        receitaCafeLeite.adicionarIngrediente(itemAgua);
        receitaCafeLeite.adicionarIngrediente(itemCafe);
        receitaCafeLeite.adicionarIngrediente(itemLeite);
        receitaCafeLeite.adicionarIngrediente(itemAcucar);
        Opcao cafeLeite = new Opcao(receitaCafeLeite);
        cafeLeite.setDescricao("Café com Leite");
        cafeLeite.setValor(new BigDecimal(1.50));
        cafeLeite.setCodigo(2);

        Receita receitaCappuccino = new Receita();
        receitaCappuccino.adicionarIngrediente(itemAgua);
        receitaCappuccino.adicionarIngrediente(itemCafe);
        receitaCappuccino.adicionarIngrediente(itemLeite);
        receitaCappuccino.adicionarIngrediente(itemChocolate);
        receitaCappuccino.adicionarIngrediente(itemAcucar);
        Opcao cappuccino = new Opcao(receitaCappuccino);
        cappuccino.setDescricao("Cappuccino");
        cappuccino.setValor(BigDecimal.valueOf(1.50));
        cappuccino.setCodigo(3);

        Receita receitaCha = new Receita();
        receitaCha.adicionarIngrediente(itemAgua);
        receitaCha.adicionarIngrediente(itemCha);
        receitaCha.adicionarIngrediente(itemAcucar);
        Opcao cha = new Opcao(receitaCha);
        cha.setDescricao("Chá");
        cha.setValor(new BigDecimal(1));
        cha.setCodigo(4);

        Receita receitaAgua = new Receita();
        receitaAgua.adicionarIngrediente(itemAgua);
        Opcao agua = new Opcao(receitaAgua);
        agua.setDescricao("Água");
        agua.setValor(new BigDecimal(0));
        agua.setCodigo(5);

        Menu menuNovo = new Menu();
        menuNovo.adicionarOpcao(cafe);
        menuNovo.adicionarOpcao(cafeLeite);
        menuNovo.adicionarOpcao(cappuccino);
        menuNovo.adicionarOpcao(cha);
        menuNovo.adicionarOpcao(agua);

        MaquinaCafe maquinaCafe = new MaquinaCafe(menuNovo);

        maquinaCafe.mostraMenu();
        maquinaCafe.esperaAteAlguemSelecionarUmaOpcao();
        maquinaCafe.alterarNivelAcucar();
        maquinaCafe.mostrarPreco();
        maquinaCafe.cobrar();
        maquinaCafe.preparar();

    }
}
