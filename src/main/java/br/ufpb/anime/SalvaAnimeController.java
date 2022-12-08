package br.ufpb.anime;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SalvaAnimeController implements ActionListener{
    private SistemaAnimesInterface sistemaAnime;
    private GravadorDeAnimes gravador;
    private JFrame janelaPrincipal;

    public SalvaAnimeController(SistemaAnimesInterface sistemaAnime, JFrame janela, GravadorDeAnimes gravador){
        this.sistemaAnime = sistemaAnime;
        this.janelaPrincipal = janela;
        this.gravador = gravador;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            gravador.gravaAnimes(sistemaAnime.getAnimes());
            JOptionPane.showMessageDialog(janelaPrincipal, "Animes salvos com sucesso");
        } catch (IOException ioException){
            JOptionPane.showMessageDialog(janelaPrincipal, "Os Animes não foram Salvos." + ioException.getMessage());
            ioException.printStackTrace();
        }
    }
}