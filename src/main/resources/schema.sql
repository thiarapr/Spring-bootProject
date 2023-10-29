CREATE TABLE stores (
    id INT AUTO_INCREMENT ,
    store_name VARCHAR(255) PRIMARY KEY,
    store_location VARCHAR(255),
    phone_no VARCHAR(20),
    opening_time VARCHAR(20)
);
CREATE TABLE items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    store_name VARCHAR(50),
    price DOUBLE,
    description TEXT,
    FOREIGN KEY (store_name) REFERENCES stores(store_name)
);



