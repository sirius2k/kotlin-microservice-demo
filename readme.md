## Synopsis
This project is kotlin micro service template project which is developed on top of the SprintBoot 2.x..

## Installation
You can run this demo with the following command. 

```bash
$ cd /go/to/project
$ docker-compose -f mongo-stack.yml up -d
$ mvn spring-boot:run
```

### Hello Page
You can request hello page with url http://localhost:8080/hello

### Connect to MongoDB container
```bash
$ docker exec it mongo bash
```

### Mongo express
You can connect to the Mongo express with url http://localhpst:8081

# IDE Support
This project is developed with IntelliJ.

## Contributors
Park, KyoungWook (Kevin) / sirius00@paran.com

## License
This project is licensed under the MIT License