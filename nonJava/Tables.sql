-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.7.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for casestudy
CREATE DATABASE IF NOT EXISTS `casestudy` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;
USE `casestudy`;

-- Dumping structure for table casestudy.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `first_name` varchar(45) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(45) COLLATE utf8mb4_bin NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_name` varchar(45) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table casestudy.users: ~8 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `email`, `first_name`, `password`, `create_date`, `last_name`) VALUES
	(1, 'eheilig@perscholas.org', 'Eric', 'password', '2022-03-31 16:22:13', 'Heilig'),
	(2, 'emai@email.org', 'first', 'password', '2022-03-31 16:22:13', 'last'),
	(3, 'party@foul.com', 'party', 'asdf', '2022-03-31 16:22:13', 'foul'),
	(4, 'q@q.qq', 'q', 'qqq', '2022-04-01 15:37:40', 'q'),
	(5, 'pink@minkey.com', '#inc', 'test', '2022-04-04 15:17:15', 'monley'),
	(6, 'w@ww.WW', 'tester', 'test', '2022-04-05 09:55:48', 'tester'),
	(7, 'new@email.com', 'dude', 'test', '2022-04-06 12:07:41', 'dude'),
	(8, 'd@d.dd', 'dd', 'ddd', '2022-04-06 23:25:37', 'dd');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
