package com.example.demo3;

import com.example.demo3.dao.HibernateLopDAO;
import com.example.demo3.dao.LopDAO;
import com.example.demo3.model.Lop;
import com.example.demo3.model.SinhVien;
import com.example.demo3.util.HibernateUtils;
import org.hibernate.Session;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Named(value = "bean")
@SessionScoped
public class Bean implements Serializable {

    private String message = "Hello world from Tuan";

    public String getMessage() {
        return message;
    }

    public String tesTDB() {
        try {
            StringBuilder stringBuilder = new StringBuilder("");
            Connection connection = TestDB.connect();
            String query = "SELECT * from student";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                stringBuilder.append(resultSet.getString("student_name"));
                stringBuilder.append(" ");

            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Default";
    }

    public String testDB2() {
        LopDAO lopDAO = new HibernateLopDAO();
        System.out.println("Hello world");
//        Lop lopDemo = new Lop();
//        lopDemo.setName("12A3");
//        lopDAO.themLop(lopDemo);

        List<Lop> lopList = lopDAO.getAllLop();

        System.out.println("Lop size" + lopList.size());
        for (Lop lop : lopList) {
            System.out.printf(lop.getName());
        }
        return "Hello world";
    }
}
