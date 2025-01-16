# Aplicación Spring Boot para API REST de Productos

Este código implementa una aplicación Spring Boot que expone una API RESTful para gestionar productos.

## Entidad Producto (Product.java)

La clase `Product` representa la entidad Producto del dominio del problema. Se mapea a una tabla en la base de datos.

* **`@Entity`:** Indica que esta clase es una entidad JPA.
* **`@Id`:** Marca la propiedad `id` como la clave primaria de la entidad.
* **`@GeneratedValue(strategy = GenerationType.IDENTITY)`:** Indica que el valor del `id` se genera automáticamente por la base de datos utilizando una estrategia de autoincremento.
* **`private long id;`:** Identificador único del producto.
* **`private String name;`:** Nombre del producto.
* **`private double price;`:** Precio del producto.

## Controlador de Productos (ProductController.java)

La clase `ProductController` es un controlador REST que maneja las solicitudes HTTP relacionadas con los productos.

* **`@RestController`:** Indica que esta clase es un controlador REST de Spring.
* **`@RequestMapping("/products")`:** Define la ruta base para todas las solicitudes manejadas por este controlador. En este caso, todas las solicitudes relacionadas con productos estarán prefijadas con "/products".
* **`@Autowired private IProductRepository productRepository;`:** Inyección de dependencia del repositorio de productos.

### Métodos del Controlador

* **`@GetMapping`:** Asigna este método para manejar solicitudes GET a la ruta "/products".
    * `public List<Product> getAllProducts()`: Recupera todos los productos de la base de datos utilizando el repositorio y los devuelve en una lista.
* **`@GetMapping("/{id}")`:** Asigna este método para manejar solicitudes GET a la ruta "/products/{id}".
    * `public Product getProductById(@PathVariable Long id)`: Recupera un producto por su identificador. Si no se encuentra el producto, se lanza una excepción.
* **`@PostMapping`:** Asigna este método para manejar solicitudes POST a la ruta "/products".
    * `public Product createProduct(@RequestBody Product product)`: Crea un nuevo producto utilizando la información del cuerpo de la solicitud y lo guarda en la base de datos utilizando el repositorio.
* **`@PutMapping("/{id}")`:** Asigna este método para manejar solicitudes PUT a la ruta "/products/{id}".
    * `public Product updateProduct(@PathVariable Long id, @RequestBody Product product)`: Actualiza un producto existente. Primero se recupera el producto por su identificador, luego se actualizan sus propiedades con los valores del cuerpo de la solicitud y finalmente se guarda en la base de datos utilizando el repositorio.
* **`@DeleteMapping("/{id}")`:** Asigna este método para manejar solicitudes DELETE a la ruta "/products/{id}".
    * `public String deleteProduct(@PathVariable Long id)`: Elimina un producto por su identificador. Si no se encuentra el producto, se lanza una excepción.

## Aplicación Principal (ApirestApplication.java)

La clase `ApirestApplication` es el punto de entrada de la aplicación Spring Boot.

* **`@SpringBootApplication`:** Anotación que habilita funcionalidades de Spring Boot de forma automática.
* **`public static void main(String[] args) { SpringApplication.run(ApirestApplication.class, args); }`:** Método principal que inicia la aplicación Spring Boot.

## Configuración de PostgreSQL en Docker (docker-compose.yml)
Este archivo de configuración de Docker se utiliza para crear una imagen de Docker que contenga una instancia de PostgreSQL. Esta imagen está diseñada específicamente para servir como base de datos para la API.

## Tecnologías Utilizadas
* **Spring Boot:** Framework Java para desarrollo de aplicaciones web de manera rápida y sencilla.
* **Spring MVC:** Módulo de Spring para crear aplicaciones web MVC.
* **JPA (Java Persistence API):** API para la persistencia de objetos Java en bases de datos relacionales.
* **Hibernate:** Implementación de referencia de JPA.
* **JSON:** Formato de intercambio de datos utilizado para transmitir información entre el cliente y el servidor.
* **HTTP:** Protocolo de comunicación utilizado para transferir datos a través de una red.
* **Docker:** Plataforma de contenedores para empaquetar aplicaciones y sus dependencias.
* **PostgreSQL:** Sistema de gestión de bases de datos relacionales de código abierto.

## Ejecutar la aplicación

1. Asegúrate de tener Maven instalado.
2. Abre un terminal en la ubicación del proyecto.
3. Ejecuta el comando `mvn clean install` para compilar el proyecto.
4. Ejecuta el comando `mvn spring-boot:run` para iniciar la aplicación.

## Resumen

Este código implementa una API REST básica para gestionar productos utilizando Spring Boot y JPA. El controlador proporciona métodos para consultar, crear, actualizar y eliminar productos. La aplicación se inicia mediante la clase `ApirestApplication`.


