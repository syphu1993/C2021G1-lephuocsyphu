package ABSTRACT_INTERFACE.THUC_HANH.animal;

import ABSTRACT_INTERFACE.THUC_HANH.editble.Edible;

public class Chicken extends Animal implements Edible {

    @Override
    public String makeSound() {
        return "gluck...gluck..";
    }

    @Override
    public String howToEat() {
        return "could use fried";
    }
}
