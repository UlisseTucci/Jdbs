package it.selecta.beans.interfaces;

public class ItalianGreetings implements Greetings {

	@Override
	public String greetings(String name) {
		return String.format("Ciao, %s!", name == null || name.isBlank() ? "Mondo" : name);
	}

}
