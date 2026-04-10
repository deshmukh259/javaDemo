# ---------- Build stage ----------
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /bsisc-curd-map

# Copy pom first for better caching
COPY pom.xml .
RUN mvn -B -e -q dependency:go-offline

# Copy source and build
COPY src ./src
RUN mvn -B clean package -DskipTests


# ---------- Runtime stage ----------
FROM eclipse-temurin:21-jre

WORKDIR /bsisc-curd-map

# Copy jar from build stage
COPY --from=build /bsisc-curd-map/target/*.jar app.jar

# Expose Spring Boot port
EXPOSE 8080

# Run Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
