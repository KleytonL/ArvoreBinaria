public class Arvore {

    private No raiz;

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
            System.out.print(raiz.getElemento() + " ");
            exibirRecursivo(raiz.getEsquerdo());
            exibirRecursivo(raiz.getDireito());
        }
    }

    public int calculaAltura(No raiz) {
        if(raiz == null) return -1;
        return altura(raiz);
    }

    public int altura(No raiz) {
        if (raiz == null) return -1;
        return 1 + Math.max(altura(raiz.getEsquerdo()), altura(raiz.getDireito()));
    }

    public int calculaNivel(No raiz) {
        int nivel = 0;
        No atual = raiz;
        while(atual != null) {
            if(raiz.getElemento() == atual.getElemento()) return nivel;
            atual = (raiz.getElemento() < atual.getElemento()) ? atual.getEsquerdo() : atual.getDireito();
            nivel++;
        }
        return -1;
    }

    public int calculaGrau(No raiz) {
        if(raiz == null) return -1;
        int grau = 0;
        if(raiz.getEsquerdo() != null) grau++;
        if(raiz.getDireito() != null) grau++;
        return grau;
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }
}
