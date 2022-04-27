package org.steinko.bank.customer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.modelmapper.ModelMapper;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerDtoTest {
	/**
	 * Logger.
	 */
	private static Logger logger = 
			LoggerFactory.getLogger(CustomerControllerTest.class);
	
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Test
	public void shoulHaveACorrectDto() {
		logger.info("start unit test shoulHavACorrctDto ");
		Customer customer = new Customer("Stein Korsveien", 
				26076144574L, 1234L, 5678);
		CustomerDto customerDto = modelMapper.map(customer,CustomerDto.class);
		assertEquals(customer.getPersonId(), customerDto.getPersonId());
		logger.info("end unit test shoulHavACorrctDto " );
	}
	
	@Test
	public void shoulReturnDto() {
		logger.info("start unit test shoulReturnDto( " );
		CustomerDto customer = new CustomerDto(26076144574L);
		assertEquals(customer.toString(), "personId: 26076144574");
		logger.info("end unit test shoulReturnDto");
	}
	
	@Test
	public void shoulReturnpersonId() {
		logger.info("start unit test should houlReturnpersonId " );
		Long personId = 26076144574L;
		CustomerDto customer = new CustomerDto(personId);
		assertThat(customer.getPersonId(), equalTo(personId));
		logger.info("end unit test shoulReturnpersonId ");
	}

}
