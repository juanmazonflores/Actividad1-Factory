CREATE DATABASE telefonos
USE telefonos

CREATE TABLE telefonos (
nombre CHAR(30) NOT NULL,
dirección CHAR(30) NOT NULL,
teléfono CHAR(12) PRIMARY KEY NOT NULL,
observaciones CHAR(240)
)

INSERT INTO telefonos VALUES ("Juan Perez", "Zaragoza",
"976111222","Es el profesor")

SELECT * FROM telefonos

