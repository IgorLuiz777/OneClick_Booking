CREATE TABLE Property (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    rooms_quantity INT NOT NULL,
    beds_quantity INT NOT NULL,
    bathrooms_quantity INT NOT NULL,
    description VARCHAR(500),
    daily_price DECIMAL(19,2) NOT NULL,
    grade INT CHECK (grade >= 1 AND grade <= 5)
);


INSERT INTO Property (type, rooms_quantity, beds_quantity, bathrooms_quantity, description, daily_price, grade)
VALUES ('HOUSE', 3, 2, 2, 'Uma linda casa de frente a um lago.'
       , 900.00, 4);
