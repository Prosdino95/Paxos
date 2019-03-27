package Paxos.NetworkTest;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;

import com.eclipsesource.json.JsonObject;

import Paxos.Network.*;

class MainTest {
    
    public static void main(String[] args) {
	// get pid of this process
	final RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
	final long pid = runtime.getPid();

	try{
	    NetworkInterface myProcess = new LocalNetworkProcess(InetAddress.getLocalHost().getHostAddress(), 40000, pid);
	    Thread netThread = new Thread(myProcess);
	    netThread.start();

	    while(true){
		Thread.sleep(500);
		myProcess.updateConnectedProcessesList();

		System.out.printf(myProcess.lookupConnectedProcesses().toString()+"%n");
		
		Message msg = new Message(null, "ciao" , MessageType.PREPAREREQUEST);
		msg.setAsBroadcast();
		myProcess.sendMessage(msg.getJSON());

		if(myProcess.isThereAnyMessage()){
		    String msgs = myProcess.receiveMessage();
		    Message receivedMessage = new Message(msgs);
		    // example of reply
		    msg = new Message(receivedMessage.getSenderID(), "risposta", MessageType.PREPAREREQUEST);
		    myProcess.sendMessage(msg.getJSON());
		}
	    }
	}catch(Exception w){
	    w.printStackTrace();
	}
      }
}

