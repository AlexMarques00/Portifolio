CREATE TABLE user (
  user_id int PRIMARY KEY,
  user_name varchar(255)
);

CREATE TABLE account (
  account_id int PRIMARY KEY,
  account_name varchar(255),
  inicial_balance float,
  inicial_datetime datetime,
  account_balance float,
  balance_datetime datetime,
  active_account bool,
  user_id int,
  type_id int
);

CREATE TABLE transaction (
  transaction_id int PRIMARY KEY,
  plus_or_minus int,
  transaction_value float,
  transaction_time datetime,
  tag_id int,
  account_id int,
  transaction_description varchar(255),
  status_id int
);

CREATE TABLE status (
	status_id int PRIMARY KEY,
    status_description varchar(255)
);

CREATE TABLE tag (
  tag_id int PRIMARY KEY,
  tag_name varchar(255)
);

CREATE TABLE type (
	type_id int PRIMARY KEY,
    type_name varchar(255)
);

ALTER TABLE account ADD FOREIGN KEY (user_id) REFERENCES user (user_id);

ALTER TABLE transaction ADD FOREIGN KEY (account_id) REFERENCES account (account_id);

ALTER TABLE transaction ADD FOREIGN KEY (status_id) REFERENCES status (status_id);

ALTER TABLE transaction ADD FOREIGN KEY (tag_id) REFERENCES tag (tag_id);

ALTER TABLE account ADD FOREIGN KEY (type_id) REFERENCES type (type_id);