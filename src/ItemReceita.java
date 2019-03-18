public class ItemReceita {

    private String nomeIngrediente;
    private String comportamento;
    private int quantidade;
    private int codigoItem;

    public ItemReceita(String nomeIngrediente, String comportamento, int codigoItem){
        this.nomeIngrediente = nomeIngrediente;
        this.comportamento = comportamento;
        this.codigoItem = codigoItem;
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomeIngrediente() {
        return nomeIngrediente;
    }

    public String getComportamento() {
        return comportamento;
    }

}
