package it.selecta.beans.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.selecta.beans.interfaces.Counter;
import it.selecta.beans.interfaces.CounterImpl;
import it.selecta.beans.interfaces.EnglishGreetings;
import it.selecta.beans.interfaces.Greetings;
import it.selecta.beans.interfaces.ItalianGreetings;

// si tratta di un bean creato nella fase di startup dell'applicazione
// e viene usato per esigenze di configurazione
@Configuration
public class ApplicationConfig {

	@Value("${language}")
	String language;

	// crea un bean attraverso un processo 
	// logico di factoring
	@Bean
	public Greetings italianGreetings() {
		// qui c'è la logica di creazione del bean
		if (language.equals("it"))
			return new ItalianGreetings();
		return new EnglishGreetings();
	}

//	@Bean
//	@Scope("prototype")
//	Counter getCounter() {
//		return new CounterImpl(15);
//	}
}
