package br.ufpb.anime;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class PesquisaAnimePelaCategoriaController implements ActionListener {

    private SistemaAnimesInterface sistemaAnime;
    private JFrame janelaPrincipal;

    public PesquisaAnimePelaCategoriaController(SistemaAnimesInterface sistemaAnime, JFrame janela) {
        this.sistemaAnime = sistemaAnime;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String categoria = JOptionPane.showInputDialog(janelaPrincipal, "Qual a categoria a pesquisar anime?").toUpperCase();
        Collection<Anime> animesCategoria = sistemaAnime.pesquisarAnimesDaCategoria(categoria);

        if (animesCategoria.size() > 0) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Animes Encontrados");
            for (Anime a : animesCategoria) {
                JOptionPane.showMessageDialog(janelaPrincipal, a.toString());

            }
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Não foi encontrado nenhum anime com esta categoria");
        }
    }
}
