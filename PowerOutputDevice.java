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
// Basic code using Java to power an output device. Power on basic objects like an LED, Buzzer or Motor.
// in this example outputOne is an LED, but was tested with buzzer and LED both.


public class PowerOutputice{
    public static void main(String args[]) throws InterruptedException{
        final GpioController mainGpio = GpioFactory.getInstance(); // gets the RPI state of GPIO pins
        GpioPinDigitalOutput outputOne = mainGpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "OutputOne", PinState.HIGH); // telling program where to send signal for output
        outputOne.setShutdownOptions(true, PinState.LOW); 

        while(true){
            Thread.sleep(50);
        }
    }
}
