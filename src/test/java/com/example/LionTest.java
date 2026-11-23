package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void testMaleHasMane() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertEquals(true, lion.doesHaveMane());
    }

    @Test
    public void testFemaleDoesNotHaveMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertEquals(false, lion.doesHaveMane());
    }

    @Test
    public void testConstructorWithInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неверный", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }

    @Test
    public void testGetKittensDelegatesToFeline() throws Exception {
        when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", feline);
        assertEquals(3, lion.getKittens());
        verify(feline).getKittens();
    }

    @Test
    public void testGetFoodCallsFelineWithPredator() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", feline);
        assertEquals(expectedFood, lion.getFood());
        verify(feline).getFood("Хищник");
    }
}