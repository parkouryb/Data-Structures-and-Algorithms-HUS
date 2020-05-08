/* NomNom created on 5/8/2020 inside the package - CTDL.Homework_6.AirportSystem.Airplane */

package CTDL.Homework_6.AirportSystem.Airplane;

import java.util.Date;

public interface Airplane extends Comparable {
    String airplaneCode();
    Date timeStart();
    Date timeFinish();
    String timeFly();
}
