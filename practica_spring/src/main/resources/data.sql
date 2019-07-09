INSERT INTO users (enabled,password,username) VALUES
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','12345');

/*Roles*/
INSERT INTO authorities (authority) VALUES
('ROLE_ADMIN'),     /*1*/
('ROLE_DOCENTE'),   /*2*/
('ROLE_DIRECTOR'),  /*3*/
('ROLE_ALUMNO'),    /*4*/
('ROLE_EMPRESA');   /*5*/


INSERT INTO authorities_users (usuario_id, authority_id) VALUES (1,1);


INSERT INTO regiones (nombre) VALUES
('O’Higgins'),  /*1*/
('Maule'),      /*2*/
('Ñuble'),      /*3*/
('BioBio');     /*4*/

INSERT INTO comunas (nombre, region_id) VALUES
('San Fernando', 1),
('Chépica', 1),
('Rancagua', 1),

('Curico', 2),
('Rauco', 2),
('Teno', 2),
('Talca', 2),

('Chillán', 3),
('San Carlos', 3),

('Concepción', 4);



INSERT INTO empresas(convenio, direccion, nombre, id_comuna) VALUES
('false', 'direccion1', 'nombreE1', 1),
('false', 'direccion2', 'nombreE2', 2),
('true', 'direccion3', 'nombreE3', 3),
('false', 'direccion4', 'nombreE4', 4),
('false', 'direccion5', 'nombreE5', 5),
('true', 'direccion6', 'nombreE6', 6),
('false', 'direccion7', 'nombreE7', 7),
('false', 'direccion8', 'nombreE8', 7),
('true', 'direccion9', 'nombreE9', 8),
('false', 'direccion10', 'nombreE10', 9);

/*Usuarios Dispuestos a los alumnos Contraseña 1234*/
INSERT INTO users (enabled,password,username) VALUES
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','19000001'),  /*2*/
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','19000002'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','19000003'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','19000004'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','19000005'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','19000006'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','19000007'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','19000008'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','19000009'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','19000010');  /*11*/

/*Asignacion de usuario al alumno*/
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (2,4);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (3,4);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (4,4);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (5,4);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (6,4);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (7,4);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (8,4);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (9,4);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (10,4);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (11,4);

INSERT INTO alumnos(apellido_paterno,apellido_materno,domicilio,nombre,telefono, id_usuario) VALUES
('escalona','morales','30oriente','bastian','97219277', 2),
('farfan','retamal','linares','carlos','546565498', 3),
('vergara','pereira','5norte','carlos','3213223', 4),
('riffo','araya','linares5sur','tomas','2316545', 5),
('muñoz','pereira','84norte','matias','21474513', 6),
('farfan','morales','sur18oriente','bastian','32132561', 7),
('riffo','retamal','poniente1','carlos','4655632', 8),
('alambrito','caldito','talca','edificio','64873212', 9),
('maldito','enojadito','1norte','ditto','123456223', 10),
('pikachu','ketchup','pueblopaleta','ash','654987321', 11);


/*Usuarios Dispuestos a los docente Contraseña 1234*/
INSERT INTO users (enabled,password,username) VALUES
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','2201'),  /*12*/
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','2202'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','2203'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','2204'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','2205'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','2206'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','2207'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','2208'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','2209'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','3301'); /*21*/

/*Asignando roles a los docentes*/
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (12,2);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (13,2);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (14,2);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (15,2);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (16,2);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (17,2);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (18,2);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (19,2);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (20,2);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (21,2);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (21,3);


INSERT INTO docentes(director, email_doc, nombre_doc, id_usuario) VALUES
('false','nombre1@docente.com', 'nombre1', 12),
('false','nombre2@docente.com', 'nombre2', 13),
('false','nombre3@docente.com', 'nombre3', 14),
('false','nombre4@docente.com', 'nombre4', 15),
('false','nombre5@docente.com', 'nombre5', 16),
('false','nombre6@docente.com', 'nombre6', 17),
('false','nombre7@docente.com', 'nombre7', 18),
('false','nombre8@docente.com', 'nombre8', 19),
('false','nombre9@docente.com', 'nombre9', 20),
('true','nombre10@docente.com', 'nombre10', 21);

/*Usuarios Dispuestos a los evaluadores Contraseña 1234*/
INSERT INTO users (enabled,password,username) VALUES
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','5501'),  /*22*/
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','5502'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','5503');  /*24*/

INSERT INTO authorities_users (usuario_id, authority_id) VALUES (22,5);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (23,5);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (24,5);

INSERT INTO evaluadores(nombre, email, telefono, id_usuario) VALUES
('nombre1', 'nombre1@em.com', '12345', 22),
('nombre2', 'nombre2@em.com', '12341', 23),
('nombre3', 'nombre3@em.com', '12343', 24);

INSERT INTO practicas(actividades_realizar_practica, fecha_practica, id_alumno, id_empresa, id_evaluador, id_docente,activo) VALUES
('crear','2019-07-22',1, 1, 1, 1,'false'),
('crear','2019-07-22',2, 2, 1, 1,'true'),
('crear','2019-07-22',3, 1, 1, 1,'false'),
('crear','2019-08-12',4, 1, 1, 2,'false'),
('crear','2019-08-12',5, 2, 1, 2,'false'),
('crear','2019-08-12',6, 2, 1, 2,'false'),
('crear','2019-08-12',7, 3, 2, 2,'false');

/*INSERT INTO evaluacionpracticas(fecha,pregunta1,pregunta2,tabla1_pregunata1,tabla1_pregunata2,tabla2_pregunata1,tabla2_pregunata2, id_practica) VALUES
('2019-06-05','respuesta1','respuesta2','regular','bueno','muy malo','bueno',2);
*/
INSERT INTO evaluacionempresas(comentario,nota) VALUES
('excelente',7),
('regular',5),
('bueno',6),
('decepcionante',4),
('pesimo',1),
('excelente',7),
('debe mejorar',4),
('excelente',7),
('pesimo',1),
('excelente',7);
