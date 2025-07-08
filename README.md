#  Movie Watchlist Backend Application

A Spring Boot-based Java backend project to manage a movie watchlist using data from OMDb and TMDB APIs.

##  Features

Search and add movies by title (from OMDb and TMDB)
Store movie metadata and images locally
Update `watched` status and rating (1–5)
View all saved movies with pagination
Delete movies from the watchlist
Multi-threaded API calls for performance
JSON response structure
RESTful API

## Technologies Used
- Java 
- Spring Boot 
- Spring Data JPA
- H2 In-Memory Database
- REST APIs (OMDb, TMDB)
- `RestTemplate` and `CompletableFuture`
- JSON Parsing (`org.json`)
- File I/O for image downloads

Method	Endpoint	                        Description
POST	/movies?title=Inception	            Add a movie to the watchlist
GET	    /movies?page=0&size=5	            Get all movies (paginated)
PATCH	/movies/{id}/watched?watched=true	Update watched status
PATCH	/movies/{id}/rating?rating=5	    Update movie rating
DELETE	/movies/{id}	                    Delete movie from the watchlist

Examples:
# Add a movie
curl -X POST "http://localhost:8080/movies?title=Inception"

# List movies
curl "http://localhost:8080/movies?page=0&size=5"

# Update watched
curl -X PATCH "http://localhost:8080/movies/1/watched?watched=true"

# Update rating
curl -X PATCH "http://localhost:8080/movies/1/rating?rating=5"

# Delete movie
curl -X DELETE "http://localhost:8080/movies/1"


image.storage.path=./images
