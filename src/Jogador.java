import java.util.List;
import java.util.Scanner;

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

    public static Jogador adicionarJogador(Scanner scanner){
        System.out.print("Nome do jogador");
        String nome = scanner.nextLine();

        boolean existe = Main.verificarSeExiste(nome);
        while(existe){
            System.out.println("Nome já existe, tente outro nome.");
            System.out.print("Nome do jogador: ");
            String novoNome = scanner.nextLine();

            existe = Main.verificarSeExiste(novoNome);
        }

        System.out.print("Idade do jogador");
        int idade = scanner.nextInt();

        return new Jogador(nome, idade);
    }
}
