# SearchShowService
Search Movies by Location, Date and Movie.

The documents are returned. 

Filtering could be done and Graphql end or Front End. Service can also filter by projection (but will do it as feature upgrade)

## Run service locally
```
docker compose build
```
```
docker compose -f docker-compose.yml up -d
```
### Important Note
The docker images chosen are fir to run in MAC M1 with arm64 architecture. It may not run in other env. This is limitation of docker images in MAC M1 and M2.
In that scenario alternatively Elastic search and Kibana can be installed locally and service can be run locally

## Postman collection
postman collection in the below folder loc
```
postman_collection
```
The collection can be imported in Postman to execute tests
