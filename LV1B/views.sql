CREATE
MATERIALIZED VIEW accommodations_per_host AS
SELECT h.id AS host_id, COUNT(a.id) AS accommodation_count
FROM host h
         LEFT JOIN accommodation a ON h.id = a.host_id
GROUP BY h.id;

CREATE
MATERIALIZED VIEW hosts_per_country AS
SELECT h.country_id AS country_id, c.name AS country_name, COUNT(*) AS host_count
FROM host h
         JOIN country c ON h.country_id = c.id
GROUP BY h.country_id, c.name;