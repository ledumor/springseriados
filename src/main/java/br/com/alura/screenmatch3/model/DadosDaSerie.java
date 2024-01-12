package br.com.alura.screenmatch3.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// serialização (converter do java para json)
// desserialização (converter json par java)
// JsonAlias - lê o 'title' e converte para titulo
// JsonProperty - le o 'imdbVotes' e nao converter ,mantem  o nomes original
// Jackson é parecido com o Gson (converte json do GOOGLE)
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosDaSerie(@JsonAlias({"Title", "Titulo"}) String titulo,
                           @JsonAlias("totalSeasons") Integer totalTemporadas,
                           @JsonAlias("imdbRating") String avaliacao,
                           @JsonProperty("imdbVotes") String votos)
                           {

}
