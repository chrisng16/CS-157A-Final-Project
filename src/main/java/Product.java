public class Product {

    protected int productID;
    protected String name;
    protected String category;
    protected int price;
    protected int rating;
    protected String manufacturer;

    public Product(){}

    public Product(int id, String name, String category, int price, int rating, String manu){
        productID = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
        manufacturer = manu;
    }

    public int getProductID(){ return productID; }

    public String getName(){ return name; }

    public String getCategory(){ return category; }

    public int getPrice() {
        return price;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
