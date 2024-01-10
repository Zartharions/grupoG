CREATE DATABASE IF NOT EXISTS `AlmacenesTia` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `AlmacenesTia`;

CREATE TABLE Usuario (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(250) NOT NULL,
    Contraseña VARCHAR(250) NOT NULL,
    Tipos_usuarios VARCHAR(250) NOT NULL
);

CREATE TABLE Cliente (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Ci INT(20) NOT NULL,
    Nombre VARCHAR(150) NOT NULL,
    Telefono INT(15),
    Direccion VARCHAR(200),
    Razon VARCHAR(200),
    Fecha DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Proveedor (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Ruc INT(20) NOT NULL,
    Nombre VARCHAR(150) NOT NULL,
    Telefono INT(15),
    Direccion VARCHAR(200),
    Razon VARCHAR(200),
    Fecha DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Productos (
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Codigo VARCHAR(30) NOT NULL,
    Nombre VARCHAR(255) NOT NULL,
    ProveedorId INT,
    Stock INT(20),
    Precio DECIMAL(10,2),
    Fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ProveedorId) REFERENCES Proveedor(id)
);

CREATE TABLE Detalles (
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Codigo_Producto INT,
    Cantidad INT(20),
    Precio DECIMAL(10,2),
    Id_Venta INT(20),
    FOREIGN KEY (Codigo_Producto) REFERENCES Productos(Id),
    FOREIGN KEY (Id_Venta) REFERENCES Ventas(Id)
);

CREATE TABLE Ventas (
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ClienteId INT,
    Vendedor VARCHAR(200),
    Total DECIMAL(10,2),
    Fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ClienteId) REFERENCES Cliente(id)
);

select * from Usuario;
select * from cliente;
select * from Proveedor;
select * from Productos;
select * from Detalles;
select * from Ventas;


Truncate Ventas;

ALTER TABLE cliente Modify Ci varchar (255);


INSERT INTO Cliente (Ci, Nombre, Telefono, Direccion, Razon)
VALUES
  (1101122334, 'Juan Perez', 0987654321, 'Quito', 'Personal'),
  (1201122335, 'Maria Gonzalez', 0123456789, 'Guayaquil', 'Mayoreo'),
  (1001122336, 'Luis Ramirez', 0765432109, 'Cuenca', 'Personal'),
  (1111122337, 'Ana Rodriguez', 0543210987, 'Ambato', 'Mayoreo'),
  (1011122338, 'Carlos Sanchez', 0123456780, 'Loja', 'Personal'),
  (1101122339, 'Isabel Mendoza', 0987654321, 'Manta', 'Mayoreo'),
  (1201122340, 'Pedro Suarez', 0123456789, 'Portoviejo', 'Personal'),
  (1001122341, 'Laura Guzman', 0765432109, 'Santo Domingo', 'Mayoreo'),
  (1111122342, 'Miguel Lopez', 0543210987, 'Ibarra', 'Personal'),
  (1011122343, 'Carmen Torres', 0123456780, 'Esmeraldas', 'Mayoreo'),
  (1101122344, 'Jorge Castro', 0987654321, 'Coca', 'Personal'),
  (1201122345, 'Gabriela Vargas', 0123456789, 'Quevedo', 'Mayoreo'),
  (1001122346, 'Fernando Medina', 0765432109, 'Zamora', 'Personal'),
  (1111122347, 'Monica Ordoñez', 0543210987, 'Machala', 'Mayoreo'),
  (1011122348, 'Hector Palacios', 0123456780, 'Riobamba', 'Personal');

INSERT INTO Productos (Codigo, Nombre, Proveedor, Stock, Precio)
VALUES
  ('1122', 'Galletas saladas', 'Nabisco', 80, 1.75),
  ('3344', 'Shampoo anti-caspa', 'Head & Shoulders', 35, 5.50),
  ('5566', 'Acondicionador reparador', 'Pantene', 30, 4.75),
  ('7788', 'Jabón de tocador suave', 'Dove', 90, 2.25),
  ('9900', 'Cepillo de dientes suave', 'Colgate', 65, 1.75),
  ('2233', 'Pasta dental blanqueadora', 'Colgate', 45, 3.00),
  ('4455', 'Pan blanco', 'Bimbo', 120, 1.20),
  ('6677', 'Yogur natural', 'Danone', 40, 1.75),
  ('8899', 'Queso cheddar', 'Kraft Heinz', 50, 4.25),
  ('0011', 'Café instantáneo', 'Nescafé', 60, 4.75),
  ('2233', 'Agua mineral', 'Coca-Cola', 75, 1.00),
  ('1122', 'Galletas de chocolate', 'Nabisco', 70, 2.25),
  ('3344', 'Shampoo hidratante', 'Pantene', 25, 6.00),
  ('5566', 'Acondicionador voluminizador', 'Pantene', 20, 5.25),
  ('7788', 'Jabón líquido corporal', 'Dove', 85, 2.50),
  ('9900', 'Cepillo de dientes medio', 'Colgate', 60, 1.95),
  ('2233', 'Pasta dental para niños', 'Colgate', 35, 2.75),
  ('4455', 'Pan integral multigrano', 'Bimbo', 100, 1.50),
  ('6677', 'Yogur de frutas', 'Danone', 45, 2.00),
  ('8899', 'Queso suizo', 'Kraft Heinz', 40, 4.50),
  ('0011', 'Café descafeinado', 'Nescafé', 50, 5.00);


INSERT INTO Proveedor (Ruc, Nombre, Telefono, Direccion, Razon)
VALUES
  (1234567890, 'Nabisco', 0998765432, 'Quito', 'Proveedor de Galletas y Snacks'),
  (234567890, 'Head & Shoulders', 0987654321, 'Guayaquil', 'Proveedor de Productos para el Cabello'),
  (345678901, 'Pantene', 0976543210, 'Cuenca', 'Proveedor de Productos para el Cabello'),
  (456789012, 'Dove', 0965432109, 'Manta', 'Proveedor de Productos de Cuidado Personal'),
  (567890123, 'Colgate', 0954321098, 'Ambato', 'Proveedor de Artículos de Higiene Bucal'),
  (678901234, 'Bimbo', 0943210987, 'Loja', 'Proveedor de Panadería y Repostería'),
  (789012345, 'Danone', 0932109876, 'Portoviejo', 'Proveedor de Productos Lácteos'),
  (890123456, 'Kraft Heinz', 0921098765, 'Santo Domingo', 'Proveedor de Alimentos y Condimentos'),
  (901234567, 'Nescafé', 0910987654, 'Ibarra', 'Proveedor de Café y Bebidas Instantáneas'),
  (112233445, 'Coca-Cola', 0909876543, 'Esmeraldas', 'Proveedor de Bebidas Gaseosas y Aguas');



