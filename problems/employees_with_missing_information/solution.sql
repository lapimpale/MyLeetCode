# Write your MySQL query statement below
SELECT e.employee_id
FROM Employees e
WHERE e.employee_id NOT IN (SELECT employee_id FROM Salaries)
UNION
SELECT s.employee_id
FROM Salaries s
WHERE s.employee_id NOT IN (SELECT employee_id FROM Employees)
ORDER BY employee_id ASC