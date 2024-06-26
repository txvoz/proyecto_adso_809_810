-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 27-06-2024 a las 01:18:36
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `siparqueo_80_81`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bill`
--

CREATE TABLE `bill` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `user_id` int(11) NOT NULL,
  `fee_id` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  `value` int(11) NOT NULL,
  `parking_service_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `bill`
--

INSERT INTO `bill` (`id`, `date`, `user_id`, `fee_id`, `count`, `value`, `parking_service_id`) VALUES
(2, '2024-06-12', 1, 2, 2, 213123123, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fee`
--

CREATE TABLE `fee` (
  `id` int(11) NOT NULL,
  `value` int(11) NOT NULL,
  `type` enum('HORA','DIA','SEMANA','MES') NOT NULL,
  `date` date NOT NULL,
  `reference_type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `fee`
--

INSERT INTO `fee` (`id`, `value`, `type`, `date`, `reference_type`) VALUES
(1, 1000, 'HORA', '2024-03-13', 1),
(2, 20000, 'DIA', '2024-03-13', 1),
(3, 50000, 'SEMANA', '2024-03-13', 1),
(4, 100000, 'MES', '2024-03-13', 1),
(5, 1500, 'HORA', '2024-03-13', 2),
(6, 30000, 'DIA', '2024-03-13', 2),
(7, 60000, 'SEMANA', '2024-03-13', 2),
(8, 120000, 'MES', '2024-03-13', 2),
(9, 5000, 'HORA', '2024-03-13', 3),
(10, 80000, 'DIA', '2024-03-13', 3),
(11, 180000, 'SEMANA', '2024-03-13', 3),
(12, 300000, 'MES', '2024-03-13', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parking_service`
--

CREATE TABLE `parking_service` (
  `id` int(11) NOT NULL,
  `income_date` datetime NOT NULL,
  `exit_date` datetime DEFAULT NULL,
  `vehicle_id` int(11) NOT NULL,
  `zone_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `income_user_id` int(11) NOT NULL,
  `exit_user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `parking_service`
--

INSERT INTO `parking_service` (`id`, `income_date`, `exit_date`, `vehicle_id`, `zone_id`, `customer_id`, `income_user_id`, `exit_user_id`) VALUES
(1, '2024-06-13 03:30:25', NULL, 1, 1, 3, 1, NULL),
(2, '2024-06-13 03:31:04', NULL, 1, 1, 1, 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reference_type`
--

CREATE TABLE `reference_type` (
  `id` int(11) NOT NULL,
  `title` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reference_type`
--

INSERT INTO `reference_type` (`id`, `title`) VALUES
(2, 'AUTOMOVIL'),
(3, 'CARRO PESADO'),
(1, 'MOTO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `title` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `title`) VALUES
(1, 'ADMIN'),
(2, 'AUX'),
(7, 'AUX_2'),
(3, 'CLIENT');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `born_date` date NOT NULL,
  `color` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `avatar` varchar(60) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `rol_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `full_name`, `born_date`, `color`, `email`, `phone`, `avatar`, `password`, `rol_id`) VALUES
(1, 'Albany', '2024-02-26', '#999', 'admin@sena.edu.co', '12312312313', '1-juan123-avatar.png', '', 3),
(2, 'Gustavo Adolfo', '2000-01-01', '#c22e2e', 'garodriguez335@misena.edu.co', '8382057', '9069.021498058155-x2.jpg', '', 2),
(3, 'Gaby', '1990-01-01', '#1630b1', 'julianurrutia554@gmail.com', '45645456456', '3306.702573977841-x1.png', '', 1),
(5, 'reert', '2024-06-10', '#999', 'admen@sena.edu.co', '12312312313', '1-juan123-avatar.png', 'contraseña123', 1),
(9, 'reert', '2024-06-10', '#999', 'adm7@sena.edu.co', '12312312313', '1-juan123-avatar.png', 'contraseña123', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehicle`
--

CREATE TABLE `vehicle` (
  `id` int(11) NOT NULL,
  `plate` varchar(10) NOT NULL,
  `brand` varchar(15) NOT NULL,
  `color` varchar(10) NOT NULL,
  `description` text NOT NULL,
  `reference_type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vehicle`
--

INSERT INTO `vehicle` (`id`, `plate`, `brand`, `color`, `description`, `reference_type_id`) VALUES
(1, 'abc123', 'mazda', 'rojo', '', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zone`
--

CREATE TABLE `zone` (
  `id` int(11) NOT NULL,
  `title` varchar(15) NOT NULL,
  `status` enum('ACTIVO','INACTIVO') NOT NULL,
  `reference_type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `zone`
--

INSERT INTO `zone` (`id`, `title`, `status`, `reference_type_id`) VALUES
(1, 'A1', 'ACTIVO', 2),
(2, 'A2', 'ACTIVO', 2),
(3, 'A3', 'ACTIVO', 2),
(4, 'A4', 'ACTIVO', 2),
(5, 'A5', 'ACTIVO', 2),
(6, 'A6', 'ACTIVO', 2),
(7, 'A7', 'ACTIVO', 2),
(8, 'A8', 'ACTIVO', 2),
(9, 'A9', 'ACTIVO', 2),
(10, 'A10', 'ACTIVO', 2),
(17, 'C1', 'ACTIVO', 3),
(18, 'C2', 'ACTIVO', 3),
(19, 'C3', 'ACTIVO', 3),
(20, 'C4', 'ACTIVO', 3),
(21, 'C5', 'ACTIVO', 3),
(22, 'M1', 'ACTIVO', 1),
(23, 'M2', 'ACTIVO', 1),
(24, 'M3', 'ACTIVO', 1),
(25, 'M4', 'ACTIVO', 1),
(26, 'M5', 'ACTIVO', 1),
(27, 'M6', 'ACTIVO', 1),
(28, 'M7', 'ACTIVO', 1),
(29, 'M8', 'ACTIVO', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `fee_id` (`fee_id`),
  ADD KEY `parking_service_id` (`parking_service_id`);

--
-- Indices de la tabla `fee`
--
ALTER TABLE `fee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `reference_type` (`reference_type`);

--
-- Indices de la tabla `parking_service`
--
ALTER TABLE `parking_service`
  ADD PRIMARY KEY (`id`),
  ADD KEY `vehicle_id` (`vehicle_id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `income_user_id` (`income_user_id`),
  ADD KEY `exit_user_id` (`exit_user_id`),
  ADD KEY `zone_id` (`zone_id`);

--
-- Indices de la tabla `reference_type`
--
ALTER TABLE `reference_type`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `title` (`title`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `title` (`title`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `rol_id` (`rol_id`);

--
-- Indices de la tabla `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `plate` (`plate`),
  ADD KEY `type_id` (`reference_type_id`);

--
-- Indices de la tabla `zone`
--
ALTER TABLE `zone`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `title` (`title`),
  ADD KEY `reference_type_id` (`reference_type_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bill`
--
ALTER TABLE `bill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `fee`
--
ALTER TABLE `fee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `parking_service`
--
ALTER TABLE `parking_service`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `reference_type`
--
ALTER TABLE `reference_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `zone`
--
ALTER TABLE `zone`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `fk_bill_fee` FOREIGN KEY (`fee_id`) REFERENCES `fee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_bill_parking_service` FOREIGN KEY (`parking_service_id`) REFERENCES `parking_service` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_bill_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `fee`
--
ALTER TABLE `fee`
  ADD CONSTRAINT `fk_fee_reference_type` FOREIGN KEY (`reference_type`) REFERENCES `reference_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `parking_service`
--
ALTER TABLE `parking_service`
  ADD CONSTRAINT `fk_parking_service_customer` FOREIGN KEY (`customer_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_parking_service_exit_user` FOREIGN KEY (`exit_user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_parking_service_income_user` FOREIGN KEY (`income_user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_parking_service_vehicle` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_parking_service_zone` FOREIGN KEY (`zone_id`) REFERENCES `zone` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_user_rol` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `vehicle`
--
ALTER TABLE `vehicle`
  ADD CONSTRAINT `fk_vehicle_reference_type` FOREIGN KEY (`reference_type_id`) REFERENCES `reference_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `zone`
--
ALTER TABLE `zone`
  ADD CONSTRAINT `fk_zone_reference_type` FOREIGN KEY (`reference_type_id`) REFERENCES `reference_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
