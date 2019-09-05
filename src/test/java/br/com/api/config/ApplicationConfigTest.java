package br.com.api.config;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.api.common.EntityMock;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationConfigTest {

	@InjectMocks
	private EntityMock entityMock;

	@Test
	public void contextLoads() throws MalformedURLException, IOException {

	}
}
