package aut.utcluj.isp.ex2;

public class OnlineShop extends Shop{
    private String webAddress;


    public OnlineShop(String name, String city, String webAddress) {
        super(name, city);
        this.webAddress = webAddress;
    }

    public String getWebAddress() {
        return webAddress;
    }

    @Override
    public String toString() {
        return "Shop: " + this.getName() + " City: "+this.getCity() +" Web address: "+this.webAddress;
    }
}
