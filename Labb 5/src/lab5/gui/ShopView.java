package lab5.gui;

import java.util.Observable;

import lab5.shop.ShopState;
import lab5.simulator.SimView;

public class ShopView extends SimView {

	ShopState state;

	public ShopView(ShopState state) {

		this.state = state;
		System.out.print(this);
		
	}

	public void update(Observable o, Object arg) {

		System.out.println(state.getEvent());
		
	}

	public String toString() {

		String output = "";
		output += "Parameters\n";
		output += "==========\n";
		output += String.format("%-30s : %s","Number of registers, N", state.getRegisterCount() + "\n");
		output += String.format("%-30s : %s","Max allowed, M", state.getMaxCustomerCount() + "\n");
		output += String.format("%-30s : %s","Arrival speed, lamda", state.getLambda() + "\n"); 
		output += String.format("%-30s : %s","Shop interval, [P_min..Pmax]", "[" + state.getPickUpTimeInterval()[0] + ".." + state.getPickUpTimeInterval()[1] + "]" + "\n");
		output += String.format("%-30s : %s","Pay interval, [K_min..Kmax]","[" + state.getPayTimeInterval()[0] + ".." + state.getPayTimeInterval()[1] + "]" + "\n");
		output += String.format("%-30s : %s", "Seed, f" ,state.getSeed() + "\n");
		output += "\nRun\n";
		output += "==========\n";
		output += String.format("%s\t %-10s %-10s %-10s  %-10s %-10s %-10s %-10s %-10s %-10s %s","Time","Event","#C", "?","#Reg","I", "$",":(",
				"Max Q","In Q","[Queue]\n\n");
		return output;

	}
}
