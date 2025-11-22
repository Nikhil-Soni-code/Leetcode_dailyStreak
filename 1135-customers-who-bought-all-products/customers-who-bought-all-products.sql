# Write your MySQL query statement below
SELECT Cus.customer_id
FROM Customer AS Cus
JOIN Product AS Pro
ON Cus.product_key = Pro.product_key
GROUP BY Cus.customer_id
HAVING COUNT(DISTINCT(Cus.product_key)) = (SELECT COUNT(*) FROM Product);