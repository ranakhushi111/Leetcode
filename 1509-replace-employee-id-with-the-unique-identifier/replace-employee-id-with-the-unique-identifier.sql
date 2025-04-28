# Write your MySQL query statement below
SELECT e.name, euni.unique_id
FROM Employees e
LEFT JOIN EmployeeUNI euni
ON e.id=euni.id;