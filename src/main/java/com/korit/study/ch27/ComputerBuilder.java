package com.korit.study.ch27;

public class ComputerBuilder {
    private String cpu;
    private int ram;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public ComputerBuilder cpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    public ComputerBuilder ram(int ram) {
        this.ram = ram;
        return this;
    }

    public Computer build() {
        return new Computer(cpu, ram);
    }

}
