package com.practica;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.practica.model.Usuario;
import com.practica.repo.UsuarioRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SistemaPracticaApplicationTests {

	@Autowired
	private UsuarioRepo repo;
	
	@Test
	public void crearUsuarioTest() {
		Usuario us = new Usuario();
		us.setId(0);
		us.setNombre("asd");
		us.setClave("holamundo");
		Usuario retorno = repo.save(us);
		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
	}

}
