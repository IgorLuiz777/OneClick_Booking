CREATE TABLE Booking (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    property_id BIGINT,
    check_in TIMESTAMP,
    check_out TIMESTAMP,
    total_price DECIMAL(10, 2),
    FOREIGN KEY (property_id) REFERENCES Property(id)
);


INSERT INTO Booking (property_id, check_in, check_out, total_price)
VALUES (1, '2024-10-01 08:00:00', '2024-10-22 10:00:00', 19800.00);
