-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 16, 2015 at 09:04 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `payroll`
--

-- --------------------------------------------------------

--
-- Table structure for table `departments`
--

CREATE TABLE IF NOT EXISTS `departments` (
  `name` varchar(20) NOT NULL,
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `designations`
--

CREATE TABLE IF NOT EXISTS `designations` (
  `name` varchar(40) NOT NULL,
  `basic_pay` double DEFAULT NULL,
  `house_allowance` double DEFAULT NULL,
  `leave_allowance` double DEFAULT NULL,
  `december_welfare` double DEFAULT NULL,
  `pension` double DEFAULT NULL,
  `maternity_allowance` double DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE IF NOT EXISTS `payments` (
  `date_of_payment` date NOT NULL,
  `staff_id` varchar(45) NOT NULL,
  `departmental_id` int(11) NOT NULL,
  `designation` varchar(45) NOT NULL,
  `amount` float DEFAULT NULL,
  KEY `staff_id_idx` (`staff_id`),
  KEY `department_id_idx` (`departmental_id`),
  KEY `designation_idx` (`designation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE IF NOT EXISTS `staff` (
  `staff_id` varchar(6) NOT NULL,
  `fname` varchar(15) DEFAULT NULL,
  `lname` varchar(15) DEFAULT NULL,
  `other_names` varchar(15) NOT NULL,
  `email` text,
  `marrital_status` enum('single','married','divorced','complicated') DEFAULT NULL,
  `picture` text,
  `bank` enum('FBN','GTB','FCMB','UBA','FIDELITY') DEFAULT NULL,
  `account_no` int(11) DEFAULT NULL,
  `date_joined` date DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `residential_address` text,
  `permanent_address` text,
  `next_of_kin` varchar(45) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `salary_to_date` double DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `designation` varchar(40) NOT NULL,
  `last_maternity_date` date DEFAULT NULL,
  `leave_date` date DEFAULT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `department_id` FOREIGN KEY (`departmental_id`) REFERENCES `departments` (`department_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `designation` FOREIGN KEY (`designation`) REFERENCES `designations` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `staff_id` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
