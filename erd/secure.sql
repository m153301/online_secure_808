SET SESSION FOREIGN_KEY_CHECKS=0;


/* Create Tables */

CREATE TABLE recommend
(
	item_id int(12) NOT NULL UNIQUE,
	user_id varchar(12) NOT NULL UNIQUE,
	recommend_date date,
	UNIQUE (item_id, user_id)
);


CREATE TABLE worker
(
	user_id varchar(12) NOT NULL UNIQUE,
	PRIMARY KEY (user_id)
);


CREATE TABLE creditcard
(
	creditcard_id int NOT NULL UNIQUE AUTO_INCREMENT,
	creditcard_type char NOT NULL,
	creditcard_number varchar(64),
	PRIMARY KEY (creditcard_id)
);


CREATE TABLE ordered
(
	order_id int(12) NOT NULL UNIQUE AUTO_INCREMENT,
	user_id varchar(12) NOT NULL,
	item_id int(12) NOT NULL,
	order_date date,
	order_quantity int(3),
	PRIMARY KEY (order_id)
);


CREATE TABLE purchace
(
	purchace_id int NOT NULL UNIQUE AUTO_INCREMENT,
	item_id int(12) NOT NULL,
	buy_date date,
	purchase_quantity int(3),
	user_id varchar(12) NOT NULL,
	PRIMARY KEY (purchace_id)
);


CREATE TABLE item
(
	item_id int(12) NOT NULL UNIQUE AUTO_INCREMENT,
	item_name varchar(50) UNIQUE,
	item_price int(12),
	item_stock int(3),
	PRIMARY KEY (item_id)
);


CREATE TABLE customer
(
	user_id varchar(12) NOT NULL,
	tel bigint(12) unsigned zerofill,
	creditcard_id int NOT NULL,
	PRIMARY KEY (user_id)
);


CREATE TABLE user
(
	user_id varchar(12) NOT NULL UNIQUE,
	password varchar(64) NOT NULL,
	user_name varchar(50) NOT NULL,
	role varchar(20) NOT NULL,
	PRIMARY KEY (user_id)
);



/* Create Foreign Keys */

ALTER TABLE recommend
	ADD FOREIGN KEY (user_id)
	REFERENCES worker (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ordered
	ADD FOREIGN KEY (user_id)
	REFERENCES worker (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE customer
	ADD FOREIGN KEY (creditcard_id)
	REFERENCES creditcard (creditcard_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ordered
	ADD FOREIGN KEY (item_id)
	REFERENCES item (item_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE recommend
	ADD FOREIGN KEY (item_id)
	REFERENCES item (item_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE purchace
	ADD FOREIGN KEY (item_id)
	REFERENCES item (item_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE purchace
	ADD FOREIGN KEY (user_id)
	REFERENCES customer (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE customer
	ADD FOREIGN KEY (user_id)
	REFERENCES user (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE worker
	ADD FOREIGN KEY (user_id)
	REFERENCES user (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



