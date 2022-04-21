CREATE DATABASE IF NOT EXISTS `pointofsale`;
USE `pointofsale`;

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(111) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(10) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(2) NOT NULL,
  `zip_code` int(5) NOT NULL,
  `phone_number` int(10) NOT NULL,
  `email` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `active` BOOLEAN DEFAULT 1,
  `created` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`);

INSERT INTO `users` (`id`, `first_name`, `last_name`, `address`, `city`, `state`, `zip_code`, `phone_number`, `email`, `password`, `active`, `created`) VALUES
	(1, 'Barry', 'Allen', '2525 Flash Dr', 'Star City', 'AL', 98765, 9125554321, 'ballen@comp.org', '$2a$12$rrTqb6gpGv0CcQgGKTDZ3OqZjfRQD94RYcswxDxC/m/u6PA/Bj8z6', 1, '2019-03-06'),
	(2, 'Bruce', 'Wayne', '3535 Batman Ave', 'Gotham City', 'NY', 87654, 8125551234, 'brucew@heroes.com', '$2a$12$rrTqb6gpGv0CcQgGKTDZ3OqZjfRQD94RYcswxDxC/m/u6PA/Bj8z6', 1, '2020-01-01'),
	(3, 'Dick', 'Grayson', '4545 Nightwing Way', 'Gotham City', 'NY', 87654, 8125556789, 'dickieg@domin.com', '$2a$12$rrTqb6gpGv0CcQgGKTDZ3OqZjfRQD94RYcswxDxC/m/u6PA/Bj8z6', 1, '2022-03-01'),
	(4, 'Oliver', 'Queen', '5555 Grnarw St', 'Central City', 'NM', 10101, 7125550101, 'arrow@org.org', 0, '$2a$12$rrTqb6gpGv0CcQgGKTDZ3OqZjfRQD94RYcswxDxC/m/u6PA/Bj8z6', '2022-03-04'),
	(5, 'Ray', 'Palmer', '6565 Atom Ave', 'Ivy Town', 'CT', 20123, 1125556979, 'mightymite@hero.com', 1, '$2a$12$rrTqb6gpGv0CcQgGKTDZ3OqZjfRQD94RYcswxDxC/m/u6PA/Bj8z6', '2020-03-06');
    
    INSERT INTO `user_roles` (`id`, `user_id`, `user_role`) values
		(1, 1, `USER`),
        (2, 2, `USER`),
        (3, 3, `USER`),
        (4, 4, `USER`),
        (5, 5, `USER`),
        (6, 1, `ADMIN`),
        (7, 5, `ADMIN`);

CREATE TABLE IF NOT EXISTS `items` (
  `id` int(111) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `description` varchar(255) NOT NULL DEFAULT 'Description Needed',
  `price` float(25) NOT NULL,
  `cost` float(25) NOT NULL,
  `department_id` int(111) NOT NULL,
  `active` int(1) NOT NULL DEFAULT 1,
  `vendor_id` int(111) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  CONSTRAINT `department_id` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`),
  CONSTRAINT `vendor_id` FOREIGN KEY (`vendor_id`) REFERENCES `vendors` (`id`));

INSERT INTO `items` (`id`, `name`, `description`, `price`, `cost`, `department_id`, `active`, `vendor_id`, `created`) VALUES
	(1, 'Cape', 'A sleek black cape', 10.99, 2.49, 5, 0, 1, '2021-03-08'),
	(2, 'Mask', 'A mask for hiding your identity', 5.99, 1.19, 5, 1, 1, '2021-03-15'),
	(3, 'Wonderdog', 'A k9 side kick', 199.99, 49.99, 1, 1, 2, '2021-01-06'),
	(4, 'Tights', 'Sleek black leggings', 19.99, 9.99, 5, 1, 2, '2021-03-11'),
	(5, 'Dog Food', 'Food for your k9 side kick', 59.99, 29.99, 1, 1, 3, '2021-01-06'),
	(6, 'Tim', 'A lesser known character', 899.99, 12.99, 1, 0, 3, '2021-03-08'),
	(7, 'Stapler', 'Milton\'s red stapler', 9.99, 4.99, 3, 0, 4, '2021-08-11'),
	(8, 'Office Chair', 'Chair for your secret hideout', 89.99, 59.99, 3, 1, 4, '2021-10-05'),
	(9, '100" Monitor', 'A monitor for all the heroes to see', 1009.99, 69.99, 3, 1, 5, '2021-07-11'),
	(10, 'Batmobile', 'A bat shaped car', 10000.00, 8000.00, 4, 1, 5, '2021-06-06'),
	(11, 'Arrow Plane', 'Green super hero plane', 90000.00, 10000.00, 4, 1, 5, '2021-11-27'),
	(12, 'Cosmic Treadmill', 'A time travel device', 100000.00, 99000.00, 4, 0, 4, '2021-12-25'),
	(13, 'Suicide Squad', 'Suicide Squad membership', 99.99, 0.99, 2, 0, 3, '2021-04-13'),
	(14, 'Justice League', 'Justice League Membership', 99.99, 0.99, 2, 1, 2, '2022-02-28'),
	(15, 'Justice Society', 'Justice Society Membership', 99.99, 0.99, 2, 1, 1, '2022-03-07');

CREATE TABLE IF NOT EXISTS `transactions` (
  `id` int(111) NOT NULL AUTO_INCREMENT,
  `users_id` int(111) NOT NULL,
  `payment` varchar(6) NOT NULL DEFAULT 'CASH',
  `created` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  CONSTRAINT `users_id` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`);

INSERT INTO `transactions` (`id`, `users_id`, `created`) VALUES
	(1, 1, 1, '2022-03-04'),
	(2, NULL, 1, '2022-03-06'),
	(3, NULL, 2, '2022-03-03'),
	(4, NULL, 2, '2022-03-02'),
	(5, 4, 3, '2022-03-05'),
	(6, 2, 3, '2022-03-08'),
	(7, NULL, 4, '2022-03-08'),
	(8, 3, 4, '2022-03-05'),
	(9, 5, 5, '2022-03-04'),
	(10, 1, 5, '2022-03-03');
    
CREATE TABLE IF NOT EXISTS `transaction_details` (
  `id` int(111) NOT NULL AUTO_INCREMENT,
  `transaction_id` int(111),
  `item_id` int(111),
  `quantity` int(11) NOT NULL CHECK (`quantity` > 0),
  PRIMARY KEY (`id`),
  CONSTRAINT `transaction_id` FOREIGN KEY (`transaction_id`) REFERENCES `transactions` (`id`),
  CONSTRAINT `item_id` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`));

INSERT INTO `transaction_details` (`id`, `transaction_id`, `item_id`, `quantity`) VALUES
	(1, 1, 9, 2),
	(2, 1, 11, 3),
	(3, 1, 10, 1),
	(4, 2, 1, 10),
	(5, 3, 12, 1),
	(6, 3, 5, 3),
	(7, 4, 14, 1),
	(8, 4, 15, 1),
	(9, 4, 13, 1),
	(10, 4, 1, 3),
	(11, 5, 2, 4),
	(12, 5, 8, 1),
	(13, 6, 7, 3),
	(14, 6, 4, 1),
	(15, 7, 6, 1),
	(16, 8, 4, 6),
	(17, 8, 1, 6),
	(18, 8, 2, 6),
	(19, 9, 3, 1),
	(20, 10, 9, 1),
	(21, 10, 11, 1),
	(22, 10, 3, 1),
	(23, 10, 5, 1);