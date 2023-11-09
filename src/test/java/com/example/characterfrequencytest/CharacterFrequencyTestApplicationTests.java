package com.example.characterfrequencytest;

import com.example.characterfrequencytest.controllers.CharacterFrequencyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CharacterFrequencyTestApplicationTests {

    @Autowired
    CharacterFrequencyController characterFrequencyController;

    @Test
    void contextLoads() {
    }

    @Test
    void calculateFrequency_shouldReturnFrequencyList() {

        String input = "aaaaabcccc";

        List<Map.Entry<Character, Integer>> result = characterFrequencyController.calculateFrequency(input);

        assertEquals(3, result.size());
        assertEquals('a', result.get(0).getKey());
        assertEquals('c', result.get(1).getKey());
        assertEquals('b', result.get(2).getKey());
        assertEquals(5, result.get(0).getValue());
        assertEquals(4, result.get(1).getValue());
        assertEquals(1, result.get(2).getValue());

    }

    @Test
    void calculateFrequency_shouldReturnEmptyList() {

        String input = "";

        List<Map.Entry<Character, Integer>> result = characterFrequencyController.calculateFrequency(input);

        assertTrue(result.isEmpty());

    }

    @Test
    void calculateFrequency_shouldReturnListWithSingleEntry() {

        String input = "a";

        List<Map.Entry<Character, Integer>> result = characterFrequencyController.calculateFrequency(input);

        assertEquals(1, result.size());
        assertEquals('a', result.get(0).getKey());
        assertEquals(1, result.get(0).getValue());

    }

}
