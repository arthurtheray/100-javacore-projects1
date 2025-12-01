package prg46;

import java.util.HashMap;
import java.util.Map;

public class TextProcessor {
    private final Map<String, Integer> words;
    private int uniqueWords = 0;

    public TextProcessor() {
        this.words = new HashMap<>();
    }

    public Map<String, Integer> getWords() {
        return words;
    }

    public int add(String text) {
        String[] splited = text.split("\\s+");
        for (String word : splited) {
            words.merge(word.toLowerCase(), 1, (oldValue, _) -> oldValue + 1);
        }
        int newWords = words.size() - uniqueWords;
        uniqueWords = words.size();
        return newWords;
    }

    public String report() {
        return "Всего слов: " + getTotalWords() + "\n" +
                "Уникальных слов: " + uniqueWords + "\n" +
                "\n" +
                words;
    }

    private int getTotalWords() {
        int res = 0;
        for (Integer v : words.values()) {
            res += v;
        }
        return res;
    }

    public Integer getWordsCount() {
        return uniqueWords;
    }
}
