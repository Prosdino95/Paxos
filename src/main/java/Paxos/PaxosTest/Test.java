package Paxos.PaxosTest;

import  Paxos.Agents.*;

import java.util.Scanner;
import java.util.Random;


public class Test {

    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        AgentHandler a1 = new AgentHandler("./src/main/java/Paxos/PaxosTest/");
        Thread t = new Thread(a1);
        t.start();
        AgentHandler a2 = new AgentHandler("./src/main/java/Paxos/PaxosTest/");
        Thread t2 = new Thread(a2);
        t2.start();
        AgentHandler a3 = new AgentHandler("./src/main/java/Paxos/PaxosTest/");
        Thread t3 = new Thread(a3);
        t3.start();


        s.nextLine();

        Thread.sleep(2000);


        while (true){
            Thread.sleep(1000);
            a2.propose(""+r.nextInt());
        }
        //Thread.sleep(1000);
        //a3.propose("java i1s wonderful");
	/*
        System.out.println(a1.getid()+" think java sucks");
        System.out.println(a3.getid()+" think java is wonderful");

        Thread.sleep(100);

        a1.propose("java sucks");*/
	// Thread.sleep(1000);
       // a3.propose("java i1s wonder2ful");

    }

}

