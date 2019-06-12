#!/bin/bash

LOCAL_CONF_PATH=./conf
CONT_CONF_PATH=/usr/local/tomcat/conf

CONT_CONT_PATH=/usr/local/tomcat/webapps/manager/META-INF


docker run -it --rm -p 8888:8080 -v $LOCAL_CONF_PATH/tomcat-users.xml:$CONT_CONF_PATH/tomcat-users.xml -v $LOCAL_CONF_PATH/context.xml:$CONT_CONT_PATH/context.xml --name tomcat tomcat:8
