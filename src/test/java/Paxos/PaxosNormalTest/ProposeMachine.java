package Paxos.PaxosNormalTest;

import Paxos.Agents.AgentHandler;
import Paxos.Paxos;
import java.util.Scanner;

import java.util.Random;

public class ProposeMachine {

    public static void main(String[] Args){
        Random rng = new Random();
        Scanner s = new Scanner(System.in);

        Paxos.init(false);
        AgentHandler a1 = Paxos.addProces(Math.abs(rng.nextLong()));
        AgentHandler a2 = Paxos.addProces(Math.abs(rng.nextLong()));
        AgentHandler a3 = Paxos.addProces(Math.abs(rng.nextLong()));

        s.nextLine();

        Paxos.propose((long)250,"Fragola",a1);
        Paxos.propose((long)5,"Mela",a2);
    }
}
