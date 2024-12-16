# Folosim o imagine oficială cu JDK 17
FROM openjdk:17-jdk-slim

# Setăm directorul de lucru
WORKDIR /app

# Copiem fișierul Java în container
COPY Main.java .

# Compilăm fișierul Java
RUN javac Main.java

# Specificăm comanda de rulare
CMD ["java", "Main"]

