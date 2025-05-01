FROM openjdk:21

WORKDIR /myapp

COPY ./src/Main.java .
COPY servers.txt .

RUN javac /myapp/Main.java -d .

CMD ["java", "Main"]