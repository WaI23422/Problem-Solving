-- CREATE TABLE Employee(
--     id INT,
--     name VARCHAR,
--     salary VARCHAR,
--     manageID INT
-- );

-- 339 ms 0B
SELECT e.name as Employee
FROM Employee e
INNER JOIN Employee m
ON e.managerId = m.id
WHERE e.salary > m.salary;