CREATE TABLE IF NOT EXISTS user (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS orders (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      product VARCHAR(255),
    user_id BIGINT,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES user(id)
    );
