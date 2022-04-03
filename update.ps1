docker-compose down
mvn clean
mvn package
mkdir .\target\dependency
cd target\dependency
jar xf ..\*.jar
cd ..\..\
docker-compose up