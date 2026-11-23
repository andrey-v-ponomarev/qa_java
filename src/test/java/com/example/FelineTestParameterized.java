package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Параметризованные тесты для Feline.getKittens")
public class FelineTestParameterized {

    private final Feline feline = new Feline();

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5, 10})
    public void testGetKittensWithMultipleValues(int expected) {
        assertEquals(expected, feline.getKittens(expected));
    }
}