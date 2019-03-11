import java.util.ArrayList;
import java.util.List;

public class Menu {

    List<Opcao> listaOpcoes = new ArrayList<>();

    public String toString(){
        listaOpcoes.forEach((opcao) ->{
            opcao.toString();
        });
        return "";
    }

    public void adicionarOpcao(Opcao opcaoLista){
        listaOpcoes.add(opcaoLista);
    }

}
