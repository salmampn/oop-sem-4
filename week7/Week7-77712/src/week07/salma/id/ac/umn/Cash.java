package week07.salma.id.ac.umn;

public class Cash extends Payment {

	public Cash(Item item) {
		super(item);
	}

	public int pay() {
		if (isPaidOff) {
			return 0;
		}
		isPaidOff = true;
		return this.item.getPrice();
	}

	public String getClassName() {
		return "Cash";
	}

	public String getStatus() {
		if (isPaidOff) {
			return "FINISHED";
		}

		return "ON PROGRESS";
	}
}
