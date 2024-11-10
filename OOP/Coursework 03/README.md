## Customers

customerID|...<orders>

## Orders

orderID, tSize, qty, status

## Customers + Orders

customerID|orderID, tSize, qty, status-orderID, tSize, qty, status

* For each customer, every order is separated by a `_`

* Orders of the customer are separated by a `:`

