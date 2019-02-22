package alg.stx.oop;

public class AbsComputerFactory {

	public static Computer getComputer(ComputerAbstractFactory factory) {
		return factory.createComputer();
	}
}
