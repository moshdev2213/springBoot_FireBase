package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
//
//import com.google.api.client.util.Objects;

@SpringBootApplication
public class SbFireBaseApplication {

	public static void main(String[] args) throws IOException {
		ClassLoader classLoader = SbFireBaseApplication.class.getClassLoader();

		File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
		FileInputStream serviceaccount = new FileInputStream(file.getAbsolutePath());

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceaccount)).build();

		FirebaseApp.initializeApp(options);

		SpringApplication.run(SbFireBaseApplication.class, args);
	}

}
