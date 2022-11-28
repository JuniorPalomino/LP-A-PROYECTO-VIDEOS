-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-11-2022 a las 17:29:31
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `basereserva`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idpersona` int(11) NOT NULL,
  `codigo_cliente` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `idhabitacion` int(11) NOT NULL,
  `numero` varchar(4) NOT NULL,
  `piso` varchar(2) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `caracteristicas` varchar(512) DEFAULT NULL,
  `precio_diario` decimal(7,2) NOT NULL,
  `estado` varchar(15) NOT NULL,
  `tipo_habitacion` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `idpago` int(11) NOT NULL,
  `idreserva` int(11) NOT NULL,
  `tipo_comprobante` varchar(20) NOT NULL,
  `numero_comprobante` varchar(20) NOT NULL,
  `igv` decimal(4,2) NOT NULL,
  `total_pago` decimal(7,2) NOT NULL,
  `fecha_emision` date NOT NULL,
  `fecha_pago` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apaterno` varchar(20) NOT NULL,
  `amaterno` varchar(20) NOT NULL,
  `tipo_documento` varchar(15) NOT NULL,
  `num_documento` varchar(8) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idpersona`, `nombre`, `apaterno`, `amaterno`, `tipo_documento`, `num_documento`, `direccion`, `telefono`, `email`) VALUES
(24, 'Junior ', 'Palomino ', 'Chambilla', 'DNI', '77049057', 'Calle Loreto 115', '915200017', 'juniorpalomino@gmail.com'),
(25, 'Carlos', 'Avila', 'Gutierrez', 'DNI', '71417777', 'Calle Yanahuara 117', '961761475', 'carlosavila@gmail.com'),
(26, 'Gerald', 'Gomez', 'Quispe', 'DNI', '70557896', 'Calle Hunter 119', '924216099', 'geraldgomez@gmail.com'),
(27, 'Kevin', 'Inofuente', 'Ramos', 'DNI', '76631278', 'Calle Miraflores 911', '924982265', 'kevininofuente@gmail.com'),
(28, 'Jose', 'Mejia ', 'Jiron', 'DNI', '72304313', 'Calle Socabaya 122', '958654479', 'josemejia@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `idreserva` int(11) NOT NULL,
  `idhabitacion` int(11) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `idtrabajador` int(11) NOT NULL,
  `tipo_reserva` varchar(20) NOT NULL,
  `fecha_reserva` date NOT NULL,
  `fecha_ingresa` date NOT NULL,
  `fecha_salida` date NOT NULL,
  `costo_alojamiento` decimal(7,2) NOT NULL,
  `estado` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajador`
--

CREATE TABLE `trabajador` (
  `idpersona` int(11) NOT NULL,
  `sueldo` int(200) NOT NULL,
  `acceso` varchar(15) NOT NULL,
  `login` varchar(15) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `trabajador`
--

INSERT INTO `trabajador` (`idpersona`, `sueldo`, `acceso`, `login`, `password`) VALUES
(24, 3000, 'Administrador', 'junior', 'junior'),
(25, 2800, 'Administrador', 'carlos', 'carlos'),
(26, 2000, 'Administrador', 'gerald', 'gerald'),
(27, 2500, 'Administrador', 'kevin', 'kevin'),
(28, 2300, 'Administrador', 'jose', 'jose');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idpersona`),
  ADD UNIQUE KEY `codigo_cliente_UNIQUE` (`codigo_cliente`);

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`idhabitacion`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`idpago`),
  ADD KEY `fk_pago_reserva_idx` (`idreserva`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idpersona`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`),
  ADD UNIQUE KEY `telefono_UNIQUE` (`telefono`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idreserva`),
  ADD KEY `fk_reserva_habitacion_idx` (`idhabitacion`),
  ADD KEY `fk_reserva_cliente_idx` (`idcliente`),
  ADD KEY `fk_reserva_trabajador_idx` (`idtrabajador`);

--
-- Indices de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  ADD PRIMARY KEY (`idpersona`),
  ADD UNIQUE KEY `login_UNIQUE` (`login`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `idhabitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `idpago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idpersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `idreserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`idreserva`) REFERENCES `reserva` (`idreserva`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idpersona`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`idtrabajador`) REFERENCES `trabajador` (`idpersona`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reserva_ibfk_3` FOREIGN KEY (`idhabitacion`) REFERENCES `habitacion` (`idhabitacion`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `trabajador`
--
ALTER TABLE `trabajador`
  ADD CONSTRAINT `trabajador_ibfk_1` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
