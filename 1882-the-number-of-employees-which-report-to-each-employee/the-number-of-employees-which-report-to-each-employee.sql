# Write your MySQL query statement below
SELECT Emp2.employee_id,Emp2.name,COUNT(Emp1.employee_id) AS reports_count,ROUND(AVG(Emp1.age),0) AS average_age
FROM Employees AS Emp1
JOIN Employees AS Emp2
ON Emp1.reports_to = Emp2.Employee_id
GROUP BY Emp2.employee_id
ORDER BY Emp2.employee_id;