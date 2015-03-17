package org.ros.android.android_tutorial_pubsub;

import org.apache.commons.logging.Log;
import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.NodeMain;
import org.ros.node.topic.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;

//It is also possible to subscribe to a particular parameter using a ParameterListener

/**
 * Created by ferran on 04.03.15.
 */

/**
 * A simple {@link Subscriber} {@link NodeMain}.
 *
 * @author damonkohler@google.com (Damon Kohler)
 */
public final class Listener extends AbstractNodeMain {

    private Character letter;
    //We should create the map structure to store the distances
    static private HashMap<Character, ArrayList<Double>> distances = new HashMap<Character, ArrayList<Double>>();

    @Override
    public GraphName getDefaultNodeName() {
        return GraphName.of("rosjava_tutorial_pubsub/listener");
    }

    @Override
    public void onStart(ConnectedNode connectedNode) {

        final Log log = connectedNode.getLog();
        Subscriber<nav_msgs.Path> subscriber = connectedNode.newSubscriber("chatter", nav_msgs.Path._TYPE);
        subscriber.addMessageListener(new MessageListener<nav_msgs.Path>() {

            @Override
            public void onNewMessage(nav_msgs.Path message) {
                //log.info("I heard: \"" + message.getData() + "\"");
                //Check to who belongs this message
                letter = message.getHeader().getFrameId().toCharArray()[0];
                //log.info("I heard: \"" + letter + "\"");
                log.info("I heard: \"" + letter + "\"");

                //List of points for shape letter
                ArrayList<Double> distList = new ArrayList<Double>();
                for (int x = 0; x < message.getPoses().size(); x = x + 1) {
                    distList.add(message.getPoses().get(x).getPose().getPosition().getY());
                }

                //Added to the Hash
                distances.put(letter, distList);

            }
        });
    }

    public ArrayList<Double> getDistances(Character letter) {

        return distances.get(letter);
    }
}