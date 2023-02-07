package com.virtusa.hotelreserve.paymentservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.hotelreserve.entity.MetaPayment;
import com.virtusa.hotelreserve.entity.Payment;
import com.virtusa.hotelreserve.entity.Status;
import com.virtusa.hotelreserve.paymentrepository.MetaPaymentRepository;
import com.virtusa.hotelreserve.paymentrepository.PaymentRepository;
import com.virtusa.hotelreserve.userservice.UserServiceImpl;

@Service
public class PaymentServiceImpl implements PaymentService
{
	Logger logger=LoggerFactory.getLogger(PaymentServiceImpl.class);
		@Autowired
		PaymentRepository paymentRepo;
		
		@Autowired
		MetaPaymentRepository metapaymentRepo;
		
		@Override
		public void addMetaPayment(MetaPayment metapayment) 
		{
			if(metapaymentRepo.existsByUpiId(metapayment.getUpiId()))
				logger.info("Metapayment Data Already Exists, You are not Authorized to add it again.!!");
			if(metapaymentRepo.existsByUpiId(metapayment.getCardNumber()))
				logger.info("Metapayment Data Already Exists, You are not Authorized to add it again.!!");
			
			metapaymentRepo.saveAndFlush(metapayment);

		}

		@Override
		public void addPaymentByCard(Payment payment)
		{

			String rNumber=payment.getCardNumber();
			int rCvv=payment.getCvv();

			MetaPayment paymentBean=metapaymentRepo.validateCredentialsForCard(rNumber);
			if(paymentBean==null)
			{
				payment.setPaymentStatus(Status.FAILED);
				paymentRepo.saveAndFlush(payment);
				logger.info("Metapayment Data Doesn't Exists.!!");
			}
			if(paymentBean.getCvv()!=rCvv)
			{
				payment.setPaymentStatus(Status.FAILED);
				paymentRepo.saveAndFlush(payment);
				logger.info("Metapayment Data Didn't Match, Wrong Credentials.!!");
			}
			else	
			{
				payment.setPaymentStatus(Status.SUCCESSFULL);
				paymentRepo.saveAndFlush(payment);
			}
		}


		@Override
		public void addPaymentByUpi(Payment payment) 
		{

			String rUpi=payment.getUpiId();
			int rUpiPin=payment.getUpiPin();

			boolean upiIdBean=metapaymentRepo.existsByUpiId(rUpi);
			boolean upiPinBean=metapaymentRepo.existsByUpiPin(rUpiPin);

			if(upiIdBean!=true||upiPinBean!=true)
			{
				payment.setPaymentStatus(Status.FAILED);
				paymentRepo.saveAndFlush(payment);
				logger.info("Metapayment Data Didn't Match, Wrong Credentials.!!");
			}
			else
			{
				payment.setPaymentStatus(Status.SUCCESSFULL);
				paymentRepo.saveAndFlush(payment);
			}
			
		}
		@Override
		public void deletePaymentById(int id)
		{
			paymentRepo.deleteById(id);

		}
}

