DROP TABLE IF EXISTS `ale_house` CASCADE;
CREATE TABLE `ale_house` (
	`id` LONG PRIMARY KEY AUTO_INCREMENT,
	`gameOfGwent` BOOLEAN,
	`drink` VARCHAR(255), 
	`food` VARCHAR(255), 
	`name` VARCHAR(255),
	`price` INTEGER
);