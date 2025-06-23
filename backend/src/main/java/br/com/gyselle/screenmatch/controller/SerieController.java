package br.com.gyselle.screenmatch.controller;

import br.com.gyselle.screenmatch.dto.EpisodioDTO;
import br.com.gyselle.screenmatch.dto.SerieDTO;
import br.com.gyselle.screenmatch.model.Episodio;
import br.com.gyselle.screenmatch.service.SerieService;
import org.aspectj.weaver.ast.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService service;

    @GetMapping
    public List<SerieDTO> obterSeries() {
        return service.obterSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> obterTop5Series() {
        return service.obterTop5Series();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> obterSeriesLancamentos() {
        return service.obterLancamentos();
    }

    @GetMapping("/{id}")
    public SerieDTO obterSeriePorId(@PathVariable Long id) {
        return service.obterSeriePorId(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDTO> obterTodasTemporadasPorSerie(@PathVariable Long id) {
        return service.obterTodasTemporadasPorSerie(id);
    }

    @GetMapping("/{id}/temporadas/{numeroTemporada}")
    public List<EpisodioDTO> obterEpisodiosPorTemporada(@PathVariable Long id, @PathVariable Long numeroTemporada) {
        return service.obterEpisodiosPorTemporada(id, numeroTemporada);
    }

    @GetMapping("/{id}/temporadas/top")
    public List<EpisodioDTO> obterTopEpisodiosPorSerie(@PathVariable Long id){
        return service.obterTopEpisodiosPorSerie(id);
    }

    @GetMapping("/categoria/{genero}")
    public List<SerieDTO> obterSeriesPorCategoria(@PathVariable String genero) {
        return service.obterSeriesPorCategoria(genero);
    }
}
