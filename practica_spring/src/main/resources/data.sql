

INSERT INTO users (enabled,password,username) VALUES
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','12345'),
(false,'$2a$04$AP8Hvx3DSC3.BKlK6RsF9OJgBP8XGZCfu7O3s3wP947.7slME.0ga','98765');

INSERT INTO authorities (authority) VALUES
('ROLE_ADMIN'),
('ROLE_DOCENTE'),
('ROLE_DIRECTOR'),
('ROLE_ALUMNO');

INSERT INTO authorities_users (usuario_id, authority_id) VALUES (1,1);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (1,2);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (1,3);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (1,4);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (2,4);






INSERT INTO regiones (nombre) VALUES
('Maule'),
('Ñuble');

INSERT INTO comunas (nombre, region_id) VALUES
('Curico', 1),
('Rauco', 1),
('Teno', 1),
('Talca', 1),
('stgo', 1),
('pichilemu', 1),
('sanclemente', 1),
('linares', 1),
('maule', 1),
('asdasd', 1);

INSERT INTO docentes(director, email_doc, nombre_doc, run_doc) VALUES
('false','nombre1@docente.com', 'nombre1', 1),
('true','nombre2@docente.com', 'nombre2', 2),
('false','nombre3@docente.com', 'nombre3', 3),
('false','nombre4@docente.com', 'nombre4', 4),
('true','nombre5@docente.com', 'nombre5', 5),
('false','nombre6@docente.com', 'nombre6', 6),
('false','nombre7@docente.com', 'nombre7', 7),
('true','nombre8@docente.com', 'nombre8', 8),
('false','nombre9@docente.com', 'nombre9', 9),
('false','nombre10@docente.com', 'nombre10', 10);


INSERT INTO empresas(convenio, direccion, nombre, id_comuna) VALUES
('false', 'direccion1', 'nombreE1', 1),
('false', 'direccion2', 'nombreE2', 1),
('true', 'direccion3', 'nombreE3', 2),
('false', 'direccion4', 'nombreE4', 1),
('false', 'direccion5', 'nombreE5', 1),
('true', 'direccion6', 'nombreE6', 4),
('false', 'direccion7', 'nombreE7', 5),
('false', 'direccion8', 'nombreE8', 3),
('true', 'direccion9', 'nombreE9', 2),
('false', 'direccion10', 'nombreE10', 1);

INSERT INTO alumnos(apellido_paterno,apellido_materno,domicilio_procedencia,nombre,run,telefono) VALUES
('escalona','morales','30oriente','bastian',191769538,'97219277'),
('farfan','retamal','linares','carlos',183441930,'546565498'),
('vergara','pereira','5norte','carlos',181547431,'3213223'),
('riffo','araya','linares5sur','tomas',207598410,'2316545'),
('muñoz','pereira','84norte','matias',174231542,'21474513'),
('farfan','morales','sur18oriente','bastian',401237841,'32132561'),
('riffo','retamal','poniente1','carlos',151234567,'4655632'),
('alambrito','caldito','talca','edificio',132134654,'64873212'),
('maldito','enojadito','1norte','ditto',784123145,'123456223'),
('pikachu','ketchup','pueblopaleta','ash',321211246,'654987321');

INSERT INTO practicas(actividades_realizar_practica,domicilio_actual_practica,fecha_practica,nombre_evaluador_practica,telefono_evaluador_practica) VALUES
('crear','santiago','2019-07-22','marco','97219277'),
('crear','santiago','2019-08-12','bastian','12312332'),
('editar','santiago','2019-06-10','tomas','432423423'),
('editar','santiago','2019-07-25','carlos','456456456'),
('modificar','santiago','2019-10-31','matias','45645765'),
('modificar','talca','2019-09-31','carlos','123123123'),
('eliminar','talca','2019-08-31','ignacio','452342334'),
('eliminar','talca','2019-07-31','lillo','123123132'),
('formulario','talca','2019-06-31','matias','23423423'),
('formulario','talca','2019-05-31','tomate','234234234');

INSERT INTO evaluacionpracticas(fecha,pregunta1,pregunta2,tabla1_pregunata1,tabla1_pregunata2,tabla2_pregunata1,tabla2_pregunata2) VALUES
('2019-06-05','respuesta1','respuesta2','regular','bueno','muy malo','bueno'),
('2019-08-01','respuesta1','respuesta2','regular','bueno','muy malo','bueno'),
('2019-08-02','respuesta1','respuesta2','regular','bueno','muy malo','bueno'),
('2019-08-03','respuesta1','respuesta2','regular','bueno','muy malo','bueno'),
('2019-08-04','respuesta1','respuesta2','Malo','Muy bueno','muy malo','bueno'),
('2019-08-05','respuesta1','respuesta2','regular','bueno','muy malo','bueno'),
('2019-08-06','respuesta1','respuesta2','regular','Muy bueno','muy malo','bueno'),
('2019-08-07','respuesta1','respuesta2','regular','bueno','muy malo','bueno'),
('2019-08-08','respuesta1','respuesta2','regular','bueno','muy malo','bueno'),
('2019-08-09','respuesta1','respuesta2','regular','Muy bueno','muy malo','bueno');

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
