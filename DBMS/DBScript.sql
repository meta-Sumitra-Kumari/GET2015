CREATE DATABASE vehicle_management_system;


USE vehicle_management_system;

CREATE TABLE IF NOT EXISTS Vehicle 
(
	vehicle_id INT AUTO_INCREMENT PRIMARY KEY,
	make VARCHAR(20),
	model VARCHAR(20),
	engine_in_cc DOUBLE,
	fuel_capacity DOUBLE,
	milage DOUBLE,
	price DOUBLE,
	road_tax DOUBLE,
	created_by VARCHAR(20),
	created_time TIMESTAMP DEFAULT NOW()
);


CREATE TABLE IF NOT EXISTS Car
(
	car_id INT AUTO_INCREMENT PRIMARY KEY,
	ac tinyint(1),
        power_steering tinyint(1),
        accessory_kit tinyint(1),
        vehicle_id INT,
	CONSTRAINT `vehicle_key` FOREIGN KEY (vehicle_id) REFERENCES Vehicle (vehicle_id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS Bike
(
	bike_id INT AUTO_INCREMENT PRIMARY KEY,
	self_start tinyint(1),
	helmet_price DOUBLE,
        vehicle_id INT,
	CONSTRAINT `vehicle_key1` FOREIGN KEY (vehicle_id) REFERENCES Vehicle (vehicle_id) ON DELETE CASCADE
);

-- ------------------
DROP DATABASE vehicle_management_system;
select * from vehicle; 
select * from car;
select * from bike;
