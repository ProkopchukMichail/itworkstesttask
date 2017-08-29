CREATE DATABASE IF NOT EXISTS itworkstesttask;
USE itworkstesttask;
CREATE SCHEMA IF NOT EXISTS itworkstesttask;

DROP TABLE IF EXISTS input_devices;
DROP TABLE IF EXISTS storage_devices;
DROP TABLE IF EXISTS components;
DROP TABLE IF EXISTS monitors;
DROP TABLE IF EXISTS peripherals;
DROP TABLE IF EXISTS goodstypes;
DROP TABLE IF EXISTS ticketsInfo;
DROP TABLE IF EXISTS tickets;


CREATE TABLE goodstypes
(
  id INT(4) PRIMARY KEY AUTO_INCREMENT,
  typeName VARCHAR(50) NOT NULL UNIQUE
) ENGINE = InnoDB;


CREATE TABLE input_devices
(
  id INT(11) PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  typeId INT(4),
  quantity INT(5),
  country VARCHAR(25),
  color VARCHAR(20) DEFAULT 'Black',
  illumination BOOLEAN DEFAULT FALSE,
  cost FLOAT(6),
  CONSTRAINT FK_1 FOREIGN KEY (typeId) REFERENCES goodstypes(id)
) ENGINE = InnoDB;

CREATE TABLE components
(
  id INT(11) PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  typeId INT(4),
  quantity INT(5),
  country VARCHAR(25),
  brand VARCHAR(50),
  weight INT(10),
  cost FLOAT(6),
  CONSTRAINT FK_2 FOREIGN KEY (typeId) REFERENCES goodstypes(id)
) ENGINE = InnoDB;

CREATE TABLE storage_devices
(
  id INT(11) PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  typeId INT(4),
  quantity INT(5),
  country VARCHAR(25),
  brand VARCHAR(50),
  capacity INT(6),
  cost FLOAT(6),
  CONSTRAINT FK_3 FOREIGN KEY (typeId) REFERENCES goodstypes(id)
) ENGINE = InnoDB;

CREATE TABLE monitors
(
  id INT(11) PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  typeId INT(4),
  quantity INT(5),
  country VARCHAR(25),
  brand VARCHAR(50),
  size FLOAT(6),
  cost FLOAT(6),
  CONSTRAINT FK_4 FOREIGN KEY (typeId) REFERENCES goodstypes(id)
) ENGINE = InnoDB;

CREATE TABLE peripherals
(
  id INT(11) PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  typeId INT(4),
  quantity INT(5),
  country VARCHAR(25),
  brand VARCHAR(50),
  voltage INT(5),
  cost FLOAT(6),
  CONSTRAINT FK_5 FOREIGN KEY (typeId) REFERENCES goodstypes(id)
) ENGINE = InnoDB;

CREATE TABLE tickets
(
  id INT(11) PRIMARY KEY AUTO_INCREMENT,
  dateAndTime DATETIME,
  summ FLOAT(8)
) ENGINE = InnoDB;

CREATE TABLE ticketsInfo
(
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  ticketId int(11),
  typeId int(4),
  goodId int(11),
  name VARCHAR(50),
  cost FLOAT(6),
  CONSTRAINT FK_6 FOREIGN KEY (ticketId) REFERENCES tickets(id)
) ENGINE =InnoDB;



