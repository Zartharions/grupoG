-- Crear la base de datos 'AlmacenesTia' si aún no existe
CREATE DATABASE IF NOT EXISTS `AlmacenesTia` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Seleccionar la base de datos 'AlmacenesTia' para su uso
USE `AlmacenesTia`;

-- Crear la tabla 'productos' para almacenar información sobre productos
CREATE TABLE `productos` (
  `id` int NOT NULL AUTO_INCREMENT, -- Identificador único de producto
  `codigo` int NOT NULL, -- Código del producto
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL, -- Nombre del producto
  `precio` decimal(10,2) NOT NULL, -- Precio del producto (número decimal con dos decimales)
  `cantidad` int NOT NULL, -- Cantidad disponible en inventario
  PRIMARY KEY(id) -- Definir 'id' como clave primaria
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;