public class Jogador {

    private String nome;
    private int idade;
    private int pontuacao;
    private int numeroTentativa;

    public void adicionarPontos(){
        pontuacao++;
    }

    public void aperderPontos(){
        pontuacao--;
    }

    public void adicionarTentativa(){
        numeroTentativa++;
    }
}
