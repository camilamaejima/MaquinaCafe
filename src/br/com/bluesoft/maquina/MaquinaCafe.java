package br.com.bluesoft.maquina;

import br.com.bluesoft.maquina.estoque.Estoque;
import br.com.bluesoft.maquina.estoque.ItemEstoque;
import br.com.bluesoft.maquina.menu.Menu;
import br.com.bluesoft.maquina.menu.Opcao;
import br.com.bluesoft.maquina.receita.ItemReceita;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

public class MaquinaCafe {

    Menu novoMenu;
    Opcao opcaoEscolhida;
    Estoque novoEstoque;

    public void confereEstoque(){

        for (ItemReceita listaItem : opcaoEscolhida.novaReceita.listaItens) {
            boolean temEstoque;
            int codigoItemReceita = listaItem.getCodigoItem();
            int quantidadeReceita = listaItem.getQuantidade();
            temEstoque = novoEstoque.verificaQuantidade(codigoItemReceita, quantidadeReceita);
            if(!temEstoque){
                throw new RuntimeException("Não há ingrediente(s) suficiente(s) para o pedido!");
            }
        }
    }

    public void retiraItemEstoque(){
        for (ItemReceita listaItem : opcaoEscolhida.novaReceita.listaItens) {
            int codigoItemReceita = listaItem.getCodigoItem();
            int quantidadeReceita = listaItem.getQuantidade();
            novoEstoque.removerQuantidadeEstoque(quantidadeReceita, codigoItemReceita);
        }
    }

    public void ligaMaquina(){
        System.out.print("Deseja ligar a máquina (S/N) ? ");
        Scanner sc = new Scanner(System.in);
        String resposta = sc.next();
        if(resposta.equalsIgnoreCase("n")){
            System.out.println("Máquina desligada.");
            System.exit(0);
        }else if(!resposta.equalsIgnoreCase("s")){
            System.out.println("Opção inválida!");
            ligaMaquina();
        }
    }

    public boolean desligaMaquina(){
        System.out.print("Deseja desligar a máquina (S/N) ? ");
        Scanner sc = new Scanner(System.in);
        String resposta = sc.next();
        if(resposta.equalsIgnoreCase("s")){
            System.out.println("Máquina desligada.");
            return false;
        }else if(resposta.equalsIgnoreCase("n")){
            return true;
        }else{
            System.out.println("Opção inválida");
            desligaMaquina();
        }
        return true;
    }

    public MaquinaCafe(Menu novoMenu, Estoque novoEstoque){
        this.novoMenu = novoMenu;
        this.novoEstoque = novoEstoque;
    }

    public void iniciaMaquina(){
        System.out.print("Máquina de Café - sem estoque de ingredientes, deseja inserir ingredientes (S/N) ? ");
        Scanner sc = new Scanner(System.in);
        String resposta = sc.next();

        if(resposta.equalsIgnoreCase("n")){
            iniciaMaquina();
        }
    }

    public void inserirEstoque(){
        for (ItemEstoque listaItem : novoEstoque.listaItens) {
            System.out.print("Insira o valor de estoque para " + listaItem.getNomeItem() +" : ");
            Scanner sc = new Scanner(System.in);
            int valorEstoque = sc.nextInt();
            listaItem.setQuantidadeEstoque(valorEstoque);
        }
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

    public void alterarNivelAcucar(){
        for (ItemReceita listaItem : this.opcaoEscolhida.novaReceita.listaItens) {
            int codigoItem = listaItem.getCodigoItem();
            if(codigoItem == 5){
                int novoNivel = mostrarOpcoesAcucar();
                if(novoNivel >= 0){
                    listaItem.setQuantidade(novoNivel);
                }
            }
        }
        confereEstoque();
    }

    public int mostrarOpcoesAcucar(){
        int nivelEscolhido = -1;
        System.out.println("O valor do nível de açúcar padrão é moderado.");
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
            System.out.print("Escolha uma opção:");
            nivelEscolhido = sc.nextInt();
            if(nivelEscolhido < 0 || nivelEscolhido > 5){
                System.out.println("Opção inválida!");
                mostrarOpcoesAcucar();
            }
        }else if(!respostaMudancaNivel.equalsIgnoreCase("N")){
            System.out.println("Opção inválida!");
            mostrarOpcoesAcucar();
        }
        return nivelEscolhido;
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
        System.out.println("MODO DE PREPARO");
        opcaoEscolhida.novaReceita.toString();
        System.out.println("ESTÁ PRONTO O SEU PEDIDO!");
    }

}
