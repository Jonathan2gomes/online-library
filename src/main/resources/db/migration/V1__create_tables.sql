CREATE TABLE user_library (
                              id SERIAL PRIMARY KEY,
                              name VARCHAR(255) NOT NULL,
                              registration VARCHAR(255) NOT NULL,
                              email VARCHAR(255) NOT NULL
);

CREATE TABLE book (
                      id SERIAL PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      author VARCHAR(255) NOT NULL
);

CREATE TABLE reservation (
                             id SERIAL PRIMARY KEY,
                             book_id BIGINT NOT NULL,
                             user_id BIGINT NOT NULL,
                             FOREIGN KEY (book_id) REFERENCES book(id),
                             FOREIGN KEY (user_id) REFERENCES user_library(id)
);

CREATE TABLE review (
                        id SERIAL PRIMARY KEY,
                        review TEXT NOT NULL,
                        book_id BIGINT NOT NULL,
                        FOREIGN KEY (book_id) REFERENCES book(id)
);