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
values(5, 'Chillan', 2);

insert into docentes(id_doc, director, email_doc, nombre_doc, run_doc)
values(1, false,'nombre1@docente.com', 'nombre1', 123456789);

insert into docentes(id_doc, director, email_doc, nombre_doc, run_doc)
values(2, true,'nombre2@docente.com', 'nombre2', 12345678);

insert into docentes(id_doc, director, email_doc, nombre_doc, run_doc)
values(3, false,'nombre4@docente.com', 'nombre3', 1234567);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(1, false, 'direccion1', 'nombreE1', 1);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(2, false, 'direccion2', 'nombreE2', 4);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(3, true, 'direccion3', 'nombreE3', 5);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(4, false, 'direccion4', 'nombreE4', 1);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(5, false, 'direccion5', 'nombreE5', 4);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(6, true, 'direccion6', 'nombreE6', 5);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(7, false, 'direccion7', 'nombreE7', 1);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(8, false, 'direccion8', 'nombreE8', 4);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(9, true, 'direccion9', 'nombreE9', 5);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(10, false, 'direccion10', 'nombreE10', 1);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(11, false, 'direccion11', 'nombreE11', 4);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(12, true, 'direccion12', 'nombreE12', 5);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(13, false, 'direccion13', 'nombreE13', 1);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(14, false, 'direccion14', 'nombreE14', 4);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(15, true, 'direccion15', 'nombreE15', 5);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(16, false, 'direccion16', 'nombreE16', 1);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(17, false, 'direccion17', 'nombreE17', 4);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(18, true, 'direccion18', 'nombreE18', 5);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(19, false, 'direccion19', 'nombreE19', 1);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(20, false, 'direccion20', 'nombreE20', 4);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(21, true, 'direccion21', 'nombreE21', 5);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(22, false, 'direccion22', 'nombreE22', 1);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(23, false, 'direccion23', 'nombreE23', 4);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(24, true, 'direccion24', 'nombreE24', 5);
