FROM java:8
VOLUME /tmp
ADD target/instructorApplication-0.0.1-SNAPSHOT.jar instructorApplication-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","instructorApplication-0.0.1-SNAPSHOT.jar"]