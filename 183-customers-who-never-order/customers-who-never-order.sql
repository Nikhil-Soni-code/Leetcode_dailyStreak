# Write your MySQL query statement below
SELECT C1.name AS Customers
FROM Customers AS C1
LEFT JOIN Orders AS C2
ON C1.id = C2.customerId
WHERE C2.customerId IS NULL;