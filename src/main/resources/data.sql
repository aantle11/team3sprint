-- src/main/resources/data.sql

-- Clear (idempotent-ish for H2)
DELETE FROM passenger_aircraft;
DELETE FROM aircraft_airport;
DELETE FROM passenger;
DELETE FROM airport;
DELETE FROM aircraft;
DELETE FROM city;

-- Cities
INSERT INTO city (id, name, state, population) VALUES
  (1,'St. Johns','NL',110525),
  (2,'Halifax','NS',439819),
  (3,'Toronto','ON',2731571);

-- Airports
INSERT INTO airport (id, name, code, city_id) VALUES
  (1,'St. Johns Intl','YYT',1),
  (2,'Halifax Stanfield','YHZ',2),
  (3,'Billy Bishop','YTZ',3),
  (4,'Toronto Pearson','YYZ',3);

-- Aircraft
INSERT INTO aircraft (id, type, airline_name, number_of_passengers) VALUES
  (1,'Boeing 737','WestJet',189),
  (2,'Airbus A320','Air Canada',174),
  (3,'Dash 8 Q400','PAL Airlines',78);

-- Passengers
INSERT INTO passenger (id, first_name, last_name, phone_number, city_id) VALUES
  (1,'Keira','Hancock','709-000-0000',1),
  (2,'Jordan','Button','709-000-0001',1),
  (3,'Matt','Stevenson','902-000-0002',2),
  (4,'Kyle','Samson','416-000-0003',3);

-- Aircraft <-> Airports (aircraft use these airports for takeoff/landing)
INSERT INTO aircraft_airport (aircraft_id, airport_id) VALUES
  (1,1),(1,2),(1,4),   -- 737 uses YYT, YHZ, YYZ
  (2,2),(2,3),(2,4),   -- A320 uses YHZ, YTZ, YYZ
  (3,1),(3,2);         -- Q400 uses YYT, YHZ

-- Passenger <-> Aircraft (who flew on what)
INSERT INTO passenger_aircraft (passenger_id, aircraft_id) VALUES
  (1,1),(1,2),  -- Keira: 737, A320
  (2,3),        -- Alicia: Q400
  (3,1),(3,3),  -- Matt: 737, Q400
  (4,2);        -- Kyle: A320
