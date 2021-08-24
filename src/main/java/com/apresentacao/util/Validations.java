package com.apresentacao.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.springframework.stereotype.Component;


@Component
public class Validations {

	public Boolean ValidateCarton(String carton) {
		return carton.replace(".", "").replace("-", "").length() == 16;
	}
	
	public Boolean ValidateCPF(String cpf) {
		return cpf.replace(".", "").replace("-", "").length() == 11;
	}
	
	public Boolean ValidateEmail(String email) {
		return email.contains("@");
	}
	
	public static String FormatDouble(int qtd, Double value) {
		NumberFormat fmt = DecimalFormat.getNumberInstance();
		fmt.setMaximumFractionDigits(qtd);
		fmt.setRoundingMode(RoundingMode.DOWN);
	    return fmt.format(value); 
	}
}
