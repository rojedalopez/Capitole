CREATE TABLE IF NOT EXISTS brands
(id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(255),
PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS prices
(price_list INT NOT NULL AUTO_INCREMENT,
brand_id VARCHAR(255),
start_date TIMESTAMP,
end_date TIMESTAMP,
product_id VARCHAR(50),
priority INT,
price NUMERIC(10,2),
curr VARCHAR(5),
PRIMARY KEY (price_list),
foreign key (brand_id) references brands(id));
