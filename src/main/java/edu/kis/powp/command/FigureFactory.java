package edu.kis.powp.command;
import edu.kis.powp.jobs2d.Job2dDriver;

public class FigureFactory{

    private Job2dDriver driver;
    private static ComplexCommand command=new ComplexCommand();

    public static void newSquare(Job2dDriver driver,int size){
        command.add(new SetPositionCommand(driver,0,0));
        command.add(new OperateToCommand(driver,size,0));
        command.add(new OperateToCommand(driver,size,size));
        command.add(new OperateToCommand(driver,0,size));
        command.add(new OperateToCommand(driver,0,0));
        command.execute();
    }

    public static void newTriangle(Job2dDriver driver,int size){
        command.add(new SetPositionCommand(driver,0,0));
        command.add(new OperateToCommand(driver,size/2,size));
        command.add(new OperateToCommand(driver,-size/2,size));
        command.add(new OperateToCommand(driver,0,0));
        command.execute();
    }

    public static void newCircle(Job2dDriver driver,int radius){
        int steps=360;
        double angleStep =2*Math.PI/steps;
        command.add(new SetPositionCommand(driver,radius,0));
        for(int i=1;i<=steps;i++){
            double angle=i*angleStep;
            double x=radius*Math.cos(angle);
            double y=radius*Math.sin(angle);
            int xi=(int)Math.round(x);
            int yi=(int)Math.round(y);
            command.add(new OperateToCommand(driver,xi,yi));
        }
        command.execute();
    }
}