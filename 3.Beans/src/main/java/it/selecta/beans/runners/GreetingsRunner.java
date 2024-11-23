package it.selecta.beans.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.selecta.beans.interfaces.Greetings;
import it.selecta.beans.interfaces.ItalianGreetings;

@Component
public class GreetingsRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(GreetingsRunner.class);
	
	@Autowired
	private Greetings greet; //= new ItalianGreetings();

	@Override
	public void run(String... args) throws Exception {
		logger.info("{}", greet.greetings("Nello"));
		logger.info("{}", greet.greetings(null));
	}

}
