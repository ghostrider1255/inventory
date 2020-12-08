FROM openjdk:8
MAINTAINER raju
ENV FILEBEAT_VERSION=7.10.0

ARG HOST_APP_JAR_LOC
ARG APP_HOME_DIR=/opt/app
ARG APP_CONFIG_DIR=/opt/config

RUN apt-get update && \
    apt-get install -y curl wget && \
    #wget https://download.elastic.co/beats/filebeat/filebeat-${FILEBEAT_VERSION}-x86_64.tar.gz -O /opt/filebeat.tar.gz && \
    wget https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-${FILEBEAT_VERSION}-linux-x86_64.tar.gz -O /opt/filebeat.tar.gz && \
    cd /opt && \
    tar xzvf filebeat.tar.gz && \
    cd filebeat-* && \
    cp filebeat /bin && \
    cd /opt && \
    rm -rf filebeat* && \
    apt-get purge -y wget && \
    apt-get autoremove -y && \
    apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

RUN mkdir -p $APP_HOME_DIR \
    mkdir -p $APP_CONFIG_DIR \
    #ls -lrt /opt/app \
    echo $HOST_APP_JAR_LOC

VOLUME $APP_CONFIG_DIR

COPY *.jar $APP_HOME_DIR/
COPY filebeat.yml $APP_CONFIG_DIR/
COPY log4j2.xml $APP_CONFIG_DIR/

RUN mv ${APP_HOME_DIR}/*.jar ${APP_HOME_DIR}/application.jar
RUN chmod 755 ${APP_HOME_DIR}/application.jar

ENV APP_CONFIG_DIR $APP_CONFIG_DIR

#ENTRYPOINT ["java","-jar","/opt/app/application.jar","--spring.config.location=file:${APP_CONFIG_DIR}/application.properties"]
ENTRYPOINT ["java","-jar","/opt/app/application.jar","--spring.config.location=file:${APP_CONFIG_DIR}/"]
CMD ["filebeat", "-e", "-c","${APP_CONFIG_DIR}/filebeat.yml"]
#CMD ["filebeat", "-e"]