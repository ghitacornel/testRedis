package tests;

import client.ClientReader;
import client.ClientWriter;
import org.junit.*;

public class TestSingleNode {

    private final ClientWriter writer = new ClientWriter();
    private final ClientReader reader = new ClientReader();

    @Before
    public void setUp() {
        writer.startClient();
        reader.startClient();
    }

    @After
    public void tearDown() {
        writer.stopClient();
        reader.stopClient();
    }

    @Test
    public void testSingleRead() {

        writer.writeDummyData();

        reader.readDummyData();

        Assert.assertEquals(writer.buildDummyData(), reader.readDummyData());

    }

    @Test
    public void testTwiceRead() {

        writer.writeDummyData();

        String data1 = reader.readDummyData();
        Assert.assertEquals(writer.buildDummyData(), data1);
        String data2 = reader.readDummyData();
        Assert.assertEquals(writer.buildDummyData(), data2);
        Assert.assertNotSame(data1, data2);

    }

    @Test
    public void testMultipleRead() {

        writer.writeDummyData();
        String dummyData = writer.buildDummyData();

        for (int i = 0; i < 100; i++) {
            String map = reader.readDummyData();
            Assert.assertEquals(dummyData, map);
        }

    }
}
