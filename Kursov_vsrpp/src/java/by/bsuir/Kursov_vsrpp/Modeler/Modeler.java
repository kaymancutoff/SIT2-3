package by.bsuir.Kursov_vsrpp.Modeler;

import by.bsuir.Kursov_vsrpp.Zayav.Zayav;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Modeler {
    
    private final static String SQL_INSERT_INTO_ZAYAV = "insert into zak values (?,?,?,?,?,?,?,?,?)";
    private final static String SQL_DELETE_FROM_ZAYAV = "delete from zak where N = ?";
    private final static String SQL_UPDATE_ZAYAV = "update zak set Товар = ?, Количество = ?, "
                    + "Стоимость = ?, ФИО = ?, Адрес = ?, Телефон = ?, Дата = ?, Статус = ? where N = ?";
    
    public ArrayList<Zayav> showBase (){
        System.out.println("Nachalo show_mod");
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;       
        ArrayList<Zayav> baseTemp = new ArrayList<Zayav> ();

        try {		
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zakazy", "root", "root");
            String sqlQuery = "Select * from zak order by N";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlQuery);

            int id;             //номер заказа
            String tovar;       //товар
            int kolich;         //количество товара
            int stoim;          //стоимость заказа
            String fiozakaz;    //фио заказчика
            String adress;      //адресс заказчика
            int telef;          //телефон заказчика
            String data;        //дата заказа
            boolean status;     //статус заказа
            
            System.out.println("Seredina show_mod");
            
            while (rs.next()) {
                id = rs.getInt("N");
                tovar = rs.getString("Товар");
                kolich = rs.getInt("Количество");
                stoim = rs.getInt("Стоимость");
                fiozakaz = rs.getString("ФИО");
                adress = rs.getString("Адрес");
                telef =  rs.getInt("Телефон");
                data = rs.getString("Дата");
                status = rs.getBoolean("Статус");
                baseTemp.add(new Zayav(id, tovar, kolich, stoim, fiozakaz, adress, telef, data, status));
            }
            System.out.println("Konec show_mod");
        } catch (SQLException se) {
            System.out.println ("SQLERROR " + se.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return baseTemp;
    }
    
    public void insertIntoZayav (int id, String tovar, int kolich, int stoim, String fiozakaz,
                                String adress, int telef, String data, boolean status){	
        System.out.println("Nachalo insert_mod");
        
        Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        
        System.out.println(id+ tovar+ kolich+ stoim+ fiozakaz+ adress+ telef+ data+ status);
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zakazy", "root", "root");
            stmt = conn.prepareStatement(SQL_INSERT_INTO_ZAYAV);

            stmt.setInt(1, id);
            stmt.setString(2, tovar);
            stmt.setInt(3, kolich);
            stmt.setInt(4, stoim);
            stmt.setString(5, fiozakaz);
            stmt.setString(6, adress);
            stmt.setInt(7, telef);
            stmt.setString(8, data);
            stmt.setBoolean(9, status);

            System.out.println("Seredina insert_mod");
            //stmtS.setInt(0,4);
            stmt.executeUpdate();
            System.out.println("Konec insert_mod");
        } catch (SQLException se) {
            System.out.println ("SQLERROR " + se.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
	
    public void updateZayav (int id, String tovar, int kolich, int stoim, String fiozakaz,
                            String adress, int telef, String data, boolean status) {
        System.out.println("Nachalo update_mod");
        
        Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;

        System.out.println(id+ tovar+ kolich+ stoim+ fiozakaz+ adress+ telef+ data+ status);
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zakazy", "root", "root");
            stmt = conn.prepareStatement(SQL_UPDATE_ZAYAV);
            
            stmt.setString(1, tovar);
            stmt.setInt(2, kolich);
            stmt.setInt(3, stoim);
            stmt.setString(4, fiozakaz);
            stmt.setString(5, adress);
            stmt.setInt(6, telef);
            stmt.setString(7, data);
            stmt.setBoolean(8, status);
            stmt.setInt(9, id);
            
            System.out.println("Seredina update_mod");
            
            stmt.executeUpdate();
            
            System.out.println("Konec update_mod");
        } catch (SQLException se) {
                System.out.println ("SQLERROR " + se.getMessage());
        } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteFromZayav (String id) {
        Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zakazy", "root", "root");
            stmt = conn.prepareStatement(SQL_DELETE_FROM_ZAYAV);
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException se) {
            System.out.println ("SQLERROR " + se.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public ArrayList<Zayav> search (String zapr){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;       

        ArrayList<Zayav> baseTemp = new ArrayList<Zayav> ();
        System.out.println(zapr);
        try {		
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zakazy", "root", "root");
            String sqlQuery = "select * from zak where Товар = '" + zapr + "'";
            System.out.println(sqlQuery);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlQuery);

            int id;             //номер заказа
            String tovar;       //товар
            int kolich;         //количество товара
            int stoim;          //стоимость заказа
            String fiozakaz;    //фио заказчика
            String adress;      //адресс заказчика
            int telef;          //телефон заказчика
            String data;        //дата заказа
            boolean status;     //статус заказа
            
            System.out.println("Seredina show_mod");
            
            while (rs.next()) {
                id = rs.getInt("N");
                tovar = rs.getString("Товар");
                kolich = rs.getInt("Количество");
                stoim = rs.getInt("Стоимость");
                fiozakaz = rs.getString("ФИО");
                adress = rs.getString("Адрес");
                telef =  rs.getInt("Телефон");
                data = rs.getString("Дата");
                status = rs.getBoolean("Статус");
                baseTemp.add(new Zayav(id, tovar, kolich, stoim, fiozakaz, adress, telef, data, status));
            }
            
            System.out.println("");
            System.out.println("Konec show_mod");
        } catch (SQLException se) {
            System.out.println ("SQLERROR " + se.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         return baseTemp;
    }
       
    public ArrayList<String> prib (){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;       

        ArrayList<Zayav> baseTemp = new ArrayList<Zayav> ();
        String rezu = null;
        String ojid = null;
        ArrayList<String> rezult = new ArrayList<String>(2);
        int rez = 0;
        int oji = 0;
        try {		
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zakazy", "root", "root");
            String sqlQuery = "select * from zak";
            System.out.println(sqlQuery);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlQuery);

            int id;             //номер заказа
            String tovar;       //товар
            int kolich;         //количество товара
            int stoim;          //стоимость заказа
            String fiozakaz;    //фио заказчика
            String adress;      //адресс заказчика
            int telef;          //телефон заказчика
            String data;        //дата заказа
            boolean status;     //статус заказа           
 
            while (rs.next()) {
                id = rs.getInt("N");
                tovar = rs.getString("Товар");
                kolich = rs.getInt("Количество");
                stoim = rs.getInt("Стоимость");
                fiozakaz = rs.getString("ФИО");
                adress = rs.getString("Адрес");
                telef =  rs.getInt("Телефон");
                data = rs.getString("Дата");
                status = rs.getBoolean("Статус");
                baseTemp.add(new Zayav(id, tovar, kolich, stoim, fiozakaz, adress, telef, data, status));
            }
            
            for(int i=0; i<baseTemp.size(); i++){
                if(baseTemp.get(i).isStatus()==true)
                    rez += baseTemp.get(i).getKolich() * baseTemp.get(i).getStoim();
                else 
                    oji += baseTemp.get(i).getKolich() * baseTemp.get(i).getStoim();
            }
            rezu = String.valueOf(rez);
            ojid = String.valueOf(oji);
            rezult.add(rezu);
            rezult.add(ojid);
        } catch (SQLException se) {
            System.out.println ("SQLERROR " + se.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         return rezult;
    }
}
