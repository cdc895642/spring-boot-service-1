package com.example.boot.springbootservice1;

import com.example.boot.springbootservice1.dto.User;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUser(String name) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String hostname = ip == null ? "" : ip.getHostName();
        return new User(
            name + " - " + Thread.currentThread().getName() + " - " + ip + " - " + hostname);
    }
}
