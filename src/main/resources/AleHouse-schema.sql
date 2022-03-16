DROP TABLE IF EXISTS `ale_house` CASCADE;
CREATE TABLE `ale_house` (
	`id` LONG PRIMARY KEY AUTO_INCREMENT,
	`game_Of_Gwent` BOOLEAN NOT NULL,
	`drink` VARCHAR(255), 
	`food` VARCHAR(255), 
	`name` VARCHAR(255),
	`price` INTEGER
);