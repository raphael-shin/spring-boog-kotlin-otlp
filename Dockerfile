# Base image
FROM amazoncorretto:17-alpine-jdk

# Working directory
WORKDIR /app

# Copy the jar file to the container
COPY ./build/libs/spring-boog-kotlin-otlp-0.0.1-SNAPSHOT.jar my-o11y-app.jar
COPY ./libs/aws-opentelemetry-agent.jar libs/aws-opentelemetry-agent.jar

# Expose the port number
EXPOSE 8080 8080

ENV OTEL_RESOURCE_ATTRIBUTES aws.log.group.names=/aws/eks/my-eks-cluster/containers/application
ENV OTEL_EXPORTER_OTLP_ENDPOINT http://adot-col-otlp-ingest-collector.opentelemetry-operator-system.svc.cluster.local:4317
ENV OTEL_METRICS_EXPORTER none

# Command to run the application
CMD ["java", "-javaagent:libs/aws-opentelemetry-agent.jar", "-Dspring.profiles.active=dev,console-logging", "-jar", "my-o11y-app.jar"]