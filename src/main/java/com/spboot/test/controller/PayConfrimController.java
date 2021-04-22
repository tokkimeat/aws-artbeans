package com.spboot.test.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PayConfrimController {

	@PostMapping("/pay/confirm")
	public void confirm(@RequestBody Map<String, Object> param) {
		log.info("iamport callback param=>{}", param);
	}

	public static void main(String[] args) {
		IamportClient client = new IamportClient("2202102371550303",
				"P57wl8MCqPQxV8RCjn8lGdH6Utp0gWI62PCoXp0ofRVa0MNjaWFQ9nX3Qm47jMdlCQJAfKZuBUFCHsWR");
		try {
			IamportResponse<Payment> response = client.paymentByImpUid("imp_195535653226");
			Payment payment = response.getResponse();
			log.info("payment=>{}", payment.getAmount());
			if(!payment.getAmount().equals(new BigDecimal(1500))) {
				CancelData cd = new CancelData("imp_195535653226", true);
				IamportResponse<Payment> cPayment = client.cancelPaymentByImpUid(cd);
				log.info("cPay=>{}",cPayment.getResponse().getCancelAmount());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IamportResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
