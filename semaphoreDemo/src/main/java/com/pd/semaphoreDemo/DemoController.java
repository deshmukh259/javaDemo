package com.pd.semaphoreDemo;


import com.pd.semaphoreDemo.response.Respo;
import com.pd.semaphoreDemo.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {


    private final static List<Respo> waitingList = new ArrayList<>();
    private final OrderService orderService;

    public DemoController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/waiting-req")
public List<Respo> getWaiting(){

        return waitingList;

    }


    @GetMapping("/order/{id}")
    public String addOrder(@PathVariable Integer id){
        Respo e = new Respo(id);
        waitingList.add(e);
        String s = orderService.addOrder(id);
        waitingList.remove(e);
        return s;
    }

    @GetMapping("/file")
    public String sendFile(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");
        File file  = new File("/Users/apple/Downloads/10MB.txt");
        response.setHeader(
                "Content-Disposition",
                "attachment; filename=\"" + file.getName() + "\""
        );

        response.setContentLengthLong(file.length());

        try (
                FileChannel fileChannel =
                        FileChannel.open(
                                file.toPath(),
                                StandardOpenOption.READ
                        );

                WritableByteChannel outChannel =
                        java.nio.channels.Channels.newChannel(
                                response.getOutputStream()
                        )
        ) {

            long position = 0;
            long count = fileChannel.size();

            while (position < count) {

                long transferred =
                        fileChannel.transferTo(
                                position,
                                count - position,
                                outChannel
                        );

                position += transferred;
            }
        }
        return "";
    }






}
