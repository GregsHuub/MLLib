package functionalInterfaces;

import Entity.Book;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.logging.Filter;

public class Main {

    public static void main(String[] args) {


        Integer a = 3;
        Integer b = 3;

        Comparator<Integer> equal = Integer::compareTo;
        int compare = equal.compare(a, b);
        System.out.println(compare);

    }

}
