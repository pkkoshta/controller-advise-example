FROM openjdk:8
EXPOSE 8080
ADD target/jenkins-demo.jar jenkins-demo.jar
ENTRYPOINT ["java","-jar","/jenkins-demo.jar"]