import java.math.BigDecimal;
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
        System.out.println("Máquina de café - Menu");
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

           System.out.print("Deseja alterar?(S/N)");
           Scanner sc = new Scanner(System.in);
           String respostaMudancaNivel = sc.next();

           if(respostaMudancaNivel.equalsIgnoreCase("S")){
               System.out.println("Níveis de açúcar:");
               System.out.println("0 - Sem açúcar");
               System.out.println("1 - Quase sem ");
               System.out.println("2 - Quase moderado");
               System.out.println("3 - Moderado");
               System.out.println("4 - Mais que moderado");
               System.out.println("5 - Bem doce");
               System.out.println("O valor do nível de açúcar padrão é moderado.");
               System.out.print("Escolha uma opção:");
               int nivelEscolhido = sc.nextInt();
               if(nivelEscolhido <0 || nivelEscolhido > 5){
                   System.out.println("Opção inválida!");
                   mostrarNivelAcucar();
               }else{
                   this.novoNivel= new NivelAcucar();
                   this.novoNivel.nivel = nivelEscolhido;
               }

           }else if(respostaMudancaNivel.equalsIgnoreCase("N")){
               this.novoNivel= new NivelAcucar();
           }else{
               System.out.println("Opção inválida!");
               mostrarNivelAcucar();
           }
       }
    }

    public void mostrarPreco(){
        if(opcaoEscolhida.getCodigo() != 5){
            System.out.println("O valor do seu pedido é : " + opcaoEscolhida.getValor() );
        }
    }

    public void cobrar(){
        if(opcaoEscolhida.getCodigo() != 5){
            System.out.print("Digite o valor em dinheiro para pagamento:");
            Scanner sc = new Scanner(System.in);
            BigDecimal valorPagamento = sc.nextBigDecimal();

            if(valorPagamento.compareTo(opcaoEscolhida.getValor()) < 0){
                System.out.println("O valor inserido é mais baixo que o valor do pedido!");
                cobrar();
            }else{
                System.out.println("O seu troco é : " + valorPagamento.subtract(opcaoEscolhida.getValor()));
            }
        }
    }

    public void preparar(){
        System.out.println(opcaoEscolhida.getModoPreparo());
        System.out.println("Está pronto o seu pedido!");
    }

}
