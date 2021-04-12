package ABSTRACT_INTERFACE.THUC_HANH.test;

import ABSTRACT_INTERFACE.THUC_HANH.fruit.Apple;
import ABSTRACT_INTERFACE.THUC_HANH.fruit.Fruit;
import ABSTRACT_INTERFACE.THUC_HANH.fruit.Orange;

public class TestFruit {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();
        Fruit[] fruits = new Fruit[2];
        fruits[0] =apple;
        fruits[1] =orange;
        for (Fruit fruit:fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
