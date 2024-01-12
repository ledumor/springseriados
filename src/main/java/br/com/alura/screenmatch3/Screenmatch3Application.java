package br.com.alura.screenmatch3;

import br.com.alura.screenmatch3.model.DadosDaSerie;
import br.com.alura.screenmatch3.model.DadosDoEpisodio;
import br.com.alura.screenmatch3.service.ConsumoApi;
import br.com.alura.screenmatch3.service.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Screenmatch3Application implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(Screenmatch3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("rodando spring sem web");
		Scanner leitura = new Scanner(System.in);
		String token = "84bad544";
		var seriePesquisa = "";

		System.out.println("Digite uma série:");
		seriePesquisa = leitura.nextLine();

		var endereco = "";
		var consumoApi = new ConsumoApi();
		endereco = "https://www.omdbapi.com/?t=" + seriePesquisa.replace(" ","+") + "&apikey=" + token;


		System.out.println("acessando link = " + endereco);
		// a classe 'consumo api' acessa qq site que passar no endereço
		var json = consumoApi.obterDados(endereco);


		System.out.println("retorno = " + json);

		// obter dados da temporada
		System.out.println("informe nr. da temporada:");
		int numTemporada = leitura.nextInt();

		endereco = "https://www.omdbapi.com/?t="
				+ seriePesquisa.replace(" ","+")
				+"&season=" + numTemporada
				+ "&apikey=" + token;

		System.out.println("Link da temporada " + numTemporada + " = " + endereco);
		// atualizando json com dados da temporada
		json = consumoApi.obterDados(endereco);
		ConverterDados conversor = new ConverterDados();
		DadosDaSerie dados = conversor.obterDados(json, DadosDaSerie.class);
		System.out.println(dados);

		// obter dados do episodio
		System.out.println("informe nr. do episodio; ");
		int numEpisodio = leitura.nextInt();

		endereco = "https://www.omdbapi.com/?t="
				+ seriePesquisa.replace(" ","+")
				+"&season=" + numTemporada
				+"&episode=" + numEpisodio
				+ "&apikey=" + token;

		System.out.println("Link do Episodio " + numEpisodio + " = " + endereco);
		json = consumoApi.obterDados(endereco);
		// obter dados do episodio
		DadosDoEpisodio dadosEpisodio = conversor.obterDados(json, DadosDoEpisodio.class);
		System.out.println(dadosEpisodio);

	}
}
