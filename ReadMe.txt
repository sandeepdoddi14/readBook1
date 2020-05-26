1. Nested Maven Module
2. Framework Contains all the wrapper classes that are resuable,
    used to build the testng.xml automatically when the project builds
    based on the number of classes given in cofig.xlsx
3. tests contain all the resources,config.ini(url paths),driver executables
4. Module(goodreads) contain the module realted test


/*
how to run the project
1. perform a clean install on whole project
2. testNg file automatically gets genreated in module goodreads
3. and runs the tests for good reads
4. good reads picks up tweet from tweets.config and generates results

*/
