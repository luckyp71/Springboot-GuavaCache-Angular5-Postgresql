FROM java:8
 
MAINTAINER Lucky Pratama
 
ADD springbootguavacache-0.0.1-SNAPSHOT.jar /app.jar
 
EXPOSE 8090
 
#RUN sh -c 'touch /app.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]