# TableAvailabilityTracker

Assumptions:
1. Customers are assigned to tables based on their group size and the capacity of the available tables.
2. The wait time for the next table will be calculated based on the time the previous group has spent on the table and the manager's allocation of time for the table.
3. For initial purposes, group size will always be less than or equal to 8 so each group can be accomodated in the restuarant at some point.
4. There are 18 tables in the restaurant.
5. Groups of 2 or lesser are seated for 40 minutes, groups of size 3-4 are seated for 1 hour, groups of size 5-6 are seated to 1 hour 20 minutes and groups of size 7-8 are seated for 2 hours.

Classes:

1. Table: Represents a table in the restaurant, with a unique ID and capacity.
   Properties: ID, capacity, availability time
   Methods: get_capacity(), get_availability_time(), reserve_table(), getId()

2. Restaurant: Represents the restaurant, with a fixed number of tables and methods to manage the tables.
   Properties: list of Table objects
   Methods: get_tables(), get_available_tables()

3. Manager: Represents the restaurant manager, with the ability to allocate time to tables based on the group size and current availability.
   Properties: None
   Methods: getNextAvailableTable(), calculateAllocationTime(), getAvailableTable(), reserveTable()

4. ReservationSystem Class contains the driver code that initializes the restaurant with 18 tables. It can also take in the customer group size as input. It calculates the wait time and allows the manager to reserve a table if the wait time is 0. Finally it prompts the Table ID assigned to the customer or informs the customer of their wait time.

Overall Flow:
When a customer enters the restaurant, they request for a table of their required size.
The restaurant manager checks the list of available tables and allocates a table based on the group size and availability time of the tables.
The manager reserves the table in the app, with the allocated time for the table.

Future Scope:
1. We can implement a database connected to this app to store table state instead of using a list of objects.
2. Keep a role based access where only the manager can perform certain operations.
3. Add a release table fuctionality in case the allocated group leaves earier.
4. We can take the allocation time as a user input instead of randomly assigning a value.
5. Scale the logic to allow any number of group sizes to be seated in the restaurant.
