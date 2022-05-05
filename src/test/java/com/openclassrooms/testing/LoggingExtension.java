package com.openclassrooms.testing;

import java.lang.reflect.InvocationTargetException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

public class LoggingExtension implements TestInstancePostProcessor {

	@Override
	public void postProcessTestInstance(Object testInstance,
			ExtensionContext context) {

		Logger logger = LogManager.getLogger(testInstance.getClass());

		try {
			testInstance.getClass()
					.getMethod("setLogger", Logger.class)
					.invoke(testInstance, logger);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.lang.NoSuchMethodException e) {
			// TODO Auto-generated catch block
			System.out.println("Ce n’est pas une méthode, c’est une classe !");
			// e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}