public class Arvore {

    private No raiz;
    private int tamanho;

    public void inserir(int elemento) {
        if(raiz == null) {
            raiz = new No(elemento);
            return;
        }

        No elementoAtual = raiz;
        No novoElemento = new No(elemento);

        while(true) {
            if(novoElemento.getElemento() < elementoAtual.getElemento()) {
                if(elementoAtual.getEsquerdo() == null) {
                    elementoAtual.setEsquerdo(novoElemento);
                    return;
                } else {
                    elementoAtual = elementoAtual.getEsquerdo();
                }
            }
            if(novoElemento.getElemento() >= elementoAtual.getElemento()){
                if(elementoAtual.getDireito() == null) {
                    elementoAtual.setDireito(novoElemento);
                    return;
                } else {
                    elementoAtual = elementoAtual.getDireito();
                }
            }
        }
    }

    public void exibirElementos() {
        exibirRecursivo(raiz);
    }

    public void exibirRecursivo(No raiz) {
        if (raiz != null) {
            System.out.println(raiz.getElemento());
            exibirRecursivo(raiz.getEsquerdo());
            exibirRecursivo(raiz.getDireito());
        }
    }

}
