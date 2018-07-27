set projectLocation=F:\Project\NowSSO
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\src\configruration\*
java org.testng.TestNG %projectLocation%\testng.xml
