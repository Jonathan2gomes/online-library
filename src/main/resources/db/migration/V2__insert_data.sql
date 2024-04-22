-- Example data insertion for users
INSERT INTO user_library (id, name, registration, email)
VALUES (1, 'John Doe', '12345', 'john@example.com');
INSERT INTO user_library (id, name, registration, email)
VALUES (2, 'Jane Smith', '67890', 'jane@example.com');

-- Example data insertion for books
INSERT INTO book (id, title, author)
VALUES (1, 'The Great Gatsby', 'F. Scott Fitzgerald');
INSERT INTO book (id, title, author)
VALUES (2, 'To Kill a Mockingbird', 'Harper Lee');

-- Example data insertion for reservations
INSERT INTO reservation (book_id, user_id)
VALUES (1, 1); -- John Doe reserves The Great Gatsby
INSERT INTO reservation (book_id, user_id)
VALUES (2, 2);
-- Jane Smith reserves To Kill a Mockingbird

-- Insert some initial reviews
INSERT INTO review (review, book_id)
VALUES ('Great book!', 1),
       ('Awesome read!', 2);
