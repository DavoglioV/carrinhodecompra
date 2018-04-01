package br.com.carrinhodecompra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//fiz uma alteração
@SpringBootApplication
public class CarrinhoDeCompraApplication {
	@RequestMapping("/")
    @ResponseBody
    String home() {
      return "Hello World!";
    }
	public static void main(String[] args) {
		SpringApplication.run(CarrinhoDeCompraApplication.class, args);
	}
}
