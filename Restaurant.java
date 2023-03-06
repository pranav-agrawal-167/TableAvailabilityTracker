import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Table> tables;

    public Restaurant(int numTables) {
        tables = new ArrayList<>();
        for (int i = 0; i < numTables; i++) {
            int tableCapacity = i % 4 == 0 ? 2 : i % 4 == 1 ? 4 : i % 4 == 2 ? 6 : 8;
            tables.add(new Table(i + 1, tableCapacity));
        }
    }

    public List<Table> getTables() {
        return tables;
    }

    public List<Table> getAvailableTables() { // returns a list of available tables
        List<Table> availableTables = new ArrayList<>();
        for (Table table : tables) {
            if (table.getAvailabilityTime() <= System.currentTimeMillis()) {
                availableTables.add(table);
            }
        }
        return availableTables;
    }
}
