package com.finanzas.personal.Services;

import org.springframework.stereotype.Service;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Service
public class TelegramNotificationService extends TelegramLongPollingBot{

	@Override
	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		 return "TuNombreDeBot";
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "6448013861:AAELPPPc_AVwfnpH4_Yw49hFudnx6i8Y9rI";
	}
	
	 public void enviarNotificacion(String chatId, String mensaje) {
	        SendMessage message = new SendMessage();
	        message.setChatId(chatId);
	        message.setText(mensaje);

	        try {
	            execute(message);
	        } catch (TelegramApiException e) {
	            e.printStackTrace();
	        }
	    }

	   
	}


