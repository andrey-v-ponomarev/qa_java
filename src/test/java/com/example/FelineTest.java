package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class FelineTest {

    private final Feline feline = new Feline();

    @Test
    public void testGetFamilyReturnsCatFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testEatMeatReturnsCorrectFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    public void testGetFoodWithHerbivore() throws Exception {
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, feline.getFood("Травоядное"));
    }

    @Test
    public void testGetFoodWithPredator() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.getFood("Хищник"));
    }

    @Test
    public void testGetFoodWithUnknownKindThrowsException() {
        assertThrows(Exception.class, () -> feline.getFood("Неизвестный"));
    }

    @Test
    public void testGetKittensWithoutParameterReturnsOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithParameterReturnsValue() {
        assertEquals(5, feline.getKittens(5));
    }
}
