SELECT 
    ROUND((
        SELECT COUNT(A1.player_id)
        FROM Activity A1
        JOIN Activity A2
            ON A1.player_id = A2.player_id
           AND DATEDIFF(A1.event_date, A2.event_date) = 1
           AND A2.event_date = (SELECT MIN(event_date) FROM Activity WHERE player_id = A2.player_id)
    )
    /
    (
        SELECT COUNT(DISTINCT player_id)
        FROM Activity
    ),2) AS fraction;
