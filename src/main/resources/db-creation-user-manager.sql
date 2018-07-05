-- schema creation
DROP SCHEMA IF EXISTS `user_manager`;
CREATE SCHEMA `user_manager` DEFAULT CHARACTER SET utf8;

CREATE TABLE `user_manager`.`u_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL,
  `email` VARCHAR(200) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` DATETIME NULL,
  UNIQUE KEY (`id`),
  PRIMARY KEY (`id`, `email`)
);

CREATE TABLE `user_manager`.`u_game` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `setting` VARCHAR(200) NOT NULL,
  `created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` DATETIME NULL,
  UNIQUE KEY (`id`),
  PRIMARY KEY (`name`),
  FOREIGN KEY (`setting`) REFERENCES `card_game`.`m_setting`(`name`)
);

CREATE TABLE `user_manager`.`new_table` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `surname` VARCHAR(200) NULL,
  `score_enrollments` INT NULL,
  `score_credits` INT NULL,
  `position` INT NULL,
  `game` VARCHAR(200) NOT NULL,
  `user_email` VARCHAR(200) NOT NULL,
  `created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` DATETIME NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_email`) REFERENCES `user_manager`.`u_user` (`email`),
  FOREIGN KEY (`game`) REFERENCES `user_manager`.`u_game` (`name`)
);
