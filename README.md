# java-concordion_poc

## Technologies used:
Java 10.0.2  
Apache Maven 3.5.2

## Rules:
No logic in POJOs.  
No if/else statements in the code.  
No switch/case statements in the code.  
All testing must be done through the Concordion framework.  
Reach 90-100% code coverage with jacoco except POJO classes.

## Comments:
-  Concordion is difficult to use when testing the equality of instances (e.g. Verify that an instance is in a row, column and region).  
-  The Given, When & Then syntax makes certain behaviors harder to test, but this syntax helps greatly.  
-  For the sake of BDD, some information was hidden in the test fixtures, which is a little detrimental.
