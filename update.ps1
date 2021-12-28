docker stop $(docker ps -q)
docker rm $(docker ps -a -q)
mvn clean
mvn package
mkdir .\target\dependency
cd target\dependency
jar xf ..\*.jar
cd ..\..\
docker build -t ci_system_webserver .
docker run -d -p 8080:8080 ci_system_webserver