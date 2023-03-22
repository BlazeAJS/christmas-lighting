package com.kata.xmas;

public class SwitchOnCommand implements Command{

    private Grid lightGrid;
    private Position from;
    private Position to;
    public SwitchOnCommand(Grid lightGrid, Position from, Position to) {
        this.lightGrid = lightGrid;
        this.from = from;
        this.to = to;
    }
    @Override
    public void execute() {
        int[][] lights = lightGrid.getLights();
        if(from.equals(to)) {
            lights[from.getxCoordinate()][from.getyCoordinate()] = lights[from.getxCoordinate()][from.getyCoordinate()] + 1;
        } else {
            for(int rows= from.getxCoordinate();rows<to.getxCoordinate();rows++) {
                for(int cols = from.getyCoordinate();cols<to.getyCoordinate();cols++) {
                    lights[rows][cols] = lights[rows][cols]+1;
                }
            }
        }

    }
}
