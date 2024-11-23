package it.selecta.beans.interfaces;

public class EnglishGreetings implements Greetings {
	@Override
	public String greetings(String name) {
		return String.format("Hello, %s!", name == null || name.isBlank() ? "World" : name);
	}

}
