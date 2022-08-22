package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;

class FinancingTest {

	@Test
	public void contructorShouldCreateObjectWhenValuesOfObjectAreValidForCondition() {
		Financing f = createValidFinancingObject();

		Assertions.assertTrue(conditionToReturnTrue(f));
	}

	@Test
	public void contructorShouldThrowsIllegalArgumentExceptionWhenValuesOfObjectAreInvalidForCondition() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Financing(100000.0, 2000.0, 20));
	}

	@Test
	public void setTotalAmountShouldSetAmountWhenAmountValueAreValidForCondition() {
		Financing f = createValidFinancingObject();

		f.setTotalAmount(100000.0);

		Assertions.assertTrue(conditionToReturnTrue(f));
	}

	@Test
	public void setTotalAmountShouldThrowsIllegalArgumentExceptionWhenAmountValueAreInvalidForCondition() {
		Financing f = createValidFinancingObject();

		Assertions.assertThrows(IllegalArgumentException.class, () -> f.setTotalAmount(500000.0));
	}

	@Test
	public void setIncomeShouldSetIncomeWhenIncomeValueAreValidForCondition() {
		Financing f = createValidFinancingObject();

		f.setIncome(2000.0);

		Assertions.assertTrue(conditionToReturnTrue(f));
	}

	@Test
	public void setIncomeShouldThrowsIllegalArgumentExceptionWhenIncomeValueAreInvalidForCondition() {
		Financing f = createValidFinancingObject();

		Assertions.assertThrows(IllegalArgumentException.class, () -> f.setIncome(1000.0));
	}

	@Test
	public void setMonthsShouldSetMonthsWhenMonthsValueAreValidForCondition() {
		Financing f = createValidFinancingObject();

		f.setMonths(80);

		Assertions.assertTrue(conditionToReturnTrue(f));
	}

	@Test
	public void setMonthsShouldThrowsIllegalArgumentExceptionWhenMonthsValueAreInvalidForCondition() {
		Financing f = createValidFinancingObject();

		Assertions.assertThrows(IllegalArgumentException.class, () -> f.setMonths(20));
	}

	@Test
	public void entryReturnValueShouldEqualsCalculationValue() {
		Financing f = createValidFinancingObject();

		Assertions.assertEquals(f.entry(), f.getTotalAmount() * 0.2);
	}

	@Test
	public void quotaReturnValueShouldEqualsCalculationValue() {
		Financing f = createValidFinancingObject();

		Assertions.assertEquals(f.quota(), (f.getTotalAmount() - f.entry()) / f.getMonths());
	}

	private Financing createValidFinancingObject() {
		return new Financing(100000.0, 2000.0, 80);
	}

	private boolean conditionToReturnTrue(Financing f) {
		return !(f.getTotalAmount() * 0.8 / f.getMonths() < f.getIncome() / 2.0);
	}
}
