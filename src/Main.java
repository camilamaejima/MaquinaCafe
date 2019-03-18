import java.math.BigDecimal;


public class Main {

    public static void main(String[] args){

        ItemReceita itemAgua = new ItemReceita("Água", "Esquenta", 1);
        ItemReceita itemCafe = new ItemReceita("Café", "Passa pelo pó", 2);
        ItemReceita itemChocolate = new ItemReceita("Chocolate", "Acrescenta",3);
        ItemReceita itemCha = new ItemReceita("Essência chá","Passa por", 4);
        ItemReceita itemLeite = new ItemReceita("Leite", "Acrescenta", 5);
        ItemReceita itemAcucar = new ItemReceita("Açúcar", "Acrescenta", 6);

        Receita receitaCafe = new Receita();
        receitaCafe.adicionarIngrediente(itemAgua);
        receitaCafe.adicionarIngrediente(itemCafe);
        receitaCafe.adicionarIngrediente(itemAcucar);
        Opcao cafe = new Opcao(receitaCafe, "Café", 1, new BigDecimal(1) );

        Receita receitaCafeLeite = new Receita();
        receitaCafeLeite.adicionarIngrediente(itemAgua);
        receitaCafeLeite.adicionarIngrediente(itemCafe);
        receitaCafeLeite.adicionarIngrediente(itemLeite);
        receitaCafeLeite.adicionarIngrediente(itemAcucar);
        Opcao cafeLeite = new Opcao(receitaCafeLeite, "Café com Leite",2, new BigDecimal(1.50));

        Receita receitaCappuccino = new Receita();
        receitaCappuccino.adicionarIngrediente(itemAgua);
        receitaCappuccino.adicionarIngrediente(itemCafe);
        receitaCappuccino.adicionarIngrediente(itemLeite);
        receitaCappuccino.adicionarIngrediente(itemChocolate);
        receitaCappuccino.adicionarIngrediente(itemAcucar);
        Opcao cappuccino = new Opcao(receitaCappuccino,"Cappuccino", 3, BigDecimal.valueOf(2) );

        Receita receitaCha = new Receita();
        receitaCha.adicionarIngrediente(itemAgua);
        receitaCha.adicionarIngrediente(itemCha);
        receitaCha.adicionarIngrediente(itemAcucar);
        Opcao cha = new Opcao(receitaCha, "Chá", 4,new BigDecimal(1));

        Receita receitaAgua = new Receita();
        receitaAgua.adicionarIngrediente(itemAgua);
        Opcao agua = new Opcao(receitaAgua,"Água", 5, new BigDecimal(0));

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
