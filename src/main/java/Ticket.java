public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int price;
    protected String to;
    protected String from;
    protected int minutes;

    public Ticket() {

    }


    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {

        return price;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setPrice(int price) {

        this.price = price;
    }

    public Ticket(int id, int price, String to, String from, int minutes) {
        this.id = id;
        this.minutes = minutes;
        this.price = price;
        this.from = from;
        this.to = to;
    }

    @Override
    public int compareTo(Ticket o) {
        if (price < o.getPrice()) {
            return -1;
        } else if (price > o.getPrice()) {
            return 1;
        } else return 0;
    }
}
