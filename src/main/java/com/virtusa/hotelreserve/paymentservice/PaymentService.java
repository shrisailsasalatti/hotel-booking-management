package com.virtusa.hotelreserve.paymentservice;

import com.virtusa.hotelreserve.entity.MetaPayment;
import com.virtusa.hotelreserve.entity.Payment;

public interface PaymentService {
	
	public void addMetaPayment(MetaPayment metapayment);
	public void addPaymentByCard(Payment payment);
	public void addPaymentByUpi(Payment payment);
	public void deletePaymentById(int id);
}
