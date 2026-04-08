package edu.kis.powp.command;
import java.util.ArrayList;

public class ComplexCommand{

    private final ArrayList<DriverCommand> commander = new ArrayList<DriverCommand>();

    public void add(DriverCommand command){this.commander.add(command);}

    public void execute(){
        for (DriverCommand command:this.commander){
            command.execute();
        }
    }
}