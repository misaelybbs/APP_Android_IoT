package com.amse.tt_2019_b087.iot.mail;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class ConectorMySQL {

    public String customerData() {
        String customerInfo = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tt2019-b087", "root", "root");
            //Find customer information where the customer ID is maximum
            //PreparedStatement statement = con.prepareStatement("SELECT * FROM customers WHERE C_ID = (SELECT MAX(C_ID) FROM customers)");
            PreparedStatement statement = con.prepareStatement("SELECT password FROM user WHERE userName = " + " +");
            ResultSet result = statement.executeQuery();


            /*
            CREATE TABLE customers(
name varchar(20),
C_ID int NOT NULL AUTO_INCREMENT,
address  varchar(20),
email varchar(50),
PRIMARY KEY(C_ID)
);

3. Populate the database

INSERT INTO customers(name,address,email)
VALUES ('Chathura','221B,Akuressa','priyankarahac@gmail.com');

            * */
            while (result.next()) {
                customerInfo = customerInfo + result.getString("name") + "&" + result.getString("C_ID") + "&" + result.getString("address") + "&" + result.getString("email");
                //Here "&"s are added to the return string. This is help to split the string in Android application
            }
        } catch (
                Exception exc) {
            System.out.println(exc.getMessage());
        }

        return customerInfo;
    }

}



