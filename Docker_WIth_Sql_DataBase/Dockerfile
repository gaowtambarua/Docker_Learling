# ধাপ 1: Java 21 ইমেজ থেকে শুরু করছি
FROM openjdk:21

# ধাপ 2: কন্টেইনারে কাজের জন্য একটি ফোল্ডার বানাচ্ছি
WORKDIR /app


# ধাপ 3: তোমার Java কোড এবং MySQL ড্রাইভার কপি করছি
COPY src/ src/
COPY libs/ libs/


# ধাপ 4: .class ফাইল রাখার জন্য build ফোল্ডার তৈরি করা
RUN mkdir -p build

# ধাপ 4: Java কোড কম্পাইল করছি (JDBC ড্রাইভার সহ)
RUN javac -cp libs/mysql-connector-j-9.3.0.jar src/Main.java -d build
#javac: Java কম্পাইলার দিয়ে .java ফাইল কম্পাইল করছি
#-cp: classpath হিসেবে MySQL ড্রাইভার দিচ্ছি
#-d build: কম্পাইল হওয়া .class ফাইল build/ ফোল্ডারে যাবে

CMD ["java", "-cp", "libs/mysql-connector-j-9.3.0.jar:build", "Main"]
#java: Java রানটাইম দিয়ে কোড চালাচ্ছি
#-cp: আবার ক্লাসপাথে MySQL ড্রাইভার এবং কম্পাইল করা ক্লাস ফাইল দিচ্ছি
#"Main": মানে Main.class ফাইল রান করবো



