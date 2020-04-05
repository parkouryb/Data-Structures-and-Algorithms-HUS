package CTDL.Homework_2;

import java.util.*;

public class Shuffle<T>{
    /**
     * this function is mine
     * @param a
     * @param size
     * @param value
     * @return
     */
    public Integer[] randomL(Integer[] a, int size, int value) {
        Integer[] res = new Integer[size];
        // process
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Random randomGenerator = new Random();
        int index = 0;
        while (map.size() != size) {
            Integer randomValue = randomGenerator.nextInt(value);
            map.put(randomValue, index);
        }
        Set<Integer> set = map.keySet();

        set.toArray(res);
        return res;
    } 

    public void swap(Integer a[], int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public void shuffle(Integer[] a) {
        Random randomGenerator = new Random();
        int count_suffle = randomGenerator.nextInt(100);
        for (int i = 0;i < count_suffle;++ i) {
            int index_1 = randomGenerator.nextInt(a.length);
            int index_2 = randomGenerator.nextInt(a.length);
            while(index_1 == index_2) index_2 = randomGenerator.nextInt(a.length);

            swap(a, index_1, index_2);
        }
    }

    public void shuffle(T[] a) {
        Random randomGenerator = new Random();
        int count_suffle = randomGenerator.nextInt(1000);
        System.out.println("Number of card shuffle times: " + count_suffle);
        for (int i = 0;i < count_suffle;++ i) {
            int index_1 = randomGenerator.nextInt(a.length);
            int index_2 = randomGenerator.nextInt(a.length);
            while(index_1 == index_2) index_2 = randomGenerator.nextInt(a.length);

            T tmp = a[index_1];
            a[index_1] = a[index_2];
            a[index_2] = tmp;
        }
    }


    /**
     * I have referenced at the site:
     * https://stackoverflow.com/questions/16000196/java-generating-non-repeating-random-numbers
     * Or can be found in the book Programming Pearls p. 127.
     * For testing purposes.
     * Seem like the answer no cool at all :D 
     * @param start
     * @param end
     * @param count
     * @return
     */
    public static int[] sampleRandomNumbersWithoutRepetition(int start, int end, int count) {
        Random rng = new Random();
    
        int[] result = new int[count];
        int cur = 0;
        int remaining = end - start;
        for (int i = start; i < end && count > 0; i++) {
            double probability = rng.nextDouble();
            if (probability < ((double) count) / (double) remaining) {
                count--;
                result[cur++] = i;
            }
            remaining--;
        }
        return result;
    }
}