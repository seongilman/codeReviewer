package org.gildedRose;

// Copyright (C) emilybache, Inc. All right reserved.
// https://github.com/emilybache/GildedRose-Refactoring-Kata

// History
//--------------------------------------------
// 230910 : 판매기한 조건 추가
// 230101 : 새로운 아이템 추가
// 220104 : 신규 코드 작성

import java.util.function.Predicate;

class Item {
    public String name; //이름
    public int sellIn; //판매기한
    public int price; //가격

    //생성자
    public Item(String name, int sellIn, int price) {
        this.name = name;
        this.sellIn = sellIn;
        this.price = price;
    }

    @Override
    public String toString() {
        //이름, 판매기한, 가격을 출력한다.
        return this.name + ", " + this.sellIn + ", " + this.price;
    }
}


class GildedRose {
    Item[] items;

    Predicate<String> IS_AGED_BRIE = "Aged Brie"::equals;
    Predicate<String> IS_BACKSTAGE_PASSED = "Backstage passes to a TAFKAL80ETC concert"::equals;
    Predicate<String> IS_SULFURAS = "Sulfuras, Hand of Ragnaros"::equals;

    //생성자
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updatePrice() {
        for (Item item : items) {
            가격조정(item);

            //=================버그 발생 방지===============================
            //Sulfuras 아이템이 아닐 경우에는 판매기한(sellin)을 1 줄인다. by inho.choi
            if (IS_SULFURAS.negate().test(item.name)) {
                item.sellIn = item.sellIn - 1;
            }
            //============================================================

            //판매기한이 음수일때 처리
            if (item.sellIn < 0) {
                판매기한음수보정(item);
            }
        }
    }

    private void 판매기한음수보정(Item item) {
        if (IS_AGED_BRIE.negate().test(item.name)
                && IS_BACKSTAGE_PASSED.negate().test(item.name)) {

            if (item.price > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.price = item.price - 1;
                }
            }

        } else {
            item.price = 0;
        }
    }

    private void 가격조정(Item item) {
        //만약 Aged Brie, Backstage Passed이 아닌 다른 아이템이라면
        if (IS_AGED_BRIE.negate().test(item.name)
                && IS_BACKSTAGE_PASSED.negate().test(item.name)
                    && IS_SULFURAS.negate().test(item.name)) {

            //가격이 존재할때만, 가격을 1 낮춘다. (단, Sulfuras 제외)
            if (item.price > 0) {
                item.price = item.price - 1;
                //모든 아이템들은 가격이 달라진다.
            }
        } else {
            if (item.price >= 50) {
                return;
            }

            item.price = item.price + 1;

            if (IS_BACKSTAGE_PASSED.negate().test(item.name)) {
                return;
            }

            if (item.sellIn < 11) {
                item.price = item.price + 1;
            }

            //판매기한이 5 이하일때는 가격이 1씩 더 증가한다.
            if (item.sellIn < 6) {
                item.price = item.price + 1;
            }
        }
    }
}
