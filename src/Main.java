import java.math.BigDecimal;


public class Main {

    public static void main(String[] args){

        Menu menuNovo = new Menu();

        Opcao cafe = new Opcao();
        cafe.setDescricao("Café");
        cafe.setValor(new BigDecimal(1));
        cafe.setCodigo(1);
        cafe.setTemAcucar(true);

        Opcao cafeLeite = new Opcao();
        cafeLeite.setDescricao("Café com Leite");
        cafeLeite.setValor(new BigDecimal(1.50));
        cafeLeite.setCodigo(2);
        cafeLeite.setTemAcucar(true);

        Opcao cappuccino = new Opcao();
        cappuccino.setDescricao("Cappuccino");
        cappuccino.setValor(BigDecimal.valueOf(1.50));
        cappuccino.setCodigo(3);
        cappuccino.setTemAcucar(true);

        Opcao cha = new Opcao();
        cha.setDescricao("Chá");
        cha.setValor(new BigDecimal(1));
        cha.setCodigo(4);
        cha.setTemAcucar(true);

        Opcao agua = new Opcao();
        agua.setDescricao("Água");
        agua.setValor(new BigDecimal(0));
        agua.setCodigo(5);
        agua.setTemAcucar(false);

        menuNovo.adicionarOpcao(cafe);
        menuNovo.adicionarOpcao(cafeLeite);
        menuNovo.adicionarOpcao(cappuccino);
        menuNovo.adicionarOpcao(cha);
        menuNovo.adicionarOpcao(agua);

        MaquinaCafe maquinaCafe = new MaquinaCafe(menuNovo);

        maquinaCafe.mostraMenu();
        maquinaCafe.esperaAteAlguemSelecionarUmaOpcao();

        maquinaCafe.mostrarNivelAcucar();

        /*
        maquinaCafe.esperaAteAlguemSelecionarUmaOpcao();
        maquinaCafe.mostrarNivelAcucar();
        maquinaCafe.esperaAteAlguemAlterarOuDizerQueNaoQuerAlterar();
        maquinaCafe.mostraPreco();
        maquinaCafe.cobrar();
        maquinaCafe.preparar();

        /*
        Opcao cafe = new Opcao();
        cafe.setDescricao("Café");
        cafe.setValor(new BigDecimal(1));
        cafe.setCodigo(1);

        Opcao cafeLeite = new Opcao();
        cafeLeite.setDescricao("Café com Leite");
        cafeLeite.setValor(new BigDecimal(1.50));
        cafeLeite.setCodigo(2);

        Opcao cappuccino = new Opcao();
        cappuccino.setDescricao("Cappuccino");
        cappuccino.setValor(BigDecimal.valueOf(1.50));
        cappuccino.setCodigo(3);

        Opcao cha = new Opcao();
        cha.setDescricao("Chá");
        cha.setValor(new BigDecimal(1));
        cha.setCodigo(4);

        Opcao agua = new Opcao();
        agua.setDescricao("Água");
        agua.setValor(new BigDecimal(0));
        agua.setCodigo(5);

        Menu menuOpcoes = new Menu();
        menuOpcoes.adicionarOpcao(cafe);
        menuOpcoes.adicionarOpcao(cafeLeite);
        menuOpcoes.adicionarOpcao(cappuccino);
        menuOpcoes.adicionarOpcao(cha);
        menuOpcoes.adicionarOpcao(agua);

        System.out.println(menuOpcoes);
        System.out.print("Escolha uma opção: ");

        Scanner sc = new Scanner(System.in);
        int opcaoEscolhida = sc.nextInt();

        if(opcaoEscolhida != 1 && opcaoEscolhida != 2 && opcaoEscolhida != 3 && opcaoEscolhida != 4 && opcaoEscolhida != 5){
            System.out.println("Opção inválida!");
        }else{
            System.out.println("Seu nível de açúcar é 3, se quiser alterar informe um novo nível: ");
            System.out.println("0 - Sem açúcar");
            System.out.println("1 - Nível 1");
            System.out.println("2 - Nível 2");
            System.out.println("3 - Nível 3");
            System.out.println("4 - Nível 4");
            System.out.println("5 - Nível 5");
            System.out.print("Escolha ");
        }

*/
    }
}
