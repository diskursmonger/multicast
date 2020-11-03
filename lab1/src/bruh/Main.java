package bruh;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

public class Main {
    public static void detectPeer() throws IOException {
        InetAddress group = InetAddress.getByName("224.0.0.1");
        MulticastSocket socket = new MulticastSocket(8888);
        socket.joinGroup(group);
        PeerTable peerTable = new PeerTable();
        peerTable.add(group.toString());
        peerTable.print();
        String msg = "huy";
        DatagramPacket hi = new DatagramPacket(msg.getBytes(), msg.length(), group, 8888);
        socket.send(hi);

        byte[] buf = new byte[1000];
        DatagramPacket recv = new DatagramPacket(buf, buf.length);
        socket.receive(recv);
        System.out.println(Arrays.toString(buf));
    }
    public static void main(String[] args) throws IOException {
        detectPeer();
    }
}
