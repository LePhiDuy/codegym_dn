package _7_abstract_class_interface.practice.p1;

public class Chicken extends Animal implements  Edible{

    @Override
    public String makeSound() {
        return "Chicken: cluck - cluck";
    }

    @Override
    public String howtoEat() {
        return "could be fried";
    }
}
