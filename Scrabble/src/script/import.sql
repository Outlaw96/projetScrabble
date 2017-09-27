DROP TABLE mot;
DROP TABLE pion;

CREATE TABLE mot (
id serial primary key,
libelle text not null);


CREATE TABLE pion(
id serial primary key,
letter text not null,
point int not null,
joker boolean default false,
placed boolean default false);

INSERT INTO pion (letter, point, joker) VALUES
('joker', 0, true),
('joker', 0, true);

INSERT INTO pion (letter, point) VALUES
('K', 10),
('W', 10),
('X', 10),
('Y', 10),
('Z', 10),

('J', 8),
('Q', 8),

('F', 4),
('F', 4),
('H', 4),
('H', 4),
('V', 4),
('V', 4),

('B', 3),
('B', 3),
('C', 3),
('C', 3),
('P', 3),
('P', 3),

('D', 2),
('D', 2),
('D', 2),
('G', 2),
('G', 2),
('M', 2),
('M', 2),
('M', 2),

('E', 1),
('E', 1),
('E', 1),
('E', 1),
('E', 1),
('E', 1),
('E', 1),
('E', 1),
('E', 1),
('E', 1),
('E', 1),
('E', 1),
('E', 1),
('E', 1),
('E', 1),

('A', 1),
('A', 1),
('A', 1),
('A', 1),
('A', 1),
('A', 1),
('A', 1),
('A', 1),
('A', 1),


('I', 1),
('I', 1),
('I', 1),
('I', 1),
('I', 1),
('I', 1),
('I', 1),
('I', 1),

('N', 1),
('N', 1),
('N', 1),
('N', 1),
('N', 1),
('N', 1),


('O', 1),
('O', 1),
('O', 1),
('O', 1),
('O', 1),
('O', 1),

('R', 1),
('R', 1),
('R', 1),
('R', 1),
('R', 1),
('R', 1),

('S', 1),
('S', 1),
('S', 1),
('S', 1),
('S', 1),
('S', 1),

('T', 1),
('T', 1),
('T', 1),
('T', 1),
('T', 1),
('T', 1),

('U', 1),
('U', 1),
('U', 1),
('U', 1),
('U', 1),
('U', 1),

('L', 1),
('L', 1),
('L', 1),
('L', 1),
('L', 1);

