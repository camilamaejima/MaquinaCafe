public class NivelAcucar {
    int nivel = 3;

    public void alterarNivel(int quantidade){
        if(quantidade >= 0 && quantidade <= 5){
            this.nivel = quantidade;
        }
    }

    public int mostraNivelAcucar(){
        return this.nivel;
    }


}
