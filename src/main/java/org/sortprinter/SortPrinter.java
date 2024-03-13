package org.sortprinter;

import org.sortprinter.solution.SortSolution;

import java.util.ArrayList;
import java.util.List;

public class SortPrinter {
    private List<Integer> numbers = new ArrayList<>();
    private SortSolution solution = null;

    void insertNumber(int num) {
        this.numbers.add(num);
    }

    void setSortSolution(SortSolution sortSolution) {
        this.solution = sortSolution;
    }

    public void sort() {
        if (this.solution == null) {
            System.out.println("sort solution is null. select sort solution.");
            return;
        }
        this.solution.sort(numbers);
    }

    public void showNumbers() {
        this.numbers.forEach(System.out::println);
    }
}
