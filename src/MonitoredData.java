import java.time.Duration;
import java.time.LocalDateTime;

public class MonitoredData {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String activity;

    public MonitoredData(LocalDateTime startTime, LocalDateTime endTime,String activity)
    {
        this.startTime=startTime;
        this.endTime=endTime;
        this.activity=new String(activity);
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }


    public LocalDateTime getEndTime() {
        return endTime;
    }


    public String getActivity() {
        return activity;
    }

    public String getS(){
        return startTime.getYear() + "-" + startTime.getMonthValue() + "-" + startTime.getDayOfMonth();

    }
    public long getTime() {
        return Duration.between(this.getStartTime(), this.getEndTime()).toMinutes();
    }
    @Override
    public String toString() {
        return "startTime=" + startTime + ", endTime=" + endTime + ", activity='" + activity +"\n";
    }
}
