package com.dmdev.injecao_dependencia;

import com.dmdev.injecao_dependencia.entities.Order;
import com.dmdev.injecao_dependencia.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class InjecaoDependenciaApplication implements CommandLineRunner {

	@Autowired
	OrderService orderService;

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		SpringApplication.run(InjecaoDependenciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.print("Order code: ");
		int code = sc.nextInt();
		System.out.print("Basic Value: ");
		double basic = sc.nextDouble();
		System.out.print("Discount Value: ");
		double discount = sc.nextDouble();

		System.out.println();
		Order order = new Order(code, basic, discount);
		System.out.print("Pedido código " + order.getCode());
		System.out.println("\nValor total: R$ " + String.format("%.2f", orderService.total(order)));

		sc.close();
	}
}
