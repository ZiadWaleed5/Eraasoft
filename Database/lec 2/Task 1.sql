CREATE TABLE Doctor (
    id INT PRIMARY KEY,
    name VARCHAR2(100),
    salary NUMBER(10, 2),
    address VARCHAR2(255)
);

INSERT INTO Doctor (id, name, salary, address) VALUES (1, 'Ahmed Ali', 5000, 'Cairo');
INSERT INTO Doctor (id, name, salary, address) VALUES (2, 'Sara Mohamed', 6000, 'Giza');
INSERT INTO Doctor (id, name, salary, address) VALUES (3, 'Omar Khaled', 4500, 'Alexandria');
INSERT INTO Doctor (id, name, salary, address) VALUES (4, 'Mona Hassan', 7000, 'Tanta');
INSERT INTO Doctor (id, name, salary, address) VALUES (5, 'Mahmoud Saeed', 1000, 'Mansoura');
INSERT INTO Doctor (id, name, salary, address) VALUES (6, 'Noha Youssef', 2000, 'Luxor');
INSERT INTO Doctor (id, name, salary, address) VALUES (7, 'Tarek Ibrahim', 3000, 'Aswan');
INSERT INTO Doctor (id, name, salary, address) VALUES (8, 'Salma Nabil', 8000, 'Suez');
INSERT INTO Doctor (id, name, salary, address) VALUES (9, 'Yasser Taha', 5500, 'Ismailia');
INSERT INTO Doctor (id, name, salary, address) VALUES (10, 'Hoda Fathy', 6500, 'Fayoum');

UPDATE Doctor
SET salary = 20000
WHERE id = 3;

DELETE FROM Doctor
WHERE id = 9;

SELECT name || ' - ' || salary AS Name_And_Salary
FROM Doctor;

SELECT id, name, (salary * 2) AS Doubled_Salary, address
FROM Doctor;

SELECT *
FROM Doctor
WHERE salary IN (1000, 2000, 3000);

ALTER TABLE Doctor RENAME TO PRD_DOCTOR;