package Posta;
/**
 * Táto trieda sa používa na ošetrovanie výnimiek pri volaní funkcií
 * @author lucia
 *
 */
public aspect AspectTest {
	
	pointcut callZobrazZasielkyScreen(): call(* ZasielkyScreen.ZobrazZasielkyScreen(..));
	
	pointcut callzobrazPracovnikScreen(): call(* PracovnikScreen.zobrazPracovnikScreen(..));
	
	pointcut callzobrazVeduciScreen(): call(* VeduciScreen.zobrazVeduciScreen(..));
	
	pointcut callZobrazZamestnanciScreen(): call(* ZamestnanciScreen.ZobrazZamestnanciScreen(..));
	
	pointcut callvalidateUser(): call(* LoginController.validateUser(..));
	
	after() throwing (Exception e): callZobrazZasielkyScreen() {
		System.out.println("Threw an exception: " + e);
	}
	
	after() throwing (Exception e): callvalidateUser() {
		System.out.println("Threw an exception: " + e);
	}
	
	after() throwing (Exception e): callzobrazPracovnikScreen() {
		System.out.println("Threw an exception: " + e);
	}
	after() throwing (Exception e): callzobrazVeduciScreen() {
		System.out.println("Threw an exception: " + e);
	}
	after() throwing (Exception e): callZobrazZamestnanciScreen() {
		System.out.println("Threw an exception: " + e);
	}
	
}
