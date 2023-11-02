import model.Word;
import service.FileService;
import service.ManagementService;
import service.impl.FileServiceImpl;
import service.impl.ManagementServiceImpl;

import java.io.File;

public class Main {
    public static void main(String[]args){
        new ManagementServiceImpl().manage();
    }
}
