-- schema creation
CREATE SCHEMA `card_game` DEFAULT CHARACTER SET utf8;




CREATE TABLE `card_game`.`m_setting` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  UNIQUE KEY (`id`),
  PRIMARY KEY (`name`)
);

CREATE TABLE `card_game`.`m_city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `setting` VARCHAR(45) NOT NULL,
  UNIQUE KEY (`id`),
  PRIMARY KEY (`name`),
  FOREIGN KEY (`setting`) REFERENCES `m_setting`(`name`)
);

CREATE TABLE `card_game`.`m_clue_card` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `value` INT NULL,
  `setting` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`city`) REFERENCES `m_city`(`name`),
  FOREIGN KEY (`setting`) REFERENCES `m_setting`(`name`)
);


INSERT IGNORE INTO `card_game`.`m_setting` (`name`) VALUES
("Cadiz"),
("Algeciras");

INSERT IGNORE INTO `card_game`.`m_city` (`name`, `setting`) VALUES
("Cadiz", "Cadiz"),
("Chiclana de la Frontera", "Cadiz"),
("Conil de la Frontera", "Cadiz"),
("El Puerto de Santa Maria", "Cadiz"),
("Jerez de la Frontera", "Cadiz"),
("Puerto Real", "Cadiz"),
("San Fernando", "Cadiz"),
("Algeciras", "Algeciras"),
("Tarifa", "Algeciras"),
("La Linea", "Algeciras"),
("Gibraltar", "Algeciras");

INSERT IGNORE INTO `card_game`.`m_clue_card` (`city`, `name`, `value`, `setting`) VALUES
("Cadiz", "Catedral", 5, "Cadiz"),
("Cadiz", "Caleta", 8, "Cadiz"),
("Cadiz", "Cortadura", 19, "Cadiz"),
("Cadiz", "Plaza España", 12, "Cadiz"),
("Cadiz", "Puerta Tierra", 15, "Cadiz"),
("Cadiz", "Falla", 26, "Cadiz"),
("Cadiz", "Tavira", 3, "Cadiz"),
("Chiclana de la Frontera", "Castillo", 22, "Cadiz"),
("Chiclana de la Frontera", "Ermita", 29, "Cadiz"),
("Chiclana de la Frontera", "Puntos Magicos", 1, "Cadiz"),
("Chiclana de la Frontera", "Templo", 16, "Cadiz"),
("Chiclana de la Frontera", "Torre", 7, "Cadiz"),
("Conil de la Frontera", "Chanca", 25, "Cadiz"),
("Conil de la Frontera", "Torre Guzman", 32, "Cadiz"),
("El Puerto de Santa Maria", "Bodegas Osborne", 30, "Cadiz"),
("El Puerto de Santa Maria", "Castillo de San Marcos", 21, "Cadiz"),
("El Puerto de Santa Maria", "Iglesia Mayor Prioral", 10, "Cadiz"),
("El Puerto de Santa Maria", "Monasterio de la Victoria", 13, "Cadiz"),
("Jerez de la Frontera", "Campus de Jerez", 9, "Cadiz"),
("Jerez de la Frontera", "Motorista", 28, "Cadiz"),
("Jerez de la Frontera", "Fundador", 2, "Cadiz"),
("Jerez de la Frontera", "Minotauro", 23, "Cadiz"),
("Jerez de la Frontera", "Alcazar", 18, "Cadiz"),
("Puerto Real", "Campus de Puerto Real", 31, "Cadiz"),
("Puerto Real", "Parque Canteras", 20, "Cadiz"),
("Puerto Real", "Cachuca", 17, "Cadiz"),
("San Fernando", "Hornos Punicos", 11, "Cadiz"),
("San Fernando", "Observatorio", 27, "Cadiz"),
("San Fernando", "Playa de Camposoto", 6, "Cadiz"),
("San Fernando", "Salina", 14, "Cadiz"),
("San Fernando", "Teatro", 4, "Cadiz"),
("San Fernando", "Venta de Vargas", 24, "Cadiz"),

("Algeciras", "Plaza Alta", 18, "Algeciras"),
("Algeciras", "Puerto", 12, "Algeciras"),
("Algeciras", "Escuela Politecnica", 7, "Algeciras"),
("Algeciras", "Murallas Merinies", 1, "Algeciras"),
("Algeciras", "Estatua a Paco de Lucia", 15, "Algeciras"),
("Algeciras", "Río de la Miel", 8, "Algeciras"),
("Tarifa", "Puerta de Jerez", 9, "Algeciras"),
("Tarifa", "Ruinas Baeloclaudia", 11, "Algeciras"),
("Tarifa", "Valdevaqueros", 17, "Algeciras"),
("Tarifa", "Castillo de Guzmán", 19, "Algeciras"),
("La Linea", "Pinar del Rey", 13, "Algeciras"),
("La Linea", "Torre de Botafuegos", 3, "Algeciras"),
("La Linea", "Estatua de Camarón", 10, "Algeciras"),
("La Linea", "Torre Nueva", 2, "Algeciras"),
("La Linea", "Poblado de Palmones", 4, "Algeciras"),
("La Linea", "Parque Alcornocales", 21, "Algeciras"),	
("Gibraltar", "Apes Den", 14, "Algeciras"),
("Gibraltar", "Great Siege Tunnels", 6, "Algeciras"),
("Gibraltar", "Moorish Castle", 16, "Algeciras"),
("Gibraltar", "Casemates Square", 5, "Algeciras"),
("Gibraltar", "The Rock", 20, "Algeciras");