import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Arvore arvore = new Arvore();

        int opt;

        do {
            System.out.println("1 - Inserir valor");
            System.out.println("2 - Exibir árvore");
            System.out.println("3 - Calcula altura");
            System.out.println("4 - Calcula nível");
            System.out.println("5 - Calcula grau");
            System.out.println("6 - Calcula grau máximo");
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
                    System.out.println("------------");
                    arvore.exibirElementos();
                    System.out.println("\n------------");
                    break;
                case 3:
                    System.out.println("Altura: " + arvore.calculaAltura(arvore.getRaiz()));
                    break;
                case 4:
                    System.out.println("Nível: " + arvore.calculaNivel(arvore.getRaiz()));
                    break;
                case 5:
                    System.out.println("Escolha um valor:");
                    arvore.grauDoNo(arvore.getRaiz());
                    break;
                case 6:
                    System.out.println("Calculo de grau máximo: ");
                    arvore.grauMaximo(arvore.getRaiz());
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
            }
        } while (opt != 0);
    }
}