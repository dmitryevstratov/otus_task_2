INSERT INTO GENRE
VALUES (1, 'Драма');
INSERT INTO GENRE
VALUES (2, 'Боевик');
INSERT INTO GENRE
VALUES (3, 'Комедия');
INSERT INTO GENRE
VALUES (4, 'Фантастика');

INSERT INTO AUTHOR
VALUES (1, 'Александр', 'Пушкин');
INSERT INTO AUTHOR
VALUES (2, 'Михаил', 'Булгаков');

INSERT INTO BOOK (id, name, description, id_author)
VALUES (1, 'Звездные войны', 'Война и политика в космосе', 1);
INSERT INTO BOOK (id, name, description, id_author)
VALUES (2, 'Мастер и Маргарита', 'Про большого кота', 2);

INSERT INTO BOOK_GENRE VALUES (1, 1);
INSERT INTO BOOK_GENRE VALUES (1, 2);
INSERT INTO BOOK_GENRE VALUES (2, 3);
INSERT INTO BOOK_GENRE VALUES (2, 4);