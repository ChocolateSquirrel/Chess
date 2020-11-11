package game;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Clock {
	LocalTime startTime;
	
	public Clock(LocalTime startTime) {
		this.startTime = startTime;
	}
	
	public long giveElapsedTimeInSeconds(LocalTime time) {
		long nbSeconds = startTime.until(time, ChronoUnit.SECONDS);
		return nbSeconds;
	}
	
	public String changeTimeInString(long nbSeconds) {
		StringBuilder str = new StringBuilder();
		int i = (int) nbSeconds;
		int minuts = i/60;
		int seconds = i%60;
		int hours = minuts/60;
		minuts = minuts%60;
		
		str.append(" ");
		if (hours<10) {
			str.append("0");
			str.append(hours);
		}
		else {
			str.append(hours);
		}
		
		str.append(" : ");
		if (minuts<10) {
			str.append("0");
			str.append(minuts);
		}
		else {
			str.append(minuts);
		}
		
		str.append(" : ");
		if (seconds<10) {
			str.append("0");
			str.append(seconds);
		}
		else {
			str.append(seconds);
		}
		return str.toString();
	}
}
