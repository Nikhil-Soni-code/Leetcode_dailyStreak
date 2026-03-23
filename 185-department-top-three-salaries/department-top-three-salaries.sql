# Write your MySQL query statement below
SELECT D.name AS Department, E.name AS Employee, E.salary AS Salary
FROM (
    SELECT *,
    DENSE_RANK() OVER(
        PARTITION BY departmentId ORDER BY salary DESC
    ) AS rnk
    FROM Employee
) AS E
JOIN Department AS D
ON E.departmentId = D.id
WHERE rnk<=3;