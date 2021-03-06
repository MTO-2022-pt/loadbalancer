package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

public class Server {

    public static final double MAXIMUM_LOAD = 100.0d;
    public double currentLoadPecentage;
    private int capacity;
    private List<Vm> vms = new ArrayList<>();

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public boolean contains(Vm vm) {
        return vms.contains(vm);
    }

    public void addVm(Vm vm) {
        this.vms.add(vm);
        this.currentLoadPecentage += loadOfVm(vm);
    }

    public int vmsCount() {
        return vms.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean canFit(Vm vm) {
        return currentLoadPecentage + loadOfVm(vm) <= MAXIMUM_LOAD;
    }

    private double loadOfVm(Vm vm) {
        return (double) vm.size / (double) this.capacity * MAXIMUM_LOAD;
    }
}
