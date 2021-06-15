package lesson11.part4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RAFWithCities extends RandomAccessFile {
    public static class CityGeoLocation{}

    // свойства
    private long start = 0;
    private long end;

    public CityGeoLocation cityGeoLocation = new CityGeoLocation();     // выбранный город

    // методы
    public RAFWithCities(String pathName) throws FileNotFoundException{}
    public boolean findCity(String city) throws IOException {
        return false;
    }
    private long startStringPosition(long pos) throws  IOException{
        return 0;
    }

    // точка входа
    public static void main(String[] args) {

    }

}
