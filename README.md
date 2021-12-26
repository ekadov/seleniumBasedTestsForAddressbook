#README

##CRUD tests for Addressbook PHP.

###Used:

   * Maven
   * TestNG
   * Selenium
   * Ashot
   * AssertJ
   * JDBC Template
   * Faker
   * Log4J2

Tests are being started with Login, then all tests one by one in one browser session.
Use Jenkinsfile for creating an example pipeline (you need to edit it with your own git repository link).

###@TODO

   * Make tests independent by adding login into each one
   * Add test data preparation
   * Add some tests for DB
   * Add more custom WebElements
   * Migrate SQL scripts into specific config file and create a class to use it


###Running tests
1. Download testable application here: https://sourceforge.net/projects/php-addressbook/

    Run it with Xampp server or something like that.

3. Run 'allTests.xml' file for running TestNG suite.