package lesson11.part4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RAFWithCities extends RandomAccessFile {
    public static class CityGeoLocation {
        public String city;
        public double lat;
        public double lon;

        public CityGeoLocation() {
            city = "";
        }

        // формируем значение по строке
        public CityGeoLocation(String cityStr) {
            if (cityStr == null) return;
            String[] cityArr = cityStr.split(",");
            city = cityArr[0].toUpperCase();
            if (cityArr.length > 1) lat = Double.parseDouble(cityArr[1]);
            if (cityArr.length > 2) lon = Double.parseDouble(cityArr[2]);
        }

        @Override
        public String toString() {
            return city + " (" + lat + ", " + lon + ")";
        }
    }

    // свойства
    private long start = 0;
    private long end;

    public CityGeoLocation cityGeoLocation = new CityGeoLocation();     // выбранный город

    // методы
    public RAFWithCities(String pathName) throws FileNotFoundException {
        super(pathName, "r");
    }

    public boolean findCity(String city) throws IOException {
        city = city.trim().toUpperCase();

        start = 0;
        end = length();

        while (start != end) {
            // ишем середину и движемся к началу строки
            long current = startStringPosition((end + start) / 2);
            seek(current);
            String currentLine = readLine();
            if (currentLine == null) return false;
            currentLine = new String(currentLine.getBytes("ISO-8859-1"), "UTF-8");

            // сравниваем заданный город и найденный в файле
            cityGeoLocation = new CityGeoLocation(currentLine);
            int compareResult = city.compareTo(cityGeoLocation.city);
            if (compareResult == 0) {
                return true;
            } else if (compareResult > 0) {
                start = this.getFilePointer();
            } else {
                end = current;
            }
        }
        return false;
    }

    private long startStringPosition(long pos) throws IOException {
        // ищем символ конца строки 0x0D (\r) или 0x0A (\n)
        for (long i = pos; i >= 0; i--) {
            seek(i);
            int byteChar = read();
            if (byteChar == 0x0D || byteChar == 0x0A) return i + 1;
        }
        return 0;
    }

    // точка входа
    public static void main(String[] args) {
        try (RAFWithCities rafCities = new RAFWithCities("D:\\Progwards\\src\\lesson11\\part4\\cities.csv")) {
            if (rafCities.findCity("АпатитЫ")) {
                System.out.println(rafCities.cityGeoLocation);
            }
            if (rafCities.findCity("ТОмск")) {
                System.out.println(rafCities.cityGeoLocation);
            }
            if (rafCities.findCity("ЯСНЫЙ")) {
                System.out.println(rafCities.cityGeoLocation);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
