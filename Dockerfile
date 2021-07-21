FROM markhobson/maven-chrome:jdk-8

COPY ./ /tests
COPY pom.xml /tests
WORKDIR /tests
CMD mvn clean test