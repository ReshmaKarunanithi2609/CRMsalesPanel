# CRMsalespanel - CRM mobile automation (Appium + Java + Cucumber + JUnit4)

Structure (Monika / Locate360 style)
  src/main/java/Driverfactory  DriverFactory, DriverManager (ONE session for the whole run)
  src/main/java/Pom            locators only - one class per module (+ Navigation, Messages)
  src/main/java/utils          ConfigReader, ElementUtils, PageElements, SessionManager
  src/test/java/hooks          Hooks (@BeforeAll start session, @Before prepare, @After screenshot, @AfterAll quit)
  src/test/java/StepDefinition one class per module + CommonSteps
  src/test/java/Test           Testrunner
  src/test/resources/Feature   01Login ... 12Profile, 15 scenarios each (9-10 @positive, 5-6 @negative)
  src/test/resources           config.properties, extent.properties, allure.properties

End to end: the app is logged in only once. Before each scenario SessionManager checks the app is in the
foreground (so the run never wanders into the Android launcher / Theme screen), types the credentials only when
the Login screen is really showing, and returns to the Dashboard. Login scenarios (@Login) start from a clean app.

Run             : Test/Testrunner.java > Run As > JUnit Test. Testrunner has  tags = "@Login and @positive"  as the example;
                  change it for the next run:  "@Login and @negative" | "@Leads" | "@Login or @Dashboard" | remove the line = everything
                  (or VM argument  -Dcucumber.filter.tags="@Leads")
Module tags: @Login @Dashboard @Leads @Attendance @FollowUp @Deals @QuotationsCustomers @Orders @Payments
             @SupportTickets @Reports @Profile      Scenario tags: @positive @negative

Reports
  Extent : test-output/SparkReport/Spark.html   (failure screenshots embedded)
  Allure : automatic. After Testrunner finishes, allure-results -> allure-report/index.html is generated and opened
           (utils/AllureReportGenerator: Allure 3 via npx, else the bundled Allure 2 in .allure/ - Java only).
           Old allure-results are cleaned before each run. Manual: generate-allure-report.bat. Disable: -Dallure.autoGenerate=false
           screenshotEveryStep=true in config.properties attaches a screenshot to every step; default = on failure only.
  Cucumber html : test-output/cucumber-report.html

Before running: emulator Pixel_Google (emulator-5554) started, crm.apk installed (adb install crm.apk), Appium 2 running.
Locators marked // VERIFY have no visible text; confirm once in Appium Inspector and change only the Pom class.
Not executed on a device in this environment.

Keyboard note: Gboard shows a toolbar with a Themes icon. Buttons hidden under the keyboard used to be tapped on that
toolbar. Now every type/tap first closes the keyboard (Done key, then Back, then hideKeyboard).
