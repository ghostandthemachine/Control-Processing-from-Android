package com.android.processing.app;

import processing.core.PApplet;
import android.util.Log;


public class PFrag extends PApplet {
	/**
	 * Rotate. 
	 * 
	 * Rotating a square around the Z axis. To get the results
	 * you expect, send the rotate function angle parameters that are
	 * values between 0 and PI*2 (TWO_PI which is roughly 6.28). If you prefer to 
	 * think about angles as degrees (0-360), you can use the radians() 
	 * method to convert your values. For example: scale(radians(90))
	 * is identical to the statement scale(PI/2). 
	 */

	float angle;
	float jitter;
	float red, green, blue, alpha;

	public void setup() {
	  size(200, 200);
	  smooth();
	  noStroke();
	  fill(255);
	  rectMode(CENTER);
	  frameRate(30);
	  red = green = blue = 0;
	  alpha = 255;
	}

	public void draw() {
	  background(255);

	  // during even-numbered seconds (0, 2, 4, 6...)
	  if (second() % 2 == 0) {  
	    jitter = random(-0.1f, 0.1f);
	  }
	  angle = angle + jitter;
	  float c = cos(angle);
	  translate(width/2, height/2);
	  rotate(c);
	  fill(red, green, blue, alpha);
	  rect(0, 0, 220, 220);  
	}

	/**
	 * @return the red
	 */
	public float getRed() {
		return red;
	}

	/**
	 * @param red the red to set
	 */
	public void setRed(float red) {
		this.red = red;
	}

	/**
	 * @return the green
	 */
	public float getGreen() {
		return green;
	}

	/**
	 * @param green the green to set
	 */
	public void setGreen(float green) {
		this.green = green;
	}

	/**
	 * @return the blue
	 */
	public float getBlue() {
		return blue;
	}

	/**
	 * @param blue the blue to set
	 */
	public void setBlue(float blue) {
		this.blue = blue;
	}

	/**
	 * @return the alpha
	 */
	public float getAlpha() {
		return alpha;
	}

	/**
	 * @param alpha the alpha to set
	 */
	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

    
}

