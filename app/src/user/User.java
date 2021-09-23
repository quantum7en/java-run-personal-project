package user;

import java.io.*;
import java.net.Socket;

//todo if we will have more than 1 user, put them in List, identify them by id or email

public class User {
    private final BufferedReader in;
    private final BufferedWriter out;
    private Long id;
    private String email;

    public User(Socket socket, Long id, String email) throws IOException {
        this.id = id;
        this.email = email;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
