package com.example.characterfrequencytest.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class CharacterFrequencyController {

    @PostMapping("/frequency")
    public List<Map.Entry<Character, Integer>> calculateFrequency(@RequestBody String input) {

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
        // sort list by value
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        return list;
    }

}
