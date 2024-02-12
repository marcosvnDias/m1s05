import java.util.Random;
import java.util.Scanner;

public class Jogo {
    public static Jogador melhorJogador = null;
    private int numeroJogadas = 0;

    public int getNumeroJogadas(){
        return numeroJogadas;
    }

    public void setNumeroJogadas(int numeroJogadas){
        this.numeroJogadas = numeroJogadas;
    }

    public void jogar(Scanner scanner, Jogo jogo){
        boolean finalizar = false;
        String[] opcoesDeJogadas = {"pedra", "papel", "tesoura"};
        Jogador jogador = logar(scanner);

        while(!finalizar){
            System.out.println("\nDigite o número da opção que você quer usar");

            System.out.println("0 - Pedra");
            System.out.println("1 - Papel");
            System.out.println("2 - Tesoura");

            int opcaoEscolhida = scanner.nextInt();
            String jogadaPlayer = opcoesDeJogadas[opcaoEscolhida];

            Random random = new Random();
            String jogadaSistema = opcoesDeJogadas[random.nextInt(3)];

            if(jogadaPlayer.equals(jogadaSistema)){
                System.out.println("\nVocê jogou " + jogadaPlayer + " e o sistema jogou " + jogadaSistema);
                System.out.println("Deu empate, jogue novamente");
                jogo.setNumeroJogadas(this.getNumeroJogadas());
            } else if (jogadaPlayer.equals("pedra") && jogadaSistema.equals("tesoura") || jogadaPlayer.equals("tesoura") && jogadaSistema.equals("papel") || jogadaPlayer.equals("papel") && jogadaSistema.equals("pedra")) {
                System.out.println("\nVocê jogou " + jogadaPlayer + " e o sistema jogou " + jogadaSistema);
                System.out.println("PARABÉNS! Você ganhou");

                jogador.adicionarPontos();
                setNumeroJogadas(1);
                jogador.adicionarTentativa();
            } else {
                System.out.println("\nVocê jogou " + jogadaPlayer + " e o sistema jogou " + jogadaSistema);
                System.out.println("Você perdeu");

                jogador.perderPontos();
                setNumeroJogadas(1);
                jogador.adicionarTentativa();
            }

            System.out.println("\nRanking:");
            Main.ajustarRanking();
            Main.listarJogadores(0);

            System.out.println("\nCaso não deseje jogar novamente digite sim");
            String resposta = scanner.next();

            if(resposta.equals("sim")){
                finalizar = true;
            }
        }

    }

    public Jogador logar(Scanner scanner){
        System.out.println("Digite o número da posição do jogar que você quer logar");
        Main.listarJogadores(3);

        int jogadorId = scanner.nextInt();
        Jogador jogadorEscolhido = null;
        for(Jogador jogador : Main.listaMelhores){
            if(jogador.getIdJogador() == jogadorId){
                jogadorEscolhido = jogador;
            }
        }

        return jogadorEscolhido;
    }

}