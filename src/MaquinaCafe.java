import java.util.Optional;
import java.util.Scanner;

public class MaquinaCafe {

    Menu novoMenu;
    NivelAcucar novoNivel;
    Opcao opcaoEscolhida;

    public MaquinaCafe(Menu novoMenu){
        this.novoMenu = novoMenu;
    }

    public void mostraMenu(){
        System.out.println(this.novoMenu);
    }

    public void esperaAteAlguemSelecionarUmaOpcao(){
        System.out.print("Escolha uma opção: ");

        Scanner sc = new Scanner(System.in);
        int codigoEscolhido = sc.nextInt();
        Optional<Opcao> opcaoEscolhida = novoMenu.buscaOpcaoPorCodigo(codigoEscolhido);

        if(opcaoEscolhida.isPresent()){
            this.opcaoEscolhida = opcaoEscolhida.get();
        }else{
            System.out.println("Opção inválida!");
            esperaAteAlguemSelecionarUmaOpcao();
        }

    }

    public void mostrarNivelAcucar(){
       if (this.opcaoEscolhida.getTemAcucar()){
           System.out.println("Níveis de açúcar:");
           System.out.println("0 - Sem açúcar");
           System.out.println("1 - Quase sem ");
           System.out.println("2 - Nível 2");
           System.out.println("3 - Moderado");
           System.out.println("4 - Nível 4");
           System.out.println("5 - Nível 5");
           System.out.println("O valor do nível de açúcar padrão é moderado.");

           System.out.print("Deseja alterar?(S/N)");
           Scanner sc = new Scanner(System.in);
           String respostaMudancaNivel = sc.next();

           if(respostaMudancaNivel.equalsIgnoreCase("S")){
               System.out.println("Escolha uma opção:");
               int nivelEscolhido = sc.nextInt();
                //FIXME verifica se o nível é entre 0 e 5
               this.novoNivel= new NivelAcucar();
               this.novoNivel.nivel = nivelEscolhido;

           }else if(respostaMudancaNivel.equalsIgnoreCase("N")){
               this.novoNivel= new NivelAcucar();
           }else{
               System.out.println("Opção inválida!");
               mostrarNivelAcucar();
           }
           System.out.println("Nivel escolhido : " + this.novoNivel);
       }
    }


}
