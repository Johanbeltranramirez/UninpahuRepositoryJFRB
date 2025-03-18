-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-03-2025 a las 02:41:41
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `presupuestodb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aprobacion`
--

CREATE TABLE `aprobacion` (
  `id` int(20) NOT NULL,
  `presupuesto_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `estado_id` int(11) NOT NULL,
  `comentarios` text DEFAULT NULL,
  `fechaAprobacion` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoriapresupuesto`
--

CREATE TABLE `categoriapresupuesto` (
  `id` int(3) NOT NULL,
  `nombreCategoria` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejecucionpresupuestaria`
--

CREATE TABLE `ejecucionpresupuestaria` (
  `id` int(10) NOT NULL,
  `partida_id` int(11) NOT NULL,
  `montoReal` decimal(15,2) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadoaprobacion`
--

CREATE TABLE `estadoaprobacion` (
  `id` int(1) NOT NULL,
  `descEstado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadopresupuesto`
--

CREATE TABLE `estadopresupuesto` (
  `id` int(1) NOT NULL,
  `descEstado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partidapresupuestaria`
--

CREATE TABLE `partidapresupuestaria` (
  `id` int(10) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  `descripcion` text NOT NULL,
  `monto` decimal(15,2) NOT NULL,
  `tipo_id` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `presupuestogeneral`
--

CREATE TABLE `presupuestogeneral` (
  `id` int(15) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `montoTotal` decimal(15,2) NOT NULL,
  `estado_id` int(11) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  `fechaCreacion` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int(1) NOT NULL,
  `descRol` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipopartida`
--

CREATE TABLE `tipopartida` (
  `id` int(1) NOT NULL,
  `descTipo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(15) NOT NULL,
  `nDocId` varchar(50) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `rol_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aprobacion`
--
ALTER TABLE `aprobacion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `presupuesto_id` (`presupuesto_id`),
  ADD KEY `usuario_id` (`usuario_id`),
  ADD KEY `estado_id` (`estado_id`);

--
-- Indices de la tabla `categoriapresupuesto`
--
ALTER TABLE `categoriapresupuesto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombreCategoria` (`nombreCategoria`);

--
-- Indices de la tabla `ejecucionpresupuestaria`
--
ALTER TABLE `ejecucionpresupuestaria`
  ADD PRIMARY KEY (`id`),
  ADD KEY `partida_id` (`partida_id`);

--
-- Indices de la tabla `estadoaprobacion`
--
ALTER TABLE `estadoaprobacion`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `descEstado` (`descEstado`);

--
-- Indices de la tabla `estadopresupuesto`
--
ALTER TABLE `estadopresupuesto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `descEstado` (`descEstado`);

--
-- Indices de la tabla `partidapresupuestaria`
--
ALTER TABLE `partidapresupuestaria`
  ADD PRIMARY KEY (`id`),
  ADD KEY `categoria_id` (`categoria_id`),
  ADD KEY `tipo_id` (`tipo_id`);

--
-- Indices de la tabla `presupuestogeneral`
--
ALTER TABLE `presupuestogeneral`
  ADD PRIMARY KEY (`id`),
  ADD KEY `estado_id` (`estado_id`),
  ADD KEY `categoria_id` (`categoria_id`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `descRol` (`descRol`);

--
-- Indices de la tabla `tipopartida`
--
ALTER TABLE `tipopartida`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `descTipo` (`descTipo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nDocId` (`nDocId`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `rol_id` (`rol_id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aprobacion`
--
ALTER TABLE `aprobacion`
  ADD CONSTRAINT `aprobacion_ibfk_1` FOREIGN KEY (`presupuesto_id`) REFERENCES `presupuestogeneral` (`id`),
  ADD CONSTRAINT `aprobacion_ibfk_2` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `aprobacion_ibfk_3` FOREIGN KEY (`estado_id`) REFERENCES `estadoaprobacion` (`id`);

--
-- Filtros para la tabla `ejecucionpresupuestaria`
--
ALTER TABLE `ejecucionpresupuestaria`
  ADD CONSTRAINT `ejecucionpresupuestaria_ibfk_1` FOREIGN KEY (`partida_id`) REFERENCES `partidapresupuestaria` (`id`);

--
-- Filtros para la tabla `partidapresupuestaria`
--
ALTER TABLE `partidapresupuestaria`
  ADD CONSTRAINT `partidapresupuestaria_ibfk_1` FOREIGN KEY (`categoria_id`) REFERENCES `categoriapresupuesto` (`id`),
  ADD CONSTRAINT `partidapresupuestaria_ibfk_2` FOREIGN KEY (`tipo_id`) REFERENCES `tipopartida` (`id`);

--
-- Filtros para la tabla `presupuestogeneral`
--
ALTER TABLE `presupuestogeneral`
  ADD CONSTRAINT `presupuestogeneral_ibfk_1` FOREIGN KEY (`estado_id`) REFERENCES `estadopresupuesto` (`id`),
  ADD CONSTRAINT `presupuestogeneral_ibfk_2` FOREIGN KEY (`categoria_id`) REFERENCES `categoriapresupuesto` (`id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
