import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    @Test
    public void removeThrows() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);

        Ticket ticket1 = new Ticket(1, 5000, "Moscow", "Saratov", 245);
        Ticket ticket2 = new Ticket(2, 3500, "Minsk", "Moscow", 400);
        Ticket ticket3 = new Ticket(3, 7000, "Tumen", "Saratov", 154);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            manager.removeByID(73);
        });
    }


    @Test
    public void removeById() {

        Repository repository = new Repository();
        Manager manager = new Manager(repository);

        Ticket ticket1 = new Ticket(1, 5000, "Moscow", "Saratov", 245);
        Ticket ticket2 = new Ticket(2, 3500, "Minsk", "Moscow", 400);
        Ticket ticket3 = new Ticket(3, 7000, "Tumen", "Saratov", 154);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        manager.removeByID(1);
        manager.removeByID(3);
        Ticket[] expected = {ticket2};
        Assertions.assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void searchByAirports() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);

        Ticket ticket1 = new Ticket(1, 5000, "SVO", "DME", 245);
        Ticket ticket2 = new Ticket(2, 3500, "DME", "SVO", 400);
        Ticket ticket3 = new Ticket(3, 7000, "VKO", "DME", 154);
        Ticket ticket4 = new Ticket(4, 2000, "SVO", "DME", 154);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] actual = manager.searchBy("DME", "SVO");
        Ticket[] expected = {ticket4, ticket1};
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void findAll() {

        Repository repository = new Repository();
        Manager manager = new Manager(repository);

        Ticket ticket1 = new Ticket(1, 5000, "SVO", "DME", 245);
        Ticket ticket2 = new Ticket(2, 3500, "DME", "SVO", 400);
        Ticket ticket3 = new Ticket(3, 7000, "VKO", "DME", 154);
        Ticket ticket4 = new Ticket(4, 6000, "SVO", "DME", 190);
        Ticket ticket5 = new Ticket(4, 6000, "SVO", "VKO", 165);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket2, ticket1, ticket4, ticket5, ticket3};
        Assertions.assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void searchByNull() {

        Repository repository = new Repository();
        Manager manager = new Manager(repository);

        Ticket[] actual = manager.searchBy("DME", "SVO");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    //Для 100% покрытия тестирую set и get
    @Test
    public void testSetId() {
        Ticket ticket = new Ticket();
        ticket.setId(1);
        assertEquals(ticket.getId(), 1);
    }

    @Test
    public void testSetPrice() {
        Ticket ticket = new Ticket();
        ticket.setPrice(100);
        assertEquals(ticket.getPrice(), 100);
    }

    @Test
    public void testSetTo() {
        Ticket ticket = new Ticket();
        ticket.setTo("Moscow");
        assertEquals(ticket.getTo(), "Moscow");
    }

    @Test
    public void testSetFrom() {
        Ticket ticket = new Ticket();
        ticket.setFrom("Moscow");
        assertEquals(ticket.getFrom(), "Moscow");
    }

    @Test
    public void testSetMiniutes() {
        Ticket ticket = new Ticket();
        ticket.setMinutes(100);
        assertEquals(ticket.getMinutes(), 100);
    }


}