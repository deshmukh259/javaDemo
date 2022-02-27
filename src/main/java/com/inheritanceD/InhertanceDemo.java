package com.inheritanceD;
public class InhertanceDemo {


    public static void main(String[] args) {
        Human h = new Human();
        h.name = "Monkey";
        h.money = 44;

        h.displayHuman();

        Human w = new Women();
        w.display();

    }
}

class Human{

    private String pass;
    public String name;
    protected int money;

    public void displayHuman(){
        System.out.println("pass "+pass +" name "+name +" money "+money);
    }

    public void display(){
        System.out.println("Im in humaman class");
    }

}

class Women extends Human{


    private String sex;

    public void displayWomen() {
        displayHuman();
        System.out.println("Sex "+sex);

    }
    public void display(){
        System.out.println("Im in women class");
    }
}