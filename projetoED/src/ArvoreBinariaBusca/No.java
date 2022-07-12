package ArvoreBinariaBusca;

import Entidades.Aluno;

public class No<T extends Comparable<T>> implements Comparable<No<T>> {

    private T chave;
    private No<T> esq;
    private No<T> dir;

    public No() {

    }

    public No(T chave) {
        this.chave = chave;
    }

    public No(T chave, No<T> esq, No<T> dir) {
        this.chave = chave;
        this.esq = esq;
        this.dir = dir;
    }

    public T getChave() {
        return chave;
    }

    public void setChave(T chave) {
        this.chave = chave;
    }

    public No<T> getEsq() {
        return esq;
    }

    public void setEsq(No<T> esq) {
        this.esq = esq;
    }

    public No<T> getDir() {
        return dir;
    }

    public void setDir(No<T> dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return  chave + "\n";

    }

    @Override
    public int compareTo(No<T> o) {
        return this.getChave().compareTo(o.getChave());
    }
}
