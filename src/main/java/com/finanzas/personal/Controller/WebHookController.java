package com.finanzas.personal.Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.finanzas.personal.Services.TelegramNotificationService;

@RestController
public class WebHookController {
	private final TelegramNotificationService telegramNotificationService;
    private static final Logger logger = LoggerFactory.getLogger(WebHookController.class);

    public WebHookController(TelegramNotificationService telegramNotificationService) {
        this.telegramNotificationService = telegramNotificationService;
    }

    @PostMapping("/github-webhook")
    public void handleGitHubWebhook(@RequestBody JSONObject payload) {
        
            // Puedes acceder a los campos directamente del objeto JSON
            String ref = payload.getString("ref");
            String before = payload.getString("before");
            String after = payload.getString("after");

            // Realiza las operaciones necesarias con los datos
            // ...

            logger.info(ref);
    }
    
}
