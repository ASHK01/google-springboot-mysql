# google-springboot-mysql

spring boot google app engine with mysql deployable



To deploy on GAE
mvn -P gcp -DskipTests appengine:deploy

To run in local
mvn -P dev -DskipTests spring-boot:run
