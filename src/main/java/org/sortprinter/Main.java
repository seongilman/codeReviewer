package org.sortprinter;

import org.sortprinter.solution.BubbleSort;
import org.sortprinter.solution.SelectionSort;
import org.sortprinter.solution.SortSolution;
import org.sortprinter.solution.SortType;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<SortType, SortSolution> sortMap = new HashMap<>();
    static {
        sortMap.put(SortType.BUBBLE, new BubbleSort());
        sortMap.put(SortType.SELECTION, new SelectionSort());
    }

    public static void main(String[] args) {
        SortPrinter sp = new SortPrinter();
        sp.insertNumber(1);
        sp.insertNumber(5);
        sp.insertNumber(7);
        sp.insertNumber(2);
        sp.insertNumber(9);

        sp.setSortSolution(getSortSolution(SortType.BUBBLE));
//        sp.setSortSolution(getSortSolution(SortType.SELECTION));

        sp.sort();
        sp.showNumbers();
    }

    public static SortSolution getSortSolution(SortType sortType) {
        return sortMap.get(sortType);
    }
}