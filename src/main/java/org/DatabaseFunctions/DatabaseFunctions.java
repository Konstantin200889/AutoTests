package org.DatabaseFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseFunctions {


    /*
    // тестовый запрос к базе данных на выведение списка 100 пользователей

    public void NewSelectUsers ()
    {
        DatabaseFunctions databaseFunctions = new DatabaseFunctions(); // создаем новый объект класса
        databaseFunctions.selectUsers(); // вызываем для него метод selectUsers,
        // который соединяется с базой и выводит список 100 пользователей (согласно установленному лимиту)
    }
*/



    private String dbUrl;
    private String dbUser;
    private String dbPassword;



    public DatabaseFunctions() {
        // 1.подгружаем нужные данные из properties
        try (InputStream input = new FileInputStream("src/main/resources/settings.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            dbUrl = prop.getProperty("dbUrl"); // записываем подгруженные данные в соответствующие поля класса
            dbUser = prop.getProperty("dbUser");
            dbPassword = prop.getProperty("dbPassword");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    private Connection getDBConnection() {
        //2. С помощью этой части кода мы подгружаем драйвер из pom в этот класс подгружаем драйвер
        Connection dbConnection = null; // переменная, которая будет устанавливать соединение с БД (Connection - это тип данных из встроенной библиотеки JDBC)

        try {
            Class.forName("org.postgresql.Driver"); // подгружаем драйвер этой командой
            // когда мы подгружаем какие-то данные, java их автоматом предлагает обработать при помощи try\catch
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

//3. С помощью этой части кода мы устанавливаем связь с БД
        try {
            dbConnection = DriverManager.getConnection(dbUrl, dbUser, dbPassword); // через метод getConnection передаем данные (в скобках)
        } catch (SQLException e) { // java также автоматом предлагает обработать при помощи try\catch
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }



// 4. метод, с помощью которого будем отправлять базе данных конкретный запрос для получения нужных данных
public ResultSet selectUsers()
{
    ResultSet resultSet = null;  // специальный встроенный в Java тип для работы с БД, который возвращает нужный результат


    try {
        String query = "SELECT * FROM public.users ORDER BY id LIMIT 100";

        Connection dbConnection = getDBConnection(); // используем установленное на предыдущем шаге соединение
        Statement statement = dbConnection.createStatement(); // statement - специальный встроенный в Java тип для работы с БД, в который мы сохраняем наш запрос и отправляем БД

        resultSet = statement.executeQuery(query); // .executeQuery(query) - выполняем запрос, в скобках передаем строку, записанную в переменную query

        while (resultSet.next()) // rs.next - это встроенный в  тип ResultSet метод, который дает команду перейти к следующей строке, пока строки не закончатся
        {
            String userId = resultSet.getString("id"); // вытаскиваем из каждой строки БД id пользователя
            String userName = resultSet.getString("name"); // вытаскиваем из каждой строки БД name пользователя

            System.out.println("userId: " + userId); // выводим в консоль
            System.out.println("userName: " + userName);
        }
    }
    catch (SQLException e)
    {
       System.out.println(e.getMessage());
    }
    return resultSet;
}

}

