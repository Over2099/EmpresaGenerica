¿Cuál es la función de Spring Data JPA? 
Simplificar la implementación de la capa de acceso a datos reduciendo el código repetitivo (boilerplate) mediante interfaces y métodos genéricos.

¿Qué función cumple Hibernate? 
Es el proveedor de JPA por defecto; se encarga de realizar el mapeo objeto-relacional (ORM) traduciendo objetos Java a consultas SQL en la base de datos.

¿Qué diferencia existe entre JPA y Hibernate? 
JPA es una especificación (un estándar de Java EE/Jakarta EE que define cómo debe funcionar el ORM), mientras que Hibernate es la implementación concreta que ejecuta dicho estándar.

¿Qué función cumple @Entity? 
Indica que una clase Java está mapeada a una tabla de la base de datos relacional.

¿Qué función cumple @ManyToOne? 
Define una relación de muchos a uno entre entidades.

¿Qué función cumple @JoinColumn? 
Especifica la columna de FK que se utilizará para asociar la relación entre tablas.

¿Qué función cumple JpaRepository? 
Una interfaz de Spring Data JPA que provee métodos listos para usar de operaciones CRUD (save, findAll, findById, delete, etc.).

¿Por qué se utilizan migraciones? 
Para llevar un control versionado, ordenado y automatizado de los cambios en el esquema de la base de datos a lo largo del desarrollo del software.

¿Qué diferencia existe entre V1, V2 y V3? 
Representan el orden secuencial de ejecución de los scripts de Flyway: V1 crea la estructura inicial, V2 modifica y agrega columnas, y V3 introduce nuevas tablas y relaciones del reto.

¿Qué problema puede producir una relación bidireccional al generar JSON?
Provoca un bucle infinito de serialización recursiva como Producto llama a Categoría, Categoría llama a sus Productos, Producto vuelve a llamar a Categoría, resultando en un error de desbordamiento de pila o JSON gigante.