# 181. Employees Earning More Than Their Managers
# https://leetcode.com/problems/employees-earning-more-than-their-managers/description/?lang=pythondata
# +-------------+---------+
# | Column Name | Type    |
# +-------------+---------+
# | id          | int     |
# | name        | varchar |
# | salary      | int     |
# | managerId   | int     |
# +-------------+---------+
# id is the primary key (column with unique values) for this table.
# Each row of this table indicates the ID of an employee, their name, salary, and the ID of their manager.

SELECT e1.name AS Employee
FROM Employee e1
         JOIN Employee e2 ON e1.managerId = e2.id
WHERE e1.salary > e2.salary;

# 182. Duplicate Emails
# Table: Person
# https://leetcode.com/problems/duplicate-emails/?lang=pythondata
# +-------------+---------+
# | Column Name | Type    |
# +-------------+---------+
# | id          | int     |
# | email       | varchar |
# +-------------+---------+
# id is the primary key (column with unique values) for this table.
# Each row of this table contains an email. The emails will not contain uppercase letters.
# Write a solution to report all the duplicate emails. Note that it's guaranteed that the email field is not NULL.
# Return the result table in any order.
# The result format is in the following example.
SELECT email
FROM Person
GROUP BY email
HAVING COUNT(email) > 1;


# 586. Customer Placing the Largest Number of Orders
# Table: Orders
# https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/?lang=pythondata
# +-----------------+----------+
# | Column Name     | Type     |
# +-----------------+----------+
# | order_number    | int      |
# | customer_number | int      |
# +-----------------+----------+
# order_number is the primary key (column with unique values) for this table.
# This table contains information about the order ID and the customer ID.
#
#
# Write a solution to find the customer_number for the customer who has placed the largest number of orders.
#
# The test cases are generated so that exactly one customer will have placed more orders than any other customer.
#
# The result format is in the following example.
#
#
#
# Example 1:
#
# Input:
# Orders table:
# +--------------+-----------------+
# | order_number | customer_number |
# +--------------+-----------------+
# | 1            | 1               |
# | 2            | 2               |
# | 3            | 3               |
# | 4            | 3               |
# +--------------+-----------------+
# Output:
# +-----------------+
# | customer_number |
# +-----------------+
# | 3               |
# +-----------------+
# Explanation:
# The customer with number 3 has two orders, which is greater than either customer 1 or 2 because each of them only has one order.
# So the result is customer_number 3.
#
#
# Follow up: What if more than one customer has the largest number of orders,
# can you find all the customer_number in this case?

SELECT customer_number
FROM Orders
GROUP BY customer_number
ORDER BY COUNT(order_number) DESC
LIMIT 1;

/*607. Sales Person
  https://leetcode.com/problems/sales-person/description/?lang=pythondata
Pandas Schema
Table: SalesPerson
+-----------------+---------+
| Column Name     | Type    |
+-----------------+---------+
| sales_id        | int     |
| name            | varchar |
| salary          | int     |
| commission_rate | int     |
| hire_date       | date    |
+-----------------+---------+
sales_id is the primary key (column with unique values) for this table.
Each row of this table indicates the name and the ID of a salesperson alongside their salary, commission rate, and hire date.


Table: Company

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| com_id      | int     |
| name        | varchar |
| city        | varchar |
+-------------+---------+
com_id is the primary key (column with unique values) for this table.
Each row of this table indicates the name and the ID of a company and the city in which the company is located.


Table: Orders

+-------------+------+
| Column Name | Type |
+-------------+------+
| order_id    | int  |
| order_date  | date |
| com_id      | int  |
| sales_id    | int  |
| amount      | int  |
+-------------+------+
order_id is the primary key (column with unique values) for this table.
com_id is a foreign key (reference column) to com_id from the Company table.
sales_id is a foreign key (reference column) to sales_id from the SalesPerson table.
Each row of this table contains information about one order. This includes the ID of the company, the ID of the salesperson, the date of the order, and the amount paid.


Write a solution to find the names of all the salespersons who did not have any orders related to the company with the name "RED".

Return the result table in any order.

The result format is in the following example.



Example 1:

Input:
SalesPerson table:
+----------+------+--------+-----------------+------------+
| sales_id | name | salary | commission_rate | hire_date  |
+----------+------+--------+-----------------+------------+
| 1        | John | 100000 | 6               | 4/1/2006   |
| 2        | Amy  | 12000  | 5               | 5/1/2010   |
| 3        | Mark | 65000  | 12              | 12/25/2008 |
| 4        | Pam  | 25000  | 25              | 1/1/2005   |
| 5        | Alex | 5000   | 10              | 2/3/2007   |
+----------+------+--------+-----------------+------------+
Company table:
+--------+--------+----------+
| com_id | name   | city     |
+--------+--------+----------+
| 1      | RED    | Boston   |
| 2      | ORANGE | New York |
| 3      | YELLOW | Boston   |
| 4      | GREEN  | Austin   |
+--------+--------+----------+
Orders table:
+----------+------------+--------+----------+--------+
| order_id | order_date | com_id | sales_id | amount |
+----------+------------+--------+----------+--------+
| 1        | 1/1/2014   | 3      | 4        | 10000  |
| 2        | 2/1/2014   | 4      | 5        | 5000   |
| 3        | 3/1/2014   | 1      | 1        | 50000  |
| 4        | 4/1/2014   | 1      | 4        | 25000  |
+----------+------------+--------+----------+--------+
Output:
+------+
| name |
+------+
| Amy  |
| Mark |
| Alex |
+------+
Explanation:
According to orders 3 and 4 in the Orders table, it is easy to tell that only salesperson
    John and Pam have sales to company RED, so we report all the other names in the table salesperson.*/

SELECT s.name
FROM SalesPerson s
WHERE s.sales_id NOT IN (
    SELECT DISTINCT o.sales_id
    FROM Orders o
             INNER JOIN Company c ON o.com_id = c.com_id
    WHERE c.name = 'RED'
);



