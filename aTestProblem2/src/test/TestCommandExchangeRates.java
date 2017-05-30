package test;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import aTestProblem.App;
import aTestProblem.Main;

public class TestCommandExchangeRates {

	App app = new App();

	@Before
	public void setCurrencies() {
		app.currenciesData = app.parseCurrencies(app.getCurrencies());
		app.currenciesRate = new LinkedHashMap<>();
		app.currenciesRate.put("USD", (double) 1);
		app.currenciesRate.putAll((Map<String, Double>) app.currenciesData.get("rates"));
	}

	@Test
	public void testCommandExchangeRates() {
		System.out.println("===========================================================");
		System.out.println("Test commandExchangeRates");
		app.commandExchangeRates();
		System.out.println("===========================================================");
	}

}
