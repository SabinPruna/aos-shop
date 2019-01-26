FROM openjdk:8-jre

RUN mkdir /app

WORKDIR /app

ADD ./api/target/orders-api.jar /app
ADD ./config.yml /app

EXPOSE 9000 9001

CMD ["java", "-jar", "orders-api.jar", "server", "config.yml"]