-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 06, 2024 at 05:13 AM
-- Server version: 8.0.31
-- PHP Version: 8.1.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `midinerodb`
--

-- --------------------------------------------------------

--
-- Table structure for table `cartera`
--

DROP TABLE IF EXISTS `cartera`;
CREATE TABLE IF NOT EXISTS `cartera` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dinero` double DEFAULT NULL,
  `moneda` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `cartera`
--

INSERT INTO `cartera` (`id`, `dinero`, `moneda`) VALUES
(1, 4500, 'SOLES');

-- --------------------------------------------------------

--
-- Table structure for table `egresos`
--

DROP TABLE IF EXISTS `egresos`;
CREATE TABLE IF NOT EXISTS `egresos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `Descripcion` text NOT NULL,
  `monto` double NOT NULL,
  `tipo_egreso` int NOT NULL,
  `id_cartera` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_egreso_idx` (`tipo_egreso`),
  KEY `fk_egresos_cartera_idx` (`id_cartera`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `egresos`
--

INSERT INTO `egresos` (`id`, `fecha`, `Descripcion`, `monto`, `tipo_egreso`, `id_cartera`) VALUES
(1, '2023-09-12', 'COMPRE COMIDA POR PEDIDOS YA', 35.65, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `ingresos`
--

DROP TABLE IF EXISTS `ingresos`;
CREATE TABLE IF NOT EXISTS `ingresos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `Descripcion` text NOT NULL,
  `monto` double NOT NULL,
  `tipo_ingreso` int NOT NULL,
  `id_cartera` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ingreso_idx` (`tipo_ingreso`),
  KEY `fk_cartera_ingreso_idx` (`id_cartera`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ingresos`
--

INSERT INTO `ingresos` (`id`, `fecha`, `Descripcion`, `monto`, `tipo_ingreso`, `id_cartera`) VALUES
(1, '2023-09-10', 'CAEN', 2500, 1, 1),
(2, '2023-09-20', 'gaming', 9, 1, 1),
(3, '2023-09-20', 'gaming', 400, 1, 1),
(4, '2023-11-15', 'gaming', 2500, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tipo_egreso`
--

DROP TABLE IF EXISTS `tipo_egreso`;
CREATE TABLE IF NOT EXISTS `tipo_egreso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `Descripcion` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tipo_egreso`
--

INSERT INTO `tipo_egreso` (`id`, `name`, `Descripcion`) VALUES
(1, 'COMIDAS', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tipo_ingreso`
--

DROP TABLE IF EXISTS `tipo_ingreso`;
CREATE TABLE IF NOT EXISTS `tipo_ingreso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `Descripcion` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tipo_ingreso`
--

INSERT INTO `tipo_ingreso` (`id`, `name`, `Descripcion`) VALUES
(1, 'PROGRAMADOR\r\n', NULL),
(2, 'LOCADOR', 'DEL CAEN');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `egresos`
--
ALTER TABLE `egresos`
  ADD CONSTRAINT `fk_egreso` FOREIGN KEY (`tipo_egreso`) REFERENCES `tipo_egreso` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_egresos_cartera` FOREIGN KEY (`id_cartera`) REFERENCES `cartera` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ingresos`
--
ALTER TABLE `ingresos`
  ADD CONSTRAINT `fk_cartera_ingreso` FOREIGN KEY (`id_cartera`) REFERENCES `cartera` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ingreso` FOREIGN KEY (`tipo_ingreso`) REFERENCES `tipo_ingreso` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
