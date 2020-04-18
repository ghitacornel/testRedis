package client;

public class ClientWriter extends ClientTemplate {

    public void writeDummyData() {
        client.set(key, buildDummyData());
    }

    public String buildDummyData() {
        return "data " + this;
    }
}
