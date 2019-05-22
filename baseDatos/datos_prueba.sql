insert into regiones (id, nombre)
values(1, 'Maule');

insert into regiones (id, nombre)
values(2, 'Ñuble');

insert into comunas (id, nombre, region_id)
values(1, 'Curico', 1);

insert into comunas (id, nombre, region_id)
values(2, 'Rauco', 1);

insert into comunas (id, nombre, region_id)
values(3, 'Teno', 1);

insert into comunas(id, nombre, region_id)
values(4, 'Talca', 1);

insert into comunas(id, nombre, region_id)
values(5, 'stgo', 1);

insert into comunas(id, nombre, region_id)
values(6, 'pichilemu', 1);

insert into comunas(id, nombre, region_id)
values(7, 'sanclemente', 1);

insert into comunas(id, nombre, region_id)
values(8, 'linares', 1);

insert into comunas(id, nombre, region_id)
values(9, 'maule', 1);

insert into comunas(id, nombre, region_id)
values(10, 'asdasd', 1);

insert into docentes(id_doc, director, email_doc, nombre_doc, run_doc)
values(1, 'false','nombre1@docente.com', 'nombre1', 1);

insert into docentes(id_doc, director, email_doc, nombre_doc, run_doc)
values(2, 'true','nombre2@docente.com', 'nombre2', 2);

insert into docentes(id_doc, director, email_doc, nombre_doc, run_doc)
values(3, 'false','nombre3@docente.com', 'nombre3', 3);

insert into docentes(id_doc, director, email_doc, nombre_doc, run_doc)
values(4, 'false','nombre4@docente.com', 'nombre4', 4);

insert into docentes(id_doc, director, email_doc, nombre_doc, run_doc)
values(5, 'true','nombre5@docente.com', 'nombre5', 5);

insert into docentes(id_doc, director, email_doc, nombre_doc, run_doc)
values(6, 'false','nombre6@docente.com', 'nombre6', 6);

insert into docentes(id_doc, director, email_doc, nombre_doc, run_doc)
values(7, 'false','nombre7@docente.com', 'nombre7', 7);

insert into docentes(id_doc, director, email_doc, nombre_doc, run_doc)
values(8, 'true','nombre8@docente.com', 'nombre8', 8);

insert into docentes(id_doc, director, email_doc, nombre_doc, run_doc)
values(9, 'false','nombre9@docente.com', 'nombre9', 9);

insert into docentes(id_doc, director, email_doc, nombre_doc, run_doc)
values(10, 'false','nombre10@docente.com', 'nombre10', 10);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(1, 'false', 'direccion1', 'nombreE1', 1);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(2, 'false', 'direccion2', 'nombreE2', 1);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(3, 'true', 'direccion3', 'nombreE3', 2);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(4, 'false', 'direccion4', 'nombreE4', 1);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(5, 'false', 'direccion5', 'nombreE5', 1);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(6, 'true', 'direccion6', 'nombreE6', 4);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(7, 'false', 'direccion7', 'nombreE7', 5);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(8, 'false', 'direccion8', 'nombreE8', 3);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(9, 'true', 'direccion9', 'nombreE9', 2);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(10, 'false', 'direccion10', 'nombreE10', 1);

insert into alumnos(id,apellido_paterno,apellido_materno,domicilio_procedencia,nombre,run,telefono)
values(1,'escalona','morales','30oriente','bastian',191769538,'97219277');

insert into alumnos(id,apellido_paterno,apellido_materno,domicilio_procedencia,nombre,run,telefono)
values(2,'farfan','retamal','linares','carlos',183441930,'546565498');

insert into alumnos(id,apellido_paterno,apellido_materno,domicilio_procedencia,nombre,run,telefono)
values(3,'vergara','pereira','5norte','carlos',181547431,'3213223');

insert into alumnos(id,apellido_paterno,apellido_materno,domicilio_procedencia,nombre,run,telefono)
values(4,'riffo','araya','linares5sur','tomas',207598410,'2316545');

insert into alumnos(id,apellido_paterno,apellido_materno,domicilio_procedencia,nombre,run,telefono)
values(5,'muñoz','pereira','84norte','matias',174231542,'21474513');

insert into alumnos(id,apellido_paterno,apellido_materno,domicilio_procedencia,nombre,run,telefono)
values(6,'farfan','morales','sur18oriente','bastian',401237841,'32132561');

insert into alumnos(id,apellido_paterno,apellido_materno,domicilio_procedencia,nombre,run,telefono)
values(7,'riffo','retamal','poniente1','carlos',151234567,'4655632');

insert into alumnos(id,apellido_paterno,apellido_materno,domicilio_procedencia,nombre,run,telefono)
values(8,'alambrito','caldito','talca','edificio',132134654,'64873212');

insert into alumnos(id,apellido_paterno,apellido_materno,domicilio_procedencia,nombre,run,telefono)
values(9,'maldito','enojadito','1norte','ditto',784123145,'123456223');

insert into alumnos(id,apellido_paterno,apellido_materno,domicilio_procedencia,nombre,run,telefono)
values(10,'pikachu','ketchup','pueblopaleta','ash',321211246,'654987321');

insert into practicas(id_practica,actividades_realizar_practica,domicilio_actual_practica,fecha_practica,nombre_evaluador_practica,telefono_evaluador_practica)
values(1,'crear','santiago','2019-07-22','marco','97219277');

insert into practicas(id_practica,actividades_realizar_practica,domicilio_actual_practica,fecha_practica,nombre_evaluador_practica,telefono_evaluador_practica)
values(2,'crear','santiago','2019-08-12','bastian','12312332');

insert into practicas(id_practica,actividades_realizar_practica,domicilio_actual_practica,fecha_practica,nombre_evaluador_practica,telefono_evaluador_practica)
values(3,'editar','santiago','2019-06-10','tomas','432423423');

insert into practicas(id_practica,actividades_realizar_practica,domicilio_actual_practica,fecha_practica,nombre_evaluador_practica,telefono_evaluador_practica)
values(4,'editar','santiago','2019-07-25','carlos','456456456');

insert into practicas(id_practica,actividades_realizar_practica,domicilio_actual_practica,fecha_practica,nombre_evaluador_practica,telefono_evaluador_practica)
values(5,'modificar','santiago','2019-10-31','matias','45645765');

insert into practicas(id_practica,actividades_realizar_practica,domicilio_actual_practica,fecha_practica,nombre_evaluador_practica,telefono_evaluador_practica)
values(6,'modificar','talca','2019-09-31','carlos','123123123');

insert into practicas(id_practica,actividades_realizar_practica,domicilio_actual_practica,fecha_practica,nombre_evaluador_practica,telefono_evaluador_practica)
values(7,'eliminar','talca','2019-08-31','ignacio','452342334');

insert into practicas(id_practica,actividades_realizar_practica,domicilio_actual_practica,fecha_practica,nombre_evaluador_practica,telefono_evaluador_practica)
values(8,'eliminar','talca','2019-07-31','lillo','123123132');

insert into practicas(id_practica,actividades_realizar_practica,domicilio_actual_practica,fecha_practica,nombre_evaluador_practica,telefono_evaluador_practica)
values(9,'formulario','talca','2019-06-31','matias','23423423');

insert into practicas(id_practica,actividades_realizar_practica,domicilio_actual_practica,fecha_practica,nombre_evaluador_practica,telefono_evaluador_practica)
values(10,'formulario','talca','2019-05-31','tomate','234234234');

insert into evaluacionpracticas(id,fecha,pregunta1,pregunta2,tabla1_pregunata1,tabla1_pregunata2,tabla2_pregunata1,tabla2_pregunata2)
values(1,'2019-06-05','respuesta1','respuesta2','regular','bueno','muy malo','bueno');

insert into evaluacionpracticas(id,fecha,pregunta1,pregunta2,tabla1_pregunata1,tabla1_pregunata2,tabla2_pregunata1,tabla2_pregunata2)
values(2,'2019-08-01','respuesta1','respuesta2','regular','bueno','muy malo','bueno');

insert into evaluacionpracticas(id,fecha,pregunta1,pregunta2,tabla1_pregunata1,tabla1_pregunata2,tabla2_pregunata1,tabla2_pregunata2)
values(3,'2019-08-02','respuesta1','respuesta2','regular','bueno','muy malo','bueno');

insert into evaluacionpracticas(id,fecha,pregunta1,pregunta2,tabla1_pregunata1,tabla1_pregunata2,tabla2_pregunata1,tabla2_pregunata2)
values(4,'2019-08-03','respuesta1','respuesta2','regular','bueno','muy malo','bueno');

insert into evaluacionpracticas(id,fecha,pregunta1,pregunta2,tabla1_pregunata1,tabla1_pregunata2,tabla2_pregunata1,tabla2_pregunata2)
values(5,'2019-08-04','respuesta1','respuesta2','Malo','Muy bueno','muy malo','bueno');

insert into evaluacionpracticas(id,fecha,pregunta1,pregunta2,tabla1_pregunata1,tabla1_pregunata2,tabla2_pregunata1,tabla2_pregunata2)
values(6,'2019-08-05','respuesta1','respuesta2','regular','bueno','muy malo','bueno');

insert into evaluacionpracticas(id,fecha,pregunta1,pregunta2,tabla1_pregunata1,tabla1_pregunata2,tabla2_pregunata1,tabla2_pregunata2)
values(7,'2019-08-06','respuesta1','respuesta2','regular','Muy bueno','muy malo','bueno');

insert into evaluacionpracticas(id,fecha,pregunta1,pregunta2,tabla1_pregunata1,tabla1_pregunata2,tabla2_pregunata1,tabla2_pregunata2)
values(8,'2019-08-07','respuesta1','respuesta2','regular','bueno','muy malo','bueno');

insert into evaluacionpracticas(id,fecha,pregunta1,pregunta2,tabla1_pregunata1,tabla1_pregunata2,tabla2_pregunata1,tabla2_pregunata2)
values(9,'2019-08-08','respuesta1','respuesta2','regular','bueno','muy malo','bueno');

insert into evaluacionpracticas(id,fecha,pregunta1,pregunta2,tabla1_pregunata1,tabla1_pregunata2,tabla2_pregunata1,tabla2_pregunata2)
values(10,'2019-08-09','respuesta1','respuesta2','regular','Muy bueno','muy malo','bueno');

insert into evaluacionempresas(id,comentario,nota)
values(1,'excelente',7);

insert into evaluacionempresas(id,comentario,nota)
values(2,'regular',5);

insert into evaluacionempresas(id,comentario,nota)
values(3,'bueno',6);

insert into evaluacionempresas(id,comentario,nota)
values(4,'decepcionante',4);

insert into evaluacionempresas(id,comentario,nota)
values(5,'pesimo',1);

insert into evaluacionempresas(id,comentario,nota)
values(6,'excelente',7);

insert into evaluacionempresas(id,comentario,nota)
values(7,'debe mejorar',4);

insert into evaluacionempresas(id,comentario,nota)
values(8,'excelente',7);

insert into evaluacionempresas(id,comentario,nota)
values(9,'pesimo',1);

insert into evaluacionempresas(id,comentario,nota)
values(10,'excelente',7);

/*insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(11, 'false', 'direccion11', 'nombreE11', 4);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(12, 'true', 'direccion12', 'nombreE12', 5);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(13, 'false', 'direccion13', 'nombreE13', 1);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(14, 'false', 'direccion14', 'nombreE14', 4);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(15, 'true', 'direccion15', 'nombreE15', 5);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(16, 'false', 'direccion16', 'nombreE16', 1);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(17, 'false', 'direccion17', 'nombreE17', 4);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(18, 'true', 'direccion18', 'nombreE18', 5);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(19, 'false', 'direccion19', 'nombreE19', 1);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(20, 'false', 'direccion20', 'nombreE20', 4);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(21, 'true', 'direccion21', 'nombreE21', 5);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(22, 'false', 'direccion22', 'nombreE22', 1);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(23, 'false', 'direccion23', 'nombreE23', 4);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(24, 'true', 'direccion24', 'nombreE24', 5);
*/
