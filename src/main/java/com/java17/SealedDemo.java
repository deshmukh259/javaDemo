package com.java17;

public class SealedDemo {
}

interface Driveable {

}
 sealed class Vechicle implements Driveable permits Car {
public int getMess(){
    return 55;
}
}
sealed class Car extends Vechicle permits Ford{
   public int  M(){
        return 66;
    }
}
final class Ford extends Car{
    public int M(){
        return 44;
    }
}