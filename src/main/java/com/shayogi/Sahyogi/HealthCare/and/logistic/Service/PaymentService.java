package com.shayogi.Sahyogi.HealthCare.and.logistic.Service;


import com.shayogi.Sahyogi.HealthCare.and.logistic.RequestAndResponse.PaymentRequest;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    Session payment(PaymentRequest paymentRequest) throws StripeException;
}