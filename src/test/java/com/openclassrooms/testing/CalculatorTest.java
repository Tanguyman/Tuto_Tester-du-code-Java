//package com.openclassrooms.testing;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.text.MessageFormat;
//import java.time.Duration;
//import java.time.Instant;
//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.apache.logging.log4j.Logger;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Timeout;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//
//@ExtendWith(LoggingExtension.class)
//public class CalculatorTest {
//
//	private static Instant startedAt;
//
//	private Calculator calculatorUnderTest;
//
//	private Logger logger;
//
//	public void setLogger(Logger logger) {
//		this.logger = logger;
//	}
//
//	@BeforeEach
//	public void initCalculator() {
//		// System.out.println("Appel avant chaque test");
//		logger.info("Appel avant chaque test");
//		calculatorUnderTest = new Calculator();
//	}
//
//	@AfterEach
//	public void undefCalculator() {
//		// System.out.println("Appel après chaque test");
//		logger.info("Appel après chaque test");
//		calculatorUnderTest = null;
//	}
//
//	@BeforeAll
//	public static void initStartingTime() { // J'ai retiré static
//		System.out.println("Appel avant tous les tests");
////		logger.info("Appel avant tous les tests");
//		startedAt = Instant.now();
//	}
//
//	@AfterAll
//	public static void showTestDuration() { // J'ai retiré static
//		System.out.println("Appel après tous les tests");
////		logger.info("Appel après tous les tests");
//		Instant endedAt = Instant.now();
//		long duration = Duration.between(startedAt, endedAt).toMillis();
//		System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
//		// logger.info(MessageFormat.format("Durée des tests : {0} ms", duration));
//	}
//
//	@Nested
//	@DisplayName("Réussir à faire des additions")
//	class AdditionTests {
//
//		@Test
//		// @Tag("Addition") // ce test fait partie des tests des 4 opérations de base
//		public void testAddTwoPositiveNumbers() {
//			// Arrange
//			int a = 2;
//			int b = 3;
//
//			// Act
//			int somme = calculatorUnderTest.add(a, b);
//
//			// Assert
//			assertThat(somme).isEqualTo(5);
//			assertEquals(5, somme);
//		}
//
//		@ParameterizedTest(name = "{0} + {1} doit être égal à {2}")
//		@CsvSource({ "1,1,2", "2,3,5", "42,57,99" })
////		@Test
////		@Tag("Addition2")
//		public void add_shouldReturnTheSum_ofMultipleIntegers(int arg1, int arg2, int expectResult) {
//			// Arrange -- Tout est prêt !
//
//			// Act
//			int actualResult = calculatorUnderTest.add(arg1, arg2);
//
//			// Assert
//			assertEquals(expectResult, actualResult);
//		}
//	}
//
//	@Nested
//	@DisplayName("Réussir à faire des multiplications")
//	class MultiplicationTest {
//
//		@Test
//		@DisplayName("Soit 2 chiffres 42 et 11, lorsq’on les multiplient, alors on obtient 462")
//		public void multiply_shouldReturnTheProduct_ofTwoIntegers() {
//			// Arrange
//			int a = 42;
//			int b = 11;
//
//			// Act
//			int produit = calculatorUnderTest.multiply(a, b);
//
//			// Assert
//			assertEquals(462, produit);
//		}
//
////		@Test
//		@DisplayName("Soit une série de chiffres, lorsq’on les multiplient par 0, alors on obtient 0")
//		@ParameterizedTest(name = "{0} x 0 doit être égal à 0")
//		@ValueSource(ints = { 1, 2, 42, 1011, 5089 })
//		public void multiply_shouldReturnZero_ofZeroWithMultipleIntegers(int arg) {
//			// Arrange -- Tout est prêt !
//
//			// Act -- Multiplier par zéro
//			int actualResult = calculatorUnderTest.multiply(arg, 0);
//
//			// Assert -- ça vaut toujours zéro !
//			assertEquals(0, actualResult);
//		}
//	}
//
//	@Test
//	@DisplayName("Le calcul doit se faire en moins d’une seconde")
//	@Timeout(1)
//	public void longCalcul_shouldComputeInLessThan1Second() {
//		// Arrange
//
//		// Act
//		calculatorUnderTest.longCalculation();
//
//		// Assert
//		// ...
//	}
//
//	@Nested
////	@Tag("SetTests")
//	@DisplayName("Réussir à manipuler des tableaux d’entiers")
//	public class SetTests {
//		@Test
//		@DisplayName("Le tableau doit contenir une liste d’entiers positifs")
//		public void listDigits_shouldReturnsTheListOfDigits_ofPositiveInteger() {
//			// GIVEN
//			int number = 95897;
//
//			// WHEN
//			Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);
//
//			// THEN
//			assertThat(actualDigits).containsExactlyInAnyOrder(9, 5, 8, 7);
//			Set<Integer> expectedDigits = Stream.of(5, 7, 8, 9).collect(Collectors.toSet());
//			assertEquals(expectedDigits, actualDigits);
//		}
//
//		@Test
//		@DisplayName("Le tableau doit contenir une liste d’entiers négatifs")
//		public void listDigits_shouldReturnsTheListOfDigits_ofNegativeInteger() {
//			int number = -124432;
//			Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);
//			assertThat(actualDigits).containsExactlyInAnyOrder(1, 2, 3, 4);
//		}
//
//		@Test
//		@DisplayName("Le tableau doit contenir 0")
//		public void listDigits_shouldReturnsTheListOfZero_ofZero() {
//			int number = 0;
//			Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);
//			assertThat(actualDigits).containsExactly(0);
//		}
//	}
//
//}
package com.openclassrooms.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.MessageFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith(LoggingExtension.class)
@DisplayName("Test class Calculator")
public class CalculatorTest {

	private static Instant startedAt;

	private Calculator calculatorUnderTest;

	private Logger logger;

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@BeforeEach
	public void initCalculator() {
		logger.info("Appel avant chaque test");
		calculatorUnderTest = new Calculator();
	}

	@AfterEach
	public void undefCalculator() {
		logger.info("Appel après chaque test");
		calculatorUnderTest = null;
	}

	@BeforeAll
	public static void initStartingTime() {
		System.out.println("Appel avant tous les tests");
		startedAt = Instant.now();
	}

	@AfterAll
	public static void showTestDuration() {
		System.out.println("Appel après tous les tests");
		Instant endedAt = Instant.now();
		long duration = Duration.between(startedAt, endedAt).toMillis();
		System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
	}

	@Nested
	@DisplayName("Réussir à faire des additions")
	class AdditionTests {

		@Disabled("Stoppé car cela échoue tous les mardis")
		@Test
		// @Tag("Addition") // ce test fait partie des tests des 4 opérations de base
		public void testAddTwoPositiveNumbers() {
			// Arrange
			int a = 2;
			int b = 3;

			// Act
			int somme = calculatorUnderTest.add(a, b);

			// Assert
			assertThat(somme).isEqualTo(5);
			assertEquals(5, somme);
		}

		@Disabled("Stoppé car cela échoue tous les mardis")
		@ParameterizedTest(name = "{0} + {1} doit être égal à {2}")
		@CsvSource({ "1,1,2", "2,3,5", "42,57,99" })
//		@Test
//		@Tag("Addition2")
		public void add_shouldReturnTheSum_ofMultipleIntegers(int arg1, int arg2, int expectResult) {
			// Arrange -- Tout est prêt !

			// Act
			int actualResult = calculatorUnderTest.add(arg1, arg2);

			// Assert
			assertEquals(expectResult, actualResult);
		}
	}

	@Disabled("Stoppé car cela échoue tous les mardis")
	@Test
	public void testAddTwoPositiveNumbers() {
		// Arrange
		int a = 2;
		int b = 3;

		// Act
		int somme = calculatorUnderTest.add(a, b);

		// Assert
		assertThat(somme).isEqualTo(5);
		assertEquals(5, somme);
	}

	@Test
	public void multiply_shouldReturnTheProduct_ofTwoIntegers() {
		// Arrange
		int a = 42;
		int b = 11;

		// Act
		int produit = calculatorUnderTest.multiply(a, b);

		// Assert
		assertEquals(462, produit);
	}

	@ParameterizedTest(name = "{0} x 0 doit être égal à 0")
	@ValueSource(ints = { 1, 2, 42, 1011, 5089 })
	public void multiply_shouldReturnZero_ofZeroWithMultipleIntegers(int arg) {
		// Arrange -- Tout est prêt !

		// Act -- Multiplier par zéro
		int actualResult = calculatorUnderTest.multiply(arg, 0);

		// Assert -- ça vaut toujours zéro !
		assertEquals(0, actualResult);
	}

	@ParameterizedTest(name = "{0} + {1} doit être égal à {2}")
	@CsvSource({ "1,1,2", "2,3,5", "42,57,99" })
	public void add_shouldReturnTheSum_ofMultipleIntegers(int arg1, int arg2, int expectResult) {
		// Arrange -- Tout est prêt !

		// Act
		int actualResult = calculatorUnderTest.add(arg1, arg2);

		// Assert
		assertEquals(expectResult, actualResult);
	}

	@Timeout(1)
	@Test
	public void longCalcul_shouldComputeInLessThan1Second() {
		// Arrange

		// Act
		calculatorUnderTest.longCalculation();

		// Assert
		// ...
	}

	@Test
	public void listDigits_shouldReturnsTheListOfDigits_ofPositiveInteger() {
		// GIVEN
		int number = 95897;

		// WHEN
		Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);

		// THEN
		assertThat(actualDigits).containsExactlyInAnyOrder(9, 5, 8, 7);
		Set<Integer> expectedDigits = Stream.of(5, 7, 8, 9).collect(Collectors.toSet());
		assertEquals(expectedDigits, actualDigits);
	}

	@Test
	public void listDigits_shouldReturnsTheListOfDigits_ofNegativeInteger() {
		int number = -124432;
		Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);
		assertThat(actualDigits).containsExactlyInAnyOrder(1, 2, 3, 4);
	}

	@Test
	public void listDigits_shouldReturnsTheListOfZero_ofZero() {
		int number = 0;
		Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);
		assertThat(actualDigits).containsExactly(0);
	}

	@Disabled("Stoppé car cela échoue tous les mardis")
	@Test
	public void testDate() {
		// GIVEN
		LocalDateTime dateTime = LocalDateTime.now();

		// WHEN

		// THEN
		assertThat(dateTime.getDayOfWeek()).isNotEqualTo(DayOfWeek.TUESDAY);
	}

}