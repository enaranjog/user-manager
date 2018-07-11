select * from u_user;

show create table u_user;
show create table u_players;
show create table u_game;
show create table u_player_score;

DROP SCHEMA IF EXISTS `user_manager`;
CREATE SCHEMA `user_manager` DEFAULT CHARACTER SET utf8;

CREATE TABLE `u_user` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `name` varchar(200) DEFAULT NULL,
   `email` varchar(200) NOT NULL,
   `password` varchar(200) NOT NULL,
   `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `modified` datetime DEFAULT NULL,
   `user_name` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`email`),
   UNIQUE KEY `id` (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
 
 CREATE TABLE `u_game` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `name` varchar(200) NOT NULL,
   `setting` varchar(200) NOT NULL,
   `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `modified` datetime DEFAULT NULL,
   PRIMARY KEY (`name`),
   UNIQUE KEY `id` (`id`),
   KEY `setting` (`setting`),
   CONSTRAINT `u_game_ibfk_1` FOREIGN KEY (`setting`) REFERENCES `card_game`.`m_setting` (`name`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 CREATE TABLE `u_players` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `name` varchar(200) NOT NULL,
   `game` varchar(200) NOT NULL,
   `user_email` varchar(200) NOT NULL,
   `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `modified` datetime DEFAULT NULL,
   PRIMARY KEY (`name`,`user_email`),
   UNIQUE KEY `id` (`id`),
   KEY `user_email` (`user_email`),
   KEY `game` (`game`),
   CONSTRAINT `u_players_ibfk_1` FOREIGN KEY (`user_email`) REFERENCES `u_user` (`email`),
   CONSTRAINT `u_players_ibfk_2` FOREIGN KEY (`game`) REFERENCES `u_game` (`name`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 CREATE TABLE `u_player_score` (
   `id` bigint(20) NOT NULL,
   `game` varchar(255) DEFAULT NULL,
   `player_name` varchar(255) DEFAULT NULL,
   `position` int(11) DEFAULT NULL,
   `score_credits` int(11) DEFAULT NULL,
   `score_enrollments` int(11) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=MyISAM DEFAULT CHARSET=utf8