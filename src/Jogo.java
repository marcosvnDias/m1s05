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

    public void jogar(Scanner scanner, int num) {
        boolean finalizar = false;
        Jogador jogador = logar(scanner);

        while(!finalizar){
            System.out.println("\nDigite um número de 0 a " + num);
            int opcaoEscolhida = scanner.nextInt();

            Random random = new Random();
            int numSorteado = random.nextInt(num + 1);

            if(opcaoEscolhida == numSorteado){
                System.out.println("O número era " + numSorteado);
                System.out.println("PARABÉNS! Você ganhou");

                jogador.adicionarPontos();
                setNumeroJogadas(1);
                jogador.adicionarTentativa();
            } else {
                System.out.println("O número era " + numSorteado);
                System.out.println("Você perdeu");

                jogador.perderPontos();
                setNumeroJogadas(1);
                jogador.adicionarTentativa();
            }

            String sairJogo = menu(scanner);
            if(sairJogo.equals("sim")){
                finalizar = true;
            }
        }
    }

    public Jogador logar(Scanner scanner){
        System.out.println("Digite o número do jogador que você quer logar");
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

    public String menu(Scanner scanner){
        boolean finalizar = false;
        String sairJogo = "";

        while(!finalizar){
            System.out.println("\nDigite a opção que você quer executar");
            System.out.println("1 - Ver ranking completo");
            System.out.println("2 - Ver top 10");
            System.out.println("3 - Jogar novamente");
            System.out.println("4 - Encerrar o Jogo");

            int opcaoEscolhida = scanner.nextInt();
            switch(opcaoEscolhida){
                case 1:
                    System.out.println("\n1 - Ver ranking completo");
                    System.out.println("Ranking:");

                    Main.ajustarRanking();
                    Main.listarJogadores(0);
                    break;
                case 2:
                    System.out.println("\n2 - Ver top 10");
                    System.out.println("\nRanking:");

                    Main.ajustarRanking();
                    Main.listarJogadores(1);
                    break;
                case 3:
                    System.out.println("\n3 - Jogar novamente");
                    sairJogo = "não";
                    finalizar = true;
                    break;
                case 4:
                    sairJogo = "sim";
                    finalizar = true;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

        return sairJogo;
    }

}
