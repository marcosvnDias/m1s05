public class Jogador {

    private String nome;
    private int idade;
    private int pontuacao = 0;
    private int numeroTentativa = 0;

    public Jogador(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public int getPontuacao(){
        return pontuacao;
    }

    public int getNumeroTentativa(){
        return numeroTentativa;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

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
