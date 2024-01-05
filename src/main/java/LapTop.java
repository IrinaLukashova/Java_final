import java.util.Objects;

public class LapTop extends Technique{
    String color;
    String os;

    public LapTop(long id, String model, int price, String type, String color, String os) {
        super(id, model, price, type);
        this.color = color;
        this.os = os;
    }

    @Override
    public String toString(){
        return String.format("\n id = %s, model = %s, os = %s, color = %s, price = %s", id, model, os, color, price);
    }

}
