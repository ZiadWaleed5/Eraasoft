ALTER TABLE employees RENAME COLUMN EMPLOYEEID TO emp_id;
ALTER TABLE employees RENAME COLUMN FIRSTNAME TO first_name;
ALTER TABLE employees RENAME COLUMN LASTNAME TO last_name;
ALTER TABLE employees RENAME COLUMN DEPARTMENT TO department_id;
ALTER TABLE employees RENAME COLUMN SALARY TO salary;
ALTER TABLE employees RENAME COLUMN MANAGERID TO manager_id;
ALTER TABLE employees RENAME COLUMN JOBID TO JOB_ID;
ALTER TABLE employees RENAME COLUMN HIREDATE TO hire_date;




SELECT * 
FROM employees 
WHERE emp_id BETWEEN 100 AND 105;

SELECT * 
FROM employees 
WHERE emp_id IN (151, 152, 153, 154, 155);

SELECT * 
FROM employees 
WHERE first_name LIKE 'P%' OR first_name LIKE 'p%';

SELECT * 
FROM employees 
WHERE first_name LIKE '%A' OR first_name LIKE '%a';

SELECT * 
FROM employees 
WHERE first_name LIKE '%A%' OR first_name LIKE '%a%';

SELECT * 
FROM employees 
WHERE first_name LIKE '__e%' OR first_name LIKE '__E%';

SELECT * 
FROM employees 
WHERE manager_id IS NULL;

SELECT * 
FROM employees 
WHERE manager_id IS NOT NULL;

INSERT INTO employees (emp_id, first_name, last_name, JOB_ID, manager_id) 
VALUES (999, 'Ahmed', 'Ali', 'IT_PROG', NULL);

SELECT * 
FROM employees 
WHERE JOB_ID IN ('AD_VP', 'IT_PROG');

SELECT * 
FROM employees 
ORDER BY last_name ASC;

SELECT * 
FROM employees 
ORDER BY hire_date DESC;

SELECT * 
FROM employees 
ORDER BY department_id ASC, salary DESC;

SELECT emp_id, first_name, LOWER(last_name) AS last_name_lowercase, JOB_ID, department_id 
FROM employees;

SELECT emp_id, UPPER(first_name) AS first_name_uppercase, last_name, JOB_ID, department_id 
FROM employees;

SELECT emp_id, INITCAP(first_name) AS first_name_titlecase, INITCAP(last_name) AS last_name_titlecase 
FROM employees;

SELECT * 
FROM employees 
WHERE LOWER(last_name) = 'smith';