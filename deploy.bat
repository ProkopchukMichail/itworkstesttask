call mvn install
cd %CATALINA_HOME%\webapps
DEL %CATALINA_HOME%\webapps\itworkstesttask-rest-1.0-SNAPSHOT.war
rd %CATALINA_HOME%\webapps\itworkstesttask-rest-1.0-SNAPSHOT /s /q
DEL %CATALINA_HOME%\webapps\itworkstesttask-web-1.0-SNAPSHOT.war
rd %CATALINA_HOME%\webapps\itworkstesttask-web-1.0-SNAPSHOT /s /q
move %CD%\\itworkstesttask-rest\target\itworkstesttask-rest-1.0-SNAPSHOT.war %CATALINA_HOME%\webapps
move %CD%\\itworkstesttask-web\target\itworkstesttask-web-1.0-SNAPSHOT.war %CATALINA_HOME%\webapps
cd %CATALINA_HOME%\bin
%CATALINA_HOME%\bin\startup.bat
