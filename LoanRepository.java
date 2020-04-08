package com.javatut;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LoanRepository {
    //@todo use ini file
    static String URL = "/Users/cristian.toma1/IdeaProjects/javatut/src/com/javatut/data.json";

    /**
     * @param period iterable
     * @return
     */
    public static Map<Integer, String[]> processPeriod(int period) {
        JSONParser parser = new JSONParser();
        Object obj = new Object();

        Calendar currentDate = new GregorianCalendar();
        currentDate.setTimeZone(TimeZone.getTimeZone("GMT"));
        // increment date by period
        currentDate.add(Calendar.MONTH, period);

        Gson gson = new GsonBuilder()
                .setDateFormat("dd-MM-yyyy")
                .create();

        // read json file
        try {
            obj = parser.parse(new FileReader(URL));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        //load json data to models
        Loan[] loanArray = gson.fromJson(obj.toString(), Loan[].class);

        float total = 0;
        for (Loan loan : loanArray) {
            Calendar entityStartDate = DateUtils.dateToCalendar(loan.getDateStart());
            // calculating end date of loan based on remaining periods.
            Calendar entityEndDate = DateUtils.dateToCalendar(loan.getDateStart());
            entityEndDate.add(Calendar.MONTH, loan.getNumberOfPeriods());

            int x = currentDate.compareTo(entityStartDate);
            int y = currentDate.compareTo(entityEndDate);

            if (x < 0 || y > 0)
                continue;

            total += loan.getAmount();
        }

        float finalTotal = total;
        Map<Integer, String[]> ret = new HashMap<>();

        ret.put(period, new String[]{DateUtils.getDate(currentDate), Float.toString(finalTotal)});
        return ret;
//        return "" + DateUtils.getDate(currentDate) + ">>>>>>>" + total + "<br/>";
//        System.out.printf(
//                " %s >>>>> %.1f \n ",
//                DateUtils.getDate(currentDate),
//                total
//        );

    }
}