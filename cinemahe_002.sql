INSERT INTO cahe_genre (genre_name)
VALUES ('horror'), ('sensacja'), ('romans'), ('komedia');

INSERT INTO cahe_genre (genre_name)
VALUES ('science-fiction');

INSERT INTO cahe_cinema (id, name, address, mail, phone, path_to_picture)
VALUES
    (1, 'Cinemahe Łódź', 'ul. Krakowska 71, 40-440 Łódź', 'cinemahe@lodz.pl', '+48 887 552 311', '../images/cinemas/cinema_lodz.jpg'),
	(2, 'Cinemahe Kraków', 'ul. Łódzka 17, 20-220 Kraków', 'cinemahe@kraków.pl', '+48 113 335 788', '../cinemas/cinema_krakow.jpg');

INSERT INTO cahe_room (name, cinema_id)
VALUES ('Pszeniczna', 1),
	('Ipa', 1),
    ('Lager', 2);

INSERT INTO cahe_director (id, first_name, last_name)
VALUES (1, 'Stanisław', 'Bareja'),
	(2, 'Sylwester', 'Chęciński'),
    (3, 'Marek', 'Koterski'),
    (4, 'Ridley', 'Scott'),
    (5, 'Robert', 'Zemeckis'),
	(6, 'John', 'McTiernan'),
    (7, 'Don', 'Siegel'),
    (8, 'Andy', 'Wachowsky'),
    (9, 'Larry', 'Wachowsky'),
    (10, 'Friedrich Wilhelm', 'Murnau'),
    (11, 'Stanley', 'Kubrick');

INSERT INTO cahe_movie (id, title, year, genre_id, wide_image, thin_image, description)
VALUES
(1, 'Miś', 1980, 4, '../images/movies/Miś.png', '../images/movies/Miś.png',
'Komedia złożona z groteskowych epizodów ukazujących rozpad PRL-owskiego systemu. Liczne sceny z barów mlecznych, urzędów i sklepów ujawniają absurd codziennej egzystencji Polaków. Wokół historii Ochódzkiego (Stanisław Tym) narasta wiele ważnych, małych opowieści charakteryzujących rzeczywistość początku lat osiemdziesiątych.'),
(2, 'Brunet wieczorową porą', 1976, 4, '../images/movies/BrunetWieczorowaPora.png', '../images/movies/BrunetWieczorowaPora.png',
'Cyganka przepowiada Michałowi Romanowi (Krzysztof Kowalewski) niezwykłe przeżycia, jednak on nie bierze poważnie tych proroctw. Gdy jego rodzina wyjeżdża na weekend, Michał zabiera się do zaległej pracy. Wtedy zaczynają się spełniać proroctwa Cyganki - Michał znajduje zaginiony zegarek, a w totolotku wylosowane zostają przepowiedziane liczby. Bohater zaczyna oczekiwać najgroźniejszej części przepowiedni - zapowiada ona zabicie bruneta, który zjawi się w jego mieszkaniu wieczorową porą...'),
(3, 'Rozmowy kontrolowane', 1991, 4, '../images/movies/RozmowyKontrolowane.png','../images/movies/RozmowyKontrolowane.png',
'W grudniu 1981 roku Ryszard Ochódzki (Stanisław Tym) otrzymuje od pułkownika UB, Zygmunta Molibdena (Krzysztof Kowalewski), zadanie przeniknięcia do struktur "Solidarności" w Suwałkach. Wyposażony we wspólne zdjęcie z Lechem Wałęsą udaje się do województwa suwalskiego. Tam zastaje go stan wojenny. Po spowodowaniu wypadku samochodowego, Ochódzki porzuca swój pojazd i pożyczonym autem wraca do stolicy. Zatrzymuje go patrol milicji, który w bagażniku samochodu znajduje solidarnościowe ulotki. Bojąc się aresztowania, rzuca się do ucieczki...'),
(4, 'Dzień świra', 2002, 4, '../images/movies/DzienSwira.png','../images/movies/DzienSwira.png',
'Gorzka komedia opowiadająca o Adasiu Miauczyńskim (Marek Kondrat), człowieku, dla którego najbliższe pięć minut życia stanowi prawdziwe piekło. Mężczyzna jest uwikłany w natręctwa życia codziennego. To numeroman, ablutoman, nie akceptuje siebie i choć marzy o wielkiej miłości, ucieka od wszystkiego, co pachnie stałym związkiem. Na dodatek codzienne kontakty z ludźmi wywołują w nim agresję. W ciągu jednej doby, w czasie której rozgrywa się akcja, skoncentrowane zostały wszelkie możliwe uciążliwości.'),
(5, 'Obcy - 8. pasażer “Nostromo”', 1979, 5, '../images/movies/Obcy.png','../images/movies/Obcy.png',
'Kosmos. Odległy wszechświat. Grupa siedmiorga członków załogi przebywa w stanie hibernacji. Ich sen przerywa sygnał S.O.S. nadawany z planety LV-240. Kapitan Dallas (Tom Skeritt), dowódca statku, zarządza zejście na niezbadaną planetę w ramach akcji ratunkowej. Jeden z członków załogi, niejaki Kane (John Hurt), zostaje zaatakowany przez nieznane stworzenie, który rzuca mu się na twarz i zaciska wokół szyi. Załoga zabiera Kane`a na pokład. Od tej chwili ich podróż przeradza się koszmar. Sygnał S.O.S. nadawany z nieznanej planety okazuje się ostrzeżeniem, lecz już za późno... Załoga otrzymuje nowego, niechcianego pasażera, ósmego pasażera "Nostromo".'),
(6, 'Powrót do przyszłości', 1985, 5, '../images/movies/BackToTheFuture.png', '../images/movies/BackToTheFuture.png',
'Marty McFly (Michael J. Fox) jest typowym nastolatkiem, ale ma niezwykłego przyjaciela - doktora Emmetta Browna (Christopher Lloyd), który wynalazł wehikuł czasu. W nocy przed centrum handlowym dr Brown pokazuje swój wynalazek Marty`emu. Wygląda on jak udoskonalony samochód, a działa na pluton. Dr Brown zwędził go Libijczykom, którzy chcieli, aby zrobił im bombę atomową. Podczas eksperymentu terroryści zabijają doktora. Marty cudem uchodzi z życiem, ale przenosi się do roku 1955. Szukając dra Browna z lat pięćdziesiątych, natyka się na rodziców i zapobiega ich poznaniu. W wyniku tego może się nigdy nie urodzić... '),
(7, 'Powrót do przyszłości II', 1989, 5, '../images/movies/BackToTheFuture2.png','../images/movies/BackToTheFuture2.png',
'Druga część opowieści o lekko zwariowanym doktorze i jego wehikule czasu. Tym razem doktor Emmet Brown i jego przyjaciel Marty wybierają się w przyszłość, by zapobiec "zniszczeniu" przyszłej rodziny Marty`ego. Seria niezwykłych przypadków sprawia, że zmienia się przeszłość (więc także i przyszłość) którą znali. Marty i Doktor postanawiają naprawić to co zrobili, co wcale nie jest takie proste...'),
(8, 'Szklana pułapka', 1988, 2, '../images/movies/DieHard.png', '../images/movies/DieHard.png',
'Klasyczny film akcji z brawurową kreacją Bruce`a Willisa w roli policjanta. W wieżowcu japońskiej korporacji w Los Angeles trwa świąteczne przyjęcie. Wśród pracowników jest żona Johna McClane`a, policjanta z Nowego Jorku, który przyleciał do Kalifornii. W tym czasie do wieżowca przedostają się terroryści, chcący zrabować ze skarbca kilka milionów dolarów. Nie przewidzieli tylko jednego, że w labiryncie pięter i korytarzy ukrył się McClane. Rozpoczyna się pojedynek, podczas którego John eliminuje po kolei przestępców.'),
(9, 'Matrix', 1999, 2, '../images/movies/Matrix.jpg', '../images/movies/Matrix.jpg',
'Neo (Keanu Reeves) jest genialnym hakerem. Pewnego dnia nawiązuje z nim kontakt tajemniczy Morfeusz (Laurence Fishburne) - człowiek, który obiecuje przekazać mu wiedzę o rzeczywistości, w jakiej żyje. Prawdę o dwóch światach: prawdziwym i wygenerowanym, który ma tylko udawać rzeczywistość. Neo przystaje do grupy Morfeusza i zaczyna dostrzegać, że świat, w którym egzystował to fikcja, a jego życiem cały czas ktoś kierował. Kolejne stopnie wtajemniczenia stawiają przed Neo nowe pytania. Czym jest Matrix i komu służy? I jaką rolę w planie Morfeusza ma do spełnienia on sam?'),
(10, 'Brudny Harry', 1971, 2, '../images/movies/BrudnyHarry.png', '../images/movies/BrudnyHarry.png',
'Dramat sensacyjny, który zmienił sposób realizacji obrazów policyjnych. Harry Callahan (Clint Eastwood), porucznik policji z San Francisco, słynie z tego, że przestępców chętniej traktuje kulami ze swojego Magnum kaliber 44 niż przesłuchuje. Otrzymuje polecenie schwytania Skorpiona, psychopatycznego mordercy, który grozi, że będzie zabijał mieszkańców miasta aż do momentu, kiedy nie otrzyma wysokiego okupu.'),
(11, 'Nosferatu - symfonia grozy', 1922, 1, '../images/movies/Nosferatu.png', '../images/movies/Nosferatu.png',
'Thomas Hutter (Gustav von Wangenheim), rozstaje się z ukochaną żoną Ellen (Greta Schroeder) i wyrusza do hrabiego Orloka (Max Schreck), w celu podpisania z nim umowy na sprzedaż domu w rodzinnym Wisborgu. Po drodze ludzie ostrzegają go przed hrabią, jednakże młody chłopak nie wierzy w historie o wampirze. Hutter dociera do zamku, gdzie czeka na niego spragniony krwi Nosferatu. Thomasa przed ostatecznym atakiem hrabiego-wampira ratuje Ellen, nie zdaje sobie jednak sprawy, że ściąga na siebie jego uwagę. Nosferatu wyrusza statkiem do Wisborga...'),
(12, 'Lśnienie', 1980, 1, '../images/movies/Lsnienie.png', '../images/movies/Lsnienie.png',
'Jack Torrance (Jack Nicholson) pracuje jako dozorca hotelu Panorama w górach stanu Kolorado. Pensjonat jest zamknięty na zimę, więc Jack z rodziną są jedynymi mieszkańcami budynku. Kiedy burze śnieżne blokują familię Torrance`ów w hotelu, Danny (Danny Lloyd), syn Jacka, który ma nadprzyrodzone, telepatyczne zdolności odkrywa, że pensjonat jest nawiedzony i duchy powoli doprowadzają jego ojca do obłędu. Kiedy Jack spotyka zjawę pana Grady`ego (Philip Stone), poprzedniego dozorcy hotelu, sytuacja staje się coraz groźniejsza.');

INSERT INTO cahe_movie_director (id_movie, id_director)
VALUES (1, 1), (2, 1), (3, 2), (4, 3), (5, 4), (6, 5), (7, 5),
(8, 6), (9, 8), (9, 9), (10, 7), (11, 10), (12, 11);

INSERT INTO cahe_seance (start_date, end_date, movie_id, room_id)
VALUES
('2022-01-26 16:00:00', '2022-01-26 18:00:00', 1, 1),
('2022-01-26 20:00:00', '2022-01-26 22:00:00', 2, 2),
('2022-01-27 16:00:00', '2022-01-27 18:00:00', 3, 3),
('2022-01-27 20:00:00', '2022-01-27 22:00:00', 4, 1),
('2022-01-28 16:00:00', '2022-01-28 18:00:00', 5, 2),
('2022-01-28 20:00:00', '2022-01-28 22:00:00', 6, 3),
('2022-01-29 16:00:00', '2022-01-29 18:00:00', 7, 1),
('2022-01-29 20:00:00', '2022-01-29 22:00:00', 8, 2),
('2022-01-30 16:00:00', '2022-01-30 18:00:00', 9, 3),
('2022-01-30 20:00:00', '2022-01-30 22:00:00', 10, 1),
('2022-01-31 16:00:00', '2022-01-31 18:00:00', 11, 2),
('2022-01-31 20:00:00', '2022-01-31 22:00:00', 12, 3),
('2022-01-31 16:00:00', '2022-01-31 18:00:00', 1, 1),
('2022-02-01 20:00:00', '2022-02-01 22:00:00', 2, 2);

INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (1, 1, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (2, 1, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (3, 1, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (4, 1, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (5, 1, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (6, 1, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (1, 2, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (2, 2, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (3, 2, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (4, 2, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (5, 2, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (6, 2, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (1, 3, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (2, 3, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (3, 3, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (4, 3, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (5, 3, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (6, 3, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (1, 4, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (2, 4, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (3, 4, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (4, 4, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (5, 4, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (6, 4, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (1, 5, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (2, 5, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (3, 5, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (4, 5, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (5, 5, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (6, 5, 1);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (1, 1, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (2, 1, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (3, 1, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (4, 1, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (5, 1, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (6, 1, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (1, 2, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (2, 2, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (3, 2, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (4, 2, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (5, 2, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (6, 2, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (1, 3, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (2, 3, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (3, 3, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (4, 3, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (5, 3, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (6, 3, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (1, 4, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (2, 4, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (3, 4, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (4, 4, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (5, 4, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (6, 4, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (1, 5, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (2, 5, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (3, 5, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (4, 5, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (5, 5, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (6, 5, 2);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (1, 1, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (2, 1, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (3, 1, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (4, 1, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (5, 1, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (6, 1, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (1, 2, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (2, 2, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (3, 2, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (4, 2, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (5, 2, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (6, 2, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (1, 3, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (2, 3, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (3, 3, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (4, 3, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (5, 3, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (6, 3, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (1, 4, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (2, 4, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (3, 4, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (4, 4, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (5, 4, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (6, 4, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (1, 5, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (2, 5, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (3, 5, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (4, 5, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (5, 5, 3);
INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (6, 5, 3);

INSERT INTO cahe_user (first_name, last_name, mail, registration_date, phone_number, password)
VALUES ('Adam', 'Wesołowski', 'adamcio125@gmail.com', '2022-01-12 23:14:56', '+48 662 773 456', hex('abc')),
('Franciszek', 'Bałaga', 'bala@o2.pl', '2022-01-09 11:00:56', '612 343 998', hex('123')),
('Bogdan', 'Krupniewski', 'misu15@wp.pl', '2022-01-23 14:14:09', NULL, hex('ab1')),
('Czesława', 'Nowotko', 'czesia@vp.pl', '2022-01-22 08:25:11', '+48 734 593 660', hex('1ab')),
('Dominika', 'Bania', 'nika17@gov.pl', '2022-02-13 20:04:57', '+48 347 112 987', hex('zzz'));

