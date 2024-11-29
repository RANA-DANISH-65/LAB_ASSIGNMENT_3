package Models;

import java.util.Objects;

public class Data {
    private String ID;
    private String name;
    private String gender;
    private String province;
    private String date;

    public Data(String ID, String name, String gender, String province, String date) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.province = province;
        this.date = date;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return this.getID().equals(data.getID());
    }

}
