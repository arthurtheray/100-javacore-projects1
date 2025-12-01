package prg47;

import prg46.TextProcessor;

import java.util.*;
import java.util.Map.Entry;

public class SortedTextProcessor extends TextProcessor {
    public List<Entry<String, Integer>> getPopularWords(int count) {
        List<Entry<String, Integer>> allWords = new ArrayList<>(super.getWords().entrySet().stream().toList());
        allWords.sort(Comparator
                .comparing((Entry<String, Integer> e) -> e.getValue()).reversed());
        return allWords.subList(0, count);
    }
}

