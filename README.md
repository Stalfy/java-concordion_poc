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

## Notes:
Concordion is difficult to use when testing the equality of instances (e.g. Verify that the same cell instance is in a row, column and region).
