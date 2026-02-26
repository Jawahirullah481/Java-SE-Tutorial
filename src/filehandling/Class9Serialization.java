package filehandling;

import filehandling.handler.FileHandler;

import java.io.*;

public class Class9Serialization extends FileHandler {

    @Override
    public void execute() {

        //serialize();
        deserialize();

    }

    private void serialize() {
        User user = new User(1, "Jawahir", "1234");
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("resources/file-handling/file9.txt"))) {

            writer.writeObject(user);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deserialize() {
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("resources/file-handling/file9.txt"))) {

            User user = (User)reader.readObject();

            System.out.println("Saved User Details : ");
            System.out.println("User Id : " + user.id + "\n" + "Username : " + user.username + "\n" + "Password : " + user.password);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class User implements Serializable {
        int id;
        String username;
        String password;

        User(int id, String username, String password) {
            super();
            this.id = id;
            this.username = username;
            this.password = password;
        }
    }

}
