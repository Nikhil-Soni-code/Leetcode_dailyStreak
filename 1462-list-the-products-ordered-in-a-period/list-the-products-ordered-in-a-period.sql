# Write your MySQL query statement below
SELECT Pro.product_name,SUM(unit) AS unit
FROM Products AS Pro
JOIN Orders AS Ord
ON Pro.product_id = Ord.product_id
WHERE Ord.order_date>='2020-02-01' AND Ord.order_date<'2020-03-01'
GROUP BY Pro.product_id
HAVING SUM(unit) >= 100;