# paradigmas-clase-7
## Dependencies
### Install maven
Herramienta necesaria para descargar las dependencias

Comprobar, primero, si está instalado maven
```bash
mvn -version
```
La respuesta debería ser algo así:
```bash
Apache Maven 3.6.3
Maven home: /usr/share/maven
Java version: 11.0.7, vendor: Oracle Corporation, runtime: /home/alvaro/.sdkman/candidates/java/11.0.7-open
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "5.4.0-81-generic", arch: "amd64", family: "unix"
```
Si no lo es, instalamos maven
```bash
sudo apt update
sudo apt install maven
```
### Install lombok 
Librería necesaria para correr los ejericios del repo
```bash
mvn org.apache.maven.plugins:maven-dependency-plugin:2.1:get \
    -Dartifact=org.projectlombok:lombok:1.18.20 \
    -DrepoUrl=https://search.maven.org/
```
### Install lombok plugin for intelliJ
Supuestamente con la versión >= 2020.3 no hace falta, pero de llegar a necesitarlo -> https://projectlombok.org/setup/intellij
