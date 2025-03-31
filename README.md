# 🌍 API REST - Aprende Idiomas

Bienvenido a la API REST del proyecto **"Aprende Idiomas"**, una aplicación pensada para explorar el mundo a través del aprendizaje de idiomas. Esta API permite gestionar cursos de diferentes niveles e idiomas, ubicados en ciudades icónicas de todo el planeta.

---

## 🚀 Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database (modo desarrollo)
- Maven
- IntelliJ IDEA

---

## 📚 Endpoints de la API

| Método | Ruta                    | Cuerpo (JSON)                                  | Descripción                                  | Respuestas posibles            |
|--------|-------------------------|------------------------------------------------|----------------------------------------------|-------------------------------|
| GET    | `/api/cursos`           | N/A                                            | Obtener todos los cursos                     | `200 OK`                      |
| GET    | `/api/cursos/{id}`      | N/A                                            | Obtener un curso por su ID                   | `200 OK`, `404 Not Found`     |
| POST   | `/api/cursos`           | Objeto JSON con datos del curso                | Crear un nuevo curso                         | `201 Created`                 |
| POST   | `/api/cursos/bulk`      | Lista JSON con varios cursos                  | Crear varios cursos a la vez (bulk insert)   | `201 Created`                 |
| PUT    | `/api/cursos/{id}`      | Objeto JSON actualizado del curso             | Actualizar un curso existente                | `200 OK`, `404 Not Found`     |
| DELETE | `/api/cursos/{id}`      | N/A                                            | Eliminar un curso                            | `204 No Content`, `404 Not Found` |

---

## 🧠 Funcionalidades implementadas

La API cuenta con un conjunto de funciones organizadas por capas siguiendo el modelo MVC (Modelo, Vista, Controlador).

---

### 📂 `CursoController.java`

| Método                      | Descripción                                      |
|----------------------------|--------------------------------------------------|
| `getAll()`                 | Obtener todos los cursos                        |
| `getById(Long id)`        | Obtener un curso específico por su ID           |
| `create(CursoDeIdioma c)` | Crear un curso nuevo                            |
| `createBulk(List<CursoDeIdioma>)` | Crear múltiples cursos a la vez (bulk insert) |
| `update(Long id, CursoDeIdioma c)` | Actualizar un curso existente                |
| `delete(Long id)`         | Eliminar un curso por ID                        |

---

### 🧰 `CursoService.java`

| Método                           | Descripción                                       |
|----------------------------------|---------------------------------------------------|
| `getAll()`                      | Devuelve la lista de todos los cursos             |
| `getById(Long id)`             | Devuelve un curso por su ID                       |
| `create(CursoDeIdioma curso)`  | Guarda un curso nuevo                             |
| `createAll(List<CursoDeIdioma>)` | Guarda varios cursos (bulk)                       |
| `update(Long id, CursoDeIdioma)` | Actualiza los datos de un curso existente         |
| `delete(Long id)`              | Elimina un curso por ID                           |

---

### 💾 `CursoRepository.java` (Spring Data JPA)

| Método                            | Descripción                                   |
|-----------------------------------|-----------------------------------------------|
| `findAll()`                      | Devuelve todos los cursos                     |
| `findById(Long id)`             | Busca un curso por ID                         |
| `save(CursoDeIdioma curso)`     | Guarda o actualiza un curso                   |
| `saveAll(List<CursoDeIdioma>)`  | Guarda varios cursos a la vez                 |
| `deleteById(Long id)`           | Elimina un curso por ID                       |
| `findByIdiomaIgnoreCase(String)` (opcional) | Buscar cursos por idioma             |
| `findByNivelIgnoreCase(String)` (opcional)  | Buscar cursos por nivel              |
| `findByDescripcionContainingIgnoreCase(String)` (opcional) | Buscar por palabra clave en descripción |

---

> ✅ Con esto se demuestra el uso completo de las operaciones **CRUD**, el uso de Spring Boot con JPA, y la correcta separación de capas.

## 🧪 Datos de ejemplo

Puedes usar estos datos en Postman (POST) :

```json
[
  {
    "nombre": "Francés en París",
    "idioma": "Francés",
    "nivel": "A2",
    "descripcion": "Curso intensivo de francés en la ciudad del amor",
    "imagenUrl": "https://images.unsplash.com/photo-1543342386-2e4e1c58c38b"
  },
  {
    "nombre": "Inglés en Londres",
    "idioma": "Inglés",
    "nivel": "B2",
    "descripcion": "Aprende inglés británico con acento nativo en la capital del Reino Unido",
    "imagenUrl": "https://images.unsplash.com/photo-1505761671935-60b3a7427bad"
  },
  {
    "nombre": "Italiano en Roma",
    "idioma": "Italiano",
    "nivel": "A1",
    "descripcion": "Descubre la historia romana hablando italiano",
    "imagenUrl": "https://images.unsplash.com/photo-1549893074-40cd3d25dbe5"
  },
  {
    "nombre": "Japonés en Tokio",
    "idioma": "Japonés",
    "nivel": "B1",
    "descripcion": "Sumérgete en la cultura japonesa aprendiendo su idioma en Tokio",
    "imagenUrl": "https://images.unsplash.com/photo-1549692520-acc6669e2f0c"
  },
  {
    "nombre": "Alemán en Berlín",
    "idioma": "Alemán",
    "nivel": "A2",
    "descripcion": "Conoce Berlín y estudia alemán de forma práctica y divertida",
    "imagenUrl": "https://images.unsplash.com/photo-1579033461380-c780ee03e0e4"
  },
  {
    "nombre": "Portugués en Río de Janeiro",
    "idioma": "Portugués",
    "nivel": "B1",
    "descripcion": "Aprende portugués en la ciudad del carnaval y las playas",
    "imagenUrl": "https://images.unsplash.com/photo-1507398941214-572c25f4b1dc"
  },
  {
    "nombre": "Chino Mandarín en Pekín",
    "idioma": "Chino Mandarín",
    "nivel": "B2",
    "descripcion": "Estudia el idioma más hablado del mundo en su país de origen",
    "imagenUrl": "https://images.unsplash.com/photo-1602034541795-5a3c1e7bfe9b"
  },
  {
    "nombre": "Ruso en Moscú",
    "idioma": "Ruso",
    "nivel": "A1",
    "descripcion": "Descubre el alfabeto cirílico y la lengua rusa desde cero",
    "imagenUrl": "https://images.unsplash.com/photo-1604788491815-97a58dd00056"
  },
  {
    "nombre": "Coreano en Seúl",
    "idioma": "Coreano",
    "nivel": "A2",
    "descripcion": "Aprende coreano mientras disfrutas del K-pop y la cultura asiática",
    "imagenUrl": "https://images.unsplash.com/photo-1600585154340-be6161a56a0c"
  }
]
