package com.game;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Generates two different types of collections as below from a given collection :
 * 1) Applying isMultiple to each element of the given collection
 * 2) Applying doMatch adn IsMultiple to each element of the given collection.
 * @see isMultiple
 * @see doMatch
 */
public class MathsGame {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static MathsGame instance;

    private MathsGame(){
    }

    public static MathsGame getInstance() {
        if (instance == null){
            instance = new MathsGame();
        }
        return instance;
    }

    /**
     * Condition 1: The number is divisible by 3
     * Condition 2: The number is divisible by 5
     * Returns "FizzBuzz" if both conditions are met
     * Returns "Fizz" if only Condition 1 is met.
     * Returns "Buzz" if only Condition 2 is met.
     */
    private Function<Integer, String> isMultiple =
        input -> {
            String fizzPart = (input % 3 == 0 ? FIZZ : "");
            String buzzPart = (input % 5 == 0 ? BUZZ : "");
            String result = fizzPart + buzzPart;
            return "".equals(result) ? String.valueOf(input) : result;
        };

    /**
     * Condition 1 : Input element contains "3" or equals "Fizz"
     * Condition 2 : Input contains "5"  or equals "Buzz"
     * Returns "FizzBuzz" if both conditions are met
     * returns "Fizz" if only condition 1 is met
     * returns "Buzz" if only condition 1 is met
     * @see #isMultiple
     */
    private BiFunction<Integer, Function<Integer, String>, String> doMatch =
    (input,  isMultiple)-> {
        String isMultipleResult = isMultiple.apply(input);
        String inputStr = String.valueOf(input);
        String fizzPart = (inputStr.contains("3") || isMultipleResult.contains(FIZZ)) ? FIZZ : "";
        String buzzPart = (inputStr.contains("5") || isMultipleResult.contains(BUZZ)) ? BUZZ : "";
        String result = fizzPart + buzzPart;
        return "".equals(result) ? inputStr : result;
    };

    /**
     * Applies isMultiple function on each element of the given stream.
     * @param intStream
     * @return resulting collection
     * @see #isMultiple
     */
    public Collection<String> getMultiples(Stream<Integer> intStream){
        return intStream.map(isMultiple).collect(Collectors.toList());
    }

    /**
     * Applies doMatch function on each element of the given stream.
     * @param intStream
     * @return resulting collection
     * @see #isMultiple
     * @see #doMatch
     */
    public Collection<String> getMultiplesAndMatches(Stream<Integer> intStream){
        return intStream.map(x -> doMatch.apply(x, isMultiple)).collect(Collectors.toList());
    }

    /**
     * Prints the result of getMultiples() method with a stream of integers 1 to 100 both inclusive as input.
     * @see #getMultiples(Stream<Integer>)
     */
    public void printMultiples(){
        getMultiples(IntStream.range(1, 101).boxed()).forEach(System.out::println);
    }

    /**
     * Prints the result of getMultiplesAndMatches() method with a stream of integers 1 to 100 both inclusive as input.
     * @see #getMultiplesAndMatches(Stream<Integer>)
     */
    public void printMultiplesAndMatches(){
        getMultiplesAndMatches(IntStream.range(1, 101).boxed()).forEach(System.out::println);
    }

    public static void main(String args[]){
        MathsGame mg = new MathsGame();
        mg.printMultiples();
        //mg.printMultiplesAndMatches();
    }
}
