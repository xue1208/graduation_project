FROM java:8

EXPOSE 7001

ADD /usr-application/build/libs/usr-application-1.0-SNAPSHOT.jar /user.jar

ENTRYPOINT ["java","-jar","/user.jar","--spring.profiles.active=prod"]
