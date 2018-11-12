package com.simbirsoft.service;

import com.simbirsoft.service.sort.ISort;
import com.simbirsoft.service.sort.impl.SortABCImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main (String[] args) throws IOException {


        //Scanner scan = new Scanner(System.in);
      /*  InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        String inputString = inputStreamReader.toString();
        String[] allWords = inputString.split(" ");
        ISort sorter = new SortABCImpl();
        System.out.println(sorter.sort(allWords));*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine().toLowerCase();
        String[] allWords = inputString.split(("[^\\p{L}\\p{Digit}_]+"));
        List<String> items = Arrays.asList(allWords);
        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
        Map<String, Long> finalMap = new LinkedHashMap<>();
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        int i = 0;
        for (String key : finalMap.keySet()) {
            if (i >= 10) {break;}
            System.out.println(key);
            i++;
        }
    }
}
