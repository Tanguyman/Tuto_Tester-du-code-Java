package com.openclassrooms.testing.calcul.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.openclassrooms.testing.calcul.domain.model.CalculationModel;

public class BatchCalculatorTest {

	@Test
	public void givenOperationsList_whenbatchCalculate_thenReturnsCorrectAnswerList()
			throws IOException, URISyntaxException {
		// GIVEN
		Stream<String> operations;
		
		// Aller chercher la donnée fournie par un collaborateur sur Internet
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(
				"https://gist.githubusercontent.com/geoffreyarthaud/7855a0f4322421f164f1701694f4369d/raw/5ad5f559f010c45c3aa9f8d266618ed5d314d5ea/operations.txt")
						.openStream()))) {
			operations = br.lines();

			// Ce n’est pas Fast car on va sur le web chercher les infos
			// Il faut virer le try
			// operations = Stream.of("2 + 2", "5 x 4", "6 + 8", "10 x 3");
			BatchCalculator batchCalculator = new BatchCalculator(new Calculator());

			// WHEN
			List<CalculationModel> resultats = batchCalculator.batchCalculate(operations);

			// THEN
			assertThat(resultats).extracting("solution").containsExactly(4, 20, 14, 30);
		}
	}
}
