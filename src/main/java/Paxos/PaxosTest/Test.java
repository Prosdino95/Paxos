package Paxos.PaxosTest;

import  Paxos.Agents.*;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);

        AgentHandler a1 = new AgentHandler((long)10,"/home/prosdothewolf/Desktop/");
        Thread t = new Thread(a1);
        t.start();
        AgentHandler a2 = new AgentHandler((long)2,"/home/prosdothewolf/Desktop/");
        Thread t2 = new Thread(a2);
        t2.start();
        AgentHandler a3 = new AgentHandler((long)30, "/home/prosdothewolf/Desktop/");
        Thread t3 = new Thread(a3);
        t3.start();

        System.out.println(a1.getid()+" think java sucks");
        System.out.println(a3.getid()+" think java is wonderful");

        s.nextLine();

        a1.propose("java sucks");
        //Thread.sleep(1000);
        a3.propose("java is wonderful");


    }

}
