package br.com.gyselle.screenmatch.service;

import br.com.gyselle.screenmatch.dto.EpisodioDTO;
import br.com.gyselle.screenmatch.dto.SerieDTO;
import br.com.gyselle.screenmatch.model.Categoria;
import br.com.gyselle.screenmatch.model.Serie;
import br.com.gyselle.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    public List<SerieDTO> obterSeries() {
        return converteDados(repository.findAll());
    }

    public List<SerieDTO> obterTop5Series() {

        return converteDados(repository.findTop5ByOrderByAvaliacaoDesc());
    }

    public List<SerieDTO> obterLancamentos() {
        return converteDados(repository.encontrarEpisodiosMaisRecentes());
    }

    public SerieDTO obterSeriePorId(Long id) {
        Optional<Serie> serie = repository.findById(id);

        if (serie.isPresent()) {
            Serie s = serie.get();
            return new SerieDTO(
                    s.getId(),
                    s.getTitulo(),
                    s.getTotalTemporadas(),
                    s.getAvaliacao(),
                    s.getGenero(),
                    s.getAtores(),
                    s.getPoster(),
                    s.getSinopse());
        }
        return null;
    }

    public List<EpisodioDTO> obterTodasTemporadasPorSerie(Long id) {
        Optional<Serie> serie = repository.findById(id);

        if (serie.isPresent()) {
            Serie s = serie.get();
            return s.getEpisodios().stream()
                    .map(e -> new EpisodioDTO(
                            e.getTemporada(),
                            e.getNumeroEpisodio(),
                            e.getTitulo()))
                    .collect(Collectors.toList());
        }
        return null;
    }

    public List<EpisodioDTO> obterEpisodiosPorTemporada(Long id, Long numeroTemporada) {
        return repository.obterEpisodiosPorTemporada(id, numeroTemporada)
                .stream()
                .map(e -> new EpisodioDTO(
                        e.getTemporada(),
                        e.getNumeroEpisodio(),
                        e.getTitulo()))
                .collect(Collectors.toList());
    }

    public List<EpisodioDTO> obterTopEpisodiosPorSerie(Long id) {
        var serie = repository.findById(id).get();
        return repository.topEpisodiosPorSerie(serie)
                .stream()
                .map(e -> new EpisodioDTO(e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()))
                .collect(Collectors.toList());
    }

    public List<SerieDTO> obterSeriesPorCategoria(String genero) {
        Categoria categoria = Categoria.fromPortugues(genero);
        return converteDados(repository.findByGenero(categoria));
    }

    private List<SerieDTO> converteDados(List<Serie> series) {
        return series.stream()
                .map(s -> new SerieDTO(
                        s.getId(),
                        s.getTitulo(),
                        s.getTotalTemporadas(),
                        s.getAvaliacao(),
                        s.getGenero(),
                        s.getAtores(),
                        s.getPoster(),
                        s.getSinopse()))
                .collect(Collectors.toList());
    }
}
