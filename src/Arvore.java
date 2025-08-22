public class Arvore {

    private No raiz;
    private int tamanho;

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
//
//    No root;
//
//    // Inserção
//    public void insert(int key) {
//        root = insertRec(root, null, key);
//    }
//
//    private No insertRec(No node, No parent, int key) {
//        if (node == null) {
//            No newNode = new No(key);
//            newNode.parent = parent;
//            return newNode;
//        }
//        if (key < node.key)
//            node.left = insertRec(node.left, node, key);
//        else if (key > node.key)
//            node.right = insertRec(node.right, node, key);
//        return node; // não insere duplicado
//    }
//
//    // Busca
//    public No search(int key) {
//        return searchRec(root, key);
//    }
//
//    private No searchRec(No node, int key) {
//        if (node == null || node.key == key)
//            return node;
//        if (key < node.key)
//            return searchRec(node.left, key);
//        return searchRec(node.right, key);
//    }
//
//    // Altura de um nó
//    public int height(No node) {
//        if (node == null) return -1; // árvore vazia tem altura -1
//        return 1 + Math.max(height(node.left), height(node.right));
//    }
//
//    // Profundidade de um nó (nível)
//    public int depth(No node) {
//        int d = 0;
//        while (node != null && node.parent != null) {
//            d++;
//            node = node.parent;
//        }
//        return d;
//    }
//
//    // Grau de um nó
//    public int degree(No node) {
//        if (node == null) return 0;
//        int degree = 0;
//        if (node.left != null) degree++;
//        if (node.right != null) degree++;
//        return degree;
//    }
//
//    // Grau máximo da árvore
//    public int maxDegree(No node) {
//        if (node == null) return 0;
//        int current = degree(node);
//        int left = maxDegree(node.left);
//        int right = maxDegree(node.right);
//        return Math.max(current, Math.max(left, right));
//    }
//
//    // Recuperar subárvore
//    public No getSubtree(int key) {
//        return search(key); // retorna o nó como raiz da subárvore
//    }
//
//    // Verificar se a árvore é estritamente binária
//    public boolean isStrictlyBinary(No node) {
//        if (node == null) return true;
//        if (node.left == null && node.right == null) return true; // folha
//        if (node.left != null && node.right != null)
//            return isStrictlyBinary(node.left) && isStrictlyBinary(node.right);
//        return false; // tem apenas 1 filho
//    }
//
//    // Impressão simples in-ordem (para debug)
//    public void inorder(No node) {
//        if (node != null) {
//            inorder(node.left);
//            System.out.print(node.key + " ");
//            inorder(node.right);
