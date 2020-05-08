/* NomNom created on 5/6/2020 inside the package - CTDL.Homework_6.AirportSystem */

package CTDL.Homework_6.AirportSystem;

import CTDL.Homework_6.AirportSystem.Airplane.Bamboo;
import CTDL.Homework_6.AirportSystem.Airplane.VietNamAirline;
import CTDL.Homework_6.AirportSystem.Airplane.Vietjet;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Initialization {
    static Random random = new Random();

//    static VietNamAirline[] VNAL;
    static ArrayList<VietNamAirline> VNAL;
    static ArrayList<Vietjet> VJ;
    static ArrayList<Bamboo> BB;

    static final int totalVietNamAirline = 3;
    static final int totalVietjet = 1;
    static final int totalBamboo = 2;

    private static String createName(String name) {
        // default = 5
        while (name.length() < 5) {
            name = "0" + name;
        }
        return name;
    }

    public static VietNamAirline createSingleVNAL() throws ParseException {
        VietNamAirline airplane = new VietNamAirline(createName(Integer.toString(random.nextInt(1000) + 1)));
        Date timeStart = Initialization.getRandomTimeStart();
        Date timeStop = Initialization.getRandomTimeFinish(timeStart);
        airplane.setStartTime(timeStart);
        airplane.setFinishTime(timeStop);
        airplane.setTimeFly(getTimeFly(timeStart, timeStop));

        return airplane;
    }

    public static Vietjet createSingleVJ() throws ParseException {
        Vietjet airplane = new Vietjet(createName(Integer.toString(random.nextInt(1000) + 1)));
        Date timeStart = Initialization.getRandomTimeStart();
        Date timeStop = Initialization.getRandomTimeFinish(timeStart);
        airplane.setStartTime(timeStart);
        airplane.setFinishTime(timeStop);
        airplane.setTimeFly(getTimeFly(timeStart, timeStop));

        return airplane;
    }

    public static Bamboo createSingleBB() throws ParseException {
        Bamboo airplane = new Bamboo(createName(Integer.toString(random.nextInt(1000) + 1)));
        Date timeStart = Initialization.getRandomTimeStart();
        Date timeStop = Initialization.getRandomTimeFinish(timeStart);
        airplane.setStartTime(timeStart);
        airplane.setFinishTime(timeStop);
        airplane.setTimeFly(getTimeFly(timeStart, timeStop));

        return airplane;
    }

    private static void createVietnamAirlinePlanes() throws ParseException {
        VNAL = new ArrayList<>();
        for (int i = 0;i < totalVietNamAirline;++ i) {
            VNAL.add(createSingleVNAL());
        }

    }

    private static void createVietjetPlanes() throws ParseException {
        VJ = new ArrayList<>();
        for (int i = 0;i < totalVietjet;++ i) {
            VJ.add(createSingleVJ());
        }
    }

    private static void createBambooPlanes() throws ParseException {
        BB = new ArrayList<>();
        for (int i = 0;i < totalBamboo;++ i) {
            BB.add(createSingleBB());
        }
    }

    private static Date getRandomTimeStart() {
        Date now = new Date();
        long timeRangeMs = 1000 * 60 * 60 * 24 * 365; // 24 hours in ms
        long random = ThreadLocalRandom.current().nextLong(timeRangeMs);
        Date randDate = new Date(now.getTime() - random);
        return randDate;
    }

    private static Date getRandomTimeFinish(Date timeStart) throws ParseException {
        Date now = timeStart;
        long timeRangeMs = 1000 * 60 * 60 * 20; // 20 hours in ms
        long random = ThreadLocalRandom.current().nextLong(timeRangeMs);
        Date randDate = new Date(now.getTime() + random);
        return randDate;
    }

    private static String getTimeFly(Date timeStart, Date timeStop) {
        long millis = timeStop.getTime() - timeStart.getTime();
        String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
        return hms;
    }

    public static void createAirplane() throws ParseException {
        createVietnamAirlinePlanes();
        createVietjetPlanes();
        createBambooPlanes();
    }
}
