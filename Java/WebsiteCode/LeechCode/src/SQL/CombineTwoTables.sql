-- CREATE TABLE Person(
--     personID INT PRIMARY KEY,
--     lastName VARCHAR,
--     firstName VARCHAR
-- )

-- CREATE TABLE Address(
--     addressId INT,
--     personId INT,
--     city VARCHAR,
--     state VARCHAR
-- )

--  376 ms 0B
SELECT FirstName, LastName, City, State
FROM Person LEFT JOIN Address
ON Person.PersonId = Address.PersonId;