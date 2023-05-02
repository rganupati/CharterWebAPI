package com.charter.assessment.CharterWebAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.charter.assessment.CharterWebAPI.entity.CustomerEntity;
import com.charter.assessment.CharterWebAPI.entity.TransactionEntity;
import com.charter.assessment.CharterWebAPI.model.CustomerRewardsModel;
import com.charter.assessment.CharterWebAPI.model.RewardsModel;
import com.charter.assessment.CharterWebAPI.model.TransactionModel;
import com.charter.assessment.CharterWebAPI.repository.CustomerRepo;
import com.charter.assessment.CharterWebAPI.repository.TransactionRepo;
import com.charter.assessment.CharterWebAPI.service.RewardsService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CharterWebApiApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
    private RewardsService rewardsService;
	
	@MockBean
	private TransactionRepo transactionRepo;
	
	@MockBean
	private CustomerRepo customerRepo;
	

	@Test
	public void getRewardsTest() {
		try {
			CustomerEntity customer = new CustomerEntity();
			customer.setCustomerId(555L);
			customer.setCustomerName("ABC");
			customer.setGender("O");
			TransactionEntity transaction = new TransactionEntity();
			transaction.setCustomerId(555L);
			transaction.setTransactionAmount(70L);
			transaction.setTransactionDate(null);
			transaction.setTransactionId(1000L);
			
			when(customerRepo.findAll()).thenReturn(Stream.of(customer).collect(Collectors.toList()));
			when(transactionRepo.findAllByCustomerId(customer.getCustomerId())).thenReturn(Stream.of(transaction).collect(Collectors.toList()));
			
			Long expectedValue = 20L;
			List<CustomerRewardsModel> actualValue = rewardsService.getRewards();
			System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue.get(0).getTotalRewards());
			assertEquals(expectedValue, actualValue.get(0).getTotalRewards());
		} catch (Exception exception) {
			exception.printStackTrace();
			assertFalse(false);
		}
	}

	@Test
	public void getRewardsByCustomerIdTest() {
		try {
			
			CustomerEntity customer = new CustomerEntity();
			customer.setCustomerId(555L);
			customer.setCustomerName("ABC");
			customer.setGender("O");
			
			TransactionEntity transaction = new TransactionEntity();
			transaction.setCustomerId(555L);
			transaction.setTransactionAmount(120L);
			transaction.setTransactionDate(null);
			transaction.setTransactionId(1000L);
			
			when(customerRepo.findById(customer.getCustomerId())).thenReturn(Optional.of(customer));
			when(customerRepo.findAll()).thenReturn(Stream.of(customer).collect(Collectors.toList()));
			when(transactionRepo.findAllByCustomerIdAndTransactionDateBetween(any(),any(),any())).thenReturn(Stream.of(transaction).collect(Collectors.toList()));
			
			Long expectedValue = 90L;
			RewardsModel actualValue = rewardsService.getRewardsByCustomerId(customer.getCustomerId());
			System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue.getCurrentMonthRewardPoints());
			assertEquals(expectedValue, actualValue.getCurrentMonthRewardPoints());
		} catch (Exception exception) {
			exception.printStackTrace();
			assertFalse(false);
		}
	}

	@Test
	public void getTransacitonsTest() {
		try {
			
			TransactionEntity transaction = new TransactionEntity();
			transaction.setCustomerId(555L);
			transaction.setTransactionAmount(130L);
			transaction.setTransactionDate(null);
			transaction.setTransactionId(1000L);
			when(transactionRepo.findAllByOrderByCustomerIdAsc()).thenReturn(Stream.of(transaction).collect(Collectors.toList()));
			
			Long expectedValue = 555L;
			Long expectedTransAmount = 130L;
			
			List<TransactionModel> actualTrans = rewardsService.getTransacitons();
			assertEquals(1,actualTrans.size());
			assertEquals(expectedValue, actualTrans.get(0).getCustomerId());
			assertEquals(expectedTransAmount, actualTrans.get(0).getTransactionAmount());
		} catch (Exception exception) {
			exception.printStackTrace();
			assertFalse(false);
		}
	}

}
