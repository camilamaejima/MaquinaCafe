import java.math.BigDecimal;

public class Opcao {

    private BigDecimal valor;
    private String descricao;
    private int codigo;
    Receita novaReceita;

    public Opcao(Receita novaReceita, String descricao, int codigo, BigDecimal valor ){
        this.novaReceita = novaReceita;
        this.descricao = descricao;
        this.codigo = codigo;
        this.valor = valor;

    }

    public int getCodigo() {
        return codigo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString(){
        return codigo +" - " + descricao + " - valor R$: " + valor;

    }

}
