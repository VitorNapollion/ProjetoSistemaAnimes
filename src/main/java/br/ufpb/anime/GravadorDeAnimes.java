package br.ufpb.anime;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class GravadorDeAnimes {

    private String fileName = "animes.txt";

    public void gravaAnimes(Collection<Anime> animes) throws IOException {
        ObjectOutputStream gravador = null;
        try {
            gravador = new ObjectOutputStream(new FileOutputStream(fileName));
            ArrayList<Anime> animesASalvar = new ArrayList<>(animes);
            gravador.writeObject(animesASalvar);
        } finally {
            if (gravador!=null){
                gravador.close();
            }
        }

    }

    public Collection<Anime> recuperaAnimes() throws IOException, ClassNotFoundException {
        ObjectInputStream leitor = null;
        try {
            leitor = new ObjectInputStream(new FileInputStream(fileName));
            Collection<Anime> animesLidos = (Collection<Anime>) leitor.readObject();
            return animesLidos;
        } finally {
            if (leitor!=null){
                leitor.close();
            }
        }
    }
}