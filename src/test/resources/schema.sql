
create table IF NOT EXISTS customer
(
  id BIGINT PRIMARY KEY,
  name TEXT,
  company TEXT NOT NULL,
  contact_info TEXT
);


CREATE TABLE IF NOT EXISTS part
(
  id BIGINT PRIMARY KEY,
  name TEXT NOT NULL,
  vendor TEXT,
  part_number TEXT,
  description TEXT
);

CREATE TABLE IF NOT EXISTS service_item(
  id BIGINT PRIMARY KEY,
  description TEXT,
  name TEXT,
  image TEXT,
  part_number TEXT,
  manufacturer TEXT,
  serial_number TEXT
);


CREATE TABLE IF NOT EXISTS technician
(
  id BIGINT PRIMARY KEY,
  name TEXT
);

CREATE TABLE IF NOT EXISTS work_order
(
  id BIGINT PRIMARY KEY,
  created_at DATE DEFAULT CURRENT_DATE NOT NULL,
  status TEXT,
  description TEXT,
  notes TEXT,
  date_arrived DATE,
  technician_id BIGINT,
  customer_id BIGINT,
  FOREIGN KEY (customer_id) REFERENCES customer(id),
  FOREIGN KEY (technician_id) REFERENCES technician(id)
);



--OLDER VERSIONS
--create table IF NOT EXISTS customer
--(
--  id BIGSERIAL PRIMARY KEY,
--  name TEXT,
--  company TEXT
--);
--
--CREATE TABLE IF NOT EXISTS part
--(
--  id BIGSERIAL PRIMARY KEY,
--  name TEXT NOT NULL,
--  vendor TEXT,
--  part_number TEXT,
--  description TEXT,
--  application TEXT
--);
--
--CREATE TABLE IF NOT EXISTS service_item (
--  id BIGSERIAL PRIMARY KEY,
--  description TEXT,
--  name TEXT,
--  image TEXT,
--  part_number TEXT,
--  manufacturer TEXT,
--  parts_available BIGINT, -- This is the column that will reference part(id)
--  FOREIGN KEY (parts_available) REFERENCES part(id)
--);
--
--CREATE TABLE IF NOT EXISTS technician
--(
--  id BIGSERIAL PRIMARY KEY,
--  name TEXT
--);
--
--CREATE TABLE IF NOT EXISTS work_order
--(
--  id BIGSERIAL PRIMARY KEY,
--  created_at DATE DEFAULT CURRENT_DATE NOT NULL,
--  status TEXT,
--  description TEXT,
--  notes TEXT,
--  date_arrived DATE,
--  technician BIGINT,
--  item_id BIGINT,
--  customer_id BIGINT,
--  FOREIGN KEY (item_id ) REFERENCES service_item(id),
--  FOREIGN KEY (customer_id) REFERENCES customer(id),
--  FOREIGN KEY (technician) REFERENCES technician(id)
--);
