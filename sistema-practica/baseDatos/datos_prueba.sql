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

insert into docentes(id, director, nombre, run)
values(1, false, 'nombre1', 123456789);

insert into docentes(id, director, nombre, run)
values(2, true, 'nombre2', 12345678);

insert into docentes(id, director, nombre, run)
values(3, false, 'nombre3', 1234567);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(1, false, 'direccion1', 'nombreE1', 1);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(2, false, 'direccion2', 'nombreE2', 4);

insert into empresas(id, convenio, direccion, nombre, id_comuna)
values(3, true, 'direccion3', 'nombreE3', 5);




