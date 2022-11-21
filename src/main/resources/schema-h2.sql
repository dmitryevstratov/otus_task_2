CREATE TABLE IF NOT EXISTS genre
(
    id   INTEGER PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS author
(
    id        INTEGER PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS book
(
    id          INTEGER PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    id_author   INTEGER      NOT NULL,
    CONSTRAINT id_author FOREIGN KEY (id_author) REFERENCES Author (id)
);

CREATE TABLE IF NOT EXISTS book_genre
(
    book_id  integer NOT NULL,
    genre_id integer NOT NULL,
    PRIMARY KEY (book_id, genre_id),
    FOREIGN KEY (book_id) REFERENCES book,
    FOREIGN KEY (genre_id) REFERENCES genre
)