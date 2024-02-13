# Spring Boot Project Documentation

This documentation provides an overview of the Spring Boot project's main components and functionalities.

## Movie Class

The `Movie` class represents an entity for storing movie information in the application.

### Properties

- **id**: `ObjectId` - The unique identifier for the movie.
- **imdbId**: `String` - The IMDB ID of the movie.
- **title**: `String` - The title of the movie.
- **releaseDate**: `String` - The release date of the movie.
- **trailerLink**: `String` - The link to the trailer of the movie.
- **poster**: `String` - The link to the poster of the movie.
- **backdrops**: `List<String>` - The list of links to the backdrops of the movie.
- **genres**: `List<String>` - The list of genres of the movie.
- **reviews**: `List<Review>` - The list of reviews associated with the movie.

### Constructors

1. **Movie()**: Default constructor.
2. **Movie(String imdbId, String title, String releaseDate, String trailerLink, String poster, List<String> backdrops, List<String> genres)**: Constructor to create a Movie object with specified parameters.

### Annotations

- **@Document**: Indicates that this class is a MongoDB document and specifies the collection name.
- **@Id**: Marks the field as the primary identifier of the document.
- **@Data**: Lombok annotation to automatically generate getters, setters, `toString()`, `equals()`, and `hashCode()` methods.
- **@AllArgsConstructor**: Lombok annotation to generate a constructor with all arguments.
- **@NoArgsConstructor**: Lombok annotation to generate a default constructor.

## MovieController Class

The `MovieController` class is responsible for handling HTTP requests related to movies.

### Endpoints

#### GET /api/v1/movies

- **Method**: `GET`
- **Description**: Retrieves a list of all movies.
- **Response**: Returns a list of `Movie` objects.
- **Status Codes**:
  - `200 OK`: Successful retrieval of movies.

#### GET /api/v1/movies/{imdbId}

- **Method**: `GET`
- **Description**: Retrieves a single movie by its IMDB ID.
- **Parameters**:
  - `{imdbId}`: IMDB ID of the movie to retrieve.
- **Response**: Returns the `Movie` object with the specified IMDB ID.
- **Status Codes**:
  - `200 OK`: Successful retrieval of the movie.
  - `404 Not Found`: If the movie with the specified IMDB ID is not found.

### Dependencies

- **Autowired**: Marks the `MovieService` bean to be automatically wired into the controller.

### Annotations

- **@CrossOrigin(origins = "https://movies-front-end-blush.vercel.app/")**: Allows cross-origin resource sharing (CORS) from the specified origin.
- **@RestController**: Indicates that this class is a REST controller.
- **@RequestMapping("/api/v1/movies")**: Specifies the base URI for mapping requests to this controller.
- **@Autowired**: Autowires the `MovieService` bean into the controller.

## Review Class

The `Review` class represents an entity for storing review information in the application.

### Properties

- **id**: `ObjectId` - The unique identifier for the review.
- **body**: `String` - The content of the review.
- **created**: `LocalDateTime` - The date and time when the review was created.
- **updated**: `LocalDateTime` - The date and time when the review was last updated.

### Constructors

1. **Review()**: Default constructor.
2. **Review(String body, LocalDateTime created, LocalDateTime updated)**: Constructor to create a Review object with specified parameters.

### Annotations

- **@Document**: Indicates that this class is a MongoDB document and specifies the collection name.
- **@Data**: Lombok annotation to automatically generate getters, setters, `toString()`, `equals()`, and `hashCode()` methods.
- **@AllArgsConstructor**: Lombok annotation to generate a constructor with all arguments.
- **@NoArgsConstructor**: Lombok annotation to generate a default constructor.

## ReviewController Class

The `ReviewController` class is responsible for handling HTTP requests related to reviews.

### Endpoints

#### POST /api/v1/reviews

- **Method**: `POST`
- **Description**: Creates a new review for a movie.
- **Request Body**: JSON object with the following keys:
  - `reviewBody`: The content of the review.
  - `imdbId`: The IMDB ID of the movie for which the review is being created.
- **Response**: Returns the created `Review` object.
- **Status Codes**:
  - `200 OK`: Successful creation of the review.

### Dependencies

- **Autowired**: Marks the `ReviewService` bean to be automatically wired into the controller.

### Annotations

- **@CrossOrigin(origins = "https://movies-front-end-blush.vercel.app/")**: Allows cross-origin resource sharing (CORS) from the specified origin.
- **@RestController**: Indicates that this class is a REST controller.
- **@RequestMapping("/api/v1/reviews")**: Specifies the base URI for mapping requests to this controller.
- **@Autowired**: Autowires the `ReviewService` bean into the controller.

## MovieRepository Interface

The `MovieRepository` interface provides methods for accessing and manipulating movie data in the MongoDB database.

### Methods

#### findMovieByImdbId

- **Signature**: `Optional<Movie> findMovieByImdbId(String imdbId)`
- **Description**: Finds a movie by its IMDB ID.
- **Parameters**:
  - `imdbId`: IMDB ID of the movie to find.
- **Returns**: An `Optional` containing the `Movie` object if found, otherwise empty.

### Annotations

- **@Repository**: Indicates that this interface is a Spring Data repository component.

## ReviewRepository Interface

The `ReviewRepository` interface provides methods for accessing and manipulating review data in the MongoDB database.

### Annotations

- **@Repository**: Indicates that this interface is a Spring Data repository component.

## MovieService Class

The `MovieService` class provides methods for interacting with movie data.

### Methods

#### findAllMovies

- **Signature**: `List<Movie> findAllMovies()`
- **Description**: Retrieves a list of all movies.
- **Returns**: A list of `Movie` objects.

#### findMovieByImdbId

- **Signature**: `Optional<Movie> findMovieByImdbId(String imdbId)`
- **Description**: Finds a movie by its IMDB ID.
- **Parameters**:
  - `imdbId`: IMDB ID of the movie to find.
- **Returns**: An `Optional` containing the `Movie` object if found, otherwise empty.

### Dependencies

- **Autowired**: Marks the `MovieRepository` bean to be automatically wired into the service.
- **MongoTemplate**: Provides low-level access to MongoDB operations.

## ReviewService Class

The `ReviewService` class provides methods for interacting with review data.

### Methods

#### createReview

- **Signature**: `Review createReview(String reviewBody, String imdbId)`
- **Description**: Creates a new review for a movie.
- **Parameters**:
  - `reviewBody`: The content of the review.
  - `imdbId`: The IMDB ID of the movie for which the review is being created.
- **Returns**: The created `Review` object.

### Dependencies

- **Autowired**: Marks the `ReviewRepository` and `MongoTemplate` beans to be automatically wired into the service.

## MoviesApplication Class

The `MoviesApplication` class serves as the entry point for the Spring Boot application.

### Dependencies

- **SpringApplication**: A helper class to bootstrap the Spring application context.
- **SecurityAutoConfiguration**: Spring Boot's auto-configuration for security.

### Annotations

- **@SpringBootApplication**: Indicates that this class is a Spring Boot application.
- **@RestController**: Indicates that this class is a Spring MVC controller.

---

This document provides comprehensive documentation for the Spring Boot project, including entities, controllers, repositories, services, and the main application class.
