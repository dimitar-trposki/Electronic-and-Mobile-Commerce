CREATE TABLE country
(
    id        SERIAL PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    continent VARCHAR(255) NOT NULL
);

CREATE TABLE author
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    surname    VARCHAR(255) NOT NULL,
    country_id BIGINT,
    CONSTRAINT fk_author_country FOREIGN KEY (country_id) REFERENCES country (id)
);

CREATE TYPE category_enum AS ENUM ('NOVEL', 'THRILLER', 'HISTORY', 'FANTASY', 'BIOGRAPHY', 'CLASSICS', 'DRAMA');

CREATE TABLE book
(
    id               SERIAL PRIMARY KEY,
    title            VARCHAR(255)  NOT NULL,
    category         category_enum NOT NULL,
    author_id        BIGINT,
    available_copies INTEGER,
    deleted          BOOLEAN,
    created          TIMESTAMP,
    CONSTRAINT fk_book_author FOREIGN KEY (author_id) REFERENCES author (id)
);

CREATE TYPE role_enum AS ENUM ('ROLE_USER', 'ROLE_LIBRARIAN');

CREATE TABLE book_users
(
    username                   VARCHAR(255) PRIMARY KEY,
    password                   VARCHAR(255) NOT NULL,
    name                       VARCHAR(255) NOT NULL,
    surname                    VARCHAR(255) NOT NULL,
    is_account_non_expired     BOOLEAN DEFAULT TRUE,
    is_account_non_locked      BOOLEAN DEFAULT TRUE,
    is_credentials_non_expired BOOLEAN DEFAULT TRUE,
    is_enabled                 BOOLEAN DEFAULT TRUE,
    role                       role_enum    NOT NULL
);

CREATE TABLE book_users_wishlist_books
(
    book_users_username VARCHAR(255) NOT NULL,
    wishlist_books_id   BIGINT       NOT NULL,
    PRIMARY KEY (book_users_username, wishlist_books_id),
    FOREIGN KEY (book_users_username) REFERENCES book_users (username),
    FOREIGN KEY (wishlist_books_id) REFERENCES book (id)
);