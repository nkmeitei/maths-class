package com.game;

import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MathsGameTest {

    private MathsGame gameUnderTest = MathsGame.getInstance();
    Stream<Integer> input = null;

    // Start of areMultiples testcases
    @Test
    public void shouldReturnFizzWhenOnlyMultipleOf3(){
        input = IntStream.of(9).boxed();
        Collection result = gameUnderTest.getMultiples(input);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Fizz", result.iterator().next());
    }

    @Test
    public void shouldReturnBuzzWhenOnlyMultipleOf5(){
        input = IntStream.of(10).boxed();
        Collection result = gameUnderTest.getMultiples(input);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Buzz", result.iterator().next());
    }

    @Test
    public void shouldReturnFizzBuzzWhenMultipleOfBoth3And5(){
        input = IntStream.of(15).boxed();
        Collection result = gameUnderTest.getMultiples(input);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("FizzBuzz", result.iterator().next());
    }

    @Test
    public void shouldReturnAsNumber(){
        input = IntStream.of(4).boxed();
        Collection result = gameUnderTest.getMultiples(input);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("4", result.iterator().next());
    }

    @Test
    public void shouldReturnExpectedCollectionWithRandomInput(){
        input = IntStream.of(1,2,5,6,7,30).boxed();
        Collection result = gameUnderTest.getMultiples(input);
        assertNotNull(result);
        assertEquals(6, result.size());
        Iterator<String> iter = result.iterator();
        assertEquals("1", iter.next());
        assertEquals("2", iter.next());
        assertEquals("Buzz", iter.next());
        assertEquals("Fizz", iter.next());
        assertEquals("7", iter.next());
        assertEquals("FizzBuzz", iter.next());
    }
    // End of Stage 1 (areMultiples) tests

    // Start of Stage 2 (doMatch) tests
    @Test
    public void shouldReturnFizzWhenMultipleOf3OrWhenContains3OrBoth(){
        input = IntStream.of(9,13,3).boxed();
        Collection result = gameUnderTest.getMultiplesAndMatches(input);
        assertNotNull(result);
        assertEquals(3, result.size());
        Iterator iter = result.iterator();
        assertEquals("Fizz", iter.next());
        assertEquals("Fizz", iter.next());
        assertEquals("Fizz", iter.next());
    }

    @Test
    public void shouldReturnBuzzWhenMultipleOf5OrWhenContains5OrBoth(){
        input = IntStream.of(10,52,25).boxed();
        Collection result = gameUnderTest.getMultiplesAndMatches(input);
        assertNotNull(result);
        assertEquals(3, result.size());
        Iterator iter = result.iterator();
        assertEquals("Buzz", iter.next());
        assertEquals("Buzz", iter.next());
        assertEquals("Buzz", iter.next());
    }
    @Test
    public void shouldReturnFizzBuzzWhenMultipleOf3AndContains5(){
        input = IntStream.of(51).boxed();
        Collection result = gameUnderTest.getMultiplesAndMatches(input);
        assertNotNull(result);
        assertEquals(1, result.size());
        Iterator iter = result.iterator();
        assertEquals("FizzBuzz", iter.next());
    }
    @Test
    public void shouldReturnFizzBuzzWhenMultipleOf5AndContains3(){
        input = IntStream.of(35).boxed();
        Collection result = gameUnderTest.getMultiplesAndMatches(input);
        assertNotNull(result);
        assertEquals(1, result.size());
        Iterator iter = result.iterator();
        assertEquals("FizzBuzz", iter.next());
    }
    @Test
    public void shouldReturnNumberWhenNoCriteriaAreMet(){
        input = IntStream.of(22).boxed();
        Collection result = gameUnderTest.getMultiplesAndMatches(input);
        assertNotNull(result);
        assertEquals(1, result.size());
        Iterator iter = result.iterator();
        assertEquals("22", iter.next());
    }

    @Test
    public void shouldReturnExpectedResultsWithRandomInput(){
        input = IntStream.of(1,2,5,7,13,53).boxed();
        Collection result = gameUnderTest.getMultiplesAndMatches(input);
        assertNotNull(result);
        assertEquals(6, result.size());
        Iterator iter = result.iterator();
        assertEquals("1", iter.next());
        assertEquals("2", iter.next());
        assertEquals("Buzz", iter.next());
        assertEquals("7", iter.next());
        assertEquals("Fizz", iter.next());
        assertEquals("FizzBuzz", iter.next());
    }
    // End of Stage 2 (doMatch) tests
}
