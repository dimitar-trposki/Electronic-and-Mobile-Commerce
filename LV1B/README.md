# Лабораториска вежба 1 (2025) - група Б

Потребно е да се изработи еден модул од апликација налик https://www.airbnb.com/ за изнајмување на сместување, со одредени привилегии за секој корисник:

- Да додава нови сместувања кои може да се изнајмат

- Да брише сместувања кои повеќе не се во добра состојба и нема да се изнајмуваат

- Да изменува одреден запис за сместување

- Да обележи одредено сместување како изнајмено

За оваа лабораториска вежба потребно е да креирате соодветна Spring Boot апликација, односно API. Во однос на базата на податоци, потребно е да користите H2 база.

Во рамки на апликацијата се чуваат следните податоци за сместувањата: id (Long), name (String), category (enum), host (Host), numRooms (Integer).

Категоријата на книгата може да биде: ROOM, HOUSE, FLAT, APARTMENT, HOTEL, MOTEL.

За секој host пак се чуваат податоците: id (Long), name (String), surname (String), country (Country).

За секоја земја се чуваат податоците: id (Long), name (String), continent (String).

Користејќи слоевита архитектура треба да се дефинираат соодветни контролери, сервиси и репозиториуми.

Дополнително, со помош на SwaggerUI потребно е да прикажете успешно извршување на API повиците.