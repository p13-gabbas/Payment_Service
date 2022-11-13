# Payment_Service
#Outputs are as required but code might not be as required because I had few questions regarding the DB schema. So Implemented according to my #undestanding.
#code can be further optimised
#below endpoints has been exposed.

POST -> http://localhost/api/v1.0/congiguration/payment-methods

POST -> http://localhost/api/v1.0/congiguration/payment-plans

GET -> http://localhost/api/v1.0/congiguration/all/payment-methods

GET -> http://localhost:9090/api/v1.0/congiguration/payment-methods?id=&name=

#PUT is missing because I was unclear update payment method or payment plan because both are different entities

#run the below command to create a mariadb docker container

docker run -p 127.0.0.1:3031:3306 -detach --name starz-play --env MARIABDB_USER=root --env MARIADB_PASSWORD=admin --env MARIADB_ROOT_PASSWORD=admin mariadb:latest

#run the below in terminal and connect mariadb and create star_playz database

docker exec -it starz-play mariadb --user root -padmin

create database star_playz;

#add the below env variables

STAR_PLAYZ_DB_URL=jdbc:mysql://127.0.0.1:3031/star_playz;STAR_PLAYZ_DB_USR=root;STAR_PLAYZ_DB_PASS=admin


