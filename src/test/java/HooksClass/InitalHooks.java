package HooksClass;

import java.io.File;
import java.io.IOException;

import org.Base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class InitalHooks extends BaseClass{
	
@Before
public void initialFb() {
	 browser("chrome");
	    windowMax();
	  
}
@After	
public void screenTake() throws IOException {
	String name;
	screenshot(new File("C:\\Users\\Hp\\eclipse-workspace2\\"
			+ "FB\\target\\name.png"));

	quit();
}
}
