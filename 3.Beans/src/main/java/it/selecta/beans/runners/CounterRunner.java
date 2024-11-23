package it.selecta.beans.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.selecta.beans.interfaces.Counter;

@Component
public class CounterRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CounterRunner.class);
	@Autowired
	private Counter counter1;
	@Autowired
	private Counter counter2;

	@Override
	public void run(String... args) throws Exception {
		var c1 = counter1.increment();
		var c2 = counter2.increment();
		logger.info("c1 = {} - c2 = {}", c1, c2);
	}

}
