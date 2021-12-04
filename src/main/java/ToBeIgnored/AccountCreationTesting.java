package ToBeIgnored;

import InterfaceAdapters.AccountManager;
import InterfaceAdapters.ScheduleManager;
import Entities.Event;
import Entities.Person;
import UseCaseClasses.UserList;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class AccountCreationTesting {
    public static void main(String [] args) throws IOException, ExecutionException, InterruptedException {
        // this file can be edited if you wish to add a different user and different courses to the database
        AccountManager manager = new AccountManager();
        ScheduleManager sManager = new ScheduleManager();
        UserList users = new UserList();
        manager.createAccount("Dennis Tat", "123", "123");
        Person Dennis = users.getUser("Dennis Tat");
        Event csc207 = new Event("CSC207", "Tuesday", 16, 17);
        Event mat334 = new Event("MAT334", "Tuesday", 17, 21);
        Event sta257 = new Event("STA257", "Wednesday", 17, 21);
        sManager.addEvent(csc207, Dennis);
        sManager.addEvent(sta257, Dennis);
        sManager.addEvent(mat334, Dennis);
    }
}