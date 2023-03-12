# RestTestDemo

**#Project Name:** RestAssuredAPITesting
**#Author:** Ganesh Satras
**Folder Structure:
1. src:
    **a. src/test/java:** 
      i. Package: restAssuredPackage (Contains Categories class where all the tests are stored )
         - Categories.java (Class File)
           **Tests for below acceptance criteria:**
                1. categoryNameVerification() : Validates the Category Name "Carbon credits" 
                2. canRelistFlagCheck() : Validates the CanRelist Flag to check whether it can be relisted
                3. promotionsDescriptionVerification() : Validates Description value of Promotion with Name="Gallery"
            **Acceptance Criteria:**
                1. Name = "Carbon credits"
                2. CanRelist = true
                3. The Promotions element with Name = "Gallery" has a Description that contains the text "Good position in category"
2. POM.xml: Dependencies and supporting plugins
3. testng.xml: Test Suite
4. RunTest.bat: Invokes the maven plugin and executes the maven command and launches the report
5. target: All the logs and Reports are created in this folder.
    - root\target\surefire-reports\emailable-report.html (Report for the test can be found here)


**Execution Guide:**
1. Run batch file with name RunTest.bat
    - This will automatically invoke the maven command and execute testNG suite.
    - Report will automatically be invoked after execution

**Path for the Code Review:**
1. root\src\test\java\restAssuredPackage\Categories.java (This file contains all the API tests for the acceptance criteria)
