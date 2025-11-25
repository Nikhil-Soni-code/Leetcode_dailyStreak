# Write your MySQL query statement below
SELECT S.user_id ,
 IFNULL(ROUND(SUM(CASE WHEN C.user_id = S.user_id AND action = 'confirmed' THEN 1 ELSE 0 END)/
 SUM(CASE WHEN C.user_id = S.user_id THEN 1 ELSE 0 END),2),0) AS confirmation_rate
FROM Signups AS S
LEFT JOIN Confirmations AS C
ON S.user_id = C.user_id
GROUP BY S.user_id
ORDER BY confirmation_rate ASC        ;