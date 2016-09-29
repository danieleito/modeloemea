CREATE USER 'sa'@'localhost' IDENTIFIED BY 'adminEMEA';
GRANT insert, update, delete, select ON emea.* TO 'sa'@'localhost';