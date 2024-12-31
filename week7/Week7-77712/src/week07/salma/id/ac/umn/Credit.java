package week07.salma.id.ac.umn;

public class Credit extends Payment {

	int installment;
	int maxInstallment;

	public Credit(Item item, int maxInstallment) {
		super(item);
		this.maxInstallment = maxInstallment;
		installment = 0;
	}

	public int pay() {
		if (maxInstallment == installment) {
			isPaidOff = true;
		}
		return item.getPrice() / maxInstallment;
	}

	public int getRemainingAmount() {

		if (isPaidOff) {
			return 0;
		} else {
			return item.getPrice() - (item.getPrice() / maxInstallment * installment);
		}
	}

	public String getClassName() {
		return "Credit";
	}

	public String getStatus() {
		if (isPaidOff) {
			return "FINISHED";
		}

		return "ON PROGRESS";
	}
}
