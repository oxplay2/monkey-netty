package io.tlf.monkeynetty.test;

import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import io.tlf.monkeynetty.MessageListener;
import io.tlf.monkeynetty.NetworkClient;
import io.tlf.monkeynetty.NetworkRegistrar;
import io.tlf.monkeynetty.NetworkServer;
import io.tlf.monkeynetty.client.NettyClient;
import io.tlf.monkeynetty.msg.NetworkMessage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JmeClient extends SimpleApplication {

    @Override
    public void simpleInitApp() {
        NettyClient client = new NettyClient("test", true, 10000, "localhost");
        stateManager.attach(client);
        client.registerListener(new MessageListener() {
            @Override
            public void onMessage(NetworkMessage msg, NetworkServer server, NetworkClient client) {
                System.out.println("Got message " + msg);
            }

            @Override
            public Class<? extends NetworkMessage>[] getSupportedMessages() {
                return new Class[] {TestTCPMessage.class, TestUDPMessage.class};
            }
        });

        inputManager.addMapping("enter", new KeyTrigger(KeyInput.KEY_RETURN));
        inputManager.addListener((ActionListener) (name, isPressed, tpf) -> {
            if (isPressed) {
                client.send(new TestTCPMessage());
            }
        }, "enter");
        inputManager.addMapping("space", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addListener((ActionListener) (name, isPressed, tpf) -> {
            if (isPressed) {
                client.send(new TestUDPMessage());
            }
        }, "space");
    }

    @Override
    public void simpleUpdate(float tpf) {

    }

    public static void main(String[] args) {
        Logger.getLogger(NetworkRegistrar.class.getName()).setLevel(Level.FINE);
        Logger.getLogger(NetworkClient.class.getName()).setLevel(Level.FINE);
        JmeClient client = new JmeClient();
        client.start();
    }
}
