CREATE TABLE IF NOT EXISTS remote (uid uuid default random_uuid(), ip VARCHAR(255), control_sum VARCHAR(255), active BOOLEAN, PRIMARY KEY (uid));
DROP TABLE if EXISTS port_note;
CREATE TABLE IF NOT EXISTS port_note (id integer AUTO_INCREMENT, owner VARCHAR(255), port integer, PRIMARY KEY(id));
--insert into port_note (owner, port) values ('my', -1), ('host', -1);