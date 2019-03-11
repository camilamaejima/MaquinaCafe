import java.math.BigDecimal;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

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

        System.out.println("Selecione uma opção: ");
        System.out.println(menuOpcoes);

    }
}
