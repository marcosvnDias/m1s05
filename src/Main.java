import java.util.ArrayList;
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
            System.out.println("2 - Mostrar ranking dos melhores jogadores");
            System.out.println("0 - Sair");

            int opcaoEscolhida = scanner.nextInt();
            switch(opcaoEscolhida){
                case 1:
                    System.out.println("1 - Adicionar novo jogador");
                    Jogador jogador = Jogador.adicionarJogador(scanner);
                    listaMelhores.add(jogador);
                    break;
                case 2:
                    listarJogadores();
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

    public static void listarJogadores(){
        for(int i = 0; i < listaMelhores.size(); i++){
            Jogador item = listaMelhores.get(i);
            System.out.println(item.getNome() + " - " + (i + 1));

            if(listaMelhores.size() >= 10 && i == 10){
                break;
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
}
