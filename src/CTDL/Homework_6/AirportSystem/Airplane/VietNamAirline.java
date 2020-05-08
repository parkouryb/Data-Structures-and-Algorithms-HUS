/* NomNom created on 5/6/2020 inside the package - CTDL.Homework_6.AirportSystem.Airplane */

package CTDL.Homework_6.AirportSystem.Airplane;

import CTDL.Homework_6.AirportSystem.Initialization;

import java.util.Date;

public class VietNamAirline implements Airplane {
    private String airplaneCode;
    private final String keyPlane = "VN";
    private Date startTime = null;
    private Date finishTime = null;
    private String timeFly = null;

    public void setTimeFly(String timeFly) {
        this.timeFly = timeFly;
    }

    public String getTimeFly() {
        return timeFly;
    }

    public VietNamAirline(String airplaneCode) {
        this.airplaneCode = this.keyPlane + airplaneCode;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public String toString() {
        return "{" +
                "airplaneCode='" + airplaneCode + '\'' +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", timeFly='" + timeFly + '\'' +
                '}';
    }

    @Override
    public String airplaneCode() {
        return this.airplaneCode;
    }

    @Override
    public Date timeStart() {
        return this.startTime;
    }

    @Override
    public Date timeFinish() {
        return this.finishTime;
    }

    @Override
    public String timeFly() {
        return this.timeFly;
    }

    @Override
    public int compareTo(Object o) {
        Airplane otherPlane = (Airplane) o;
        return this.startTime.compareTo(otherPlane.timeStart());
    }
}
