-- Aquí añadir inserts para poblar la base de datos
-- Este script es cargado automáticamente al iniciar la aplicación
INSERT INTO blogspring.user (id, username, password, profile_picture) VALUES (1, 'admin', '123', 'https://avatars.dicebear.com/api/initials/admin.svg');

INSERT INTO blogspring.post (id, title, body, post_date, cover_picture, author_id) VALUES (1, 'Crear CRUD con Spring Boot desde cero', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi tincidunt lorem eu interdum sollicitudin. In convallis tellus ac odio ultricies fringilla in at magna. Suspendisse potenti. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer a lacinia dui. Fusce sed aliquet dolor. Nullam sit amet scelerisque purus. Mauris tincidunt tortor condimentum, faucibus ligula vitae, semper lorem. Suspendisse condimentum, tellus nec sodales elementum, neque enim sollicitudin justo, convallis semper urna justo ut velit. Suspendisse eleifend id arcu et efficitur. Nam vulputate felis nec pellentesque malesuada. Aliquam nec hendrerit diam. Pellentesque eget mattis sem. Sed fermentum lectus et libero finibus congue at eu orci. Integer elit purus, fermentum quis ligula vitae, pellentesque accumsan elit. Nulla facilisi.', '2021-12-13', 'https://spring.io/images/projects/spring-boot-7f2e24fb962501672cc91ccd285ed2ba.svg', 1);


-- Local Database related scripts (descomentar si los necesitas)
-- CREATE DATABASE IF NOT EXISTS blogspring;
-- DROP DATABASE  IF EXISTS blogspring;


-- Nota:
-- Pasó algo interesante en este script y es que al comentar de manera automática con el char '#' en la cabecera el 2do comando sql
-- fallaba con el error de: Cannot add or update a child row: a foreign key constraint fails (`blogspring`.`post`, CONSTRAINT `FK12...` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`))
-- la base de datos que hosteamos es mysql aunque el driver que utilicemos sea mariadb hay que tener cuidado con los comentarios de sintaxis mariadb ya que al parecer no son soportados por mysql