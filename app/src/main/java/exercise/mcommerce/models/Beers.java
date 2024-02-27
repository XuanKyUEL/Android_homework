package exercise.mcommerce.models;

public class Beers {
    int beerThumb;

    String beerName;

    public Beers(int beerThumb, String beerName, Double beerPrice) {
        this.beerThumb = beerThumb;
        this.beerName = beerName;
        this.beerPrice = beerPrice;
    }

    public int getBeerThumb() {
        return beerThumb;
    }

    public void setBeerThumb(int beerThumb) {
        this.beerThumb = beerThumb;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public Double getBeerPrice() {
        return beerPrice;
    }

    public long getRoundBeerPrice() {
        return Math.round(beerPrice);
    }

    public void setBeerPrice(Double beerPrice) {
        this.beerPrice = beerPrice;
    }

    Double beerPrice;
}
