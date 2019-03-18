import java.util.ArrayList;
import java.util.List;

public class Receita {
    List<ItemReceita> listaItens = new ArrayList<>();

    public void adicionarIngrediente(ItemReceita novoItem){
        listaItens.add(novoItem);
    }

    @Override
    public String toString(){


        listaItens.forEach((item) ->{

            if(item.getCodigoItem() == 6 && item.getQuantidade() == 0) {
                System.out.println("Sem açúcar!");

            }else{
                System.out.println(item.getComportamento() + " - "
                        + item.getNomeIngrediente()
                        + (item.getQuantidade() != 0 ? " - " + item.getQuantidade() : ""));
            }

        });

        return "";
    }



}

