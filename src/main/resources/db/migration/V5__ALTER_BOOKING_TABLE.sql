ALTER TABLE Booking
    ADD COLUMN users_id BIGINT;

ALTER TABLE Booking
    ADD FOREIGN KEY (users_id) REFERENCES Users(id);

INSERT INTO Booking (property_id, users_id, check_in, check_out, total_price)
VALUES
    (1, 1, '2024-10-01 08:00:00', '2024-10-22 10:00:00', 19800.00),
    (2, 2, '2024-11-01 14:00:00', '2024-11-15 12:00:00', 15000.00),
    (3, 3, '2024-12-01 09:00:00', '2024-12-05 10:00:00', 5000.00),
    (1, 1, '2024-12-10 15:00:00', '2024-12-25 11:00:00', 25000.00);
