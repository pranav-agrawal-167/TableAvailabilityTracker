public class Table {
    private int id;
    private int capacity;
    private long availabilityTime; // in milliseconds

    public Table(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.availabilityTime = System.currentTimeMillis(); // initialize availability time to current time
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

    public long getAvailabilityTime() {
        return availabilityTime;
    }

    public void reserveTable(long allocationTime) {
        availabilityTime = System.currentTimeMillis() + allocationTime; // allocate the table for the given time
    }
}
