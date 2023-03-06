import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Manager {

    public Table getNextAvailableTable(Restaurant restaurant, int groupSize) {
        // get the list of all tables sorted by availability time
        List<Table> allTables = restaurant.getTables();
        Collections.sort(allTables, Comparator.comparingLong(Table::getAvailabilityTime));
        // return the first available table
        for(Table table : allTables) {
            if(table.getCapacity() >= groupSize) {
                return table;
            }
        }
        return null;
    }

    private long calculateAllocationTime(int groupSize) {
        // calculate allocation time based on the group size
        if (groupSize <= 2) {
            return 40 * 60 * 1000; // 40 minutes for a group of 2 or less
        } else if (groupSize <= 4) {
            return 60 * 60 * 1000; // 1 hour for a group of 3-4
        } else if (groupSize <= 6) {
            return 80 * 60 * 1000; // 1 hour 20 minutes for a group of 5-6
        } else {
            return 120 * 60 * 1000; // 2 hour for a group greater than 6
        }
    }

    public Table getAvailableTable(Restaurant restaurant, int groupSize) {
        List<Table> tables;
        if(restaurant.getAvailableTables().size() > 0) {
            tables = restaurant.getAvailableTables();
            for(Table table: tables) {
                if (table.getCapacity() >= groupSize) {
                    return table;
                }
            }
        }
        // no available table could occupy current group size
        Table nextAvailableTable = getNextAvailableTable(restaurant, groupSize);
        return nextAvailableTable;
    }

    public void reserveTable(Table table, int groupSize) {
        long allocationTime = calculateAllocationTime(groupSize) + System.currentTimeMillis();
        table.reserveTable(allocationTime);
    }
}
