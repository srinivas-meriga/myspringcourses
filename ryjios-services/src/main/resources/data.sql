
/** 
inserting some sample user details --
create table user (user_id varchar(255) not null, brith_date timestamp, first_name varchar(255), 
last_name varchar(255), regestired_date timestamp, updated_date timestamp, 
user_email_id varchar(255), user_password varchar(255), primary key (user_id)) 
*/
insert into user  values('1001','1976-03-01','FN1', 'LN3',CURRENT_TIMESTAMP, null, 'test1@ryjios.com', 'test1' );
insert into user  values('1002','1976-03-01','FN2', 'LN3',CURRENT_TIMESTAMP, null, 'test2@ryjios.com', 'test2' );
insert into user  values('1003','1976-03-01','FN3', 'LN3',CURRENT_TIMESTAMP, null, 'test3@ryjios.com', 'test3' );

/** 
--create table monitoring_device (device_id varchar(255) not null, device_mac_id varchar(255), 
device_name varchar(255), modified_date date, registred_date date, 
user_id varchar(255), primary key (device_id)) 
*/
-- inserting some sample device details --
insert into monitoring_device values('1001', 'device-1', 'Living Room', null, CURRENT_TIMESTAMP, '1001');
insert into monitoring_device values('1002', 'device-2', 'Living Room', null, CURRENT_TIMESTAMP, '1002');
insert into monitoring_device values('1003', 'device-3', 'Living Room', null, CURRENT_TIMESTAMP, '1003');

insert into monitoring_device values('1004', 'device-4', 'Dining Room', null, CURRENT_TIMESTAMP, '1001');
insert into monitoring_device values('1005', 'device-5', 'Dining Room', null, CURRENT_TIMESTAMP, '1002');
insert into monitoring_device values('1006', 'device-6', 'Dining Room', null, CURRENT_TIMESTAMP, '1003');

/**
-- create table co2sensor_data (reading_id varchar(255) not null, captured_time timestamp, device_id varchar(255), 
reading decimal(19,2), status varchar(255), primary key (reading_id))
*/
--insert CO2 sensor data --
insert into co2sensor_data values ('1001', CURRENT_TIMESTAMP, '1001', 12.34, 'Normal');
insert into co2sensor_data values ('1002', CURRENT_TIMESTAMP, '1002', 12.35, 'Normal');
insert into co2sensor_data values ('1003', CURRENT_TIMESTAMP, '1003', 12.36, 'Normal');
insert into co2sensor_data values ('1004', CURRENT_TIMESTAMP, '1004', 11.34, 'Normal');
insert into co2sensor_data values ('1005', CURRENT_TIMESTAMP, '1005', 11.35, 'Normal');
insert into co2sensor_data values ('1006', CURRENT_TIMESTAMP, '1006', 11.36, 'Normal');
insert into co2sensor_data values ('1007', CURRENT_TIMESTAMP, '1001', 13.34, 'Normal');
insert into co2sensor_data values ('1008', CURRENT_TIMESTAMP, '1002', 13.35, 'Normal');
insert into co2sensor_data values ('1009', CURRENT_TIMESTAMP, '1003', 13.36, 'Normal');
insert into co2sensor_data values ('1010', CURRENT_TIMESTAMP, '1004', 14.34, 'Normal');
insert into co2sensor_data values ('1011', CURRENT_TIMESTAMP, '1005', 14.35, 'Normal');
insert into co2sensor_data values ('1012', CURRENT_TIMESTAMP, '1006', 14.36, 'Normal');
insert into co2sensor_data values ('1013', CURRENT_TIMESTAMP, '1001', 15.34, 'Normal');
insert into co2sensor_data values ('1014', CURRENT_TIMESTAMP, '1002', 15.35, 'Normal');
insert into co2sensor_data values ('1015', CURRENT_TIMESTAMP, '1003', 15.36, 'Normal');
insert into co2sensor_data values ('1016', CURRENT_TIMESTAMP, '1004', 16.34, 'Normal');
insert into co2sensor_data values ('1017', CURRENT_TIMESTAMP, '1005', 16.35, 'Normal');
insert into co2sensor_data values ('1018', CURRENT_TIMESTAMP, '1006', 16.36, 'Normal');

-- create table cosensor_data (reading_id varchar(255) not null, captured_time timestamp, device_id varchar(255), reading decimal(19,2), status varchar(255), primary key (reading_id))
insert into cosensor_data values ('1037', CURRENT_TIMESTAMP, '1001', 12.34, 'Normal');
insert into cosensor_data values ('1038', CURRENT_TIMESTAMP, '1002', 12.35, 'Normal');
insert into cosensor_data values ('1039', CURRENT_TIMESTAMP, '1003', 12.36, 'Normal');
insert into cosensor_data values ('1040', CURRENT_TIMESTAMP, '1004', 11.34, 'Normal');
insert into cosensor_data values ('1041', CURRENT_TIMESTAMP, '1005', 11.35, 'Normal');
insert into cosensor_data values ('1042', CURRENT_TIMESTAMP, '1006', 11.36, 'Normal');                      
insert into cosensor_data values ('1043', CURRENT_TIMESTAMP, '1001', 13.34, 'Normal');
insert into cosensor_data values ('1044', CURRENT_TIMESTAMP, '1002', 13.35, 'Normal');
insert into cosensor_data values ('1045', CURRENT_TIMESTAMP, '1003', 13.36, 'Normal');
insert into cosensor_data values ('1046', CURRENT_TIMESTAMP, '1004', 14.34, 'Normal');
insert into cosensor_data values ('1047', CURRENT_TIMESTAMP, '1005', 14.35, 'Normal');
insert into cosensor_data values ('1048', CURRENT_TIMESTAMP, '1006', 14.36, 'Normal');
insert into cosensor_data values ('1049', CURRENT_TIMESTAMP, '1001', 15.34, 'Normal');
insert into cosensor_data values ('1050', CURRENT_TIMESTAMP, '1002', 15.35, 'Normal');
insert into cosensor_data values ('1051', CURRENT_TIMESTAMP, '1003', 15.36, 'Normal');
insert into cosensor_data values ('1052', CURRENT_TIMESTAMP, '1004', 16.34, 'Normal');
insert into cosensor_data values ('1053', CURRENT_TIMESTAMP, '1005', 16.35, 'Normal');
insert into cosensor_data values ('1054', CURRENT_TIMESTAMP, '1006', 16.36, 'Normal');

-- create table h2ssensor_data (reading_id varchar(255) not null, captured_time timestamp, device_id varchar(255), reading decimal(19,2), status varchar(255), primary key (reading_id))
insert into h2ssensor_data values ('1055', CURRENT_TIMESTAMP, '1001', 12.34, 'Normal');
insert into h2ssensor_data values ('1056', CURRENT_TIMESTAMP, '1002', 12.35, 'Normal');
insert into h2ssensor_data values ('1057', CURRENT_TIMESTAMP, '1003', 12.36, 'Normal');
insert into h2ssensor_data values ('1058', CURRENT_TIMESTAMP, '1004', 11.34, 'Normal');
insert into h2ssensor_data values ('1059', CURRENT_TIMESTAMP, '1005', 11.35, 'Normal');
insert into h2ssensor_data values ('1060', CURRENT_TIMESTAMP, '1006', 11.36, 'Normal');
insert into h2ssensor_data values ('1061', CURRENT_TIMESTAMP, '1001', 13.34, 'Normal');
insert into h2ssensor_data values ('1062', CURRENT_TIMESTAMP, '1002', 13.35, 'Normal');
insert into h2ssensor_data values ('1063', CURRENT_TIMESTAMP, '1003', 13.36, 'Normal');
insert into h2ssensor_data values ('1064', CURRENT_TIMESTAMP, '1004', 14.34, 'Normal');
insert into h2ssensor_data values ('1065', CURRENT_TIMESTAMP, '1005', 14.35, 'Normal');
insert into h2ssensor_data values ('1066', CURRENT_TIMESTAMP, '1006', 14.36, 'Normal');
insert into h2ssensor_data values ('1067', CURRENT_TIMESTAMP, '1001', 15.34, 'Normal');
insert into h2ssensor_data values ('1068', CURRENT_TIMESTAMP, '1002', 15.35, 'Normal');
insert into h2ssensor_data values ('1069', CURRENT_TIMESTAMP, '1003', 15.36, 'Normal');
insert into h2ssensor_data values ('1070', CURRENT_TIMESTAMP, '1004', 16.34, 'Normal');
insert into h2ssensor_data values ('1071', CURRENT_TIMESTAMP, '1005', 16.35, 'Normal');
insert into h2ssensor_data values ('1072', CURRENT_TIMESTAMP, '1006', 16.36, 'Normal');

-- create table humidity_sensor_data (reading_id varchar(255) not null, captured_time timestamp, device_id varchar(255), reading decimal(19,2), status varchar(255), primary key (reading_id))
insert into humidity_sensor_data values ('1073', CURRENT_TIMESTAMP, '1001', 12.34, 'Normal');
insert into humidity_sensor_data values ('1074', CURRENT_TIMESTAMP, '1002', 12.35, 'Normal');
insert into humidity_sensor_data values ('1075', CURRENT_TIMESTAMP, '1003', 12.36, 'Normal');
insert into humidity_sensor_data values ('1076', CURRENT_TIMESTAMP, '1004', 11.34, 'Normal');
insert into humidity_sensor_data values ('1077', CURRENT_TIMESTAMP, '1005', 11.35, 'Normal');
insert into humidity_sensor_data values ('1078', CURRENT_TIMESTAMP, '1006', 11.36, 'Normal');
insert into humidity_sensor_data values ('1079', CURRENT_TIMESTAMP, '1001', 13.34, 'Normal');
insert into humidity_sensor_data values ('1080', CURRENT_TIMESTAMP, '1002', 13.35, 'Normal');
insert into humidity_sensor_data values ('1081', CURRENT_TIMESTAMP, '1003', 13.36, 'Normal');
insert into humidity_sensor_data values ('1082', CURRENT_TIMESTAMP, '1004', 14.34, 'Normal');
insert into humidity_sensor_data values ('1083', CURRENT_TIMESTAMP, '1005', 14.35, 'Normal');
insert into humidity_sensor_data values ('1084', CURRENT_TIMESTAMP, '1006', 14.36, 'Normal');
insert into humidity_sensor_data values ('1085', CURRENT_TIMESTAMP, '1001', 15.34, 'Normal');
insert into humidity_sensor_data values ('1086', CURRENT_TIMESTAMP, '1002', 15.35, 'Normal');
insert into humidity_sensor_data values ('1087', CURRENT_TIMESTAMP, '1003', 15.36, 'Normal');
insert into humidity_sensor_data values ('1088', CURRENT_TIMESTAMP, '1004', 16.34, 'Normal');
insert into humidity_sensor_data values ('1089', CURRENT_TIMESTAMP, '1005', 16.35, 'Normal');
insert into humidity_sensor_data values ('1090', CURRENT_TIMESTAMP, '1006', 16.36, 'Normal');

-- create table no2sensor_data (reading_id varchar(255) not null, captured_time timestamp, device_id varchar(255), reading decimal(19,2), status varchar(255), primary key (reading_id))
insert into no2sensor_data values ('1091', CURRENT_TIMESTAMP, '1001', 12.34, 'Normal');
insert into no2sensor_data values ('1092', CURRENT_TIMESTAMP, '1002', 12.35, 'Normal');
insert into no2sensor_data values ('1093', CURRENT_TIMESTAMP, '1003', 12.36, 'Normal');
insert into no2sensor_data values ('1094', CURRENT_TIMESTAMP, '1004', 11.34, 'Normal');
insert into no2sensor_data values ('1095', CURRENT_TIMESTAMP, '1005', 11.35, 'Normal');
insert into no2sensor_data values ('1096', CURRENT_TIMESTAMP, '1006', 11.36, 'Normal');
                                    
insert into no2sensor_data values ('1097', CURRENT_TIMESTAMP, '1001', 13.34, 'Normal');
insert into no2sensor_data values ('1098', CURRENT_TIMESTAMP, '1002', 13.35, 'Normal');
insert into no2sensor_data values ('1099', CURRENT_TIMESTAMP, '1003', 13.36, 'Normal');
insert into no2sensor_data values ('1100', CURRENT_TIMESTAMP, '1004', 14.34, 'Normal');
insert into no2sensor_data values ('1101', CURRENT_TIMESTAMP, '1005', 14.35, 'Normal');
insert into no2sensor_data values ('1102', CURRENT_TIMESTAMP, '1006', 14.36, 'Normal');
                                
insert into no2sensor_data values ('1103', CURRENT_TIMESTAMP, '1001', 15.34, 'Normal');
insert into no2sensor_data values ('1104', CURRENT_TIMESTAMP, '1002', 15.35, 'Normal');
insert into no2sensor_data values ('1105', CURRENT_TIMESTAMP, '1003', 15.36, 'Normal');
insert into no2sensor_data values ('1106', CURRENT_TIMESTAMP, '1004', 16.34, 'Normal');
insert into no2sensor_data values ('1107', CURRENT_TIMESTAMP, '1005', 16.35, 'Normal');
insert into no2sensor_data values ('1108', CURRENT_TIMESTAMP, '1006', 16.36, 'Normal');

-- create table pmsensor_data (reading_id varchar(255) not null, captured_time timestamp, device_id varchar(255), reading decimal(19,2), status varchar(255), primary key (reading_id))
insert into pmsensor_data values ('1109', CURRENT_TIMESTAMP, '1001', 12.34, 'Normal');
insert into pmsensor_data values ('1110', CURRENT_TIMESTAMP, '1002', 12.35, 'Normal');
insert into pmsensor_data values ('1111', CURRENT_TIMESTAMP, '1003', 12.36, 'Normal');
insert into pmsensor_data values ('1112', CURRENT_TIMESTAMP, '1004', 11.34, 'Normal');
insert into pmsensor_data values ('1113', CURRENT_TIMESTAMP, '1005', 11.35, 'Normal');
insert into pmsensor_data values ('1114', CURRENT_TIMESTAMP, '1006', 11.36, 'Normal');
insert into pmsensor_data values ('1115', CURRENT_TIMESTAMP, '1001', 13.34, 'Normal');
insert into pmsensor_data values ('1116', CURRENT_TIMESTAMP, '1002', 13.35, 'Normal');
insert into pmsensor_data values ('1117', CURRENT_TIMESTAMP, '1003', 13.36, 'Normal');
insert into pmsensor_data values ('1118', CURRENT_TIMESTAMP, '1004', 14.34, 'Normal');
insert into pmsensor_data values ('1119', CURRENT_TIMESTAMP, '1005', 14.35, 'Normal');
insert into pmsensor_data values ('1120', CURRENT_TIMESTAMP, '1006', 14.36, 'Normal');
insert into pmsensor_data values ('1121', CURRENT_TIMESTAMP, '1001', 15.34, 'Normal');
insert into pmsensor_data values ('1122', CURRENT_TIMESTAMP, '1002', 15.35, 'Normal');
insert into pmsensor_data values ('1123', CURRENT_TIMESTAMP, '1003', 15.36, 'Normal');
insert into pmsensor_data values ('1124', CURRENT_TIMESTAMP, '1004', 16.34, 'Normal');
insert into pmsensor_data values ('1125', CURRENT_TIMESTAMP, '1005', 16.35, 'Normal');
insert into pmsensor_data values ('1126', CURRENT_TIMESTAMP, '1006', 16.36, 'Normal');


-- create table rhsensor_data (reading_id varchar(255) not null, captured_time timestamp, device_id varchar(255), reading decimal(19,2), status varchar(255), primary key (reading_id))
insert into rhsensor_data values ('1127', CURRENT_TIMESTAMP, '1001', 12.34, 'Normal');
insert into rhsensor_data values ('1128', CURRENT_TIMESTAMP, '1002', 12.35, 'Normal');
insert into rhsensor_data values ('1129', CURRENT_TIMESTAMP, '1003', 12.36, 'Normal');
insert into rhsensor_data values ('1130', CURRENT_TIMESTAMP, '1004', 11.34, 'Normal');
insert into rhsensor_data values ('1131', CURRENT_TIMESTAMP, '1005', 11.35, 'Normal');
insert into rhsensor_data values ('1132', CURRENT_TIMESTAMP, '1006', 11.36, 'Normal');
insert into rhsensor_data values ('1133', CURRENT_TIMESTAMP, '1001', 13.34, 'Normal');
insert into rhsensor_data values ('1134', CURRENT_TIMESTAMP, '1002', 13.35, 'Normal');
insert into rhsensor_data values ('1135', CURRENT_TIMESTAMP, '1003', 13.36, 'Normal');
insert into rhsensor_data values ('1136', CURRENT_TIMESTAMP, '1004', 14.34, 'Normal');
insert into rhsensor_data values ('1137', CURRENT_TIMESTAMP, '1005', 14.35, 'Normal');
insert into rhsensor_data values ('1138', CURRENT_TIMESTAMP, '1006', 14.36, 'Normal');
insert into rhsensor_data values ('1139', CURRENT_TIMESTAMP, '1001', 15.34, 'Normal');
insert into rhsensor_data values ('1140', CURRENT_TIMESTAMP, '1002', 15.35, 'Normal');
insert into rhsensor_data values ('1141', CURRENT_TIMESTAMP, '1003', 15.36, 'Normal');
insert into rhsensor_data values ('1142', CURRENT_TIMESTAMP, '1004', 16.34, 'Normal');
insert into rhsensor_data values ('1143', CURRENT_TIMESTAMP, '1005', 16.35, 'Normal');
insert into rhsensor_data values ('1144', CURRENT_TIMESTAMP, '1006', 16.36, 'Normal');

-- create table smoke_sensor_data (reading_id varchar(255) not null, captured_time timestamp, device_id varchar(255), reading decimal(19,2), status varchar(255), primary key (reading_id))
insert into smoke_sensor_data values ('1145', CURRENT_TIMESTAMP, '1001', 12.34, 'Normal');
insert into smoke_sensor_data values ('1146', CURRENT_TIMESTAMP, '1002', 12.35, 'Normal');
insert into smoke_sensor_data values ('1147', CURRENT_TIMESTAMP, '1003', 12.36, 'Normal');
insert into smoke_sensor_data values ('1148', CURRENT_TIMESTAMP, '1004', 11.34, 'Normal');
insert into smoke_sensor_data values ('1149', CURRENT_TIMESTAMP, '1005', 11.35, 'Normal');
insert into smoke_sensor_data values ('1150', CURRENT_TIMESTAMP, '1006', 11.36, 'Normal');
insert into smoke_sensor_data values ('1151', CURRENT_TIMESTAMP, '1001', 13.34, 'Normal');
insert into smoke_sensor_data values ('1152', CURRENT_TIMESTAMP, '1002', 13.35, 'Normal');
insert into smoke_sensor_data values ('1153', CURRENT_TIMESTAMP, '1003', 13.36, 'Normal');
insert into smoke_sensor_data values ('1154', CURRENT_TIMESTAMP, '1004', 14.34, 'Normal');
insert into smoke_sensor_data values ('1155', CURRENT_TIMESTAMP, '1005', 14.35, 'Normal');
insert into smoke_sensor_data values ('1156', CURRENT_TIMESTAMP, '1006', 14.36, 'Normal');
insert into smoke_sensor_data values ('1157', CURRENT_TIMESTAMP, '1001', 15.34, 'Normal');
insert into smoke_sensor_data values ('1158', CURRENT_TIMESTAMP, '1002', 15.35, 'Normal');
insert into smoke_sensor_data values ('1159', CURRENT_TIMESTAMP, '1003', 15.36, 'Normal');
insert into smoke_sensor_data values ('1160', CURRENT_TIMESTAMP, '1004', 16.34, 'Normal');
insert into smoke_sensor_data values ('1161', CURRENT_TIMESTAMP, '1005', 16.35, 'Normal');
insert into smoke_sensor_data values ('1162', CURRENT_TIMESTAMP, '1006', 16.36, 'Normal');

-- create table so2sensor_data (reading_id varchar(255) not null, captured_time timestamp, device_id varchar(255), reading decimal(19,2), status varchar(255), primary key (reading_id))

-- inserting so2 sensor data --
insert into so2sensor_data values ('1019', CURRENT_TIMESTAMP, '1001', 12.34, 'Normal');
insert into so2sensor_data values ('1020', CURRENT_TIMESTAMP, '1002', 12.35, 'Normal');
insert into so2sensor_data values ('1021', CURRENT_TIMESTAMP, '1003', 12.36, 'Normal');
insert into so2sensor_data values ('1022', CURRENT_TIMESTAMP, '1004', 11.34, 'Normal');
insert into so2sensor_data values ('1023', CURRENT_TIMESTAMP, '1005', 11.35, 'Normal');
insert into so2sensor_data values ('1024', CURRENT_TIMESTAMP, '1006', 11.36, 'Normal'); 
insert into so2sensor_data values ('1025', CURRENT_TIMESTAMP, '1001', 13.34, 'Normal');
insert into so2sensor_data values ('1026', CURRENT_TIMESTAMP, '1002', 13.35, 'Normal');
insert into so2sensor_data values ('1027', CURRENT_TIMESTAMP, '1003', 13.36, 'Normal');
insert into so2sensor_data values ('1028', CURRENT_TIMESTAMP, '1004', 14.34, 'Normal');
insert into so2sensor_data values ('1029', CURRENT_TIMESTAMP, '1005', 14.35, 'Normal');
insert into so2sensor_data values ('1030', CURRENT_TIMESTAMP, '1006', 14.36, 'Normal');
insert into so2sensor_data values ('1031', CURRENT_TIMESTAMP, '1001', 15.34, 'Normal');
insert into so2sensor_data values ('1032', CURRENT_TIMESTAMP, '1002', 15.35, 'Normal');
insert into so2sensor_data values ('1033', CURRENT_TIMESTAMP, '1003', 15.36, 'Normal');
insert into so2sensor_data values ('1034', CURRENT_TIMESTAMP, '1004', 16.34, 'Normal');
insert into so2sensor_data values ('1035', CURRENT_TIMESTAMP, '1005', 16.35, 'Normal');
insert into so2sensor_data values ('1036', CURRENT_TIMESTAMP, '1006', 16.36, 'Normal');


-- create table temp_sensor_data (reading_id varchar(255) not null, captured_time timestamp, device_id varchar(255), reading decimal(19,2), status varchar(255), primary key (reading_id))
insert into temp_sensor_data values ('1163', CURRENT_TIMESTAMP, '1001', 12.34, 'Normal');
insert into temp_sensor_data values ('1164', CURRENT_TIMESTAMP, '1002', 12.35, 'Normal');
insert into temp_sensor_data values ('1165', CURRENT_TIMESTAMP, '1003', 12.36, 'Normal');
insert into temp_sensor_data values ('1166', CURRENT_TIMESTAMP, '1004', 11.34, 'Normal');
insert into temp_sensor_data values ('1167', CURRENT_TIMESTAMP, '1005', 11.35, 'Normal');
insert into temp_sensor_data values ('1168', CURRENT_TIMESTAMP, '1006', 11.36, 'Normal');
insert into temp_sensor_data values ('1169', CURRENT_TIMESTAMP, '1001', 13.34, 'Normal');
insert into temp_sensor_data values ('1170', CURRENT_TIMESTAMP, '1002', 13.35, 'Normal');
insert into temp_sensor_data values ('1171', CURRENT_TIMESTAMP, '1003', 13.36, 'Normal');
insert into temp_sensor_data values ('1172', CURRENT_TIMESTAMP, '1004', 14.34, 'Normal');
insert into temp_sensor_data values ('1173', CURRENT_TIMESTAMP, '1005', 14.35, 'Normal');
insert into temp_sensor_data values ('1174', CURRENT_TIMESTAMP, '1006', 14.36, 'Normal');
insert into temp_sensor_data values ('1175', CURRENT_TIMESTAMP, '1001', 15.34, 'Normal');
insert into temp_sensor_data values ('1176', CURRENT_TIMESTAMP, '1002', 15.35, 'Normal');
insert into temp_sensor_data values ('1177', CURRENT_TIMESTAMP, '1003', 15.36, 'Normal');
insert into temp_sensor_data values ('1178', CURRENT_TIMESTAMP, '1004', 16.34, 'Normal');
insert into temp_sensor_data values ('1179', CURRENT_TIMESTAMP, '1005', 16.35, 'Normal');
insert into temp_sensor_data values ('1180', CURRENT_TIMESTAMP, '1006', 16.36, 'Normal');

-- create table vocsensor_data (reading_id varchar(255) not null, captured_time timestamp, device_id varchar(255), reading decimal(19,2), status varchar(255), primary key (reading_id))
insert into vocsensor_data values ('1181', CURRENT_TIMESTAMP, '1001', 12.34, 'Normal');
insert into vocsensor_data values ('1182', CURRENT_TIMESTAMP, '1002', 12.35, 'Normal');
insert into vocsensor_data values ('1183', CURRENT_TIMESTAMP, '1003', 12.36, 'Normal');
insert into vocsensor_data values ('1184', CURRENT_TIMESTAMP, '1004', 11.34, 'Normal');
insert into vocsensor_data values ('1185', CURRENT_TIMESTAMP, '1005', 11.35, 'Normal');
insert into vocsensor_data values ('1186', CURRENT_TIMESTAMP, '1006', 11.36, 'Normal');
insert into vocsensor_data values ('1187', CURRENT_TIMESTAMP, '1001', 13.34, 'Normal');
insert into vocsensor_data values ('1188', CURRENT_TIMESTAMP, '1002', 13.35, 'Normal');
insert into vocsensor_data values ('1189', CURRENT_TIMESTAMP, '1003', 13.36, 'Normal');
insert into vocsensor_data values ('1190', CURRENT_TIMESTAMP, '1004', 14.34, 'Normal');
insert into vocsensor_data values ('1191', CURRENT_TIMESTAMP, '1005', 14.35, 'Normal');
insert into vocsensor_data values ('1192', CURRENT_TIMESTAMP, '1006', 14.36, 'Normal');
insert into vocsensor_data values ('1193', CURRENT_TIMESTAMP, '1001', 15.34, 'Normal');
insert into vocsensor_data values ('1194', CURRENT_TIMESTAMP, '1002', 15.35, 'Normal');
insert into vocsensor_data values ('1195', CURRENT_TIMESTAMP, '1003', 15.36, 'Normal');
insert into vocsensor_data values ('1196', CURRENT_TIMESTAMP, '1004', 16.34, 'Normal');
insert into vocsensor_data values ('1197', CURRENT_TIMESTAMP, '1005', 16.35, 'Normal');
insert into vocsensor_data values ('1198', CURRENT_TIMESTAMP, '1006', 16.36, 'Normal');