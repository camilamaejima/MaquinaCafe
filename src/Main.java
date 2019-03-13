import java.math.BigDecimal;


public class Main {

    public static void main(String[] args){

        Menu menuNovo = new Menu();

        Opcao cafe = new Opcao();
        cafe.setDescricao("Café");
        cafe.setValor(new BigDecimal(1));
        cafe.setCodigo(1);
        cafe.setTemAcucar(true);
        cafe.setModoPreparo("Esquentando a água, passando a água pelo pó de café, café saindo na xícara.");

        Opcao cafeLeite = new Opcao();
        cafeLeite.setDescricao("Café com Leite");
        cafeLeite.setValor(new BigDecimal(1.50));
        cafeLeite.setCodigo(2);
        cafeLeite.setTemAcucar(true);
        cafeLeite.setModoPreparo("Esquentando a água, passando a água pelo pó de café e adicionando leite, café com leite saindo na xícara.");

        Opcao cappuccino = new Opcao();
        cappuccino.setDescricao("Cappuccino");
        cappuccino.setValor(BigDecimal.valueOf(1.50));
        cappuccino.setCodigo(3);
        cappuccino.setTemAcucar(true);
        cappuccino.setModoPreparo("Esquentando a água, passando a água pelo pó de café, adicionando leite e chocolate, cappuccino saindo na xícara.");

        Opcao cha = new Opcao();
        cha.setDescricao("Chá");
        cha.setValor(new BigDecimal(1));
        cha.setCodigo(4);
        cha.setTemAcucar(true);
        cha.setModoPreparo("Esquentando a água, passando a água pela essência, chá saindo na xícara.");


        Opcao agua = new Opcao();
        agua.setDescricao("Água");
        agua.setValor(new BigDecimal(0));
        agua.setCodigo(5);
        agua.setTemAcucar(false);
        agua.setModoPreparo("Esquentando a água, água quente saindo na xícara.");

        menuNovo.adicionarOpcao(cafe);
        menuNovo.adicionarOpcao(cafeLeite);
        menuNovo.adicionarOpcao(cappuccino);
        menuNovo.adicionarOpcao(cha);
        menuNovo.adicionarOpcao(agua);

        MaquinaCafe maquinaCafe = new MaquinaCafe(menuNovo);

        maquinaCafe.mostraMenu();
        maquinaCafe.esperaAteAlguemSelecionarUmaOpcao();
        maquinaCafe.mostrarNivelAcucar();
        maquinaCafe.mostrarPreco();
        maquinaCafe.cobrar();
        maquinaCafe.preparar();

    }
}
