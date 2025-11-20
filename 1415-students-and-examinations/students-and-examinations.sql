# Write your MySQL query statement below
SELECT Stu.student_id,Stu.student_name,Sub.subject_name,IFNULL(COUNT(Exam.student_id), 0) AS attended_exams
FROM Students AS Stu
CROSS JOIN Subjects AS Sub
LEFT JOIN
Examinations AS Exam
ON Stu.student_id = Exam.student_id AND Sub.subject_name = Exam.subject_name
GROUP BY 
Sub.subject_name,Stu.student_id
ORDER BY Stu.student_id,Sub.subject_name;

-- SELECT 
--     Stu.student_id,
--     Stu.student_name,
--     Sub.subject_name,
--     IFNULL(COUNT(Exam.student_id), 0) AS attended_exams
-- FROM Students AS Stu
-- CROSS JOIN Subjects AS Sub
-- LEFT JOIN Examinations AS Exam
--     ON Stu.student_id = Exam.student_id 
--    AND Sub.subject_name = Exam.subject_name
-- GROUP BY 
--     Stu.student_id,
--     Stu.student_name,
--     Sub.subject_name
-- ORDER BY 
--     Stu.student_id,
--     Sub.subject_name;
