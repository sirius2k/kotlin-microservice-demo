## Synopsis
This project is kotlin micro service template project which is developed on top of the SprintBoot 2.x..

## Installation

### Run Mongodb
Before you start the demo application, you will need to run mongodb with docker.

```bash
$ cd /go/to/project
$ docker-compose -f mongo-stack.yml up -d
```

In order to access mongo db with specific user described in application.yml you should create user in the MongoDB. You will need to install mongo client.

```bash
$ mongo 127.0.0.1:27700/admin -u root -p 'example'
> db.createUser({  
   user:"msa",
   pwd:"examples",
   roles:[  
    {  
       role:"dbOwner",
       db:"microservices"
    }
   ],
   mechanisms:[  
    "SCRAM-SHA-1"
   ]
  })
``` 

### Run microservice
You can run the demo service with the following command. 

```bash
$ cd /go/to/project
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