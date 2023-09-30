-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-09-2023 a las 16:45:08
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gamers`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `cve_prov` tinyint(3) UNSIGNED NOT NULL COMMENT 'Clave del proveedor',
  `nom_prov` varchar(25) COLLATE utf8_spanish_ci NOT NULL COMMENT 'Nombre',
  `email_prov` varchar(35) COLLATE utf8_spanish_ci DEFAULT NULL COMMENT 'Email',
  `tel_prov` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL COMMENT 'Teléfono'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`cve_prov`, `nom_prov`, `email_prov`, `tel_prov`) VALUES
(1, 'Microsoft', 'ventas@microsoft.com', '8154789520'),
(2, 'Videojuegos Monterrey', 'videojuegos.mty@hotm', '8127653099'),
(3, 'Game Star', 'games@star.com', '818392001'),
(4, 'Fatima', 'fatima.sanchezps@uanl.edu.mx', ' 528127540833'),
(5, 'Jatziri', 'fatimajatziri@hotmail.com', '1010101010'),
(6, 'Prueba 2', 'prueba@proveedor.com', '7878787878');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `videojuegos`
--

CREATE TABLE `videojuegos` (
  `cve_vid` smallint(5) UNSIGNED NOT NULL COMMENT 'clave',
  `tit_vid` varchar(25) COLLATE utf8_spanish_ci NOT NULL COMMENT 'titulo',
  `pre_vid` decimal(10,2) UNSIGNED NOT NULL COMMENT 'precio',
  `cveprov_vid` tinyint(3) UNSIGNED NOT NULL COMMENT 'Clave de proveedor',
  `inv_vid` smallint(5) UNSIGNED NOT NULL COMMENT 'Inventario'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `videojuegos`
--

INSERT INTO `videojuegos` (`cve_vid`, `tit_vid`, `pre_vid`, `cveprov_vid`, `inv_vid`) VALUES
(1, 'Mario Bross', '100.00', 1, 5),
(2, 'Mario Kart', '100.99', 1, 20),
(3, 'Overwatch', '0.99', 1, 10),
(4, 'Call of Duty', '899.56', 2, 34),
(5, 'Mario Party', '499.00', 2, 5),
(6, 'Fortnite', '999.00', 3, 3),
(7, 'FIFA', '890.00', 1, 18),
(8, 'PubG', '50.00', 2, 50),
(9, 'Mario Kart 2', '50.00', 1, 1),
(10, 'Mario Kart 3', '50.00', 1, 2),
(11, 'Mario Kart 4', '50.00', 1, 10),
(12, 'Mortal Kombat 3', '300.00', 1, 30),
(13, 'Mortal Kombat 3', '300.00', 1, 3),
(14, 'Splatoon', '1450.50', 1, 200),
(15, 'Mario Kart 5', '100.00', 1, 100),
(16, 'Mortal Kombat 5', '999.00', 3, 12),
(20, 'Nuevo', '12.00', 1, 1),
(21, 'Nuevo 2', '100.00', 1, 5),
(22, 'Nuevo 3', '30.00', 1, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`cve_prov`);

--
-- Indices de la tabla `videojuegos`
--
ALTER TABLE `videojuegos`
  ADD PRIMARY KEY (`cve_vid`),
  ADD KEY `cveProveedor` (`cveprov_vid`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `cve_prov` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Clave del proveedor', AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `videojuegos`
--
ALTER TABLE `videojuegos`
  MODIFY `cve_vid` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'clave', AUTO_INCREMENT=23;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `videojuegos`
--
ALTER TABLE `videojuegos`
  ADD CONSTRAINT `videojuegos_ibfk_1` FOREIGN KEY (`cveprov_vid`) REFERENCES `proveedores` (`cve_prov`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
