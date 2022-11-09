CREATE table bezoekers(
	bezoeker_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
    naam VARCHAR(50) NOT NULL,
    voornaam VARCHAR(50) NOT NULL,
    straat_en_nummer VARCHAR(50) NOT NULL,
    gemeente VARCHAR(50) NOT NULL,
    postcode VARCHAR(5) NOT NULL,
    land CHAR(2) NOT NULL,
    PRIMARY KEY (bezoeker_id)
);

INSERT into bezoekers VALUES
	(null, 'Peters' , 'Jan'	, 'Pierstraat 5' ,	'Aartselaar',	'2630',	'BE'),
	(null,'Degrootte',	'Nick',	'Palmboomstraat 4',	'Diest',	'3290',	'BE'),
	(null,'Deridder',	'Eva',	'Pelserstraat 17',	'Maaseik',	'3680',	'BE'),
	(null, 'Wilms ','	Frederik',	'Molendreef 121',	'Waasmunster',	'9250',	'BE'),
	(null,'Moons','	Anja','	Rue des Brasseurs 13','	Mons',	'7000',	'BE'),
	(null,'Van gogh', 'Sara','rue van gogh 12','	Paris',	'75012','FR'),
	(null,'Richard','	Pierre','	Rue de Soleil','	Saint-Tropez','83990',	'FR'),
	(null,'Romer','	Linda	','Ahornstrasse 7','	Berlin',	'12624',	'DE'),
	(null,'Lindt',	'Aurelie','	18 Rue Richmont	Geneve','1202',	'CH'),
	(null,'Borger	','Bjorn	','Langstrasse 500	','Zurich','	8005',	'CH'),
	(null,'Herman','	Fries','	Avenue de Cour 20	','Lausanne','	1007',	'CH'),
	(null,'Zoetemelk	','Joop','	Delftlandlaan 19','	Amsterdam','	1062',	'NL'),
	(null,'De Loenen	','Belinda','	Kleine Gracht 24	','Maastricht','	6222',	'NL'),
	(null,'Santos	','Carlos	','Plaza de Torros 6	','Granada','	18010',	'ES'),
	(null,'Witteveen','	Kees	','Hoefkade 9','	Den Haag','	2526',	'NL'),
	(null,'Contador','	Jorge ','	Paseo de Sancha 17','	Malaga','	29016',	'ES'),
	(null,'Castello ','	Isabella','	Frezzaria 128 San Marco	Venetie',	'30124',	'IT'),
	(null,'Corce','	Paolo	','Via del porto 6	','Bologna','40122','IT');
    
    


UPDATE `bezoekers` SET `naam` = 'Wilmots' WHERE `bezoeker_id` = 4;

UPDATE `bezoekers` SET `straat_en_nummer` = 'Rue van gogh 12a' WHERE `voornaam` = 'sara';

ALTER TABLE bezoekers
MODIFY COLUMN postcode INT NOT NULL;

DELETE FROM bezoekers WHERE 'land' = 'DE';

SELECT sum(postcode)
FROM bezoekers;


