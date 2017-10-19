package se.sbab.kafkademo;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkademoApplicationTests {
	private static String BOOT_TOPIC = "tnt-test";

	@Autowired
	private Sender sender;

	@Test
	public void testSend() {
		//sender.send(BOOT_TOPIC, "Hello Boot!");
	}
}