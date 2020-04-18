package client;

public class ClientReader extends ClientTemplate {

    public String readDummyData() {
        return client.get(key);
    }

}
