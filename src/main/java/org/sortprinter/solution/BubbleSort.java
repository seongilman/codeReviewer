package org.sortprinter.solution;

import java.util.List;

public class BubbleSort implements SortSolution {
    @Override
    public void sort(List<Integer> numbers) {
        for(int cycle = 0 ;cycle < numbers.size(); cycle ++) {
            for(int i = 0 ; i < numbers.size() - 1 - cycle; i ++) {
                if(numbers.get(i) > numbers.get(i + 1)){
                    //swap
                    int tmp = numbers.get(i);
                    numbers.set(i, numbers.get(i + 1));
                    numbers.set(i + 1, tmp);
                }
            }
        }
    }
}
