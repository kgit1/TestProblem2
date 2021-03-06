package com.kd.aTestProblem.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import com.kd.aTestProblem.java.AppCheckCurrencyChanger;
import com.kd.aTestProblem.java.DataText;

public class TestCommandClear {

	AppCheckCurrencyChanger app = new AppCheckCurrencyChanger();

	@Before
	public void setUp() {

		app.programmData = new TreeMap<>();
		List<DataText> dataText1 = new ArrayList<>();
		List<DataText> dataText2 = new ArrayList<>();
		dataText1.add(new DataText(22, "USD", "Gorm"));
		dataText1.add(new DataText(22, "USD", "Gorm"));
		dataText2.add(new DataText(22, "BRL", "Gorm"));

		app.programmData.put(LocalDate.of(2001, 10, 21), dataText1);
		app.programmData.put(LocalDate.of(2011, 10, 21), dataText2);

		app.currenciesData = app.parseCurrencies(app.getCurrencies());
		app.currenciesRate = new LinkedHashMap<>();
		app.currenciesRate.put("USD", (double) 1);
		app.currenciesRate.putAll((Map<String, Double>) app.currenciesData.get("rates"));
	}

	@Test
	public void testCommandList() {
		final String correctClearCommand = "clear 2011-10-21";
		final String correctClearCommandWrongDate = "clear 2010-10-21";
		final String incorrectClearCommand = "clear2011-10-21";

		app.commandClear(correctClearCommand);
		assertEquals(1, app.programmData.size());

		app.commandClear(correctClearCommandWrongDate);
		assertEquals(1, app.programmData.size());

		app.commandClear(incorrectClearCommand);
		assertEquals(1, app.programmData.size());
	}

}
