[![CircleCI](https://circleci.com/gh/smaddala/brewery.svg?style=svg)](https://circleci.com/gh/smaddala/brewery)

# Beer Service

#### Steps

##### Clone source code from git
```
$  git clone https://github.com/smaddala/brewery.git .
```
##### Build Docker image
```
$ docker build -t brewery .
```
This will first run maven build to create jar package and then build brewery image using built jar package.

##### Run Docker Container
```
$ docker run -p 8080:8080 -it --rm brewery
```

##### Test application

```
$ curl localhost:8080/api/v1/beer
```

the response should be:
```
{
   
    "beerName": "my beer",
    "beerStyle": "LAGER",
    "upc": 89797,
    "price": 10.00,
    "quantityOnHand": null,
    "createdDate": null,
    "lastModifiedDate": null,
    "version": null
}
```

## Run with docker-compose 

Build and start the container by running 

```
$ docker-compose up -d 
```

##### Test application with command

```
$ curl localhost:8080/api/v1/beer
```

the respone should be:
```
{
   
    "beerName": "my beer",
    "beerStyle": "LAGER",
    "upc": 89797,
    "price": 10.00,
    "quantityOnHand": null,
    "createdDate": null,
    "lastModifiedDate": null,
    "version": null
}
```

##### Stop Docker Container:
```
docker-compose down
```
