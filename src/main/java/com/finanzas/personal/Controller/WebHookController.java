package com.finanzas.personal.Controller;

import org.json.JSONObject;
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
    public void handleGitHubWebhook(@RequestBody String payload) {
        // Procesa la información del commit aquí
        JSONObject jsonPayload = new JSONObject(payload);

    		logger.info(payload);
    		String ref = jsonPayload.getString("ref");
    		System.out.println(ref);
    	  /*try {
    		  JSONObject json = new JSONObject(payload);
    	        JSONObject commit = json.getJSONObject("head_commit");
    	        System.out.println(payload);
    	        logger.info(payload);
    	        String mensajeCommit = commit.getString("message");
    	        String autorCommit = commit.getJSONObject("author").getString("name");
    	        // Envía una notificación a Telegram
    	        telegramNotificationService.enviarNotificacion("2005702056", "Se realizó un nuevo commit en el repositorio."+ autorCommit + ": " + mensajeCommit);
          } catch (Exception e) {
              // Registra el error en los registros
              logger.error("Ocurrió un error al procesar el webhook de GitHub", e);
          }*/
    	
    }
}
