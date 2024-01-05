package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return words -> {
            for(String word : words){
                if(!Character.isUpperCase(word.charAt(0))){
                    return false;
                }
            }

            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return numbers -> {
            List<Integer> numbersToAdd = new ArrayList<>();

            for(Integer number : numbers){
                if(number % 2 == 0){
                    numbersToAdd.add(number);
                }
            }

            numbers.addAll(numbersToAdd);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> result = new ArrayList<>();

            for (String words : values) {
                int wordsCount = words.split(" ").length;
                boolean startsWithUpperCase = Character.isUpperCase(words.charAt(0));
                boolean endsWithPeriod = words.charAt(words.length() - 1) == '.';

                if (wordsCount > 3 && startsWithUpperCase && endsWithPeriod) {
                    result.add(words);
                }
            }

            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return  words -> {
            Map<String, Integer> result = new LinkedHashMap<>();

            for(String word : words){
                int wordLength = word.length();
                result.put(word, wordLength);
            }

            return  result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> combinedList = new ArrayList<>();

            combinedList.addAll(list1);
            combinedList.addAll(list2);

            return combinedList;
        };
    }
}
