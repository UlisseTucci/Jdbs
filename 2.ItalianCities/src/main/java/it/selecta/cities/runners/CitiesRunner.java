package it.selecta.cities.runners;

import java.net.URI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CitiesRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		var url = "https://www.istat.it/storage/codici-unita-amministrative/Elenco-comuni-italiani.csv";
		var uri = new URI(url);
		var inputStream = uri.toURL().openStream();
	}

}
