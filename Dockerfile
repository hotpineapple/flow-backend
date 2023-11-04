FROM openjdk:11-jre-slim

WORKDIR /app

ARG port
ARG db_driver
ARG db_uri
ARG db_username
ARG db_password
ARG show_sql
ARG ddl_auto
ARG format_sql

ENV port=${port} \
    db_driver=${db_driver} \
    db_uri=${db_uri} \
    db_username=${db_username} \
    db_password=${db_password} \
    show_sql=${show_sql} \
    ddl_auto=${ddl_auto} \
    format_sql=${format_sql}\
    cors_allowed=${cors_allowed}

COPY build/libs/*.jar app.jar

CMD ["java", "-jar", "app.jar"]