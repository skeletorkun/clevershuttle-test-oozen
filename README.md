# Clevershuttle Car API

### Project name : clevershuttle-test-oozen

Demo of a small REST api to GET and POST a new car. 

### to run

Using Maven as the build tool.

Run the following in the project terminal path:

```
mvn spring-boot:run
```

### Examples 

Creating a new car
```
curl --location --request POST 'http://localhost:8080/api/car' \
--header 'Content-Type: application/json' \
--data-raw '{
  "brand": "A4",
  "licensePlate": "L-ZZZZZZZ",
  "manufacturer": "Audi",
  "operationCity": 4,
  "status": "AVAILABLE"
}'
```

Retrieving a car by id
```
curl --location --request GET 'http://localhost:8080/api/car/1'
```
