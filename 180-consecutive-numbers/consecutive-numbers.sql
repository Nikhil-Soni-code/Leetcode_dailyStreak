# Write your MySQL query statement below
SELECT DISTINCT a.num AS ConsecutiveNums
FROM Logs AS a
JOIN Logs AS b
JOIN Logs AS c
WHERE a.num = b.num AND b.num = c.num AND a.id + 1 = b.id AND b.id + 1 = c.id