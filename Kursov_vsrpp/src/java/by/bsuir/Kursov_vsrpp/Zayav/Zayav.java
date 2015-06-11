package by.bsuir.Kursov_vsrpp.Zayav;

import java.util.Objects;

public class Zayav {
    int id;             //номер заказа
    String tovar;       //товар
    int kolich;         //количество товара
    int stoim;          //стоимость заказа
    String fiozakaz;    //фио заказчика
    String adress;      //адресс заказчика
    int telef;          //телефон заказчика
    String data;           //дата заказа
    boolean status;     //статус заказа
    
    public Zayav(int id, String tovar, int kolich, int stoim, String fiozakaz, String adress, int telef, String data, boolean status){
        this.id = id;
        this.tovar = tovar;
        this.kolich = kolich;
        this.stoim = stoim;
        this.fiozakaz = fiozakaz;
        this.adress = adress;
        this.telef = telef;
        this.data = data;
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.tovar);
        hash = 97 * hash + this.kolich;
        hash = 97 * hash + this.stoim;
        hash = 97 * hash + Objects.hashCode(this.fiozakaz);
        hash = 97 * hash + Objects.hashCode(this.adress);
        hash = 97 * hash + this.telef;
        hash = 97 * hash + Objects.hashCode(this.data);
        hash = 97 * hash + (this.status ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zayav other = (Zayav) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.tovar, other.tovar)) {
            return false;
        }
        if (this.kolich != other.kolich) {
            return false;
        }
        if (this.stoim != other.stoim) {
            return false;
        }
        if (!Objects.equals(this.fiozakaz, other.fiozakaz)) {
            return false;
        }
        if (!Objects.equals(this.adress, other.adress)) {
            return false;
        }
        if (this.telef != other.telef) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Zayav{" + "id=" + id + ", tovar=" + tovar + ", kolich=" + kolich + ", stoim=" + stoim + ", fiozakaz=" + fiozakaz + ", adress=" + adress + ", telef=" + telef + ", data=" + data + ", status=" + status + '}';
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTovar() {
        return tovar;
    }

    public void setTovar(String tovar) {
        this.tovar = tovar;
    }

    public int getKolich() {
        return kolich;
    }

    public void setKolich(int kolich) {
        this.kolich = kolich;
    }

    public int getStoim() {
        return stoim;
    }

    public void setStoim(int stoim) {
        this.stoim = stoim;
    }

    public String getFiozakaz() {
        return fiozakaz;
    }

    public void setFiozakaz(String fiozakaz) {
        this.fiozakaz = fiozakaz;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getTelef() {
        return telef;
    }

    public void setTelef(int telef) {
        this.telef = telef;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }  
}
