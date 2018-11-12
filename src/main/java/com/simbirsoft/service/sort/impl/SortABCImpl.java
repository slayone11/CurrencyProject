package com.simbirsoft.service.sort.impl;

import com.simbirsoft.service.sort.ISort;

import java.util.*;

public class SortABCImpl implements ISort {

    public Map<Character, List<String>> sort(String[] allWords) {
        List<String> allWordsList = Arrays.asList(allWords);
        Map<Character, List<String>> finalMap = makeABCSortedMap(allWordsList);
        return lengthSort(finalMap);
    }

    private Map<Character, List<String>> makeABCSortedMap(List<String> allWordsList){
        allWordsList.sort(String.CASE_INSENSITIVE_ORDER);
        Map<Character, List<String>> sortedMap = new HashMap<>();
        for (String word : allWordsList) {
            char charKey = word.charAt(0);
            if (sortedMap.containsKey(charKey)) {
                sortedMap.get(charKey).add(word);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(word);
                sortedMap.put(charKey, newList);
            }
        }
        return sortedMap;
    }

    private Map<Character, List<String>> lengthSort(Map<Character, List<String>> sortedMap){
        Map<Character, List<String>> resultMap = new HashMap<>();
        for (Map.Entry<Character, List<String>> entry: sortedMap.entrySet()) {
            char key = entry.getKey();
            List<String> valueList = sortedMap.get(key);
            if (valueList.size() > 1) {
                valueList.sort(new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return s1.length() < s2.length() ? 1 : -1;
                    }
                });
                resultMap.put(key, valueList);
            }
        }
        return resultMap;
    }
}
