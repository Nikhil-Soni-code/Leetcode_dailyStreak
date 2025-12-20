SELECT D.name AS Department, E.name AS Employee, E.salary AS Salary
FROM Employee AS E
JOIN Department AS D
ON E.departmentId = D.id
HAVING E.salary = (
    SELECT MAX(salary)
    FROM Employee
    WHERE departmentId = E.departmentId
);
