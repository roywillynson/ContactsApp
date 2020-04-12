# Programa de Contacto

_Este programa es un CRUD de contacto que exporta e importa CSV (Proyecto Final de Programación 1)_

### Pre-requisitos 📋

_Script sql ( MySQL )_

```-- -----------------------------------
--        CREAR BASE DE DATOS
-- -----------------------------------
CREATE DATABASE agenda;
-- ------------------------------------
--        USAR BASE DE DATOS AGENDA
-- -------------------------------------	
USE agenda;
-- ------------------------------------
--        CREAR TABLA AGENDA
-- -------------------------------------
CREATE TABLE contactos(
    id_contacto INT AUTO_INCREMENT NOT NULL,
    foto mediumblob,
    nombre VARCHAR(40) NOT NULL,
    apellido VARCHAR(40) NOT NULL,
    company VARCHAR(100) DEFAULT 'no company',
    posicion VARCHAR(50),
    email VARCHAR(255) ,
    telefono VARCHAR(15),
    Notas VARCHAR(255),


    CONSTRAINT pk_id_contacto PRIMARY KEY(id_contacto) ,
    CONSTRAINT uq_email UNIQUE(id_contacto)

) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8mb4;
```

## Construido con 🛠️

* [Commons CSV](http://commons.apache.org/proper/commons-csv/download_csv.cgi) - Libreria para escribir y leer CSV
* [Mysql Connector ( JDBC Driver )](https://www.mysql.com/products/connector/) - libreria para conectarse a la base de datos

## Autor ✒️

* **Roy Willynson del Orbe Medina** - *Matricula: 2018 7315* 
