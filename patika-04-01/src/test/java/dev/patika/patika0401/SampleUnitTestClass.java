package dev.patika.patika0401;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Executable;

public class SampleUnitTestClass {

    Calculator calculatorTest;

    // yeni obje oluşturma her test için yapılmalı
    @BeforeEach
    void setup() {
        System.out.println("Inside before");
        this.calculatorTest = new Calculator();
    }

    @BeforeAll // static olmalı, hepsinden önce 1 kere çalışır
    static void beforeAll(){
        System.out.println("Before all");
    }


    // @RepeatedTest(10)
    @Test // Unit testler void tir, bir şey dönmez. Hepsi birbirinden bağımsız
    public void should_ReturnEquals_When_addTwoNumber(){
        // given
        int firstNumber = 10;
        int secondNumber = 20;
        int expected = 30;

        // when
        int actual = calculatorTest.add(firstNumber, secondNumber);

        // then
        // Assertion: iddia etmek
        Assertions.assertEquals(expected, actual);

    }
    @ParameterizedTest
    @ValueSource(ints = {-10, 1, 0, 20})
    public void should_ReturnZero_When_multipleNumberWithZero(int givenSource){
        // given
        int firstNumber = givenSource;
        int secondNumber = 0;
        int expected = 0;

        // when
        int actual = calculatorTest.multiply(firstNumber, secondNumber);

        // then
        Assertions.assertTrue(actual==0);

    }

    @ParameterizedTest
    @CsvSource(value = {"-10, -11", "-9, -20", "-2, -3"})
    public void should_ReturnTrue_When_multipleTwoNegativeNumber(int givenFirstNumber, int givenSecondNumber ){
        // given
        int firstNumber = givenFirstNumber;
        int secondNumber = givenSecondNumber;

        // when
        int actual = calculatorTest.multiply(firstNumber, secondNumber);

        // then
        Assertions.assertTrue(actual > 0);

    }
   /* @Test
    public void should_throwException_When_divideToZero(){
        // given
        int firstNumber = 10;
        int secondNumber = 0;

        // when
        Executable executable = () -> calculatorTest.divide(firstNumber, secondNumber);

        // then
        // Assertion: iddia etmek
        Assertions.assertEquals(ArithmeticException.class, executable);

    }*/

    class Calculator {
        int add(int a, int b) {
            return a+b;
        }
        int multiply(int a, int b){
            return a*b;
        }
        int divide(int a, int b){
            return a / b;
        }
    }
}
