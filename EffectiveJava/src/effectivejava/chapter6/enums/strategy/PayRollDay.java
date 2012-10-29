package effectivejava.chapter6.enums.strategy;

enum PayRollDay {
	MONDAY(PayType.WEEKDAY),
	TUESDAY(PayType.WEEKDAY),
	WEDNESDAY(PayType.WEEKDAY),
	THURSDAY(PayType.WEEKDAY),
	FRIDAY(PayType.WEEKDAY),
	SATURDAY(PayType.WEEKEND),
	SUNDAY(PayType.WEEKEND);
	
	
	
	private final PayType payType;
	PayRollDay(PayType p) {
		this.payType = p;
	}
	
	double pay(double hoursWorked, double payRate){
		return payType.pay(hoursWorked, payRate);
	}
	
	//the strategy enum type
	private enum PayType{
		WEEKDAY{
			double overTimePay(double hours, double payRate){
				return hours <= HOURS_PER_SHIFT ? 0 : (hours - HOURS_PER_SHIFT) * payRate / 2;
			}
		},
		
		WEEKEND{
			double overTimePay(double hours, double payRate){
				return hours * payRate / 2;
			}
		};
		
		private static final int HOURS_PER_SHIFT = 8;
		abstract double overTimePay(double hours, double payRate);
		
		double pay(double hoursWorked, double payRate){
			double basePay = hoursWorked * payRate;
			return basePay + overTimePay(hoursWorked, payRate);
		}
		
		
		
	}

}
