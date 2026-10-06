CREATE TABLE manager(
	
	id	   	CHAR(4),
	name    VARCHAR(20),
	age		NUMBER(2),
	birth_date	DATE,
	address		VARCHAR(50)

);


SELECT * FROM manager;

ALTER TABLE manager DROP COLUMN address;
ALTER TABLE manager ADD(city_address VARCHAR(50), street VARCHAR(30));

SELECT * FROM manager;


ALTER TABLE manager RENAME COLUMN name TO full_name;


SELECT * FROM manager;


ALTER TABLE manager READ ONLY;


SELECT * FROM manager;


CREATE TABLE Owner AS SELECT id , full_name , birth_date FROM manager;


SELECT * FROM Owner;


RENAME manager TO Master;


SELECT * FROM Master;


DROP TABLE Master;
DROP TABLE Owner;