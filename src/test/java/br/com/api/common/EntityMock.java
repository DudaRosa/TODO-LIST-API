package br.com.api.common;

import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class EntityMock {

	private static final String SRC_TEST_RESOURCES = "src/test/resources/";

	private static Logger log = LogManager.getLogger(EntityMock.class);

	public static <T> T setEntityMock(String file, Class<T> entity) {
		ObjectMapper mapper = new ObjectMapper();
		FileReader fileReader;
		T readValue = null;
		try {
			fileReader = new FileReader(SRC_TEST_RESOURCES + file);
			readValue = mapper.readValue(fileReader, entity);
		} catch (Exception e) {
			log.error("Erro ao resuperar o arquivo json para o mock: " + e.getMessage(), e);
		}

		return readValue;
	}

}
