package avengers;

public class Neuron {
    public String name; // name of neuron
    public String synapse; // neuron?dendrite? that neuron is connected to

    public Neuron(String n, String s){
        name = n;
        synapse = s;
    }

    public String getName(){
        return name;
    }

    public String getNeighbor(){
        return synapse;
    }

    public void setNeighbor(String s){
        synapse = s;
    }
    }
