import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class WeatherStation {
  private final LinkedList<Weather> weatherData;

  public LinkedList<Weather> getWeatherData() {
    return weatherData;
  }

  public WeatherStation() {
    this.weatherData = generateWeatherData();
    printTable("WEATHER TABLE", getWeatherData());
  }

  public void lowestTemperature() {
    double lowestTemperature = Double.POSITIVE_INFINITY;
    Weather lowest = new Weather("", 0.00);
    for (Weather weather : getWeatherData()) {
      if (weather.temperature() < lowestTemperature) {
        lowestTemperature = weather.temperature();
        lowest = weather;
      }
    }
    printTable("LOWEST TEMPERATURE", List.of(lowest));
  }

  public void averageTemperature() {
    double sum = 0.0;
    for (Weather weather : getWeatherData()) {
      sum += weather.temperature();
    }
    double average = sum / getWeatherData().size();
    System.out.printf(
        """
            %n
            ##########
              %s
            ##########
            The average temperature is: %s
            """,
        "AVERAGE TEMPERATURE", average);
  }

  public void highestTemperature() {
    double highestTemperature = Double.NEGATIVE_INFINITY;
    Weather highest = new Weather("", 0.00);
    for (Weather weather : getWeatherData()) {
      if (weather.temperature() > highestTemperature) {
        highestTemperature = weather.temperature();
        highest = weather;
      }
    }
    printTable("HIGHEST TEMPERATURE", List.of(highest));
  }

  private LinkedList<Weather> generateWeatherData() {
    LinkedList<Weather> weatherData = new LinkedList<>();
    LocalDate date = LocalDate.now();
    Random random = new Random();
    double minTemperature = -20;
    double maxTemperature = 40;

    for (int i = 0; i <= 32; i++) {
      weatherData.add(
          new Weather(
              DateTimeFormatter.ofPattern("dd.MM.yyyy").format(date),
              minTemperature + (maxTemperature - minTemperature) * random.nextDouble()));
      date = date.plusDays(1);
    }

    return weatherData;
  }

  private void printTable(String headline, List<Weather> weatherData) {
    final String format = "%-10s | %-15s%n";
    System.out.printf(
            """
            %n
            ##########
              %s
            ##########
            """, headline);
    System.out.printf(format, "Date", "Temperature");
    for (Weather weather : weatherData) {
      System.out.printf(format, weather.date(), weather.temperature());
    }
  }
}
