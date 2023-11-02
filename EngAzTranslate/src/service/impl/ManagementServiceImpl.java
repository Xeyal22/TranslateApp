package service.impl;

import service.GameService;
import service.ManagementService;
import util.MenuUtil;

public class ManagementServiceImpl implements ManagementService {
   private final GameService gameService;

   public ManagementServiceImpl(){
       gameService=new GameServiceImpl();
   }
    @Override
    public void manage() {
        while (true) {
            int option = MenuUtil.showMenu();

            switch (option) {
                case 0:
                    System.exit(-1);

                case 1:
                    gameService.play();
                    break;
                case 2:
                    gameService.add();
                    break;
                case 3:
                    gameService.show();
                    break;
                default:
                    System.out.println("Option is invalid !");

            }
        }
    }
}
