package ca.uhn.fhir.jpa.starter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class, properties = {
		"hapi.fhir.custom-bean-packages=some.custom.pkg1,some.custom.pkg2",
		"spring.datasource.url=jdbc:h2:mem:dbr4",
		// "hapi.fhir.enable_repository_validating_interceptor=true",
		"hapi.fhir.fhir_version=r4"
})
public class CustomBeanTest {

	static {
		System.setProperty("org.springframework.boot.logging.LoggingSystem", "none");
	}

	@Autowired
	some.custom.pkg1.CustomBean customBean1;

	@Test
	void testCustomBeanExists() {
		Assertions.assertNotNull(customBean1);
		Assertions.assertEquals("I am alive", customBean1.getInitFlag());
	}
}
