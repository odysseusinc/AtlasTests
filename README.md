# AtlasTests

To start you have to install cucumber plugin to IntelliJ Idea: https://plugins.jetbrains.com/plugin/7212-cucumber-for-java
Please take attention on version of your Idea, to download correct version of plugin. (Help -> About)

Clone this project to your computer.

Create file "application.properties" with parameters:
login
password
downloadpath

e.g.
login = qa_login

password = qa_password

downloadpath = C:\\downloads     (Directory should be exist)



To run tests you have to run RunCucumberTest.class file
If you start it as is, all tests from project start.
You can say to cucumber what tests do you want to start by uncommenting row ", tags = {"@dev"}"
after  @ you have to set tag with type of tests what you want. e.g. @IMPALA and start RunCucumberTest and all tests with
tag IMPALA will be start.

