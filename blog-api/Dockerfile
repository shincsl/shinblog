FROM java:8
VOLUME /tmp
ADD blog-api-1.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=prod"]
EXPOSE 9000