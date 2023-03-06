public class ReservationSystem {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(18);
        Manager manager = new Manager();

        int groupSize = 4; // default customer group size, can be taken from user

        Table tableToBeAssigned = manager.getAvailableTable(restaurant, groupSize);
        long calculatedWaitTime = tableToBeAssigned.getAvailabilityTime() - System.currentTimeMillis();
        long waitTime = calculatedWaitTime <= 0 ? 0 : calculatedWaitTime;
        if (waitTime == 0) {
            int tableId = tableToBeAssigned.getId();
            manager.reserveTable(tableToBeAssigned, groupSize);
            System.out.println("Table number " + tableId + " has been assigned to you");
        } else {
            System.out.println("Sorry, your wait time is " + (waitTime/1000)/60 + " minutes");
        }
    }
}
