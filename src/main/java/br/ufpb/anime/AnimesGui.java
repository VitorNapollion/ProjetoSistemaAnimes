package br.ufpb.anime;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class AnimesGui extends JFrame {
    JLabel linha1, linha2, linha3;
    ImageIcon imgPrincipal1 = new ImageIcon("src" + File.separator + "main" + File.separator + "resources" + File.separator + "imgs" + File.separator + "imgPrincipal1.png");
    ImageIcon imgPrincipal2 = new ImageIcon("src" + File.separator + "main" + File.separator + "resources" + File.separator + "imgs" + File.separator + "imgPrincipal2.png");
    ImageIcon imgPrincipal3 = new ImageIcon("src" + File.separator + "main" + File.separator + "resources" + File.separator + "imgs" + File.separator + "imgPrincipal3.png");
    ImageIcon addImg = new ImageIcon("src" + File.separator + "main" + File.separator + "resources" + File.separator + "imgs" + File.separator + "cadastra.png");
    ImageIcon pesqImg = new ImageIcon("src" + File.separator + "main" + File.separator + "resources" + File.separator + "imgs" + File.separator + "pesquisa.png");
    ImageIcon removeImg = new ImageIcon("src" + File.separator + "main" + File.separator + "resources" + File.separator + "imgs" + File.separator + "remove.png");
    JButton botaoAdicionar, botaoPesquisarPeloNome, botaoPesquisarPelaCategoria, botaoRemover;
    SistemaAnimesInterface sistema = new SistemaAnimesMap();
    JMenuBar barraDeMenu = new JMenuBar();
    GravadorDeAnimes gravador = new GravadorDeAnimes();

    public AnimesGui() {

        File f = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "imgs"+ File.separator + "addImg.jpg");

        System.out.println(f.exists());
        System.out.println(f.getAbsolutePath());

        setTitle("Sistema de Animes");
        setSize(920, 670);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        Collection<Anime> animes = null;
        try {
            animes = gravador.recuperaAnimes();
            for (Anime a : animes) {
                this.sistema.cadastraAnime(a.getNome(), a.getCategoria(), a.getEpisodios());
            }
            JOptionPane.showMessageDialog(null, "Animes recuperados com sucesso");
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Animes não recuperados. Erro: " + e.getMessage());
            e.printStackTrace();
        }

        linha1 = new JLabel(imgPrincipal1, JLabel.CENTER);
        linha2 = new JLabel(imgPrincipal2, JLabel.CENTER);
        linha3 = new JLabel(imgPrincipal3,JLabel.CENTER);
        botaoAdicionar = new JButton("ADICIONAR", addImg);
        botaoAdicionar.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        botaoAdicionar.setBackground(Color.LIGHT_GRAY);
        botaoAdicionar.addActionListener(new CadastraAnimeController(sistema, this));
        botaoPesquisarPeloNome = new JButton("PESQUISAR ANIME", pesqImg);
        botaoPesquisarPeloNome.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        botaoPesquisarPeloNome.setBackground(Color.LIGHT_GRAY);
        botaoPesquisarPeloNome.addActionListener(new PesquisaAnimePeloNomeController(sistema, this));
        botaoPesquisarPelaCategoria = new JButton("Pesquisar pela Categoria", pesqImg);
        botaoPesquisarPelaCategoria.addActionListener(new PesquisaAnimePelaCategoriaController(sistema, this));
        botaoRemover = new JButton("REMOVER", removeImg);
        botaoRemover.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        botaoRemover.setBackground(Color.LIGHT_GRAY);
        botaoRemover.addActionListener(new RemoveAnimeController(sistema, this));

        setLayout(new GridLayout(3, 2));
        add(linha1);
        add(botaoAdicionar);
        add(linha2);
        add(botaoPesquisarPeloNome);
        add(linha3);
        add(botaoRemover);

        JMenu menuOperacoes = new JMenu("Operações com Animes");

        JMenuItem menuCadastrarAnime = new JMenuItem("Cadastrar Anime");
        menuOperacoes.add(menuCadastrarAnime);
        menuCadastrarAnime.addActionListener(new CadastraAnimeController(sistema, this));

        JMenuItem menuAtualizarAnime = new JMenuItem("Atualizar Anime");
        menuOperacoes.add(menuAtualizarAnime);
        menuAtualizarAnime.addActionListener(new AtualizaAnimeController(sistema, this));

        JMenuItem menuPesquisarAnimePorNome = new JMenuItem("Pesquisar Anime por Nome");
        menuOperacoes.add(menuPesquisarAnimePorNome);
        menuPesquisarAnimePorNome.addActionListener(new PesquisaAnimePeloNomeController(sistema, this));

        JMenuItem menuPesquisarAnimePorCategoria = new JMenuItem("Pesquisar Anime por Categoria");
        menuOperacoes.add(menuPesquisarAnimePorCategoria);
        menuPesquisarAnimePorCategoria.addActionListener(new PesquisaAnimePelaCategoriaController(sistema, this));

        JMenuItem menuRemoverAnime = new JMenuItem("Remover Anime");
        menuOperacoes.add(menuRemoverAnime);
        menuRemoverAnime.addActionListener(new RemoveAnimeController(sistema, this));

        barraDeMenu.add(menuOperacoes);

        JMenu menuSalvar = new JMenu("Salvar");
        JMenuItem menuSalvarDados = new JMenuItem("Salvar dados");
        menuSalvar.add(menuSalvarDados);
        menuSalvarDados.addActionListener(new SalvaAnimeController(sistema, this, gravador));

        barraDeMenu.add(menuSalvar);

        setJMenuBar(barraDeMenu);
        File arquivo = new File(".");
        System.out.println("===>" + arquivo.getAbsolutePath());

    }

    public static void main(String[] args) {
        JFrame janela = new AnimesGui();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}