package br.com.alura.screenmatch3.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosDoEpisodio(@JsonAlias("Title") String tituloEpisodio,
                              @JsonAlias("Season") int numDaTemporada,
                              @JsonAlias("Episode") int numDoEpisodio,
                              @JsonAlias("Runtime") String duracao ) {

}
