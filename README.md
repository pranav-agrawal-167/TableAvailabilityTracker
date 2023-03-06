# TableAvailabilityTracker

Assumptions:

Customers are assigned to tables based on their group size and the capacity of the available tables.
The wait time for the next table will be calculated based on the time the previous group has spent on the table and the manager's allocation of time for the table.
The app will keep track of the available tables and their respective availability times.
For initial purposes, group size will always be less than or equal to 8.

Classes:

Table: Represents a table in the restaurant, with a unique ID and capacity.
Properties: ID, capacity, availability time
Methods: get_capacity(), get_availability_time(), reserve_table(), getId()

Restaurant: Represents the restaurant, with a fixed number of tables and methods to manage the tables.
Properties: list of Table objects
Methods: get_tables(), get_available_tables()

Manager: Represents the restaurant manager, with the ability to allocate time to tables based on the group size and current availability.
Properties: None
Methods: getNextAvailableTable(), calculateAllocationTime(), getAvailableTable(), reserveTable()

ReservationSystem Class contains the driver code that initializes the restaurant with 18 tables. It can also take in the customer group size as input. It calculates the wait time and allows the manager to reserve a table if the wait time is 0. Finally it prompts the Table ID assigned to the customer or informs the customer of their wait time.

Overall Flow:
When a customer enters the restaurant, they request for a table of their required size.
The restaurant manager checks the list of available tables and allocates a table based on the group size and availability time of the tables.
The manager reserves the table in the app, with the allocated time for the table.
