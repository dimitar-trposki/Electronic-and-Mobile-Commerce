CREATE MATERIALIZED VIEW book_count_by_author AS
SELECT a.id                                   AS author_id,
       CONCAT(a.name, ' ', a.surname) AS full_name,
       COUNT(b.id)                            AS book_count
FROM author a
         LEFT JOIN
     book b ON b.author_id = a.id
GROUP BY a.id, a.name, a.surname;

CREATE MATERIALIZED VIEW author_count_by_country AS
SELECT c.id        AS country_id,
       c.name      AS country_name,
       COUNT(a.id) AS author_count
FROM country c
         LEFT JOIN
     author a ON a.country_id = c.id
GROUP BY c.id, c.name;