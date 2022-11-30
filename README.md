
Caso: La escuela de “cursos alternativos”

Cierta escuela que ofrece cursos especializados en diversas ciencias del conocimiento ha tenido un
crecimiento inesperado, por lo mismo han surgido necesidades que deben ser satisfechas.
Los padres de familia, los alumnos y muchas instituciones públicas y privadas, exigen información a la
escuela y lo que antes era fácil de proporcionar ahora se vuelve difícil de controlar y de mantener, sin
contar el tiempo invertido en ese proceso.
Derivado de lo anterior el colegio ha decidido desarrollar un sistema que les ayude a satisfacer estás
necesidades, empezando por sus principales clientes el alumno y padres de familia para cumplir la
siguiente obligación – necesidad.
Requerimiento.
La escuela “cursos alternativos” tiene la necesidad de construir un sistema para llevar a cabo el control
de las calificaciones de sus estudiantes, por ello debe crear un RestFul Web Service para registrar,
consultar y actualizar las calificaciones de sus estudiantes.

Nota:
Utilice la base de datos que se encuentra en la parte 2 de este documento, para el desarrollo de la
prueba.
Parte 1.

Desarrolle un servicio web Rest, siguiendo el orden de acciones, que permita realizar las siguientes
acciones.

1. Acción POST:
El webservice debera de dar de alta una calificación para el alumno en la tabla de t_calificaciones.
Si el alta es exitosa el servicio web deberá responder en formato json:
{"success":"ok", "msg":"calificacion registrada"}

2. Acción GET:
El webservice deberá de recibir la variable de id del alumno y deberá devolver el listado de las
calificaciones en formato json, adicional tendrá que enviar el promedio de las calificaciones del alumno.

Ejemplo de la respuesta que tendrá que devolver el webservice.
[{id_t_usuario:1,nombre:”John”,”apellido”:”Dow”,”materia”,”programacion
I”,”calificacion”:10,”fecha_registro”:”10/10/2017”},
{id_t_usuario:1,nombre:”John”,”apellido”:”Dow”,”materia”,”ingenieria de
software”,”calificacion”:8.5,”fecha_registro”:”10/10/2017”},{“promedio”:9.25}] *La fecha
deberá devolverla en el formato dd/mm/yyyy

3. Acción PUT:
Actualizar una calificación de la tabla de t_calificaciones Si el alta es exitosa el servicio web deberá
responder en formato json:
{"success":"ok", "msg":"calificacion actualizada”}

4. Acción DELETE:
Realizar un webservice DELETE eliminar físicamente el registro de una calificación. Si el registro se
elimina con éxito el webservice deberá devolver la siguiente respuesta.
{"success":"ok", "msg":"calificacion eliminada”}

5. Validación y presentación:
Los datos se deben validar al ingresar o actualizar.
Implemente un método de seguridad para la implementación del servicio.

6. Datos técnicos.
El desarrollo debe estar en java 11
Debe usar zkoss – framework para la interfaz del usuario.
La base de datos a utilizar debe ser PostgreSQL.
Use JasperReports para alguno de los reportes.
Utilice un servidor para subir su trabajo.

Parte 2.

create database escuela;
create table t_alumnos (
id_t_usuarios int not null auto_increment,
nombre varchar (80),
ap_paterno varchar(80),
ap_materno varchar(80),
activo int (1),
primary key (id_t_usuarios)
) ENGINE=INNODB;
insert into t_alumnos values (default,"John","Dow","Down",1);
create table t_materias (
id_t_materias int not null auto_increment,
nombre varchar(80),
activo int (1),
primary key (id_t_materias)
) ENGINE=INNODB;
insert into t_materias values (default,'matematicas',1); insert
into t_materias values (default,'programacion I',1); insert into
t_materias values (default,'ingenieria de sofware',1);

create table t_calificaciones (
id_t_calificaciones int not null auto_increment,
id_t_materias int not null,
id_t_usuarios int not null,
calificacion decimal (10,2),
fecha_registro date,
primary key (id_t_calificaciones),
foreign key (id_t_materias) references t_materias (id_t_materias),
foreign key (id_t_materias) references t_materias (id_t_materias) )
ENGINE=INNODB;


> Evaluación JAVA tutum.com.mx
