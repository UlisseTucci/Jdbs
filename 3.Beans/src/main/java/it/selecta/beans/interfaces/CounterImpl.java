package it.selecta.beans.interfaces;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// crea un bean di sistema
@Component
// scope indica il ciclo di vita
@Scope("singleton")
public class CounterImpl implements Counter {

	private int value = 0;

	public CounterImpl() {
		this(0);
	}

	public CounterImpl(int value) {
		this.value = value;
	}

	@Override
	public int increment() {
		return ++value;
	}

	@Override
	public int decrement() {
		return --value;
	}

}
