package com.simbirsoft.service.sort;

import java.util.List;
import java.util.Map;

public interface ISort {
    Map<Character, List<String>> sort(String[] allWords);
}
