import java.util.Arrays;

public class Manager {
    protected Repository repository;

    public Manager(Repository repo) {
        this.repository = repo;
    }

    public void add(Ticket product) {
        repository.add(product);
    }

    public void removeByID(int id) {
        repository.removeByID(id);
    }

    public Ticket[] findAll() {
        return repository.findAll();
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket product, String from, String to) {
        if (product.getFrom().contains(from)) {
            if (product.getTo().contains(to))
                return true;
        }
        return false;
    }
}

