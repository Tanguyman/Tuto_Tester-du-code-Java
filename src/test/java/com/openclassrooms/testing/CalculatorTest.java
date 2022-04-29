package com.openclassrooms.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

	// Stocker l’instance en cours de Calculator
	private Calculator calculatorUnderTest; // Créer une propriété (field) de class

	// Chronométrer la durée de tous les tests de cette classe
	// créer une variable pour stocker le mmt où on va démarrer les tests
	private static Instant startedAt; // static nécessaire pour cette annotation

	@BeforeAll
	public static void initStartingTime() {
		System.out.println("Appel avant tous les tests");
		startedAt = Instant.now();
	}

	@AfterAll
	public static void showDuration() {
		System.out.println("Appel après tous les tests");
		Instant endedAt = Instant.now();
		long duration = Duration.between(startedAt, endedAt).toMillis();
		System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
	}

	// Avant de commencer les tests
	// créer la méthode permettant d’instancier la classe Calculator
	// afin d’éliminer les lignes redondantes dans les tests (factoriser)
	@BeforeEach
	public void initCalculator() {
		calculatorUnderTest = new Calculator();
		System.out.println("Appel avant chaque test");
	}

	// Désaffecter la variable calculator
	// pour éviter toute réutilisation
	// Je pense que c’est pour l’exemple...
	@AfterEach
	public void undefCalculator() {
		System.out.println("Appel après chaque test");
		calculatorUnderTest = null;
	}

	// Cette méthode est un test à lancer
	@Test
	public void testAddTwoPositiveNumbers() {
		// ARRANGE
		int a = 2;
		int b = 3;
		// Calculator calculator = new Calculator(); // BeforeEach

		// ACT
		// int somme = calculator.add(a, b); // Variable local
		// Utiliser la propriété de class au lieu de la variable local
		int somme = calculatorUnderTest.add(a, b);

		// ASSERT
		assertEquals(5, somme);
	}

	@Test
	public void multiply_shouldReturnTheProduct_ofTwoIntegers() {
		// Arrange
		int a = 42;
		int b = 11;

		// ACT
		int produit = calculatorUnderTest.multiply(a, b);

		// ASSERT
		assertEquals(462, produit);
	}

	@ParameterizedTest(name = "{0} x 0 doit être égal à 0")
	// Insérer les nb entiers en argument (arg)
	@ValueSource(ints = { 1, 2, 42, 1001, 5089 })
	public void multiply_shouldReturnZero_ofZeroWithMultipleIntegers(int arg) {
		// ARRANGE : rien à faire grâce à int arg qui est passé en paramètre

		// ACT -- Multiplier par zéro
		int actualResult = calculatorUnderTest.multiply(arg, 0);

		// ASSERT -- Ça vaut toujours zéro !
		assertEquals(0, actualResult);
	}

	@ParameterizedTest(name = "{0} + {1} doit être égal à {2}")
	// Injecter les valeurs avec un tableau de données (.csv)
	@CsvSource({ "1,1,2", "2,3,5", "42,57,99" })
	public void add_shouldReturnTheSum_ofMultipleIntegers(int arg1, int arg2, int expectResult) {
		// ARRANGE : rien à faire grâce aux arguments passés en paramètre

		// ACT -- Multiplier par zéro
		int actualResult = calculatorUnderTest.add(arg1, arg2);

		// ASSERT -- Ça vaut toujours zéro !
		assertEquals(expectResult, actualResult);
	}
	
	@Test
	@Timeout(1)
	public void longCalcul_shouldComputeInLessThan1Second() {
		// ARRANGE
		// ACT
		calculatorUnderTest.longCalculation();
		// ASSERT
	}
	
}
