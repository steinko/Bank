package org.steinko.bank.customer;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import  static net.logstash.logback.argument.StructuredArguments.keyValue;


public class CustomerDtoTest {
	/**
	 * Logger.
	 */
	private static Logger logger = 
			LoggerFactory.getLogger(CustomerControllerTest.class);
	
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Test
	public void shoulHaveACorrectDto() {
		logger.info("start unit test shoulHavACorrctDto " ,keyValue("category", "component"));
		Customer customer = new Customer("Stein Korsveien", 
				26076144574L, 1234L, 5678);
		CustomerDto customerDto = modelMapper.map(customer,CustomerDto.class);
		assertEquals(customer.getPersonId(), customerDto.getPersonId());
		logger.info("end unit test shoulHavACorrctDto " ,keyValue("category", "component"));
	}
	
	@Test
	public void shoulReturnDto() {
		logger.info("start unit test shoulReturnDto( " ,keyValue("category", "component"));
		CustomerDto customer = new CustomerDto(26076144574L);
		assertEquals(customer.toString(), "personId: 26076144574");
		logger.info("end unit test shoulReturnDto( " ,keyValue("category", "component"));
	}
	
	@Test
	public void shoulReturnpersonId() {
		logger.info("start unit test should houlReturnpersonId " ,keyValue("category", "component"));
		Long personId = 26076144574L;
		CustomerDto customer = new CustomerDto(personId);
		assertThat(customer.getPersonId(), equalTo(personId));
		logger.info("end unit test shoulReturnpersonId " ,keyValue("category", "component"));
	}

}
