package br.ufpb.anime;

import java.io.Serializable;

public class Anime implements Serializable {

    private String nome;
    private String categoria;
    private int episodios;

    public Anime(String nome, String categoria, int episodios) {
        this.nome = nome;
        this.categoria = categoria;
        this.episodios = episodios;
    }

    public Anime() {
        this("", "", 0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    @Override
    public String toString() {
        return "Anime de nome: " + this.nome + ", de categoria: " + this.categoria + " e com " + this.episodios + " episódios";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Anime other = (Anime) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

}