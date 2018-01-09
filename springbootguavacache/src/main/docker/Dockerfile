FROM java:8
 
LABEL maintainer="Lucky Pratama"
 
COPY springbootguavacache-0.0.1-SNAPSHOT.jar /app.jar
 
EXPOSE 8090
 
#RUN sh -c 'touch /app.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]