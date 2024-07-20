package hello.core.singleton;

public class StateFullService {

    private int price; //

    public int order(String name, int price){
        System.out.println("name + price  = " + name + price );

        //this.price = price;
        return price;
    }


}
