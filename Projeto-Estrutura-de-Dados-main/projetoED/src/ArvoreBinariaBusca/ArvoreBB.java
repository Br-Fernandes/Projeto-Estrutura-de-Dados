package ArvoreBinariaBusca;

public class ArvoreBB<T extends Comparable<T>> extends No<T> {

    private No<T> raiz;

    public ArvoreBB(T... args){
        for(T item : args){
            inserir(item);
        }
    }

    public void inserir(T item) {
        No<T> novo = new No<>(item);
        if (raiz == null)
            raiz = novo;
        else {
            No<T> noAtual = raiz;
            while (noAtual != null) {
                System.out.println(contem(item));
                if (noAtual.getEsq() == null || noAtual.getDir() == null) {
                    if (novo.compareTo(noAtual) > 0 && noAtual.getDir() == null && !contem(item)) {
                        noAtual.setDir(novo);
                        break;

                    } else if (novo.compareTo(noAtual) < 0 && noAtual.getEsq() == null && !contem(item)) {
                        noAtual.setEsq(novo);
                        break;
                    }
                }

                if (noAtual.compareTo(novo) > 0)
                    novo = novo.getDir();
                else
                    novo = novo.getEsq();

            }
        }
    }

    public void inserir2(T valor) {
        raiz = inserir2(raiz, valor);
    }

    public No<T> inserir2(No<T> r, T item) {
        if (r == null) {
            No<T> novo = new No<>(item, null, null);
            System.out.println("Add raiz");
            return novo;

        } else if (r.getChave().compareTo(item) > 0) {
            r.setEsq(inserir2(r.getEsq(), item));
            System.out.println("Indo pra esquerda");
            return r;

        } else {
            r.setDir(inserir2(r.getDir(), item));
            System.out.println("Indo pra direita");
            return r;

        }
    }

    public boolean remover(T chave) {
        return remover(raiz, chave) != null;

    }

    public No<T> remover(No<T> r, T chave) {
        if (r == null) {
            System.out.println("pilha vazia");
            return r;

        } else {
            if (chave.compareTo(r.getChave()) == 0) {
                if (r.getEsq() == null && r.getDir() == null) {
                    r = null;

                } else if (r.getEsq() != null && r.getDir() != null) {
                    T aux = sucessor(r);
                    remover(sucessor(r));
                    r.setChave(aux);

                } else if (r.getEsq() != null && r.getDir() == null) {
                    r = r.getEsq();

                } else if (r.getEsq() == null && r.getDir() != null) {
                    r = r.getDir();

                }

            } else if (chave.compareTo(r.getChave()) < 0) {
                r.setEsq(remover(r.getEsq(), chave));
                return r;

            } else {
                r.setDir(remover(r.getDir(), chave));
                return r;

            }
        }
        return r;
    }

    public boolean contem(T chave) {
        No<T> noAtual = raiz;
        while (noAtual != null) {
            if (noAtual.getChave().compareTo(chave) < 0)
                noAtual = noAtual.getDir();
            else if (noAtual.getChave().compareTo(chave) > 0)
                noAtual = noAtual.getEsq();
            else
                return true;
        }
        return false;

    }

    public No<T> buscar(No<T> r, T chave) {
        No<T> noAtual = r;
        while (noAtual.getChave().compareTo(chave) != 0) {
            if (chave.compareTo(noAtual.getChave()) > 0) {
                noAtual = noAtual.getDir();

            } else {
                noAtual = noAtual.getEsq();

            }
        }
        return (noAtual);
    }

    public T minimo(No<T> r) {
        if (r == null) {
            return null;

        }
        if (r.getEsq() == null) {
            return r.getChave();

        } else {
            return minimo(r.getEsq());

        }
    }

    public T sucessor(No<T> r) {
        return minimo(r.getDir());

    }

    public String inOrdem() {
        return inOrdem(this.raiz);
    }

    public String inOrdem(No<T> no) {
        if (no != null) {
            return inOrdem(no.getEsq())
                    + no.getChave() + " "
                    + inOrdem(no.getDir());
        }
        return "";
    }

    public No<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(No<T> raiz) {
        this.raiz = raiz;
    }
}
