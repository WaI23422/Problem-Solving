-- CREATE TABLE Person(
--     id INT,
--     email VARCHAR
-- );

-- 351 ms 0B
SELECT DISTINCT e.email AS Email
FROM Person e
INNER JOIN Person m
ON e.email = m.email
WHERE e.id <> m.id

-- 366 ms 0B
SELECT Email FROM PERSON GROUP BY EMAIL HAVING COUNT(*)>1;