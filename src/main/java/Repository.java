import java.util.Arrays;

public class Repository {
    protected Ticket[] tickets = new Ticket[0];

    public void add(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeByID(int id) throws NotFoundException {
        if (findById(id) == null) {
            System.out.println("ID " + id + " не найден");
            throw new NotFoundException(
                    "ID " + id + " не найден");
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
                tickets = tmp;
            }
        }
    }

    public Ticket[] findAll() {
        Arrays.sort(tickets);
        return tickets;
    }

}

