package br.ufpb.anime;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtualizaAnimeController implements ActionListener{

    private SistemaAnimesInterface sistemaAnime;
    private JFrame janelaPrincipal;

    public AtualizaAnimeController(SistemaAnimesInterface sistemaAnime, JFrame janela){
        this.sistemaAnime = sistemaAnime;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do anime: ").toUpperCase();
        int episodios = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual a nova quantidade de episodios: "));
        boolean atualizou = sistemaAnime.atualizarAnime(nome, episodios);
        if(atualizou){
            JOptionPane.showMessageDialog(janelaPrincipal, "Anime atualizou com sucesso");
        } else{
            JOptionPane.showMessageDialog(janelaPrincipal, "Anime não foi encontrado. Operação não realizada");
        }

    }

}