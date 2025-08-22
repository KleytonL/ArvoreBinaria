public class Arvore {

    private No raiz;

    public void inserir(int elemento) {
        if (raiz == null) {
            raiz = new No(elemento);
            return;
        }

        No elementoAtual = raiz;
        No novoElemento = new No(elemento);

        while (true) {
            if (novoElemento.getElemento() < elementoAtual.getElemento()) {
                if (elementoAtual.getEsquerdo() == null) {
                    elementoAtual.setEsquerdo(novoElemento);
                    return;
                } else {
                    elementoAtual = elementoAtual.getEsquerdo();
                }
            }
            if (novoElemento.getElemento() >= elementoAtual.getElemento()) {
                if (elementoAtual.getDireito() == null) {
                    elementoAtual.setDireito(novoElemento);
                    return;
                } else {
                    elementoAtual = elementoAtual.getDireito();
                }
            }
        }
    }

    public No buscar(int valor) {
        return buscaRecursiva(raiz, valor);
    }

    private No buscaRecursiva(No raiz, int valor) {
        if (raiz == null || raiz.getElemento() == valor) {
            return raiz;
        }
        if (valor < raiz.getElemento()) {
            return buscaRecursiva(raiz.getEsquerdo(), valor);
        }
        return buscaRecursiva(raiz.getDireito(), valor);
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

    public int grauDoNo(No raiz) {
        if (raiz == null) return 0;
        int grau = 0;
        if (raiz.getEsquerdo() != null) grau++;
        if (raiz.getDireito() != null) grau++;
        return grau;
    }

    public int grauMaximo(No raiz) {
        if (raiz == null) return 0;
        int atual = grauDoNo(raiz);
        int esquerdo = grauMaximo(raiz.getEsquerdo());
        int direito = grauMaximo(raiz.getDireito());
        return Math.max(atual, Math.max(esquerdo, direito));
    }

    public No retornarSubarvore(int valor) {
        return buscar(valor);
    }

    public boolean estritamenteBinaria(No raiz) {
        if (raiz == null) return true;
        if (raiz.getEsquerdo() == null && raiz.getDireito() == null) return true;
        if (raiz.getEsquerdo() != null && raiz.getDireito() != null) {
            return estritamenteBinaria(raiz.getEsquerdo()) && estritamenteBinaria(raiz.getDireito());
        }
        return false;
    }
}