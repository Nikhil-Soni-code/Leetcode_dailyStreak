SELECT Emp.employee_id
FROM Employees AS Emp
LEFT JOIN Employees AS Man
    ON Emp.manager_id = Man.employee_id
WHERE Emp.salary < 30000
  AND Man.employee_id IS NULL
  AND Emp.manager_id IS NOT NULL
  
ORDER BY Emp.employee_id;
