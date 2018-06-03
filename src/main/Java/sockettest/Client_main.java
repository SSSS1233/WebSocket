package sockettest;

public class Client_main {
    public static void main(String[] args) {

        new Thread( new Client("localhost",9090)).start();
    }
}
