# BlogSpring
BlogSpring es un repositorio que se utiliza para la redacción de un manual con enfoque a la construcción de una aplicación básica de CRUD, se basa en el funcionamiento de un blog personal.

### Requerimientos:  
 - Maven 3.2+
 - OpenJDK/JDK 17 o superior
 - Servidor local o remoto de MariaDB/MySQL

### Instalación:
Antes de instalar:  
 1. Debes tener creada la base de datos `blogspring`, no es necesario crear el schema previamente dado que se utiliza DDL automático

 2. Tener disponible y en ejecución servicio MariaDB/MySQL, puedes modificar las configuraciones de la aplicación y 
 ajustarla a tu entorno o usuario en el archivo 
 [application.properties](https://github.com/Esteb4nx/BlogSpring/blob/main/src/main/resources/application.properties)
 
Asegurados los pasos 1 y 2 de la etapa anterior:

 - En la carpeta raíz del repositorio ejecutar: `mvn clean package`
   - Esto ejecutará las pruebas unitarias y creará el archivo `BlogPersonal-0.0.1-SNAPSHOT.jar` que será nuestra app 

 - Luego ejecutar `.jar` con: `java -jar target/BlogPersonal-0.0.1-SNAPSHOT.jar`
 
Si todo resultó correcto la aplicación BlogSpring se encuentra disponible en [localhost:8080](http://localhost:8080)

---
Creado por:
[Esteb4nx](https://github.com/Esteb4nx/) y [jmainhard](https://github.com/jmainhard) como apoyo en la creación de material didáctico
