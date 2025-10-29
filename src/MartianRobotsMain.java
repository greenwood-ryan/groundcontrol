public class MartianRobotsMain {
    public static void main(String[] args) {
        // Set up grid and tracking
        GridBoundary grid = new GridConc(5, 3);
        ScentTracker scentTracker = new ScentTrackerConc();
        RobotController controller = new RobotController(grid, scentTracker);
        
        // Robot 1
        RobotState robot1 = new RobotStateConc(1, 1, 'E');
        controller.executeInstructions(robot1, "RFRFRFRF");
        System.out.println(robot1.toString());
        
        // Robot 2
        RobotState robot2 = new RobotStateConc(3, 2, 'N');
        controller.executeInstructions(robot2, "FRRFLLFFRRFLL");
        System.out.println(robot2.toString());
        
        // Robot 3
        RobotState robot3 = new RobotStateConc(0, 3, 'W');
        controller.executeInstructions(robot3, "LLFFFLFLFL");
        System.out.println(robot3.toString());
    }
}