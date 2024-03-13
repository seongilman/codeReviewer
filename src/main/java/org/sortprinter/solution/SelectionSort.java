package org.sortprinter.solution;

import java.util.List;

public class SelectionSort implements SortSolution {
    @Override
    public void sort(List<Integer> numbers) {
        for(int i = 0 ; i < numbers.size(); i++) {
            for(int j = i + 1 ; j < numbers.size(); j ++) {
                if(numbers.get(i) > numbers.get(j)){
                    int tmp = numbers.get(i);
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, tmp);
                }
            }
        }
    }
}
