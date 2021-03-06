package name.antonsmirnov.firmata.tests;

import name.antonsmirnov.firmata.message.ReportFirmwareVersionMessage;
import name.antonsmirnov.firmata.serial.SerialException;
import name.antonsmirnov.firmata.writer.SysexMessageWriter;
import org.junit.Test;

import java.util.Arrays;

/**
 * Test for ReportFirmwareVersionMessage
 */
public class ReportFirmwareVersionMessageTest extends BaseFirmataTest {

    @Test
    public void testWrite() throws SerialException {
        serial.clear();
        ReportFirmwareVersionMessage message = new ReportFirmwareVersionMessage();
        firmata.send(message);

        byte[] expected_output = new byte[] {
                (byte)SysexMessageWriter.COMMAND_START,
                (byte)ReportFirmwareVersionMessage.COMMAND,
                (byte)SysexMessageWriter.COMMAND_END
        };

        byte[] actual_output = serial.getOutputStream().toByteArray();
        assertTrue(Arrays.equals(expected_output, actual_output));
    }

}
