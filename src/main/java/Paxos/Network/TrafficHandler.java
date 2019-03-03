package Paxos.Network;

// handle NetworkManager queues, sending and receiving messages to remote clients
class TrafficHandler implements Runnable{

    public void run(){
	System.out.printf("[TrafficHandler]: Ready to route traffic!\n");
	while(true){
	    for(SocketBox socket : SocketRegistry.getInstance().getAllSockets()){
		try {
		    // take message
		    String message;
		    if(socket.getInputStream().ready()){ // there are data ready to be readden
			message = socket.getInputStream().readLine();

			// apply traffic rule
			for(MessageType msg : MessageType.values()){
			    if(msg.match(message)){
				msg.applyRule(socket, message);
				break;
			    }
			}
		    }
		}catch (Exception e) {
		    System.out.println("Error " + e.getMessage());
		    e.printStackTrace();
		}

	    }
	    
	    try{
		Thread.sleep(10); // avoid burning the CPU
	    }catch(Exception e){

	    }
	}
    }
   
}
