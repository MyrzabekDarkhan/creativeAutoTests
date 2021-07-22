FROM markhobson/maven-chrome:jdk-8
MAINTAINER Myrzabek Darkhan <mid@crtweb.ru>


ENV LANG C.UTF-8
ENV LC_ALL C.UTF-8

COPY ./ /tests
COPY pom.xml /tests
WORKDIR /tests

CMD ["mvn","clean","test"]
#CMD ["allure","serve", "target/allure-result"]