DROP DATABASE IF EXISTS panderexo;
CREATE DATABASE panderexo;
USE panderexo;


-- Create the tables.

CREATE TABLE IF NOT EXISTS `user` (
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    address VARCHAR(255) NULL,
    postcode VARCHAR(255) NULL,
    city VARCHAR(50) NULL,
    phone VARCHAR(15) NULL,
    email VARCHAR(50) NOT NULL,
    website VARCHAR(255) NULL,
    created_at DATE NULL,
    updated_at DATE NULL,
    UNIQUE (email)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS candidate (
	user_id BIGINT PRIMARY KEY NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES `user`(id)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS company (
	user_id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    siret VARCHAR(20) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES `user`(id)
)ENGINE=InnoDB;

-- 2

INSERT INTO `user` (email) VALUES ('test@candidate.fr');
INSERT INTO candidate (user_id, lastname, firstname) VALUES ((SELECT id FROM `user` WHERE email = 'test@candidate.fr'), "john", "snow"); 
INSERT INTO `user` (email) VALUES ('test@company.fr'); 
INSERT INTO company (user_id, name, siret) VALUES ((SELECT id FROM `user` WHERE email = 'test@company.fr'), "TACT factory", "00000000000000"); 

-- 3

SELECT u.id, c.lastname, c.firstname, u.created_at, u.email, u.phone FROM `user` u INNER JOIN candidate c ON u.id = c.user_id;

-- 4

CREATE TABLE IF NOT EXISTS job (
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    user_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    created_at DATE NULL,
    updated_at DATE NULL,
    FOREIGN KEY (user_id) REFERENCES company(user_id)
)ENGINE=InnoDB;

INSERT INTO job (user_id, name) VALUES ((SELECT user_id FROM company WHERE name = "TACT factory"), "Laveur de schtroumpf");
INSERT INTO job (user_id, name) VALUES ((SELECT user_id FROM company WHERE name = "TACT factory"), "Masseur de gargamel");

-- 5

SELECT j.name AS "intitulé", CONCAT(c.name, "(", c.siret, ")"), u.city, u.website FROM job j INNER JOIN company c ON c.user_id = j.user_id INNER JOIN `user` u ON u.id = c.user_id;

-- 6

DELIMITER |
CREATE DEFINER=`root`@`localhost` PROCEDURE `buildCandidate`(IN email VARCHAR(255), IN lastname VARCHAR(255), IN firstname VARCHAR(255))
BEGIN
	START TRANSACTION;
		INSERT INTO `user` (email, created_at) VALUES (email, NOW());
		INSERT INTO candidate (user_id, lastname, firstname) VALUES (LAST_INSERT_ID(), lastname, firstname);
	COMMIT;
END|
DELIMITER ;

CALL buildCandidate("email","nom","prénom");

-- 7

CALL buildCandidate("test@candidate2.fr","john2","snow2");
INSERT INTO `user` (email) VALUES ('test@company2.fr'); 
INSERT INTO company (user_id, name, siret) VALUES ((SELECT id FROM `user` WHERE email = 'test@company2.fr'), "TACT factory", "00000000000000"); 

-- 8

CREATE TABLE IF NOT EXISTS skill (
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    created_at DATETIME NULL
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS candidate_skill (
    user_id BIGINT NOT NULL,
    skill_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES candidate(user_id),
    FOREIGN KEY (skill_id) REFERENCES skill(id),
    PRIMARY KEY (user_id, skill_id)
)ENGINE=InnoDB;

-- 9

INSERT INTO skill (name, created_at) VALUES ("Feignant", NOW());
INSERT INTO skill (name, created_at) VALUES ("Stressé", NOW());
INSERT INTO skill (name, created_at) VALUES ("Incompétent", NOW());

SET @skill_a = (SELECT id FROM skill WHERE name = "Feignant");
SET @skill_b = (SELECT id FROM skill WHERE name = "Stressé");
SET @skill_c = (SELECT id FROM skill WHERE name = "Incompétent");
SET @candidate_a = (SELECT user_id FROM candidate WHERE lastname = "john" AND firstname = "snow");
SET @candidate_b = (SELECT user_id FROM candidate WHERE lastname = "john2" AND firstname = "snow2");
INSERT INTO candidate_skill (user_id, skill_id) VALUES (@candidate_a, @skill_a);
INSERT INTO candidate_skill (user_id, skill_id) VALUES (@candidate_a, @skill_b);
INSERT INTO candidate_skill (user_id, skill_id) VALUES (@candidate_a, @skill_c);
INSERT INTO candidate_skill (user_id, skill_id) VALUES (@candidate_b, @skill_a);
INSERT INTO candidate_skill (user_id, skill_id) VALUES (@candidate_b, @skill_c);

-- 10

SELECT CONCAT(UPPER(c.lastname), " ", LOWER(c.firstname)), CONCAT(COUNT(cs.user_id),"/",(SELECT COUNT(id) FROM skill)) 
FROM candidate c 
INNER JOIN candidate_skill cs 
ON c.user_id = cs.user_id 
GROUP BY cs.user_id;