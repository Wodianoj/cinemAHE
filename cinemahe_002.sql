INSERT INTO cahe_genre (genre_name)
VALUES ('horror'), ('sensacja'), ('romans'), ('komedia');

INSERT INTO cahe_cinema (id, name, address, contact, path_to_picture)
VALUES (1, 'Warka', 'Ul. Maltańska 9, 26-666 Chrząszczyrzewoszyce.', 'Tel. +48 662 724 534; email: kinowarka@gov.pl;', '/webTech/cinemahe/pics/dummy.jpg'),
	(2, 'Strong', 'Ul. Woltyżerki 23, 16-556 Akapulkowice.', 'Tel. +48 382 048 020; email: kinostrong@gov.pl', '/webTech/cinemahe/pics/dummy1.jpg');

INSERT INTO cahe_room (name, cinema_id)
VALUES ('Pszeniczna', 1),
	('Ipa', 1),
    ('Lager', 2);

INSERT INTO cahe_director (first_name, last_name)
VALUES ('Stanisław', 'Bareja'),
	('Władysław', 'Pasikowski'),
    ('Abecjusz', 'Cedeowski');