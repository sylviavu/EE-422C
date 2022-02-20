package final_exam;

public class AuctionItem {

    public String name;
    public double price;
    public double minPrice;
    public double maxPrice;

    boolean closed = false;

    public AuctionItem(String name, double price, double minPrice, double maxPrice){
        this.name = name;
        this.price = price;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }


}
