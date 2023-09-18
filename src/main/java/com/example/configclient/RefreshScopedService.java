package com.example.configclient;

import lombok.Data;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
@RefreshScope
@Data
public class RefreshScopedService {

    @Value("#{'yes'.equals('${prop-6:false}')}")
    private Boolean prop6;

    @Value("${tps}")
    Integer tps;
    String responseMessage;

    @Autowired
    EnvUtil util;

    @PostConstruct
    public void refresh(){
        responseMessage = responseMessage = "Service is running with tps: " + tps;
    }

//   @Scheduled(fixedRate = 100000)
//    public void refreshProperties() throws IOException {
//
//       String url = util.getServerUrlPrefi()+"/actuator/refresh";
//       System.out.println("calling refresh endpoint " + url);
//
//       OkHttpClient client = new OkHttpClient().newBuilder()
//               .build();
//       MediaType mediaType = MediaType.parse("text/plain");
//       RequestBody body = RequestBody.create(mediaType, "");
//       Request request = new Request.Builder()
//               .url(url)
//               .method("POST", body)
//               .build();
//       Response response = client.newCall(request).execute();
//        System.out.println("call actuator endpoint to update the value ");
//    }

}
