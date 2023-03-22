package com.kata.xmas;

import java.util.List;

public class InstructionManual {

    private List<String> instructions;
    private Grid lightGrid;

    public Grid getLightGrid() {
        return lightGrid;
    }

    public void setLightGrid(Grid lightGrid) {
        this.lightGrid = lightGrid;
    }

    public List<String> getInstructions() {
        return this.instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public Command instructionIdentifier(String commandString) {
        Command command = null;
        String[] commandPiece = commandString.split(" ");
        if(commandPiece[0].equals("turn")) {
            if(commandPiece[1].equals("on")) {
                Position from = getPosition(commandPiece[2]);
                Position to = getPosition(commandPiece[4]);
                command = new SwitchOnCommand(lightGrid,from,to);
            }
            else if(commandPiece[1].equals("off")) {
                Position from = getPosition(commandPiece[2]);
                Position to = getPosition(commandPiece[4]);
                command = new SwitchOffCommand(lightGrid, from, to);
            }
        } else if(commandPiece[0].equals("toggle")) {
            Position from = getPosition(commandPiece[1]);
            Position to = getPosition(commandPiece[3]);
            command = new ToggleCommand(lightGrid, from, to);
        }
        return command;
    }

    public Position getPosition(String position) {
        Position pos=null;
        String[] positionArray = position.split(",");

        if(positionArray.length>1)
            pos = new Position(Integer.parseInt(positionArray[0]),Integer.parseInt(positionArray[1]));
        else
            System.out.println("Invalid instruction : light position incorrect");
        return pos;
    }

}
