package org.challenge;

public class Home {

    final MySocket socket;

    public Home(MySocket socket) {
        this.socket = socket;
    }

    public void connect() {
        socket.connect();
    }

    public static void main(String[] args) {
        Home h = new Home(new DanSang());
        h.connect();
    }
}
class SamSung implements MySocket {

    @Override
    public void connect() {
        System.out.println("SamSung connect");
    }
}

class DanSang implements MySocket {

    @Override
    public void connect() {
        System.out.println("dansang connect");
    }
}

interface MySocket {
    void connect();
}

