USE itworkstesttask;

DELETE FROM input_devices;
DELETE FROM components;
DELETE FROM monitors;
DELETE FROM storage_devices;
DELETE FROM peripherals;
DELETE FROM goodstypes;
DELETE FROM ticketsinfo;
DELETE FROM tickets;

COMMIT;

INSERT INTO goodstypes(id, typeName) VALUES
  (1,'Input device'),
  (2,'Component'),
  (3,'Monitor'),
  (4,'Storage device'),
  (5,'Peripheral');
COMMIT;


INSERT INTO input_devices(id, name, typeId, quantity, country, color, illumination,cost) VALUES
  (1,'input1',1,4,'china','pink',FALSE,30 ),
  (2,'input2',1,8,'china','black',FALSE,40 ),
  (3,'input3',1,2,'usa','red',TRUE,80);
COMMIT;

INSERT INTO components(id, name, typeId, quantity, country, brand, weight,cost) VALUES
  (1,'component1',2,3,'china','intel',250,15.6),
  (2,'component2',2,7,'usa','amd',180,50),
  (3,'component3',2,30,'china','nvidia',150,35);
COMMIT;

INSERT INTO monitors(id, name, typeId, quantity, country, brand, size,cost) VALUES
  (1,'monitor1',3,10,'china','samsung',15.6,100),
  (2,'monitor2',3,10,'china','samsung',19,130),
  (3,'monitor3',3,10,'china','dell',21,180);
COMMIT;

INSERT INTO storage_devices(id, name, typeId, quantity, country, brand, capacity,cost) VALUES
  (1,'storage1',4,10,'china','seagate',500,50),
  (2,'storage2',4,10,'china','kingston',120,75),
  (3,'storage3',4,10,'china','samsung',1000,60);
COMMIT;

INSERT INTO peripherals(id, name, typeId, quantity, country, brand, voltage, cost) VALUES
  (1,'p1',5,10,'china','lenovo',220,100),
  (2,'p2',5,10,'china','lenovo',220,100),
  (3,'p3',5,10,'china','lenovo',220,100);
COMMIT;

INSERT INTO tickets(id,dateAndTime, summ) VALUES
  (1,now(),100),
  (2,now(),35),
  (3,now(),150);
COMMIT;

INSERT INTO ticketsinfo(id, ticketId, typeId, goodId, name, amount, cost) VALUES
  (1,1,5,1,'p1',1,100),
  (2,2,2,3,'component3',2,35),
  (3,3,5,3,'p3',1,100),
  (4,3,4,1,'storage1',1,50);
COMMIT;