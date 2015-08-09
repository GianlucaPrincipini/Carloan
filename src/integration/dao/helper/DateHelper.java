package integration.dao.helper;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;

public class DateHelper {
	   /**
	    * Fuso orario di riferimento settato in Europa Centrale (Central European Time)
	    */
	   public static final DateTimeZone jodaTzCET = DateTimeZone.forID("CET");

	    /**
	     * Converte una java.sql.Date in una LocalDate
	     * @param d data da convertire
	     * @return data convertita
	     */
	    public static LocalDate dateToLocalDate(java.sql.Date d) {
	        if(d==null) return null;
	        System.out.println(d);
	        return new LocalDate(d.getTime(), jodaTzCET);
	    }

	    /**
	     * Converte una LocalDate in java.sql.Date
	     * @param ld data da convertire
	     * @return data convertita
	     */
	    public static java.sql.Date localdateToDate(LocalDate ld) {
	        if(ld==null) return null;
	        return new java.sql.Date(
	           ld.toDateTimeAtStartOfDay(jodaTzCET).getMillis());
	    }
}
