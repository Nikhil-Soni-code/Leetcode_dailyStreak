# Write your MySQL query statement below
SELECT Dep.name AS Department,Emp.name AS Employee,Emp.salary AS Salary
FROM Employee AS Emp
JOIN Department AS Dep
ON Emp.departmentId = Dep.id
WHERE Emp.salary = (SELECT MAX(Salary) FROM Employee WHERE departmentId = dep.id);
