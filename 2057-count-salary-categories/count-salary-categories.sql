SELECT 'Low Salary' AS category,
       (SELECT COUNT(*) FROM Accounts WHERE income < 20000) AS accounts_count

UNION ALL

SELECT 'Average Salary' AS category,
       (SELECT COUNT(*) FROM Accounts WHERE income BETWEEN 20000 AND 50000) AS accounts_count

UNION ALL

SELECT 'High Salary' AS category,
       (SELECT COUNT(*) FROM Accounts WHERE income > 50000) AS accounts_count
