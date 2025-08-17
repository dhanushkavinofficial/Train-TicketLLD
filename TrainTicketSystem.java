import java.util.*;

// ===============================
// Train Ticket Booking System
// ===============================
public class TrainTicketSystem {

    // ---------- User ----------
    static class User {
        private String userId;
        private String name;
        private String email;

        public User(String userId, String name, String email) {
            this.userId = userId;
            this.name = name;
            this.email = email;
        }

        public String getUserId() { return userId; }
        public String getName() { return name; }
        public String getEmail() { return email; }
    }

    // ---------- Seat ----------
    static class Seat {
        private int seatNumber;
        private boolean isBooked;

        public Seat(int seatNumber) {
            this.seatNumber = seatNumber;
            this.isBooked = false;
        }

        public int getSeatNumber() { return seatNumber; }
        public boolean isBooked() { return isBooked; }
        public void bookSeat() { this.isBooked = true; }
        public void cancelSeat() { this.isBooked = false; }
    }

    // ---------- Train ----------
    static class Train {
        private String trainId;
        private String trainName;
        private List<Seat> seats;

        public Train(String trainId, String trainName, int seatCapacity) {
            this.trainId = trainId;
            this.trainName = trainName;
            this.seats = new ArrayList<>();
            for (int i = 1; i <= seatCapacity; i++) {
                seats.add(new Seat(i));
            }
        }

        public String getTrainId() { return trainId; }
        public String getTrainName() { return trainName; }
        public List<Seat> getSeats() { return seats; }
    }

    // ---------- Ticket ----------
    static class Ticket {
        private String ticketId;
        private User user;
        private Train train;
        private Seat seat;
        private double price;

        public Ticket(String ticketId, User user, Train train, Seat seat, double price) {
            this.ticketId = ticketId;
            this.user = user;
            this.train = train;
            this.seat = seat;
            this.price = price;
        }

        @Override
        public String toString() {
            return "TicketID: " + ticketId + ", User: " + user.getName() +
                    ", Train: " + train.getTrainName() + ", Seat: " + seat.getSeatNumber() +
                    ", Price: " + price;
        }
    }

    // ---------- Booking Service ----------
    static class BookingService {
        private Map<String, Ticket> bookings = new HashMap<>();
        private Random random = new Random();

        // Price Calculation (Math based: base fare + distance*factor)
        private double calculatePrice(int distance, int seatNumber) {
            return 100 + distance * 2 + (seatNumber % 5) * 10; // small math formula
        }

        public Ticket bookTicket(User user, Train train, int distance) {
            for (Seat seat : train.getSeats()) {
                if (!seat.isBooked()) {
                    seat.bookSeat();
                    String ticketId = "T" + random.nextInt(10000);
                    double price = calculatePrice(distance, seat.getSeatNumber());
                    Ticket ticket = new Ticket(ticketId, user, train, seat, price);
                    bookings.put(ticketId, ticket);
                    return ticket;
                }
            }
            return null; // No seats available
        }

        public boolean cancelTicket(String ticketId) {
            if (bookings.containsKey(ticketId)) {
                Ticket ticket = bookings.get(ticketId);
                ticket.seat.cancelSeat();
                bookings.remove(ticketId);
                return true;
            }
            return false;
        }

        public void printAllBookings() {
            if (bookings.isEmpty()) {
                System.out.println("No active bookings.");
            } else {
                for (Ticket t : bookings.values()) {
                    System.out.println(t);
                }
            }
        }
    }

    // ---------- Main ----------
    public static void main(String[] args) {
        // Create Train
        Train train = new Train("TR001", "Chennai Express", 5);

        // Create Users
        User user1 = new User("U1", "Dhanush", "dhanush@email.com");
        User user2 = new User("U2", "Kavin", "kavin@email.com");

        // Booking Service
        BookingService bookingService = new BookingService();

        // Book Tickets
        Ticket t1 = bookingService.bookTicket(user1, train, 250); // distance = 250 km
        Ticket t2 = bookingService.bookTicket(user2, train, 120);

        System.out.println("Bookings after ticketing:");
        bookingService.printAllBookings();

        // Cancel One Ticket
        System.out.println("\nCancelling Ticket: " + t1.ticketId);
        bookingService.cancelTicket(t1.ticketId);

        System.out.println("\nBookings after cancellation:");
        bookingService.printAllBookings();
    }
}
