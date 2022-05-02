package com.OrangeHRMAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import CyberSuccess.com.org.BaseClass;

public class RoboImplementations extends BaseClass {

	public static void main(String[] args) throws AWTException {
		
		getBrowserInstance("Chrome");
		
		driver.navigate().to("https://www.amazon.in/");
		
		Robot robot = new Robot();
		
		//Key press and key release operations using keyPress() and keyRelease()
		//robot.keyPress(KeyEvent.VK_DOWN);
		//robot.keyRelease(KeyEvent.VK_DOWN);
		
		//Mouse right click operation using mousePress() and mouseRelease()
		//robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		//robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		
		//Mouse left click operation using mousePress() and mouseRelease()
		//robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		//robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		//Mouse scroll operation using mouseWheel() to scroll down [+ve value] and scroll up [-ve value]
		robot.mouseWheel(100);
		robot.mouseWheel(-20);
		
		
		
		
		
		
	}

}
