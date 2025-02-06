public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // CRITICAL SQL INJECTION VULNERABILITY: Concatenating user input directly into SQL query
        String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                System.out.println("Login successful! Welcome, " + username);
            } else {
                System.out.println("Invalid credentials.");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
