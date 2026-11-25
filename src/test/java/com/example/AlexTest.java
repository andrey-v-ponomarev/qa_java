package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class    AlexTest {

    @Mock
    private Feline feline;

    @Test
    public void testGetFriendsReturnsCorrectList() throws Exception {
        Alex alex = new Alex(feline);
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        assertEquals(expected, alex.getFriends());
    }

    @Test
    public void testGetPlaceOfLivingReturnsZoo() throws Exception {
        Alex alex = new Alex(feline);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void testGetKittensReturnsZero() throws Exception {
        Alex alex = new Alex(feline);
        assertEquals(0, alex.getKittens());
    }

    @Test
    public void testAlexIsMaleAndHasMane() throws Exception {
        Alex alex = new Alex(feline);
        assertTrue(alex.doesHaveMane());
    }
}