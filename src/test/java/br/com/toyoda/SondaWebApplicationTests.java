package br.com.toyoda;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SondaWebApplication.class)
public class SondaWebApplicationTests {

	@Test
	public void contextLoads() {
		Assert.assertEquals(true, true);
	}
}
