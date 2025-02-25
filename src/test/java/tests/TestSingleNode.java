package tests;

import client.ClientReader;
import client.ClientWriter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSingleNode {

    private final ClientWriter writer = new ClientWriter();
    private final ClientReader reader = new ClientReader();

    @BeforeEach
    public void setUp() {
        writer.startClient();
        reader.startClient();
    }

    @AfterEach
    public void tearDown() {
        writer.stopClient();
        reader.stopClient();
    }

    @Test
    public void testSingleRead() {

        writer.writeDummyData();

        reader.readDummyData();

        Assertions.assertEquals(writer.buildDummyData(), reader.readDummyData());

    }

    @Test
    public void testTwiceRead() {

        writer.writeDummyData();

        String data1 = reader.readDummyData();
        Assertions.assertEquals(writer.buildDummyData(), data1);
        String data2 = reader.readDummyData();
        Assertions.assertEquals(writer.buildDummyData(), data2);
        Assertions.assertNotSame(data1, data2);

    }

    @Test
    public void testMultipleRead() {

        writer.writeDummyData();
        String dummyData = writer.buildDummyData();

        for (int i = 0; i < 100; i++) {
            String map = reader.readDummyData();
            Assertions.assertEquals(dummyData, map);
        }

    }
}
