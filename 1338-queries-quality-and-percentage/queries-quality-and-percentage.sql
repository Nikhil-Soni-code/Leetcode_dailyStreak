SELECT 
    Q.query_name,
    ROUND(AVG(Q.rating / Q.position), 2) AS quality,
    ROUND(
        SUM(CASE WHEN Q.rating < 3 THEN 1 ELSE 0 END)*100 / COUNT(*),
        2
    ) AS poor_query_percentage
FROM Queries AS Q
GROUP BY Q.query_name;
