import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Arvore arvore = new Arvore();

        int opt;

        do {
            System.out.println("1 - Inserir valor");
            System.out.println("2 - Exibir árvore");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção:");
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("Insira um valor: ");
                    arvore.inserir(sc.nextInt());
                    System.out.println("Valor inserido");
                    break;
                case 2:
                    arvore.exibirElementos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;

            }
        } while (opt != 0);
    }
}