-- Drop/create DB.

DROP DATABASE IF EXISTS firepanda;
CREATE DATABASE firepanda;
USE firepanda;


-- Create the tables.

CREATE TABLE IF NOT EXISTS students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    lastname VARCHAR(255),
    firstname VARCHAR(255),
    birthdate DATE,
    address VARCHAR(255),
    phone VARCHAR(15)
)ENGINE=InnoDB;


-- Insert examples.

INSERT INTO students
(lastname, firstname)
VALUES
('SCHOCH', 'Patrice'),
('Skywalker', 'Luke'),
('Skywalker', 'Anakin'),
('Skywalker', 'Padme après mariage'),
('Wookie', 'Carl-Eric');

-- C'est le 12 en fait mais ça montre mal le format du coup ... :-E
INSERT INTO students
(lastname, firstname, birthdate)
VALUES
('Pourchasse', 'Joël', '1964-01-13');
-- other type examples
-- - for mysql datetime '1989-08-26 05:26:30'
-- - for positive int 15 (not '15')
-- - for negative int -15 (not '-15')
-- - for float 10000000.20 (not '10000000.20', 10000000,20, 10,000,000.20)
-- - for time '20:04:59'
-- - for boolean TRUE|FALSE (mysql accepts 0|1 -- not a good idea)


-- DELETE examples.

-- DELETE FROM students; -- Amazing idea! Delete all data in table.
DELETE FROM students
WHERE firstname='Carl-Eric' AND lastname='Wookie';


-- UPDATE examples.

-- Add not null column without DEFAULT.
ALTER TABLE students ADD fullname VARCHAR(500) NULL;
UPDATE students SET fullname=CONCAT(firstname, ' ', lastname);
ALTER TABLE students MODIFY fullname VARCHAR(511) NOT NULL;
-- Could be (with default) : ALTER TABLE students ADD fullname VARCHAR(500) NOT NULL DEFAULT CONCAT(firstname, ' ', lastname);

UPDATE students SET birthdate='1964-01-12', phone='0622143944'
WHERE firstname='Joël'
AND lastname='Pourchasse';

-- SELECT examples.

-- Get all columns from all records from students.
SELECT * FROM students;

-- Get all lastname from students.
SELECT lastname FROM students;

-- Get all wookie case insensitive.
SELECT * FROM students WHERE LOWER(lastname)='wookie';

-- Get student nb by lastname.
SELECT lastname, COUNT(id) as 'nb' FROM students GROUP BY lastname;
-- Result :
-- lastname     nb
-- SCHOCH       1
-- Skywalker    3
-- Pourchasse   1

-- Get adults -- could use YEAR.
SELECT * FROM students WHERE SUBSTR(birthdate, 0, 4) < YEAR(CURDATE())-18;

-- List student by alphabetic order -- lastname ASC then firstname DESC).
SELECT * FROM students ORDER BY lastname, firstname DESC;

-- Get students from Rennes.
SELECT * FROM students
WHERE LOWER(address) LIKE '%rennes%'; -- Accept a lot of bad response.

-- Get student with firstname which starts with p|P
SELECT * FROM students WHERE LOWER(SUBSTR(firstname, 0, 1))='p';
-- Or.
SELECT * FROM students WHERE LOWER(firstname) LIKE 'p%';
-- Same but only first result.
SELECT * FROM students WHERE LOWER(firstname) LIKE 'p%' LIMIT 1;

-- Get all lastname with its occurence nb if >= 3.
SELECT lastname, count(id) as nb FROM students
GROUP BY lastname
HAVING count(id) >= 3;

-- Get namesake (french = "homonymes").
SELECT lastname, firstname, count(id) as nb FROM students GROUP BY lastname, firstname HAVING count(id)>1;
-- Result Empty.
-- Add namesake.
INSERT INTO students (fullname, lastname, firstname, phone)
VALUES
('Julien Niord', 'Niord', 'Julien', '0645314799'),
('Copieur', 'Niord', 'Julien', 'euuuuuu');
-- Recheck result : Niord    | Julien    |  2 .

-- 1)

ALTER TABLE students ADD score INT;
ALTER TABLE students ADD created_at DATETIME;
ALTER TABLE students ADD updated_at DATETIME;

CREATE TABLE IF NOT EXISTS abilities (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	label VARCHAR(255)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS student_ability (
	student_id BIGINT NOT NULL,
	abilities_id BIGINT NOT NULL,
	created_at DATETIME,
	updated_at DATETIME,
	PRIMARY KEY (student_idn, abilities_id)
	FOREIGN KEY (student_id) REFERENCES students(id),
	CONSTRAINT FK_titre_moisis FOREIGN KEY (abilities_id) REFERENCES abilities(id)
) ENGINE=InnoDB;


-- 2)
SELECT firstname, lastname FROM students WHERE address IS NULL AND phone IS NULL;

-- 3)
UPDATE students SET score = 0, updated_at = CURDATE() WHERE address IS NULL AND phone IS NULL;
UPDATE students SET score = 25, updated_at = CURDATE() WHERE address IS NOT NULL;
UPDATE students SET score = 50, updated_at = CURDATE() WHERE phone IS NOT NULL;
UPDATE students SET score = 75, updated_at = CURDATE() WHERE address IS NOT NULL AND phone IS NOT NULL;

-- 4)

SELECT firstname, lastname FROM students WHERE LOWER(SUBSTRING(lastname,1,3)) = 'sky' LIMIT 2

-- 5)

INSERT INTO abilities (label) VALUES ('java'); 
INSERT INTO abilities (label) VALUES ('c++');
INSERT INTO abilities (label) VALUES ('marcher dans le ciel');
INSERT INTO abilities (label) VALUES ('invoquer des licornes');
INSERT INTO abilities (label) VALUES ('méthodologie');

--6)

INSERT INTO student_ability (student_id, abilities_id, created_at, updated_at) 
VALUES (
	(SELECT id 
		FROM students 
		WHERE lastname = 'Skywalker' AND firstname = 'Anakin'), 
	(SELECT id 
		FROM abilities 
		WHERE label = 'marcher dans le ciel'), 
	CURDATE(), 
	CURDATE()
);

-- 7) 

SELECT firstname, lastname FROM students
WHERE id NOT IN (SELECT student_id FROM student_ability);

--8)

INSERT INTO student_ability (student_id, abilities_id, created_at, updated_at) 
	SELECT id, (SELECT id FROM abilities WHERE label = 'marcher dans le ciel'), CURDATE(), CURDATE() 
		FROM students 
		WHERE LOWER(lastname) = 'skywalker' 
		AND student_id NOT IN (
			SELECT student_id FROM student_ability 
			WHERE abilities_id=(SELECT id FROM abilities WHERE label='marcher dans le ciel')
);

-- Gwénolé)

DELIMITER $$
CREATE TRIGGER `students_BEFORE_INSERT` BEFORE INSERT ON `students` FOR EACH ROW BEGIN
	SET NEW.created_at = CURDATE();
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `students_BEFORE_UPDATE` BEFORE UPDATE ON `students` FOR EACH ROW BEGIN
	SET NEW.updated_at = CURDATE();
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `student_ability_BEFORE_INSERT` BEFORE INSERT ON `student_ability` FOR EACH ROW BEGIN
	SET NEW.created_at = CURDATE();
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `student_ability_BEFORE_UPDATE` BEFORE UPDATE ON `student_ability` FOR EACH ROW BEGIN
	SET NEW.updated_at = CURDATE();
END
$$
DELIMITER ;
-- 9)

ALTER TABLE students DROP updated_at;
ALTER TABLE student_ability DROP updated_at;

-- 10)

ALTER TABLE students ADD email VARCHAR(255);
UPDATE students SET email = 'skywalker@la-force.fr' WHERE LOWER(lastname) = 'skywalker';

-- 11)


UPDATE students SET phone = '000001' WHERE LOWER(firstname) = 'patrice';

-- 12) 

UPDATE students SET score=0;
UPDATE students SET score=score+50 WHERE phone IS NOT NULL;
UPDATE students SET score=score+25 WHERE address IS NOT NULL;

-- 13)

DELETE FROM students WHERE phone IS NULL AND address IS NULL;

-- 14)

ALTER TABLE students CHANGE address mail;

-- 15 6)

# inutile

-- 15 7) 

SELECT * FROM students s
LEFT JOIN student_ability sa ON s.id = sa.student_id
WHERE sa.abilities_id IS NULL

-- 15 8)

INSERT INTO student_ability (student_id, abilities_id, created_at)
    SELECT
        s.id,
        a.id,
        CURDATE()
    FROM students s, abilities a
    WHERE LOWER(s.lastname)='skywalker'
      AND LOWER(a.label)='marcher dans le ciel';

INSERT INTO student_ability (student_id, abilities_id, created_at)
    SELECT
        s.id,
        a.id,
        CURDATE()
    FROM abilities a, students s
    LEFT JOIN student_ability sa ON s.id = sa.student_id
    WHERE LOWER(s.lastname)='skywalker'
      AND LOWER(a.label)='marcher dans le ciel'
      AND sa.student_id IS NULL;

-- 16)
SELECT s.*, a.label  FROM students s
LEFT JOIN student_ability sa ON s.id = sa.student_id
LEFT JOIN abilities a ON a.id = sa.abilities_id

--17)
SELECT a.label FROM abilities a
INNER JOIN student_ability sa ON a.id = sa.abilities_id
GROUP BY a.label