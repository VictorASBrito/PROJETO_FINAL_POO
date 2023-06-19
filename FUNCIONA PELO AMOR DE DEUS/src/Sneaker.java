
public class Sneaker {
    private int id;
    private String name_sneaker;
    private String description;
    private double price;
    private String creator;

    public Sneaker(String name_sneaker, String description, double price, String creator) {
        this.name_sneaker = name_sneaker;
        this.description = description;
        this.price = price;
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_sneaker() {
        return name_sneaker;
    }

    public void setName_sneaker(String name_sneaker) {
        this.name_sneaker = name_sneaker;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setName(String string) {
    }

}
