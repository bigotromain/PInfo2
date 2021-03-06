[![Build Status](https://travis-ci.org/unige-pinfo-2019/PInfo2.svg?branch=master)](https://travis-ci.org/unige-pinfo-2019/PInfo2) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=unige-pinfo-2019_PInfo2&metric=coverage)](https://sonarcloud.io/dashboard?id=unige-pinfo-2019_PInfo2) [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=unige-pinfo-2019_PInfo2&metric=alert_status)](https://sonarcloud.io/dashboard?id=unige-pinfo-2019_PInfo2)

# Agility team

"Entrepreneurial Philanthropy is not just a philosophy or a dream. It is a promise that philanthropy is at its best when it is founded on entrepreneurial zest and agility."

## Members

 - Marvin Fourastié (Project leader)
 - Corentin Bugnot  (System administrator)
 - Heloy Estevanin
 - Romain Bigot
 - Adrien Razurel
 - Raphaël Lutz
 
 ## Instructions
 To run the microservices using Docker execute:
 
```
mvn clean install
mvn install -Ppackage-docker-image
cd docker-compose/
docker-compose -f docker-compose-microservices.yml up
```

To avoid docker images compilation time, each microservice can be run independently 

```
mvn clean install -T 4
java -jar {serviceFolder}/target/{serviceName}-service-0.2.0-SNAPSHOT-thorntail.jar
```

If you have added or deleted a file put the `clean` keywoard after mvn otherwise simply run `mvn install -T 4`

List of services ports:

User service: `13080`
Category service: `12080`
Search service: `11080`
Ad service: `15080`
Image service: `14080`
