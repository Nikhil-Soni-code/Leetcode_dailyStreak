# Write your MySQL query statement below
SELECT teacher_id,COUNT(DISTINCt subject_id) AS cnt
FROM Teacher
GROUP BY teacher_id;