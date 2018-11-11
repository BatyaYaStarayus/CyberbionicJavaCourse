package sample;

import java.util.*;
import java.util.stream.Collectors;

public class StringStatistics {

    private String[] wordsToIgnore;

    public void setWordsToIgnore(String[] wordsToIgnore) {
        this.wordsToIgnore = wordsToIgnore;
    }

    private HashMap<String, Integer> getWordsAndTheirNumbers(String string) {
        HashMap<String, Integer> wordsAndTheirNumbers = new HashMap<>();

        for (String word : getAllWordsWithLengthMoreThan(2,string)) {
            if(wordsToIgnore != null) {
                if(!Arrays.asList(wordsToIgnore).contains(word)) {
                    updateMapWithWordsAppearanceNumber(wordsAndTheirNumbers, word);
                }
            } else {
                updateMapWithWordsAppearanceNumber(wordsAndTheirNumbers, word);
            }
        }

        return wordsAndTheirNumbers.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((a, b) -> b - a))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    private void updateMapWithWordsAppearanceNumber(HashMap<String, Integer> map, String wordToPaste) {
        if(!map.containsKey(wordToPaste)) {
            map.put(wordToPaste, 1);
        } else {
            map.put(wordToPaste, map.get(wordToPaste) + 1);
        }
    }

    private String[] getAllWordsArray(String string) {
        return string.split(" ");
    }

//    private String getAllWordsExceptIgnored(String string) {
//        String editedString = string.toLowerCase();
//        if(wordsToIgnore != null) {
//            for (String word : wordsToIgnore) {
//                editedString = editedString.replaceAll("\b(" + word + ")\b", "");
//            }
//        }
//
//        return editedString;
//    }

    private List<String> getAllWordsWithLengthMoreThan(int length, String string) {
        List<String> editedList = new ArrayList<>();
        for (String word : getAllWordsArray(string)) {
            if(word.length() > length) {
                editedList.add(word);
            }
        }

        return editedList;
    }

    private int getWordsNumber(String string) {
        return getAllWordsArray(string).length;
    }

//    private ArrayList<String> getUniqueWordsArray(String string) {
//        ArrayList<String> uniqueWords = new ArrayList<>();
//        HashMap<String, Integer> wordsHashMap = getWordsAndTheirNumbers(string);
//
//        wordsHashMap.forEach((k, v) ->(wordsHashMap.get(k) == 1) ? (uniqueWords.add(k));
//
//        return uniqueWords;
//    }
//
//    private int getUniqueWordsNumber(String string) {
//        return getUniqueWordsArray(string).size();
//    }


    private String getWordsAndAppearanceNumber(String string) {
        final String[] statString = {""};
        HashMap<String, Integer> uniqueWordsMap = getWordsAndTheirNumbers(string);

        uniqueWordsMap.forEach((s, k) -> statString[0] += s + " - " + k + " times\n");

        for (String s : statString) {
            System.out.println(s);
        }
        return statString[0];
    }

    public String getTextStatistics(String string) {
        String statisticsString = "";

        statisticsString += "Total words amount - " + getWordsNumber(string) + "\n";
        statisticsString += getWordsAndAppearanceNumber(string);

        return statisticsString;
    }





}
