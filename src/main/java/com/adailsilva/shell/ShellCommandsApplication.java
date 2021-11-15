package com.adailsilva.shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShellCommandsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShellCommandsApplication.class, args);
		try {
//			Process process = Runtime.getRuntime().exec("ping www.google.com");
			Process process = Runtime.getRuntime().exec("ngrok start --none");
			printResults(process);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printResults(Process process) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

	}
}
