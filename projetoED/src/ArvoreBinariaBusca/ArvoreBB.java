package ArvoreBinariaBusca;

public class ArvoreBB<T extends Comparable> extends No<T> {

    private No<T> raiz;

    public void inserir(T chave) {
        raiz = inserir(raiz, chave);

    }

    public No<T> inserir(No<T> r, T chave) {
        if (r == null) {
            No<T> novaChave = new No<>(chave, null, null);
            return novaChave;

        }
        if (chave.compareTo(r.getChave()) < 0) {
            inserir(r.getEsq(), chave);
            return r;

        } else {
            inserir(r.getDir(), chave);
            return r;

        }
    }

    public void remover(T chave) {
        raiz = remover(raiz, chave);

    }

    public No<T> remover(No<T> r, T chave) {
        if (r == null) {
            return null;

        } else {
            if (chave.compareTo(r.getChave()) == 0) {
                T aux = sucessor(r);
                remover(sucessor(r));
                r.setChave(aux);
                return r;

            } else if (chave.compareTo(r.getChave()) < 0) {
                remover(r.getEsq(), chave);
                return r;

            } else {
                remover(r.getDir(), chave);
                return r;

            }
        }
    }

    public boolean buscar(T chave) {
        if  (buscar(raiz, chave) != null)
            return true;
        else
            return false;
    }

    public No<T> buscar(No<T> r, T chave) {
        if (r == null || chave.compareTo(r.getNome()) == 0){
            return r;
        }
        if (chave.compareTo(r.getEsq()) < 0) {
            buscar(r.getEsq(), chave);
            return r;

        } else {
            buscar(r.getDir(), chave);
            return r;

        }
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

    public String preOrdem(No<T> no) {
        if (no != null) {
            return no.getChave() + " "
                    + preOrdem(no.getEsq())
                    + preOrdem(no.getDir());
        }
        return "";
    }

    public String preOrdem() {
        return preOrdem(this.raiz);
    }

}
