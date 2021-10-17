FROM openjdk:17
COPY . .
ENTRYPOINT ["java","-jar","build/libs/ExchangerGif-0.1.0-plain.jar"]