package br.ufpb.anime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;



import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TestaSistemaAnime {
    /**
     * Rigorous Test :-)
     */

    @Test
    public void TestaRemoverEPesquisa() {
        SistemaAnimesMap sistema = new SistemaAnimesMap();
        boolean cadastraAnime = sistema.cadastraAnime("nanatsu", "aventura", 24);
        Collection<Anime> pesquisaAnime1 = sistema.pesquisaAnimePeloNome("nanatsu");
        assertTrue(cadastraAnime);
        assertEquals(1,pesquisaAnime1.size());
        boolean removeuAnime = sistema.removeAnime("nanatsu");
        assertTrue(removeuAnime);
        Collection<Anime> pesquisaAnime2 = sistema.pesquisaAnimePeloNome("nanatsu");
        assertEquals(0,pesquisaAnime2.size());
    }
}