package com.virtusa.hotelreserve.paymentrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virtusa.hotelreserve.entity.MetaPayment;

public interface MetaPaymentRepository extends JpaRepository<MetaPayment,Integer>
{
	@Query("SELECT m FROM MetaPayment m WHERE m.cardNumber LIKE :cNumber")
	public MetaPayment validateCredentialsForCard(@Param("cNumber")String cNumber);
	
    public boolean existsByUpiId(String rUpi);
    
    public boolean existsByUpiPin(int pin);
}
