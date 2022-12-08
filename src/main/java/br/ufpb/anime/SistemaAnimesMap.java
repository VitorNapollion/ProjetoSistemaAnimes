package br.ufpb.anime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SistemaAnimesMap implements SistemaAnimesInterface{

    private Map<String, Anime> animes;

    public SistemaAnimesMap() {
         this.animes = new HashMap<>();
    }

    public Collection<Anime> getAnimes(){
        return this.animes.values();
    }

    @Override
    public boolean cadastraAnime(String nome, String categoria, int episodios){
        if(!animes.containsKey(nome)){
            this.animes.put(nome, new Anime(nome, categoria, episodios));
            return true;
        } else{
            return false;
        }

    }

    @Override
    public Collection<Anime> pesquisaAnimePeloNome(String nome){
        Collection<Anime> animesAchados = new ArrayList<>();
        for(Anime a: this.animes.values()){
            if(a.getNome().equals(nome)){
                animesAchados.add(a);
            }
        }
        return animesAchados;
    }

    @Override
    public Collection<Anime> pesquisarAnimesDaCategoria(String categoria){
        Collection<Anime> listaAnimesDaCategoria = new ArrayList<>();
        for(Anime a: this.animes.values()){
            if(a.getCategoria().equals(categoria)){ 
                listaAnimesDaCategoria.add(a);
            }
        }
        return listaAnimesDaCategoria;
    }

    @Override
    public boolean atualizarAnime (String nome, int episodios) {
        Anime a = this.animes.get(nome);
        if(!animes.containsKey(nome)) {
            return false;
        } else {
            if (nome.isEmpty() || episodios == 0) {
                return false;
            } else {
                a.setEpisodios(episodios);
                return true;
            }
        }
    }

    @Override
    public boolean removeAnime(String nome){
        if(this.animes.containsKey(nome)){
            this.animes.remove(nome);
            return true;
        } else{
            return false;
        }
        
    }

}   