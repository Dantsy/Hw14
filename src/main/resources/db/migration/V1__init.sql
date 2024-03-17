create table categories
(
    id    bigserial primary key,
    title varchar(255) NOT NULL
);

create table authors
(
    id        bigserial primary key,
    full_name varchar(255) NOT NULL
);

create table books
(
    id        bigserial primary key,
    title     varchar(255) NOT NULL,
    genre     varchar(255) NOT NULL,
    author_id bigint NOT NULL,
    foreign key (author_id) references authors (id)
);

create table books_details
(
    id          bigserial primary key,
    book_id     bigint NOT NULL,
    description varchar(255) NOT NULL,
    foreign key (book_id) references books (id)
);

create table reviews
(
    id          bigserial primary key,
    book_id     bigint NOT NULL,
    review_date date NOT NULL,
    user_name   varchar(255) NOT NULL,
    score       int NOT NULL,
    text        varchar(1000) NOT NULL,
    books_key   bigint,
    foreign key (book_id) references books (id)
);

INSERT INTO categories (title)
VALUES ('Space Opera'),
       ('Detective'),
       ('Dystopian'),
       ('Political'),
       ('Horror'),
       ('Classic Fiction'),
       ('Science'),
       ('Adventure');

INSERT INTO authors (full_name)
VALUES ('Isaac Asimov'),
       ('Agatha Christie'),
       ('George Orwell'),
       ('J.K. Rowling'),
       ('Stephen King'),
       ('Jane Austen'),
       ('John Doe'),
       ('Mary Smith'),
       ('George R.R. Martin'),
       ('J.R.R. Tolkien'),
       ('Stephen King'),
       ('J.K. Rowling'),
       ('Agatha Christie'),
       ('Arthur Conan Doyle'),
       ('J.D. Salinger'),
       ('Mark Twain'),
       ('F. Scott Fitzgerald'),
       ('Ernest Hemingway');

INSERT INTO books (title, author_id, genre)
VALUES ('Foundation', 1, 'SCIFI'),
       ('Murder on the Orient Express', 2, 'MYSTERY'),
       ('1984', 3, 'DYSTOPIAN'),
       ('The Robots of Dawn', 1, 'SCIFI'),
       ('And Then There Were None', 2, 'MYSTERY'),
       ('Animal Farm', 3, 'POLITICAL'),
       ('Prelude to Foundation', 1, 'SCIFI'),
       ('Harry Potter and the Philosopher''s Stone', 4, 'FANTASY'),
       ('The Shining', 5, 'HORROR'),
       ('Pride and Prejudice', 6, 'CLASSIC_FICTION'),
       ('Jane Doe: A Mystery', 7, 'MYSTERY'),
       ('Love in Bloom', 6, 'ROMANCE'),
       ('The Stand', 5, 'HORROR'),
       ('Sense and Sensibility', 6, 'CLASSIC_FICTION'),
       ('A Brief History of Time', 1, 'SCIENCE'),
       ('Twilight', 4, 'FANTASY'),
       ('The Da Vinci Code', 7, 'MYSTERY'),
       ('The Hitchhiker''s Guide to the Galaxy', 8, 'SCIFI'),
       ('To Kill a Mockingbird', 7, 'MYSTERY'),
       ('A Tale of Two Cities', 6, 'POLITICAL'),
       ('The Great Gatsby', 6, 'CLASSIC_FICTION'),
       ('War and Peace', 6, 'POLITICAL'),
       ('Jurassic Park', 5, 'SCIFI'),
       ('Gone with the Wind', 6, 'ROMANCE'),
       ('The Girl with the Dragon Tattoo', 7, 'MYSTERY'),
       ('Brave New World', 3, 'DYSTOPIAN'),
       ('The Lord of the Rings', 4, 'FANTASY'),
       ('The Catcher in the Rye', 6, 'CLASSIC_FICTION'),
       ('Wuthering Heights', 7, 'ROMANCE'),
       ('A Game of Thrones', 9, 'FANTASY'),
       ('The Hobbit', 10, 'FANTASY'),
       ('The Shining', 11, 'HORROR'),
       ('Harry Potter and the Chamber of Secrets', 12, 'FANTASY'),
       ('The Mysterious Affair at Styles', 13, 'MYSTERY'),
       ('Moby-Dick', 8, 'ADVENTURE'),
       ('The Adventures of Sherlock Holmes', 14, 'MYSTERY'),
       ('The Catcher in the Rye', 15, 'CLASSIC_FICTION'),
       ('The Adventures of Huckleberry Finn', 16, 'ADVENTURE'),
       ('The Great Gatsby', 17, 'CLASSIC_FICTION'),
       ('The Old Man and the Sea', 18, 'ADVENTURE');

INSERT INTO books_details (book_id, description)
VALUES (1, 'A science fiction novel by Isaac Asimov'),
       (2, 'A detective novel by Agatha Christie'),
       (3, 'A dystopian novel by George Orwell'),
       (4, 'Another science fiction novel by Isaac Asimov'),
       (5, 'A mystery novel by Agatha Christie'),
       (6, 'A political allegory and satire by George Orwell'),
       (7, 'A prequel to the Foundation series by Isaac Asimov'),
       (8, 'The first book in the Harry Potter series'),
       (9, 'A horror novel by Stephen King'),
       (10, 'A classic romance novel by Jane Austen'),
       (11, 'A mystery novel by John Doe'),
       (12, 'A romantic novel by Mary Smith'),
       (13, 'A horror novel by Stephen King'),
       (14, 'A classic romance novel by Jane Austen'),
       (15, 'A popular science book by Stephen Hawking'),
       (16, 'A fantasy novel by J.K. Rowling'),
       (17, 'A mystery novel by Dan Brown'),
       (18, 'A humorous science fiction series by Douglas Adams'),
       (19, 'A classic mystery novel by Harper Lee'),
       (20, 'A historical novel by Charles Dickens'),
       (21, 'A classic romance novel by F. Scott Fitzgerald'),
       (22, 'An epic historical novel by Leo Tolstoy'),
       (23, 'A science fiction novel by Michael Crichton'),
       (24, 'A classic romance novel by Margaret Mitchell'),
       (25, 'A mystery novel by Stieg Larsson'),
       (26, 'A dystopian novel by Aldous Huxley'),
       (27, 'A fantasy novel by J.R.R. Tolkien'),
       (28, 'A classic novel by J.D. Salinger'),
       (29, 'A gothic novel by Emily Brontë'),
       (30, 'A classic adventure novel by Herman Melville'),
       (31, 'A fantasy novel by George R.R. Martin'),
       (32, 'A fantasy novel by J.R.R. Tolkien'),
       (33, 'A horror novel by Stephen King'),
       (34, 'The second book in the Harry Potter series'),
       (35, 'A mystery novel by Agatha Christie'),
       (36, 'A collection of short stories by Sir Arthur Conan Doyle'),
       (37, 'A novel by J.D. Salinger'),
       (38, 'A novel by Mark Twain'),
       (39, 'A novel by F. Scott Fitzgerald'),
       (40, 'A novel by Ernest Hemingway');

INSERT INTO reviews (book_id, review_date, user_name, score, text)
VALUES (1, '2023-11-10', 'Alice', 8, 'Enjoyed the depth of the story and character development'),
       (1, '2023-11-15', 'Bob', 9, 'Compelling narrative and well-executed plot twists'),
       (2, '2023-11-20', 'Charlie', 4, 'Interesting concept but found it a bit predictable'),
       (2, '2023-11-25', 'David', 7, 'Engaging mystery with a satisfying resolution'),
       (3, '2023-12-01', 'Eva', 10, 'Brilliantly crafted dystopian novel, a must-read'),
       (3, '2023-12-05', 'Frank', 2, 'Dystopian themes were too dark for my taste'),
       (4, '2023-12-10', 'Grace', 6, 'Good exploration of robotics and ethics'),
       (4, '2023-12-15', 'Harry', 8, 'Another Asimov classic, thoroughly enjoyed it'),
       (5, '2023-12-20', 'Ivy', 3, 'Found it too horrifying, couldn''t finish'),
       (5, '2023-12-25', 'Jack', 5, 'Horror elements were effective but not my favorite genre'),
       (6, '2023-11-05', 'Karen', 7, 'Classic romance with timeless appeal'),
       (6, '2023-11-10', 'Larry', 4, 'Romance genre is not my preference'),
       (7, '2023-11-15', 'Mia', 9, 'Magical world-building and a captivating story'),
       (7, '2023-11-20', 'Nathan', 6, 'Entertaining but felt a bit too long'),
       (8, '2023-11-25', 'Olivia', 10, 'Terrifying and suspenseful, a horror masterpiece'),
       (8, '2023-11-30', 'Peter', 8, 'The Shining is a classic for a reason'),
       (9, '2023-12-05', 'Quinn', 2, 'Didn''t connect with the characters or the plot'),
       (9, '2023-12-10', 'Rachel', 6, 'Classic romance that didn''t stand out for me'),
       (10, '2023-12-15', 'Sam', 9, 'Thrilling mystery that kept me guessing until the end'),
       (25, '2023-12-20', 'Sophie', 7, 'Solid mystery novel, enjoyed the suspense'),
       (25, '2023-12-25', 'Thomas', 9, 'Riveting plot and well-developed characters'),
       (26, '2023-11-30', 'Isabella', 8, 'Fantasy world was immersive and enchanting'),
       (26, '2023-12-05', 'Michael', 5, 'Expected more depth in the fantasy genre'),
       (27, '2023-12-10', 'Ava', 10, 'A mystery masterpiece, couldn''t put it down'),
       (27, '2023-12-15', 'Daniel', 3, 'Disappointed with the plot twists and resolution'),
       (28, '2023-12-20', 'Emily', 8, 'Humorous and entertaining science fiction adventure'),
       (28, '2023-12-25', 'William', 6, 'Enjoyable but lacked some depth in character development'),
       (29, '2023-11-05', 'Liam', 10, 'A classic with a timeless appeal'),
       (29, '2023-11-10', 'Olivia', 9, 'Well-researched historical novel with great storytelling'),
       (30, '2023-11-15', 'Emma', 7, 'Adventure elements were interesting but pacing was slow'),
       (31, '2023-11-10', 'Alice', 8, 'Great characters and a gripping plot'),
       (32, '2023-11-15', 'Bob', 9, 'A classic fantasy novel'),
       (33, '2023-11-20', 'Charlie', 4, 'Not my cup of tea'),
       (34, '2023-11-25', 'David', 7, 'A solid entry into the Harry Potter series'),
       (35, '2023-12-01', 'Eva', 10, 'A riveting mystery with a satisfying resolution'),
       (36, '2023-11-10', 'Alice', 8, 'Engaging and thought-provoking'),
       (37, '2023-11-15', 'Bob', 9, 'A timeless classic'),
       (38, '2023-11-20', 'Charlie', 4, 'A bit slow-paced for my taste'),
       (39, '2023-11-25', 'David', 7, 'A masterpiece of American literature'),
       (40, '2023-12-01', 'Eva', 10, 'A beautiful and moving story');