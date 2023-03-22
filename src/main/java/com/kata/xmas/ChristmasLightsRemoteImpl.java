package com.kata.xmas;

import java.util.List;

public class ChristmasLightsRemoteImpl implements Remote{

    Grid lightGrid;
    InstructionManual manual;

    public ChristmasLightsRemoteImpl(Grid lightGrid, InstructionManual manual) {
        this.lightGrid = lightGrid;
        this.manual = manual;
    }
    @Override
    public void lumos() {
        List<String> instructions = manual.getInstructions();
        for(String instruction: instructions) {
            manual.instructionIdentifier(instruction).execute();
        }
        System.out.println("Lit Lights : "+lightGrid.getLitLights());
        System.out.println("Brightness : "+ lightGrid.getTotalBrightness());
    }




}
