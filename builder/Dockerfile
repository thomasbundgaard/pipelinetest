FROM tomcat
COPY index.war /usr/local/tomcat/webapps/
RUN chgrp -R 0 /usr/local/tomcat/webapps/ && \
	chmod -R g=u /usr/local/tomcat/webapps/
RUN chmod 777 /usr/local/tomcat/webapps/index.war	
CMD ["catalina.sh", "run"]
