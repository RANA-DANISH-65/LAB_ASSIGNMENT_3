package Models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    private File dataFile;
    private List<Data> dataArray;

    public Manager() {
        dataArray = new ArrayList<>();
        dataFile = new File("Data.txt");
        if (dataFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length == 5) {
                        Data data = new Data(
                                parts[0],
                                parts[1],
                                parts[2],
                                parts[3],
                                parts[4]
                        );
                        dataArray.add(data);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("Data file does not exist.");
        }
    }

    public List<Data> getDataArray() {
        return dataArray;
    }

    public void addData(Data newData) {
        dataArray.add(newData);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile, true))) {
            writer.write(newData.getID() + "|" +
                    newData.getName() + "|" +
                    newData.getGender() + "|" +
                    newData.getProvince() + "|" +
                    newData.getDate());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    public Data searchData(String id) {
        for (Data data : dataArray) {
            if (data.getID().equals(id)) {
                return data;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        System.out.println("Loaded Data:");
        for (Data d : manager.getDataArray()) {
            System.out.println(d.getID() + " | " + d.getName() + " | " +
                    d.getGender() + " | " + d.getProvince() + " | " + d.getDate());
        }
        manager.addData(new Data("011", "Kevin", "Male", "Punjab", "2004-10-20"));
    }
}
