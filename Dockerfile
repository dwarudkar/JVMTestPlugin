FROM adoptopenjdk/openjdk11

COPY ./build/libs/player.jar /opt/

CMD java $(eval echo $JAVA_OPTS) -jar /opt/player.jar

