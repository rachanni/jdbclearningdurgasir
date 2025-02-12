package jdbcapplication;

public class CheckConnector {
    public static void main(String[] args) {
        try {
            // Attempt to load the Connector/J driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL Connector/J is available in the classpath.");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Connector/J is NOT found in the classpath.");
            e.printStackTrace();
        }
    }
}