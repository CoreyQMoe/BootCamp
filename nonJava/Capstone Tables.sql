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


-- Dumping database structure for pointofsale
CREATE DATABASE IF NOT EXISTS `pointofsale` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `pointofsale`;

-- Dumping structure for table pointofsale.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `custID` int(111) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(10) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `address1` varchar(50) DEFAULT NULL,
  `address2` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(2) DEFAULT NULL,
  `zipCode` int(5) DEFAULT NULL,
  `phoneNumber` bigint(10) NOT NULL,
  `email` varchar(50) NOT NULL DEFAULT 'Declined',
  `active` tinyint(1) NOT NULL DEFAULT 1,
  `created` date NOT NULL DEFAULT curdate(),
  `updated` date DEFAULT curdate(),
  PRIMARY KEY (`custID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table pointofsale.customer: ~5 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`custID`, `firstName`, `lastName`, `address1`, `address2`, `city`, `state`, `zipCode`, `phoneNumber`, `email`, `active`, `created`, `updated`) VALUES
	(1, 'Bill', 'Pullman', '1919 Some St', 'A', 'Shawano', 'WI', 12345, 7155559876, 'yo@domain.com', 1, '2022-02-04', '2022-03-04'),
	(2, 'Edgar', 'Poe', '2929 Scare Ave', NULL, 'Green Bay', 'WI', 54321, 6155551234, 'mtv@school.edu', 1, '2022-03-01', '2022-03-01'),
	(3, 'Edgar', 'Borroughs', '3939 Mars Way', '#312', 'Los Vegas', 'NV', 23145, 7155551234, 'raps@domain.com', 1, '2021-12-04', '2021-12-12'),
	(4, 'Douglas', 'Adams', '4949 Universe Ave', 'B', 'Shawano', 'WI', 12345, 5155554567, 'checkitout@something.org', 1, '2022-03-04', '2022-03-04'),
	(5, 'Wally', 'Cleaver', '5959 Main St', 'Suite 16', 'Chicago', 'IL', 21352, 4155551357, 'Declined', 1, '2022-02-04', '2022-03-04');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table pointofsale.departments
CREATE TABLE IF NOT EXISTS `departments` (
  `deptID` int(111) NOT NULL AUTO_INCREMENT,
  `deptName` varchar(20) NOT NULL DEFAULT 'Need Department Name',
  `created` date NOT NULL DEFAULT curdate(),
  `updated` date DEFAULT curdate(),
  PRIMARY KEY (`deptID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table pointofsale.departments: ~4 rows (approximately)
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` (`deptID`, `deptName`, `created`, `updated`) VALUES
	(1, 'Pets', '2022-03-04', '2022-03-04'),
	(2, 'Membership', '2022-03-04', '2022-03-04'),
	(3, 'Office', '2022-01-04', '2022-03-04'),
	(4, 'Automotive', '2021-11-07', '2021-11-07'),
	(5, 'Clothes', '2021-12-22', '2021-12-25');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;

-- Dumping structure for table pointofsale.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `empID` int(111) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(10) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `address1` varchar(50) NOT NULL,
  `address2` varchar(20) DEFAULT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(2) NOT NULL,
  `zipCode` int(5) NOT NULL,
  `phoneNumber` bigint(10) NOT NULL,
  `email` varchar(20) NOT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `reportsTo` int(111) DEFAULT NULL,
  `created` date NOT NULL DEFAULT curdate(),
  `updated` date DEFAULT curdate(),
  PRIMARY KEY (`empID`),
  KEY `reportsTO` (`reportsTo`) USING BTREE,
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`reportsTo`) REFERENCES `employee` (`empID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table pointofsale.employee: ~5 rows (approximately)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`empID`, `firstName`, `lastName`, `address1`, `address2`, `city`, `state`, `zipCode`, `phoneNumber`, `email`, `active`, `reportsTo`, `created`, `updated`) VALUES
	(1, 'Barry', 'Allen', '2525 Flash Dr', NULL, 'Star City', 'AL', 98765, 9125554321, 'ballen@comp.org', 1, NULL, '2019-03-06', '2019-05-06'),
	(2, 'Bruce', 'Wayne', '3535 Batman Ave', 'Suite B', 'Gotham City', 'NY', 87654, 8125551234, 'brucew@heroes.com', 1, 1, '2020-01-01', '2022-02-28'),
	(3, 'Dick', 'Grayson', '4545 Nightwing Way', '240', 'Gotham City', 'NY', 87654, 8125556789, 'dickieg@domin.com', 1, 2, '2022-03-01', '2022-03-01'),
	(4, 'Oliver', 'Queen', '5555 Grnarw St', 'A', 'Central City', 'NM', 10101, 7125550101, 'arrow@org.org', 0, 1, '2022-03-04', '2022-03-04'),
	(5, 'Ray', 'Palmer', '6565 Atom Ave', NULL, 'Ivy Town', 'CT', 20123, 1125556979, 'mightymite@hero.com', 1, 4, '2020-03-06', '2022-03-04');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Dumping structure for table pointofsale.passwords
CREATE TABLE IF NOT EXISTS `passwords` (
  `passwordID` int(111) NOT NULL AUTO_INCREMENT,
  `empID` int(111) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `created` date NOT NULL DEFAULT curdate(),
  `updated` date DEFAULT curdate(),
  PRIMARY KEY (`passwordID`),
  KEY `empID` (`empID`),
  CONSTRAINT `passwords_ibfk_1` FOREIGN KEY (`empID`) REFERENCES `employee` (`empID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table pointofsale.passwords: ~5 rows (approximately)
/*!40000 ALTER TABLE `passwords` DISABLE KEYS */;
INSERT INTO `passwords` (`passwordID`, `empID`, `PASSWORD`, `created`, `updated`) VALUES
	(1, 1, 'TheFlash', '2022-03-07', '2022-03-07'),
	(2, 2, 'TheBatman', '2022-03-07', '2022-03-07'),
	(3, 3, 'Nightwing', '2022-03-07', '2022-03-07'),
	(4, 4, 'GreenArrow', '2022-03-07', '2022-03-07'),
	(5, 5, 'TheAtom', '2022-03-07', '2022-03-07');
/*!40000 ALTER TABLE `passwords` ENABLE KEYS */;

-- Dumping structure for table pointofsale.products
CREATE TABLE IF NOT EXISTS `products` (
  `prodID` int(111) NOT NULL AUTO_INCREMENT,
  `prodName` varchar(25) NOT NULL,
  `description` varchar(255) NOT NULL DEFAULT 'Description Needed',
  `price` decimal(10,2) NOT NULL,
  `cost` decimal(10,2) NOT NULL,
  `deptID` int(111) DEFAULT NULL,
  `active` tinyint(1) NOT NULL DEFAULT 1,
  `vendorID` int(111) DEFAULT NULL,
  `created` date NOT NULL DEFAULT curdate(),
  `updated` date DEFAULT curdate(),
  PRIMARY KEY (`prodID`),
  KEY `deptID` (`deptID`),
  KEY `FK_products_vendor` (`vendorID`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`deptID`) REFERENCES `departments` (`deptID`),
  CONSTRAINT `products_ibfk_2` FOREIGN KEY (`vendorID`) REFERENCES `vendors` (`VendID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- Dumping data for table pointofsale.products: ~15 rows (approximately)
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`prodID`, `prodName`, `description`, `price`, `cost`, `deptID`, `active`, `vendorID`, `created`, `updated`) VALUES
	(1, 'Cape', 'A sleek black cape', 10.99, 2.49, 5, 0, 1, '2021-03-08', '2021-05-08'),
	(2, 'Mask', 'A mask for hiding your identity', 5.99, 1.19, 5, 1, 1, '2021-03-15', '2022-03-08'),
	(3, 'Wonderdog', 'A k9 side kick', 199.99, 49.99, 1, 1, 2, '2021-01-06', '2022-03-08'),
	(4, 'Tights', 'Sleek black leggings', 19.99, 9.99, 5, 1, 2, '2021-03-11', '2022-03-08'),
	(5, 'Dog Food', 'Food for your k9 side kick', 59.99, 29.99, 1, 1, 3, '2021-01-06', '2022-03-08'),
	(6, 'Tim', 'A lesser known character', 899.99, 12.99, 1, 0, 3, '2021-03-08', '2021-08-15'),
	(7, 'Stapler', 'Milton\'s red stapler', 9.99, 4.99, 3, 0, 4, '2021-08-11', '2022-03-02'),
	(8, 'Office Chair', 'Chair for your secret hideout', 89.99, 59.99, 3, 1, 4, '2021-10-05', '2022-02-03'),
	(9, '100" Monitor', 'A monitor for all the heroes to see', 1009.99, 69.99, 3, 1, 5, '2021-07-11', '2022-03-08'),
	(10, 'Batmobile', 'A bat shaped car', 10000.00, 8000.00, 4, 1, 5, '2021-06-06', '2021-11-28'),
	(11, 'Arrow Plane', 'Green super hero plane', 90000.00, 10000.00, 4, 1, 5, '2021-11-27', '2022-02-22'),
	(12, 'Cosmic Treadmill', 'A time travel device', 100000.00, 99000.00, 4, 0, 4, '2021-12-25', '2022-01-01'),
	(13, 'Suicide Squad', 'Suicide Squad membership', 99.99, 0.99, 2, 0, 3, '2021-04-13', '2022-02-22'),
	(14, 'Justice League', 'Justice League Membership', 99.99, 0.99, 2, 1, 2, '2022-02-28', '2022-03-04'),
	(15, 'Justice Society', 'Justice Society Membership', 99.99, 0.99, 2, 1, 1, '2022-03-07', '2022-03-08');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;

-- Dumping structure for table pointofsale.transactions
CREATE TABLE IF NOT EXISTS `transactions` (
  `transactionID` int(111) NOT NULL AUTO_INCREMENT,
  `custID` int(111) DEFAULT NULL,
  `empID` int(111) NOT NULL,
  `created` date NOT NULL DEFAULT curdate(),
  `updated` date DEFAULT curdate(),
  PRIMARY KEY (`transactionID`),
  KEY `custID` (`custID`),
  KEY `empID` (`empID`),
  CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`custID`) REFERENCES `customer` (`custID`),
  CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`empID`) REFERENCES `employee` (`empID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping data for table pointofsale.transactions: ~8 rows (approximately)
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` (`transactionID`, `custID`, `empID`, `created`, `updated`) VALUES
	(1, 1, 1, '2022-03-04', '2022-03-04'),
	(2, NULL, 1, '2022-03-06', '2022-03-06'),
	(3, NULL, 2, '2022-03-03', '2022-03-03'),
	(4, NULL, 2, '2022-03-02', '2022-03-02'),
	(5, 4, 3, '2022-03-05', '2022-03-06'),
	(6, 2, 3, '2022-03-08', '2022-03-08'),
	(7, NULL, 4, '2022-03-08', '2022-03-08'),
	(8, 3, 4, '2022-03-05', '2022-03-05'),
	(9, 5, 5, '2022-03-04', '2022-03-05'),
	(10, 1, 5, '2022-03-03', '2022-03-03');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;

-- Dumping structure for table pointofsale.transaction_details
CREATE TABLE IF NOT EXISTS `transaction_details` (
  `tDID` int(111) NOT NULL AUTO_INCREMENT,
  `transactionID` int(111) NOT NULL,
  `prodID` int(111) NOT NULL,
  `quantity` int(11) NOT NULL CHECK (`quantity` > 0),
  `created` date NOT NULL DEFAULT curdate(),
  `updated` date DEFAULT curdate(),
  PRIMARY KEY (`tDID`),
  KEY `transactionID` (`transactionID`),
  KEY `prodID` (`prodID`),
  CONSTRAINT `transaction_details_ibfk_1` FOREIGN KEY (`transactionID`) REFERENCES `transactions` (`transactionID`),
  CONSTRAINT `transaction_details_ibfk_2` FOREIGN KEY (`prodID`) REFERENCES `products` (`prodID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- Dumping data for table pointofsale.transaction_details: ~21 rows (approximately)
/*!40000 ALTER TABLE `transaction_details` DISABLE KEYS */;
INSERT INTO `transaction_details` (`tDID`, `transactionID`, `prodID`, `quantity`, `created`, `updated`) VALUES
	(1, 1, 9, 2, '2022-03-15', '2022-03-15'),
	(2, 1, 11, 3, '2022-03-15', '2022-03-15'),
	(3, 1, 10, 1, '2022-03-15', '2022-03-15'),
	(4, 2, 1, 10, '2022-03-15', '2022-03-15'),
	(5, 3, 12, 1, '2022-03-15', '2022-03-15'),
	(6, 3, 5, 3, '2022-03-15', '2022-03-15'),
	(7, 4, 14, 1, '2022-03-15', '2022-03-15'),
	(8, 4, 15, 1, '2022-03-15', '2022-03-15'),
	(9, 4, 13, 1, '2022-03-15', '2022-03-15'),
	(10, 4, 1, 3, '2022-03-15', '2022-03-15'),
	(11, 5, 2, 4, '2022-03-15', '2022-03-15'),
	(12, 5, 8, 1, '2022-03-15', '2022-03-15'),
	(13, 6, 7, 3, '2022-03-15', '2022-03-15'),
	(14, 6, 4, 1, '2022-03-15', '2022-03-15'),
	(15, 7, 6, 1, '2022-03-15', '2022-03-15'),
	(16, 8, 4, 6, '2022-03-15', '2022-03-15'),
	(17, 8, 1, 6, '2022-03-15', '2022-03-15'),
	(18, 8, 2, 6, '2022-03-15', '2022-03-15'),
	(19, 9, 3, 1, '2022-03-15', '2022-03-15'),
	(20, 10, 9, 1, '2022-03-15', '2022-03-15'),
	(21, 10, 11, 1, '2022-03-15', '2022-03-15'),
	(22, 10, 3, 1, '2022-03-15', '2022-03-15'),
	(23, 10, 5, 1, '2022-03-15', '2022-03-15');
/*!40000 ALTER TABLE `transaction_details` ENABLE KEYS */;

-- Dumping structure for table pointofsale.vendors
CREATE TABLE IF NOT EXISTS `vendors` (
  `VendID` int(111) NOT NULL AUTO_INCREMENT,
  `vendName` varchar(20) NOT NULL,
  `address1` varchar(50) DEFAULT NULL,
  `address2` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(2) DEFAULT NULL,
  `zipCode` int(5) DEFAULT NULL,
  `phoneNumber` bigint(10) NOT NULL,
  `repFirstName` varchar(10) NOT NULL,
  `repLastName` varchar(20) NOT NULL,
  `repEmail` varchar(50) NOT NULL,
  `repPhoneNumber` bigint(10) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT 1,
  `created` date NOT NULL DEFAULT curdate(),
  `updated` date DEFAULT curdate(),
  PRIMARY KEY (`VendID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table pointofsale.vendors: ~4 rows (approximately)
/*!40000 ALTER TABLE `vendors` DISABLE KEYS */;
INSERT INTO `vendors` (`VendID`, `vendName`, `address1`, `address2`, `city`, `state`, `zipCode`, `phoneNumber`, `repFirstName`, `repLastName`, `repEmail`, `repPhoneNumber`, `active`, `created`, `updated`) VALUES
	(1, 'Radioactive Spider', '9999 Main St', NULL, 'New York', 'NY', 12345, 9995551234, 'Peter', 'Parker', 'spider@man.com', 9995551235, 1, '2022-03-08', '2022-03-08'),
	(2, 'Gamma Radiation', '8888 N Broadway Ave', 'B', 'Seatle', 'WA', 54321, 8885554321, 'Bruce', 'Banner', 'thehulk@green.com', 8885554322, 1, '2022-03-08', '2022-03-08'),
	(3, 'Alien', '7777 S 115th St', '101', 'New York', 'NY', 12345, 9995559876, 'Clark', 'Kent', 'super@man.com', 9995559999, 1, '2022-03-08', '2022-03-08'),
	(4, 'The Occult', '6666 Egypt Way', NULL, 'Miami', 'FL', 33333, 7775555678, 'Kent', 'Nelson', 'dr@fate.com', 7775559678, 1, '2022-03-08', '2022-03-08'),
	(5, 'Magic Ring', '5555 Airport Dr', '9', 'Eau Claire', 'WI', 54703, 6665554444, 'Hal', 'Jordan', 'green@lantern.com', 6665554443, 1, '2022-03-08', '2022-03-08');
/*!40000 ALTER TABLE `vendors` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
