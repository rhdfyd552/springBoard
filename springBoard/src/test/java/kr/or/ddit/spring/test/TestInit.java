package kr.or.ddit.spring.test;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/spring/application-context.xml",
			"classpath:kr/or/ddit/spring/context-datasource.xml",
			"classpath:kr/or/ddit/spring/context-transaction.xml"})

public class TestInit {
	
	/*@Before
	public void setup(){
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("kr/or/ddit/db/initDb.sql"));
		populator.setContinueOnError(false);
		
		BasicDataSource datasource = new BasicDataSource();
		datasource.setUrl("jdbc:oracle:thin:@192.168.0.11:1521:XE");
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");*/
		//*****************운영계정인지 반드시 확인***************************/
		/*datasource.setUsername("pc12");
		datasource.setPassword("java");
		
		DatabasePopulatorUtils.execute(populator, datasource);
	}*/
}
