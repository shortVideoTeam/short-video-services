FROM williamyeh/java8
VOLUME /tmptest
ADD huomai-app.jar /jar/app.jar
EXPOSE 8081
EXPOSE 18081
RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
&& echo 'Asia/Shanghai' >/etc/timezone
ENV LC_ALL=zh_CN.utf8
ENV LANG=zh_CN.utf8
ENV LANGUAGE=zh_CN.utf8
RUN localedef -c -f UTF-8 -i zh_CN zh_CN.utf8
ENV PARAMS=""
ENV PACKAGE=""
#ENTRYPOINT [ "java $PARAMS", "-jar", "/jar/app.jar" ]
ENTRYPOINT ["sh","-c","java $PARAMS $PACKAGE -jar /jar/app.jar"]
#ENTRYPOINT ["sh","-c","java $PARAMS $PACKAGE -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=18081 /jar/app.jar"]
