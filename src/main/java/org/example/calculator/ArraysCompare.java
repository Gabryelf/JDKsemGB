package org.example.calculator;

public class ArraysCompare {
    public static <T> boolean compareArrays(T[] array1, T[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {1, 2, 3};
        System.out.println(compareArrays(array1, array2));

        String[] array3 = {"hello", "world"};
        String[] array4 = {"hello", "world"};
        System.out.println(compareArrays(array3, array4));

        Double[] array5 = {1.5, 2.0, 3.7};
        Double[] array6 = {1.5, 2.0, 3.7};
        System.out.println(compareArrays(array5, array6));

        Integer[] array7 = {1, 2, 3};
        Integer[] array8 = {1, 4, 3};
        System.out.println(compareArrays(array7, array8));
    }
}
