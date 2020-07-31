-- inserting some sample user details --
insert into user  values(1001,'1976-03-01','FN1', 'LN3','test1@ryjios.com', 'test1' );
insert into user  values(1002,'1976-03-01','FN2', 'LN3','test2@ryjios.com', 'test2' );
insert into user  values(1003,'1976-03-01','FN3', 'LN3','test3@ryjios.com', 'test3' );

-- inserting some sample device details --
--create table monitoring_device (id integer not null, device_id varchar(255), device_name varchar(255), user_id integer, primary key (id))

insert into monitoring_device values(1001, 'device-1', 'Living Room', 1001);
insert into monitoring_device values(1002, 'device-2', 'Living Room', 1002);
insert into monitoring_device values(1003, 'device-3', 'Living Room', 1003);

insert into monitoring_device values(1004, 'device-4', 'Dining Room', 1001);
insert into monitoring_device values(1005, 'device-5', 'Dining Room', 1002);
insert into monitoring_device values(1006, 'device-6', 'Dining Room', 1003);

--create table co2sensor_data (id integer not null, captured_time timestamp, reading decimal(19,2), status varchar(255), device_id integer, primary key (id))
insert into co2sensor_data values (1001, CURRENT_TIMESTAMP , 12.34, 'Normal', 1001);
insert into co2sensor_data values (1002, CURRENT_TIMESTAMP , 12.35, 'Normal', 1002);
insert into co2sensor_data values (1003, CURRENT_TIMESTAMP , 12.36, 'Normal', 1003);
insert into co2sensor_data values (1004, CURRENT_TIMESTAMP , 11.34, 'Normal', 1004);
insert into co2sensor_data values (1005, CURRENT_TIMESTAMP , 11.35, 'Normal', 1005);
insert into co2sensor_data values (1006, CURRENT_TIMESTAMP , 11.36, 'Normal', 1006);

insert into co2sensor_data values (1007, CURRENT_TIMESTAMP , 13.34, 'Normal', 1001);
insert into co2sensor_data values (1008, CURRENT_TIMESTAMP , 13.35, 'Normal', 1002);
insert into co2sensor_data values (1009, CURRENT_TIMESTAMP , 13.36, 'Normal', 1003);
insert into co2sensor_data values (1010, CURRENT_TIMESTAMP , 14.34, 'Normal', 1004);
insert into co2sensor_data values (1011, CURRENT_TIMESTAMP , 14.35, 'Normal', 1005);
insert into co2sensor_data values (1012, CURRENT_TIMESTAMP , 14.36, 'Normal', 1006);

insert into co2sensor_data values (1013, CURRENT_TIMESTAMP , 15.34, 'Normal', 1001);
insert into co2sensor_data values (1014, CURRENT_TIMESTAMP , 15.35, 'Normal', 1002);
insert into co2sensor_data values (1015, CURRENT_TIMESTAMP , 15.36, 'Normal', 1003);
insert into co2sensor_data values (1016, CURRENT_TIMESTAMP , 16.34, 'Normal', 1004);
insert into co2sensor_data values (1017, CURRENT_TIMESTAMP , 16.35, 'Normal', 1005);
insert into co2sensor_data values (1018, CURRENT_TIMESTAMP , 16.36, 'Normal', 1006);