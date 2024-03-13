package org.gildedRose2;

// Copyright (C) emilybache, Inc. All right reserved.
// https://github.com/emilybache/GildedRose-Refactoring-Kata

// History
//--------------------------------------------
// 230910 : 판매기한 조건 추가
// 230101 : 새로운 아이템 추가
// 220104 : 신규 코드 작성

class Item2 {
    public String name; //이름
    public int sellIn; //판매기한
    public int price; //가격

    //생성자
    public Item2(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.price = quality;
    }

    @Override
    public String toString() {
        //이름, 판매기한, 가격을 출력한다.
        return this.name + ", " + this.sellIn + ", " + this.price;
    }
}

class GildedRose2 {
    Item2[] items;

    //생성자
    public GildedRose2(Item2[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item2 item : items) {

            //만약 Aged Brie, Backstage Passed, Sulfuras 이 아닌 다른 아이템이라면
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                        && !item.name.equals("Sulfuras, Hand of Ragnaros")) {

                //판매기한(sellin)을 1 줄인다.
                item.sellIn = item.sellIn - 1;

                //가격이 존재하거나 판매 일자가 음수일 때
                if (item.price > 0 || item.sellIn < 0) {
                    item.price = item.price - 1;
                }
            } else {
                if (item.price >= 50) {
                    return;
                }
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    item.price += 1;
                    return;
                }
                if (item.sellIn < 0) {
                    item.price = 0;
                    return;
                }

                int modifyPrice = 1;
                if (item.sellIn < 11) {
                    modifyPrice ++;
                }
                if (item.sellIn < 6) {
                    modifyPrice ++;
                }
                item.price = modifyPrice;
            }
        }
    }
}
