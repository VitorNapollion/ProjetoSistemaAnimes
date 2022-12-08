package br.ufpb.anime;

import java.util.Collection;

public interface SistemaAnimesInterface {

    public boolean cadastraAnime(String nome, String categoria, int episodios);

    public Collection<Anime> pesquisaAnimePeloNome(String nome);

    public Collection<Anime> pesquisarAnimesDaCategoria(String categoria);

    public boolean atualizarAnime(String nome, int episodios);
    
    public boolean removeAnime(String nome);

    public Collection<Anime> getAnimes();
}