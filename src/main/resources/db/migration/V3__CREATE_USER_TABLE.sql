CREATE TABLE Users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       name VARCHAR(80) NOT NULL,
                       password VARCHAR(72) NOT NULL
);

INSERT INTO Users (email, name, password)
VALUES
    ('john.doe@example.com', 'John Doe',
     '$2a$12$wNm.LWXd49a212dWIZlcauflwIv0pnW9/0VGYlR85O2pdTFXZgVQK'), --password123
    ('jane.smith@example.com', 'Jane Smith',
     '$2a$12$U/sq.VSBNVKtDw/SiXewCOI5/F9/BJ0OxAsfw4FYZ9ol4Z0ARUroS'), -- securePass456
    ('maria.santos@example.com', 'Maria Santos',
     '$2a$12$G7sN7nI1jat/iKIwWJsnqeNhgzIjk/hq6rYzRCfULsiQly717tNkS'); --strongPassword789
