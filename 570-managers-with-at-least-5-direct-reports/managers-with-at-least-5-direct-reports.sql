# Write your MySQL query statement below
SELECT e2.name
FROM Employee AS e1
JOIN Employee AS e2
ON e1.managerId = e2.id
GROUP BY e2.id
HAVING COUNT(e1.id)>=5;