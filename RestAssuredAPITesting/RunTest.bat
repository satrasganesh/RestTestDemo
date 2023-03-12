@ECHO OFF
call mvn clean test

timeout /t 10 /nobreak
%cd%\target\surefire-reports\emailable-report.html