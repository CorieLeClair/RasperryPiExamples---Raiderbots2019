import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import java.util.concurrent.Callable;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.trigger.GpioCallbackTrigger;
import com.pi4j.io.gpio.trigger.GpioPulseStateTrigger;
import com.pi4j.io.gpio.trigger.GpioSetStateTrigger;
import com.pi4j.io.gpio.trigger.GpioSyncStateTrigger;


// Corie LeClair example code for RPI3 - Raiderbots 2019
// Basic code using Java to check for input from RPI and do an action. 
// Used button and LED to test 
// outputOne is an LED
// inputOne is a button

public class InputListenerBasic{
    public static void main(String args[]) throws InterruptedException{
        // final means the value will not change
        final GpioController mainGpio = GpioFactory.getInstance(); // gets the RPI state of GPIO pins
        final GpioPinDigitalInput inputOne = mainGpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN); // telling program where and how to collect input
        GpioPinDigitalOutput outputOne = mainGpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "OutputOne", PinState.LOW); // telling program where to send signal for output // also tells program to start with voltage low/off
        outputOne.setShutdownOptions(true, PinState.LOW); // tells the program to set voltage low/off when program is shutdown

        inputOne.addListener(new GpioPinListenerDigital() { // listens for any time the voltage from an input changes
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event){ // does things when voltage changes
                System.out.print("Input button has been activated");
                outputOne.toggle();
                // to make the outputOne on a timer use outputOne.pulse(time);
            }
        });

        while(true){ // runs as long as the application is running
            Thread.sleep(50); // refresh application rate
            // delete Thread.sleep() if no time is needed between refresh!
        }

    }
}
