package ABSTRACT_INTERFACE.THUC_HANH.test;

import ABSTRACT_INTERFACE.THUC_HANH.animal.Animal;
import ABSTRACT_INTERFACE.THUC_HANH.animal.Chicken;
import ABSTRACT_INTERFACE.THUC_HANH.animal.Tiger;
import ABSTRACT_INTERFACE.THUC_HANH.editble.Edible;

public class TestAnimal {
    public static void main(String[] args) {
        Animal[] animal = new Animal[2];
        animal[0] = new Chicken();
        animal[1] = new Tiger();
        for (int i = 0; i <animal.length ; i++) {
            System.out.println(animal[i].makeSound());
            if(animal[i] instanceof Chicken){
                Edible edible = (Chicken)animal[i];
                System.out.println(edible.howToEat());
            }
        }
    }
}
