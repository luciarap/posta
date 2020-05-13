package Posta;

public aspect AspectTest {
	
	pointcut callZobrazZasielkyScreen(): call(* ZasielkyScreen.ZobrazZasielkyScreen(..));
	
	//pointcut callChanged(): call();
	
   /* after() : callChanged()  {
        System.out.println("After call");
    }*/
	
	after() throwing (Exception e): callZobrazZasielkyScreen() {
		System.out.println("Threw an exception: " + e);
	}
	
    after() : callZobrazZasielkyScreen()  {
        System.out.println("After call");
    }
	
	

}
