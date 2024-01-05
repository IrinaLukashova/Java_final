import java.util.Objects;

public class Technique {
    long id;
    String model;
    int price;
    String type;

    public Technique(long id, String model, int price, String type){
        this.id = id;
        this.model = model;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString(){
        return String.format("\n id = %s, type = %s, model = %s, price = %s", id, type, model, price);
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Technique technique = (Technique) o;

        return (this.id == technique.id && this.model.equals(technique.model));
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
