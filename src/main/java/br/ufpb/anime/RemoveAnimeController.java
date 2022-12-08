package br.ufpb.anime;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveAnimeController implements ActionListener{

    private SistemaAnimesInterface sistemaAnime;
    private JFrame janelaPrincipal;

    public RemoveAnimeController(SistemaAnimesInterface sistemaAnime, JFrame janela){
        this.sistemaAnime = sistemaAnime;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do anime a remover").toUpperCase();
        boolean removeu = sistemaAnime.removeAnime(nome);

        if(removeu){
            JOptionPane.showMessageDialog(janelaPrincipal, "Anime removido com sucesso");
        } else{
            JOptionPane.showMessageDialog(janelaPrincipal, "Anime não foi encontrado. Operação não realizada");
        }

    }

}