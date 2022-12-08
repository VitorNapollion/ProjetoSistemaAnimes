package br.ufpb.anime;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CadastraAnimeController implements ActionListener{
    private SistemaAnimesInterface sistemaAnime;
    private JFrame janelaPrincipal;

    public CadastraAnimeController(SistemaAnimesInterface sistemaAnime, JFrame janela){
        this.sistemaAnime = sistemaAnime;
        this.janelaPrincipal = janela;

    }
    @Override
    public void actionPerformed(ActionEvent e){
        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do Anime?").toUpperCase();
        String categoria = JOptionPane.showInputDialog(janelaPrincipal, "Qual a categoria do Anime?").toUpperCase();
        int episodios = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Quantos episódios tem o anime?"));
        boolean cadastrou = sistemaAnime.cadastraAnime(nome,categoria,episodios);

        if(cadastrou){
            JOptionPane.showMessageDialog(janelaPrincipal, "Anime cadastrado com sucesso");
        } else{
            JOptionPane.showMessageDialog(janelaPrincipal, "Anime não foi cadastrado. Pois já existe esse Anime no Sistema");
        }
    }
}