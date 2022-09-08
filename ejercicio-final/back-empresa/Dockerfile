FROM openjdk:17
EXPOSE 8090
COPY /target/*.jar /usr/local/lib/spring.jar 
ENTRYPOINT ["java","-jar","/usr/local/lib/spring.jar"]