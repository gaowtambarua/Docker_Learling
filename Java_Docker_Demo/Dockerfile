# Use official OpenJDK 21 base image
FROM openjdk:21

# Set working directory in the container
WORKDIR /myapp

# Copy Java source code from host to container
COPY  ./src/Main.java .


# Compile Java source to class files (put .class in /myapp directory)
RUN javac /myapp/Main.java -d .

# Run the compiled class
CMD ["java", "Main"]



