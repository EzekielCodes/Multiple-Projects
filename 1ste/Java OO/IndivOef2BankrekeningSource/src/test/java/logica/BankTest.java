package logica;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * IndivOef1a_Bankrekening : BankTest
 *
 * @author kristien.vanassche
 * @version 19/03/2021
 */
class BankTest {
    private Bank bank;

    public BankTest() {
        bank = new Bank("KBC");
    }

    @Test
    public void testConstructor() {
        assertNotNull(bank);
        assertEquals(0, bank.getRekeningen().size());
    }

    @Test
    public void testRekeningen() {
        assertEquals(0, bank.getRekeningen().size());
        bank.voegBankrekeningToe(new Bankrekening("TEST1", "IBAN BE63 6511 5525 8408"));
        assertEquals(1, bank.getRekeningen().size());
        assertThrows(IllegalArgumentException.class, () -> bank.voegBankrekeningToe(new Bankrekening("TEST2", "IBAN BE63 6511 5525 8408")));
        assertEquals(1, bank.getRekeningen().size());
    }

    @Test
    public void testRekeningToevoegen() {
        Bankrekening rek1 = new Bankrekening("TEST1", "IBAN BE63 6511 5525 8408", 123);
        Bankrekening rek2 = new Bankrekening("TEST1", "BE75 9796 2085 3151", 456);
        bank.voegBankrekeningToe(rek1);
        bank.voegBankrekeningToe(rek2);
        assertEquals(2, bank.getRekeningen().size());
    }

    @Test
    public void testVraagSaldo() {
        Bankrekening rek1 = new Bankrekening("TEST1", "IBAN BE63 6511 5525 8408", 123);
        Bankrekening rek2 = new Bankrekening("TEST1", "BE75 9796 2085 3151", 456);
        bank.voegBankrekeningToe(rek1);
        bank.voegBankrekeningToe(rek2);
        assertEquals(2, bank.getRekeningen().size());
        assertEquals(579, bank.geefTotaalSaldoVanHouder("TEST1"));
    }
}