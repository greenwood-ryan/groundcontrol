Ground Control

A Java solution for controlling robots on Mars

Architecture Overview

The system uses three main design patterns to keep code organized and easy to change:

Command Pattern
- RobotController maps instruction letters (L, R, F) to command objects
- Each command (TurnLeftCommand, TurnRightCommand, MoveForwardCommand) handles one specific action
- Commands operate on robot state without knowing about other commands

Strategy Pattern  
- OrientationHelper handles all direction calculations (turning, movement)
- Separates orientation logic from robot state management
- Makes it easy to change how directions work

Interface Segregation
- GridBoundary interface defines grid operations
- ScentTracker interface handles scent management  
- RobotState interface manages robot position and status
- Concrete classes (GridConc, ScentTrackerConc, RobotStateConc) implement the details

Key Components

- RobotController: Executes instruction sequences using commands
- Command classes: Handle individual robot actions (turn left/right, move forward)
- OrientationHelper: Calculates direction changes and movement
- GridBoundary: Defines valid positions on the grid
- ScentTracker: Remembers where robots were lost to prevent future losses
- RobotState: Tracks robot position, direction, and lost status

How to Maintain and Extend

Adding New Commands
1. Create a new class implementing the Command interface
2. Add the command logic in the execute() method
3. Register the new command in RobotController constructor
4. Write tests for the new command

Changing Grid Behavior
- Modify GridConc class or create a new GridBoundary implementation
- Grid logic is isolated, so changes won't affect other components

Modifying Scent Tracking
- Update ScentTrackerConc or create a new ScentTracker implementation
- Scent behavior is separate from robot movement logic

Adding Robot Capabilities
- Extend RobotState interface and RobotStateConc implementation
- New robot properties won't break existing commands

Testing Strategy
- Unit tests for individual components (each command, helper classes)
- Integration tests verify the complete system works correctly
- Test invalid inputs to ensure robustness

Design Benefits

- Easy to extend: Add new commands without changing existing code
- Easy to test: Each component can be tested independently  
- Easy to understand: Each class has one clear responsibility
- Easy to change: Modifications are isolated to specific components

Maven Commands

- mvn clean     # Remove all compiled files and build artifacts
- mvn compile   # Convert Java source code into executable class files
- mvn test      # Run all unit and integration tests with coverage analysis
- mvn clean test # Clean, compile, test, and generate coverage report
- open target/site/jacoco/index.html  # View coverage report in browser

Running the Application

- mvn compile exec:java -Dexec.mainClass="MartianRobotsMain"  # Compile and run the main application
- java -cp target/classes MartianRobotsMain  # Run after compiling with mvn compile

Test Coverage

The project uses JaCoCo for test coverage analysis. After running tests, coverage reports are generated in:
- HTML Report: target/site/jacoco/index.html (open in browser)
- CSV Report: target/site/jacoco/jacoco.csv (for CI/CD integration)
- XML Report: target/site/jacoco/jacoco.xml (for tools like SonarQube)

Current Coverage: 96% instruction coverage, 86% branch coverage
