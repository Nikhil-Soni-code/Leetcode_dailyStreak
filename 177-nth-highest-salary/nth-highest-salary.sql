CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT E1.salary AS getNthHighestSalary
      FROM Employee AS E1
      WHERE N-1 = (SELECT COUNT(DISTINCT E2.salary) FROM Employee AS E2 WHERE E1.salary<E2.salary)     
  );
END