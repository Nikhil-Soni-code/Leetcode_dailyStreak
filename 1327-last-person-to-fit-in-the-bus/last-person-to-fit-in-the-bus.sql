# Write your MySQL query statement below
SELECT person_name
FROM (SELECT person_name,turn ,SUM(weight) OVER(ORDER BY turn) AS running_sum FROM Queue)t
WHERE running_sum <= 1000
ORDER BY t.turn DESC
LIMIT 1;