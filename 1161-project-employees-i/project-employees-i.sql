# Write your MySQL query statement below
SELECT Pro.project_id,ROUND(AVG(Emp.experience_years),2)  AS average_years
FROM Project AS Pro
LEFT JOIN Employee AS Emp
ON Pro.employee_id = Emp.employee_id
GROUP BY Pro.project_id;