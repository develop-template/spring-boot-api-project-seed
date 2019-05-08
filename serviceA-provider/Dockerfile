FROM openjdk:8-jre-alpine
MAINTAINER ouzhx <javastar920905@163.com>

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ADD target/classes/client.xml /data/appdatas/cat/client.xml
ADD target/classes/client.xml /data/applogs/cat/client.xml
ADD target/classes/client.xml  /data/appdatas/cat/client.xml
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/article/myservice.jar
# ENTRYPOINT 指令不要换行
ENTRYPOINT ["/usr/bin/java", "-jar","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5121", "/usr/share/article/myservice.jar","-Dspring.profiles.active=dev"]