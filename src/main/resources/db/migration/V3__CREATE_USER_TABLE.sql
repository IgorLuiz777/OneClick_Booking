CREATE TABLE Users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       name VARCHAR(80) NOT NULL,
                       password VARCHAR(72) NOT NULL
);

INSERT INTO Users (email, name, password)
VALUES
    ('john.doe@example.com', 'John Doe', 'password123'),
    ('jane.smith@example.com', 'Jane Smith', 'securePass456'),
    ('maria.santos@example.com', 'Maria Santos', 'strongPassword789');
