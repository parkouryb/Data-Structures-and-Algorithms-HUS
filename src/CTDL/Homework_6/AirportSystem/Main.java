/* NomNom created on 5/6/2020 inside the package - CTDL.Homework_6.AirportSystem */

package CTDL.Homework_6.AirportSystem;

import CTDL.Homework_6.AirportSystem.Airplane.Airplane;
import CTDL.Homework_6.AirportSystem.Airplane.VietNamAirline;
import CTDL.Homework_6.Entry;
import CTDL.Homework_6.MinHeapPriorityQueue;
import CTDL.Homework_6.UnsortedLinkedPriorityQueue;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws ParseException {
        Initialization.createAirplane();
        // Airplane and timeFly
        MinHeapPriorityQueue<Date, Airplane> AirplaneSystem = new MinHeapPriorityQueue<>();

        // đống này là thêm hết vào
        for (Airplane airplane: Initialization.VNAL) {
            AirplaneSystem.insert(airplane.timeStart(), airplane);
        }

        for (Airplane airplane: Initialization.VJ) {
            AirplaneSystem.insert(airplane.timeStart(), airplane);

        }
        for (Airplane airplane: Initialization.BB) {
            AirplaneSystem.insert(airplane.timeStart(), airplane);
        }

//         thêm thử riêng lẻ máy bay của việt nam airline nhé <3
        Airplane a = Initialization.createSingleVNAL();
        AirplaneSystem.insert(a.timeStart(), a);

        Airplane b = Initialization.createSingleBB();
        AirplaneSystem.insert(b.timeStart(), b);
        System.out.println("E: " + b);

        while (!AirplaneSystem.isEmpty()) {
            Entry var = AirplaneSystem.removeTop();
            System.out.println(var);
        }
    }
}
