package org.sortprinter;

import org.sortprinter.solution.SortSolution;

import java.util.ArrayList;
import java.util.List;

public class SortPrinter {
    private List<Integer> numbers = new ArrayList<>();
    private SortSolution solution = null;

    //숫자 추가
    public void insertNumber(int num) {
        this.numbers.add(num);
    }
    
    //정렬 솔루션 선택
    public void setSortSolution(SortSolution sortSolution) {
        this.solution = sortSolution;
    }

    //선택된 정렬 방법으로 정렬
    public void sort() {
        if (this.solution == null) {
            System.out.println("sort solution is null. select sort solution.");
            return;
        }
        this.solution.sort(numbers);
    }

    //정렬된 결과 보기
    public void showNumbers() {
        this.numbers.forEach(System.out::println);
    }

    //숫자 초기화
    public void clearNumbers() {
        this.numbers = new ArrayList<>();
    }
}
