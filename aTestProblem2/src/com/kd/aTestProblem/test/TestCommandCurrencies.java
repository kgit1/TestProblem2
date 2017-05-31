package com.kd.aTestProblem.test;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.kd.aTestProblem.java.AppCheckCurrencyChanger;
import com.kd.aTestProblem.java.Main;

public class TestCommandCurrencies {

	AppCheckCurrencyChanger app = new AppCheckCurrencyChanger();

	@Before
	public void setCurrencies() {
		app.currenciesData = app.parseCurrencies(app.getCurrencies());
		app.currenciesRate = new LinkedHashMap<>();
		app.currenciesRate.put("USD", (double) 1);
		app.currenciesRate.putAll((Map<String, Double>) app.currenciesData.get("rates"));
	}

	@Test
	public void testCommandCurrencies() {
		System.out.println("===========================================================");
		System.out.println("Test commandCurrencies");
		app.commandCurrencies();
		System.out.println("===========================================================");
	}

}
