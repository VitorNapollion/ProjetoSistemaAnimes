package br.ufpb.anime;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class PesquisaAnimePeloNomeController implements ActionListener{

    private SistemaAnimesInterface sistemaAnime;
    private JFrame janelaPrincipal;

    public PesquisaAnimePeloNomeController(SistemaAnimesInterface sistemaAnime, JFrame janela){
        this.sistemaAnime = sistemaAnime;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do anime a pesquisar?").toUpperCase();
        Collection<Anime> animesNomes = sistemaAnime.pesquisaAnimePeloNome(nome);

        if (animesNomes.size() > 0) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Animes Encontrados");
            for (Anime a : animesNomes) {
                JOptionPane.showMessageDialog(janelaPrincipal, a.toString());

            }
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Não foi encontrado nenhum anime com este nome");
        }

    }

}