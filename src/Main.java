import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
 import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean finalizar = false;
        System.out.println("------ BEM VINDO! ------");

        while(!finalizar){
            System.out.println("\nDigite a opção que você quer executar");
            System.out.println("1 - Adicionar novo jogador");

            String opcao2 = Main.listaMelhores.isEmpty() ?
                    "2 - Bloqueado" : "2 - Mostrar ranking dos jogadores";
            System.out.println(opcao2);

            String opcao3 = Main.listaMelhores.isEmpty() ?
                    "3 - Bloqueado" : "3 - Jogar pedra, papel, tesoura";
            System.out.println(opcao3);

            String opcao4 = Main.listaMelhores.isEmpty() ?
                    "4 - Bloqueado" : "4 - Jogar adivinhe o número";
            System.out.println(opcao4);
            System.out.println("0 - Sair");

            int opcaoEscolhida = scanner.nextInt();
            if(opcao2.equals("2 - Bloqueado") && opcaoEscolhida == 2){
                opcaoEscolhida = -1;
            } else if (opcao3.equals("3 - Bloqueado") && opcaoEscolhida == 3) {
                opcaoEscolhida = -1;
            } else if (opcao4.equals("4 - Bloqueado") && opcaoEscolhida == 4) {
                opcaoEscolhida = -1;
            }

            switch(opcaoEscolhida){
                case 1:
                    System.out.println("\n1 - Adicionar novo jogador");
                    Jogador jogador = Jogador.adicionarJogador(scanner);
                    listaMelhores.add(jogador);
                    break;
                case 2:
                    System.out.println("\n2 - Mostrar ranking dos jogadores");
                    listarJogadores(0);
                    break;
                case 3:
                    System.out.println("\n3 - Jogar pedra, papel, tesoura");
                    Jogo jogo1 = new Jogo();
                    jogo1.jogar(scanner, jogo1);
                    break;
                case 4:
                    System.out.println("\n4 - Jogar adivinhe o número");
                    System.out.println("Você quer adivinhar um número de 0 até quanto?");

                    int numMax = scanner.nextInt();
                    Jogo jogo2 = new Jogo();
                    jogo2.jogar(scanner, numMax);
                    break;
                case 0:
                    finalizar = true;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

    }

    public static List<Jogador> listaMelhores = new ArrayList<>();

    public static void listarJogadores(int modo){
        if(modo == 0 || modo == 1){
            for(int i = 0; i < listaMelhores.size(); i++){
                if(listaMelhores.size() >= 10 && i >= 10 && modo == 1){
                    break;
                }

                Jogador item = listaMelhores.get(i);
                System.out.println(item.getNome() + " - " + (i + 1));
            }
        } else if (modo == 3) {
            for(Jogador jogador : listaMelhores){
                System.out.println("[" + jogador.getIdJogador() + "] " + jogador.getNome());
            }
        }
    }

    public static boolean verificarSeExiste(String nome){
        boolean existe = false;
        for(Jogador jogador : listaMelhores){
            if(jogador.getNome().equals(nome)){
                existe = true;
                break;
            }
        }

        return existe;
    }

    public static void ajustarRanking(){
        List<Jogador> rankingAntigo = listaMelhores;
        rankingAntigo.sort(Comparator.comparing(Jogador::getPontuacao).reversed());

        listaMelhores = rankingAntigo;
        Jogo.melhorJogador = listaMelhores.get(0);
    }
}
