DROP SCHEMA IF EXISTS `user_manager`;
CREATE SCHEMA `user_manager` DEFAULT CHARACTER SET utf8;

DROP TABLE IF EXISTS `user_manager`.`u_user`;
CREATE TABLE `user_manager`.`u_user` (
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
