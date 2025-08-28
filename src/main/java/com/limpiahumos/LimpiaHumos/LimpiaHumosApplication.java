package com.limpiahumos.LimpiaHumos;

import com.limpiahumos.LimpiaHumos.DAO.MetasDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;




@SpringBootApplication
@EnableTransactionManagement
public class LimpiaHumosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimpiaHumosApplication.class, args);
	}

	@Autowired
	MetasDAO metasDAO;



}
