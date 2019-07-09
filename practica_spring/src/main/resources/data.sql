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
('false', 'Estado#1547', 'Kevincito', 1),
('false', 'Argomedo#174', 'Rapido&Furioso', 2),
('true', 'Bernardo#014', 'Cafeteria', 3),
('false', 'Montt#213', 'Equifax', 4),
('false', 'Frei#324', '3it', 5),
('true', 'direccion6', 'Microsoft', 6),
('false', 'direccion7', 'Java', 7),
('false', 'direccion8', 'Apple', 7),
('true', 'direccion9', 'Garcia', 8),
('false', 'direccion10', 'Microplay', 9);

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

INSERT INTO alumnos(apellido_paterno,apellido_materno,domicilio,nombre,telefono,email, id_usuario) VALUES
('Escalona','Morales','30Oriente','Bastián','97219277','bastianescalona@hotmail.com', 2),
('Farfan','Retamal','Linares','Carlos','546565498','carlosfarfan@hotmail.com',3),
('Vergara','Pereira','5norte','Carlos','3213223', 'carlosvergara@gmail.com',4),
('Riffo','Araya','linares5sur','Tomas','2316545', 'tomasriffo@gmail.com',5),
('Muñoz','Pereira','84norte','Matias','21474513', 'matiasmuñoz@gmail.com',6),
('Farfan','Morales','sur18oriente','Bastian','32132561','bastianfarfan@gmail.es',7),
('Riffo','Retamal','poniente1','Carlos','4655632','carlosriffo@live.cl' ,8),
('Muñoz','Acevedo','Maule','Octavio','64873212', 'ostavio09@gmail.com',9),
('Perez','Perez','1Norte','Santiago','123456223', 'santiagoperez@hotmail.com',10),
('Perez','Gonzalez','SanJavier','Juan','654987321','juanperez@gmail.com',11);


/*Usuarios Dispuestos a los docente Contraseña 1234*/
INSERT INTO users (enabled,password,username) VALUES
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','15000001'),  /*12*/
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','15000002'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','15000003'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','15000004'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','15000005'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','15000006'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','15000007'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','15000008'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','15000009'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','14000001'); /*21*/

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
('false','haraya@spock.ucm.cl', 'HugoAraya', 12),
('false','rbarrientos@ucm.cl', 'RicardoBarrientos', 13),
('false','mtoranzo@ucm.cl', 'MarcoToranzo', 14),
('false','rcofre@ucm.cl', 'RodrigoCofré', 15),
('false','mmora@ucm.cl', 'MarcoMora', 16),
('false','ftirado@ucm.cl', 'FelipeTirado', 17),
('false','mjarur@ucm.cl', 'MaryJarur', 18),
('false','aurrutia@spock.ucm.cl', 'AngélicaUrrutia', 19),
('false','shernandez@ucm.cl', 'SergioHernández', 20),
('true','pgonzalez@ucm.cl', 'PauloGonzález', 21);

/*Usuarios Dispuestos a los evaluadores Contraseña 1234*/
INSERT INTO users (enabled,password,username) VALUES
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','12000001'),  /*22*/
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','12000002'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','12000003');  /*24*/

INSERT INTO authorities_users (usuario_id, authority_id) VALUES (22,5);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (23,5);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (24,5);

INSERT INTO evaluadores(nombre, email, telefono, id_usuario) VALUES
('Bastián', 'bastian@evaluador1.com', '12345', 22),
('Carlos', 'carlos@evaluador2.com', '12341', 23),
('Octavio', 'octavio@evaluador3.com', '12343', 24);

INSERT INTO practicas(actividades_realizar_practica, fecha_practica, id_alumno, id_empresa, id_evaluador, id_docente,activo) VALUES
('crear','2019-07-22',1, 1, 1, 1,'false'),
('modificar','2019-07-22',2, 2, 1, 1,'true'),
('eliminar','2019-07-22',3, 1, 2, 1,'false'),
('vistas','2019-08-12',4, 1, 2, 2,'false'),
('crear','2019-08-12',5, 2, 1, 2,'false'),
('modificar','2019-08-12',6, 2, 3, 2,'false'),
('eliminar','2019-08-12',7, 3, 2, 3,'false');

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
