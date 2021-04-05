package CLASS_OBJECT.BAI_TAP;

public class StopWatch {
    private double startTime;
    private double endTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public double getStartTime() {
        return startTime;
    }
    public double getEndTime() {
        return endTime;
    }
    public double start(){
        return startTime =System.currentTimeMillis() ;
    }
    public double stop(){
        return endTime=System.currentTimeMillis();
    }
    public double getElapsedTime(){
        return endTime-startTime;
    }
}
